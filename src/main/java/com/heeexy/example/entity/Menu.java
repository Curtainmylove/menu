package com.heeexy.example.entity;

import com.heeexy.example.util.model.MomentEnum;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
//TkMybatis默认使用继承Mapper接口中传入的实体类对象去数据库寻找对应的表,
// 因此如果表名与实体类名不满足对应规则时,会报错,这时使用@Table为实体类指定表。
// (这种对应规则为驼峰命名规则)

@Table(name = "menu")
@Builder
@Data
public class Menu {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,
    // 会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    Long id;
    Long userId;
    Date time;
    @Column(name = "moment")
    MomentEnum moment;
    String menuData;
    Date createTime;
    Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MomentEnum getMoment() {
        return moment;
    }

    public void setMoment(MomentEnum moment) {
        this.moment = moment;
    }

    public String getMenuData() {
        return menuData;
    }

    public void setMenuData(String menuData) {
        this.menuData = menuData;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
