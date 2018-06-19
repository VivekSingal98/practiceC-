package com.vivek.compressionLZ4;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class compressCasesByte {
	private static File sourceJSON=new File("C:\\Users\\int572\\compression\\json.txt");
	private static File destinationCompress=new File("C:\\Users\\int572\\compression\\JsonCompress.txt");
	private static File destinationUncompress=new File("C:\\Users\\int572\\compression\\JsonUncompress.txt");
	
	private static void compressDeflate() throws IOException, ParseException {
		long startTime = System.nanoTime();
		JSONParser parser= new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\int572\\compression\\json_for_compression.json"));
		long endTime = System.nanoTime();
		byte[] inputByte=jsonObject.toString().getBytes("UTF-8");
		
		Deflater def=new Deflater(Deflater.BEST_SPEED);
		ByteArrayOutputStream  byteStream=new ByteArrayOutputStream (inputByte.length);
		DeflaterOutputStream dout=new DeflaterOutputStream(byteStream,def);
		
		dout.write(inputByte);
		dout.finish();
		dout.close();
		
    	System.out.print("Deflate Compression: "+(endTime-startTime)/1000000);
		FileOutputStream fout= new FileOutputStream(destinationCompress);
		byte[] compressedData=byteStream.toByteArray();
		fout.write(compressedData);
		fout.close();
	}

	public static void main(String[] arg) throws IOException, ParseException {
		compressDeflate();
	}
}
