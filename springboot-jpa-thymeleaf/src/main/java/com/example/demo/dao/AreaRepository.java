package com.example.demo.dao;

import com.example.demo.entity.TbAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AreaRepository extends JpaRepository<TbAreaEntity,Integer> {

    @Transactional
    @Modifying
    @Query("delete from TbAreaEntity where areaId = ?1")
    void deleteBy_Id(@Param("areaId") Integer id);

    @Transactional
    @Query("select o from TbAreaEntity  o where o.areaId=:areaId")
    TbAreaEntity findBy_id(@Param("areaId") Integer id);
}