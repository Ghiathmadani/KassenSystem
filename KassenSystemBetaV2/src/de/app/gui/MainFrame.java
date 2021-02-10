package de.app.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import System.KassenUtility;
import System.Lage;
import System.Ware;
import de.app.MeinApplikation;

public class MainFrame extends JFrame {
	ArrayList<Ware> einkaufList = new ArrayList<>();
	static KassenUtility utility = new KassenUtility();
	private double Summe;
	private double zwischenSumme;
	private double rabatt;
	private double barGeldDouble;
	// private JFrame MainFrame;
	private JPanel pnlAdd;
	private JPanel pnlUpdate;
	private JPanel pnlDelete;
	private JPanel pnlAddToShopingTrolley;
	private JPanel pnlPay;
	private JScrollPane scrollPane;
	private JTextPane EinkaufenPane;
	private JTextPane textPaneLage;
	private JTextField textField_wareName;
	private JTextField textField_menge;
	private JTextField textField_price;
	private JTextField textField_idlöschen;
	private JTextField textField_IdAk;
	private JTextField textField_nameAk;
	private JTextField textField_mengeAk;
	private JTextField textField_priceAk;
	private JTextField textField_idEinkauf;
	private JTextField textField_mengeEinkauf;
	private JTextField textField_barGeld;
	private JLabel lblStoreTitle;
	private JLabel lblName;
	private JLabel lblAmount;
	private JLabel lblIdDelete;
	private JLabel lblPrice;
	private JLabel lblIdUpdate;
	private JLabel lblNama;
	private JLabel lblAmountUpdate;
	private JLabel lblPriceUpdate;
	private JLabel lblIdAddShopingTrolley;
	private JLabel lblAmountAddShopingTrolley;
	private JLabel RabattLabel_12;
	private JLabel bezahlenLabel_12;
	private JLabel zuarckLabel_12;
	private JLabel RechnugLabel;
	private JLabel RechnungLabel_2;
	private JLabel lblProTitle;
	private JLabel UhrLabel;
	private JLabel lblMyMoney;
	private JButton EinfugenButton;
	private JButton LöschenButton;
	private JButton akButton_1;
	private JButton EinkaufButton_1;
	private JButton bezahlenButton;

	public void setRabatt(double rabatt) {
		this.rabatt = rabatt;
	}

	public double setBarGeldDouble(double barGeldDouble) {
		return this.barGeldDouble = barGeldDouble;
	}

	public void setSumme(double summe) {
		Summe = summe;
	}

	public void setZwischenSumme(double zwischenSumme) {
		this.zwischenSumme = zwischenSumme;
	}

	public ArrayList<Ware> getEinkaufList() {
		return einkaufList;
	}

	public static KassenUtility getUtility() {
		return utility;
	}

	public double getSumme() {
		return Summe;
	}

	public double getZwischenSumme() {
		return zwischenSumme;
	}

	public double getRabatt() {
		return rabatt;
	}

	public double getBarGeldDouble() {
		return barGeldDouble;
	}

	public JPanel getPnlAdd() {
		return pnlAdd;
	}

	public JPanel getPnlUpdate() {
		return pnlUpdate;
	}

	public JPanel getPnlDelete() {
		return pnlDelete;
	}

	public JPanel getPnlAddToShopingTrolley() {
		return pnlAddToShopingTrolley;
	}

