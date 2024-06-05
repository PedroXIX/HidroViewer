package view.form;

import controllers.LeituraDAO;
import java.awt.Dimension;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import services.BD;
import services.MyTableModel;
import view.tabbed.TabbedForm;
import java.sql.SQLException;
import java.sql.Date;
import models.Leitura;

/**
 *
 * @author RAVEN
 */
public class CadastroLeituraForm extends TabbedForm {
    private LeituraDAO dao;
    private Leitura l;
    
    private DefaultTableModel model;
    private BD bd;

    /**
     * Creates new form TestForm
     */
    public CadastroLeituraForm() {
        dao = new LeituraDAO();
        l = new Leitura();
        bd = new BD();
        bd.getConnection();
        
        initComponents();
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbCodigoLeitura = new javax.swing.JLabel();
        tfCodigoLeitura = new javax.swing.JTextField();
        btnBuscarLeitura = new javax.swing.JButton();
        lblDataLeitura = new javax.swing.JLabel();
        tfDataLeitura = new javax.swing.JTextField();
        lblLeituraAnterior = new javax.swing.JLabel();
        tfLeituraAnterior = new javax.swing.JTextField();
        lblLeituraAtual = new javax.swing.JLabel();
        tfLeituraAtual = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfLocalizar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbCodigoHidrometro = new javax.swing.JLabel();
        tfCodigoHidrometro = new javax.swing.JTextField();
        btnBuscarHidrometro = new javax.swing.JButton();
        lblConsumo = new javax.swing.JLabel();
        tfConsumo = new javax.swing.JTextField();
        lblMediaConsumo = new javax.swing.JLabel();
        tfMediaConsumo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Crud Leituras");

        lbCodigoLeitura.setText("Codigo Leitura");

        tfCodigoLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoLeituraActionPerformed(evt);
            }
        });

        btnBuscarLeitura.setText("Buscar");
        btnBuscarLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLeituraActionPerformed(evt);
            }
        });

        lblDataLeitura.setText("Data Leitura");

        lblLeituraAnterior.setText("Leitura Anterior");

        lblLeituraAtual.setText("Leitura Atual");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tfLocalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfLocalizarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfLocalizarKeyReleased(evt);
            }
        });

        lbCodigoHidrometro.setText("Codigo Hidrometro");

        tfCodigoHidrometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoHidrometroActionPerformed(evt);
            }
        });

        btnBuscarHidrometro.setText("Buscar");
        btnBuscarHidrometro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarHidrometroActionPerformed(evt);
            }
        });

        lblConsumo.setText("Consumo");

        tfConsumo.setEnabled(false);

        lblMediaConsumo.setText("Média Consumo");

        tfMediaConsumo.setEnabled(false);

        atualizarGrade();
        table.setColumnSelectionAllowed(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnNovo)
                            .addGap(18, 18, 18)
                            .addComponent(btnSalvar)
                            .addGap(18, 18, 18)
                            .addComponent(btnExcluir))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblMediaConsumo)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfMediaConsumo, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblConsumo)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfConsumo))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLeituraAnterior)
                                        .addComponent(lblLeituraAtual))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfLeituraAnterior)
                                        .addComponent(tfLeituraAtual)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblDataLeitura)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfDataLeitura)))
                            .addGap(8, 8, 8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbCodigoHidrometro)
                                .addGap(18, 18, 18)
                                .addComponent(tfCodigoHidrometro, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbCodigoLeitura)
                                .addGap(18, 18, 18)
                                .addComponent(tfCodigoLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarHidrometro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(380, 380, 380)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                    .addComponent(tfLocalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE))
                .addContainerGap(753, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCodigoLeitura)
                            .addComponent(tfCodigoLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarLeitura))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCodigoHidrometro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarHidrometro)
                            .addComponent(lbCodigoHidrometro))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDataLeitura)
                            .addComponent(tfDataLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLeituraAnterior)
                            .addComponent(tfLeituraAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLeituraAtual)
                            .addComponent(tfLeituraAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConsumo)
                            .addComponent(tfConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMediaConsumo)
                            .addComponent(tfMediaConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnNovo)
                            .addComponent(btnExcluir)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(tfLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodigoLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoLeituraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoLeituraActionPerformed

    private void btnBuscarLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLeituraActionPerformed
        
        try{
            l = dao.localizar(Integer.parseInt(tfCodigoLeitura.getText()));
        if(l != null){
            tfCodigoHidrometro.setText(""+l.getCodHidrometro());
            tfDataLeitura.setText(""+l.getDataLeitura());
            tfLeituraAtual.setText(""+l.getLeituraAtual());
            tfLeituraAnterior.setText(""+l.getLeituraAnterior());
            tfConsumo.setText(""+l.getConsumo());
            tfMediaConsumo.setText(""+l.getMediaConsumo());
            
        }
        else{
            JOptionPane.showMessageDialog(btnBuscarLeitura, "Leitura não encontrada");
            limparCampos();
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(btnBuscarLeitura, "Erro ao consultar leitura: " + e);
        }
        
    }//GEN-LAST:event_btnBuscarLeituraActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tfLocalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLocalizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLocalizarKeyPressed

    private void tfLocalizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLocalizarKeyReleased
        try{
            String sql = "select * from leitura where cod_leitura like '%" + tfLocalizar.getText() + "%'";
            model = MyTableModel.getModel(bd, sql);
            table.setModel(model);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_tfLocalizarKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       tfCodigoLeitura.setText((String)table.getValueAt(table.getSelectedRow(), 0));
       tfCodigoHidrometro.setText((String)table.getValueAt(table.getSelectedRow(), 1));
       tfDataLeitura.setText((String)table.getValueAt(table.getSelectedRow(), 2));
       tfLeituraAnterior.setText((String)table.getValueAt(table.getSelectedRow(), 3));
       tfLeituraAtual.setText((String)table.getValueAt(table.getSelectedRow(), 4));
       tfConsumo.setText((String)table.getValueAt(table.getSelectedRow(), 5));
       tfMediaConsumo.setText((String)table.getValueAt(table.getSelectedRow(), 6));
       
      
    }//GEN-LAST:event_tableMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        try{
            int r = JOptionPane.showConfirmDialog(btnExcluir, "Tem certeza que deseja excluir a leitura selecionada?");
            if(r==0){
                JOptionPane.showMessageDialog(btnExcluir,
                 dao.excluir(Integer.parseInt(tfCodigoLeitura.getText())));
                limparCampos();
                atualizarGrade();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(btnExcluir, "Erro ao excluir leitura: " + e);
        }
        
        
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        try{
            
            l.setCodLeitura(Integer.parseInt(tfCodigoLeitura.getText()));
            l.setCodHidrometro(Integer.parseInt(tfCodigoHidrometro.getText()));
            Date date = Date.valueOf(tfDataLeitura.getText());
            l.setDataLeitura(date);
            l.setLeituraAnterior(Double.parseDouble(tfLeituraAnterior.getText()));
            l.setLeituraAtual(Double.parseDouble(tfLeituraAtual.getText()));
        
            if(dao.localizar(l.getCodLeitura()) != null){
            
                JOptionPane.showMessageDialog(btnSalvar,
                dao.atualizar(l));
                limparCampos();
            } else{
                JOptionPane.showMessageDialog(btnSalvar,
                dao.salvar(l));
                limparCampos();
            }
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(btnSalvar, "Erro ao salvar nova leitura: " + e);
        }
        
        atualizarGrade();
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tfCodigoHidrometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoHidrometroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoHidrometroActionPerformed

    private void btnBuscarHidrometroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarHidrometroActionPerformed
        try{
            String sql = "select * from leitura where cod_hidrometro like '" + tfCodigoHidrometro.getText() + "'";
            model = MyTableModel.getModel(bd, sql);
            table.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(btnBuscarHidrometro, "Erro ao buscar valores: " + e);
        }
    }//GEN-LAST:event_btnBuscarHidrometroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarHidrometro;
    private javax.swing.JButton btnBuscarLeitura;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCodigoHidrometro;
    private javax.swing.JLabel lbCodigoLeitura;
    private javax.swing.JLabel lblConsumo;
    private javax.swing.JLabel lblDataLeitura;
    private javax.swing.JLabel lblLeituraAnterior;
    private javax.swing.JLabel lblLeituraAtual;
    private javax.swing.JLabel lblMediaConsumo;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfCodigoHidrometro;
    private javax.swing.JTextField tfCodigoLeitura;
    private javax.swing.JTextField tfConsumo;
    private javax.swing.JTextField tfDataLeitura;
    private javax.swing.JTextField tfLeituraAnterior;
    private javax.swing.JTextField tfLeituraAtual;
    private javax.swing.JTextField tfLocalizar;
    private javax.swing.JTextField tfMediaConsumo;
    // End of variables declaration//GEN-END:variables

    private void atualizarGrade() {
        model = MyTableModel.getModel(bd, "select * from leitura");
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        
     
        
    }

    private void limparCampos() {
        tfCodigoLeitura.setText("");
        tfCodigoHidrometro.setText("");
        tfDataLeitura.setText("");
        tfLeituraAtual.setText("");
        tfLeituraAnterior.setText("");
        tfConsumo.setText("");
        tfConsumo.enable(false);
        tfMediaConsumo.setText("");
        tfMediaConsumo.enable(false);
        tfCodigoLeitura.requestFocus();
    }

}