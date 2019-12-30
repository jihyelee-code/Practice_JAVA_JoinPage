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
	// container생성
	Container container = getContentPane();
	/* container 구성 */
	JPanel panelCenter = new JPanel();
	JPanel panelButton = new JPanel();
	/* panelCenter 구성 */
	Box boxLeft = Box.createVerticalBox();
	Box boxRight = Box.createVerticalBox();
	/* boxLeft구성 */
	JLabel labelId = new JLabel("아 이 디 : ", JLabel.RIGHT);
	JLabel labelName = new JLabel("이    름 : ");
	JLabel labelPassword = new JLabel("비밀번호 : ");
	JLabel labelBirth = new JLabel("생년월일 : ");
	JLabel labelSex = new JLabel("성    별 : ");
	JLabel labelPhone = new JLabel("전화번호 : ");
	JLabel labelEmail = new JLabel("이 메 일 : ");

	/* boxRight구성 */
	JPanel panelId = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelPassword = new JPanel();
	JPanel panelBirth = new JPanel();
	JPanel panelSex = new JPanel();
	JPanel panelPhone = new JPanel();
	JPanel panelEmail = new JPanel();
	
	//아이디 패널 구성
	JTextField textFieldId = new JTextField(20);
	JLabel labelIdNoOption = new JLabel("*필수입력");
	//이름 패널 구성
	JTextField textFieldName = new JTextField(20);
	JLabel labelNameNoOption = new JLabel("*필수입력");
	//비밀번호 패널 구성
	JPasswordField passwordField = new JPasswordField(20);
	JLabel labelPasswordNoOption = new JLabel("*필수입력");

	// 생년월일 패널 구성
	JComboBox<String> comboBoxYear;
	JComboBox<String> comboBoxMonth;
	JComboBox<String> comboBoxDate;
	JLabel labelYear = new JLabel("년 ");
	JLabel labelMonth = new JLabel("월 ");
	JLabel labelDate = new JLabel("일 ");

	// 성별 패널 구성
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton radioButtonMan = new JRadioButton("남자");
	JRadioButton radioButtonWoman = new JRadioButton("여자");

	// 핸드폰번호 패널 구성
	JTextField textFieldFirst = new JTextField(5);
	JTextField textFieldSecond = new JTextField(7);
	JTextField textFieldThird = new JTextField(7);
	JLabel labelFirst = new JLabel(" - ");
	JLabel labelSecond = new JLabel(" - ");

	// 이메일 주소 패널 구성
	JTextField textFieldEmailId = new JTextField(15);
	JTextField textFieldEmailAdress = new JTextField(15);
	JComboBox<String> comboBoxEmailAdress;
	JLabel labelGolbang = new JLabel("@");
	String[] adress = { "-직접 입력-", "naver.com", "daum.net", "hotmail.com", "gmail.com" };

	/* panelButton 구성 */
	JButton buttonOk = new JButton("확   인");
	JButton buttonCancle = new JButton("취   소");
	/* 디자인 */
	Font fontLabel = new Font("바탕체", Font.BOLD, 20);
	Font fontText = new Font("바탕체", Font.PLAIN, 20);

	//공백문자 입력용 boolean
	boolean check=true;
	
	public UIexamWindow() {
		setTitle("회원가입");
		setSize(800, 800);

		// 화면 중심 설정
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
		/* container 구성 */
		container.setLayout(new BorderLayout(0, 10));
		container.add("Center", panelCenter);
		container.add("South", panelButton);
		// 디자인
		container.setBackground(Color.white);
		/* panelCenter 구성 */
		panelCenter.setLayout(new FlowLayout());
		panelCenter.add(boxLeft);
		panelCenter.add(boxRight);
		// 디자인
		panelCenter.setBackground(Color.white);

		/* boxLeft 구성 */
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
		// 라벨 폰트
		labelId.setFont(fontLabel);
		labelName.setFont(fontLabel);
		labelPassword.setFont(fontLabel);
		labelBirth.setFont(fontLabel);
		labelSex.setFont(fontLabel);
		labelPhone.setFont(fontLabel);
		labelEmail.setFont(fontLabel);

		/* boxRight 구성 */
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

		/* 아이디 패널 구성 */
		panelId.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelId.add(textFieldId);
		panelId.add(labelIdNoOption);
		textFieldId.requestFocus();
		// 디자인
		panelId.setBackground(Color.white);
		labelIdNoOption.setForeground(Color.red);
		// 폰트
		textFieldId.setFont(fontText);
		

		/* 이름 패널 구성 */
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelName.add(textFieldName);
		panelName.add(labelNameNoOption);
		// 디자인
		panelName.setBackground(Color.white);
		labelNameNoOption.setForeground(Color.red);
		// 폰트
		textFieldName.setFont(fontText);

		/* 비밀번호 패널 구성 */
		panelPassword.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelPassword.add(passwordField);
		panelPassword.add(labelPasswordNoOption);
		// 비밀번호 '*'표시
		passwordField.setEchoChar('*');
		// 디자인
		panelPassword.setBackground(Color.white);
		labelPasswordNoOption.setForeground(Color.red);
		// 폰트
		passwordField.setFont(fontText);

		/* 생년월일 패널 구성 */
		// 년도 콤보박스
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
		// 디자인
		panelBirth.setBackground(Color.white);
		comboBoxYear.setBackground(Color.white);
		// 폰트
		comboBoxYear.setFont(fontLabel);
		labelYear.setFont(fontText);

		// 월 콤보박스
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
		// 디자인
		comboBoxMonth.setBackground(Color.white);
		// 폰트
		comboBoxMonth.setFont(fontLabel);
		labelMonth.setFont(fontText);

		// 일 콤보박스
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
		// 디자인
		comboBoxDate.setBackground(Color.white);
		// 폰트
		comboBoxDate.setFont(fontLabel);
		labelDate.setFont(fontText);

		/* 성별 패널 구성 */
		panelSex.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSex.add(radioButtonMan);
		panelSex.add(radioButtonWoman);
		buttonGroup.add(radioButtonMan);
		buttonGroup.add(radioButtonWoman);
		// 디자인
		panelSex.setBackground(Color.white);
		radioButtonMan.setBackground(Color.white);
		radioButtonWoman.setBackground(Color.white);
		// 폰트
		radioButtonMan.setFont(fontText);
		radioButtonWoman.setFont(fontText);

		/* 핸드폰번호 패널 구성 */
		panelPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelPhone.add(textFieldFirst);
		panelPhone.add(labelFirst);
		panelPhone.add(textFieldSecond);
		panelPhone.add(labelSecond);
		panelPhone.add(textFieldThird);
		// 디자인
		panelPhone.setBackground(Color.white);
		// 폰트
		textFieldFirst.setFont(fontText);
		textFieldSecond.setFont(fontText);
		textFieldThird.setFont(fontText);
		labelFirst.setFont(fontText);
		labelSecond.setFont(fontText);

		/* 이메일 패널 구성 */
		panelEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEmail.add(textFieldEmailId);
		panelEmail.add(labelGolbang);
		panelEmail.add(textFieldEmailAdress);
		// 주소 콤보박스 설정
		comboBoxEmailAdress = new JComboBox<String>(adress);
		panelEmail.add(comboBoxEmailAdress);
		// 디자인
		panelEmail.setBackground(Color.white);
		comboBoxEmailAdress.setBackground(Color.white);
		// 폰트
		textFieldEmailId.setFont(fontText);
		labelGolbang.setFont(fontText);
		textFieldEmailAdress.setFont(fontText);
		comboBoxEmailAdress.setFont(fontText);

		/* panelButton 구성 */
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 50));
		panelButton.setBackground(Color.white);
		panelButton.add(buttonOk);
		panelButton.add(buttonCancle);
		// 버튼 디자인
		buttonOk.setBackground(Color.white);
		buttonOk.setFocusPainted(false);
		buttonCancle.setBackground(Color.white);
		buttonCancle.setFocusPainted(false);
		// 폰트
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
				JOptionPane.showMessageDialog(this, "'"+label_str+"' 항목에는 공백문자를 포함할 수 없습니다.");
				check=false;
				return check;
			}
		}
		return check; //return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == buttonOk) {
			// 아이디or이름or비밀번호 공백에 대한 메시지 출력
			if (textFieldId.getText().equals("") || textFieldId == null) {
				JOptionPane.showMessageDialog(this, "아이디를 확인해주세요.");
			} else if (textFieldName.getText().equals("") || textFieldName == null) {
				JOptionPane.showMessageDialog(this, "이름을 확인해주세요.");
			} else if (passwordField.getText().equals("") || passwordField == null) {
				JOptionPane.showMessageDialog(this, "비밀번호를 확인해주세요.");
			} else {
				// 아이디or이름or비밀번호 공백문자(" ")에 대한 메시지 출력
				String checkId = textFieldId.getText();
				String checkName = textFieldName.getText();
				String checkPassword = passwordField.getText();
				
				if(checkSpace(labelId.getText(),checkId)) {
					if(checkSpace(labelName.getText(),checkName)) {
						if(checkSpace(labelPassword.getText(),checkPassword)) {
							JOptionPane.showMessageDialog(this,"회원가입이 완료되었습니다.\n프로그램을 종료합니다.");
							this.dispose();
						}
					}
				}
				
			}

		} else if (e.getSource() == buttonCancle) {
			/* 취소버튼 클릭시 내용 초기화 */
			JOptionPane.showMessageDialog(this, "입력 내용을 초기화합니다.");
			// 아이디 초기화
			textFieldId.setText("");
			// 이름 초기화
			textFieldName.setText("");
			// 비밀번호 초기화
			passwordField.setText("");
			// 생년월일 초기화
			comboBoxYear.setSelectedIndex(0);
			comboBoxMonth.setSelectedIndex(0);
			comboBoxDate.setSelectedIndex(0);
			// 성별 초기화
			buttonGroup.clearSelection();
			// 핸드폰 번호 초기화
			textFieldFirst.setText("");
			textFieldSecond.setText("");
			textFieldThird.setText("");
			// 이메일 주소 초기화
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
