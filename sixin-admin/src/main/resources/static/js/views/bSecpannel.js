/**
 * Created by yxw on 2019/12/20.
 */

function secload(){
    //init_bd_sec();
    init_pmsec();
    init_rainsec();
    init_tempsec();
    init_wlevelsec();
    init_humsec();
    init_envsectype();
    init_3d_watersec();
    sort_3d_watersec();
    init_bacsec();
    init_watsectype();
}

function init_pmsec() {
    var pmsec = echarts.init(document.getElementById('pmsec'));
    $.ajax({
        type: "GET",
        url: "/api/security/pm",
        datatype: "JSON",
        success: function (data) {
            var pmsec_data = data.data;
            var x_data = new Array();
            var y_cs_data = new Array();
            var y_hx_data = new Array();
            var y_hh_data = new Array();
            for (var i = 0; i < pmsec_data.length; i++) {
                if (pmsec_data[i].pm == '') {
                    x_data.push('未知');
                }
                if (pmsec_data[i].aid == '01') {
                    y_cs_data.push(pmsec_data[i].pm);
                    x_data.push(pmsec_data[i].time);
                }
            }
            for (var i = 0; i < pmsec_data.length; i++) {
                if (pmsec_data[i].pm == '') {
                    x_data.push('未知');
                }
                if (pmsec_data[i].aid == '0101') {
                    y_hx_data.push(pmsec_data[i].pm);
                    //x_data.push(pmsec_data[i].time);
                }
            }
            for (var i = 0; i < pmsec_data.length; i++) {
                if (pmsec_data[i].pm == '') {
                    x_data.push('未知');
                }
                if(pmsec_data[i].aid == '0102'){
                    y_hh_data.push(pmsec_data[i].pm);
                    //x_data.push(pmsec_data[i].time);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            pm_option = {
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
                legend:{
                    show:true,
                    selectedMode:'single',    //设置显示单一图例的图形，点击可切换
                    data:['长沙县','黄兴镇','黄花镇'],
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
                        name: '长沙县',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_cs_data) {
                                    var index_color = y_cs_data.value;
                                    if (index_color <= 50 ) {
                                        return '#00fc1a';
                                    }
                                    if (index_color > 50 && index_color <=100 ) {
                                        return '#FFFF00';
                                    }
                                    if(index_color > 100 && index_color <= 150 ) {
                                        return '#FFA500';
                                    }
                                    if(index_color > 150 && index_color <= 200 ) {
                                        return '#fe4365';
                                    }
                                    if(index_color > 200 ) {
                                        return '#000000';
                                    }
                                },
                                lineStyle: {color: '#00fc1a' }//改变折线颜色
                            }
                        },
                        data: y_cs_data,
                        markLine: {
                            data: [
                                {label:{
                                        formatter:'预警值:100',
                                        position:'middle',
                                    },
                                    yAxis:'100',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                    {
                        name: '黄兴镇',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_hx_data) {
                                    var index_color = y_hx_data.value;
                                    if (index_color <= 50 ) {
                                        return '#00fc1a';
                                    }
                                    if (index_color > 50 && index_color <=100 ) {
                                        return '#FFFF00';
                                    }
                                    if(index_color > 100 && index_color <= 150 ) {
                                        return '#FFA500';
                                    }
                                    if(index_color > 150 && index_color <= 200 ) {
                                        return '#fe4365';
                                    }
                                    if(index_color > 200 ) {
                                        return '#000000';
                                    }
                                },
                                lineStyle: {color: '#00fc1a' }//改变折线颜色
                            }
                        },
                        data: y_hx_data,
                        markLine: {
                            data: [
                                {label:{
                                        formatter:'预警值:100',
                                        position:'middle',
                                    },
                                    yAxis:'100',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                    {
                        name: '黄花镇',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_hh_data) {
                                    var index_color = y_hh_data.value;
                                    if (index_color <= 50 ) {
                                        return '#00fc1a';
                                    }
                                    if (index_color > 50 && index_color <=100 ) {
                                        return '#FFFF00';
                                    }
                                    if(index_color > 100 && index_color <= 150 ) {
                                        return '#FFA500';
                                    }
                                    if(index_color > 150 && index_color <= 200 ) {
                                        return '#fe4365';
                                    }
                                    if(index_color > 200 ) {
                                        return '#000000';
                                    }
                                },
                                lineStyle: {color: '#00fc1a' }//改变折线颜色
                            }
                        },
                        data: y_hh_data,
                        markLine: {
                            data: [
                                {label:{
                                        formatter:'预警值:100',
                                        position:'middle',
                                    },
                                    yAxis:'100',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                ]
            };
            pmsec.setOption(pm_option);
        }
    });
}

function init_rainsec() {
    var rainsec = echarts.init(document.getElementById('rainsec'));
    $.ajax({
        type: "GET",
        url: "/api/security/rain",
        datatype: "JSON",
        success: function (data) {
            var rainsec_data = data.data;
            var x_data = new Array();
            var y_cs_data = new Array();
            var y_hx_data = new Array();
            var y_hh_data = new Array();
            for (var i = 0; i < rainsec_data.length; i++) {
                if (rainsec_data[i].rain == '') {
                    x_data.push('未知');
                }
                if (rainsec_data[i].aid == '01') {
                    y_cs_data.push(rainsec_data[i].rain);
                    x_data.push(rainsec_data[i].time);
                }
            }
            for (var i = 0; i < rainsec_data.length; i++) {
                if (rainsec_data[i].rain == '') {
                    x_data.push('未知');
                }
                if (rainsec_data[i].aid == '0101') {
                    y_hx_data.push(rainsec_data[i].rain);
                    //x_data.push(rainsec_data[i].time);
                }
            }
            for (var i = 0; i < rainsec_data.length; i++) {
                if (rainsec_data[i].rain == '') {
                    x_data.push('未知');
                }
                if(rainsec_data[i].aid == '0102'){
                    y_hh_data.push(rainsec_data[i].rain);
                    //x_data.push(rainsec_data[i].time);
                }
            }
            /*for (var i = 0; i < rainsec_data.length; i++) {
                if (rainsec_data[i].rain == '')
                    x_data.push('未知');
                else if (rainsec_data[i].aid == "01"){
                    y_cs_data.push(rainsec_data[i].rain);
                    x_data.push(rainsec_data[i].time);
                    continue;
                }
                else if(rainsec_data[i].aid == "0101"){
                    y_hx_data.push(rainsec_data[i].rain);
                    x_data.push(rainsec_data[i].time);
                    continue;
                }
                else if(rainsec_data[i].aid == "0102"){
                    y_hh_data.push(rainsec_data[i].rain);
                    x_data.push(rainsec_data[i].time);
                    continue;
                }
            }*/
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            rain_option = {
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
                legend:{
                    show:true,
                    selectedMode:'single',    //设置显示单一图例的图形，点击可切换
                    data:['长沙县','黄兴镇','黄花镇'],
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: true,
                        alignWithLabel:true,
                        splitNumber:10,
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
                        name:'长沙县',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_cs_data) {
                                    var index_color = y_cs_data.value;

                                    if (index_color >= 20) {
                                        return '#fe4365';
                                    } else {
                                        return '#25daba';
                                    }
                                },
                                lineStyle: {color: '#8cd5c2' }//改变折线颜色
                            }
                        },
                        data: y_cs_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:20mm',
                                        position:'middle',
                                    },
                                    yAxis: '20',
                                    lineStyle: {
                                        color: '#900',
                                        type: 'solid'
                                    },
                                    name: '报警值'
                                }
                            ]
                        }
                    },
                    /*{
                        name:'长沙县',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                lineStyle: {color: '#8cd5c2' }//改变折线颜色
                            }
                        },
                        data: y_data,
                    },*/
                    {
                        name:'黄兴镇',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_hx_data) {
                                    var index_color = y_hx_data.value;

                                    if (index_color >= 20) {
                                        return '#fe4365';
                                    } else {
                                        return '#25daba';
                                    }
                                },
                                lineStyle: {color: '#8cd5c2' }//改变折线颜色
                            }
                        },
                        data: y_hx_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:20mm',
                                        position:'middle',
                                    },
                                    yAxis: '20',
                                    lineStyle: {
                                        color: '#900',
                                        type: 'solid'
                                    },
                                    name: '报警值'
                                }
                            ]
                        }
                    },
                    /*{
                        name:'黄兴镇',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                lineStyle: {color: '#8cd5c2' }//改变折线颜色
                            }
                        },
                        data: y_data,
                    },*/
                    {
                        name:'黄花镇',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_hh_data) {
                                    var index_color = y_hh_data.value;

                                    if (index_color >= 20) {
                                        return '#fe4365';
                                    } else {
                                        return '#25daba';
                                    }
                                },
                                lineStyle: {color: '#8cd5c2' }//改变折线颜色
                            }
                        },
                        data: y_hh_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:20mm',
                                        position:'middle',
                                    },
                                    yAxis: '20',
                                    lineStyle: {
                                        color: '#900',
                                        type: 'solid'
                                    },
                                    name: '报警值'
                                }
                            ]
                        }
                    },
                    /*{
                        name:'黄花村',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                lineStyle: {color: '#8cd5c2' }//改变折线颜色
                            }
                        },
                        data: y_data,
                    },*/
                ]
            };
            rainsec.setOption(rain_option);
        }
    });
}

