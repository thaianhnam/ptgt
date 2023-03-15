/*
 * To change this license header, choose License Headers in Project Properties .
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class DataValidator {
    public static void validdateEmpty(JTextField filed, StringBuilder sb, String errorMessage){
        if (filed.getText().equals("")){
            sb.append(errorMessage).append("\n");
            filed.setBackground(Color.red);
            filed.requestFocus();
        }else{
            filed.setBackground(Color.white);
        }
    }
    
    public static void validdateEmpty(JPasswordField filed, StringBuilder sb, String errorMessage){
        String password  = new String (filed.getPassword());
        if (password.equals("")){
            sb.append(errorMessage).append("\n");
            filed.setBackground(Color.red);
            filed.requestFocus();
        }else{
            filed.setBackground(Color.white);
        }
    }
}
