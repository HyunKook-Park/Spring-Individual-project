package com.sparta.spring_individual.repository;

import com.sparta.spring_individual.entity.Schedule;
import com.sparta.spring_individual.request.ScheduleRequestDto;
import com.sparta.spring_individual.response.ScheduleResponseDto;
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

    // DB 저장(repository) 불러오기
    public Schedule save(Schedule schedule) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO schedule (todo, manager_name, secret_number, creation_date, modification_date) VALUES (?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
        jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(sql,
                            PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1, schedule.getToDo());
                    ps.setString(2, schedule.getManagerName());
                    ps.setString(3, schedule.getSecretNumber());
                    return ps;
                },
                keyHolder);

        return findById(keyHolder.getKey().longValue());
    }

    // DB 조회
    public List<ScheduleResponseDto> findAll() {

        String sql = "SELECT * FROM schedule";
        return jdbcTemplate.query(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                Long id = rs.getLong("schedule_id");
                String todo = rs.getString("todo");
                String managerName = rs.getString("manager_name");
                String creationDate = rs.getString("creation_date");
                return new ScheduleResponseDto(id, todo, managerName, creationDate);
            }
        });
    }

    // DB 단건 조회
    public Schedule findById(long scheduleId) {
        String sql = "SELECT * FROM schedule WHERE schedule_id=?";

        return jdbcTemplate.query(sql, resultSet -> {
            if (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getLong("schedule_id"));
                schedule.setToDo(resultSet.getString("todo"));
                schedule.setManagerName(resultSet.getString("manager_name"));
                schedule.setCreationDate(resultSet.getString("creation_date"));
                schedule.setModificationDate(resultSet.getString("modification_date"));

                return schedule;
            } else {
                return null;
            }
        }, scheduleId);
    }
    public void update(Long scheduleId, ScheduleRequestDto scheduleRequestDto){
        String sql = "UPDATE schedule SET  todo = ?, manager_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, scheduleRequestDto.getTodo(), scheduleRequestDto.getManagerName(),scheduleId);
    }

    public void delete(Long scheduleId) {
        String sql = "DELETE FROM schedule WHERE schedule_id=?";
        jdbcTemplate.update(sql,scheduleId);
    }
}
