package com.we.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.we.UserMain;

public class CardBusinessDone extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8878416190270664711L;
	private JPanel contentPane;
	private JButton btn_showCash;
	private JButton btn_print;
	private JButton btn_continue;
	private JButton btn_back;
	private JButton btn_exit;
	private JLabel label;
	private JLabel label_1;
	private JLabel lb_money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardBusinessDone frame = new CardBusinessDone(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CardBusinessDone(int money) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 80, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_continue = new JButton("继续取款");
		btn_continue.setBounds(32, 191, 93, 23);
		contentPane.add(btn_continue);
		btn_continue.addActionListener(this);
		
		btn_showCash = new JButton("显示余额");
		btn_showCash.setBounds(698, 133, 93, 23);
		contentPane.add(btn_showCash);
		btn_showCash.addActionListener(this);
		
		btn_print = new JButton("打印凭条");
		btn_print.setBounds(698, 218, 93, 23);
		contentPane.add(btn_print);
		btn_print.addActionListener(this);
		
		btn_back = new JButton("回主菜单");
		btn_back.setBounds(698, 308, 93, 23);
		contentPane.add(btn_back);
		btn_back.addActionListener(this);
		
		btn_exit = new JButton("退出");
		btn_exit.setBounds(32, 308, 93, 23);
		contentPane.add(btn_exit);
		
		label = new JLabel("交易成功");
		label.setBounds(309, 98, 54, 15);
		contentPane.add(label);
		
		label_1 = new JLabel("交易金额：");
		label_1.setBounds(267, 145, 72, 23);
		contentPane.add(label_1);
		
		lb_money = new JLabel(money+"");
		lb_money.setBounds(349, 149, 54, 15);
		contentPane.add(lb_money);
		btn_exit.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn == btn_exit){
			dispose();
		}else if(btn == btn_back){
			new UserMain().setVisible(true);
			dispose();
		}
	}

}
