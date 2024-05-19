package code;

import java.util.ArrayList;

public class LLAPSearch extends GenericSearch {

	

	public LLAPSearch(String init) {
		super(init);
		// TODO Auto-generated constructor stub
	}

	public static String solve(String initalState, String strategy, boolean visualize) {
		LLAPproblem proplem=new LLAPproblem(initalState);
		Node initialNode=new Node(proplem.getInitialProsperity(),proplem.getInitialFood(),proplem.getInitialMaterials(),proplem.getInitialEnergy(),0,0,0,"RootNode");
		Node result = null;
		switch(strategy) {
		case "BF":
			result=BFS(initialNode);
			if(result.getProsperity()<100)
			{
			return"NOSOLUTION";
			
			}
				break;
				
		case "DF":
			result=DFS(initialNode);
			if(result.getProsperity()<100)
			{
				return"NOSOLUTION";
		
		}
		break;
	
		case "ID":
			result=ID(initialNode);
			if(result.getProsperity()<100)
				{
				return"NOSOLUTION";
		
				}
		break;
		
		case "UC":
			result=UC(initialNode);
		break;
		
		case "GR1":
			result=GR1(initialNode);
			if(result.getProsperity()<100)
			{
			return"NOSOLUTION";
	
			}
		break;
		
		case "GR2":
			result=GR2(initialNode);
			if(result.getProsperity()<100)
			{
			return"NOSOLUTION";
			}
		break;
		
		case "AS1":
			result=AS1(initialNode);
			if(result.getProsperity()<100)
			{
			return"NOSOLUTION";
			}
		break;
		
		case "AS2":
			result=AS2(initialNode);
			if(result.getProsperity()<100)
			{
			return"NOSOLUTION";
			}
		break;
		
		}
		
		return FinalResult(result);
	}
	
	
	public static String FinalResult(Node node) {
		String plan = ""; //Path that it took took to reach final 
		String monetaryCost= ""; // Money Spent to get to the Final 
		String nodesExpanded= nodes_expanded+""; // All Nodes visited 
		String Result; // Print all the above in 1 String
		
		monetaryCost=node.getMoney_spent()+"";
		
		ArrayList<String> stringReversed = new ArrayList<String>();
		
		while(!node.getNameOfOperator().equals("RootNode")) {
			stringReversed.add(node.getNameOfOperator()) ;
			node=node.getParent();
		}
		
		for(int i = stringReversed.size()-1;i >= 0;i--) {
			if(i == stringReversed.size()-1) {
				plan =stringReversed.get(i);
			}else {
				plan = plan + "," + stringReversed.get(i);
			}
			
		}
		Result= plan + ";" + monetaryCost + ";" + nodesExpanded;
		return Result;
		
		
	}
	public static void main (String[] args) {
		String initialState9 = "50;" +
				"20,16,11;" +
				"76,14,14;" +
				"7,1;7,1;7,1;" +
				"359,14,25,23,39;" +
				"524,18,17,17,38;";
		System.out.println(solve(initialState9,"GR1",false));
		
	}

}
