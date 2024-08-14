package com.sparta.spring_individual.entity;

import com.sparta.spring_individual.Controller.ScheduleController;
import com.sparta.spring_individual.request.ScheduleRequestSaveDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {


    private long id;
    private String toDo;
    private String managerName;
    private String secretNumber;
    private String creationDate;
    private String modificationDate;

    public Schedule(ScheduleRequestSaveDto scheduleRequestDto) {
        this.toDo=scheduleRequestDto.getTodo();
        this.managerName=scheduleRequestDto.getManagerName();
        this.secretNumber=scheduleRequestDto.getSecretNumber();
        this.creationDate=scheduleRequestDto.getCreationDate();
        this.modificationDate=scheduleRequestDto.getModificationDate();
    }


}
