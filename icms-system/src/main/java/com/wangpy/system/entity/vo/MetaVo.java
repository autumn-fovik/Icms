package com.wangpy.system.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wangpy
 * @Description: TODO
 * @Date: Created in 2022/8/27 22:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaVo {
    private Long id;
    /**
     * 设置该路由在侧边栏和面包屑中展示的名字
     */
    private String title;

    /**
     * 设置该路由的图标，对应路径src/assets/icons/svg
     */
    private String icon;

    /**
     * 设置为true，则不会被 <keep-alive>缓存
     */
    private boolean noCache;
}
