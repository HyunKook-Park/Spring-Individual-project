package com.sparta.spring_individual.entity;

import com.sparta.spring_individual.request.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Schedule {


    private long id;
    private String toDo;
    private String managerName;
    private String secretNumber;
    private String creationDate;
    private String modificationDate;

    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.toDo=scheduleRequestDto.getTodo();
        this.managerName=scheduleRequestDto.getManagerName();
        this.secretNumber=scheduleRequestDto.getSecretNumber();
    }




}
