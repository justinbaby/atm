package com.we.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.we.UserMain;
import com.we.bean.TradeInfo;
import com.we.dao.CardManager;
import com.we.dao.TradeManager;
import com.we.dao.UserManager;
import com.we.util.DateUtil;
import com.we.util.MainImagePane;
import com.we.util.MyButton;
import com.we.util.TimerUtil;

@SuppressWarnings("serial")
public class CardDetailsView extends JFrame implements ActionListener{

	private static final int HISTORY_DAY_LIMIT = -30*3;

	private JPanel contentPane;
	
	CardManager cardManager = CardManager.getInstance();
	private MyButton btn_back;
	private MyButton btn_exit;
	private JTable table;
	TradeManager tradeManager = TradeManager.getInstance();
	UserManager userManager = UserManager.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardDetailsView frame = new CardDetailsView();
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
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
	public CardDetailsView() {
		super("交易记录明细");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 80, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MainImagePane mainImagePane = new MainImagePane();
		contentPane.add(mainImagePane);
		mainImagePane.setLayout(null);
		
		btn_exit = new MyButton("res\\btn_exit.png",10,400);
		btn_exit.addActionListener(this);
		mainImagePane.add(btn_exit);
		
        btn_back = new MyButton("res\\btn_back.png",720,400);
        btn_back.addActionListener(this);
		mainImagePane.add(btn_back);
		
		JLabel label = new JLabel("近三个月交易明细");
		label.setBounds(350, 34, 200, 23);
		mainImagePane.add(label);
		label.setFont(new Font("宋体", Font.PLAIN,22));
		String threeMonthBefore = DateUtil.addDay(DateUtil.getDate(), HISTORY_DAY_LIMIT);
		ArrayList<TradeInfo>dataList = tradeManager.queryRecentTradeInfos(DateUtil.addDay(DateUtil.getDate(),1),threeMonthBefore);
		String rowData[][] = new String[100][5];
		Object columnNames[] = { "序号", "交易时间", "交易类型", "交易金额","转账对象"};
		for (int i = 0; i < dataList.size(); i++) {
			rowData[i][0] = String.valueOf(i+1);
			rowData[i][1] = dataList.get(i).getTradeDate();
			rowData[i][2] = getShowType(dataList.get(i).getTradeType());
			rowData[i][3] = dataList.get(i).getTradeMoney()+" CNY";
			int targetId = dataList.get(i).getTarget();
			if(targetId != TradeManager.TARGET_NULL){
				rowData[i][4] = userManager.getUserNameByCardId(targetId);
			}
		}
		JScrollPane scroll = new JScrollPane();  
		scroll.setLocation(158, 83);
        scroll.setSize(560, 300);  
		table = new JTable(rowData,columnNames){
			public Component prepareRenderer(TableCellRenderer renderer, int row,
					int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		table.setFont(new Font("宋体", Font.PLAIN,12));
		 //设置显示范围  
        Dimension viewSize = new Dimension();   
        viewSize.width = table.getColumnModel().getTotalColumnWidth(); ;   
        viewSize.height = 10 * table.getRowHeight();   
        table.setPreferredScrollableViewportSize(viewSize);   
        table.setIntercellSpacing(new Dimension(0, 0));  
        JTableHeader header = table.getTableHeader();   
        header.setPreferredSize(new Dimension(30, 26));   
        header.setOpaque(false);  
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
        render.setOpaque(false); //将渲染器设置为透明  
        table.setDefaultRenderer(Object.class,render);  

		table.setOpaque(false);
		scroll.getViewport().setOpaque(false); 
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false);
		scroll.setViewportView(table);
		mainImagePane.add(scroll);
		table.setBounds(168, 161, 155, 1000);
		table.getTableHeader().setOpaque(false);
		
		
		TimerUtil.stopTimeCount();	
	}
	
	private String getShowType(int tradeType) {
		switch (tradeType) {
		case TradeManager.TRADE_TYPE_SAVE:
			return "存款";
		case TradeManager.TRADE_TYPE_TAKE:
			return "取款";
		case TradeManager.TRADE_TYPE_TRANSFERS_OUT:
			return "转出";
		case TradeManager.TRADE_TYPE_TRANSFERS_IN:
			return "转入";
		}
		return "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyButton btn = (MyButton)e.getSource();
		if(btn == btn_exit){
			System.exit(0);
		}else if(btn == btn_back){
			 new UserMain().setVisible(true);
	         dispose();
		}
	}
}
