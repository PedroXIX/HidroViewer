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
import raven.chart.line.LineChart;
import raven.chart.pie.PieChart;
import view.tabbed.TabbedForm;

/**
 * Painel que exibe as informações de consumo geral de acordo com a base de dados
 *
 * @author Pedro
 */
public class ConsumoForm extends TabbedForm {

    private LineChart lineChart;
    private HorizontalBarChart barChart1;
    private HorizontalBarChart barChart2;
    private PieChart pieChart1;
    private PieChart pieChart2;
    private PieChart pieChart3;

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

    /**
     * Método que adiciona os gráficos de pizza no painel
     */
    private void createPieChartsPanel() {
        JPanel pieChartsPanel = new JPanel(new MigLayout("fill, insets 0", "[33%][33%][33%]", "[]"));

        pieChart1 = createPieChartMes("CONSUMO MENSAL");
        pieChartsPanel.add(pieChart1, "cell 0 0, grow");

        pieChart2 = createPieChartEstacao("CONSUMO SAZONAL " + GraficosDAO.anoConsumo(1));
        pieChartsPanel.add(pieChart2, "cell 1 0, grow");

        pieChart3 = createPieChartAno("CONSUMO ANUAL");
        pieChart3.setChartType(PieChart.ChartType.DONUT_CHART);
        pieChartsPanel.add(pieChart3, "cell 2 0, grow");

        add(new JScrollPane(pieChartsPanel), "grow, height 290");
    }

    /**
     * Método que cria um gráfico de pizza com dados referentes ao consumo dos 5
     * últimos meses, com base no momento atual
     *
     * @param headerText - cabeçalho do gráfico
     * @return - gráfico gerado
     */
    private PieChart createPieChartMes(String headerText) {
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
        pieChart.setDataset(GraficosDAO.createDataMes());
        return pieChart;
    }

    /**
     * Método que cria um gráfico de pizza com dados referentes ao consumo dos 5
     * últimos anos, a partir do ano anterior ao atual
     *
     * @param headerText - cabeçalho do gráfico
     * @return - gráfico gerado
     */
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
        pieChart.setDataset(GraficosDAO.createDataAno());
        return pieChart;
    }

    /**
     * Método que cria um gráfico de pizza com dados referentes ao consumo das
     * estações últimos anos, a partir do ano anterior ao atual
     *
     * @param headerText - cabeçalho do gráfico
     * @return - gráfico gerado
     */
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
        pieChart.setDataset(GraficosDAO.createPieDataEstacao());
        return pieChart;
    }

    /**
     * Método que adiciona o gráfico de linha no painel
     */
    private void createLineChart() {
        lineChart = new LineChart();
        lineChart.setChartType(LineChart.ChartType.CURVE);
        applyStyle(lineChart);
        add(new JScrollPane(lineChart), "span, height 300");
        createLineChartData();
    }

    /**
     * Método que adiciona os gráficos de barra no painel
     */
    private void createBarChart() {
        // BarChart 1
        barChart1 = new HorizontalBarChart();
        JLabel header1 = new JLabel("Consumo Mensal");
        header1.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        barChart1.setHeader(header1);
        barChart1.setBarColor(Color.decode("#1f77b4"));
        barChart1.setDataset(GraficosDAO.createDataMes());
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
        barChart2.setDataset(GraficosDAO.createDataAno());
        //barChart2.setValuesFormat(new DecimalFormat("#,#0.00"));
        JPanel panel2 = new JPanel(new BorderLayout());
        applyStyle(panel2);
        panel2.add(barChart2);
        add(new JScrollPane(panel2), "height 300");
    }
    
      /**
     * Método que determina os dados anuais do gráfico de linha
     */
    private void createLineChartData() {
        DefaultCategoryDataset<String, String> categoryDataset = new DefaultCategoryDataset<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        for (int i = GraficosDAO.qtdMes() - 1; i >= 0; i--) {
            String date = df.format(GraficosDAO.mesData(i));
            categoryDataset.addValue(GraficosDAO.mesConsumo(i), "Consumo(atual)", date);
            categoryDataset.addValue(GraficosDAO.mesConsumo(i, 1), GraficosDAO.ano(1), date);
            categoryDataset.addValue(GraficosDAO.mesConsumo(i, 2), GraficosDAO.ano(2), date);
            cal.add(Calendar.DATE, 1);
        }

        lineChart.setCategoryDataset(categoryDataset);
        lineChart.getChartColor().addColor(Color.decode("#6baed6"), Color.decode("#4292c6"), Color.decode("#2171b5"));
        JLabel header = new JLabel("Consumo ao longo dos meses");
        header.putClientProperty(FlatClientProperties.STYLE, "font:+1; border:0,0,5,0");
        lineChart.setHeader(header);
    }

    /**
     * Método que aplica os padrões de formatação a um objeto JPanel
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
            if (component instanceof JLabel jLabel) {
                jLabel.putClientProperty(FlatClientProperties.STYLE, ""
                        + "font:+1;"
                        + "foreground:$Component.foreground;");
            }
        }
    }

    @Override
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
