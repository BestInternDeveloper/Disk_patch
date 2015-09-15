package demo;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
public class LineChartDemo5 extends ApplicationFrame
{
    public LineChartDemo5(String s, ArrayList<Integer> list1,
                                    ArrayList<Integer> list2,
                                    ArrayList<Integer> list3,
                                    ArrayList<Integer> list4,int TracksNum)
    {
        super(s);
        CategoryDataset categorydataset = createDataset(list1,list2,list3,list4,TracksNum);
        JFreeChart jfreechart = createChart(categorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartpanel);
    }
    private static CategoryDataset createDataset(ArrayList<Integer> list1,
                                                    ArrayList<Integer> list2,
                                                    ArrayList<Integer> list3,
                                                    ArrayList<Integer> list4,int TracksNum)
            
    {
        String s1 = "FCFS";
        String s2 = "SSTF";
        String s3 = "SCAN";
        String s4 = "CSCAN";
        //s3-s10   (type3-type10)
        ArrayList<String> Types = new ArrayList<String>();
        for(int i = 0;i<TracksNum;i++){
            Types.add("Time "+i);
            System.out.println(Types.get(i));   
            System.out.println(list1.get(i));
        }  
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for(int i=0;i<TracksNum;i++){
            defaultcategorydataset.addValue(list1.get(i), s1, Types.get(i));
        }
        for(int i=0;i<TracksNum;i++){
            System.out.println(list2.get(i));
            defaultcategorydataset.addValue(list2.get(i), s2, Types.get(i));
        }
        for(int i=0;i<TracksNum;i++){
            System.out.println(list3.get(i));
            defaultcategorydataset.addValue(list3.get(i), s3, Types.get(i));
        }
        for(int i=0;i<TracksNum;i++){
            System.out.println(list4.get(i));
            defaultcategorydataset.addValue(list4.get(i), s4, Types.get(i));
        }
        return defaultcategorydataset;
    }
    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createLineChart("Disk Dispatch----Made By HuSong", "Time", "Track", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        Shape ashape[] = new Shape[3];
        int ai[] = {
            -3, 3, -3
        };
        int ai1[] = {
            -3, 0, 3
        };
        ashape[0] = new Polygon(ai, ai1, 3);
        ashape[1] = new java.awt.geom.Rectangle2D.Double(-2D, -3D, 3D, 6D);
        ai = (new int[] {
            -3, 3, 3
        });
        ai1 = (new int[] {
            0, -3, 3
        });
        ashape[2] = new Polygon(ai, ai1, 3);
        DefaultDrawingSupplier defaultdrawingsupplier = new DefaultDrawingSupplier(DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE, DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE, ashape);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setOrientation(PlotOrientation.HORIZONTAL);
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);
        categoryplot.setDrawingSupplier(defaultdrawingsupplier);
        categoryplot.getRenderer().setSeriesStroke(0, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
            10F, 6F
        }, 0.0F));
        categoryplot.getRenderer().setSeriesStroke(1, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
            6F, 6F
        }, 0.0F));
        categoryplot.getRenderer().setSeriesStroke(2, new BasicStroke(2.0F, 1, 1, 1.0F, new float[] {
            2.0F, 6F
        }, 0.0F));
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setShapesVisible(true);
        lineandshaperenderer.setBaseItemLabelsVisible(true);
        lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setUpperMargin(0.12D);
        return jfreechart;
    }

}