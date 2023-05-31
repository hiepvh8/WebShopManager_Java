package com.startup.ShopManager.repository;

import com.startup.ShopManager.entity.Voicher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoicherRepository extends JpaRepository<Voicher,Long> {
}
