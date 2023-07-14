package com.apache.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apache.consumer.model.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long>{

}
