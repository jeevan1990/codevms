package net.BiometricMatch;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

public class ImagePixelMatcher {
	
	 public boolean compareTwoImages(byte[] fileOne, byte[]  fileTwo) {
	        Boolean isTrue = true;
	        int a=0;
        	int b=0;
        	int i=0;
        	int j=0;
        	
        	int x1 = 0, y1 = 0, cw = 0, ch = 0;
    		String str[] = new String[]{"10","10","200","230"};

    		x1 = str[0].equals("") ? 50 : Integer.parseInt(str[0]);
    		y1 = str[1].equals("") ? 50 : Integer.parseInt(str[1]);
    		cw = str[2].equals("") ? 50 : Integer.parseInt(str[2]);
    		ch = str[3].equals("") ? 50 : Integer.parseInt(str[3]);
	        try{
	        	ByteArrayInputStream in1= new ByteArrayInputStream(fileOne);
	    		BufferedInputStream f1= new BufferedInputStream(in1);
	    		
	    		ByteArrayInputStream in2= new ByteArrayInputStream(fileTwo);
	    		BufferedInputStream f2= new BufferedInputStream(in2);
	        	
	        	 BufferedImage bufImg1 = ImageIO.read(f1);
	        	 System.out.println("check  "+bufImg1);
	           System.out.println("width 1 "+bufImg1.getWidth());
	           System.out.println("height 1 "+bufImg1.getHeight());
	           
	           BufferedImage bufImg2 = ImageIO.read(f2);
	           // Image imgTwo = ImageIO.read(fileTwo);
	           // Image imgOne = ImageIO.read(fileOne);
	           //System.out.println("check  "+ImageIO.read(f1));
	            BufferedImage bufImgOne = bufImg1.getSubimage(x1, y1, cw, ch);
	            BufferedImage bufImgTwo = bufImg2.getSubimage(x1, y1, cw, ch);
	           
	            int imgOneHt = bufImgOne.getHeight();
	            int imgTwoHt = bufImgTwo.getHeight();
	            int imgOneWt = bufImgOne.getWidth();
	            int imgTwoWt = bufImgTwo.getWidth();
	            System.out.println(imgTwoHt);
	            System.out.println(imgOneWt);
	            if(imgOneHt!=imgTwoHt ||(imgOneWt!=imgTwoWt)){
	                System.out.println(" size are not equal ");
	                isTrue = false;
	            }
                //for images with different width and height
	            for(int x =0; x < imgOneWt; x++ ){ //replace the loop, if needed
	                for(int y =0; y < imgOneHt ; y++){
	                	a=x;
	                	b=y;
	                	i++;
	                	j++;
	                    if(bufImgOne.getRGB(x, y) != bufImgTwo.getRGB(x, y) ){
	                    	i--;
	                    	//System.out.println(" rgb are not equal ");
	                        isTrue = false;
	                       // break;
	                    }
	                }
	            }
	            
	           // for images with same width and height
	           /* for(int x =0; x< imgOneWt; x++ ){
	                for(int y =0; y <imgOneHt ; y++){
	                	a=x;
	                	b=y;
	                	i++;
	                	j++;
	                    if(bufImgOne.getRGB(x, y) != bufImgTwo.getRGB(x, y) ){
	                    	i--;
	                       // System.out.println(" not matching ");
	                        isTrue = false;
	                       // break;
	                    }
	                }
	            }*/
	            
	        }catch (Exception e) {
	        	 System.out.println("x cor "+a);
	        	 System.out.println("y cor "+b);
	        	 System.out.println("score "+i);
	                        e.printStackTrace();
	        }
	        System.out.println("x cor "+a);
       	 System.out.println("y cor "+b);
       	 System.out.println("score "+i+"  out of "+j);
	        return isTrue;
	    }
	 
	
	 public static void main(String[] args) {
	       
	        File fileName1 = new File("D:\\joy\\finger_1a.bmp");
	        File fileName2 = new File("D:\\joy\\finger_11a.bmp");
	        byte[] a1=null;
	        byte[] a2=null;
	        try{
	        InputStream f1= new FileInputStream(fileName1);
			
			InputStream f2= new FileInputStream(fileName2);
			
			 a1=IOUtils.toByteArray(f1);
			
			 a2=IOUtils.toByteArray(f2);
	        }catch(Exception ex)
	        {
	        	System.out.println(ex.toString());
	        }
	        
	        ImagePixelMatcher imgComp = new ImagePixelMatcher();
	        System.out.println(imgComp.compareTwoImages(a1, a2));
	       
	    }

}
