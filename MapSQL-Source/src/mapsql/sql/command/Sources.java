package mapsql.sql.command;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import mapsql.sql.core.SQLCommand;
import mapsql.sql.core.SQLException;
import mapsql.sql.core.SQLManager;
import mapsql.util.List;

public class Sources implements SQLCommand {
	private String filename;
	
	public Sources(String filename) {
		this.filename = filename;
	}
	
	@Override
	public String execute(SQLManager manager) throws SQLException {
		Scanner sc= null;
		try {
            sc = new Scanner(new BufferedReader(new FileReader(filename)));
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return filename + " parsed";
	}
}
