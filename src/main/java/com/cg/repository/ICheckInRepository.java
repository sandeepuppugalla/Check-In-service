package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.CheckIn;

public interface ICheckInRepository extends JpaRepository<CheckIn, Long> {

}
