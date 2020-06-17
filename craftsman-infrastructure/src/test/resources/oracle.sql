--新建表
CREATE TABLE metric
(
  `id` NUMBER(20) unsigned NOT NULL,
  `user_id` varchar2(64) NOT NULL,
  `main_metric` varchar2(64) NOT NULL,
  `sub_metric` varchar2(64) NOT NULL,
  `metric_item` varchar2(1024) DEFAULT NULL ,
  `creator` varchar2(64) NOT NULL ,
  `modifier` varchar2(64) NOT NULL,
  `gmt_create` DATE NOT NULL ,
  `gmt_modified` DATE NOT NULL,
  `is_deleted` VARCHAR2(1) NOT NULL
);

COMMENT ON TABLE metric IS '素材点赞表';
COMMENT ON COLUMN metric.id IS '主键id';
COMMENT ON COLUMN metric.user_id IS '素材id';
COMMENT ON COLUMN metric.main_metric IS '内容类型,4视频,6音频(听书) 7音频(后台上传) 8图文(手机报通用) 9 资讯 ';
COMMENT ON COLUMN metric.sub_metric IS '点赞用户号';
COMMENT ON COLUMN metric.metric_item IS '删除状态：0未删除，1已删除（取消点赞）  默认为0未删除';
COMMENT ON COLUMN metric.creator IS '点赞时间';

--索引
CREATE INDEX IDX_MATERIALSABET_DOUBLEID ON metric(user_id,main_metric);

-- 主键
alter table metric add constraint PK_T_MATERIALS_ABET primary key(id);

--创建序列
CREATE SEQUENCE SEQ_MATERIALS_ABET
  MINVALUE 1
  MAXVALUE 99999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 400;