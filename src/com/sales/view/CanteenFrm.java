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

import com.sales.dao.FoodDao;
import com.sales.dao.StudentDao;
import com.sales.model.Food;
import com.sales.model.Student;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
//食堂管理窗口
public class CanteenFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanteenFrm frame = new CanteenFrm();
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
	public CanteenFrm() {
		setResizable(false);
		setTitle("\u98DF\u5802\u540E\u53F0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u83DC\u54C1");
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u83DC\u54C1");
		
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664\u83DC\u54C1");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addGap(30)
							.addComponent(btnNewButton_1)
							.addGap(27)
							.addComponent(btnNewButton_1_1)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u83DC\u540D", "\u4EF7\u683C", "\u4E0B\u5355\u6570", "\u65F6\u95F4"
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
	    //将数据库中的数据放入表中
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
}
