--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // init
-- Migration SQL that makes the change goes here.

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Menu`
-- ----------------------------
CREATE TABLE `Menu` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `parentId` int(11) NOT NULL,
  `disOrder` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `Menu`
-- ----------------------------
BEGIN;
INSERT INTO `Menu` VALUES ('1', '工作面板', 'user/index.do', '0', '1', '工作面板'), ('2', '部门管理', 'department/getdepartmentList.do', '0', '3', '部门管理'), ('3', '用户管理', 'user/userList.do', '0', '2', '用户管理'), ('4', '角色管理', 'role/roleList.do', '0', '4', '角色管理'), ('5', '考勤管理', 'record/recordList.do', '0', '5', '考勤管理'), ('6', '日报管理', 'dailly/dailyList.do', '0', '6', '日报管理'), ('7', '消息中心', 'email/emailList.do', '0', '7', '邮件管理'), ('8', '薪资福利', 'money/moneyList.do', '0', '8', '薪资管理'), ('25', '用户列表', 'user/userList.do', '3', '', '修改用户'), ('26', '添加用户', 'user/addUserSend.do', '3', '', '添加用户'), ('28', '添加角色', 'role/addRoleSend.do', '4', '', '增加角色'), ('29', '角色列表', 'role/rolesList.do', '4', '', '修改角色'), ('31', '请假列表', 'record/selectRrcord.do', '5', '', '考勤记录查询'), ('32', '请假申请', 'record/addRecord.do', '5', '', '请假申请'), ('34', '日报查询', 'daily/selectDaily.do', '6', '', '日报查询'), ('35', '日报填写', 'daily/addDaily.do', '6', '', '日报填写'), ('37', '发送消息', 'message/sendMessage.do', '7', '', '发送邮件'), ('38', '收件箱', 'message/ReceiveEmail.do', '7', '', '收件箱'), ('39', '消息列表', 'message/messageList.do', '7', '', '邮件查询'), ('40', '部门列表', 'department/departmentList.do', '2', '2', '部门管理'), ('41', '员工调动管理', 'postRecord/postRecordList.do', '0', '9', '员工调动'), ('42', '职位列表', 'post/alPostList.do', '2', null, null), ('43', '我的请假单', 'record/selectRrcordUserId.do', '5', null, '请假单'), ('44', '添加薪资', 'salary/addSalarySend.do', '111111', '1', '薪资添加'), ('45', '薪资列表', 'salary/getSalaryList.do', '8', '2', '薪资列表'), ('46', '员工调动列表', 'postRecord/postRecordList.do', '41', null, '员工调动列表'), ('47', '离职申请', 'postRecord/leavePost.do', '41', null, '离职申请'), ('48', '离职员工列表', 'postRecord/leavePostList.do', '41', null, '离职员工列表'), ('49', '员工奖惩', 'money/sendMoney.do', '8', null, '员工奖惩'), ('50', '奖惩记录', 'money/getRewardList.do', '8', null, '奖惩记录');
COMMIT;

-- ----------------------------
--  Table structure for `daily`
-- ----------------------------
CREATE TABLE `daily` (
  `userId` int(11) NOT NULL COMMENT '用户id',
  `workDate` datetime NOT NULL COMMENT '工作日期',
  `dailyContext` varchar(255) NOT NULL COMMENT '日报内容',
  `workTime` int(11) NOT NULL COMMENT '工作时长',
  `workSite` varchar(20) NOT NULL,
  `overTime` int(11) DEFAULT NULL COMMENT '加班时长',
  `overWorkContext` varchar(255) DEFAULT NULL COMMENT '加班内容'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `daily`
-- ----------------------------
BEGIN;
INSERT INTO `daily` VALUES ('1', '2016-06-14 00:00:00', '努力工作', '8', '1', '0', ''), ('1', '2016-06-13 00:00:00', '6-13日报填写啊', '8', '2', '0', '');
COMMIT;

-- ----------------------------
--  Table structure for `department`
-- ----------------------------
CREATE TABLE `department` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `department_id` int(10) NOT NULL COMMENT '部门编号',
  `department_Name` varchar(45) NOT NULL COMMENT '部门名称',
  `department_Type` varchar(45) NOT NULL COMMENT '部门类型',
  `description` varchar(200) DEFAULT NULL COMMENT '部门描述',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `department`
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES ('13', '10000', '交付部', '开发', '作为产品的交付', '0'), ('14', '10001', '人事部', '人事', '职工管理', '0'), ('15', '10002', '财务部', '财务', '财务部', '0');
COMMIT;

-- ----------------------------
--  Table structure for `employeeStatus`
-- ----------------------------
CREATE TABLE `employeeStatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `remark` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `employeeStatus`
-- ----------------------------
BEGIN;
INSERT INTO `employeeStatus` VALUES ('1', '试用', '试用'), ('2', '正式员工', null), ('3', '实习', null);
COMMIT;

