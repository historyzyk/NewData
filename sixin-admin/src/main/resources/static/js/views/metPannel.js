function metload(){
    //init_met_rain();
}


// function init_met_rain() {
//     var pre_data;
//     var area_group = new Array();
//     var metrain = echarts.init(document.getElementById('metrain'));
//
//     $.ajax({
//         type: "get",
//         url: "/iot/metpannel/list",
//         dataType: "json",
//         success: function (data) {
//             pre_data = data.data;
//             //确定area_group
//             // for (x in pre_data) {
//             //     area_group.push(pre_data[x].rname);
//             // }
//             //
//             // // 二维图表 广播地域分布可视化
//             // var x_data = area_group;
//             // var y_data = new Array();
//             //
//             // for (y in pre_data) {
//             //     y_data.push(pre_data[y].data);
//             // }
//             var x_data = new Array();
//             var y_data = new Array();
//             for (var i = 0; i <pre_data.length; i++) {
//                 if (pre_data[i].rname == '') {
//                     x_data.push('未知');
//                 } else {
//                     y_data.push(parseInt(pre_data[i].data));
//                     x_data.push(pre_data[i].rname);
//                 }
//             }
//             metrain_option = {
//                 color: ['#9B30FF'],
//                 tooltip: {
//                     trigger: 'axis',
//                     axisPointer: {            // 坐标轴指示器，坐标轴触发有效
//                         type: 'cross'        // 默认为直线，可选为：'line' | 'shadow'
//                     }
//                 },
//                 grid: {
//                     left: '0%',
//                     right: '0%',
//                     top: '5%',
//                     bottom: '0%',
//                     containLabel: true
//                 },
//                 xAxis: [
//                     {
//                         type: 'category',
//                         data: x_data,
//                         axisTick: {
//                             alignWithLabel: true
//                         }
//                     }
//                 ],
//                 yAxis: [
//                     {
//                         type: 'value'
//                     }
//                 ],
//                 series: [
//                     {
//                         name: '雨水量',
//                         type: 'bar',
//                         barWidth: '60%',
//                         data: y_data
//                     }
//                 ]
//             };
//             metrain.setOption(metrain_option);
//
//         }
//     })
// }
