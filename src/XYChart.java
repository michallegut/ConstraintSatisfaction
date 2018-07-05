import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.Range;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class XYChart extends ApplicationFrame {
    private final XYSeriesCollection dataSet;
    private final XYSeries firstSeries;
    private final XYSeries secondSeries;
    private final XYSeries thirdSeries;
    private String chartTitle;
    private String yAxisLabel;
    private boolean generateThirdSeries;

    XYChart(String applicationTitle, String firstSeriesName, String secondSeriesName, String thirdSeriesName, String chartTitle, String yAxisLabel, boolean generateThirdSeries) {
        super(applicationTitle);
        this.chartTitle = chartTitle;
        dataSet = new XYSeriesCollection();
        firstSeries = new XYSeries(firstSeriesName);
        secondSeries = new XYSeries(secondSeriesName);
        thirdSeries = new XYSeries(thirdSeriesName);
        this.yAxisLabel = yAxisLabel;
        this.generateThirdSeries = generateThirdSeries;
    }

    XYSeries getFirstSeries() {
        return firstSeries;
    }

    XYSeries getSecondSeries() {
        return secondSeries;
    }

    XYSeries getThirdSeries() {
        return thirdSeries;
    }

    void generateChart() {
        dataSet.addSeries(firstSeries);
        dataSet.addSeries(secondSeries);
        if (generateThirdSeries) {
            dataSet.addSeries(thirdSeries);
        }
        JFreeChart xyChart = ChartFactory.createXYLineChart(chartTitle, "Wielkość problemu N", yAxisLabel, dataSet, PlotOrientation.VERTICAL, true, true, false);
        xyChart.setTitle(new TextTitle(chartTitle,
                new Font("Arial", Font.BOLD, 12)));
        ChartPanel chartPanel = new ChartPanel(xyChart);
        chartPanel.setPreferredSize(new Dimension(1152, 648));
        final XYPlot plot = xyChart.getXYPlot();
        Range range = new Range(plot.getDataRange(plot.getRangeAxis()).getLowerBound() * 0.985, plot.getDataRange(plot.getRangeAxis()).getUpperBound() * 1.015);
        plot.getDomainAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        plot.getRangeAxis().setRange(range);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesFillPaint(0, Color.GREEN);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesFillPaint(1, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(1));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesShape(0, new Ellipse2D.Float(-1, -1, 2, 2));
        renderer.setSeriesShape(1, new Ellipse2D.Float(-2, -2, 4, 4));
        if (generateThirdSeries) {
            renderer.setSeriesPaint(2, Color.YELLOW);
            renderer.setSeriesFillPaint(2, Color.YELLOW);
            renderer.setSeriesStroke(2, new BasicStroke(3));
            renderer.setSeriesShape(2, new Ellipse2D.Float(-3, -3, 6, 6));
        }
        plot.setRenderer(renderer);
        setContentPane(chartPanel);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
}