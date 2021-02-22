package Recent;

import java.io.File;

public class MainApp {
	
	public static enum types {Variable,DataType,Punctuation,Constant,KeyWords,Defaults};
	
	public static void main(String[] args) {
		File file = new File("/home/feroz/Desktop/Projects/test.txt");
		Processor processor = new Processor(file);
		processor.process();
		processor.buildSDT();
	}
}