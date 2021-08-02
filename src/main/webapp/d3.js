let tooltip = d3.select('body')
    .append('div')
    .style('z-index', '10')
    .style('position', 'absolute')
    .style('color', '#010507')
    .style('visibility', 'hidden')
    .style('font-size', '15px')
    .style('font-weight', 'bold')
    .style('border','solid 1px')
    .text('')
window.onload = function () {
    var width = 600;
    var height = 300;
    var svgCanvas = d3.select("svg")
        .attr("width",width)
        .attr("height",height)
        .attr("class","svgCanvas");
    var margin = {top:10,right:20,bottom:30,left:50};
    width = width-margin.left-margin.right;
    height = height-margin.top-margin.bottom;
    var barChartArea = svgCanvas
        .append("g")
        .attr("transform", "translate("+margin.left+","+margin.top+")");
    var y = d3.scaleLinear()
        .rangeRound([height,0]);
    var x = d3.scaleLinear()
        .rangeRound([0,width]);
    d3.csv("d3.csv",function (d) {
        console.log(d);
        var minValue = Infinity;
        var maxValue = -1;
        var WeekdayArray = new Array();
        var WeekendArray = new Array();
        d.forEach(function (thisD) {
            var thisValue = thisD["HourlyAverage"];
            minValue = Math.min(minValue,thisValue);
            maxValue = Math.max(maxValue,thisValue);
            if (thisD["Day"]=="Weekday"){
                WeekdayArray.push(thisD);
            }else {
                WeekendArray.push(thisD);
            }
        });
        x.domain([0,24]);
        y.domain([minValue,maxValue+200]);
        barChartArea.append("g")
            .attr("class","axis")
            .attr("transform","translate(0,"+height+")")
            .call(d3.axisBottom(x));
        barChartArea.append("g")
            .attr("class","axis")
            .call(d3.axisLeft(y).ticks(null,"s"));
        barChartArea.selectAll("circle")
            .data(d).enter()
            .append("circle")
            .attr("cx",function (thisElement) {
                return x(thisElement["TimeOfDay"]);
            })
            .attr("cy",function (thisElement) {
                return y(thisElement["HourlyAverage"]);
            })
            .attr("r",5)
            .attr("fill",function (thisElement,index) {
                if (thisElement["Day"]=="Weekday")
                    return "red";
                else return "lightgreen";
            })
            .on("mouseover",function (thisElement,index) {
                return tooltip.style('visibility', 'visible').text('Day:'+thisElement["Day"]+"  TimeOfDay:"+thisElement["TimeOfDay"]+"  HourlyAverage:"+thisElement["HourlyAverage"]);
            })
            .on("mousemove",function (thisElement,index) {
                return tooltip.style('top', (event.pageY-10)+'px').style('left',(event.pageX+10)+'px');
            })
            .on('mouseout', function (thisElement, index) {
                return tooltip.style('visibility', 'hidden');
            });

        // 添加折线
        var line = d3.line()
            .x(function(d) {
                return x(d.TimeOfDay)
            })
            .y(function(d) {
                return y(d.HourlyAverage);
            });
        barChartArea.append("path")
            .attr("class","redpath")
            .attr("d", line(WeekdayArray));
        barChartArea.append("path")
            .attr("class","greenpath")
            .attr("d", line(WeekendArray));
    });
};