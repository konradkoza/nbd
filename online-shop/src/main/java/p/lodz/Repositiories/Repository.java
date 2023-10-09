package p.lodz.Repositiories;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Repository<T> {
    private ArrayList<T> elements;

    public Repository() {
        this.elements = new ArrayList<T>();
    }

    public T getElement(int number){
        if(number > elements.size()){
            return null;
        }
        return elements.get(number);
    }

    public void addElement(T element){
        if(element == null){
            return;
        }
        elements.add(element);
    }

    public ArrayList<T> find(Predicate<T> predicate) {
        ArrayList<T> found = new ArrayList<>();

        for (T element : elements) {
            if (element != null && predicate.test(element)) {
                found.add(element);
            }
        }

        return found;
    }

    public ArrayList<T> findAll(){
        Predicate<T> p = x -> true;
        return find(p);
    }

    public int size(){
        return elements.size();
    }

    public void remove(T element){
        if( element == null) {
            return;
        }
        elements.removeIf(x -> x == element);
    }

    public ArrayList<T> findById(int id){
        //TODO jak znalezc po ID w template??? zrobic czy usunąć ???
        return null;
    }


}
