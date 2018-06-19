package com.vivek.compressionLZ4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;

import org.apache.commons.io.FileUtils;

import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4BlockOutputStream;

public class compressCases {
	private static File sourceJSON=new File("C:\\Users\\int572\\compression\\json.txt");
	private static File destinationCompress=new File("C:\\Users\\int572\\compression\\JsonCompress.txt");
	private static File destinationUncompress=new File("C:\\Users\\int572\\compression\\JsonUncompress.txt");
	
	private static boolean checkUncompressSuccess() {
		try {
			return FileUtils.contentEquals(sourceJSON, destinationUncompress);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private static void compressDeflate() throws IOException {
		byte[] buffer=new byte[1024];
		Deflater def=new Deflater(Deflater.BEST_SPEED);
		FileInputStream fin=new FileInputStream(sourceJSON);
		FileOutputStream fout=new FileOutputStream(destinationCompress);
		DeflaterOutputStream lout=new DeflaterOutputStream(fout,def);
		int read;
		while((read=fin.read(buffer))!=-1) {
			lout.write(buffer, 0,read );
		}
		lout.finish();
		lout.close();
		fin.close();
		fout.close();
	}
	
	private static void decompressDeflate() throws IOException {
		byte[] buffer = new byte[1024];
		FileInputStream fileIn = new FileInputStream(destinationCompress);
		InflaterInputStream defInput = new InflaterInputStream(fileIn);
		FileOutputStream fileOutputStream = new FileOutputStream(destinationUncompress);
		int bytes_read;
		while ((bytes_read = defInput.read(buffer)) > 0) {
			fileOutputStream.write(buffer, 0, bytes_read);
		}
		defInput.close();
		fileOutputStream.close();
		fileIn.close();
		
	}
	
	private static void NormalTransfer() throws IOException {
		byte[] buffer=new byte[1024];
		FileInputStream fin=new FileInputStream(sourceJSON);
		FileOutputStream fout=new FileOutputStream(destinationUncompress);
		int read;
		while((read=fin.read(buffer))!=-1) {
			fout.write(buffer, 0,read );
		}
		fin.close();
		fout.close();
	}
	
	private static void compressGzip() throws IOException {
		byte[] buffer=new byte[1024];
    	FileInputStream fin=new FileInputStream(sourceJSON);
    	FileOutputStream fout=new FileOutputStream(destinationCompress);
    	GZIPOutputStream gzos= new GZIPOutputStream(fout);
    	int read;
    	while((read=fin.read(buffer))!=-1) {
    		gzos.write(buffer, 0,read );
    	}
    	gzos.finish();
    	gzos.close();
    	fin.close();
    	fout.close();
	}
	
	private static void decompressGzip() throws IOException{
		byte[] buffer = new byte[1024];
		FileInputStream fileIn = new FileInputStream(destinationCompress);
		GZIPInputStream gZIPInputStream = new GZIPInputStream(fileIn);
		FileOutputStream fileOutputStream = new FileOutputStream(destinationUncompress);
		int bytes_read;
		while ((bytes_read = gZIPInputStream.read(buffer)) > 0) {
			fileOutputStream.write(buffer, 0, bytes_read);
		}
		gZIPInputStream.close();
		fileOutputStream.close();
		fileIn.close();
		
	}
	
	private static void compressLZ4() throws IOException {
		byte[] buffer=new byte[1024];
    	FileInputStream fin=new FileInputStream(sourceJSON);
    	FileOutputStream fout=new FileOutputStream(destinationCompress);
    	LZ4BlockOutputStream lout=new LZ4BlockOutputStream(fout);
    	int read;
    	while((read=fin.read(buffer))!=-1) {
    		lout.write(buffer, 0,read );
    	}
    	lout.finish();
    	lout.close();
    	fin.close();
    	fout.close();
	}
	
	public static void decompressLZ4() throws IOException {
		byte[] buffer = new byte[1024];
		FileInputStream fileIn = new FileInputStream(destinationCompress);
		LZ4BlockInputStream lz4InputStream = new LZ4BlockInputStream(fileIn);
		FileOutputStream fileOutputStream = new FileOutputStream(destinationUncompress);
		int bytes_read;
		while ((bytes_read = lz4InputStream.read(buffer)) > 0) {

			fileOutputStream.write(buffer, 0, bytes_read);
		}
		lz4InputStream.close();
		fileOutputStream.close();
		fileIn.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		//Deflate
		long startTime = System.nanoTime();
		compressDeflate();
		long endTime = System.nanoTime();
    	System.out.print("Deflate Compression: "+(endTime-startTime)/1000000);
    	
    	startTime = System.nanoTime();
    	decompressDeflate();
    	endTime = System.nanoTime();
    	System.out.println("  Deflate Decompression: "+(endTime-startTime)/1000000);
    	if(checkUncompressSuccess()==false) {
			System.out.println("Deflate compression fails");
		}
    	
    	//GZIP
    	startTime = System.nanoTime();
    	compressGzip();
    	endTime = System.nanoTime();
    	System.out.print("GZIP Compression: "+(endTime-startTime)/1000000);
    	
    	startTime = System.nanoTime();
    	decompressGzip();
    	endTime = System.nanoTime();
    	System.out.println("  GZIP decompression: "+(endTime-startTime)/1000000);
    	
    	if(checkUncompressSuccess()==false) {
			System.out.println("GZip compression fails");
		}
    	
    	//LZ4
    	startTime = System.nanoTime();
    	compressLZ4();
    	endTime = System.nanoTime();
    	System.out.print("LZ4 Compression: "+(endTime-startTime)/1000000);
    	
    	startTime = System.nanoTime();
    	decompressLZ4();
    	endTime = System.nanoTime();
    	System.out.println("  LZ4 Decompression: "+(endTime-startTime)/1000000);
    	
    	if(checkUncompressSuccess()==false) {
			System.out.println("LZ4 compression fails");
		}
    	
    	//normal transfer
    	startTime = System.nanoTime();
    	NormalTransfer();
    	endTime = System.nanoTime();
    	System.out.print("Time taken to copy file without compression "+(endTime-startTime)/1000000);
	}
}