function init_wlevelsec() {
    var wlevelsec = echarts.init(document.getElementById('wlvlsec'));
    $.ajax({
        type: "GET",
        url: "/api/security/wlevel",
        datatype: "JSON",
        success: function (data) {
            var wlevelsec_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < wlevelsec_data.length; i++) {
                if (wlevelsec_data[i].wlevel == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseFloat(wlevelsec_data[i].wlevel));
                    x_data.push(wlevelsec_data[i].time);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            wlevel_option = {
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
                        itemStyle: {
                            normal: {
                                color: function (y_data) {
                                    var index_color = y_data.value;

                                    if (index_color >= 3600) {
                                        return '#fe4365';
                                    } else {
                                        return '#00BFFF';
                                    }
                                },
                                lineStyle: {color: '#00BFFF' }//改变折线颜色
                            }
                        },
                        data: y_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:3600mm',
                                        position:'middle',
                                    },
                                    yAxis:'3600',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                ]
            };
            wlevelsec.setOption(wlevel_option);
        }
    });
}

function init_tempsec() {
    var tempsec = echarts.init(document.getElementById('tempsec'));
    $.ajax({
        type: "GET",
        url: "/api/security/temp",
        datatype: "JSON",
        success: function (data) {
            var tempsec_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < tempsec_data.length; i++) {
                if (tempsec_data[i].temp == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseFloat(tempsec_data[i].temp));
                    x_data.push(tempsec_data[i].time);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            temp_option = {
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
                        itemStyle: {
                            normal: {
                                color: function (y_data) {
                                    var index_color = y_data.value;

                                    if (index_color >= 35) {
                                        return '#fe4365';
                                    }
                                     else if (index_color < 4) {
                                        return '#00BFFF';
                                    }
                                    else {
                                        return '#FFFF00';
                                    }
                                },
                                lineStyle: {color: '#FFFF00' }//改变折线颜色
                            }
                        },
                        data: y_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:35℃',
                                        position:'middle',
                                    },
                                    yAxis:'35',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                },
                                {
                                    label:{
                                        formatter:'预警值:4℃',
                                        position:'middle',
                                    },
                                    yAxis:'4',
                                    lineStyle:{
                                        color:'#87CEFA',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                ]
            };
            tempsec.setOption(temp_option);
        }
    });
}

