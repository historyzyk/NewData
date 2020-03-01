function secload(){
     init_watersec();
init_3d_bt();
    sort_3d_bt();
    init_trigger();
}
function init_watersec() {
    var watersec = echarts.init(document.getElementById('watersec'));
    $.ajax({
        type: "GET",
        url: "/api/iot/water",
        datatype: "JSON",
        success: function (data) {
            var watersec_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < watersec_data.length; i++) {
                if (watersec_data[i].date == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(watersec_data[i].water));
                    x_data.push(watersec_data[i].date);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            option = {
                color: ['#06edfc'],
                tooltip: {
                    trigger: 'axis'
                },
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                    }
                },
                calculable: true,
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
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
                        data: y_data,
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    },
                ]
            };
            watersec.setOption(option);
        }
    });

}

function sort_3d_bt() {

    var pre_data;
    var area_group = new Array();
    var data_group = new Array();
    var xyz_data = new Array();
    var ec_3d_bt= echarts.init(document.getElementById('3d_bt'));

    $.ajax({
        type: "GET",
        url: "/api/iot/sumtermSort",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            var dp_temp = ['down','req','run','sum'];
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].aname);
            }
            //确定xyz_data
            for( pg_name in pre_data){
                var ag = area_group.indexOf(pre_data[pg_name].aname);
                var temp_data = pre_data[pg_name];
                delete temp_data["aname"];
                var temp_keys = Object.keys(temp_data);
                for(i=0;i<temp_keys.length;i++){
                    var this_key = temp_keys[i];
                    var pg = dp_temp.indexOf(temp_keys[i]);
                    var z_value = temp_data[this_key];
                    xyz_data.push([pg,ag,z_value])
                }
            }

            // 英文 - 中文替换
            for ( item in dp_temp){
                if(dp_temp[item].indexOf('sum') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('sum','设备总数');
                }else if(dp_temp[item].indexOf('run') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('run','运行数');
                }else if (dp_temp[item].indexOf('down') >= 0 ) {
                    dp_temp[item] = dp_temp[item].replace('down','停止数');
                }else if(dp_temp[item].indexOf('req') >= 0){
                    dp_temp[item] = dp_temp[item].replace('req','维修数');
                }
                data_group = dp_temp;
            }

            //确定3D_EC 坐标系与数据
            var a_cg =area_group;
            var data_cg = data_group;
            var data = xyz_data;
            ec_3d_bt_option = {
                tooltip: {
                    axisPointer :{
                        label:{
                            show: true
                        }
                    }
                },
                visualMap: {
                    max: 260,
                    inRange: {
                        color: ['#00868B','#00CD00', '#00FA9A', '#00CED1','#00F5FF','#00FFFF']
                    }
                },
                xAxis3D: {
                    type: 'category',
                    data: a_cg
                },
                yAxis3D: {
                    type: 'category',
                    data: data_cg
                },
                zAxis3D: {
                    type: 'value'
                },
                grid3D: {
                    boxWidth: 300,
                    boxDepth: 80,
                    axisLabel: {
                        interval: 0
                    },
                    viewControl: {
                        // projection: 'orthographic'
                        autoRotate: true
                    },
                    light: {
                        main: {
                            intensity: 1.2,
                            shadow: true
                        },
                        ambient: {
                            intensity: 0.3
                        }
                    }
                },
                series: [{
                    type: 'bar3D',
                    data: data.map(function (item) {
                        return {
                            value: [item[1], item[0], item[2]],
                        }
                    }),
                    shading: 'lambert',

                    label: {
                        textStyle: {
                            fontSize: 12,
                            borderWidth: 1
                        }
                    },

                    emphasis: {
                        label: {
                            textStyle: {
                                fontSize: 20,
                                color: '#900'
                            }
                        },
                        itemStyle: {
                            color: '#900'
                        }
                    }
                }]
            };
            ec_3d_bt.setOption(ec_3d_bt_option);
        }
    })

}


