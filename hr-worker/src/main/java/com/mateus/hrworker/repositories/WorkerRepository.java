package com.mateus.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
