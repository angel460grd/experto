/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difuso;
import java.util.ArrayList;
import java.util.List;
/**
 * @param <T>
 */
public class BC<T> {
    private List<BC<T>> antecedents = new ArrayList<BC<T>>();
    private BC<T> consecuent = null;
    private T data = null;
    private int id_regla;
    /**
     * Constructor que sirve para cuando se crea un nodo con un valor objeto
     * @param data
     */
    public BC(T data) {
        this.data = data;
    }
    /**
     * Constructor que sirve cuando se crea un nodo con objeto, padre y costo
     * @param data
     * @param id_regla
     */
    public BC(T data, int id_regla) {
        this.data = data;
        this.id_regla = id_regla;
    }
    /**
     * Devuelve el nombre los hijos del nodo
     * @return
     */
    public List<T> getAntecedentsData() {
        List<T> lista = new ArrayList<T>();
        for(int i = 0; i< antecedents.size(); i++){
            lista.add(antecedents.get(i).data);
        }
        return lista;
    }
    /**
     * Devuelve la direccion temporal de los hijos del nodo
     * @return
     */
    public List<BC<T>> getAntecedents() {
        return antecedents;
    }
    /**
     * Devuelve el numero de hijos que posee un padre
     * @return
     */
    public int getNumberOfAntecedents() {
        if (antecedents == null) {
            return 0;
        }
        return antecedents.size();
    }
    /**
     * Devuelve el nodo hijo en la posicion especificada
     * @param index
     * @return
     */
    public BC<T> getAntecedentsAt(int index) {
        return antecedents.get(index);
    }
    /**
     * Devuelve el nombre del nodo hijo en la posicion especificada
     * @param index
     * @return
     */
    public T getAntecedentsDataAt(int index) {
        return antecedents.get(index).data;
    }
    /**
     * Agrega el padre del nodo
     * @param parent
     */
    public void setConsecuent(BC<T> parent) {
        parent.addAntecedent(this);
        this.consecuent = parent;
    }
    /**
     * Devuelve la informacion el padre del nodo
     * @return
     */
    public T getConsecuentData() {
        return consecuent.data;
    }
    /**
     * Devuelve el nodo padre
     * @return
     */
    public BC<T> getConcecuent() {
        return consecuent;
    }
    /**
     * Agrega un nuevo hijo al nodo
     * @param child
     */
    public void addAntecedent(BC<T> child) {
        //child.setParent(this);
        this.antecedents.add(child);
    }
    /**
     * Obtiene los datos inmediatos de un nodo
     * @return
     */
    public T getData() {
        return this.data;
    }
    /**
     * Este no se pa que existe, ni hace nada
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * Obtiene los datos inmediatos de un nodo
     * @return
     */
    public int getId_regla() {
        return this.id_regla;
    }
    /**
     * Este no se pa que existe, ni hace nada
     * @param data
     */
    public void setId_regla(int id_regla) {
        this.id_regla = id_regla;
    }
    /**
     * Comprueba si el nodo es raiz
     * @return boolean
     */
    public boolean isRoot() {
        return (this.consecuent == null);
    }
    /**
     * Comprueba si el nodo es hoja (nodo sin hijos)
     * @return
     */
    public boolean isLeaf() {
        if(this.antecedents.size() == 0)
            return true;
        else
            return false;
    }
    /**
     * Elimina padre de nodo
     */
    public void removeConcecuent() {
        this.consecuent = null;
    }
    /**
     * Quita a un nodo hijo de su padre
     */
    public void removeAntecedentAt(int index) {
        this.antecedents.remove(index);
    }
}
