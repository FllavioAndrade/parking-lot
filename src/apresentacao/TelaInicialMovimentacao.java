package apresentacao;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class TelaInicialMovimentacao extends JFrame implements ActionListener {

    private JButton btnSair;
    private JButton btnEntrar;

    public static void main(String[] args) {
        TelaInicialMovimentacao tela = new TelaInicialMovimentacao();
        tela.setVisible(true);    
    }

    public TelaInicialMovimentacao(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 300));
        setResizable(false);
        setTitle("Sistema de Estacionamento");
        getContentPane().setLayout(new GridLayout(1,2,0,0));

        btnEntrar = new JButton("");
        btnEntrar.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/entrar.png")));
        btnEntrar.addActionListener(this);
        btnEntrar.setActionCommand("Entrada");
        getContentPane().add(btnEntrar);

        btnSair = new JButton("");
        btnSair.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/sair.png")));
        btnSair.addActionListener(this);
        btnSair.setActionCommand("Saida");
        getContentPane().add(btnSair);

        setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent evento) {
        String cmd = evento.getActionCommand();
        JFrame tela = null;
        if (cmd.equals("Entrada")){
            tela = new TelaEntradaVeiculo(this);
        }
        else{
            tela = new TelaSaidaVeiculo(this);
        }
        tela.setVisible(true);
        this.setVisible(false);
    }
}
