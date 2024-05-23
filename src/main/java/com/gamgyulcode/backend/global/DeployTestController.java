package com.gamgyulcode.backend.global;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class DeployTestController {

    private final JdbcTemplate jdbcTemplate;


    @GetMapping("/test")
    public ResponseEntity<?> pingTest() {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/db")
    public ResponseEntity<?> dbTest() {
        try {
            // 간단한 쿼리를 실행하여 데이터베이스 접속을 테스트합니다.
            jdbcTemplate.execute("SELECT 1");
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            // 접속에 실패하면 false를 반환합니다.
            return ResponseEntity.status(500).body(false);
        }
    }
}