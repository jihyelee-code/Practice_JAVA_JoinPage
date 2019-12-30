import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.peer.TextFieldPeer;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class UIexamWindow extends JFrame implements MouseListener, ItemListener {
	// container����
	Container container = getContentPane();
	/* container ���� */
	JPanel panelCenter = new JPanel();
	JPanel panelButton = new JPanel();
	/* panelCenter ���� */
	Box boxLeft = Box.createVerticalBox();
	Box boxRight = Box.createVerticalBox();
	/* boxLeft���� */
	JLabel labelId = new JLabel("�� �� �� : ", JLabel.RIGHT);
	JLabel labelName = new JLabel("��    �� : ");
	JLabel labelPassword = new JLabel("��й�ȣ : ");
	JLabel labelBirth = new JLabel("������� : ");
	JLabel labelSex = new JLabel("��    �� : ");
	JLabel labelPhone = new JLabel("��ȭ��ȣ : ");
	JLabel labelEmail = new JLabel("�� �� �� : ");

	/* boxRight���� */
	JPanel panelId = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelPassword = new JPanel();
	JPanel panelBirth = new JPanel();
	JPanel panelSex = new JPanel();
	JPanel panelPhone = new JPanel();
	JPanel panelEmail = new JPanel();
	
	//���̵� �г� ����
	JTextField textFieldId = new JTextField(20);
	JLabel labelIdNoOption = new JLabel("*�ʼ��Է�");
	//�̸� �г� ����
	JTextField textFieldName = new JTextField(20);
	JLabel labelNameNoOption = new JLabel("*�ʼ��Է�");
	//��й�ȣ �г� ����
	JPasswordField passwordField = new JPasswordField(20);
	JLabel labelPasswordNoOption = new JLabel("*�ʼ��Է�");

	// ������� �г� ����
	JComboBox<String> comboBoxYear;
	JComboBox<String> comboBoxMonth;
	JComboBox<String> comboBoxDate;
	JLabel labelYear = new JLabel("�� ");
	JLabel labelMonth = new JLabel("�� ");
	JLabel labelDate = new JLabel("�� ");

	// ���� �г� ����
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton radioButtonMan = new JRadioButton("����");
	JRadioButton radioButtonWoman = new JRadioButton("����");

	// �ڵ�����ȣ �г� ����
	JTextField textFieldFirst = new JTextField(5);
	JTextField textFieldSecond = new JTextField(7);
	JTextField textFieldThird = new JTextField(7);
	JLabel labelFirst = new JLabel(" - ");
	JLabel labelSecond = new JLabel(" - ");

	// �̸��� �ּ� �г� ����
	JTextField textFieldEmailId = new JTextField(15);
	JTextField textFieldEmailAdress = new JTextField(15);
	JComboBox<String> comboBoxEmailAdress;
	JLabel labelGolbang = new JLabel("@");
	String[] adress = { "-���� �Է�-", "naver.com", "daum.net", "hotmail.com", "gmail.com" };

	/* panelButton ���� */
	JButton buttonOk = new JButton("Ȯ   ��");
	JButton buttonCancle = new JButton("��   ��");
	/* ������ */
	Font fontLabel = new Font("����ü", Font.BOLD, 20);
	Font fontText = new Font("����ü", Font.PLAIN, 20);

	//���鹮�� �Է¿� boolean
	boolean check=true;
	
	public UIexamWindow() {
		setTitle("ȸ������");
		setSize(800, 800);

		// ȭ�� �߽� ����
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension1 = tk.getScreenSize();
		Dimension dimension2 = this.getSize();
		int x = (int) (dimension1.getWidth() / 2 - dimension2.getWidth() / 2);
		int y = (int) (dimension1.getHeight() / 2 - dimension2.getHeight() / 2);
		setLocation(x, y);
		init();
		start();

		setVisible(true);	
	}

	private void init() {
		/* container ���� */
		container.setLayout(new BorderLayout(0, 10));
		container.add("Center", panelCenter);
		container.add("South", panelButton);
		// ������
		container.setBackground(Color.white);
		/* panelCenter ���� */
		panelCenter.setLayout(new FlowLayout());
		panelCenter.add(boxLeft);
		panelCenter.add(boxRight);
		// ������
		panelCenter.setBackground(Color.white);

		/* boxLeft ���� */
		boxLeft.add(Box.createVerticalStrut(70));
		boxLeft.add(labelId);
		boxLeft.add(Box.createVerticalStrut(50));
		boxLeft.add(labelName);
		boxLeft.add(Box.createVerticalStrut(50));
		boxLeft.add(labelPassword);
		boxLeft.add(Box.createVerticalStrut(50));
		boxLeft.add(labelBirth);
		boxLeft.add(Box.createVerticalStrut(50));
		boxLeft.add(labelSex);
		boxLeft.add(Box.createVerticalStrut(50));
		boxLeft.add(labelPhone);
		boxLeft.add(Box.createVerticalStrut(50));
		boxLeft.add(labelEmail);
		boxLeft.add(Box.createVerticalStrut(50));
		// �� ��Ʈ
		labelId.setFont(fontLabel);
		labelName.setFont(fontLabel);
		labelPassword.setFont(fontLabel);
		labelBirth.setFont(fontLabel);
		labelSex.setFont(fontLabel);
		labelPhone.setFont(fontLabel);
		labelEmail.setFont(fontLabel);

		/* boxRight ���� */
		boxRight.add(Box.createVerticalStrut(75));
		boxRight.add(panelId);
		boxRight.add(Box.createVerticalStrut(35));
		boxRight.add(panelName);
		boxRight.add(Box.createVerticalStrut(35));
		boxRight.add(panelPassword);
		boxRight.add(Box.createVerticalStrut(35));
		boxRight.add(panelBirth);
		boxRight.add(Box.createVerticalStrut(30));
		boxRight.add(panelSex);
		boxRight.add(Box.createVerticalStrut(35));
		boxRight.add(panelPhone);
		boxRight.add(Box.createVerticalStrut(35));
		boxRight.add(panelEmail);
		boxRight.add(Box.createVerticalStrut(50));

		/* ���̵� �г� ���� */
		panelId.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelId.add(textFieldId);
		panelId.add(labelIdNoOption);
		textFieldId.requestFocus();
		// ������
		panelId.setBackground(Color.white);
		labelIdNoOption.setForeground(Color.red);
		// ��Ʈ
		textFieldId.setFont(fontText);
		

		/* �̸� �г� ���� */
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelName.add(textFieldName);
		panelName.add(labelNameNoOption);
		// ������
		panelName.setBackground(Color.white);
		labelNameNoOption.setForeground(Color.red);
		// ��Ʈ
		textFieldName.setFont(fontText);

		/* ��й�ȣ �г� ���� */
		panelPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelPassword.add(passwordField);
		panelPassword.add(labelPasswordNoOption);
		// ��й�ȣ '*'ǥ��
		passwordField.setEchoChar('*');
		// ������
		panelPassword.setBackground(Color.white);
		labelPasswordNoOption.setForeground(Color.red);
		// ��Ʈ
		passwordField.setFont(fontText);

		/* ������� �г� ���� */
		// �⵵ �޺��ڽ�
		int a = 1940;
		int b = 2020;
		int c = b - a;
		String[] str = new String[c];
		for (int i = a; i < b; i++) {
			str[i - a] = String.valueOf(i);
		}
		comboBoxYear = new JComboBox<String>(str);
		panelBirth.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelBirth.add(comboBoxYear);
		panelBirth.add(labelYear);
		// ������
		panelBirth.setBackground(Color.white);
		comboBoxYear.setBackground(Color.white);
		// ��Ʈ
		comboBoxYear.setFont(fontLabel);
		labelYear.setFont(fontText);

		// �� �޺��ڽ�
		a = 1;
		b = 13;
		c = b - a;
		str = new String[c];
		for (int i = a; i < b; i++) {
			str[i - a] = String.valueOf(i);
		}
		comboBoxMonth = new JComboBox<String>(str);
		panelBirth.add(comboBoxMonth);
		panelBirth.add(labelMonth);
		// ������
		comboBoxMonth.setBackground(Color.white);
		// ��Ʈ
		comboBoxMonth.setFont(fontLabel);
		labelMonth.setFont(fontText);

		// �� �޺��ڽ�
		a = 1;
		b = 32;
		c = b - a;
		str = new String[c];
		for (int i = a; i < b; i++) {
			str[i - a] = String.valueOf(i);
		}
		comboBoxDate = new JComboBox<String>(str);
		panelBirth.add(comboBoxDate);
		panelBirth.add(labelDate);
		// ������
		comboBoxDate.setBackground(Color.white);
		// ��Ʈ
		comboBoxDate.setFont(fontLabel);
		labelDate.setFont(fontText);

		/* ���� �г� ���� */
		panelSex.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSex.add(radioButtonMan);
		panelSex.add(radioButtonWoman);
		buttonGroup.add(radioButtonMan);
		buttonGroup.add(radioButtonWoman);
		// ������
		panelSex.setBackground(Color.white);
		radioButtonMan.setBackground(Color.white);
		radioButtonWoman.setBackground(Color.white);
		// ��Ʈ
		radioButtonMan.setFont(fontText);
		radioButtonWoman.setFont(fontText);

		/* �ڵ�����ȣ �г� ���� */
		panelPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelPhone.add(textFieldFirst);
		panelPhone.add(labelFirst);
		panelPhone.add(textFieldSecond);
		panelPhone.add(labelSecond);
		panelPhone.add(textFieldThird);
		// ������
		panelPhone.setBackground(Color.white);
		// ��Ʈ
		textFieldFirst.setFont(fontText);
		textFieldSecond.setFont(fontText);
		textFieldThird.setFont(fontText);
		labelFirst.setFont(fontText);
		labelSecond.setFont(fontText);

		/* �̸��� �г� ���� */
		panelEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEmail.add(textFieldEmailId);
		panelEmail.add(labelGolbang);
		panelEmail.add(textFieldEmailAdress);
		// �ּ� �޺��ڽ� ����
		comboBoxEmailAdress = new JComboBox<String>(adress);
		panelEmail.add(comboBoxEmailAdress);
		// ������
		panelEmail.setBackground(Color.white);
		comboBoxEmailAdress.setBackground(Color.white);
		// ��Ʈ
		textFieldEmailId.setFont(fontText);
		labelGolbang.setFont(fontText);
		textFieldEmailAdress.setFont(fontText);
		comboBoxEmailAdress.setFont(fontText);

		/* panelButton ���� */
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 50));
		panelButton.setBackground(Color.white);
		panelButton.add(buttonOk);
		panelButton.add(buttonCancle);
		// ��ư ������
		buttonOk.setBackground(Color.white);
		buttonOk.setFocusPainted(false);
		buttonCancle.setBackground(Color.white);
		buttonCancle.setFocusPainted(false);
		// ��Ʈ
		buttonOk.setFont(fontLabel);
		buttonCancle.setFont(fontLabel);

	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		comboBoxEmailAdress.addItemListener(this);
		buttonOk.addMouseListener(this);
		buttonCancle.addMouseListener(this);

	}

	public boolean checkSpace(String label, String text) {
		byte[] textByte = text.getBytes();
		for (int i = 0; i < textByte.length; i++) {
			byte a = textByte[i];
			if (a == 32) {
				int num=label.lastIndexOf(":");
				String label_str=label.substring(0,num-1);
				JOptionPane.showMessageDialog(this, "'"+label_str+"' �׸񿡴� ���鹮�ڸ� ������ �� �����ϴ�.");
				check=false;
				return check;
			}
		}
		return check; //return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buttonOk) {
			// ���̵�or�̸�or��й�ȣ ���鿡 ���� �޽��� ���
			if (textFieldId.getText().equals("") || textFieldId == null) {
				JOptionPane.showMessageDialog(this, "���̵� Ȯ�����ּ���.");
			} else if (textFieldName.getText().equals("") || textFieldName == null) {
				JOptionPane.showMessageDialog(this, "�̸��� Ȯ�����ּ���.");
			} else if (passwordField.getText().equals("") || passwordField == null) {
				JOptionPane.showMessageDialog(this, "��й�ȣ�� Ȯ�����ּ���.");
			} else {
				// ���̵�or�̸�or��й�ȣ ���鹮��(" ")�� ���� �޽��� ���
				String checkId = textFieldId.getText();
				String checkName = textFieldName.getText();
				String checkPassword = passwordField.getText();
				
				if(checkSpace(labelId.getText(),checkId)) {
					if(checkSpace(labelName.getText(),checkName)) {
						if(checkSpace(labelPassword.getText(),checkPassword)) {
							JOptionPane.showMessageDialog(this,"ȸ�������� �Ϸ�Ǿ����ϴ�.\n���α׷��� �����մϴ�.");
							this.dispose();
						}
					}
				}
				
			}

		} else if (e.getSource() == buttonCancle) {
			/* ��ҹ�ư Ŭ���� ���� �ʱ�ȭ */
			JOptionPane.showMessageDialog(this, "�Է� ������ �ʱ�ȭ�մϴ�.");
			// ���̵� �ʱ�ȭ
			textFieldId.setText("");
			// �̸� �ʱ�ȭ
			textFieldName.setText("");
			// ��й�ȣ �ʱ�ȭ
			passwordField.setText("");
			// ������� �ʱ�ȭ
			comboBoxYear.setSelectedIndex(0);
			comboBoxMonth.setSelectedIndex(0);
			comboBoxDate.setSelectedIndex(0);
			// ���� �ʱ�ȭ
			buttonGroup.clearSelection();
			// �ڵ��� ��ȣ �ʱ�ȭ
			textFieldFirst.setText("");
			textFieldSecond.setText("");
			textFieldThird.setText("");
			// �̸��� �ּ� �ʱ�ȭ
			textFieldEmailId.setText("");
			textFieldEmailAdress.setText("");
			comboBoxEmailAdress.setSelectedIndex(0);
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == buttonOk) {
			buttonOk.setBackground(Color.pink);
			buttonOk.setForeground(Color.white);
		} else if (arg0.getSource() == buttonCancle) {
			buttonCancle.setBackground(Color.pink);
			buttonCancle.setForeground(Color.white);
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource() == buttonOk) {
			buttonOk.setBackground(Color.white);
			buttonOk.setForeground(Color.black);
		} else if (arg0.getSource() == buttonCancle) {
			buttonCancle.setBackground(Color.white);
			buttonCancle.setForeground(Color.black);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == comboBoxEmailAdress) {
			System.out.println(comboBoxEmailAdress.getSelectedIndex());
			int indexNum = comboBoxEmailAdress.getSelectedIndex();
			String indexText = comboBoxEmailAdress.getItemAt(indexNum);
			textFieldEmailAdress.setText(indexText);
			if (indexNum == 0) {
				textFieldEmailAdress.setEditable(true);
				textFieldEmailAdress.setText("");
				textFieldEmailAdress.requestFocus();
			} else {
				textFieldEmailAdress.setEditable(false);
			}
		}

	}
}
