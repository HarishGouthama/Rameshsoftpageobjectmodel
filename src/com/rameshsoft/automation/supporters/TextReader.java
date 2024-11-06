package com.rameshsoft.automation.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rameshsoft.automation.customisedexceptions.FrameworkException;

public class TextReader {
	
	private String filePath;
	private File file;
	private FileWriter fileWriter;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String value;
	
	public TextReader(String filepath) throws IOException
	{
		this.filePath = filepath;
		file = new File(filePath);
		fileWriter = new FileWriter(file);
		bufferedWriter = new BufferedWriter(fileWriter);
		fileReader = new FileReader(filepath);
		bufferedReader = new BufferedReader(fileReader);
	}
	
	public void writeData(String data) throws FrameworkException, IOException {
		if(bufferedWriter != null) {
			bufferedWriter.write(data);
			bufferedWriter.flush();
			
		}
		else {
			FrameworkException exception = new FrameworkException("BufferedWriter");
			throw exception;
		}
	}
	
	public String readData() throws FrameworkException, IOException {
		if(bufferedReader != null) {
			bufferedReader.readLine();
		}
		else
		{
			FrameworkException exception = new FrameworkException("BufferedReader is pointing to null");
			throw exception;
		}
		return value;
	}
	
	public List<String> readTotalData() throws FrameworkException, IOException {
		List<String> fileData = new ArrayList<String>();
		if(bufferedReader != null) {
			while(bufferedReader.ready()) {
				value = bufferedReader.readLine();
				fileData.add(value);
				
			}
		}
		else
		{
			FrameworkException exception = new FrameworkException("BufferedReader is pointing to null");
			throw exception;
		}
		return fileData;
	}
	
}
