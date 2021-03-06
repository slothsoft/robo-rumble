package de.slothsoft.roborumble.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import de.slothsoft.roborumble.Robot;

/**
 * The panel that shows the scores of the {@link Robot}'s.
 *
 * @author Stef Schulz
 * @since 1.0.0
 */

public class HighScorePanel extends JPanel {

	private static final long serialVersionUID = -2165255329208901685L;

	private final HighScoreModel highScoreModel = new HighScoreModel();

	public HighScorePanel() {
		setLayout(new BorderLayout());
		createControls();
	}

	private void createControls() {
		final TitledBorder titleBorder = BorderFactory.createTitledBorder("High Score");
		titleBorder.setTitleColor(Color.DARK_GRAY);

		setBorder(titleBorder);
		setLayout(new GridBagLayout());

		final JTable table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setModel(this.highScoreModel);
		table.getColumnModel().getColumn(HighScoreModel.COLUMN_ROBOT).setPreferredWidth(170);
		table.getColumnModel().getColumn(HighScoreModel.COLUMN_AUTHOR).setPreferredWidth(100);
		table.getColumnModel().getColumn(HighScoreModel.COLUMN_VICTORIES).setPreferredWidth(30);

		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		add(scrollPane, GridBagData.forPanel(0, 0).gridwidth(2));
	}

	public void propagateWinner(Robot winner) {
		this.highScoreModel.propagateWinner(winner);
	}
}
