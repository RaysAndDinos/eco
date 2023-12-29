package com.example.ecoandrich.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

    List<DepartmentLocationResponse> findAllByPaging(Integer limit, Integer offset);
}
