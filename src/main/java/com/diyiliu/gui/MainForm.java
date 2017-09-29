package com.diyiliu.gui;

import com.diyiliu.util.UIHelper;

import javax.swing.*;

/**
 * Description: MainForm
 * Author: DIYILIU
 * Update: 2017-09-29 09:03
 */
public class MainForm extends JFrame{
    private JTextField textField1;
    private JLabel fee1;
    private JLabel fee2;
    private JLabel fee3;
    private JLabel fee4;
    private JLabel fee5;
    private JLabel fee6;
    private JLabel fee7;
    private JLabel fee8;
    private JTextField textField2;
    private JPanel plContainer;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;


    public MainForm(){
        this.setContentPane(plContainer);
        this.setSize(420, 340);
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
}
