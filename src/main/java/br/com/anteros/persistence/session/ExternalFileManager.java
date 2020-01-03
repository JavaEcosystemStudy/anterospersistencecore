package br.com.anteros.persistence.session;

public interface ExternalFileManager {
	
	
	public ResultInfo saveFile(String folderName, String fileName, byte[] fileContent, String mimeType) throws Exception;
	
	public void removeFile(String folderName, String fileName) throws Exception;

}
