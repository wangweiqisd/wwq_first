package com.zy.tow.ServiceImpl;

import com.zy.tow.Mapper.second.SchoolMapper;
import com.zy.tow.Service.SchoolService;
import com.zy.tow.bean.School;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {
    @Resource
    private SchoolMapper schoolMapper;

    @Override
    public List<School> getSchool() {
        return schoolMapper.getSchool();
    }
}
