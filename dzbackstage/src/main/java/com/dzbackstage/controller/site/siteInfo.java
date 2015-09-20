package com.dzbackstage.controller.site;

import com.dzbackstage.service.imp.SiteService;
import com.dzeep.dzframe.controller.DZController;

/**
 * Created by fighting on 15/9/20.
 */
public class siteInfo extends DZController{
    SiteService siteService;

    public void setSiteService(SiteService siteService) {
        this.siteService = siteService;
    }
}
