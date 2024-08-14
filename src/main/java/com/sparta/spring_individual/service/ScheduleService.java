package com.sparta.spring_individual.service;

import com.sparta.spring_individual.entity.Schedule;
import com.sparta.spring_individual.repository.ScheduleRepository;
import com.sparta.spring_individual.request.ScheduleRequestSaveDto;
import com.sparta.spring_individual.response.scheduleResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(JdbcTemplate jdbcTemplate) {
        this.scheduleRepository = new ScheduleRepository(jdbcTemplate);
    }

    public scheduleResponseDto createSchedule(ScheduleRequestSaveDto scheduleRequestSaveDto){
        // RequestDto -> Entity
        Schedule schedule = new Schedule(scheduleRequestSaveDto);

        // DB 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        scheduleResponseDto scheduleResponseDto = new scheduleResponseDto(savedSchedule);
        return  scheduleResponseDto;
    }
    public List<scheduleResponseDto> getSchedule(){
        // DB 조회
        return scheduleRepository.findAll();
    }

}