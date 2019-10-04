import java.util.Arrays;

public class MyList<H> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;


    public MyList(){
        elements=new Object[DEFAULT_CAPACITY];
    }

    public void add(int index, Object element){
        if(size==elements.length){
            ensureCapacity();
        }

        elements[index]=element;
        size++;
    }

    private void ensureCapacity(){
        int newSize=elements.length*2;
        elements= Arrays.copyOf(elements, newSize);

    }

    public void remove(int index){
        for(int i=0;i<elements.length;i++){
            if(i>=index){
                elements[i]=elements[i+1];
            }
        }
    }

    public int size(){
        return size;
    }

    public H copy(){
        return (H) elements;
    }

    public boolean contains(H o){
        boolean check = false;
        for (int i=0;i<elements.length;i++){
            if(elements[i]==o){
                check=true;
            }else {
                check=false;
            }
        }
        return check;
    }

    public int indexOf(H o){
        int index=-1;
        for(int i=0;i<elements.length;i++){
            if (elements[i]==o){
                index=i;
                break;
            }
        }
        return index;
    }

    public H get(int i){
        if (i>=size||i<0){
            throw new IndexOutOfBoundsException("Index:"+i+",Size:"+i);
        }
        return (H) elements[i];
    }

    public void clear(){
        elements=new Object[DEFAULT_CAPACITY];
    }

}
