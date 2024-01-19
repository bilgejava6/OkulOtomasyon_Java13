package com.muhammet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface GenericRepository<T,ID> extends JpaRepository<T,ID> {
    List<T> findAllByAd(String ad);
}
