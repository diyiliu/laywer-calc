package com.diyiliu;

import com.diyiliu.gui.MainForm;
import com.diyiliu.util.UIHelper;

/**
 * Description: Main
 * Author: DIYILIU
 * Update: 2017-09-28 14:51
 */
public class Main {

    public static void main(String[] args) {
        UIHelper.beautify();
        new MainForm();
    }
}
