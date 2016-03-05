package com.dzeep.dzstage.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alan on 15/10/7.
 * Board 代表面版   有所属类别、名称、帖子总数、回帖总数、最后回帖、最后发帖、版主等信息。
 */
@Entity
@Table
public class Board extends  BaseBean {
    @ManyToOne                         //多对一
    @JoinColumn(name = "category_id")   //外键列
    private Category category;          //所属版面类别

    private String name;    //版面标题
    private String description; //版面描述
    private int    threadCount; //帖子总数
    private int    replyCount; //回帖总数

    @ManyToOne                          //多对一
    @JoinColumn(name = "last_reply_id") //外键列
    private Reply lastReply;            //最后发表的帖子

    @ManyToOne
    @JoinColumn(name = "last_thread_id")
    private Thread lastThread;          //最后发表的帖子

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "board_administrator",joinColumns = {@JoinColumn(name = "board_id")},inverseJoinColumns = {@JoinColumn(name = "persion_id")})  //中间表配置
    private Set<Person> administrators = new HashSet<Person>();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public Reply getLastReply() {
        return lastReply;
    }

    public void setLastReply(Reply lastReply) {
        this.lastReply = lastReply;
    }

    public Thread getLastThread() {
        return lastThread;
    }

    public void setLastThread(Thread lastThread) {
        this.lastThread = lastThread;
    }

    public Set<Person> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Set<Person> administrators) {
        this.administrators = administrators;
    }
}
