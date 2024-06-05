package view.form;

import com.formdev.flatlaf.FlatClientProperties;
import controllers.GraficosDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

        pieChart2 = createPieChartEstacao("CONSUMO SAZONAL");
        pieChartsPanel.add(pieChart2, "cell 1 0, grow");

        pieChart3 = createPieChartAno("CONSUMO ANUAL");
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
                Color.decode("#1f77b4"),
                Color.decode("#4292c6"),
                Color.decode("#6baed6"),
                Color.decode("#9ecae1"),
                Color.decode("#a9cfe9"));
        applyStyle(pieChart);
        pieChart.setDataset(createPieData());
        return pieChart;
    }

    private PieChart createPieChartAno(String headerText) {
        PieChart pieChart = new PieChart();
        JLabel header = new JLabel(headerText);
        header.putClientProperty(FlatClientProperties.STYLE, "font:+1");
        pieChart.setHeader(header);
        pieChart.getChartColor().addColor(
                Color.decode("#6baed6"),
                Color.decode("#4292c6"),
                Color.decode("#2171b5"),
                Color.decode("#08519c"),
                Color.decode("#08306b"));
        applyStyle(pieChart);
        pieChart.setDataset(createPieDataAno());
        return pieChart;
    }

    private PieChart createPieChartEstacao(String headerText) {
        PieChart pieChart = new PieChart();
        JLabel header = new JLabel(headerText);
        header.putClientProperty(FlatClientProperties.STYLE, "font:+1");
        pieChart.setHeader(header);
        pieChart.getChartColor().addColor(              
                Color.decode("#6baed6"),
                Color.decode("#4292c6"),
                Color.decode("#2171b5"),
                Color.decode("#084594"));
        applyStyle(pieChart);
        pieChart.setDataset(createPieDataEstacao());
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
        JLabel header1 = new JLabel("Consumo Mensal");
        header1.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        barChart1.setHeader(header1);
        barChart1.setBarColor(Color.decode("#1f77b4"));
        barChart1.setDataset(createData());
        JPanel panel1 = new JPanel(new BorderLayout());
        applyStyle(panel1);
        panel1.add(barChart1);
        add(new JScrollPane(panel1), "split 2, gap 0 20, height 300");

        // BarChart 2
        barChart2 = new HorizontalBarChart();
        JLabel header2 = new JLabel("Consumo Anual");
        header2.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        barChart2.setHeader(header2);
        barChart2.setBarColor(Color.decode("#6baed6"));
        barChart2.setDataset(createDataAno());
        JPanel panel2 = new JPanel(new BorderLayout());
        applyStyle(panel2);
        panel2.add(barChart2);
        add(new JScrollPane(panel2), "height 300");
    }

    private DefaultPieDataset createData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue(GraficosDAO.mes(0) + " (Atual)", GraficosDAO.mesConsumo(0));
        dataset.addValue(GraficosDAO.mes(1), GraficosDAO.mesConsumo(1));
        dataset.addValue(GraficosDAO.mes(2), GraficosDAO.mesConsumo(2));
        dataset.addValue(GraficosDAO.mes(3), GraficosDAO.mesConsumo(3));
        dataset.addValue(GraficosDAO.mes(4), GraficosDAO.mesConsumo(4));
        return dataset;
    }

    private DefaultPieDataset createDataAno() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue(GraficosDAO.ano(1) + " (Atual)", GraficosDAO.anoConsumo(1));
        dataset.addValue(GraficosDAO.ano(2), GraficosDAO.anoConsumo(2));
        dataset.addValue(GraficosDAO.ano(3), GraficosDAO.anoConsumo(3));
        dataset.addValue(GraficosDAO.ano(4), GraficosDAO.anoConsumo(4));
        dataset.addValue(GraficosDAO.ano(5), GraficosDAO.anoConsumo(5));
        return dataset;
    }

    private DefaultPieDataset createPieData() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue(GraficosDAO.mes(0) + " (Atual)", GraficosDAO.mesConsumo(0));
        dataset.addValue(GraficosDAO.mes(1), GraficosDAO.mesConsumo(1));
        dataset.addValue(GraficosDAO.mes(2), GraficosDAO.mesConsumo(2));
        dataset.addValue(GraficosDAO.mes(3), GraficosDAO.mesConsumo(3));
        dataset.addValue(GraficosDAO.mes(4), GraficosDAO.mesConsumo(4));
        return dataset;
    }

    private DefaultPieDataset createPieDataEstacao() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue("Verão", GraficosDAO.estacaoConsumo(0));
        dataset.addValue("Outono", GraficosDAO.estacaoConsumo(1));
        dataset.addValue("Inverno", GraficosDAO.estacaoConsumo(2));
        dataset.addValue("Primavera", GraficosDAO.estacaoConsumo(3));
        return dataset;
    }

    private DefaultPieDataset createPieDataAno() {
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.addValue(GraficosDAO.ano(1), GraficosDAO.anoConsumo(1));
        dataset.addValue(GraficosDAO.ano(2), GraficosDAO.anoConsumo(2));
        dataset.addValue(GraficosDAO.ano(3), GraficosDAO.anoConsumo(3));
        dataset.addValue(GraficosDAO.ano(4), GraficosDAO.anoConsumo(4));
        dataset.addValue(GraficosDAO.ano(5), GraficosDAO.anoConsumo(5));
        return dataset;
    }

    private void createLineChartData() {
        DefaultCategoryDataset<String, String> categoryDataset = new DefaultCategoryDataset<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        for (int i = GraficosDAO.qtdMes() - 1; i >= 0; i--) {
            String date = df.format(GraficosDAO.mesData(i));
            categoryDataset.addValue(GraficosDAO.mesConsumo(i), "Consumo", date);
            categoryDataset.addValue(GraficosDAO.mesConsumo(i, 1), "2024", date);
            categoryDataset.addValue(GraficosDAO.mesConsumo(i, 2), "2023", date);
            cal.add(Calendar.DATE, 1);
        }

        lineChart.setCategoryDataset(categoryDataset);
        lineChart.getChartColor().addColor(                Color.decode("#6baed6"));
            lineChart.getChartColor().addColor(    Color.decode("#4292c6"));
            lineChart.getChartColor().addColor(     Color.decode("#2171b5"));
        JLabel header = new JLabel("Consumo ao longo dos meses");
        header.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        lineChart.setHeader(header);
    }

    /**
     * Aplica os padrões de formatação a um objeto JPanel
     *
     * @param panel - objeto que será formatado
     */
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
