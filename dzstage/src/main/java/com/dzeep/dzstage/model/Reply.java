package com.dzeep.dzstage.model;

import javax.persistence.*;

/**
 * Created by alan on 15/10/7.
 * Reply代表回帖，有原帖、回帖标题、内容、作者、第几个回帖等属性。
 */
@Entity
@Table
public class Reply extends BaseBean {

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread thread;              //回复的帖子

    private String title;

    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "longtext")      //该列为longtext类型
    private String content;     //回复内容

    @ManyToOne
    @JoinColumn(name = "author_id")     //外键
    private Person author;     //回复作者

    private int floor;          //第几楼
    private String ipCreated;   //发表时ip地址

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getIpCreated() {
        return ipCreated;
    }

    public void setIpCreated(String ipCreated) {
        this.ipCreated = ipCreated;
    }
}
