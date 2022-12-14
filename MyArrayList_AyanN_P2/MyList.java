/*
 * DO NOT MODIFY THIS INTERFACE.
 * YOU CANNOT SUCCESFULLY COMPLETE THE LAB OR FUTURE LABS IF YOU CHANGE ANYTHING
 * IN THIS INTERFACE
 * There are no user serviceable parts inside.
 * Altering this class in any way will void your warranty.
 * @author Mr. Page
 * @version 092713
 */

public interface MyList<E> extends Iterable<E> 
{
    int size();
    boolean add(E obj);
    void add(int index, E obj);
    E get(int index);
    E set(int index, E obj);
    E remove(int index);
    
    MyIterator<E> iterator();
    MyListIterator<E> listIterator();    
    
}
