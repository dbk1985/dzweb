package com.dzeep.dzstage.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 15/10/7.
 * Category 代表版面类别
 */
@Entity
@Table
public class Category extends BaseBean {

    private  String name;           //使用默认配置

    @OneToMany(mappedBy = "category")       // 一对多关系属性
    private List<Board> boards = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}
