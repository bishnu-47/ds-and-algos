public class Nodes{
	private String key;
	private int value;

	public Nodes(String key, int val){
		this.key = key;
		this.value = val;
	}

	public String getKey(){
		return key;
	}

	public void setKey(String key){
		this.key = key;
	}

	public int getValue(){
		return value;
	}

	public void setValue(int val){
		this.value = val;
	}
}