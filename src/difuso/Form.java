/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difuso;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 123456
 */
public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    Competencia a1;
    ArrayList<float[]> puntos;
    ArrayList<Etiqueta> v= new ArrayList<>();
    Etiqueta et;
    int contadorpuntos=0,contadoretiquetas=0;
    public Form() {
        initComponents();
        
    control l = new control();
     ArrayList<Competencia> compe=l.cargarCompetencias();
              for(Competencia p:compe)
              {
                  
                    jComboBox1.addItem(p.getNombre().toString());
                    jComboBox2.addItem(p.getNombre().toString());
        
        }
         

        
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtetiqueta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpuntocritico = new javax.swing.JTextField();
        btnAgregarP = new javax.swing.JButton();
        btnetiqueta = new javax.swing.JButton();
        btncompetencia = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtpuntocriticoy = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttraslape = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA EXPERTO DIFUSO");

        jTabbedPane1.setBackground(new java.awt.Color(230, 240, 230));

        jPanel1.setBackground(new java.awt.Color(240, 230, 240));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        jLabel1.setText("Nombre de la competencia");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        jLabel2.setText("Nombre de la etiqueta");

        jLabel3.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        jLabel3.setText("Punto Critico X");

        btnAgregarP.setText("Agregar Punto");
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });

        btnetiqueta.setText("Agregar etiqueta");
        btnetiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnetiquetaActionPerformed(evt);
            }
        });

        btncompetencia.setText("Agregar Competencia");
        btncompetencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncompetenciaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        jLabel4.setText("Punto Critico Y");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 3, 14)); // NOI18N
        jLabel8.setText("% de traslape");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnetiqueta)
                            .addComponent(txtetiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btncompetencia))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnAgregarP))
                            .addComponent(txtpuntocritico, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpuntocriticoy, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttraslape, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtetiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncompetencia)
                    .addComponent(btnetiqueta))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txttraslape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpuntocriticoy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpuntocritico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarP)
                .addGap(68, 68, 68))
        );

        jTabbedPane1.addTab("Add Competencia", jPanel1);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Competencia");

        jLabel6.setText("Relacion con ");

        jLabel7.setText("Competencia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel7)))
                .addContainerGap(403, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Datos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
       puntos= new ArrayList<>();
        if(contadorpuntos<2){
            float puntox=Float.parseFloat(txtpuntocritico.getText());
             float puntoy=Float.parseFloat(txtpuntocriticoy.getText());
            puntos.add(new float[]{puntox,puntoy});
            contadorpuntos++;
        }else
        JOptionPane.showMessageDialog(null, "Se excedio el numero de puntos criticos");

    }//GEN-LAST:event_btnAgregarPActionPerformed

    private void btnetiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnetiquetaActionPerformed
        if(contadoretiquetas<8){  
            contadorpuntos=0;
            if(!puntos.isEmpty()){
                    et= new Etiqueta();
                    et.setNombre(txtetiqueta.getText());
                    et.setListaPuntos(puntos);
                      v.add(et);
            }
            else
                JOptionPane.showMessageDialog(null, "Falta definir por lo menos un punto critico");}
        else
            JOptionPane.showMessageDialog(null, "Se excedio de etiquetas");
                
            
    }//GEN-LAST:event_btnetiquetaActionPerformed

    private void btncompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncompetenciaActionPerformed
        a1= new Competencia(txtnombre.getText());
        float traslape=0;
        int contadoret=v.size();
        for(int i=0;i<contadoret;i++){
            et=v.get(i);
            if(i==0){      
                Etiqueta et2=v.get(i+1);
                
                if(et.listaPuntos.size()>1)
                    traslape=calculartraslape(et.listaPuntos.get(i+1));
                else
                    traslape=calculartraslape(et.listaPuntos.get(i));
                
                et.listaPuntos.add(new float[]{et2.listaPuntos.get(0)[0],(float)0});
                et2= new Etiqueta(et.nombre,et.listaPuntos.get(0),et.listaPuntos.get(1),et.listaPuntos);
                  a1.agregarE(et2);
            }
            int contpuntos=et.listaPuntos.size();
            for(int e=0;e<contpuntos;e++){
                    et.listaPuntos.add(new float[]{(et.listaPuntos.get(e)[0])-traslape,0});
                    if(contpuntos>1){
                        if(i+1==contadoret)
                            et.listaPuntos.add(new float[]{(float)100,(float)1});
                        else
                         et.listaPuntos.add(new float[]{(et.listaPuntos.get(e+1)[0])+traslape,0});}
                    else
                         if(i+1==contadoret)
                             et.listaPuntos.add(new float[]{(float)100,(float)0});
                         else
                             et.listaPuntos.add(new float[]{(et.listaPuntos.get(e)[0])+traslape,0}); 
                    break;
            }
            int p= et.listaPuntos.size();
            for(int x=0;x<p;x++){
                if(et.listaPuntos.get(x)[0]>et.listaPuntos.get(x+1)[0]){
                    float []aux= et.listaPuntos.get(x);
                    float []aux2= et.listaPuntos.get(x+1);
                    et.listaPuntos.add(x, aux2);
                    et.listaPuntos.add(x+1, aux);
                }
            }
            Etiqueta et2= new Etiqueta(et.getNombre(),et.listaPuntos.get(0),et.listaPuntos.get(p-1),et.listaPuntos);
             a1.agregarE(et);
            
        }
        
        if(v.isEmpty()){
            JOptionPane.showMessageDialog(null, "Falta agregar etiquetas a la competencia");
        }
        control c = new control();
        c.guardarCompetencias(a1);
        
    }//GEN-LAST:event_btncompetenciaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
       
       // jComboBox1.addItemListener(this);
        
        
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

     public float calculartraslape(float[]pc){
        float traslape=pc[0]*Float.parseFloat(txttraslape.getText());
            return traslape ;
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btncompetencia;
    private javax.swing.JButton btnetiqueta;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtetiqueta;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpuntocritico;
    private javax.swing.JTextField txtpuntocriticoy;
    private javax.swing.JTextField txttraslape;
    // End of variables declaration//GEN-END:variables
}
