package com.sales.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.sales.model.UserType;
import com.sales.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userIDtextField;
	private JPasswordField userPasswordField;
	protected JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7/\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(105, 82, 104, 19);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("\u98DF\u5802\u9500\u552E\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		lblNewLabel.setBounds(165, 10, 210, 29);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 21));
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(153, 136, 54, 15);
		panel.add(lblNewLabel_2);
		
		userIDtextField = new JTextField();
		userIDtextField.setBounds(231, 83, 144, 21);
		panel.add(userIDtextField);
		userIDtextField.setColumns(10);
		
		userPasswordField = new JPasswordField();
		userPasswordField.setBounds(231, 135, 144, 21);
		panel.add(userPasswordField);
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAct(e);
			}
		});
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		loginButton.setBounds(271, 259, 104, 42);
		panel.add(loginButton);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(140, 214, 104, 15);
		panel.add(lblNewLabel_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(UserType.values()));
		comboBox.setBounds(231, 212, 116, 23);
		panel.add(comboBox);
	}
	//登录的一系列事件
	protected void loginAct(ActionEvent e) {
		// TODO Auto-generated method stub
		//获取输入框的内容
		String userID=userIDtextField.getText();
		String userPassword=userPasswordField.getText();
		//获取用户类型
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		//判断输入框是否空
		if(StringUtil.isEmpty(userID)){
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(userPassword)){
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
	}
		
}
