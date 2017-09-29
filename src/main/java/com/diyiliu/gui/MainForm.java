package com.diyiliu.gui;

import com.diyiliu.util.UIHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

/**
 * .multiply(Description: MainForm
 * .multiply(Author: DIYILIU
 * .multiply(Update: 2017-09-29 09:03
 */
public class MainForm extends JFrame implements ActionListener, KeyListener {
    private JTextField tfInput;
    private JLabel fee1;
    private JLabel fee2;
    private JLabel fee3;
    private JLabel fee4;
    private JLabel fee5;
    private JLabel fee6;
    private JLabel fee7;
    private JLabel fee8;
    private JTextField tf1;
    private JPanel plContainer;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private JTextField tf7;
    private JTextField tf8;
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JLabel lb5;
    private JLabel lb6;
    private JLabel lb7;
    private JLabel lb8;
    private JButton btCalc;
    private JLabel money;


    public MainForm() {
        btCalc.addActionListener(this);
        btCalc.setActionCommand("calc");

        this.setContentPane(plContainer);
        this.setSize(450, 380);
        // 设置窗口居中
        UIHelper.setCenter(this);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        UIHelper.beautify();
        new MainForm();
    }


    public void doCalc() {
        long input = Long.parseLong(tfInput.getText().trim());

        BigDecimal rate2 = new BigDecimal(tf2.getText().trim()).divide(new BigDecimal(100));
        BigDecimal rate3 = new BigDecimal(tf3.getText().trim()).divide(new BigDecimal(100));
        BigDecimal rate4 = new BigDecimal(tf4.getText().trim()).divide(new BigDecimal(100));
        BigDecimal rate5 = new BigDecimal(tf5.getText().trim()).divide(new BigDecimal(100));
        BigDecimal rate6 = new BigDecimal(tf6.getText().trim()).divide(new BigDecimal(100));
        BigDecimal rate7 = new BigDecimal(tf7.getText().trim()).divide(new BigDecimal(100));
        BigDecimal rate8 = new BigDecimal(tf8.getText().trim()).divide(new BigDecimal(100));

        BigDecimal fee2 = new BigDecimal(0);
        BigDecimal fee3 = new BigDecimal(0);
        BigDecimal fee4 = new BigDecimal(0);
        BigDecimal fee5 = new BigDecimal(0);
        BigDecimal fee6 = new BigDecimal(0);
        BigDecimal fee7 = new BigDecimal(0);
        BigDecimal fee8 = new BigDecimal(0);

        if (input > 100000000l) {

            fee8 = new BigDecimal(input - 100000000l).multiply(rate8);
            fee7 = new BigDecimal(100000000l - 10000000l).multiply(rate7);
            fee6 = new BigDecimal(10000000l - 5000000l).multiply(rate6);
            fee5 = new BigDecimal(5000000l - 1000000l).multiply(rate5);
            fee4 = new BigDecimal(1000000l - 500000l).multiply(rate4);
            fee3 = new BigDecimal(500000l - 100000l).multiply(rate3);
            fee2 = new BigDecimal(100000l - 10000l).multiply(rate2);
        } else if (input > 10000000l) {

            fee7 = new BigDecimal(input - 10000000l).multiply(rate7);
            fee6 = new BigDecimal(10000000l - 5000000l).multiply(rate6);
            fee5 = new BigDecimal(5000000l - 1000000l).multiply(rate5);
            fee4 = new BigDecimal(1000000l - 500000l).multiply(rate4);
            fee3 = new BigDecimal(500000l - 100000l).multiply(rate3);
            fee2 = new BigDecimal(100000l - 10000l).multiply(rate2);
        } else if (input > 5000000l) {

            fee6 = new BigDecimal(input - 5000000l).multiply(rate6);
            fee5 = new BigDecimal(5000000l - 1000000l).multiply(rate5);
            fee4 = new BigDecimal(1000000l - 500000l).multiply(rate4);
            fee3 = new BigDecimal(500000l - 100000l).multiply(rate3);
            fee2 = new BigDecimal(100000l - 10000l).multiply(rate2);
        } else if (input > 1000000l) {

            fee5 = new BigDecimal(input - 1000000l).multiply(rate5);
            fee4 = new BigDecimal(1000000l - 500000l).multiply(rate4);
            fee3 = new BigDecimal(500000l - 100000l).multiply(rate3);
            fee2 = new BigDecimal(100000l - 10000l).multiply(rate2);
        } else if (input > 500000l) {

            fee4 = new BigDecimal(input - 500000l).multiply(rate4);
            fee3 = new BigDecimal(500000l - 100000l).multiply(rate3);
            fee2 = new BigDecimal(100000l - 10000l).multiply(rate2);
        } else if (input > 100000l) {

            fee3 = new BigDecimal(input - 100000l).multiply(rate3);
            fee2 = new BigDecimal(100000l - 10000l).multiply(rate2);
        } else if (input > 10000l) {

            fee2 = new BigDecimal(input - 10000l).multiply(rate2);
        }

        if (fee8.longValue() > 0) {
            lb8.setText(String.valueOf(fee8));
        }
        if (fee7.longValue() > 0) {
            lb7.setText(String.valueOf(fee7));
        }
        if (fee6.longValue() > 0) {
            lb6.setText(String.valueOf(fee6));
        }
        if (fee5.longValue() > 0) {
            lb5.setText(String.valueOf(fee5));
        }
        if (fee4.longValue() > 0) {
            lb4.setText(String.valueOf(fee4));
        }
        if (fee3.longValue() > 0) {
            lb3.setText(String.valueOf(fee3));
        }
        if (fee2.longValue() > 0) {
            lb2.setText(String.valueOf(fee2));
        }

        BigDecimal sum = new BigDecimal(2500);
        sum = sum.add(fee2).add(fee3).add(fee4).add(fee5).add(fee6).add(fee7).add(fee8);
        money.setText(String.valueOf(sum));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("calc")) {

            doCalc();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
