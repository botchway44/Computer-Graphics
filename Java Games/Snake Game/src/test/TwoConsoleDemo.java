package test;
/*
 * File: TwoConsoleDemo.java
 * -------------------------
 * This program test the multithreading capabilities of the IOConsole
 * class by building a two-console communicator.
 */

import acm.io.*;
import acm.program.*;
import ui.GraphUI;

import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * This class simulates an interactive discussion between two consoles.
 * Its primary purpose is to test the facilities of the <code>IOConsole</code>
 * class.
 */

public class TwoConsoleDemo extends Program {

	public void init() {
		TCModel model = new TCModel();
		c1 = new TCView(model, 1);
		c2 = new TCView(model, 2);
		c1.setMenuBar(getMenuBar());
		c2.setMenuBar(getMenuBar());
		
//		add(c2);
		
//		GraphUI ui = new GraphUI();
//		ui.start();
//		add(ui);
		add(c1);
	}

	public void run() {
		new Thread(c1).start();
		new Thread(c2).start();
	}

	private TCView c1;
	private TCView c2;

/* Standard Java entry point */
/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new TwoConsoleDemo().start(args);
	}
}

class TCView extends IOConsole implements Runnable {

	public TCView(TCModel model, int index) {
		consoleIndex = index;
		consoleModel = model;
		consoleModel.addView(this);
		Color inputColor = (index % 2 == 0) ? Color.MAGENTA : Color.BLUE;
		Color errorColor = (index % 2 == 1) ? Color.MAGENTA : Color.BLUE;
		String inputColorName = (index % 2 == 0) ? "magenta" : "blue";
		String errorColorName = (index % 2 == 1) ? "magenta" : "blue";
		setInputColor(inputColor);
		setErrorColor(errorColor);
		int r = Math.max(0xCC, inputColor.getRed());
		int g = Math.max(0xCC, inputColor.getGreen());
		int b = Math.max(0xCC, inputColor.getBlue());
		setBackground(new Color(r, g, b));
		println("Console " + index);
		print("On this console, input appears in ");
		setInputScript(new BufferedReader(new StringReader(inputColorName + "\n")));
		readLine();
		print("Output from other consoles appears in ");
		showErrorMessage(errorColorName);
	}

	public void run() {
		while (true) {
			String line = readLine();
			consoleModel.inputReceived(this, line);
		}
	}

	public int getIndex() {
		return consoleIndex;
	}

	public void inputReceived(String line) {
		showErrorMessage(line);
	}

	private TCModel consoleModel;
	private int consoleIndex;
}

class TCModel {

	public TCModel() {
		views = new ArrayList<TCView>();
	}

	public void addView(TCView view) {
		views.add(view);
	}

	public void inputReceived(TCView source, String line) {
		int nViews = views.size();
		for (int i = 0; i < nViews; i++) {
			TCView view = views.get(i);
			if (view != source) view.inputReceived(line);
		}
	}

	private ArrayList<TCView> views;
}
