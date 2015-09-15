/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.windows;

import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author husong
 */
public class Chart extends ApplicationFrame{
    public static void main(String args[]) {
        Chart fjc = new Chart("Demo");
        fjc.pack(); 
        RefineryUtilities.centerFrameOnScreen(fjc);
        fjc.setVisible(true); 

    }
    public static JPanel createDemoPanel(){
            JFreeChart jfreechart = createChart(createDataset());
            return new ChartPanel(jfreechart);
    } 
    public static JFreeChart createChart(XYDataset dataset){  
          //定义图表对象   
         JFreeChart jfreechart = ChartFactory.createXYLineChart("XYLine Chart Demo",// 标题   
              "磁道", // categoryAxisLabel （category轴，横轴，X轴标签）      
             "数量", // valueAxisLabel（value轴，纵轴，Y轴的标签）      
             dataset, // dataset      
             PlotOrientation.VERTICAL,   
             true, // legend      
             false, // tooltips      
             false); // URLs   
         // 使用CategoryPlot设置各种参数。以下设置可以省略。      
         XYPlot plot = (XYPlot) jfreechart.getPlot();      
         // 背景色 透明度      
         plot.setBackgroundAlpha(0.5f);      
         return jfreechart;
      } 
    //生成折线图数据集对象 
    public static XYDataset createDataset(){ 
        XYSeries xyseries1 = new XYSeries("FCFS");      
        xyseries1.add(1987, 50);      
        xyseries1.add(1997, 20);      
        xyseries1.add(2007, 30);      
        
        XYSeries xyseries2 = new XYSeries("Two");      
        xyseries2.add(1987, 20);      
        xyseries2.add(1997, 10D);      
        xyseries2.add(2007, 40D);      
 
 
        XYSeries xyseries3 = new XYSeries("Three");      
        xyseries3.add(1987, 40);      
        xyseries3.add(1997, 30.0008);      
        xyseries3.add(2007, 38.24);      
 
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();      
        xySeriesCollection.addSeries(xyseries1);      
        xySeriesCollection.addSeries(xyseries2);      
        xySeriesCollection.addSeries(xyseries3);      
        return xySeriesCollection;     
}

    public Chart(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }
}
