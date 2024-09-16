package com.example.jobData.repositories.impl;

import com.example.jobData.enums.OrderOperator;
import com.example.jobData.enums.SearchOperator;
import com.example.jobData.exceptions.ServiceException;
import com.example.jobData.models.entities.JobEntity;
import com.example.jobData.repositories.JobRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class JobRepositoryCustomImpl implements JobRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<JobEntity> getJobs(Map<String, String> request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<JobEntity> query = cb.createQuery(JobEntity.class);
        Root<JobEntity> job = query.from(JobEntity.class);

        List<Selection<?>> selections = buildSelections(request, job);

        if (!selections.isEmpty()) {
            query.multiselect(selections);
        } else {
            query.select(job);
        }

        List<Predicate> predicates = createPredicates(request, cb, job);
        List<Order> orders = buildSorting(request, cb, job);
        return entityManager.createQuery(query.where(predicates.toArray(new Predicate[0])).orderBy(orders)).getResultList();
    }

    private List<Selection<?>> buildSelections(Map<String, String> request, Root<JobEntity> job) {
        List<Selection<?>> selections = new ArrayList<>();
        if (request.containsKey("fields")) {
            selections.add(job.get("id").alias("id"));
            List<String> fields = List.of(request.get("fields").split(","));
            fields.forEach(field -> selections.add(job.get(field).alias(field)));
        }
        return selections;
    }

    private List<Predicate> createPredicates(Map<String, String> request, CriteriaBuilder cb, Root<JobEntity> job) {
        List<Predicate> predicates = new ArrayList<>();
        for (Map.Entry<String, String> entry : request.entrySet()) {

            if (entry.getKey().equals("fields") || entry.getKey().equals("sort") || entry.getKey().equals("sortType")) {
                continue;
            }

            String operator = entry.getKey().substring(entry.getKey().indexOf('[') + 1, entry.getKey().indexOf(']'));
            String key = entry.getKey().substring(0, entry.getKey().indexOf('['));
            String value = entry.getValue();

            switch (SearchOperator.getByValue(operator)) {
                case EQUAL -> predicates.add(cb.equal(job.get(key), value));
                case LESS_THAN -> predicates.add(cb.lessThan(job.get(key), value));
                case LESS_THAN_EQUAL -> predicates.add(cb.lessThanOrEqualTo(job.get(key), value));
                case GREATER_THAN -> predicates.add(cb.greaterThan(job.get(key), value));
                case GREATER_THAN_EQUAL -> predicates.add(cb.greaterThanOrEqualTo(job.get(key), value));
                case CONTAINS -> predicates.add(cb.like(job.get(key), "%" + value + "%"));
            }
        }
        return predicates;
    }

    private List<Order> buildSorting(Map<String, String> request, CriteriaBuilder cb, Root<JobEntity> root) {
        List<Order> orders = new ArrayList<>();

        if (request.containsKey("sort")) {
            String[] sortFields = request.get("sort").split(",");
            String[] sortTypes = request.containsKey("sortType") ? request.get("sortType").split(",") : new String[0];

            if (sortTypes.length > 0 && sortFields.length != sortTypes.length) {
                throw new ServiceException(HttpStatus.BAD_REQUEST, "Mismatch between sort fields and sort types.");
            }

            for (int i = 0; i < sortFields.length; i++) {
                String sortField = sortFields[i].trim();
                String sortType = i < sortTypes.length ? sortTypes[i].trim() : OrderOperator.ASC.getValue();

                if (OrderOperator.DESC.getValue().equalsIgnoreCase(sortType)) {
                    orders.add(cb.desc(root.get(sortField)));
                } else {
                    orders.add(cb.asc(root.get(sortField)));
                }
            }
        }
        return orders;
    }
}