function init_humsec() {
    var humsec = echarts.init(document.getElementById('humsec'));
    $.ajax({
        type: "GET",
        url: "/api/security/hum",
        datatype: "JSON",
        success: function (data) {
            var humsec_data = data.data;
            var x_data = new Array();
            var y_cs_data = new Array();
            var y_hx_data = new Array();
            var y_hh_data = new Array();
            for (var i = 0; i < humsec_data.length; i++) {
                if (humsec_data[i].hum == '') {
                    x_data.push('未知');
                }
                if (humsec_data[i].aid == '01') {
                    y_cs_data.push(humsec_data[i].hum);
                    x_data.push(humsec_data[i].time);
                }
            }
            for (var i = 0; i < humsec_data.length; i++) {
                if (humsec_data[i].hum == '') {
                    x_data.push('未知');
                }
                if (humsec_data[i].aid == '0101') {
                    y_hx_data.push(humsec_data[i].hum);
                    //x_data.push(humsec_data[i].time);
                }
            }
            for (var i = 0; i < humsec_data.length; i++) {
                if (humsec_data[i].hum == '') {
                    x_data.push('未知');
                }
                if(humsec_data[i].aid == '0102'){
                    y_hh_data.push(humsec_data[i].hum);
                    //x_data.push(humsec_data[i].time);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            hum_option = {
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
                legend:{
                    show:true,
                    selectedMode:'single',    //设置显示单一图例的图形，点击可切换
                    data:['长沙县','黄兴镇','黄花镇'],
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
                        name:'长沙县',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_cs_data) {
                                    var index_color = y_cs_data.value;

                                    if (index_color < 25) {
                                        return '#fe4365';
                                    }
                                    else if (index_color >= 80) {
                                        return '#00BFFF';
                                    }
                                    else {
                                        return '#7CFC00';
                                    }
                                },
                                lineStyle: {color: '#7CFC00' }//改变折线颜色
                            }
                        },
                        data: y_cs_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:80%',
                                        position:'middle',
                                    },
                                    yAxis:'80',
                                    lineStyle:{
                                        color:'#00BFFF',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                },
                                {
                                    label:{
                                        formatter:'预警值:25%',
                                        position:'middle',
                                    },
                                    yAxis:'25',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                    {
                        name:'黄兴镇',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_hx_data) {
                                    var index_color = y_hx_data.value;

                                    if (index_color < 25) {
                                        return '#fe4365';
                                    }
                                    else if (index_color >= 80) {
                                        return '#00BFFF';
                                    }
                                    else {
                                        return '#7CFC00';
                                    }
                                },
                                lineStyle: {color: '#7CFC00' }//改变折线颜色
                            }
                        },
                        data: y_hx_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:80%',
                                        position:'middle',
                                    },
                                    yAxis:'80',
                                    lineStyle:{
                                        color:'#00BFFF',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                },
                                {
                                    label:{
                                        formatter:'预警值:25%',
                                        position:'middle',
                                    },
                                    yAxis:'25',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                    {
                        name:'黄花镇',
                        type: 'line',
                        itemStyle: {
                            normal: {
                                color: function (y_hh_data) {
                                    var index_color = y_hh_data.value;

                                    if (index_color < 25) {
                                        return '#fe4365';
                                    }
                                    else if (index_color >= 80) {
                                        return '#00BFFF';
                                    }
                                    else {
                                        return '#7CFC00';
                                    }
                                },
                                lineStyle: {color: '#7CFC00' }//改变折线颜色
                            }
                        },
                        data: y_hh_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:80%',
                                        position:'middle',
                                    },
                                    yAxis:'80',
                                    lineStyle:{
                                        color:'#00BFFF',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                },
                                {
                                    label:{
                                        formatter:'预警值:25%',
                                        position:'middle',
                                    },
                                    yAxis:'25',
                                    lineStyle:{
                                        color:'#900',
                                        type: 'solid'
                                    },
                                    name:'报警值'
                                }
                            ]
                        }
                    },
                ]
            };
            humsec.setOption(hum_option);
        }
    });
}

