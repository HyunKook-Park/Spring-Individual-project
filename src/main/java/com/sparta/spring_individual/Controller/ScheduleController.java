package com.sparta.spring_individual.Controller;


import com.sparta.spring_individual.entity.Schedule;
import com.sparta.spring_individual.request.ScheduleRequestSaveDto;
import com.sparta.spring_individual.response.ScheduleResponseDto;
import com.sparta.spring_individual.service.ScheduleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

// 스케쥴 생성 API 받아줄 클래스
@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(JdbcTemplate jdbcTemplate) {
        this.scheduleService = new ScheduleService(jdbcTemplate);
    }

    @PostMapping("/schedule")
    public ScheduleResponseDto CreateSchedule(@RequestBody ScheduleRequestSaveDto scheduleRequestDto) {
        return scheduleService.createSchedule(scheduleRequestDto);
    }
}
