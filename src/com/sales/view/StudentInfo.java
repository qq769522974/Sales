package com.sales.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sales.dao.CacheDao;
import com.sales.dao.StudentDao;
import com.sales.model.Cache;
import com.sales.model.Student;
import com.sales.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//学生信息及修改窗口
public class StudentInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNull_1;
	private JTextField txtNull_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo();
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
	public StudentInfo() {
		setResizable(false);
		setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 283, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//实例化缓存对象
		Cache cache=new Cache();
		getCache(cache);//获取缓存
		
		txtNull_1 = new JTextField();
		String name=cache.getName();
		txtNull_1.setText(name);
		txtNull_1.setColumns(10);
		
		txtNull_2 = new JTextField();
		String address=cache.getAddress();
		txtNull_2.setText(address);
		txtNull_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u5730\u5740\uFF1A");
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		String sex=cache.getSex();
		comboBox.setSelectedItem(sex);
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_4_1 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		
		passwordField_1 = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认修改
				updateInfo(e);
			}
		});
		
		lblNewLabel_5 = new JLabel("NULL");
		String id=cache.getId();
		lblNewLabel_5.setText(id);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_4_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(passwordField_1)
								.addComponent(passwordField)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtNull_2)
								.addComponent(txtNull_1))))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNull_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNull_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_1))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//个人信息修改
	private void updateInfo(ActionEvent e) {
			String id=lblNewLabel_5.getText().toString();
			String name=txtNull_1.getText().toString();
			String address=txtNull_2.getText().toString();
			String sex=comboBox.getSelectedItem().toString();
			String password1=passwordField.getText().toString();
			String password2=passwordField_1.getText().toString();
			if(password1.equals(password2)==false) {
				JOptionPane.showMessageDialog(this, "请输入相同的密码");
				return;
			}
			if(StringUtil.isEmpty(password1)&StringUtil.isEmpty(password2)) {
				//不更改密码
				Student student=new Student();
			    student.setSex(sex);
			    student.setStudentAddress(address);
			    student.setStudentId(id);
			    student.setStudentName(name);
			    StudentDao studentDao=new StudentDao();
			    studentDao.update1(student);
			    if(studentDao.update1(student)){
					JOptionPane.showMessageDialog(this, "修改成功!");
				}else{
					JOptionPane.showMessageDialog(this, "修改失败!");
				}
				studentDao.closeDao();
			}else{
				//更改密码
				Student student=new Student();
			    student.setSex(sex);
			    student.setStudentAddress(address);
			    student.setStudentId(id);
			    student.setStudentName(name);
			    student.setStudentPass(password1);
			    StudentDao studentDao=new StudentDao();
			    studentDao.update2(student);
			    if(studentDao.update2(student)){
					JOptionPane.showMessageDialog(this, "修改成功!请重新登录更新数据！");
				}else{
					JOptionPane.showMessageDialog(this, "修改失败!");
				}
			    studentDao.closeDao();
			}
			
		   }
	//获取缓存
	private void getCache(Cache cache) {
			CacheDao cacheDao=new CacheDao();
			cacheDao.getCache(cache);	
			cacheDao.closeDao();
		}
	
}
