package com.dzeep.dzstage.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alan on 15/10/7.
 * Thread 代表帖子，有所属版面、帖子标题、内容、发表ip、作者、点击率、最后回复人等属性。
 */
@Entity
@Table
public class Thread extends BaseBean{
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    private String title;

    @Basic(fetch = FetchType.LAZY)      //延迟加载
    @Column(columnDefinition = "longtext")  //该列为longtext类型
    private String content;         //内容

    @ManyToOne          //多对一
    @JoinColumn(name = "author_id")
    private Person author;

    private String ipCreated;       //发表时的ip地址
    private int hit;                //人气点击率

    @ManyToOne                  //多对一属性
    @JoinColumn(name = "autor_last_replied_id")     //外键
    private Person authorLastReplied;          //最后回复人

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastReplied;       //最后回复时间

    private boolean readonly;       //是否只读
    private boolean tooped;         //是否置顶
    private int     replyCount;     //回帖数

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
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

    public String getIpCreated() {
        return ipCreated;
    }

    public void setIpCreated(String ipCreated) {
        this.ipCreated = ipCreated;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public Person getAuthorLastReplied() {
        return authorLastReplied;
    }

    public void setAuthorLastReplied(Person authorLastReplied) {
        this.authorLastReplied = authorLastReplied;
    }

    public Date getDateLastReplied() {
        return dateLastReplied;
    }

    public void setDateLastReplied(Date dateLastReplied) {
        this.dateLastReplied = dateLastReplied;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public boolean isTooped() {
        return tooped;
    }

    public void setTooped(boolean tooped) {
        this.tooped = tooped;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }
}
