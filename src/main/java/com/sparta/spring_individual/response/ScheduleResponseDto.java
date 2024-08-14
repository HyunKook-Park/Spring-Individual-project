package com.sparta.spring_individual.response;

import com.sparta.spring_individual.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private long id;
    private String toDo;
    private String managerName;
    private String secretNumber;
    private String creationDate;
    private String modificationDate;


    public ScheduleResponseDto(Schedule schedule) {
    }

    public ScheduleResponseDto(Long id, String todo, String managerName, String creationDate) {
    }
}