function init_envsectype() {
    var envsectype = echarts.init(document.getElementById('envsectype'));
    $.ajax({
        type: "GET",
        url: "/api/security/envsectype",
        datatype: "JSON",
        success: function (data) {
            var envsectype_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < envsectype_data.length; i++) {
                if (envsectype_data[i].marea == '') {
                    x_data.push('未知');
                } else {
                    x_data.push(envsectype_data[i].content);
                    y_data.push(parseInt(envsectype_data[i].secnum));
                    /*var y = new Object();
                     y.name = bdsygroup_data[i].scategory;
                     y.value = parseInt(bdsygroup_data[i].bcount);
                     y_data.push(y);*/
                }
            }
            /*console.log(bdsygroup_data);*/
            /*console.log(x_data);
             console.log(y_data);*/
            envsectype_option = {
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
                        name: '环境警报类型',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            /*y_data*/
                            {value: y_data[0], name: x_data[0]},
                            {value: y_data[1], name: x_data[1]},
                            {value: y_data[2], name: x_data[2]},
                            {value: y_data[3], name: x_data[3]},
                            {value: y_data[4], name: x_data[4]},
                        ]
                    }
                ]
            };
            envsectype.setOption(envsectype_option);
        }
    });
}

function init_watsectype() {
    var watsectype = echarts.init(document.getElementById('watsectype'));
    $.ajax({
        type: "GET",
        url: "/api/security/watsectype",
        datatype: "JSON",
        success: function (data) {
            var watsectype_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < watsectype_data.length; i++) {
                if (watsectype_data[i].marea == '') {
                    x_data.push('未知');
                } else {
                    x_data.push(watsectype_data[i].content);
                    y_data.push(parseInt(watsectype_data[i].secnum));
                    /*var y = new Object();
                     y.name = bdsygroup_data[i].scategory;
                     y.value = parseInt(bdsygroup_data[i].bcount);
                     y_data.push(y);*/
                }
            }
            /*console.log(bdsygroup_data);*/
            /*console.log(x_data);
             console.log(y_data);*/
            watsectype_option = {
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
                        name: '水质警报类型',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            /*y_data*/
                            {value: y_data[0], name: x_data[0]},
                            {value: y_data[1], name: x_data[1]},
                            {value: y_data[2], name: x_data[2]},
                            {value: y_data[3], name: x_data[3]},
                            /*{value: y_data[4], name: x_data[4]},*/
                        ]
                    }
                ]
            };
            watsectype.setOption(watsectype_option);
        }
    });
}

