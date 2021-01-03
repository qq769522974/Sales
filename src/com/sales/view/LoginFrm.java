package com.sales.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sales.dao.CanteenDao;
import com.sales.dao.ManagerDao;
import com.sales.dao.StudentDao;
import com.sales.model.Canteen;
import com.sales.model.Manager;
import com.sales.model.Student;
import com.sales.model.UserType;
import com.sales.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

//��¼ҳ��
public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JComboBox userTypeComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u98DF\u5802\u9500\u552E\u7CFB\u7EDF\u767B\u5F55\u754C\u9762");
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 21));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7/\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_2_1 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lblNewLabel_2_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAct(e);
			}
		});
		loginButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		
	    userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.STUDENT, UserType.CANTEEN, UserType.MANAGER}));
		userTypeComboBox.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_2_1)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
								.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
							.addGap(43)))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//��¼��һϵ���¼�
	protected void loginAct(ActionEvent e) {
		// TODO Auto-generated method stub
		//��ȡ����������
	    String userID=textField.getText();
		String userPassword=passwordField.getText();
		//��ȡ�û�����
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		//�ж�������Ƿ��
		if(StringUtil.isEmpty(userID)){
			JOptionPane.showMessageDialog(this, "�û�������Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(userPassword)){
			JOptionPane.showMessageDialog(this, "���벻��Ϊ�գ�");
			return;
		}
		//����Ա��¼
		Manager manager = null;
		if("ѧ��".equals(selectedItem.getName())){
			//ѧ����¼
			Student student = null; 
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			studentTmp.setStudentId(userID);
			studentTmp.setStudentPass(userPassword);
			student = studentDao.login(studentTmp);
			studentDao.closeDao();
			if(student == null){
				JOptionPane.showMessageDialog(this, "�û������������");
				return;
			}
			JOptionPane.showMessageDialog(this, "��¼�ɹ���");
			this.dispose();
			new MainFrm().setVisible(true);
			
		}else if("ʳ��".equals(selectedItem.getName())){
			//ʳ�õ�¼
			Canteen canteen = null;
			CanteenDao canteenDao = new CanteenDao();
			Canteen canteenTmp = new Canteen();
			canteenTmp.setCanteenId(userID);
			canteenTmp.setPassword(userPassword);
			canteen = canteenDao.login(canteenTmp);
			canteenDao.closeDao();
			if(canteen == null){
				JOptionPane.showMessageDialog(this, "�û������������");
				return;
			}
			JOptionPane.showMessageDialog(this, "��¼�ɹ���");
			this.dispose();
			new CanteenFrm().setVisible(true);
		}else{
			//����Ա��¼
			ManagerDao managerDao = new ManagerDao();
			Manager managerTmp = new Manager();
			managerTmp.setManagerId(userID);
			managerTmp.setManagerPass(userPassword);
			manager = managerDao.login(managerTmp);
			managerDao.closeDao();
			if(manager == null){
				JOptionPane.showMessageDialog(this, "�û������������");
				return;
			}
			JOptionPane.showMessageDialog(this, "��¼�ɹ���");
			this.dispose();
			new ManagerFrm().setVisible(true);
		}
		
	}

}
