package com.sparta.spring_individual.Controller;


import com.sparta.spring_individual.request.ScheduleRequestDto;
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

    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping("/schedules/{Id}")
    public ScheduleResponseDto getSchedule(@PathVariable long Id) {
        return scheduleService.getSchedule(Id);
    }

    @PutMapping("/schedules/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.updateSchedule(id,scheduleRequestDto);
    }

    @DeleteMapping("/schedules/{id}")
    public Long deleteSchedule(@PathVariable long id) {
        return scheduleService.deleteSchedule(id);
    }
}
