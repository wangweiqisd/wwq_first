package com.zy.tow.Mapper.second;

import com.zy.tow.bean.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SchoolMapper {
    List<School> getSchool();
}
