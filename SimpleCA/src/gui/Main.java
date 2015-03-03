package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import structures.Space;


public class Main {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = 2048;
	static int height = 1024;
	static Space space = new Space(width);
	static GUI gui;
	static JCheckBoxMenuItem cb = new JCheckBoxMenuItem("Random initial state");
	static boolean rulez[];

	public static void main(String[] args) {
		JFrame frame = new JFrame("SimpleCA");
		gui = new GUI(width, height);
		gui.setPreferredSize(new Dimension(width, height));
		gui.setBackground(Color.WHITE);
		
		JScrollPane scroll = new JScrollPane(gui);
		DragScrollHandler.createDragScrollHandlerFor(gui);
		frame.add(scroll, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");
		menuBar.add(menu);
		
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Author :    Stanko Ovkaric\n"
					+   "Webpage:	 www.VicariousMirror.com"
								,"About", 1);

			}
		});
		
		menu.add(about);
			
		menu.addSeparator();
		menu.add(cb);
		
		JMenu submenu = new JMenu("Predefined Rules");
		
		// RULE 184
				JMenuItem rule184 = new JMenuItem("Rule 184");
				rule184.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean rulez[] = { true, false, true, true, true, false, false,
								false };
						setAndApplyRules(rulez);
					}
				});
				submenu.add(rule184);
		
		// RULE 126
		JMenuItem rule126 = new JMenuItem("Rule 126");
		rule126.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean rulez[] = { false, true, true, true, true, true, true,
						false };
				setAndApplyRules(rulez);
			}
		});
		submenu.add(rule126);

		// RULE 110
		JMenuItem rule110 = new JMenuItem("Rule 110");
		rule110.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean rulez[] = { false, true, true, false, true, true, true,
						false };
				setAndApplyRules(rulez);
			}
		});
		submenu.add(rule110);

		// RULE 90
		JMenuItem rule90 = new JMenuItem("Rule 90");
		rule90.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean rulez[] = { false, true, false, true, true, false,
						true, false };
				setAndApplyRules(rulez);
			}
		});
		submenu.add(rule90);

		// RULE 30
		JMenuItem rule30 = new JMenuItem("Rule 30");
		rule30.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean rulez[] = { false, false, false, true, true, true,
						true, false };
				setAndApplyRules(rulez);
			}
		});
		submenu.add(rule30);
		menu.add(submenu);
		
		JMenuItem newrule = new JMenuItem("Apply new rule");
		newrule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newRuleFrame nrf = new newRuleFrame();
				nrf.setVisible(true);
			}
		});
		menu.add(newrule);
		
		menu.addSeparator();
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(exit);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		frame.setSize(new Dimension(1024,500));
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void applyRule(int row) {
		boolean[] cells = space.getCells();
		boolean[] newCells = cells.clone();
		for (int i = 0; i < width; i++) {
			int sum = 0;
			try {
				if (cells[i - 1]) {
					sum += 100;
				}
			} catch (Exception x) {
			}
			if (cells[i])
				sum += 10;
			try {
				if (cells[i + 1]) {
					sum += 1;
				}
			} catch (Exception x) {
			}
			if (space.getRule().get(sum)) {
				gui.fill(i, row, Color.BLACK);
				newCells[i] = true;
			} else {
				newCells[i] = false;
				gui.fill(i, row, Color.WHITE);
			}

		}
		System.out.println();
		space.setCells(newCells);
	}

	public static void setAndApplyRules(boolean rulez[]) {
		space.settRule(rulez);
		if(cb.isSelected()){space.randomize();
		}else{space.nullify();}
		
		for (int i = 0; i < height; i++) {
			applyRule(i);
		}
	}
}
