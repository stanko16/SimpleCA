package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class newRuleFrame extends JFrame {

	private JPanel contentPane;
	private JFrame self;
	public newRuleFrame() {
		self = this;
		setTitle("New Rule");
		setBounds(100, 100, 250, 250);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JCheckBox c1 = new JCheckBox("000");
		c1.setBackground(Color.WHITE);
		c1.setBounds(6, 7, 97, 23);
		contentPane.add(c1);
		
		final JCheckBox c2 = new JCheckBox("001");
		c2.setBackground(Color.WHITE);
		c2.setBounds(6, 33, 97, 23);
		contentPane.add(c2);
		
		final JCheckBox c3 = new JCheckBox("010");
		c3.setBackground(Color.WHITE);
		c3.setBounds(6, 59, 97, 23);
		contentPane.add(c3);
		
		final JCheckBox c4 = new JCheckBox("011");
		c4.setBackground(Color.WHITE);
		c4.setBounds(6, 85, 97, 23);
		contentPane.add(c4);
		
		final JCheckBox c5 = new JCheckBox("100");
		c5.setBackground(Color.WHITE);
		c5.setBounds(6, 111, 97, 23);
		contentPane.add(c5);
		
		final JCheckBox c6 = new JCheckBox("101");
		c6.setBackground(Color.WHITE);
		c6.setBounds(6, 137, 97, 23);
		contentPane.add(c6);
		
		final JCheckBox c7 = new JCheckBox("110");
		c7.setBackground(Color.WHITE);
		c7.setBounds(6, 163, 97, 23);
		contentPane.add(c7);
		
		final JCheckBox c8 = new JCheckBox("111");
		c8.setBackground(Color.WHITE);
		c8.setBounds(6, 187, 97, 23);
		contentPane.add(c8);
		
		JButton applyRule = new JButton("Apply Rule");
		applyRule.setBounds(108, 163, 100, 23);
		applyRule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean rulez[] = {
						c1.isSelected(),
						c2.isSelected(),
						c3.isSelected(),
						c4.isSelected(),
						c5.isSelected(),
						c6.isSelected(),
						c7.isSelected(),
						c8.isSelected()
				};
				Main.setAndApplyRules(rulez);
				self.dispose();			}
		});
		contentPane.add(applyRule);
		
		JEditorPane text = new JEditorPane();
		text.setEditable(false);
		text.setText("Please select the rules that you'd like to be true");
		text.setBounds(100, 37, 111, 68);
		contentPane.add(text);
	}

}
