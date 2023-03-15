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

/**
 *
 * @author Admin
 */
public class DoiMatKhauDao {
    public boolean update(NguoiDung nd) throws Exception
    {
        String sql = "UPDATE dbo.NguoiDung "
                + " SET UserPass = ? "
                + " WHERE MaND = ?";
        try( Connection con = DatabaseHelper.openConnection();
             PreparedStatement pre = con.prepareStatement(sql);)  
        {
             pre.setString(1,nd.getUserPass());
             pre.setString (2,nd.getMaND());
             
            return pre.executeUpdate()>0;
        }
    }
}
