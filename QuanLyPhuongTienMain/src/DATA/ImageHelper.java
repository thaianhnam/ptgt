/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author 54321
 */
public class ImageHelper {
    // resize cho phep chỉnh sửa kích thước của ảnh
    public  static  Image resize( Image originalImage, int targetwidth, int targetHeight)
    {
        Image resultingImage = originalImage.getScaledInstance( targetwidth,targetHeight, Image.SCALE_SMOOTH);
        return  resultingImage;    
    }
    //toByteArray cho phép chuyển toàn bộ hình ảnh thnahf mảng cấp byte[]data
    public  static  byte [] toByteArray( Image img, String type) throws  IOException
    {
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(img,0,0,null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimage,type,baos);
        byte[] imageInByte = baos.toByteArray();
        
        return imageInByte;                                  
    }
    // cho phép chuyển mang data về image
    public static  Image createiImage(byte [] data,  String type) throws IOException
    {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bI2 = ImageIO.read(bis);
        
        Image img =bI2.getScaledInstance(bI2.getWidth(),bI2.getHeight(),Image.SCALE_SMOOTH);
        return  img;
    }
}
