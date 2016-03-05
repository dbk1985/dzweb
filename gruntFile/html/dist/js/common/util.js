window.DZPFM = window.DZPFM || {};

if(!DZPFM.use && window.seajs){
    DZPFM.use = seajs.use;
    DZPFM.config = seajs.config;
}

define('dzp/common/util', function (require) {
//兼容jquery 1.6以下
    (function($){
        if($.fn){
            $.fn.on = $.fn.on || $.fn.bind;
            $.fn.off = $.fn.off || $.fn.unbind;
        }
    })(jQuery);

    $.extend(DZPFM,{
        /**
         * 版本号
         * @memberOf DZPFM
         * @type {Number}
         */
        version:1.0,

        /**
         * 子版本号
         * @type {Number}
         */
        subVersion : 1,


        /**
         * 是否为函数
         * @param  {*} fn 对象
         * @return {Boolean}  是否函数
         */
        isFunction : function(fn){
            return typeof(fn) === 'function';
        },
        /**
         * 是否数组
         * @method
         * @param  {*}  obj 是否数组
         * @return {Boolean}  是否数组
         */
        isArray : ('isArray' in Array) ? Array.isArray : function(value) {
            return toString.call(value) === '[object Array]';
        },
        /**
         * 是否日期
         * @param  {*}  value 对象
         * @return {Boolean}  是否日期
         */
        isDate: function(value) {
            return toString.call(value) === '[object Date]';
        },
        /**
         * 是否是javascript对象
         * @param {Object} value The value to test
         * @return {Boolean}
         * @method
         */
        isObject: (toString.call(null) === '[object Object]') ?
            function(value) {
                // check ownerDocument here as well to exclude DOM nodes
                return value !== null && value !== undefined && toString.call(value) === '[object Object]' && value.ownerDocument === undefined;
            } :
            function(value) {
                return toString.call(value) === '[object Object]';
            },
        /**
         * 是否是数字或者数字字符串
         * @param  {String}  value 数字字符串
         * @return {Boolean}  是否是数字或者数字字符串
         */
        isNumeric: function(value) {
            return !isNaN(parseFloat(value)) && isFinite(value);
        },
        /**
         * 判断是否是字符串
         * @return {Boolean} 是否是字符串
         */
        isString : function(value){
            return typeof value === 'string';
        },
        /**
         * 判断是否数字，由于$.isNumberic方法会把 '123'认为数字
         * @return {Boolean} 是否数字
         */
        isNumber : function(value){
            return typeof value === 'number';
        },
        /**
         * 是否是布尔类型
         *
         * @param {Object} value 测试的值
         * @return {Boolean}
         */
        isBoolean: function(value) {
            return typeof value === 'boolean';
        },
        /**
         * 拷贝对象
         * @param  {Object} obj 要拷贝的对象
         * @return {Object} 拷贝生成的对象
         */
        cloneObject : function(obj){
            var result = DZPFM.isArray(obj) ? [] : {};

            return DZPFM.mix(true,result,obj);
        },
        /**
         * 封装 jQuery.extend 方法，将多个对象的属性merge到第一个对象中
         * @return {Object}
         */
        mix : function(){
            return $.extend.apply(null,arguments);
        },
        /**
         * 生成命名空间
         * @param  {String} name 命名空间的名称
         * @param  {Object} baseNS 在已有的命名空间上创建命名空间，默认“DZPFM”
         * @return {Object} 返回的命名空间对象
         *      @example
         *      DZPFM.namespace("Grid"); // DZPFM.Grid
         */
        namespace : function(name,baseNS){
            baseNS = baseNS || DZPFM;
            if(!name){
                return baseNS;
            }
            var list = name.split('.'),
            //firstNS = win[list[0]],
                curNS = baseNS;

            for (var i = 0; i < list.length; i++) {
                var nsName = list[i];
                if(!curNS[nsName]){
                    curNS[nsName] = {};
                }
                curNS = curNS[nsName];
            }
            return curNS;
        },

        /**
         * 实现类的继承，通过父类生成子类
         * @param  {Function} subclass
         * @param  {Function} superclass 父类构造函数
         * @param  {Object} overrides  子类的属性或者方法
         * @return {Function} 返回的子类构造函数
         * 示例:
         *      @example
         *      //父类
         *      function base(){
         *
         *      }
         *
         *      function sub(){
         *
         *      }
         *      //子类
         *      DZPFM.extend(sub,base,{
         *          method : function(){
         *
         *          }
         *      });
         *
         *      //或者
         *      var sub = DZPFM.extend(base,{});
         */
        extend : function(subclass,superclass,overrides, staticOverrides){
            //如果只提供父类构造函数，则自动生成子类构造函数
            if(!DZPFM.isFunction(superclass)) {
                overrides = superclass;
                superclass = subclass;
                subclass =  function(){};
            }

            var create = Object.create ?
                function (proto, c) {
                    return Object.create(proto, {
                        constructor: {
                            value: c
                        }
                    });
                } :
                function (proto, c) {
                    function F() {
                    }

                    F.prototype = proto;

                    var o = new F();
                    o.constructor = c;
                    return o;
                };
            var superObj = create(superclass.prototype,subclass);//new superclass(),//实例化父类作为子类的prototype
            subclass.prototype = DZPFM.mix(superObj,subclass.prototype);     //指定子类的prototype
            subclass.superclass = create(superclass.prototype,superclass);
            DZPFM.mix(superObj,overrides);
            DZPFM.mix(subclass,staticOverrides);
            return subclass;
        },

        /**
         * 遍历数组或者对象
         * @param {Object|Array} element/Object 数组中的元素或者对象的值
         * @param {Function} func 遍历的函数 function(element,index){} 或者 function(value,key){}
         */
        each : function (elements,func) {
            if(!elements){
                return;
            }
            $.each(elements,function(k,v){
                return func(v,k);
            });
        },
        /**
         * 使第一个字母变成大写
         * @param  {String} s 字符串
         * @return {String} 首字母大写后的字符串
         */
        ucfirst : function(s){
            s += '';
            return s.charAt(0).toUpperCase() + s.substring(1);
        },

    });

    return DZPFM;
});