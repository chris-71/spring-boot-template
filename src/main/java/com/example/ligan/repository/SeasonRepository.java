package com.example.ligan.repository;

import com.example.ligan.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    // You can add custom query methods here if needed
}