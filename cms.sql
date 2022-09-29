/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : cms

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 29/09/2022 12:28:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章Id',
  `user_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `keywords` varchar(255) DEFAULT NULL COMMENT '关键字',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `content_markdown_source` text COMMENT 'MarkDown数据',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `sort` varchar(255) DEFAULT NULL COMMENT '分类',
  `tags` varchar(255) DEFAULT NULL COMMENT '标签',
  `comment_flag` varchar(255) DEFAULT NULL COMMENT '是否开启评论',
  `top_flag` varchar(255) DEFAULT NULL COMMENT '是否置顶',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标识',
  `author` varchar(255) DEFAULT NULL COMMENT '原文作者',
  `link` varchar(255) DEFAULT NULL COMMENT '原文地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(255) DEFAULT NULL COMMENT '文章状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COMMENT='文章';

-- ----------------------------
-- Records of cms_article
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_category
-- ----------------------------
DROP TABLE IF EXISTS `cms_category`;
CREATE TABLE `cms_category` (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `parent_id` int DEFAULT NULL COMMENT '父ID',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `description` varchar(255) DEFAULT NULL COMMENT '分类描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COMMENT='分类';

-- ----------------------------
-- Records of cms_category
-- ----------------------------
BEGIN;
INSERT INTO `cms_category` (`category_id`, `category_name`, `parent_id`, `sort`, `description`, `create_time`, `update_time`, `status`, `del_flag`) VALUES (1, '12121', 0, NULL, '', '2022-04-22 17:52:58', NULL, '0', NULL);
INSERT INTO `cms_category` (`category_id`, `category_name`, `parent_id`, `sort`, `description`, `create_time`, `update_time`, `status`, `del_flag`) VALUES (2, '我的世界', 0, NULL, '', '2022-05-10 13:23:40', NULL, '0', NULL);
COMMIT;

-- ----------------------------
-- Table structure for cms_category_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_category_article`;
CREATE TABLE `cms_category_article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` int DEFAULT NULL COMMENT '分类ID',
  `article_id` int DEFAULT NULL COMMENT '文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='文章分类关联';

