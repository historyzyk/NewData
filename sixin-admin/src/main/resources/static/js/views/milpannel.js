function mil_load() {
    init_millist();
    init_pmtips();
}
function init_pmtips() {
    $.ajax({
        type: "GET",
        url: "/iot/milpannel/pmtips",
        dataType: "json",
        success: function(data){
            $("#pmavg").html(data.data[0].pm);
            $("#pmtips").html(data.data[0].tips);
        }
    });
}
function init_millist() {
    $.ajax({
        type: "GET",
        url: "/iot/milpannel/pm",
        dataType: "json",
        success: function (data_bt) {
            var pre_data = data_bt.data;
            var rain = new Array();
            var ph = new Array();
            var pm = new Array();
            var temp = new Array();
            var hum = new Array();
            var common_time = new Array();

            // 遍历服务器数据显示到页面

            for (i in pre_data){
                rain.push(pre_data[i].rain);
                ph.push(pre_data[i].ph);
                pm.push(pre_data[i].pm);
                temp.push(pre_data[i].temp);
                hum.push(pre_data[i].hum);
                common_time.push(pre_data[i].time);
            }

            var ec_rvis_rain = echarts.init(document.getElementById('rvis-rain'));
            var ec_rvis_ph = echarts.init(document.getElementById('rvis-ph'));
            var ec_rvis_pm = echarts.init(document.getElementById('rvis-pm'));
            var ec_rvis_temp = echarts.init(document.getElementById('rvis-temp'));
            var ec_rvis_hum = echarts.init(document.getElementById('rvis-hum'));


            ec_rvis_rain_option1 = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
                grid: {
                    left: '0%',
                    right: '0%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'雨量走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#cbd672"
                                }
                            },
                            emphasis: {
                                color: '#cbd672',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#cbd672" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:rain
                    }
                ]
            };
            ec_rvis_rain.setOption(ec_rvis_rain_option1);

            ec_rvis_ph_option4 = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
                grid: {
                    left: '0%',
                    right: '0%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'河流酸碱度走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#d6742e"
                                }
                            },
                            emphasis: {
                                color: '#d6742e',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#d6742e" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:ph
                    }
                ]
            };
            ec_rvis_ph.setOption(ec_rvis_ph_option4);

            ec_rvis_pm_option5 = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
                grid: {
                    left: '0%',
                    right: '0%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'PM2.5走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#6DD623"
                                }
                            },
                            emphasis: {
                                color: '#6DD623',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#6dd623" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:pm
                    }
                ]
            };
            ec_rvis_pm.setOption(ec_rvis_pm_option5);

            ec_rvis_temp_option6 = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
                grid: {
                    left: '0%',
                    right: '0%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'温度走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#4fd6d2"
                                }
                            },
                            emphasis: {
                                color: '#4fd6d2',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#4fd6d2" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:temp
                    }
                ]
            };
            ec_rvis_temp.setOption(ec_rvis_temp_option6);

            ec_rvis_hum_option7 = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
                grid: {
                    left: '0%',
                    right: '0%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'湿度走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#4fd6d2"
                                }
                            },
                            emphasis: {
                                color: '#4fd6d2',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#4fd6d2" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:hum
                    }
                ]
            };
            ec_rvis_hum.setOption(ec_rvis_hum_option7);



        }
    })




}