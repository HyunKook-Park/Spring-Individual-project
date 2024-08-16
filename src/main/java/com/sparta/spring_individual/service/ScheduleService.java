package com.sparta.spring_individual.service;

import com.sparta.spring_individual.entity.Schedule;
import com.sparta.spring_individual.repository.ScheduleRepository;
import com.sparta.spring_individual.request.ScheduleRequestDto;
import com.sparta.spring_individual.response.ScheduleResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final JdbcTemplate jdbcTemplate;

    public ScheduleService(JdbcTemplate jdbcTemplate) {
        this.scheduleRepository = new ScheduleRepository(jdbcTemplate);
        this.jdbcTemplate = jdbcTemplate;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(scheduleRequestDto);

        // DB 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(savedSchedule);
        return scheduleResponseDto;
    }

    public ScheduleResponseDto getSchedule(long scheduleId) {
        // DB 조회
        Schedule schedule = scheduleRepository.findById(scheduleId);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    // update
    public Long updateSchedule(Long scheduleId, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if(schedule == null) {
            scheduleRepository.update(scheduleId, scheduleRequestDto);
            return scheduleId;
        }else{
            throw new IllegalArgumentException("Schedule is not exists");
        }
    }

    // delete
    public Long deleteSchedule(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId);
        if(schedule != null) {
            scheduleRepository.delete(scheduleId);
            return scheduleId;
        }else {
            throw new IllegalArgumentException("Schedule is not exists");
        }

    }

}