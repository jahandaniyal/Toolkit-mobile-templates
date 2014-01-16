package com.flashcardapp.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



import android.content.Context;

public class GlobalData {
	   private static GlobalData instance = null;
	   String iQuizTitle = null;
	   String iQuizAuthor = null;
		BufferedReader br;
		List<String> iQuizList= new ArrayList<String>();
		
	   
	   int iSelectedIndex = -1;
	   protected GlobalData() {
	      // Exists only to defeat instantiation.
	   }
	   public static GlobalData getInstance() {
	      if(instance == null) {
	         instance = new GlobalData();
	      }
	      return instance;
	   }
	   
	    public void ReadContent(Context myContext) {
			try {
				br = new BufferedReader(new InputStreamReader(myContext.getAssets().open("flashcard_content.txt"))); // throwing a FileNotFoundException?
				iQuizTitle= br.readLine();
				iQuizAuthor= br.readLine();
				String text;
				while ((text = br.readLine()) != null) {
					iQuizList.add(text);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close(); // stop reading
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	}
}