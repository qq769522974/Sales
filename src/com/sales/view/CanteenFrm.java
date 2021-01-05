package com.sales.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//食堂管理窗口
public class CanteenFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_4;
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
		setBounds(100, 100, 734, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u83DC\u54C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改菜品信息
				updateFood(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0\u83DC\u54C1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//增加菜品
				AddFood addFood=new AddFood();
				addFood.setVisible(true);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664\u83DC\u54C1");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除菜品
				deleteFood(e);
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("\u5237\u65B0");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//刷新
				setTable(new Food());
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5E8F\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u83DC\u540D\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u5143");
		
		lblNewLabel_4 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 676, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_4)
									.addGap(41)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addGap(18)
									.addComponent(btnNewButton_1_1)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(23)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_3)))))
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(425, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(212))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_4))
					.addGap(20)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		//鼠标事件监听
		table.addMouseListener(new MouseAdapter() {
			@Override
			//鼠标单击
			public void mouseClicked(MouseEvent e) {
				select(e);
			}
		});
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
		//修改菜品信息
	    protected void updateFood(ActionEvent e) {
	    	// TODO Auto-generated method stub
	    	int row = table.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "请选中要修改的菜品！");
				return;
			}
	    	String id=lblNewLabel_4.getText().toString();
	    	String name=textField_1.getText().toString();
	    	String price=textField_2.getText().toString();
	    	Food food=new Food();
	    	food.setFoodId(id);
	    	food.setFoodName(name);
	    	food.setPrice(price);
	    	FoodDao foodDao=new FoodDao();
	    	foodDao.update(food);
	    	if(foodDao.update(food)){
				JOptionPane.showMessageDialog(this, "修改成功!");
			}else{
				JOptionPane.showMessageDialog(this, "修改失败!");
			}
	    	foodDao.closeDao();
	    	setTable(new Food());
	}

		//将鼠标单击选择的一行数据放入编辑框
	    protected void select(MouseEvent e) {
	    	// TODO Auto-generated method stub
	    	int row=table.getSelectedRow();
	    	Object id = table.getValueAt(row, 0);
	    	Object name = table.getValueAt(row, 1);
	    	Object price = table.getValueAt(row, 2);
	    	lblNewLabel_4.setText((String) id);
	    	textField_1.setText((String) name);
	    	textField_2.setText((String) price);
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
		private void deleteFood(ActionEvent e) {
			int row=table.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "请选中要删除的菜品！");
				return;
			}
			if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
				return;
			}
			FoodDao foodDao=new FoodDao();
			if(foodDao.delete(Integer.parseInt(table.getValueAt(row, 0).toString()))){
				JOptionPane.showMessageDialog(this, "删除成功！");
			}else{
				JOptionPane.showMessageDialog(this, "删除失败！");	
			}
			foodDao.closeDao();
			setTable(new Food());	
		}
		
}
