package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_area", schema = "boot_demo", catalog = "")
public class TbAreaEntity {
    private Integer areaId;
    private String areaName;
    private Integer priority;
    private Timestamp createTime;
    private Timestamp lastEditTime;

    @Id
    @Column(name = "area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "area_name")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_edit_time")
    public Timestamp getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Timestamp lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAreaEntity that = (TbAreaEntity) o;
        return areaId == that.areaId &&
                Objects.equals(areaName, that.areaName) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(lastEditTime, that.lastEditTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, areaName, priority, createTime, lastEditTime);
    }
}
