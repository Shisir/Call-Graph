package Recent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class Processor {
	
	Scanner Input;

	public Processor(File file) {
		try {
			Input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	ArrayList<String>tokens = new ArrayList<>();
	ArrayList<String>customCharacters = new ArrayList<>();
	String tokenName = "";
	
	public void process(){
		String customs[] = {"&&","||","==","<=",">="};
		for(int i=0; i<customs.length; i++){
			customCharacters.add(customs[i]);
		}
		while(Input.hasNext()){
			String line = Input.nextLine();
			for(int i=0; i<line.length(); i++){
				processLine(line.charAt(i));
			}
		}
	}
	public void processLine(char ch){
		if(Character.isLetter(ch) || (ch >= '0' && ch <= '9')) tokenName += ch;
		else{
			String checker = tokenName + ch;
			/*if(customCharacters.contains(tokenName)){
				System.out.println("feroz");
				tokens.remove(tokens.size()-1);
				tokens.add(checker);
				tokenName="";
				return;
			}*/
			if(!tokenName.equals("")){
				tokens.add(tokenName);
				tokenName = "";
			}
			if(ch==' ' || ch=='\t') return;
			if(ch==';') tokens.add(Character.toString(';'));	
			else tokens.add(new String(Character.toString(ch)));
		}
	}
	public void buildSDT(){
		for(String token: tokens){
			System.out.print(token+" ");
		}
		/*SDT sdt = new SDT(tokens);
		sdt.manageTree();
		for(Node Root:sdt.TreeRoots){
			TreePrinter t = new TreePrinter(Root);
			t.setSize(1300, 900);
			t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			t.setVisible(true);
		}*/
	}
}
