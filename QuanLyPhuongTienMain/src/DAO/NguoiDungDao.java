/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DATA.DatabaseHelper;
import DTO.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class NguoiDungDao {
    public NguoiDung checkLogin(String username, String userpass)
            throws  Exception{
        String sql="SELECT UserName, UserPass,TenND, ChucVu, MaND  FROM NguoiDung"
                +" WHERE UserName =? AND UserPass = ?";
        try(
                Connection con=DatabaseHelper.openConnection();
                PreparedStatement pre=con.prepareStatement(sql);
        ){
            pre.setString(1, username);
            pre.setString(2,userpass);
            try(ResultSet rs=pre.executeQuery();){
                if(rs.next()){
                    NguoiDung nd=new NguoiDung();
                    nd.setUserName(username);
                    nd.setUserPass(userpass);
                    nd.setTenND(rs.getString("TenND"));
                    nd.setChucVu(rs.getString("ChucVu"));
                    nd.setMaND(rs.getString("MaND"));
                    
                    return nd;
                }
            }
        }
        return null;
    }
}