function init_3d_watersec() {

    var pre_data;
    var area_group = new Array();
    var data_group = new Array();
    var xyz_data = new Array();
    var ec_3d_bt= echarts.init(document.getElementById('watersec'));

    $.ajax({
        type: "GET",
        url: "/api/security/water",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            var dp_temp = ['ndata','pdata','qdata','sdata','fudata'];
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].stime);
            }
            //确定xyz_data
            for( pg_name in pre_data){
                var ag = area_group.indexOf(pre_data[pg_name].stime);
                var temp_data = pre_data[pg_name];
                delete temp_data["stime"];
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
                if(dp_temp[item].indexOf('ndata') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('ndata','总氮含量');
                }else if(dp_temp[item].indexOf('pdata') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('pdata','总磷含量');
                }else if (dp_temp[item].indexOf('qdata') >= 0 ) {
                    dp_temp[item] = dp_temp[item].replace('qdata','氰化物含量');
                }else if(dp_temp[item].indexOf('sdata') >= 0){
                    dp_temp[item] = dp_temp[item].replace('sdata','硫化物含量');
                } else if(dp_temp[item].indexOf('fudata') >= 0){
                    dp_temp[item] = dp_temp[item].replace('fudata','氟化物含量');
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
                    max: 5,
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
                    boxWidth: 200,
                    boxDepth: 55,
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
                        },
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
                },
                ]
            };
            ec_3d_bt.setOption(ec_3d_bt_option);
        }
    })
}

