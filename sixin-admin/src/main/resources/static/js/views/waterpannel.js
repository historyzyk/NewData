function   waterload() {
    init_water_tem()
    //init_water_ph()
    //首页图表 水质全部可视化
    //init_waters()
}
function init_water_tem() {
    var water_tem = echarts.init(document.getElementById('water_tem'));
    $.ajax({
        type: "GET",
        url: "/api/iot/tem",
        datatype: "JSON",
        success: function (data) {
            var watertem_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < watertem_data.length; i++) {
                if (watertem_data[i].tem == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(watertem_data[i].tem));
                    x_data.push(watertem_data[i].aid);
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
            water_tem.setOption(option);
        }
    });
}

// function init_water_ph() {
//     var water_ph = echarts.init(document.getElementById('water_ph'));
//     $.ajax({
//         type: "GET",
//         url: "/api/iotdata/ph",
//         datatype: "JSON",
//         success: function (data) {
//             var waterph_data = data.data;
//             var x_data = new Array();
//             var y_data = new Array();
//             for (var i = 0; i < waterph_data.length; i++) {
//                 if (waterph_data[i].ph == '') {
//                     x_data.push('未知');
//                 } else {
//                     y_data.push(parseInt(waterph_data[i].ph));
//                     x_data.push(waterph_data[i].aid);
//                 }
//             }
//             /*console.log(x_data);*/
//             /*console.log(y_data);*/
//             option = {
//                 color: ['#06edfc'],
//                 tooltip: {
//                     trigger: 'axis'
//                 },
//                 toolbox: {
//                     show: true,
//                     feature: {
//                         magicType: {show: true, type: ['line', 'bar']},
//                     }
//                 },
//                 calculable: true,
//                 grid: {
//                     left: '3%',
//                     right: '3%',
//                     top: '5%',
//                     bottom: '0%',
//                     containLabel: true
//                 },
//                 xAxis: [
//                     {
//                         type: 'category',
//                         boundaryGap: false,
//                         data: x_data,
//                     }
//                 ],
//                 yAxis: [
//                     {
//                         type: 'value',
//                         axisLabel: {
//                             formatter: '{value}'
//                         }
//                     }
//                 ],
//                 series: [
//                     {
//                         type: 'line',
//                         data: y_data,
//                         markLine: {
//                             data: [
//                                 {type: 'average', name: '平均值'}
//                             ]
//                         }
//                     },
//                 ]
//             };
//             water_ph.setOption(option);
//         }
//     });
// }

// function init_waters() {
//     $.ajax({
//         type: "GET",
//         url: "/api/waterdata/",
//         dataType: "json",
//         success: function (data_bt) {
//             var pre_data = data_bt.data;
//             var rain = new Array();
//             var flow = new Array();
//             var wlevel = new Array();
//             var ph = new Array();
//             var pm = new Array();
//             var temp = new Array();
//             var hum = new Array();
//             var common_time = new Array();
//

//         }
//     )
//
// }