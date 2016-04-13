package com.we.admin;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.we.admin.panel.PanelCreate;
import com.we.admin.panel.PanelDel;
import com.we.admin.panel.PanelFrozen;
import com.we.admin.panel.PanelLost;
import com.we.admin.panel.PanelQue;
import com.we.admin.panel.PanelRec;
import com.we.admin.panel.PanelSignUp;

/**
 * 管理界面的Frame finish
 * @author 梓扬
 *
 */
@SuppressWarnings("serial")
public class AdminMain extends JFrame {

	private JPanel contentPane;
	private JMenuBar menu_bar;
	private JMenu item_account;
	private JMenu item_activity;
	private JMenu item_query;
	private JMenu item_right;
	private JMenuItem sel_create;
	private JMenuItem sel_del;
	private JMenuItem sel_lost;
	private JMenuItem sel_frozen;
	private JMenuItem sel_scan;
	private JMenuItem sel_acc;
	private JMenuItem sel_change;
	private JMenuItem sel_user;
	private CardLayout cl;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					AdminMain frame = new AdminMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminMain() {
		setTitle("管理界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		cl = new CardLayout();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cl);
		initView();
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		addMenu();
		addPanel();
	}

	/**
	 * 添加panel到当前Frame中
	 */
	private void addPanel() {

		contentPane.add(new PanelCreate(), PanelCreate.TAG);
		sel_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "create");
			}
		});
		contentPane.add(new PanelDel(), PanelDel.TAG);
		sel_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, "delete");
			}
		});
		contentPane.add(new PanelLost(), PanelLost.TAG);
		sel_lost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, PanelLost.TAG);
			}
		});
		contentPane.add(new PanelFrozen(), PanelFrozen.TAG);
		sel_frozen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, PanelFrozen.TAG);
			}
		});
		
		contentPane.add(new PanelRec(), PanelRec.TAG);
		sel_scan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, PanelRec.TAG);
			}
		});
		
		contentPane.add(new PanelQue(), PanelQue.TAG);
		sel_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, PanelQue.TAG);
			}
		});
		
		contentPane.add(new PanelSignUp(), PanelSignUp.TAG);
		sel_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(contentPane, PanelSignUp.TAG);
			}
		});
	}
	
	/**
	 * 添加Menu到Frame中
	 */
	private void addMenu() {
		menu_bar = new JMenuBar();
		setJMenuBar(menu_bar);

		item_account = new JMenu("用户管理");
		menu_bar.add(item_account);
		item_activity = new JMenu("账号活动");
		menu_bar.add(item_activity);
		item_query = new JMenu("信息查询");
		menu_bar.add(item_query);
		item_right = new JMenu("权限");
		menu_bar.add(item_right);

		sel_create = new JMenuItem("开户功能");
		item_account.add(sel_create);
		sel_del = new JMenuItem("销户功能");
		item_account.add(sel_del);
		sel_user = new JMenuItem("注册用户");
		item_account.add(sel_user);
		
		sel_lost = new JMenuItem("挂失\\解挂失");
		item_activity.add(sel_lost);
		sel_frozen = new JMenuItem("冻结\\解冻");
		item_activity.add(sel_frozen);


		sel_scan = new JMenuItem("交易记录查询");
		item_query.add(sel_scan);
		sel_acc = new JMenuItem("卡号查询");
		item_query.add(sel_acc);

		sel_change = new JMenuItem("更改密码");
		item_right.add(sel_change);
	}
}
