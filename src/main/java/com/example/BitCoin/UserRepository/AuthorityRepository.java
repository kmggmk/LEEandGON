package com.example.BitCoin.UserRepository;

import com.example.BitCoin.Entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
    // 필요한 쿼리 메서드 추가 가능
}
