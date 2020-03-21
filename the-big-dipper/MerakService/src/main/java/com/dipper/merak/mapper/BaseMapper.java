package com.dipper.merak.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

@NoRepositoryBean
public interface BaseMapper<T,ID> extends JpaRepository<T,ID>, QueryByExampleExecutor<T> {


}
