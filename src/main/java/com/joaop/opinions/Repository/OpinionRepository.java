package com.joaop.opinions.Repository;

import com.joaop.opinions.Models.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion,Long> {

    @Query("SELECT o FROM Opinion o ORDER BY o.id DESC")
    List<Opinion> findMaximumOpinions(Pageable pageable);
}
