var DZPFM = window.DZPFM = window.DZPFM || {};
(function(){
    //获取当前路径
    var loaderPath = seajs.pluginSDK ? seajs.pluginSDK.util.loaderDir : seajs.data.base,
        lastIndex = loaderPath.lastIndexOf('/');
    if(lastIndex == loaderPath.length -1){ //去掉最后的 /
        loaderPath = loaderPath.substr(0,lastIndex);
    }
    seajs.config({
        // 变量配置
        vars: {
            'basePath': loaderPath
        },
        // 别名配置
        alias: {
            'jquery': '{basePath}/vendor/jquery'
        },
        // 路径配置
        paths: {
            'dzp': loaderPath
        },
        // Sea.js 的基础路径
        base: '{basePath}'
    });
    /*
    //获取bui使用的script标签
    var scripts = document.getElementsByTagName('script'),
        loaderScript = scripts[scripts.length - 1];
    DZPFM.loaderScript = loaderScript;
    //设置 是否调试
    if(loaderScript.getAttribute('data-debug') == 'true'){
        DZPFM.debug = true;
    }else{
        DZPFM.debug = false;
    }

    DZPFM.setDebug = function (debug) {
        DZPFM.debug = debug;

        if(debug){
            var map = seajs.data.map,
                index = -1;
            if(map){
                for(var i = 0 ; i < map.length; i++){
                    var item = map[i];
                    if(item[0].toString() == /.js$/.toString() && item[1] == '-min.js'){
                        index = i;
                        break;
                    }
                }
                if(index != -1){
                    map.splice(index,1);
                }
            }
        }else{
            seajs.config({
                map : [
                    [/.js$/, '-min.js']
                ]
            });
        }
    };

    DZPFM.setDebug(DZPFM.debug);
    */

    DZPFM.debug = false;
    DZPFM.use = seajs.use;
    DZPFM.config = seajs.config;

    var requires = [];

    define('dzp/common/loader',requires,function(require){
        var dzp = require("dzp/common/util");
        dzp.mix(DZPFM,{
            Browser : require('dzp/common/browser'),
            JSON : require('dzp/common/json'),
            Date : require('dzp/common/date'),
            Array : require('dzp/common/array'),
            KeyCode : require('dzp/common/keycode')
            /*
             Observable : require('bui/observable'),
             Base : require('bui/base'),
             Component : require('bui/component')
             */
        });

        return DZPFM;
    });
})();