function init_3d_bt() {

    var pre_data;
    var area_group = new Array();
    var data_group = new Array();
    var xyz_data = new Array();
    var ec_3d_bt= echarts.init(document.getElementById('3d_bt'));

    $.ajax({
        type: "GET",
        url: "/api/iot/sumterm",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            var dp_temp = ['down','req','run','sum'];
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].aname);
            }
            //确定xyz_data
            for( pg_name in pre_data){
                var ag = area_group.indexOf(pre_data[pg_name].aname);
                var temp_data = pre_data[pg_name];
                delete temp_data["aname"];
                var temp_keys = Object.keys(temp_data);
                for(i=0;i<temp_keys.length;i++){
                    var this_key = temp_keys[i];
                    var pg = dp_temp.indexOf(temp_keys[i]);
                    var z_value = temp_data[this_key];
                    xyz_data.push([pg,ag,z_value])
                }
            }

            // 英文 - 中文替换
            for ( item in dp_temp){
                if(dp_temp[item].indexOf('sum') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('sum','设备总数');
                }else if(dp_temp[item].indexOf('run') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('run','运行数');
                }else if (dp_temp[item].indexOf('down') >= 0 ) {
                    dp_temp[item] = dp_temp[item].replace('down','停止数');
                }else if(dp_temp[item].indexOf('req') >= 0){
                    dp_temp[item] = dp_temp[item].replace('req','维修数');
                }
                data_group = dp_temp;
            }

            //确定3D_EC 坐标系与数据
            var a_cg =area_group;
            var data_cg = data_group;
            var data = xyz_data;
            ec_3d_bt_option = {
                tooltip: {
                    axisPointer :{
                        label:{
                            show: true
                        }
                    }
                },
                visualMap: {
                    max: 260,
                    inRange: {
                        color: ['#00868B','#00CD00', '#00FA9A', '#00CED1','#00F5FF','#00FFFF']
                    }
                },
                xAxis3D: {
                    type: 'category',
                    data: a_cg
                },
                yAxis3D: {
                    type: 'category',
                    data: data_cg
                },
                zAxis3D: {
                    type: 'value'
                },
                grid3D: {
                    boxWidth: 300,
                    boxDepth: 80,
                    axisLabel: {
                        interval: 0
                    },
                    viewControl: {
                        // projection: 'orthographic'
                        autoRotate: true
                    },
                    light: {
                        main: {
                            intensity: 1.2,
                            shadow: true
                        },
                        ambient: {
                            intensity: 0.3
                        }
                    }
                },
                series: [{
                    type: 'bar3D',
                    data: data.map(function (item) {
                        return {
                            value: [item[1], item[0], item[2]],
                        }
                    }),
                    shading: 'lambert',

                    label: {
                        textStyle: {
                            fontSize: 12,
                            borderWidth: 1
                        }
                    },

                    emphasis: {
                        label: {
                            textStyle: {
                                fontSize: 20,
                                color: '#900'
                            }
                        },
                        itemStyle: {
                            color: '#900'
                        }
                    }
                }]
            };
            ec_3d_bt.setOption(ec_3d_bt_option);
        }
    })

}

function init_trigger() {
    var trigger = echarts.init(document.getElementById('trigger'));
    $.ajax({
        type: "GET",
        url: "/api/iot/trigger",
        datatype: "JSON",
        success: function (data) {
            var trigger_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < trigger_data.length; i++) {
                if (trigger_data[i].marea == '') {
                    x_data.push('未知');
                } else {
                    x_data.push(trigger_data[i].type);
                    y_data.push(parseInt(trigger_data[i].count));

                }
            }
            /*console.log(bdsygroup_data);*/
            /*console.log(x_data);
             console.log(y_data);*/
            bds_option = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: x_data
                },
                calculable: true,
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            /*y_data*/
                            {name: x_data[0], value: 3},
                            {name: x_data[1], value: 2},

                        ]
                    }
                ]
            };
           trigger.setOption(bds_option);
        }
    });
}