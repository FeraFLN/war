/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferafln.war.gui.tests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author feraf
 */
public class TriangleButton extends JButton {

    public TriangleButton(String label) {
        super(label);

        // These statements enlarge the button so that it 
        // becomes a circle rather than an oval.
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width,
                size.height);
        setPreferredSize(size);

        // This call causes the JButton not to paint 
        // the background.
        // This allows us to paint a round background.
        setContentAreaFilled(false);
    }

    // Paint the round background and label.
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            // You might want to make the highlight color 
            // a property of the RoundButton class.
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }

        int x3Points[] = {getSize().width / 2, 0, getSize().width};
        int y3Points[] = {0, getSize().height, getSize().height};
        g.fillPolygon(x3Points, y3Points, x3Points.length);

        // This call will paint the label and the 
        // focus rectangle.
        super.paintComponent(g);
    }

    // Paint the border of the button using a simple stroke.
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        int x3Points[] = {getSize().width / 2, 0, getSize().width};
        int y3Points[] = {0, getSize().height, getSize().height};
//        g.drawPolygon(x3Points, y3Points, x3Points.length);
        g.drawPolygon(x3Points, y3Points, x3Points.length);
    }
    // Hit detection.
    Polygon polygon;

    public boolean contains(int x, int y) {
        // If the button has changed size, 
        // make a new shape object.
        if (polygon == null
                || !polygon.getBounds().equals(getBounds())) {
            int x3Points[] = {getSize().width / 2, 0, getSize().width};
            int y3Points[] = {0, getSize().height, getSize().height};
            polygon = new Polygon(x3Points, y3Points, 3);
        }
        return polygon.contains(x, y);
    }

    // Test routine.
    public static void main(String[] args) {
        // Create a button with the label "Jackpot".
        JButton button = new TriangleButton("Jackpot");
//        button.setBackground(Color.green);

        // Create a frame in which to show the button.
        JFrame frame = new JFrame();
//    frame.getContentPane().setBackground(Color.yellow);
        frame.getContentPane().add(button);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(150, 150);
        frame.setVisible(true);
    }
}