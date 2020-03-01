


function metload() {
    init_hummet();//创建湿度二维表
    init_rainmet();//创建降雨二维表
    init_seemet();//创建可见度二维表
    init_rivermet();//创建水位二维表
}


function init_hummet() {
    var hummet = echarts.init(document.getElementById('hummet'));
    $.ajax({
        type: "GET",
        url: "/api/met/hum",
        datatype: "JSON",
        success: function (data) {
            var hummet_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < hummet_data.length; i++) {
                if (hummet_data[i].hum == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(hummet_data[i].sumhum));
                    x_data.push(hummet_data[i].hum);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            hum_option = {
                //鼠标移动到柱状图会显示内容
                tooltip: {
                    trigger: 'axis'
                    //触发类型；轴触发,axis则鼠标hover到一条柱状图显示全部数据,item则鼠标hover到折线点显示相应数据
                },
                //工具箱,只能一个
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                    }
                },
                //是否用拖拽重计算特性
                calculable: true,
                //图标边缘
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',//坐标轴类型
                        boundaryGap: false,
                        data: x_data,
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function(y_data) {
                                    var index_color = y_data.value;

                                    if(index_color>=100){
                                        return '#fe4365';
                                    }else {
                                        return '#25daba';
                                    }


                                }
                            }
                        },
                        data: y_data,
                        markLine: {
                            data: [
                                {
                                    yAxis:'100',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'湿度'
                                }
                            ]
                        }
                    },
                ]
            };
            hummet.setOption(hum_option);
        }
    });
}


function init_rainmet() {
    var rainmet = echarts.init(document.getElementById('rainmet'));
    $.ajax({
        type: "GET",
        url: "/api/met/rain",
        datatype: "JSON",
        success: function (data) {
            var rainmet_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < rainmet_data.length; i++) {
                if (rainmet_data[i].rname == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(rainmet_data[i].sumrain));
                    x_data.push(rainmet_data[i].rname);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            rain_option = {
                //鼠标移动到柱状图会显示内容
                tooltip: {
                    trigger: 'axis'
                    //触发类型；轴触发,axis则鼠标hover到一条柱状图显示全部数据,item则鼠标hover到折线点显示相应数据
                },
                //工具箱,只能一个
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                    }
                },
                //是否用拖拽重计算特性
                calculable: true,
                //图标边缘
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',//坐标轴类型
                        boundaryGap: false,
                        data: x_data,
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function(y_data) {
                                    var index_color = y_data.value;

                                    if(index_color>=100){
                                        return '#fe4365';
                                    }else {
                                        return '#25daba';
                                    }


                                }
                            }
                        },
                        data: y_data,
                        markLine: {
                            data: [
                                {
                                    yAxis:'100',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'降雨'
                                }
                            ]
                        }
                    },
                ]
            };
            rainmet.setOption(rain_option);
        }
    });
}

function init_seemet() {
    var seemet = echarts.init(document.getElementById('seemet'));
    $.ajax({
        type: "GET",
        url: "/api/met/see",
        datatype: "JSON",
        success: function (data) {
            var seemet_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < seemet_data.length; i++) {
                if (seemet_data[i].temp == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(seemet_data[i].sumtemp));
                    x_data.push(seemet_data[i].temp);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            see_option = {
                //鼠标移动到柱状图会显示内容
                tooltip: {
                    trigger: 'axis'
                    //触发类型；轴触发,axis则鼠标hover到一条柱状图显示全部数据,item则鼠标hover到折线点显示相应数据
                },
                //工具箱,只能一个
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                    }
                },
                //是否用拖拽重计算特性
                calculable: true,
                //图标边缘
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',//坐标轴类型
                        boundaryGap: false,
                        data: x_data,
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function(y_data) {
                                    var index_color = y_data.value;

                                    if(index_color>=100){
                                        return '#fe4365';
                                    }else {
                                        return '#25daba';
                                    }


                                }
                            }
                        },
                        data: y_data,
                        markLine: {
                            data: [
                                {
                                    yAxis:'100',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'可见度'
                                }
                            ]
                        }
                    },
                ]
            };
            seemet.setOption(see_option);
        }
    });
}

function init_rivermet() {
    var rivermet = echarts.init(document.getElementById('rivermet'));
    $.ajax({
        type: "GET",
        url: "/api/met/river",
        datatype: "JSON",
        success: function (data) {
            var rivermet_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < rivermet_data.length; i++) {
                if (rivermet_data[i].rname == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(rivermet_data[i].data));
                    x_data.push(rivermet_data[i].rname);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            river_option = {
                //鼠标移动到柱状图会显示内容
                tooltip: {
                    trigger: 'axis'
                    //触发类型；轴触发,axis则鼠标hover到一条柱状图显示全部数据,item则鼠标hover到折线点显示相应数据
                },
                //工具箱,只能一个
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                    }
                },
                //是否用拖拽重计算特性
                calculable: true,
                //图标边缘
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',//坐标轴类型
                        boundaryGap: false,
                        data: x_data,
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function(y_data) {
                                    var index_color = y_data.value;

                                    if(index_color>=100){
                                        return '#fe4365';
                                    }else {
                                        return '#25daba';
                                    }


                                }
                            }
                        },
                        data: y_data,
                        markLine: {
                            data: [
                                {
                                    yAxis:'100',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'水位'
                                }
                            ]
                        }
                    },
                ]
            };
            rivermet.setOption(river_option);
        }
    });
}