-- ----------------------------
--  Table structure for `leavePost`
-- ----------------------------
CREATE TABLE `leavePost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `reason` varchar(200) DEFAULT NULL,
  `leaveStatus` int(11) DEFAULT NULL,
  `leavetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `leavePost`
-- ----------------------------
BEGIN;
INSERT INTO `leavePost` VALUES ('1', '4', '要离职啊啊', '0', '2016-06-16 00:00:00');
COMMIT;

-- ----------------------------
--  Table structure for `message`
-- ----------------------------
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动增长列',
  `sendId` int(11) NOT NULL COMMENT '发送者id',
  `context` varchar(255) NOT NULL COMMENT '发送内容',
  `reviceId` int(11) NOT NULL COMMENT '接收者id',
  `sendDate` datetime NOT NULL COMMENT '发送日期',
  `readState` int(255) NOT NULL DEFAULT '1' COMMENT '读的状态，1未读，2已读',
  `deletType` int(255) NOT NULL DEFAULT '1' COMMENT '是否已经删除，1未删除，2删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `message`
-- ----------------------------
BEGIN;
INSERT INTO `message` VALUES ('1', '1', '123123123123', '22', '2016-06-04 15:58:17', '1', '1'), ('2', '1', '123123123123', '16', '2016-06-04 15:58:17', '1', '1'), ('3', '1', '123123123123', '22', '2016-06-04 15:58:20', '1', '1'), ('4', '1', '123123123123', '16', '2016-06-04 15:58:20', '1', '1'), ('5', '1', '123123123123', '22', '2016-06-04 15:58:20', '1', '1'), ('6', '1', '123123123123', '16', '2016-06-04 15:58:20', '1', '1'), ('7', '1', '123123123123', '22', '2016-06-04 15:58:20', '1', '1'), ('8', '1', '123123123123', '16', '2016-06-04 15:58:20', '1', '1'), ('9', '1', '123123123123', '22', '2016-06-04 15:58:20', '1', '1'), ('10', '22', '123123123123', '1', '2016-06-04 15:58:20', '2', '1'), ('11', '22', 'asdasd', '1', '2016-06-04 16:12:22', '2', '1'), ('12', '22', 'asdasd', '1', '2016-06-04 16:17:41', '2', '1'), ('13', '22', 'wwwww', '1', '2016-06-04 16:18:21', '2', '1'), ('14', '1', '', '16', '2016-06-05 10:20:20', '1', '1'), ('15', '1', '发送消息123', '2', '2016-06-14 08:56:49', '2', '1'), ('16', '5', '明天开会', '4', '2016-06-14 21:16:25', '1', '1'), ('17', '5', '明天开会', '3', '2016-06-14 21:16:25', '1', '1'), ('18', '5', '明天开会', '2', '2016-06-14 21:16:25', '1', '1'), ('19', '5', '明天开会', '1', '2016-06-14 21:16:25', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `personInfo`
-- ----------------------------
CREATE TABLE `personInfo` (
  `userId` int(11) NOT NULL COMMENT '用户id',
  `technology` varchar(255) DEFAULT NULL COMMENT '工作经历',
  `specialty` varchar(255) DEFAULT NULL COMMENT '所学专业',
  `school` varchar(255) DEFAULT NULL COMMENT '毕业院校',
  `createTime` datetime DEFAULT NULL COMMENT '建立时间',
  `personInformation` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `favourites` varchar(255) DEFAULT NULL COMMENT '喜好',
  `head` varchar(255) DEFAULT NULL,
  `weibo` varchar(11) DEFAULT NULL,
  `weixin` varchar(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `personInfo`
-- ----------------------------
BEGIN;
INSERT INTO `personInfo` VALUES ('1', 'java', '软件工程', '兰州理工大学', null, '个人简介', '乒乓球', 'static/upload/Img/2016-06-15/1465957833673.jpeg', 'hua_zhenguo', '751724893', '18331385759', null), ('2', null, null, null, null, null, null, null, null, null, null, null), ('3', null, null, null, null, null, null, null, null, null, null, null), ('4', null, null, null, null, null, null, null, null, null, null, null), ('5', null, null, null, null, null, null, null, null, null, null, null), ('16', null, null, null, null, null, null, null, null, null, null, null), ('22', null, null, null, null, null, null, null, null, null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `post`
-- ----------------------------
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL COMMENT '岗位id',
  `post_Name` varchar(255) NOT NULL COMMENT '岗位名称',
  `department_id` int(11) NOT NULL COMMENT '对应的部门id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `post`
-- ----------------------------
BEGIN;
INSERT INTO `post` VALUES ('20000', 'java', '13', 'java开发'), ('20001', '.net', '13', '.net开发'), ('20002', '前端开发', '13', '前端开发'), ('20003', 'UI', '13', 'UI开发'), ('30001', '人事', '14', '人事'), ('40001', '会计', '15', '会计');
COMMIT;

-- ----------------------------
--  Table structure for `postRecord`
-- ----------------------------
CREATE TABLE `postRecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `department` int(11) DEFAULT NULL,
  `post` int(11) DEFAULT NULL,
  `newPost` int(11) DEFAULT NULL,
  `newPostName` varchar(200) DEFAULT NULL,
  `newDepartment` int(11) DEFAULT NULL,
  `changeTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `postRecord`
-- ----------------------------
BEGIN;
INSERT INTO `postRecord` VALUES ('1', '22', '9080', '12123', '1', 'java', '32323', '2016-06-03 19:15:44'), ('2', '2', '10000', '20000', '20001', '.net', '10000', '2016-06-14 08:53:40'), ('3', '5', '10000', '20003', '20002', '前端开发', '10000', '2016-06-15 11:05:20');
COMMIT;

-- ----------------------------
--  Table structure for `postSalary`
-- ----------------------------
CREATE TABLE `postSalary` (
  `postId` int(11) NOT NULL COMMENT '用户id',
  `basic` decimal(10,0) NOT NULL COMMENT '基本工资',
  `totalize` decimal(10,0) DEFAULT NULL COMMENT '总计',
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`postId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `postSalary`
-- ----------------------------
BEGIN;
INSERT INTO `postSalary` VALUES ('12123', '1000', null, '2016-05-27 15:49:29'), ('20000', '5000', null, '2016-06-13 14:52:08'), ('20001', '5000', null, '2016-06-13 14:52:53'), ('20002', '4000', null, '2016-06-13 14:53:25'), ('20003', '4000', null, '2016-06-13 14:54:03'), ('30001', '4000', null, '2016-06-14 21:14:39'), ('40001', '3000', null, '2016-06-14 21:14:56');
COMMIT;

-- ----------------------------
--  Table structure for `prizeAndpublish`
-- ----------------------------
CREATE TABLE `prizeAndpublish` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动增长列',
  `userId` int(11) NOT NULL COMMENT '用户id',
  `pName` varchar(255) NOT NULL COMMENT '奖惩名称',
  `pReason` varchar(255) NOT NULL COMMENT '原因',
  `pDescription` varchar(255) DEFAULT NULL COMMENT '描述',
  `createTime` datetime NOT NULL COMMENT '建立时间',
  `pType` int(11) NOT NULL COMMENT '1表示奖励，2表示惩罚',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `prizeAndpublish`
-- ----------------------------
BEGIN;
INSERT INTO `prizeAndpublish` VALUES ('1', '13', '奖励1', '奖励1', '奖励1', '2016-06-05 11:04:23', '1'), ('2', '22', '奖励2', '奖励2', '奖励2', '2016-06-05 11:07:26', '1'), ('3', '13', '惩罚1', '惩罚1', '惩罚1', '2016-06-05 11:09:19', '0'), ('4', '12', '惩罚2', '惩罚2', '惩罚2', '2016-06-05 11:09:54', '0'), ('5', '13', '惩罚3', '惩罚3', '惩罚3', '2016-06-05 11:10:52', '0'), ('6', '13', '正处在', 'z注册', '的是', '2016-06-05 11:13:04', '1'), ('7', '22', '惩罚333', '惩罚2333', '惩罚133', '2016-06-05 11:17:20', '0'), ('8', '22', '惩罚9999', '惩罚9999', '惩罚9999', '2016-06-05 11:17:42', '0'), ('9', '22', '惩罚9999', '惩罚9999', '惩罚9999', '2016-06-05 11:17:42', '0');
COMMIT;

-- ----------------------------
--  Table structure for `record`
-- ----------------------------
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `openTime` datetime NOT NULL COMMENT '请假开始时间',
  `endTime` datetime NOT NULL COMMENT '请假结束时间',
  `absenceType` varchar(255) NOT NULL COMMENT '请假类型，1事假，2病假，3其它',
  `reason` varchar(255) NOT NULL COMMENT '原因',
  `state` int(11) DEFAULT NULL COMMENT '状态，暂时未用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `record`
-- ----------------------------
BEGIN;
INSERT INTO `record` VALUES ('1', '1', '2016-06-13 00:00:00', '2016-06-14 00:00:00', '1', '有事请假啊啊', '1'), ('2', '1', '2016-06-08 00:00:00', '2016-06-10 00:00:00', '2', '生病就医', '1'), ('3', '2', '2016-06-06 00:00:00', '2016-06-08 00:00:00', '2', '生病了。休息', '1');
COMMIT;

-- ----------------------------
--  Table structure for `resource`
-- ----------------------------
CREATE TABLE `resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sourceName` varchar(45) NOT NULL COMMENT '资源名称',
  `url` varchar(45) NOT NULL COMMENT '资源路径',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL COMMENT '对应的权限',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `resource`
-- ----------------------------
BEGIN;
INSERT INTO `resource` VALUES ('1', '工作面板', 'user/index.do', null, null, '1', '工作面板'), ('2', '部门管理', 'department/getdepartmentList.do', null, null, '1', '部门管理列表'), ('3', '用户管理', 'user/userList.do', null, null, '1', '用户管理列表'), ('4', '用户列表', 'user/userList.do', null, null, '1', '添加用户'), ('5', '添加用户', 'user/addUserSend.do', null, null, '1', '添加用户'), ('6', '角色管理', 'role/roleList.do', null, null, '1', '角色管理'), ('7', '添加角色', 'role/addRoleSend.do', null, null, '1', '增加角色'), ('8', '角色列表', 'role/rolesList.do', null, null, '1', '修改角色'), ('9', '考勤管理', 'record/recordList.do', null, null, '1', '考勤管理'), ('10', '请假列表', 'record/selectRrcord.do', null, null, '1', '考勤记录查询'), ('11', '请假申请', 'record/addRecord.do', null, null, '1', '请假申请'), ('12', '日报管理', 'admin/dailyList.do', null, null, '1', '日报管理'), ('13', '日报查询', 'daily/selectDaily.do', null, null, '1', '日报查询'), ('14', '日报填写', 'daily/addDaily.do', null, null, '1', '日报填写'), ('15', '消息中心', 'message/emailList.do', null, null, '1', '邮件管理'), ('16', '消息列表', 'message/messageList.do', null, null, '1', '邮件查询'), ('17', '发送消息', 'message/sendMessage.do', null, null, '1', '发送邮件'), ('18', '收件箱', 'email/ReceiveEmail.do', null, null, '1', '收件箱'), ('19', '薪资福利', 'money/moneyList.do', null, null, '1', '薪资管理'), ('43', '部门列表', 'department/departmentList.do', null, null, '1', '部门列表'), ('44', '员工调动管理', 'postRecord/postRecordList.do', null, null, '1', '员工调动管理'), ('107', '职位列表', 'post/alPostList.do', null, null, '1', '职位列表'), ('108', '我的请假单', 'record/selectRrcordUserId.do', null, null, '1', '我的请假单'), ('109', '薪资添加', 'salary/addSalarySend.do', null, null, '1111111', '薪资添加'), ('110', '薪资列表', 'salary/getSalaryList.do', null, null, '1', '薪资列表'), ('111', '员工调动列表', 'postRecord/postRecordList.do', null, null, '1', '员工调动列表'), ('112', '离职申请', 'postRecord/leavePost.do', null, null, '1', '离职申请'), ('113', '离职员工列表', 'postRecord/leavePostList.do', null, null, '1', '离职员工列表'), ('114', '员工奖惩', 'money/sendMoney.do', null, null, '1', '员工奖惩'), ('115', 'j奖惩记录', 'money/getRewardList.do', null, null, '1', '奖惩记录'), ('116', '工作面板', 'user/index.do', '2016-06-13 14:50:53', null, '1', '工作面板'), ('117', '职位列表', 'post/alPostList.do', '2016-06-13 14:50:53', null, '1', null), ('118', '用户列表', 'user/userList.do', '2016-06-13 14:50:53', null, '1', '修改用户'), ('119', '角色列表', 'role/rolesList.do', '2016-06-13 14:50:53', null, '1', '修改角色'), ('120', '请假申请', 'record/addRecord.do', '2016-06-13 14:50:53', null, '1', '请假申请'), ('121', '我的请假单', 'record/selectRrcordUserId.do', '2016-06-13 14:50:53', null, '1', '请假单'), ('122', '日报查询', 'daily/selectDaily.do', '2016-06-13 14:50:53', null, '1', '日报查询'), ('123', '日报填写', 'daily/addDaily.do', '2016-06-13 14:50:53', null, '1', '日报填写'), ('124', '发送消息', 'message/sendMessage.do', '2016-06-13 14:50:53', null, '1', '发送邮件'), ('125', '消息列表', 'message/messageList.do', '2016-06-13 14:50:53', null, '1', '邮件查询'), ('126', '薪资列表', 'salary/getSalaryList.do', '2016-06-13 14:50:53', null, '1', '薪资列表'), ('127', '员工调动列表', 'postRecord/postRecordList.do', '2016-06-13 14:50:53', null, '1', '员工调动列表'), ('128', '离职申请', 'postRecord/leavePost.do', '2016-06-13 14:50:53', null, '1', '离职申请'), ('129', '工作面板', 'user/index.do', '2016-06-13 15:14:04', null, '2', '工作面板'), ('130', '部门列表', 'department/departmentList.do', '2016-06-13 15:14:04', null, '2', '部门管理'), ('131', '请假列表', 'record/selectRrcord.do', '2016-06-13 15:14:04', null, '2', '考勤记录查询'), ('132', '请假申请', 'record/addRecord.do', '2016-06-13 15:14:04', null, '2', '请假申请'), ('133', '日报查询', 'daily/selectDaily.do', '2016-06-13 15:14:04', null, '2', '日报查询'), ('134', '日报填写', 'daily/addDaily.do', '2016-06-13 15:14:04', null, '2', '日报填写'), ('135', '发送消息', 'message/sendMessage.do', '2016-06-13 15:14:04', null, '2', '发送邮件'), ('136', '消息列表', 'message/messageList.do', '2016-06-13 15:14:04', null, '2', '邮件查询'), ('137', '奖惩记录', 'money/getRewardList.do', '2016-06-13 15:14:04', null, '2', '奖惩记录'), ('138', '员工调动列表', 'postRecord/postRecordList.do', '2016-06-13 15:14:04', null, '2', '员工调动列表'), ('139', '离职申请', 'postRecord/leavePost.do', '2016-06-13 15:14:04', null, '2', '离职申请'), ('140', '离职员工列表', 'postRecord/leavePostList.do', '2016-06-13 15:14:04', null, '2', '离职员工列表'), ('141', '工作面板', 'user/index.do', '2016-06-13 15:20:53', null, '3', '工作面板'), ('142', '用户列表', 'user/userList.do', '2016-06-13 15:20:53', null, '3', '修改用户'), ('143', '添加用户', 'user/addUserSend.do', '2016-06-13 15:20:53', null, '3', '添加用户'), ('144', '请假列表', 'record/selectRrcord.do', '2016-06-13 15:20:53', null, '3', '考勤记录查询'), ('145', '请假申请', 'record/addRecord.do', '2016-06-13 15:20:53', null, '3', '请假申请'), ('146', '我的请假单', 'record/selectRrcordUserId.do', '2016-06-13 15:20:53', null, '3', '请假单'), ('147', '日报查询', 'daily/selectDaily.do', '2016-06-13 15:20:53', null, '3', '日报查询'), ('148', '日报填写', 'daily/addDaily.do', '2016-06-13 15:20:53', null, '3', '日报填写'), ('149', '发送消息', 'message/sendMessage.do', '2016-06-13 15:20:53', null, '3', '发送邮件'), ('150', '消息列表', 'message/messageList.do', '2016-06-13 15:20:53', null, '3', '邮件查询'), ('151', '薪资列表', 'salary/getSalaryList.do', '2016-06-13 15:20:53', null, '3', '薪资列表'), ('152', '员工奖惩', 'money/sendMoney.do', '2016-06-13 15:20:53', null, '3', '员工奖惩'), ('153', '奖惩记录', 'money/getRewardList.do', '2016-06-13 15:20:53', null, '3', '奖惩记录'), ('154', '员工调动列表', 'postRecord/postRecordList.do', '2016-06-13 15:20:53', null, '3', '员工调动列表'), ('155', '离职申请', 'postRecord/leavePost.do', '2016-06-13 15:20:53', null, '3', '离职申请'), ('156', '离职员工列表', 'postRecord/leavePostList.do', '2016-06-13 15:20:53', null, '3', '离职员工列表');
COMMIT;

-- ----------------------------
--  Table structure for `salary`
-- ----------------------------
CREATE TABLE `salary` (
  `userId` int(11) NOT NULL COMMENT '用户id',
  `basic` decimal(10,0) NOT NULL COMMENT '基本工资',
  `eat` decimal(10,0) NOT NULL COMMENT '饭补',
  `duty` decimal(10,0) NOT NULL COMMENT '全勤',
  `scot` decimal(10,0) NOT NULL COMMENT '赋税',
  `punishment` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '奖惩',
  `createTime` datetime NOT NULL COMMENT '发放时间',
  `totalize` decimal(10,0) NOT NULL COMMENT '总计',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `salary`
-- ----------------------------
BEGIN;
INSERT INTO `salary` VALUES ('2', '5000', '0', '0', '0', '0', '2016-06-13 15:25:51', '5000'), ('3', '4000', '0', '0', '0', '0', '2016-06-14 21:09:00', '4000'), ('4', '4000', '0', '0', '0', '0', '2016-06-14 21:10:35', '4000'), ('5', '4000', '0', '0', '0', '0', '2016-06-14 21:13:19', '4000'), ('22', '689', '4', '345', '35', '45', '2016-05-30 09:12:50', '1048');
COMMIT;

-- ----------------------------
--  Table structure for `salarybottle`
-- ----------------------------
CREATE TABLE `salarybottle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL COMMENT '用户id',
  `basic` decimal(10,0) NOT NULL COMMENT '基本工资',
  `eat` decimal(10,0) NOT NULL COMMENT '饭补',
  `duty` decimal(10,0) NOT NULL COMMENT '全勤',
  `scot` decimal(10,0) NOT NULL COMMENT '赋税',
  `punishment` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '奖惩',
  `grantTime` datetime NOT NULL COMMENT '发放时间',
  `totalize` decimal(10,0) NOT NULL COMMENT '总计',
  `status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `salarybottle`
-- ----------------------------
BEGIN;
INSERT INTO `salarybottle` VALUES ('1', '1', '689', '4', '345', '35', '45', '2016-05-30 09:52:06', '1048', '1'), ('2', '2', '5000', '0', '0', '0', '0', '2016-06-14 09:04:12', '5000', '1');
COMMIT;

-- ----------------------------
--  Table structure for `train`
-- ----------------------------
CREATE TABLE `train` (
  `trainId` int(11) NOT NULL COMMENT '培训id流水',
  `trainName` varchar(255) NOT NULL COMMENT '培训名称',
  `purpose` varchar(255) NOT NULL COMMENT '培训目的',
  `beginTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  `teacher` varchar(255) NOT NULL COMMENT '培训讲师',
  `createTime` datetime NOT NULL COMMENT '建立时间',
  `datum` varchar(255) DEFAULT NULL COMMENT '人员',
  `student_id` int(11) NOT NULL COMMENT '培训学生id，用',
  PRIMARY KEY (`trainId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `realName` varchar(45) NOT NULL COMMENT '真实姓名',
  `sex` int(11) NOT NULL COMMENT '性别',
  `age` int(11) NOT NULL COMMENT '年龄',
  `idCode` varchar(45) NOT NULL COMMENT '身份证号码',
  `telephone` varchar(45) NOT NULL COMMENT '电话',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭地址',
  `workDate` datetime NOT NULL COMMENT '入职时间',
  `departmentId` int(11) NOT NULL COMMENT '部门id',
  `postId` int(11) DEFAULT NULL COMMENT '岗位id现在没用啦',
  `state` int(11) NOT NULL COMMENT '状态,1实习，2试用，3入职',
  `roles` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'admin', '111111', 'admin', '1', '24', '1307221992071100324', '18300000000', '18300000000@qq.com', '河北省', '2016-03-03 21:21:02', '10000', '20000', '5', '1'), ('2', 'zhangguangwei', '1111111', '章广伟', '1', '32', '330722197609192116', '18331375758', '18331375758@163.com', '河北', '2016-06-10 00:00:00', '10000', '20001', '1', '2'), ('3', 'taojunhua', '1111111', '陶君华', '0', '23', '430421197710177894', '18331376899', '75172433@qq.com', '甘肃', '2016-06-14 00:00:00', '10000', '20002', '1', '2'), ('4', 'wangxiaofei', '1111111', '王效霏', '1', '21', '370502198707175016', '18331374849', '751724893@qq.com', '北京', '2016-06-15 00:00:00', '10000', '20003', '1', '3'), ('5', 'meinanning', '1111111', '梅男宁', '0', '22', '610301198601143836', '18331376784', '751724893@qq.com', '河北', '2016-06-13 00:00:00', '10000', '20002', '2', '2');
COMMIT;

-- ----------------------------
--  Table structure for `user_Roles`
-- ----------------------------
CREATE TABLE `user_Roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) NOT NULL,
  `remark` varchar(45) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_Roles`
-- ----------------------------
BEGIN;
INSERT INTO `user_Roles` VALUES ('1', '超级管理员', '超级管理员'), ('2', '普通员工', '普通员工'), ('3', '管理员', '管理员');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;


-- //@UNDO
-- SQL to undo the change goes here.


