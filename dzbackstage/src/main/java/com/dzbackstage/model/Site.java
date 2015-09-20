package com.dzbackstage.model;

/**
 * Created by fighting on 15/9/19.
 */
public class Site {
    private Long id;
    /** 网站名称 */
    private String title;
    /** 网站地址 */
    private String siteUrl;
    /** 版权信息 */
    private String copyRight;
    /** 站点关键字描述 */
    private String keywords;
    /** 网站描述 */
    private String desc;
    /** 站点备案号 */
    private String webSiteRecordNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getWebSiteRecordNumber() {
        return webSiteRecordNumber;
    }

    public void setWebSiteRecordNumber(String webSiteRecordNumber) {
        this.webSiteRecordNumber = webSiteRecordNumber;
    }
}
