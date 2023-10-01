package apresentacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaLogin extends JFrame implements ActionListener{


    private JPasswordField txtSenha;
    private JPanel panel_2;
    private JRadioButton rdbRelatorio;
    private JRadioButton rdbOperacional;
    private JButton btnOk;

    //TODO remover ao entregar o projeto
    public static void main(String[] args) {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }

    public TelaLogin(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500,150));
        setResizable(false);
        setTitle("Login");

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);

        btnOk = new JButton("Ok");
        btnOk.addActionListener(this);
        btnOk.setActionCommand("Ok");
        panel.add(btnOk);

        JPanel panel_1 =new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.SOUTH);

        JLabel lblSenha = new JLabel("Senha: ");
        panel_2.add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setColumns(20);
        panel_2.add(txtSenha);

        JPanel panel_3 =new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);


        ButtonGroup grupo = new ButtonGroup();
        rdbOperacional = new JRadioButton("Operacional");
        rdbOperacional.setSelected(true);
        rdbOperacional.addActionListener(this);
        rdbOperacional.setActionCommand("Operacional");

        grupo.add(rdbOperacional);
        panel_3.add(rdbOperacional);

        rdbRelatorio = new JRadioButton("relatorio");
        rdbRelatorio.setSelected(false);
        rdbRelatorio.addActionListener(this);
        rdbRelatorio.setActionCommand("Relatorio");
        grupo.add(rdbRelatorio);
        panel_3.add(rdbRelatorio);

        panel_2.setVisible(false);

        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent evento){
        //TODO implementar
        String cmd = evento.getActionCommand();
        JFrame tela = null;
        if (cmd.equals("Operacional")){
            panel_2.setVisible(false);
        }
        else if(cmd.equals("Relatorio")){
            txtSenha.setText("");
            panel_2.setVisible(true);
        }
        else if(cmd.equals("Ok")){
            if (rdbOperacional.isSelected()){
                tela = new TelaInicialMovimentacao();
                tela.setVisible(true);
            }
            else{
                String senha = new String(txtSenha.getPassword());
                if (senha.equals("Flavio")){
                    tela = new TelaInicialRelatorio();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Senha Inválida","Falha Login", JOptionPane.ERROR_MESSAGE);
                    txtSenha.setText("");
                    return;
                }
            }
            this.dispose();
        }
        
        

    }
    
}
