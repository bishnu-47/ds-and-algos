import java.util.ArrayList;
import java.util.List;

public class HashTable {
  private int length;
  private Nodes[] data;

  HashTable(int size){
    this.length = size;
    this.data = new Nodes[size];
  }

  public void set(String key, int val){
    int address = hash(key);
    Nodes n = new Nodes(key, val);

    data[address] = n;
  }

  private int get(String key){
    int address = hash(key);

    return data[address].getValue();
  }

  private int hash(String key) {
    int hash = 0;
    for (int i = 0; i < key.length(); i++) {
      hash = (hash + key.charAt(i) * i) % length;
    }
    return hash;
  }

  public static void main(String[] args) {
    HashTable h = new HashTable(50);
    h.set("grapes", 1000);
    h.set("applas", 200);
    h.set("applas", 3000);
    int v = h.get("applas");
    System.out.println(v);
  }
}
