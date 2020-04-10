package com.zy.tow.Controller;

import com.zy.tow.Service.SchoolService;
import com.zy.tow.Service.UserService;
import com.zy.tow.Until.ApiResult;
import com.zy.tow.bean.School;
import com.zy.tow.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "/test", description = "我的用户",tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private SchoolService schoolService;

    @RequestMapping(value = "getUsers",method = RequestMethod.GET)
    @ApiOperation(value = "测试接口限流", notes = "每秒钟限流5 token", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "Object"),
            @ApiImplicitParam(name = "msg", value = "消息", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "状态码", dataType = "Integer")
    })
    public ApiResult getUsers() {
        HashMap<String,Object> returnMap= new HashMap<String,Object>();
        List<User> users=userService.getAll();
        List<School> schools = schoolService.getSchool();
        returnMap.put("users",users);
        returnMap.put("schools",schools);
        return ApiResult.success(returnMap);
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    @ApiOperation(value = "测试接口限流", notes = "每秒钟限流5 token", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "Object"),
            @ApiImplicitParam(name = "msg", value = "消息", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "状态码", dataType = "Integer")
    })
    public User getUser(Long id) {
        User user=userService.getOne(id);
        return user;
    }

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    @ApiOperation(value = "测试接口限流", notes = "每秒钟限流5 token", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "Object"),
            @ApiImplicitParam(name = "msg", value = "消息", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "状态码", dataType = "Integer")
    })
    public void save(User user) {
        userService.insert(user);
    }


    @RequestMapping(value="delete/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "测试接口限流", notes = "每秒钟限流5 token", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "Object"),
            @ApiImplicitParam(name = "msg", value = "消息", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "状态码", dataType = "Integer")
    })
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ApiOperation(value = "测试接口限流", notes = "每秒钟限流5 token", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "返回的数据对象", dataType = "Object"),
            @ApiImplicitParam(name = "msg", value = "消息", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "状态码", dataType = "Integer")
    })
    public String hello(Map<String,Object> map){
        return "饶你吗";
    }
}

