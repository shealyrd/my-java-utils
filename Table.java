import java.util.ArrayList;


public class Table {
	ArrayList<Integer> widths = new ArrayList<Integer>();
	ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
	
	public void addRow(Object... inputs){
		ArrayList<String> row = new ArrayList<String>();
		for(Object obj: inputs){
			row.add(obj.toString());
		}
		if(widths.isEmpty()){
			for(Object obj: inputs){
				widths.add(obj.toString().length());
			}
		}
		else{
			for(int i = 0; i < inputs.length; i++){
				if(widths.get(i) < inputs[i].toString().length()){
					widths.set(i, inputs[i].toString().length());
				}
			}
		}
		rows.add(row);
	}

	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(ArrayList<String> row: rows){
			for(int i = 0; i < row.size(); i++){
				builder.append("|" + toLength(row.get(i), widths.get(i)));
			
			}
			builder.append("|\n");
		}
		return builder.toString();
	}
	
	public static String toLength(String str, int length){
		StringBuilder builder = new StringBuilder();
		
		if(str.length() < length){
			builder.append(str);
			int padding = length - str.length();
			for(int i = 0; i < padding; i++){
				builder.append(" ");
			}
		}
		else if(str.length() > length){
			str = str.substring(0, length);
			builder.append(str);
		}
		else{
			builder.append(str);
		}
		return builder.toString();
	}
}
