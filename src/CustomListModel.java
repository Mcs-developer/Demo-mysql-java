
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marloncs
 */
public class CustomListModel extends AbstractListModel{
    ArrayList<Person> list;

    public CustomListModel() {
    }
    
    public CustomListModel(ArrayList<Person> list) {
        this.list = list;
    }

    public void setList(ArrayList<Person> list) {
        this.list = list;
        this.fireContentsChanged(this, getSize(), getSize());
    }
    
    
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        Person p = list.get(index);
        return p.getCode() + " - " + p.getName();
    }
    
    public void addPerson(Person p){
        list.add(p);
        this.fireIntervalAdded(this, getSize(), getSize() + 1);
    }
    
    public void deletePerson(int index0){
        list.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize() + 1);
    }
    
    public Person getPerson(int index){
        return list.get(index);
    }
    
    public void update(int index, Person p){
        Person temp = getPerson(index);
        temp.setCode(p.getCode());
        temp.setName(p.getName());
        temp.setBirthDay(p.getBirthDay());
        fireContentsChanged(this, index, index);
    }
    
}
