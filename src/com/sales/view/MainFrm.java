package com.sales.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sales.dao.CacheDao;
import com.sales.dao.FoodDao;
import com.sales.model.Cache;
import com.sales.model.Food;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//学生点餐窗口
public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u70B9\u9910");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		//实例化缓存对象
		Cache cache=new Cache();
		getCache(cache);//获取缓存
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4E0B\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//下单
				buy(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			//按下个人信息按钮-事件
			public void actionPerformed(ActionEvent e) {
				StudentInfo studentInfo=new StudentInfo();
				studentInfo.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("ps\uFF1A\u8BF7\u9009\u62E9\u4F60\u60F3\u5403\u7684\u83DC\uFF0C\u7136\u540E\u4E0B\u5355");
		
		JLabel lblNewLabel_1 = new JLabel("\u9001\u5230\u5BBF\u820D\u540E\u8BF7\u7528\u5FAE\u4FE1\u4ED8\u6B3E");
		
		JLabel lblNewLabel_2 = new JLabel("\u4F60\u597D\uFF01");
		
		JLabel lblNewLabel_3 = new JLabel("name");
		String name=cache.getName();
		lblNewLabel_3.setText(name);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 780, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
							.addGap(67)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnNewButton_1)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_3)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u83DC\u540D", "\u5E8F\u53F7", "\u4EF7\u683C", "\u7D2F\u8BA1\u4E0B\u5355\u6570", "\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		setTable(new Food());
	}
	
	 //将数据库中的菜品信息放入表中
	private void setTable(Food food){	
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		FoodDao foodDao = new FoodDao();
		List<Food> foodList = foodDao.getFoodList(food);
		for (Food s : foodList) {
			Vector v = new Vector();
			v.add(s.getFoodId());
			v.add(s.getFoodName());
			v.add(s.getPrice());
			v.add(s.getNumber());
			v.add(s.getCreateTime());
			dft.addRow(v);
		}
		foodDao.closeDao();
	}
	//下单
	private void buy(ActionEvent e) {
		int row = table.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要下单的菜！");
			return;
		}
		Cache cache=new Cache();
		getCache(cache);
		FoodDao foodDao=new FoodDao();
		if(foodDao.buy(Integer.parseInt(table.getValueAt(row, 0).toString()))) {
			JOptionPane.showMessageDialog(this, "下单成功！下单学生："+cache.getName()+"，地址："+cache.getAddress()+"，将在30分钟内送达！");
		}else {
			JOptionPane.showMessageDialog(this, "下单失败！");
		}
		foodDao.closeDao();
		setTable(new Food());
	}
	//获取缓存
	private void getCache(Cache cache) {
		CacheDao cacheDao=new CacheDao();
		cacheDao.getCache(cache);	
		cacheDao.closeDao();
	}
}