-- ----------------------------
-- Records of cms_category_article
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cid` int DEFAULT NULL COMMENT '父级Id',
  `user_id` int DEFAULT NULL COMMENT '用户ID',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime DEFAULT NULL COMMENT '评论时间',
  `status` varchar(255) DEFAULT NULL COMMENT '评论状态',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='评论';

-- ----------------------------
-- Records of cms_comment
-- ----------------------------
BEGIN;
INSERT INTO `cms_comment` (`comment_id`, `cid`, `user_id`, `content`, `create_time`, `status`) VALUES (1, 0, 1, '435', '2022-05-14 17:18:13', '0');
COMMIT;

-- ----------------------------
-- Table structure for cms_file
-- ----------------------------
DROP TABLE IF EXISTS `cms_file`;
CREATE TABLE `cms_file` (
  `file_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cms_file
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_link
-- ----------------------------
DROP TABLE IF EXISTS `cms_link`;
CREATE TABLE `cms_link` (
  `link_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cms_link
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for cms_tags
-- ----------------------------
DROP TABLE IF EXISTS `cms_tags`;
CREATE TABLE `cms_tags` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='文章标签';

-- ----------------------------
-- Records of cms_tags
-- ----------------------------
BEGIN;
INSERT INTO `cms_tags` (`tag_id`, `tag_name`) VALUES (1, '测试');
INSERT INTO `cms_tags` (`tag_id`, `tag_name`) VALUES (2, 'dawdaw');
INSERT INTO `cms_tags` (`tag_id`, `tag_name`) VALUES (3, 'dwadaw');
INSERT INTO `cms_tags` (`tag_id`, `tag_name`) VALUES (4, 'Java');
INSERT INTO `cms_tags` (`tag_id`, `tag_name`) VALUES (5, '第一篇');
INSERT INTO `cms_tags` (`tag_id`, `tag_name`) VALUES (6, '测试');
INSERT INTO `cms_tags` (`tag_id`, `tag_name`) VALUES (7, '这是一个新的标签');
COMMIT;

-- ----------------------------
-- Table structure for cms_tags_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_tags_article`;
CREATE TABLE `cms_tags_article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tag_id` int DEFAULT NULL COMMENT '标签Id',
  `article_id` int DEFAULT NULL COMMENT '文章Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COMMENT='文章标签关联';

-- ----------------------------
-- Records of cms_tags_article
-- ----------------------------
BEGIN;
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (1, 1, 7);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (2, 2, 7);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (3, 1, 8);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (4, 2, 8);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (5, 3, 8);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (6, 4, 9);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (7, 1, 9);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (8, 1, 10);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (9, 4, 10);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (10, 3, 10);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (11, 2, 10);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (12, 1, 11);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (13, 4, 11);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (14, 2, 12);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (15, 5, 12);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (16, 6, 13);
INSERT INTO `cms_tags_article` (`id`, `tag_id`, `article_id`) VALUES (17, 7, 13);
COMMIT;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `config_id` int NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-04-26 19:44:21', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-04-26 19:44:21', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-04-26 19:44:21', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2022-04-26 19:44:21', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` (`config_id`, `config_name`, `config_key`, `config_value`, `config_type`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-04-26 19:44:21', '', NULL, '是否开启注册用户功能（true开启，false关闭）');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '性别男');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '性别女');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '通知');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '公告');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` (`dict_code`, `dict_sort`, `dict_label`, `dict_value`, `dict_type`, `css_class`, `list_class`, `is_default`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '停用状态');
COMMIT;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) DEFAULT '' COMMENT '字典类型',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` (`dict_id`, `dict_name`, `dict_type`, `status`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-04-26 19:44:21', '', NULL, '登录状态列表');
COMMIT;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb3 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` bigint DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) DEFAULT NULL COMMENT '路由参数',
  `is_frame` int DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `is_cache` int DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2042 DEFAULT CHARSET=utf8mb3 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '系统管理', 0, 5, 'system', 'Layout', NULL, 1, 0, 'M', '0', '0', '', 'Layers', '', NULL, '2', '2022-05-11 09:39:12', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '菜单管理', 1, 1, 'menu', 'system/menu/index', NULL, 1, 0, 'C', '0', '0', 'system:menu:list', 'ApplicationMenu', '', NULL, '2', '2022-05-02 22:35:08', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, '用户管理', 1, 2, 'user', 'system/user/index', NULL, 1, 0, 'C', '0', '0', 'system:user:list', 'Classroom', '', NULL, '2', '2022-05-02 22:35:55', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, '角色管理', 1, 3, 'role', 'system/role/index', NULL, 1, 0, 'C', '0', '0', 'system:role:list', 'EveryUser', '', NULL, '2', '2022-05-02 22:36:03', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (5, '文章管理', 0, 1, 'article', 'Layout', NULL, 1, 0, 'M', '0', '0', NULL, 'ViewList', '', NULL, '2', '2022-05-02 22:34:26', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (6, '写文章', 5, 2, 'write', 'article/write', NULL, 1, 0, 'C', '0', '0', NULL, 'Write', '', NULL, '2', '2022-05-11 17:06:26', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2002, '文章分类', 5, 3, 'sort', 'article/sort', NULL, 1, 0, 'C', '0', '0', 'cms:category:list', 'CategoryManagement', '', NULL, '2', '2022-05-11 17:06:41', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2003, '所有文章', 5, 4, 'all', 'article/index', NULL, 1, 0, 'C', '0', '0', NULL, 'CopyOne', '', NULL, '2', '2022-05-11 17:06:46', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2006, '添加菜单', 2, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:menu:add', '', '2', '2022-04-26 21:12:37', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2007, '修改菜单', 2, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:menu:edit', '', '2', '2022-04-26 21:13:08', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2008, '删除菜单', 2, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:menu:delect', '', '2', '2022-04-26 21:13:26', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2009, '添加用户', 3, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:user:add', '', '2', '2022-04-26 21:22:17', '2', '2022-04-26 21:29:12', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2010, '编辑用户', 3, 2, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:user:edit', '', '2', '2022-04-26 21:22:30', '2', '2022-04-26 21:29:14', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2011, '删除用户', 3, 3, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:user:delect', '', '2', '2022-04-26 21:22:39', '2', '2022-04-26 21:29:17', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2012, '添加角色', 4, 1, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:role:add', '', '2', '2022-04-26 21:22:58', '2', '2022-04-26 21:28:59', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2013, '编辑角色', 4, 2, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:role:edit', '', '2', '2022-04-26 21:23:16', '2', '2022-04-26 21:29:02', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2014, '删除角色', 4, 3, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:role:delect', '', '2', '2022-04-26 21:23:26', '2', '2022-04-26 21:29:05', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2025, '添加文章分类', 2002, 1, '', '', NULL, 1, 0, 'F', '0', '0', 'cms:category:add', '', '2', '2022-05-10 19:51:06', '2', '2022-05-10 20:04:55', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2026, '编辑文章分类 ', 2002, 2, '', '', NULL, 1, 0, 'F', '0', '0', 'cms:category:edit', '', '2', '2022-05-10 19:51:20', '2', '2022-05-10 20:05:09', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2027, '删除文章分类', 2002, 3, '', '', NULL, 1, 0, 'F', '0', '0', 'cms:category:delect', '', '2', '2022-05-10 19:51:34', '2', '2022-05-10 20:05:22', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2029, '评论审核', 2040, 1, 'comments', 'audit/comments', NULL, 1, 0, 'C', '0', '0', '', 'MessageSearch', '2', '2022-05-10 21:53:31', '2', '2022-05-12 21:20:18', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2030, '所有评论', 0, 1, 'stacked', 'comments/index', NULL, 1, 0, 'C', '0', '0', '', 'Comments', '2', '2022-05-10 21:53:42', '2', '2022-05-12 13:55:11', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2032, '媒体', 0, 2, 'media', 'media/index', NULL, 1, 0, 'C', '0', '0', '', 'CarouselVideo', '2', '2022-05-10 22:53:15', '2', '2022-05-10 22:53:58', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2033, '系统设置', 0, 7, 'settings', 'Layout', NULL, 1, 0, 'M', '0', '0', '', 'SettingConfig', '2', '2022-05-11 09:23:30', '2', '2022-05-11 16:52:39', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2034, '邮箱配置', 2033, 1, 'stmp', 'settings/stmp', NULL, 1, 0, 'C', '0', '0', '', 'Mail', '2', '2022-05-11 09:33:07', '2', '2022-05-11 09:35:28', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2035, '网站配置', 2033, 1, 'website', 'settings/website', NULL, 1, 0, 'C', '0', '0', '', 'SettingWeb', '2', '2022-05-11 09:33:20', '2', '2022-05-11 09:36:12', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2036, '链接管理', 0, 3, 'link', 'link/index', NULL, 1, 0, 'C', '0', '0', '', 'Link', '2', '2022-05-11 09:38:37', '2', '2022-05-11 09:38:59', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2037, '文件管理', 0, 6, 'file', 'file/index', NULL, 1, 0, 'C', '0', '0', '', 'FolderClose', '2', '2022-05-11 16:52:22', '2', '2022-05-11 17:02:36', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2038, '存储配置', 2033, 1, 'storage', 'settings/storage', NULL, 1, 0, 'C', '0', '0', '', 'CloudStorage', '2', '2022-05-11 17:00:02', '2', '2022-05-11 17:00:57', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2039, '文章审核', 2040, 1, 'article', 'audit/article', NULL, 1, 0, 'C', '0', '0', '', 'FileDisplay', '2', '2022-05-11 17:04:43', '2', '2022-05-12 21:20:26', '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2040, '审核', 0, 1, 'audit', 'Layout', NULL, 1, 0, 'M', '0', '0', '', 'Audit', '2', '2022-05-12 13:41:33', '', NULL, '');
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2041, '安全配置', 2033, 1, 'security', 'settings/security', NULL, 1, 0, 'C', '0', '0', '', 'Protect', '2', '2022-05-12 21:17:59', '', NULL, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) NOT NULL COMMENT '角色权限字符串',
  `role_sort` int DEFAULT NULL COMMENT '显示顺序',
  `status` char(1) NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb3 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (1, '超级管理员', 'admin', 1, '0', '0', 'admin', '2022-04-21 21:22:19', '2', '2022-05-10 22:01:44', '超级管理员');
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, '普通角色', 'common', 2, '0', '0', 'admin', '2022-04-21 21:22:19', '2', '2022-05-12 21:18:11', '普通角色');
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (100, '正常注册', 'user', NULL, '0', '0', '2', '2022-05-09 13:05:33', '', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 1);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 3);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 4);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 5);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 6);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2002);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2003);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2006);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2007);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2008);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2009);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2010);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2011);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2012);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2013);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2014);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2025);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2026);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2027);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2029);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2030);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2032);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2033);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2034);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2035);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2036);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2037);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2038);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2039);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2040);
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES (2, 2041);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(36) NOT NULL COMMENT '用户ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('1', 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-04-21 21:22:19', 'admin', '2022-04-21 21:22:19', '', NULL, '管理员');
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('100', '435', '3453', '00', '', '', '0', '', '', '0', '2', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('101', '345', '453', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('102', '5344', '4533', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('103', '53', '453', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('104', '345345', '34534', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('105', '45345345', '4535345345', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('106', '4534534', '543453', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('2', 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-04-21 21:22:19', 'admin', '2022-04-21 21:22:19', '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('453', '453', '34545', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('454', '453', '453', '00', '', '', '0', '', '', '0', '2', '', NULL, '', NULL, '', NULL, NULL);
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('455', 'dwadawdawda', '无法无天', '00', '3185dawda', '', '0', '', '', '0', '0', '', NULL, '2', '2022-05-03 11:43:42', '2', '2022-05-03 11:43:55', '');
INSERT INTO `sys_user` (`user_id`, `user_name`, `nick_name`, `user_type`, `email`, `phonenumber`, `sex`, `avatar`, `password`, `status`, `del_flag`, `login_ip`, `login_date`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES ('udiwauiduaiduawiudqiwu', '21', '3', '00', '', '', '0', '', '', '0', '0', '', NULL, '', NULL, '', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `role_id` bigint NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (455, 1);
INSERT INTO `sys_user_role` (`user_id`, `role_id`) VALUES (455, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
