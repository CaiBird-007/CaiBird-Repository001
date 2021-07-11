package com.caibird.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caibird.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.caibird.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-06-08
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

}
