package com.wangpy.common.core.controller;

import com.github.pagehelper.PageInfo;
import com.wangpy.common.utils.PageUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangpy
 * @Description: 父级访问控制器
 * @Date: Created in 2022/9/21 16:31
 */
public class BaseController {
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder)
//    {
//        // Date 类型转换
//        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
//        {
//            @Override
//            public void setAsText(String text)
//            {
//                setValue(DateUtils.parseDate(text));
//            }
//        });
//    }

    /**
     * 设置请求分页数据
     */
    protected void startPage() {
        PageUtils.startPage();
    }

    /**
     * 清理分页的线程变量
     */
    protected void clearPage()
    {
        PageUtils.clearPage();
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected Object getDataTable(List<?> list) {
        PageInfo pageInfo = new PageInfo(list);
        if (pageInfo.getPages() == 1 && pageInfo.getPageSize() == pageInfo.getTotal())
            return list;
        else {
            Map<String, Object> map = new HashMap<>();
            map.put("total", pageInfo.getTotal());
            map.put("pageSize", pageInfo.getPageSize());
            map.put("pageNum", pageInfo.getPageNum());
            map.put("pages", pageInfo.getPages());
            map.put("records", pageInfo.getList());
            return map;
        }

    }
}
