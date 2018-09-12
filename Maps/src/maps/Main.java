package maps;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import maps.cities.Cities;


public class Main {
	public static JFrame runGUI() {
		JFrame frame = new JFrame("Maps");

		Cities cities = new Cities("cities.csv");
		MapGUI gui = new MapGUI(cities);

		frame.getContentPane().add(gui.getSearchPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(gui.getMapPanel(), BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();

		return frame;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				runGUI();
			}
		});
	}
	

}
