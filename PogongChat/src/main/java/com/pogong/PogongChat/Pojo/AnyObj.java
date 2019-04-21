package com.pogong.PogongChat.Pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;
import java.util.Date;
import com.pogong.PogongChat.Common.Groups;

public class AnyObj {
    @Null(groups = {Groups.addStep1.class}) private Integer id;
    @NotNull(groups = {Groups.addStep2.class}) private String name;
    @Min(value = 1,groups = {Groups.addStep1.class,Groups.addStep2.class}) private int seasonCount;
    private Date originRelease;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSeasonCount() {
        return seasonCount;
    }
    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }
    public Date getOriginRelease() {
        return originRelease;
    }
    public void setOriginRelease(Date originRelease) {
        this.originRelease = originRelease;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append(this.getClass().getName()).append("{id:").append(id);
        buf.append(",name:").append(name).append(",seasonCount:").append(seasonCount);
        buf.append("}");
        return buf.toString();
    }
}