	public JPanel getPnlPay() {
		return pnlPay;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextField getTextField_wareName() {
		return textField_wareName;
	}

	public JTextField getTextField_menge() {
		return textField_menge;
	}

	public JTextField getTextField_price() {
		return textField_price;
	}

	public JTextField getTextField_idlöschen() {
		return textField_idlöschen;
	}

	public JTextField getTextField_IdAk() {
		return textField_IdAk;
	}

	public JTextField getTextField_nameAk() {
		return textField_nameAk;
	}

	public JTextField getTextField_mengeAk() {
		return textField_mengeAk;
	}

	public JTextField getTextField_priceAk() {
		return textField_priceAk;
	}

	public JTextField getTextField_idEinkauf() {
		return textField_idEinkauf;
	}

	public JTextField getTextField_mengeEinkauf() {
		return textField_mengeEinkauf;
	}

	public JTextField getTextField_barGeld() {
		return textField_barGeld;
	}

	public JLabel getLblStoreTitle() {
		return lblStoreTitle;
	}

	public JLabel getLblName() {
		return lblName;
	}

	public JLabel getLblAmount() {
		return lblAmount;
	}

	public JLabel getLblIdDelete() {
		return lblIdDelete;
	}

	public JLabel getLblPrice() {
		return lblPrice;
	}

	public JLabel getLblIdUpdate() {
		return lblIdUpdate;
	}

	public JLabel getLblNama() {
		return lblNama;
	}

	public JLabel getLblAmountUpdate() {
		return lblAmountUpdate;
	}

	public JLabel getLblPriceUpdate() {
		return lblPriceUpdate;
	}

	public JLabel getLblIdAddShopingTrolley() {
		return lblIdAddShopingTrolley;
	}

	public JLabel getLblAmountAddShopingTrolley() {
		return lblAmountAddShopingTrolley;
	}

	public JLabel getRabattLabel_12() {
		return RabattLabel_12;
	}

	public JLabel getBezahlenLabel_12() {
		return bezahlenLabel_12;
	}

	public JLabel getZuarckLabel_12() {
		return zuarckLabel_12;
	}

	public JLabel getLblProTitle() {
		return lblProTitle;
	}

	public JLabel getLblMyMoney() {
		return lblMyMoney;
	}

	public JButton getEinfugenButton() {
		return EinfugenButton;
	}

	public JButton getLöschenButton() {
		return LöschenButton;
	}

	public JButton getAkButton() {
		return akButton_1;
	}

	public JButton getEinkaufButton_1() {
		return EinkaufButton_1;
	}

	public JButton getBezahlenButton() {
		return bezahlenButton;
	}

	public MainFrame() {
		initialize();
		uhr();
		lage();
	}

	public void uhr() {
		Thread uhr = new Thread() {
			public void run() {
				try {
					for (;;) {
						// LocalDateTime a = LocalDateTime.now();
						Calendar cal = new GregorianCalendar();
						int tag = cal.get(Calendar.DAY_OF_MONTH);
						int monat = cal.get(Calendar.MONTH);
						int jahr = cal.get(Calendar.YEAR);
						int sekunde = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int stunde = cal.get(Calendar.HOUR);

						UhrLabel.setText("Uhr " + stunde + ":" + minute + ":" + sekunde + " Data " + jahr + "." + monat
								+ "." + tag);

						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		uhr.start();
	}

	public void lage() {
		Thread log = new Thread() {
			public void run() {
				try {
					for (;;) {

						textPaneLage.setText(Lage.listToString(Lage.lagelist));
						RechnugLabel.setText("Ihre Rechnung ohne MWST= " + zwischenSumme);
						RechnungLabel_2.setText("Ihre Rechnung mit MWST= " + Summe);
						EinkaufenPane.setText(Lage.listToString(einkaufList));
						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		log.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initComponents();
//		addControl();

	}

	public JTextPane getEinkaufenPane() {
		return EinkaufenPane;
	}

	public JTextPane getTextPaneLage() {
		return textPaneLage;
	}

	public JLabel getRechnugLabel() {
		return RechnugLabel;
	}

	public JLabel getRechnungLabel_2() {
		return RechnungLabel_2;
	}

	public JLabel getUhrLabel() {
		return UhrLabel;
	}

	////////////////////////////////////////////////////////////////
	/// This method contains all of the code for creating und initializing
	/// components
	////////////////////////////////////////////////////////////////
	private void initComponents() {
		try {
			utility.loadLageVonDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
//		MainFrame = new JFrame();
		this.setResizable(false);
		this.setTitle("KassenSystem");
		this.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MeinApplikation.class.getResource("/resource/credit-card-machine.png")));
		this.setBounds(100, 100, 899, 748);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPaneStore = new JScrollPane();
		// Panels
		pnlAdd = new JPanel();
		pnlAdd.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Einf\u00FCgen neue Ware", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		pnlDelete = new JPanel();
		pnlDelete.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"L\u00F6schen Nach ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		pnlUpdate = new JPanel();
		pnlUpdate.setBorder(
				new TitledBorder(null, "Aktualisieren Nach ID", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		pnlAddToShopingTrolley = new JPanel();
		pnlAddToShopingTrolley.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Einf\u00FCgen zum Einkaufswagen", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		pnlPay = new JPanel();
		pnlPay.setBorder(new TitledBorder(null, "Bezahlen", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		// Labels
		lblStoreTitle = new JLabel("Der Lage:");
		lblStoreTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

		UhrLabel = new JLabel("Uhr");
		UhrLabel.setFont(new Font("Segoe Print", Font.PLAIN, 20));

		lblProTitle = new JLabel("KassenSystem");
		lblProTitle.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));

		lblMyMoney = new JLabel("Bitte schreiben Sie Ihren Geldbetrag ?");
		RabattLabel_12 = new JLabel("Rabatt 10% nur wenn Sie \u00FCber 30 kaufen");
		RabattLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RabattLabel_12.setForeground(Color.RED);
		bezahlenLabel_12 = new JLabel("Bezahl");
		bezahlenLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bezahlenLabel_12.setForeground(Color.RED);
		zuarckLabel_12 = new JLabel("zur\u00FCck");
		zuarckLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		zuarckLabel_12.setForeground(Color.GREEN);
		lblIdAddShopingTrolley = new JLabel("Welche ID der Ware m\u00F6chten Sie einf\u00FCgen ?");
		lblAmountAddShopingTrolley = new JLabel("Wie viel St\u00FCck m\u00F6chten Sie?");
		RechnugLabel = new JLabel("Rechnung");
		RechnugLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RechnugLabel.setForeground(Color.RED);
		RechnungLabel_2 = new JLabel("Rechnung");
		RechnungLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RechnungLabel_2.setForeground(Color.RED);
		lblIdUpdate = new JLabel("ID:");
		lblNama = new JLabel("Name:");
		lblAmountUpdate = new JLabel("Menge:");
		lblPriceUpdate = new JLabel("Price:");
		lblIdDelete = new JLabel("ID:");
		lblName = new JLabel("Name:");
		lblAmount = new JLabel("Menge:");
		lblPrice = new JLabel("Price:");

		// textFields
		textField_barGeld = new JTextField();
		textField_barGeld.setColumns(10);
		textField_idEinkauf = new JTextField();
		textField_idEinkauf.setColumns(10);
		textField_mengeEinkauf = new JTextField();
		textField_mengeEinkauf.setColumns(10);
		textField_IdAk = new JTextField();
		textField_IdAk.setColumns(10);
		textField_nameAk = new JTextField();
		textField_nameAk.setColumns(10);
		textField_mengeAk = new JTextField();
		textField_mengeAk.setColumns(10);
		textField_priceAk = new JTextField();
		textField_priceAk.setColumns(10);
		textField_idlöschen = new JTextField();
		textField_idlöschen.setColumns(10);
		textField_wareName = new JTextField();
		textField_wareName.setColumns(10);
		textField_menge = new JTextField();
		textField_menge.setColumns(10);
		textField_price = new JTextField();
		textField_price.setColumns(10);

		// Buttons
		bezahlenButton = new JButton("Bezahlen");
		EinkaufButton_1 = new JButton("Einf\u00FCgen");
		akButton_1 = new JButton("Aktualisieren");
		LöschenButton = new JButton("L\u00F6schen");
		EinfugenButton = new JButton("Hinfugen");

		EinkaufenPane = new JTextPane();
		EinkaufenPane.setEditable(false);

		textPaneLage = new JTextPane();
		textPaneLage.setEditable(false);
		scrollPaneStore.setViewportView(textPaneLage);

		JScrollPane scrollPane = new JScrollPane();

		GroupLayout gl_pnlPay = new GroupLayout(pnlPay);
		gl_pnlPay.setHorizontalGroup(gl_pnlPay.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPay.createSequentialGroup().addGroup(gl_pnlPay.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPay.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnlPay.createParallelGroup(Alignment.TRAILING).addComponent(bezahlenButton)
										.addComponent(lblMyMoney))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_barGeld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlPay.createSequentialGroup().addGap(24).addGroup(
								gl_pnlPay.createParallelGroup(Alignment.LEADING).addComponent(bezahlenLabel_12)
										.addComponent(RabattLabel_12).addComponent(zuarckLabel_12))))
						.addContainerGap(73, Short.MAX_VALUE)));
		gl_pnlPay.setVerticalGroup(gl_pnlPay.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlPay
				.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_pnlPay.createParallelGroup(Alignment.BASELINE).addComponent(lblMyMoney).addComponent(
						textField_barGeld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_pnlPay.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlPay.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(bezahlenButton).addGap(58))
						.addGroup(Alignment.TRAILING, gl_pnlPay.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(RabattLabel_12).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bezahlenLabel_12).addGap(6)))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(zuarckLabel_12).addGap(44)));
		pnlPay.setLayout(gl_pnlPay);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(EinkaufenPane);

		GroupLayout gl_pnlDelete = new GroupLayout(pnlDelete);
		gl_pnlDelete.setHorizontalGroup(gl_pnlDelete.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDelete.createSequentialGroup().addContainerGap().addComponent(lblIdDelete).addGap(42)
						.addComponent(textField_idlöschen, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(LöschenButton, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE).addGap(6)));
		gl_pnlDelete
				.setVerticalGroup(gl_pnlDelete.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDelete.createSequentialGroup().addGap(5)
								.addGroup(gl_pnlDelete.createParallelGroup(Alignment.BASELINE).addComponent(lblIdDelete)
										.addComponent(textField_idlöschen, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(LöschenButton))));
		pnlDelete.setLayout(gl_pnlDelete);

		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout
								.createSequentialGroup().addGap(332)
								.addComponent(lblProTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(400))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(pnlAdd, GroupLayout.PREFERRED_SIZE, 261,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(pnlDelete, GroupLayout.PREFERRED_SIZE,
																		257, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(pnlUpdate, GroupLayout.PREFERRED_SIZE, 224,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addGap(215)
														.addComponent(lblStoreTitle)))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(scrollPaneStore, GroupLayout.DEFAULT_SIZE, 489,
														Short.MAX_VALUE)
												.addGap(6)))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addGap(18)
														.addComponent(UhrLabel, GroupLayout.DEFAULT_SIZE, 198,
																Short.MAX_VALUE)
														.addContainerGap(257, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(pnlPay, GroupLayout.PREFERRED_SIZE, 368,
																GroupLayout.PREFERRED_SIZE)
														.addGap(99)))
										.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(pnlAddToShopingTrolley, GroupLayout.PREFERRED_SIZE, 371,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap(966, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		groupLayout.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblProTitle).addGap(18)
										.addGroup(groupLayout
												.createParallelGroup(Alignment.BASELINE)
												.addComponent(
														UhrLabel, GroupLayout.PREFERRED_SIZE, 26,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblStoreTitle))
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGap(229)
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGap(14)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(pnlAddToShopingTrolley,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED, 10,
																				Short.MAX_VALUE)
																		.addComponent(
																				pnlPay, GroupLayout.PREFERRED_SIZE, 223,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(scrollPaneStore,
																				GroupLayout.DEFAULT_SIZE, 204,
																				Short.MAX_VALUE)
																		.addGap(18)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(
																						pnlUpdate, Alignment.TRAILING,
																						GroupLayout.DEFAULT_SIZE, 335,
																						Short.MAX_VALUE)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addComponent(pnlAdd,
																								GroupLayout.PREFERRED_SIZE,
																								197,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(pnlDelete,
																								GroupLayout.DEFAULT_SIZE,
																								132, Short.MAX_VALUE)))
																		.addGap(16)))))));

		GroupLayout gl_pnlAdd = new GroupLayout(pnlAdd);
		gl_pnlAdd.setHorizontalGroup(gl_pnlAdd.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlAdd
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlAdd.createSequentialGroup()
						.addGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING).addComponent(lblAmount)
								.addComponent(lblPrice))
						.addGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlAdd.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(textField_price, GroupLayout.PREFERRED_SIZE, 105,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlAdd.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_menge, GroupLayout.PREFERRED_SIZE, 105,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pnlAdd.createSequentialGroup().addComponent(lblName).addGap(9)
								.addComponent(textField_wareName, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
				.addGap(94))
				.addGroup(gl_pnlAdd.createSequentialGroup().addGap(70).addComponent(EinfugenButton).addContainerGap(104,
						Short.MAX_VALUE)));
		gl_pnlAdd.setVerticalGroup(gl_pnlAdd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAdd.createSequentialGroup().addGap(5)
						.addGroup(gl_pnlAdd.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(
								textField_wareName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlAdd.createParallelGroup(Alignment.BASELINE).addComponent(lblAmount)
								.addComponent(textField_menge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_pnlAdd.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrice))
						.addGap(18).addComponent(EinfugenButton).addContainerGap(33, Short.MAX_VALUE)));

		GroupLayout gl_pnlUpdate = new GroupLayout(pnlUpdate);
		gl_pnlUpdate.setHorizontalGroup(gl_pnlUpdate.createParallelGroup(Alignment.TRAILING).addGroup(gl_pnlUpdate
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING).addComponent(lblIdUpdate)
						.addGroup(gl_pnlUpdate.createSequentialGroup()
								.addComponent(lblNama, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE).addGap(5))
						.addGroup(gl_pnlUpdate.createSequentialGroup()
								.addComponent(lblPriceUpdate, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE).addGap(13))
						.addGroup(gl_pnlUpdate.createSequentialGroup()
								.addComponent(lblAmountUpdate, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
								.addGap(4)))
				.addGap(0)
				.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING).addComponent(akButton_1)
						.addComponent(textField_priceAk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_mengeAk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_nameAk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_IdAk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(69)));

		pnlUpdate.setLayout(gl_pnlUpdate);
		gl_pnlUpdate.setVerticalGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlUpdate
				.createSequentialGroup()
				.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_IdAk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdUpdate))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_nameAk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNama))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlUpdate
						.createSequentialGroup()
						.addGroup(gl_pnlUpdate.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_mengeAk, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmountUpdate))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_priceAk,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPriceUpdate, Alignment.TRAILING))
				.addGap(26).addComponent(akButton_1).addGap(151)));

		pnlAdd.setLayout(gl_pnlAdd);
		this.getContentPane().setLayout(groupLayout);

		GroupLayout gl_pnlAddToShopingTrolley = new GroupLayout(pnlAddToShopingTrolley);
		gl_pnlAddToShopingTrolley.setHorizontalGroup(gl_pnlAddToShopingTrolley.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlAddToShopingTrolley.createSequentialGroup().addGroup(gl_pnlAddToShopingTrolley
						.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlAddToShopingTrolley.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnlAddToShopingTrolley.createParallelGroup(Alignment.LEADING)
										.addComponent(lblIdAddShopingTrolley).addComponent(lblAmountAddShopingTrolley))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_pnlAddToShopingTrolley.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_mengeEinkauf, 0, 0, Short.MAX_VALUE).addComponent(
												textField_idEinkauf, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
						.addGroup(gl_pnlAddToShopingTrolley.createSequentialGroup().addGap(124)
								.addComponent(EinkaufButton_1)))
						.addGap(64))
				.addGroup(gl_pnlAddToShopingTrolley.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnlAddToShopingTrolley.createParallelGroup(Alignment.LEADING)
								.addComponent(RechnungLabel_2, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(RechnugLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addGap(252))
				.addGroup(gl_pnlAddToShopingTrolley.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(17, Short.MAX_VALUE)));
		gl_pnlAddToShopingTrolley
				.setVerticalGroup(gl_pnlAddToShopingTrolley.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlAddToShopingTrolley.createSequentialGroup().addContainerGap()
								.addGroup(gl_pnlAddToShopingTrolley.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblIdAddShopingTrolley).addComponent(textField_idEinkauf))
								.addGap(18)
								.addGroup(gl_pnlAddToShopingTrolley.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_mengeEinkauf).addComponent(lblAmountAddShopingTrolley))
								.addGap(11).addComponent(EinkaufButton_1).addGap(18)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(12)
								.addComponent(RechnugLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(RechnungLabel_2).addGap(25)));
		pnlAddToShopingTrolley.setLayout(gl_pnlAddToShopingTrolley);
	}

	////////////////////////////////////////////////////////////////
	/// This method contains all of the code for creating events////
	////////////////////////////////////////////////////////////////
//	private void addControl() {

//		EinfugenButton.addActionListener(this::EinfugenButton);
//		LöschenButton.addActionListener(this::LöschenButton);
//		akButton_1.addActionListener(this::akButton_1);
//		EinkaufButton_1.addActionListener(this::EinkaufButton_1);
//		bezahlenButton.addActionListener(this::bezahlenButton);

//	}

}
