package org.za.hem.ipsec_tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

public class PolicyFile extends JarFile {
	public static final String ATTR_NAME = "Name";
	
	public static final String SETKEY_NAME = "setkey.conf";
	public static final String RACOON_NAME = "racoon.conf";

	public PolicyFile(File file) throws IOException {
		super(file);
		// TODO Auto-generated constructor stub
	}

	public PolicyFile(String filename) throws IOException {
		super(filename);
		// TODO Auto-generated constructor stub
	}

	public PolicyFile(File file, boolean verify) throws IOException {
		super(file, verify);
		// TODO Auto-generated constructor stub
	}

	public PolicyFile(String filename, boolean verify) throws IOException {
		super(filename, verify);
		// TODO Auto-generated constructor stub
	}

	public PolicyFile(File file, boolean verify, int mode) throws IOException {
		super(file, verify, mode);
		// TODO Auto-generated constructor stub
	}

	public String getPolicyName() {
		try {
			Attributes attrs = getManifest().getMainAttributes();
			if (attrs.containsKey(ATTR_NAME))
				return attrs.getValue(ATTR_NAME);
		} catch (IOException e) {
		}
		// No Name attr found, return file name
		return getName(); 
	}
	
	public InputStream getRacoonConfStream() throws IOException {
		return getInputStream(getJarEntry(RACOON_NAME));
	}

	public InputStream getSetkeyConfStream() throws IOException {
		return getInputStream(getJarEntry(SETKEY_NAME));
	}
}
