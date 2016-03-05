package com.dzeep.dzstage.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fighting on 15/10/7.
 * 实体父级类
 */
@MappedSuperclass
public class BaseBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)         //id自动增长
    private Integer id;     //id配置

    @Version
    private Integer version;        //版本列 hibernate自动维护

    private boolean deleted;        //删除位，使用默认配置

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCreated;       //时间戳

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
