package com.joaop.opinions.Repository;

import com.joaop.opinions.Models.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion,Long> {
}
