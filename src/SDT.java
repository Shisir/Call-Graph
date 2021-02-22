package Recent;

import java.util.ArrayList;
import java.util.Stack;

public class SDT {
	ArrayList <Node> TreeRoots = new ArrayList<>();
	ArrayList <String> Tokens;
	ArrayList <String> DataTypes= new ArrayList<>();
	ArrayList <String> Comparators = new ArrayList<>();
	Node Root = null;
	
	public SDT(ArrayList<String>tokens) {
		Tokens = tokens;
		String dataTypes[] = {"int","float","double","void","long"};
		for(int i=0; i<dataTypes.length; i++)
			DataTypes.add(dataTypes[i]);
		String comparators[] = {"=",">","<"};
		for(int i=0; i<comparators.length; i++)
			Comparators.add(comparators[i]);
	}
	
	public void manageTree(){
		
		int loopNUmber = 1;
		Stack<Loop>Loops = new Stack<>();
		Node Previous=null,Current=null;
		String previousToken = new String();
		
		for(int i=0; i<Tokens.size(); i++){
			
			String currentToken = Tokens.get(i);
			
			if(DataTypes.contains(currentToken)){
				i++;
				String nextToken = Tokens.get(i);
				Previous = new Node("declare", currentToken);
				Current = new Node("",nextToken);
				Previous.RightChild = Current;
				Root = Previous;
				
				
				while(true){
					i++;
					currentToken = Tokens.get(i);
					if(currentToken.equals(";")){
						Current.Name = ";";
						TreeRoots.add(Root);
						break;
					}
					else if(currentToken.equals("=")){
						ExpressionTree e = new ExpressionTree();
						while(true){
							i++;
							nextToken = Tokens.get(i);
							if(nextToken.equals(",") || nextToken.equals(";")){
								e.buildTree();
								Node left = new Node("=", Current.LeftChild.Name);
								left.RightChild = e.Root;
								Current.LeftChild = left;
								i--;
								break;
							}
							else{
								e.add(nextToken);
							}
						}
					}
					else if(currentToken.equals(",")){
						Current.Name = ",";
						i++;
						nextToken = Tokens.get(i);
						Current.RightChild = new Node("", nextToken);
						Current = Current.RightChild;
					}
					else{
						System.out.println(currentToken);
					}
				}
			}
			else if(currentToken.equals("while")){
				TreeRoots.add(new Node("StartOfLoop"+Integer.toString(loopNUmber)));
				TreeRoots.add(new Node("EndOfLoop"+Integer.toString(loopNUmber)));
				loopNUmber++;
			}
			else if(currentToken.equals("true") || currentToken.equals("false")){
				
			}
			else if(currentToken.equals("do")){
				
			}
			else if(currentToken.equals("for")){
				
			}
			else if(Comparators.contains(currentToken)){
				
			}
			else{
				
			}
		}
	}
	
	public boolean compare(int begin, int end){
		return true;
	}
}
