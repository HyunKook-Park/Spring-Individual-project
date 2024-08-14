package com.sparta.spring_individual.service;

import com.sparta.spring_individual.entity.Schedule;
import com.sparta.spring_individual.repository.ScheduleRepository;
import com.sparta.spring_individual.request.ScheduleRequestSaveDto;
import com.sparta.spring_individual.response.ScheduleResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(JdbcTemplate jdbcTemplate) {
        this.scheduleRepository = new ScheduleRepository(jdbcTemplate);
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestSaveDto scheduleRequestSaveDto){
        // RequestDto -> Entity
        Schedule schedule = new Schedule(scheduleRequestSaveDto);

        // DB 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(savedSchedule);
        return  scheduleResponseDto;
    }
    public List<ScheduleResponseDto> getSchedule(){
        // DB 조회
        return scheduleRepository.findAll();
    }

}