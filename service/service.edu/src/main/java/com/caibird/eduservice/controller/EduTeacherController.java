package com.caibird.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caibird.CaiBirdException;
import com.caibird.commonutils.R;
import com.caibird.eduservice.entity.EduTeacher;
import com.caibird.eduservice.entity.vo.TeacherQuery;
import com.caibird.eduservice.service.EduTeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-06-08
 */
@Api(description="讲师管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

//    查询所有讲师的数据
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findall")
    public R findAllTeacher(){
        try {
            int i = 10 / 0;
        }catch (Exception e){
            throw new CaiBirdException(20001,"CaiBird异常发生啦");
        }
        R r=R.ok();
        List<EduTeacher> eduTeachers=eduTeacherService.list(null);

        r.data("item",eduTeachers);
        return r;
    }


    @ApiOperation(value = "根据id逻辑删除")
    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id){
        eduTeacherService.removeById(id);
        R r=R.ok();
        return  r;

    }

//    分页查询
    @GetMapping("pageTeacher/{page}/{limit}")
    public R pageListTeacher(@PathVariable("page") Integer page,
                             @PathVariable("limit") Integer limit){
        Page<EduTeacher> eduTeacherPage=new Page<EduTeacher>(page,limit);
        eduTeacherService.page(eduTeacherPage,null);
        List<EduTeacher> eduTeachers=eduTeacherPage.getRecords();
        return  R.ok().data("rows",eduTeachers).data("total",eduTeacherPage.getTotal());

    }

//    条件分页查询
    @PostMapping("pageTeacherCondition/{page}/{limit}")
    public R pageTeacherCondition(@PathVariable("page")Integer page,
                                  @PathVariable("limit")Integer limit,
                                  @RequestBody TeacherQuery teacherQuery){



            Page<EduTeacher> pageParam = new Page<>(page, limit);
            eduTeacherService.pageQuery(pageParam, teacherQuery);
            List<EduTeacher> records = pageParam.getRecords();
            long total = pageParam.getTotal();
            return  R.ok().data("total", total).data("rows", records);


    }
//添加教师
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean result=eduTeacherService.save(eduTeacher);
        if (result){
            return R.ok();
        }
        else
            return R.error();
    }
//    根据id查询
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@PathVariable("id") String id){
        EduTeacher eduTeacher=eduTeacherService.getById(id);
        return R.ok().data("teacher",eduTeacher);
    }

//    更新教师信息
    @PutMapping("updateTeacher")
    public R updataTeacher(@RequestBody EduTeacher eduTeacher){
        System.out.println(eduTeacher.getId());
        boolean frag=eduTeacherService.updateById(eduTeacher);
        if (frag){
            return R.ok();
        }
        else
            return R.error();
    }



}

