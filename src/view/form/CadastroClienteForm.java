package view.form;

import controllers.ClienteDAO;
import java.awt.Dimension;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import controllers.Cliente;
import services.BD;
import services.MyTableModel;
import view.tabbed.TabbedForm;
import java.sql.SQLException;

/**
 * Classe que permite o cadastro, atualização, exclusão e consulta de registros na tabela Cliente no banco de dados.
 * Criação de um design interativo para o cliente com JFrame
 * @author RAVEN
 */
public class CadastroClienteForm extends TabbedForm {
    private ClienteDAO dao;
    private Cliente c;
    
    private DefaultTableModel model;
    private BD bd;

    /**
     * Classe voltada a inicialização dos componentes visuais e de objetos de classes que serão utilizadas
     */
    public CadastroClienteForm() {
        dao = new ClienteDAO();
        c = new Cliente();
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
        lbCodigo = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        tfLocalizar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Cliente");

        lbCodigo.setText("Codigo");

        tfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNome.setText("Nome");

        lblCpf.setText("CPF");

        lblEmail.setText("Email");

        lblTelefone.setText("Telefone");

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

        atualizarGrade();
        table.setDragEnabled(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCodigo)
                            .addComponent(lblNome)
                            .addComponent(lblCpf)
                            .addComponent(lblEmail)
                            .addComponent(lblTelefone))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfEmail)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCpf, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addGap(109, 109, 109)))
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addComponent(tfLocalizar))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(tfLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCodigo)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCpf)
                            .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefone)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnNovo)
                            .addComponent(btnExcluir)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        try{
            c = dao.localizar(Integer.parseInt(tfCodigo.getText()));
        if(c != null){
            tfNome.setText(c.getNomeCliente());
            tfEmail.setText(c.getEmailCliente());
            tfCpf.setText(c.getCpfCliente());
            tfTelefone.setText(c.getTelefoneCliente());
            
        }
        else{
            JOptionPane.showMessageDialog(btnBuscar, "Cliente não encontrado");
            limparCampos();
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(btnBuscar, "Erro ao consultar cliente: " + e);
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tfLocalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLocalizarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLocalizarKeyPressed

    private void tfLocalizarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLocalizarKeyReleased
        try{
            String sql = "select * from cliente where nome_cliente like '%" + tfLocalizar.getText() + "%'";
            model = MyTableModel.getModel(bd, sql);
            table.setModel(model);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_tfLocalizarKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       tfCodigo.setText((String)table.getValueAt(table.getSelectedRow(), 0));
       tfCpf.setText((String)table.getValueAt(table.getSelectedRow(), 1));
       tfNome.setText((String)table.getValueAt(table.getSelectedRow(), 2));
       tfEmail.setText((String)table.getValueAt(table.getSelectedRow(), 3));
       tfTelefone.setText((String)table.getValueAt(table.getSelectedRow(), 4));
      
    }//GEN-LAST:event_tableMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        try{
            int r = JOptionPane.showConfirmDialog(btnExcluir, "Tem certeza que deseja excluir o cliente selecionado?");
            if(r==0){
                JOptionPane.showMessageDialog(btnExcluir,
                 dao.excluir(Integer.parseInt(tfCodigo.getText())));
                limparCampos();
                atualizarGrade();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(btnExcluir, "Erro ao excluir cliente: " + e);
        }
        
        
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        try{
        c.setCodCliente(Integer.parseInt(tfCodigo.getText()));
        c.setEmailCliente(tfEmail.getText());
        c.setCpfCliente(tfCpf.getText());
        c.setNomeCliente(tfNome.getText());
        c.setTelefoneCliente(tfTelefone.getText());
        
        if(dao.localizar(c.getCodCliente()) != null){
            
            JOptionPane.showMessageDialog(btnSalvar,
            dao.atualizar(c));
            limparCampos();
        } else{
            JOptionPane.showMessageDialog(btnSalvar,
            dao.salvar(c));
            limparCampos();
        }
        
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(btnSalvar, "Erro ao salvar novo cliente: " + e);
        }
        
        atualizarGrade();
        
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfLocalizar;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables

    /**
     * Método responsável por atualizar a tabela com as informações de todos os clientes
     */
    private void atualizarGrade() {
        model = MyTableModel.getModel(bd, "select * from cliente");
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        
        
    }

    /**
     * Método utilizado para limpar os textFields, dexando-os em branco.
     */
    private void limparCampos() {
        tfCodigo.setText("");
        tfNome.setText("");
        tfEmail.setText("");
        tfCpf.setText("");
        tfTelefone.setText("");
        tfCodigo.requestFocus();
    }

}