function sort_3d_watersec() {

    var pre_data;
    var area_group = new Array();
    var data_group = new Array();
    var xyz_data = new Array();
    var ec_3d_bt= echarts.init(document.getElementById('watersec'));

    $.ajax({
        type: "GET",
        url: "/api/security/water",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            var dp_temp = ['ndata','pdata','qdata','sdata','fudata'];
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].stime);
            }
            //确定xyz_data
            for( pg_name in pre_data){
                var ag = area_group.indexOf(pre_data[pg_name].stime);
                var temp_data = pre_data[pg_name];
                delete temp_data["stime"];
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
                if(dp_temp[item].indexOf('ndata') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('ndata','总氮含量');
                }else if(dp_temp[item].indexOf('pdata') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('pdata','总磷含量');
                }else if (dp_temp[item].indexOf('qdata') >= 0 ) {
                    dp_temp[item] = dp_temp[item].replace('qdata','氰化物含量');
                }else if(dp_temp[item].indexOf('sdata') >= 0){
                    dp_temp[item] = dp_temp[item].replace('sdata','硫化物含量');
                } else if(dp_temp[item].indexOf('fudata') >= 0){
                    dp_temp[item] = dp_temp[item].replace('fudata','氟化物含量');
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
                    max: 5,
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
                    boxWidth: 200,
                    boxDepth: 55,
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

function init_bacsec() {
    var bacsec = echarts.init(document.getElementById('bacsec'));
    $.ajax({
        type: "GET",
        url: "/api/security/bac",
        datatype: "JSON",
        success: function (data) {
            var bacsec_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for (var i = 0; i < bacsec_data.length; i++) {
                if (bacsec_data[i].bacdata == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(bacsec_data[i].bacdata));
                    x_data.push(bacsec_data[i].stime);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            bac_option = {
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
                        itemStyle: {
                            normal: {
                                color: function (y_data) {
                                    var index_color = y_data.value;

                                    if (index_color >= 2500) {
                                        return '#fe4365';
                                    } else {
                                        return '#25daba';
                                    }
                                },
                                lineStyle: {color: '#8cd5c2' }//改变折线颜色
                            }
                        },
                        data: y_data,
                        markLine: {
                            data: [
                                {
                                    label:{
                                        formatter:'预警值:2500',
                                        position:'middle',
                                    },
                                    yAxis: '2500',
                                    lineStyle: {
                                        color: '#900',
                                        type: 'solid'
                                    },
                                    name: '报警值'
                                }
                            ]
                        }
                    }
                ]
            };

            bacsec.setOption(bac_option);
        }
    });
}
/*function init_bd_sec(){
    $.ajax({
        type: "GET",
        url: "/api/iot/sec",
        dataType: "json",
        success: function (data) {
            $("#sec_flush_time").html('<span>' + data.time + ' 更新' +
                '</span>');
            var l_sec = data.data;
            var mid = '';
            for (sec in l_sec){
                mid += '<tr>' +
                    '<td>' + l_sec[sec].mid +
                    '</td>' +
                    '<td>' + l_sec[sec].content +
                    '</td>' +
                    '</tr>';
            }

            $("#sec_log").html('<table class="table table-hover">' +
                '<thead>' +
                '<tr>' +
                '<th>序号</th>' +
                '<th>状态</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' + mid +
                '</tbody>' +
                '</table>');
        }
    })
}*/