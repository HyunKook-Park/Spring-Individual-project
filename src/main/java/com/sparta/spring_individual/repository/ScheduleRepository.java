package com.sparta.spring_individual.repository;

import com.sparta.spring_individual.entity.Schedule;
import com.sparta.spring_individual.response.scheduleResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Schedule save(Schedule schedule) {
        // DB 저장(repository) 불러오기
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO schedule (todo, manager_name, secret_number, creation_date, modification_date) VALUES (?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
        jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(sql,
                            PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1,schedule.getToDo());
                    ps.setString(2,schedule.getManagerName());
                    ps.setString(3,schedule.getSecretNumber());
                    return ps;
                },
                keyHolder);
        schedule.setId(keyHolder.getKey().intValue());
        return schedule;
    }

    public List<scheduleResponseDto> findAll() {
        // DB 조회
        String sql = "SELECT * FROM schedule";
        return jdbcTemplate.query(sql, new RowMapper<scheduleResponseDto>() {
            @Override
            public scheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long id = rs.getLong("id");
                String todo = rs.getString("todo");
                String managerName = rs.getString("managerName");
                String creationDate = rs.getString("creationDate");
                return new scheduleResponseDto(id,todo,managerName,creationDate);
            }
        });
    }
}
