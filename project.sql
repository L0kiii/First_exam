/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50553
 Source Host           : localhost:3306
 Source Schema         : project

 Target Server Type    : MySQL
 Target Server Version : 50553
 File Encoding         : 65001

 Date: 10/04/2020 15:17:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for applications
-- ----------------------------
DROP TABLE IF EXISTS `applications`;
CREATE TABLE `applications`
(
    `id`                                       bigint(32) UNSIGNED                                    NOT NULL AUTO_INCREMENT,
    `user_id`                                  bigint(32)                                             NULL DEFAULT NULL COMMENT 'userId',
    `user_id_num`                              varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
    `stu_id`                                   varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学籍号',
    `examinee_id`                              varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考生号（天津应届初三填写）',
    `name`                                     varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
    `gender`                                   varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '性别',
    `birth`                                    varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生年月',
    `nation`                                   varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
    `political_status`                         varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '政治面貌',
    `professional_name`                        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业名称',
    `professional_category`                    varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业分类',
    `grade`                                    varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '所在年级',
    `household_registration`                   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户籍',
    `household_registration_category`          varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户籍类别',
    `household_registration_address`           varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户籍（户口簿上的）',
    `police_station`                           varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '派出所',
    `graduated_school`                         varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业学校',
    `fresh`                                    tinyint(1)                                             NULL DEFAULT NULL COMMENT '是否应届0/1',
    `addressee`                                varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收信人',
    `addressee_addr`                           varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收信人地址',
    `postcode`                                 varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '邮编',
    `father_name`                              varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲姓名',
    `father_id`                                varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲身份证号',
    `father_job`                               varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲工作单位',
    `father_phone`                             varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲手机',
    `mother_name`                              varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '母亲姓名',
    `mother_id`                                varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '母亲身份证号',
    `mother_job`                               varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '母亲工作单位',
    `mother_phone`                             varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '母亲手机',
    `created_at`                               timestamp                                              NULL DEFAULT NULL COMMENT '创建时间',
    `status`                                   tinyint(2)                                             NULL DEFAULT 0 COMMENT '0待缴费1已缴费',
    `stage`                                    tinyint(2)                                             NULL DEFAULT 0 COMMENT '0未审核1初试2复试3文考4录取5审核未通过',
    `first_score`                              int(4)                                                 NULL DEFAULT NULL COMMENT '初试成绩',
    `second_score`                             int(4)                                                 NULL DEFAULT NULL COMMENT '复试成绩',
    `reject_reason`                            text CHARACTER SET utf8 COLLATE utf8_general_ci        NULL COMMENT '驳回理由',
    `avatar_url`                               varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '1寸照',
    `id_front_url`                             varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证正面',
    `id_back_url`                              varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证背面',
    `household_registration_home_page_url`     varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户口簿首页',
    `household_registration_personal_page_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户口簿本人页',
    `recommendation_url`                       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐信',
    `first_exam_time`                          varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初试时间',
    `first_exam_address`                       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初试地点',
    `exam_num`                                 varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '准考证号',
    `second_exam_time`                         varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复试时间',
    `second_exam_address`                      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复试地点',
    `cultural_exam_time`                       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文考时间',
    `cultural_exam_address`                    varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文考地点',
    `cultural_exam_num`                        varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文考准考证号',
    `chinese_score`                            int(3)                                                 NULL DEFAULT NULL COMMENT '文考语文成绩',
    `math_score`                               int(3)                                                 NULL DEFAULT NULL COMMENT '文考数学成绩',
    `english_score`                            int(3)                                                 NULL DEFAULT NULL COMMENT '文考英语成绩',
    `first_financial_code`                     varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '初试缴费财务码',
    `second_financial_code`                    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '复试缴费财务码',
    `cultural_financial_code`                  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文考缴费财务码',
    `cultural_score`                           int(3)                                                 NULL DEFAULT NULL COMMENT '文考总分',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 18
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`         bigint(32)                                              NOT NULL AUTO_INCREMENT,
    `username`   varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `password`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `enabled`    int(1)                                                  NULL     DEFAULT 0,
    `created_at` timestamp                                               NULL     DEFAULT NULL,
    `name`       varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `roles`      varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL     DEFAULT 'user',
    `phone`      varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL DEFAULT '',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM
  AUTO_INCREMENT = 17
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
