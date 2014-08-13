import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Mazesolver {
	public static HashMap <Node, HashSet<Node>> map = new HashMap <Node, HashSet<Node>>();
	public static void makeneighbour(Node n,int i, int j, char[][] lis){
		System.out.println("called");
		HashSet<Node> hs = new HashSet<Node>();
		if(i-1>='0'&&(lis[i-1][j]=='0'||lis[i-1][j]=='3')){
			Node m = new Node();
			if(lis[i-1][j]=='3')
				m.setisfin();
			hs.add(m);
			makeneighbour(m,i-1,j,lis);
		}
		if(i+1<lis.length&&(lis[i+1][j]=='0'||lis[i+1][j]=='3')){
			Node m = new Node();
			if(lis[i+1][j]=='3'){
				m.setisfin();
			}
			hs.add(m);
			makeneighbour(m,i+1,j,lis);
			
		}
		if(j+1<lis[0].length&&(lis[i][j+1]=='0'||lis[i][j+1]=='3')){
			Node m = new Node();
			if(lis[i][j+1]=='3'){
				m.setisfin();
			}
			hs.add(m);
			makeneighbour(m,i,j+1,lis);
		}
		if(j-1>='0'&&(lis[i][j-1]=='0'||lis[i][j-1]=='3')){
			Node m = new Node();
			if(lis[i][j-1]=='3'){
				m.setisfin();
			}
			hs.add(m);
			makeneighbour(m,i,j-1,lis);
		}
		map.put(n, hs);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("map_0.txt"));
		ArrayList <String> strlist = new ArrayList<String>();
		String line;
		while ((line = br.readLine()) != null) {
		   // process the line.
			strlist.add(line);
		}
		char lis[][] = new char[strlist.size()][strlist.get(0).length()];
		for(int i=0; i<strlist.size();i++){
			for(int j =0; j<strlist.get(0).length();j++ ){
				lis[i][j]=strlist.get(i).charAt(j);
			}
		}
		br.close();
		
		for(int i=0;i<lis.length;i++){
			for(int j=0;j<lis[0].length;j++){
				if(lis[i][j]=='2'){
					Node n = new Node();
					makeneighbour(n,i,j,lis);
					break;
				}
			}
			//System.out.println();
		}
		System.out.println(map.size()+""+map.values().size());
	}
	
}
