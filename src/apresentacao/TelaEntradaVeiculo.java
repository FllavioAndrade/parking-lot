package apresentacao;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import controle.EstacionamentoController;

//implements ActionListener adiciona a proópria págian

public class TelaEntradaVeiculo extends JFrame implements ActionListener {
    private JFrame parent;
    private JTextField txtMarca;
    private JTextField txtmodelo;
    private JTextField txtCor;
    private JFormattedTextField txtfPlacaMercosul;
    private JFormattedTextField txtfPlacaBrasil;
    private JFormattedTextField txtfPlaca;

    private JButton btnOk;
    private JButton btnCancel;
    private JRadioButton rdbOMercoSul;
    private JRadioButton rdbBrasil;

    //TODO temporario
    public static void main(String[] args) {
        TelaEntradaVeiculo tela = new TelaEntradaVeiculo(null);
        tela.setVisible(true);
    }

    public TelaEntradaVeiculo (JFrame parent){
        setResizable(false); //Não redimencionar
        setSize(new Dimension (400,300));
        setTitle("Entrada de Veículo");
        this.parent = parent;
        getContentPane().setLayout(null); //pagina inteira

        ButtonGroup grupo = new ButtonGroup();
        rdbOMercoSul = new JRadioButton("MercoSul");
        rdbOMercoSul.setBounds(130, 20,86,20);
        rdbOMercoSul.setSelected(true);
        rdbOMercoSul.addActionListener(this);
        rdbOMercoSul.setActionCommand("MercoSul");
        getContentPane().add(rdbOMercoSul);
        grupo.add(rdbOMercoSul);
        

        rdbBrasil = new JRadioButton("Brasil");
        rdbBrasil.setBounds(220, 20,86,20);
        rdbBrasil.setSelected(false);
        rdbBrasil.addActionListener(this);
        rdbBrasil.setActionCommand("Brasil");
        getContentPane().add(rdbBrasil);
        grupo.add(rdbBrasil);


        JLabel lblplaca = new JLabel("Placa:");
        lblplaca.setBounds(94,46,46,14);
        getContentPane().add(lblplaca);

        JLabel lbMarca = new JLabel("Marca:");
        lbMarca.setBounds(94,86,46,14);
        getContentPane().add(lbMarca); 

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(94,126,46,14);
        getContentPane().add(lblModelo);

        JLabel lblCor = new JLabel("Cor:");
        lblCor.setBounds(94,166,46,14); 
        getContentPane().add(lblCor);

        txtMarca = new JTextField(); //instacia uma caixa de texto
        txtMarca.setBounds(160,82,86,20);
        txtMarca.setColumns(10); //define o tamanho da caixa
        getContentPane().add(txtMarca);

        txtmodelo = new JTextField();
        txtmodelo.setBounds(160,126,86,20);
        txtmodelo.setColumns(10);
        getContentPane().add(txtmodelo);

        txtCor = new JTextField();
        txtCor.setBounds(160,166,86,20);
        txtCor.setColumns(10);
        getContentPane().add(txtCor);
        
        btnOk = new JButton("OK"); // instancia um botão
        btnOk.setBounds(104,220,91,23);
        btnOk.addActionListener(this);
        btnOk.setActionCommand("Ok");
        getContentPane().add(btnOk);

        btnCancel = new JButton("Cancelar");
        btnCancel.setBounds(210,220,91,23);
        btnCancel.addActionListener(this);
        btnCancel.setActionCommand("cancel");
        getContentPane().add(btnCancel);

        

        /**
         * Como se está usando um tipo de txtfild diferente, faz-se neessário usar o try e o catch.
         */
        
        try{
            txtfPlacaMercosul = new JFormattedTextField(new MaskFormatter("UUU-#U##")); //adicionar um formato de caixa diferente
        }
        catch (ParseException e){
            assert false: "Padrão de placa errado!";
        }
        txtfPlacaMercosul.setBounds(160, 46,86,20);
        getContentPane().add(txtfPlacaMercosul);

        try{
            txtfPlacaBrasil = new JFormattedTextField(new MaskFormatter("UUU-####")); //adicionar um formato de caixa diferente
        }
        catch (ParseException e){
            assert false: "Padrão de placa errado!";
        }

        txtfPlacaBrasil.setBounds(160, 46,86,20);
        getContentPane().add(txtfPlacaBrasil);
        txtfPlacaBrasil.setVisible(false);

        setLocationRelativeTo(null);
    }
            
        
        @Override
        public void actionPerformed(ActionEvent evento){
            if(rdbOMercoSul.isSelected()) {
                txtfPlacaMercosul.setText("");
                txtfPlacaBrasil.setVisible(false);
                txtfPlacaMercosul.setVisible(true);
                txtfPlaca = txtfPlacaMercosul;
            }

            else if(rdbBrasil.isSelected()){
                txtfPlacaBrasil.setText("");
                txtfPlacaMercosul.setVisible(false);
                txtfPlacaBrasil.setVisible(true);
                txtfPlaca = txtfPlacaBrasil;
            }

            if(evento.getActionCommand().equals("Ok")){
                EstacionamentoController controller = new EstacionamentoController();
                controller.processarEntrada(txtfPlaca.getText(), txtMarca.getText(),txtmodelo.getText(),txtCor.getText());
                
            }
            
            this.parent.setVisible(true);
            this.dispose();
        }      

}
