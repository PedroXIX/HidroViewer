package view.form;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import raven.chart.bar.HorizontalBarChart;
import raven.chart.data.category.DefaultCategoryDataset;
import raven.chart.data.pie.DefaultPieDataset;
import raven.chart.line.LineChart;
import raven.chart.pie.PieChart;
import view.tabbed.TabbedForm;

/**
 *
 * @author RAVEN
 */
public class ConsumoForm extends TabbedForm {

    private LineChart lineChart;
    private HorizontalBarChart barChart1;
    private HorizontalBarChart barChart2;
    private PieChart pieChart1;
    private PieChart pieChart2;
    private PieChart pieChart3;

    /**
     * Creates new form TestForm
     */


    public ConsumoForm() {
        initComponents();
        init();
    }

    @Override
    public void init() {
        setLayout(new MigLayout("wrap, fill, gap 10", "[fill]"));
        createPieChartsPanel();
        createLineChart();
        createBarChart();
    }

    private void createPieChartsPanel() {
        JPanel pieChartsPanel = new JPanel(new MigLayout("fill, insets 0", "[33%][33%][33%]", "[]"));

        pieChart1 = createPieChart("CONSUMO MENSAL");
        pieChartsPanel.add(pieChart1, "cell 0 0, grow");

        pieChart2 = createPieChart("CONSUMO ANUAL");
        pieChartsPanel.add(pieChart2, "cell 1 0, grow");

        pieChart3 = createPieChart("CONSUMO DE ACORDO COM A CIDADE");
        pieChart3.setChartType(PieChart.ChartType.DONUT_CHART);
        pieChartsPanel.add(pieChart3, "cell 2 0, grow");

        add(new JScrollPane(pieChartsPanel), "grow, height 290");
    }

    private PieChart createPieChart(String headerText) {
        PieChart pieChart = new PieChart();
        JLabel header = new JLabel(headerText);
        header.putClientProperty(FlatClientProperties.STYLE, "font:+1");
        pieChart.setHeader(header);
        pieChart.getChartColor().addColor(
                Color.decode("#f87171"),
                Color.decode("#fb923c"),
                Color.decode("#fbbf24"),
                Color.decode("#a3e635"),
                Color.decode("#34d399"),
                Color.decode("#22d3ee"),
                Color.decode("#818cf8"),
                Color.decode("#c084fc")
        );
        applyStyle(pieChart);
        pieChart.setDataset(createPieData());
        return pieChart;
    }

    private void createLineChart() {
        lineChart = new LineChart();
        lineChart.setChartType(LineChart.ChartType.CURVE);
        applyStyle(lineChart);
        add(new JScrollPane(lineChart), "span, height 300");
        createLineChartData();
    }

    private void createBarChart() {
        // BarChart 1
        barChart1 = new HorizontalBarChart();
        JLabel header1 = new JLabel("Monthly Income");
        header1.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        barChart1.setHeader(header1);
        barChart1.setBarColor(Color.decode("#f97316"));
        barChart1.setDataset(createData());
        JPanel panel1 = new JPanel(new BorderLayout());
        applyStyle(panel1);
        panel1.add(barChart1);
        add(new JScrollPane(panel1), "split 2, gap 0 20, height 300");

        // BarChart 2
        barChart2 = new HorizontalBarChart();
        JLabel header2 = new JLabel("Monthly Expense");
        header2.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        barChart2.setHeader(header2);
        barChart2.setBarColor(Color.decode("#10b981"));
        barChart2.setDataset(createData());
        JPanel panel2 = new JPanel(new BorderLayout());
        applyStyle(panel2);
        panel2.add(barChart2);
        add(new JScrollPane(panel2), "height 300");
    }

    private DefaultPieDataset createData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        Random random = new Random();
        dataset.addValue("July (ongoing)", random.nextInt(100));
        dataset.addValue("June", random.nextInt(100));
        dataset.addValue("May", random.nextInt(100));
        dataset.addValue("April", random.nextInt(100));
        dataset.addValue("March", random.nextInt(100));
        dataset.addValue("February", random.nextInt(100));
        return dataset;
    }

    private DefaultPieDataset createPieData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        Random random = new Random();
        dataset.addValue("Bags", random.nextInt(100) + 50);
        dataset.addValue("Hats", random.nextInt(100) + 50);
        dataset.addValue("Glasses", random.nextInt(100) + 50);
        dataset.addValue("Watches", random.nextInt(100) + 50);
        dataset.addValue("Jewelry", random.nextInt(100) + 50);
        return dataset;
    }

    private void createLineChartData() {
        DefaultCategoryDataset<String, String> categoryDataset = new DefaultCategoryDataset<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        Random ran = new Random();
        int randomDate = 30;
        for (int i = 1; i <= randomDate; i++) {
            String date = df.format(cal.getTime());
            categoryDataset.addValue(ran.nextInt(700) + 5, "Income", date);
            categoryDataset.addValue(ran.nextInt(700) + 5, "Expense", date);
            categoryDataset.addValue(ran.nextInt(700) + 5, "Profit", date);
            cal.add(Calendar.DATE, 1);
        }

        lineChart.setCategoryDataset(categoryDataset);
        lineChart.getChartColor().addColor(Color.decode("#38bdf8"), Color.decode("#fb7185"), Color.decode("#34d399"));
        JLabel header = new JLabel("Income Data");
        header.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        lineChart.setHeader(header);
    }

    private void applyStyle(JPanel panel) {
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:5,5,5,5,$Component.borderColor;"
                + "background:$Component.background;"
                + "font:$Component.font;"
                + "foreground:$Component.foreground"
               );
        for (var component : panel.getComponents()) {
            if (component instanceof JLabel) {
                ((JLabel) component).putClientProperty(FlatClientProperties.STYLE, ""
                        + "font:+1;"
                        + "foreground:$Component.foreground;");
            }
        }
    }

    public void formOpen() {
        System.out.println("Form open");
        lineChart.startAnimation();
        pieChart1.startAnimation();
        pieChart2.startAnimation();
        pieChart3.startAnimation();
        barChart1.startAnimation();
        barChart2.startAnimation();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
