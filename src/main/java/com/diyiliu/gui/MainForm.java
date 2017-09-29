package com.diyiliu.gui;

import com.diyiliu.util.UIHelper;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
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
        this.setContentPane(plContainer);

        btCalc.addActionListener(this);
        btCalc.setActionCommand("calc");

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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        plContainer = new JPanel();
        plContainer.setLayout(new GridLayoutManager(3, 3, new Insets(15, 15, 15, 15), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        plContainer.add(panel1, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, true));
        final JLabel label1 = new JLabel();
        label1.setText("财产金额");
        panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfInput = new JTextField();
        panel1.add(tfInput, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(8, 3, new Insets(10, 0, 20, 0), -1, -1));
        plContainer.add(panel2, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "诉讼争议标的额", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, -1, panel2.getFont())));
        fee1 = new JLabel();
        fee1.setText("≤1万 (按民事不涉及财产案件标准执行)");
        panel2.add(fee1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fee2 = new JLabel();
        fee2.setText("＞1万，≤10万 (6%-7%)");
        panel2.add(fee2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fee3 = new JLabel();
        fee3.setText("＞10万，≤50万 (5%-6%)");
        panel2.add(fee3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fee4 = new JLabel();
        fee4.setText("＞50万，≤100万 (4%-5%)");
        panel2.add(fee4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fee5 = new JLabel();
        fee5.setText("＞100万，≤500万 (3%-4%)");
        panel2.add(fee5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fee6 = new JLabel();
        fee6.setText("＞500万，≤1000万 (2%-3%)");
        panel2.add(fee6, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fee7 = new JLabel();
        fee7.setText("＞1000万，≤1亿 (1%-2%)");
        panel2.add(fee7, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fee8 = new JLabel();
        fee8.setText("＞1亿 (0.5%-1%)");
        panel2.add(fee8, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lb1 = new JLabel();
        lb1.setText("2500");
        panel2.add(lb1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        tf1 = new JTextField();
        tf1.setText("2500");
        panel2.add(tf1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        lb2 = new JLabel();
        lb2.setText("");
        panel2.add(lb2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        lb3 = new JLabel();
        lb3.setText("");
        panel2.add(lb3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        lb4 = new JLabel();
        lb4.setText("");
        panel2.add(lb4, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        lb5 = new JLabel();
        lb5.setText("");
        panel2.add(lb5, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        lb6 = new JLabel();
        lb6.setText("");
        panel2.add(lb6, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        lb7 = new JLabel();
        lb7.setText("");
        panel2.add(lb7, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        lb8 = new JLabel();
        lb8.setText("");
        panel2.add(lb8, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, -1), null, 0, false));
        tf2 = new JTextField();
        tf2.setText("7");
        panel2.add(tf2, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        tf3 = new JTextField();
        tf3.setText("6");
        panel2.add(tf3, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        tf4 = new JTextField();
        tf4.setText("5");
        panel2.add(tf4, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        tf5 = new JTextField();
        tf5.setText("4");
        panel2.add(tf5, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        tf6 = new JTextField();
        tf6.setText("3");
        panel2.add(tf6, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        tf7 = new JTextField();
        tf7.setText("2");
        panel2.add(tf7, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        tf8 = new JTextField();
        tf8.setText("1");
        panel2.add(tf8, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("总金额(元):");
        plContainer.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btCalc = new JButton();
        btCalc.setText("计算");
        plContainer.add(btCalc, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
        money = new JLabel();
        money.setText("0");
        plContainer.add(money, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return plContainer;
    }
}
