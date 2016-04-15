package com.we.admin.panel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import com.we.dao.CardManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelLost extends JPanel{
	public static final String TAG = "lost";
	private JTextField tf_acc;
	JRadioButton rb_lost;
	JRadioButton rb_unlost;
	private CardManager cardManager = CardManager.getInstance();
	private final ButtonGroup btn_group = new ButtonGroup();
	public PanelLost() {
		setLayout(null);
		
		JLabel lb = new JLabel("挂失|解挂失");
		lb.setBounds(10, 10, 84, 15);
		add(lb);
		
		JLabel lb_acc = new JLabel("卡号：");
		lb_acc.setBounds(159, 126, 54, 15);
		add(lb_acc);
		
		tf_acc = new JTextField();
		tf_acc.setBounds(223, 123, 183, 21);
		add(tf_acc);
		tf_acc.setColumns(10);
		
		rb_lost = new JRadioButton("挂失");
		btn_group.add(rb_lost);
		rb_lost.setBounds(159, 180, 64, 23);
		add(rb_lost);
		
		rb_unlost = new JRadioButton("解挂失");
		btn_group.add(rb_unlost);
		rb_unlost.setBounds(342, 180, 64, 23);
		add(rb_unlost);
		
		JButton btn_con = new JButton("确认");
		btn_con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = rb_lost.isSelected() ? 1 : 0;
				cardManager.lostCard(tf_acc.getText(), flag);
				JOptionPane.showMessageDialog(PanelLost.this, "操作成功");
			}
		});
		btn_con.setBounds(159, 239, 93, 23);
		add(btn_con);
		
		JButton btn_reset = new JButton("重置");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_acc.setText("");
			}
		});
		btn_reset.setBounds(313, 239, 93, 23);
		add(btn_reset);
	}
}
