package com.example.jobData.mappers;

import com.example.jobData.Utils.DateFormatUtil;
import com.example.jobData.enums.Gender;
import com.example.jobData.models.Job;
import com.example.jobData.models.dtos.JobDto;
import com.example.jobData.models.entities.JobEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(imports = {DateFormatUtil.class, Gender.class})
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);
    @Mapping(target ="timestamp", expression = "java(DateFormatUtil.changeToLocalDateFormat(job.getTimestamp()))")
    @Mapping(target = "gender", expression = "java(Gender.getByValue(job.getGender()))")
    JobEntity toJobEntity(Job job);

    @Mapping(target = "gender", source = "gender", qualifiedByName = "genderToString")
    JobDto toJobDto(JobEntity jobEntity);

    @Named("genderToString")
    default String mapGenderToString(Gender gender) {
        if (gender != null) {
            return gender.getValue();
        } else {
            return null;
        }
    }

}
