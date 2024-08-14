package com.sparta.spring_individual.response;

import com.sparta.spring_individual.entity.Schedule;
import lombok.Getter;

@Getter
public class scheduleResponseDto {
    private long id;
    private String toDo;
    private String managerName;
    private String secretNumber;
    private String creationDate;
    private String modificationDate;


    public scheduleResponseDto(Schedule savedSchedule) {
        this.id = savedSchedule.getId();
        this.toDo = savedSchedule.getToDo();
        this.managerName = savedSchedule.getManagerName();
        this.creationDate = savedSchedule.getCreationDate();
        this.modificationDate = savedSchedule.getModificationDate();
    }

    public scheduleResponseDto(Long id, String todo, String managerName, String creationDate) {

    }
}
