package com.app.service;

import com.app.entity.UserEntity;
import com.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;

    public Page<UserEntity> getAllUser(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(pageRequest);
    }
    public Page<UserEntity> getAllUserByNativeQuery(int page, int size){
        int offset = page * size;
        String sql = "SELECT * FROM user_entity ORDER BY id LIMIT ? OFFSET ?";
        MapSqlParameterSource  source= new MapSqlParameterSource();
        source.addValue("page",page).addValue("size",offset);
        return new PageImpl<>(jdbcTemplate.query(sql,new Object[]{size,offset},new BeanPropertyRowMapper<>(UserEntity.class))) ;
    }
}
