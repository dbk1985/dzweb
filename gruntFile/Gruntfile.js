/**
 * Created by dlm on 15/9/22.
 *
 */
module.exports = function (grunt) {
    'use strict';
    var distDir = 'html/dist/';
    grunt.initConfig({
        distDirectory:distDir,
        lessFiles:{"style":"style","dzp":"dzp"},
        srcFiles:{         //less编译目标
            '<%= distDirectory %>css/<%= lessFiles.style %>.css': 'less/<%= lessFiles.style %>.less',
            //'<%= distDirectory %>css/<%= lessFiles.list %>.css': 'less/<%= lessFiles.list %>.less',
            '<%= distDirectory %>css/<%= lessFiles.dzp%>.css': 'less/<%= lessFiles.dzp%>.less'
        },
        pkg: grunt.file.readJSON('package.json'),
        //在压缩后的文件的顶部添加的信息,如：功能 作者 日期等
        banner: '/*!\n'+
                '*v<%= pkg.version %> (<%= pkg.name %>) create by author <%= pkg.author %>\n'+
                '*<%= grunt.template.today("yyyy-mm-dd") %>\n'+
                '*/\n',

        //判断bower的配置文件是否存在，存在就使用bower的配置文件，否则就是用bower的默认文件bower_components
        bower_config:grunt.file.exists('.bowerrc') ? grunt.file.readJSON('.bowerrc') : { directory : 'bower_components' },

        clean: {
            dist: '<%= distDirectory %>',
        },
        /** ============================
         *              js
         *  ============================ **/
        /** 多个文件连接成一个文件插件任务配置  把第三方的js文件及自定义的js文件连接成一个文件 这些js插件是使用bower来管理的 */
        concat:{
            options: {
                banner: '<%= banner %>',
                stripBanners: false
            },
            dist:{          //目标
                /*
                src: [
                    '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.core.js',
                    '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.widget.js',
                    '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.mouse.js',
                    '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.position.js',
                    '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.button.js',
                    '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.slider.js',
                    '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.effect.js',
                    '<%= bower_config.directory %>/jquery-ui-touch-punch/jquery.ui.touch-punch.js',
                    '<%= bower_config.directory %>/bootstrap/dist/js/bootstrap.js',
                    'js/*.js',
                ],
                dest: '<%= distDirectory %>js/<%= pkg.name %>.js',
                */
                files: {
                    '<%= distDirectory %>js/vendor/jquery-ui.js': [
                        '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.core.js',
                        '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.widget.js',
                        '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.mouse.js',
                        '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.position.js',
                        '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.button.js',
                        '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.slider.js',
                        '<%= bower_config.directory %>/jquery-ui/ui/jquery.ui.effect.js',
                        '<%= bower_config.directory %>/jquery-ui-touch-punch/jquery.ui.touch-punch.js'],
                    '<%= distDirectory %>js/vendor/bootstrap.js':['<%= bower_config.directory %>/bootstrap/dist/js/bootstrap.js'],
                    '<%= distDirectory %>js/vendor/jquery.js':['<%= bower_config.directory %>/jquery/dist/jquery.js'],
                    '<%= distDirectory %>js/vendor/angular.js':['<%= bower_config.directory %>/angular/angular.js'],
                    '<%= distDirectory %>js/dzp.js':['<%= bower_config.directory %>/seajs/dist/sea.js','js/common/loader.js']
                }
            }
        },
        /** js文件校验插件 */
        jshint: {
            options: {
                jshintrc: 'config/.jshintrc'
            },
            src: {
                src: 'js/*.js'
            }
        },

        /** js文件压缩插件任务配置  压缩连接的js文件*/
        uglify:{
            // 全局的配置选项
            options: {
                //banner:'<%= banner =%>',  //应用全局的定义
                footer: '',     //在压缩后文件的底部添加的信息
                preserveComments:'some', //不删除注释，还可以为 false（删除全部注释），some（保留@preserve @license @cc_on等
            },
            //任务 build为任意取的任务的名称
            build: {
                //src: '<%= concat.dist.dest %>',      //连接好的js源文件位置
                //dest:'<%= distDirectory %>js/<%= pkg.name %>.min.js'         //压缩后的文件
                files:[
                    {
                        src: '<%= concat.dist.dest %>',      //连接好的js源文件位置
                        dest:'<%= distDirectory %>js/<%= pkg.name %>.min.js'         //压缩后的文件
                    },
                    {

                    }
                ]
            }
        },

        /** ============================
         *          less css 处理
         *  ============================ **/
        /** less编译插件任务配置 */
        less:{
            compileCore:{
                options:{       //less 核心编译配置
                    strictMath: true,
                    sourceMap: true,
                    outputSourceFiles: true,
                    sourceMapURL: '<%= pkg.name %>.css.map',
                    sourceMapFilename: '<%= distDirectory %>css/<%= pkg.name %>.css.map'
                },
                files:'<%= srcFiles %>'
            }
        },
        /** css根据不同浏览器添加前缀插件配置 */
        autoprefixer:{
            options: {
                browsers: [
                    'Android >= 4',
                    'Chrome >= 20',
                    'Firefox >= 24', // Firefox 24 is the latest ESR
                    'Explorer >= 9',
                    'iOS >= 6',
                    'Opera >= 16',
                    'Safari >= 6'
                ]
            },
            core: {
                options: {
                    map: true
                },
                src: [
                    '<%= distDirectory %>css/<%= lessFiles.style%>.css',
                    //'<%= distDirectory %>css/<%= lessFiles.list %>.css',
                    '<%= distDirectory %>css/<%= lessFiles.dzp%>.css'
                ]
            }
        },

        /** css语法检验插件任务配置 */
        csslint:{
            options: {
                csslintrc: 'config/.csslintrc',            //csslint 插件配置
                'overqualified-elements': false
            },
            files:'<%= srcFiles %>'
        },

        /** css压缩插件配置 */
        cssmin:{
            options: {
                keepSpecialComments: '*',
                noAdvanced: true
            },
            target: {
                files:'<%= srcFiles %>'
            }
        },

        /** ============================
         *        最后的资源文件处理
         *  ============================ **/
        /** copy插件任务配置->将编译好的文件复制到指定为位置 */
        copy:{
            //静态文件目标
            dist: {
                expand: true,    /** 启动文件映射配置 */
                src: [
                    'fonts/**',
                    'img/**'
                ],
                dest: '<%= distDirectory %>'
            },

            //模板文件目标
            distTemplate: {         //js css 开发的测试html模板

            },
            //第三方js文件目标
            distVendorJS: {
                expand:true,
                flatten:true,
                cwd: './bower_components',   // expand为true时才可使用,指定src中的文件的相对目录，bower_components为bower管理的js库
                src:[
                    'jquery/dist/jquery.min.js',
                    'jquery/dist/jquery.min.map',
                ],
                dest:"<%= distDirectory %>/vendor"
            },
            //第三方css文件目标 赋值bootstap的样式
            distVendorCSS: {
                expand: true,
                flatten: true,
                cwd: '<%= bower_config.directory %>',
                src:[
                    'bootstrap/dist/css/bootstrap.min.css',
                    'bootstrap/dist/css/bootstrap.css.map',
                    'bootstrap/dist/css/bootstrap-theme.css.map',
                    'bootstrap/dist/css/bootstrap-theme.min.css',
                ],
                dest:"<%= distDirectory %>vendor/bootstrap"
            },
            // 字体图标插件
            distFontAwesome:{
                files:[
                    {
                        expand: true,
                        cwd: '<%= bower_config.directory %>',
                        src: ['font-awesome/css/*'],
                        dest: '<%= distDirectory %>vendor'
                    },
                    {
                        expand: true,
                        cwd: '<%= bower_config.directory %>',
                        src: ['font-awesome/fonts/*'],
                        dest: '<%= distDirectory %>vendor'
                    }
                ]
            },
            // 弹出框插件
            distLayer:{
                files:[
                    {
                        expand:true,
                        cwd: '<%= bower_config.directory %>',
                        src: 'layer/layer.js',
                        dest: '<%= distDirectory %>vendor/'
                    },
                    {
                        expand:true,
                        cwd: '<%= bower_config.directory %>',
                        src: 'layer/extend/*',
                        dest: '<%= distDirectory %>vendor/'
                    },
                    {
                        expand:true,
                        cwd: '<%= bower_config.directory %>',
                        src: 'layer/mobile/*',
                        dest: '<%= distDirectory %>vendor'
                    },
                    {
                        expand:true,
                        cwd: '<%= bower_config.directory %>',
                        src: 'layer/skin/**/*',
                        dest: '<%= distDirectory %>vendor'
                    }
                ]
            },
            // jquery 滚动插件
            distJqSlimscroll:{
                expand: true,
                flatten: true,
                cwd: '<%= bower_config.directory %>',
                src:[
                    'jquery-slimscroll/*.js'
                ],
                dest:"<%= distDirectory %>vendor/jquery-slimscroll/"
            },
            // jquery MetisMenu插件
            distMetisMenu:{
                files:[
                    {
                        expand: true,
                        flatten: true,
                        cwd: '<%= bower_config.directory %>',
                        src:['metisMenu/dist/*'],
                        dest:"<%= distDirectory %>vendor/metisMenu/"
                    }
                ]
            },

            // pace插件
            distPace:{
                files:[
                    {
                        expand: true,
                        flatten: true,
                        cwd: '<%= bower_config.directory %>',
                        src:'PACE/themes/*',
                        dest:"<%= distDirectory %>vendor/pace/themes/"
                    },
                    {
                        expand: true,
                        flatten: true,
                        cwd: '<%= bower_config.directory %>',
                        src:'PACE/*.js',
                        dest:"<%= distDirectory %>vendor/pace/"
                    }
                ]
            },
            // css 动画插件
            distAnimate:{
                expand: true,
                flatten: true,
                cwd: '<%= bower_config.directory %>',
                src:'animate.css/*.css',
                dest:"<%= distDirectory %>vendor/animate/"
            },
            //自定义js文件目标
            distCustomJS: {
                files:[
                    {
                        expand: true,
                        cwd: './',
                        src:['js/**'],
                        dest:"<%= distDirectory %>/"
                    }
                ]
            }
        },
        /** 测试服务器连接插件 */
        connect: {
            options: {
                port: 9007,
                livereload: 42201,
                hostname: 'localhost',
                base: './html/'
            },
            livereload: {
                options: {
                    open: true
                }
            }
        },
        /** less文件监听 */
        watch:{
            less: {
                files: 'less/**/*.less',
                tasks: ['less','autoprefixer'],
                options: {
                    livereload: true,
                }
            },
            scripts: {
                files: 'js/**/*.js',
                tasks: ['jshint','copy:distCustomJS'],
                options: {
                    livereload: true,
                }
            },
            livereload: {
                options: {
                    livereload: '<%= connect.options.livereload %>'
                },
                files: ['{,*/}*.html', '{html,dist}/**/css/{,*/}*.css', '{html,dist}/**/js/{,*/}*.js']
            }
        }
    });
    /** 加载包含 "uglify" 任务的插件。压缩（minify）源码文件并依据上述元数据动态生成一个文件头注释 */
    grunt.loadNpmTasks('grunt-autoprefixer');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks("grunt-contrib-concat");
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-csslint');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks("grunt-contrib-jshint");
    grunt.loadNpmTasks("grunt-contrib-less");
    grunt.loadNpmTasks("grunt-contrib-uglify");
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks("grunt-contrib-watch");

    /** css、js测试任务 */
    grunt.registerTask('test', ['csslint', 'jshint']);
    /** js发布任务 */
    grunt.registerTask('dist-js', ['concat', 'uglify']);
    /** css发布任务 */
    grunt.registerTask('dist-css',['less','autoprefixer', 'cssmin']);
    /** 文件拷贝任务 */
    grunt.registerTask('dist-copy', [
        'copy:dist',
        'copy:distVendorJS',
        'copy:distAnimate',
        'copy:distCustomJS',
        'copy:distVendorCSS',
        'copy:distFontAwesome',
        'copy:distLayer',
        'copy:distJqSlimscroll',
        'copy:distMetisMenu',
        'copy:distPace',
        'copy:distTemplate'
    ]);

    /** 所有发布任务 */
    grunt.registerTask('dist', ['clean', 'dist-css', 'dist-js']);
    // 注册一个默认的任务 使用grunt命令才会执行
    grunt.registerTask('default', ['clean','dist', 'test', 'dist-copy']);

    grunt.registerTask('server', ['less', 'autoprefixer','connect:livereload', 'watch']);
}