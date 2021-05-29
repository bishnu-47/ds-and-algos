public class StaticArray{
    private int size;
    private int length;
    private int[] arr;

    public StaticArray(int size){
        if (size < 0) throw new IllegalArgumentException("Illegal size: " + size);
        this.size = size;
        this.length = 0;
        this.arr = new int[size];
    }

    // push
    public void push(int val){
        if(this.length == 0) {
            this.arr[0] = val;
            this.length++;
        }
        else if(this.length >= this.size){
            throw new ArrayIndexOutOfBoundsException("Index "+(this.length)+" out of bound for size "+ this.size);
        }else{
            this.arr[length] = val;
        this.length++;
        }
    }

    // delete
    public int removeAt(int idx){
        if(this.length == 0) throw new IndexOutOfBoundsException();
        int[] newArr = new int[this.size];
        int removedElement = this.arr[idx];

        for (int i=0, j=0; i<this.length; i++, j++) {
            if(idx == i) j--;
            else newArr[j] = this.arr[i];
        }

        this.arr = newArr;
        this.length--;
        return removedElement;
    }

    //pop
    public int pop(){
        return removeAt(this.length-1);
    }

    public int length(){
        return this.length;
    }

    // print
    public String toString(){
        if(this.length == 0) return null;
        String str = "[";
        for(int i=0; i<this.length;i++){
            str+= (i == this.length-1) ? this.arr[i] : this.arr[i]+", ";
        }
        str+="]";
        return str;
    }
} 