package net.BiometricMatch;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;

public class ImagePatternMatch  {
	
	private static int BUFFSIZE=2000;
	private static byte buff1[]=new byte[2000];
	private static byte buff2[]=new byte[2000];
	
	public static byte[] cropImage(byte[] bytesIn) {
		byte[] bytesOut = null;
		try {
		int x1 = 0, y1 = 0, cw = 0, ch = 0;
		String str[] = new String[]{"10","10","300","200"};

		x1 = str[0].equals("") ? 50 : Integer.parseInt(str[0]);
		y1 = str[1].equals("") ? 50 : Integer.parseInt(str[1]);
		cw = str[2].equals("") ? 50 : Integer.parseInt(str[2]);
		ch = str[3].equals("") ? 50 : Integer.parseInt(str[3]);

		//String oldFileName="D:\\Ears\\Old_Another_File.JPG";
		ByteArrayInputStream in= new ByteArrayInputStream(bytesIn);
		BufferedInputStream f= new BufferedInputStream(in);
		//FileInputStream oldFile = new FileInputStream(f.toString());

		//File newFile = new File("D:\\Ears\\New_Another_File.JPG");
		//FileOutputStream fout = new FileOutputStream(newFile);
		
		
		
		BufferedImage bimage = ImageIO.read(f);
		BufferedImage bi = null;
		System.out.println(bimage);
		bi = bimage.getSubimage(x1, y1, cw, ch);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String format = "bmp";
		if (bi != null) {
		ImageIO.write(bi, format, baos);
		}
		bytesOut = baos.toByteArray();
		//fout.write(bytesOut);
		System.out.println("New file with cropped dimension is created.");
		//fout.close();
		return bytesOut;
		}
		catch(Exception exp){
		exp.printStackTrace();
		}
		
		return null;
		}
	
	public static void main(String[] args) throws Exception {
		
		
		String fileName1="D:\\joy\\finger_1a.bmp";
		String fileName2 = "D:\\joy\\finger_1b.bmp";
	  
		InputStream f1= new FileInputStream(fileName1);
		
		InputStream f2= new FileInputStream(fileName2);
		
		byte[] a1=cropImage(IOUtils.toByteArray(f1));
		
		byte[] a2=cropImage(IOUtils.toByteArray(f2));

		System.out.println("Comparison result of both files : "+fileContentsEquals(a1,a2));
		//System.out.println("Comparison result of both files : "+fileContentsEquals(fileName1,fileName2));

		

		}
  
	
	public static boolean inputStreamEquals(InputStream is1, InputStream is2) {
		if(is1 == is2) return true;
		if(is1 == null && is2 == null) {
		return true;
		}
		if(is1 == null || is2 == null) {
		return false;
		}
		try {
			
		int read1 = -1;
		int read2 = -1;
		do {
		int offset1 = 0;
		while (offset1 < BUFFSIZE && (read1 = is1.read(buff1, offset1, BUFFSIZE-offset1)) >= 0) {
		offset1 += read1;
		}

		int offset2 = 0;
		while (offset2 < BUFFSIZE && (read2 = is2.read(buff2, offset2, BUFFSIZE-offset2)) >= 0) {
		offset2 += read2;
		}
		if(offset1 != offset2) {
		return false;
		}
		if(offset1 != BUFFSIZE) {
		Arrays.fill(buff1, offset1, BUFFSIZE, (byte)0);
		Arrays.fill(buff2, offset2, BUFFSIZE, (byte)0);
		}
		if(!Arrays.equals(buff1, buff2)){
		return false;
		}
		} while(read1 >= 0 && read2 >= 0);
		if(read1 < 0 && read2 < 0) return true;    // both at EOF
		return false;

		} catch (Exception ei) {
		return false;
		}
		}

		public static boolean fileContentsEquals(File file1, File file2) {
		InputStream is1 = null;
		InputStream is2 = null;
		if(file1.length() != file2.length())  {
		System.out.println("Either of the file is not available or size differs");
		return false;
		}
		try {
		is1 = new FileInputStream(file1);
		is2 = new FileInputStream(file2);
		return inputStreamEquals(is1, is2);

		} catch (Exception ei) {
		return false;
		} finally {
		try {
		if(is1 != null) is1.close();
		if(is2 != null) is2.close();
		} catch (Exception ei2) {}
		}
		}

		public static boolean fileContentsEquals(byte[] fn1, byte[] fn2) {
			
			String fileName1="D:\\temp\\finger_1a.bmp";
			String fileName2 = "D:\\temp\\finger_1b.bmp";
			
			File a= new File(fileName1);
			File b= new File(fileName2);
			
			try{
			OutputStream f1= new FileOutputStream(a);
			OutputStream f2= new FileOutputStream(b);
			f1.write(fn1);
			f2.write(fn2);
			}catch(Exception ex)
			{
				
			}
			
		return fileContentsEquals(new File(fileName1), new File(fileName2));
		}
	
	

}
