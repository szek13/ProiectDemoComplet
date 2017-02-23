package org.fasttrackit.dev.todolist;



import java.util.*;

/**
 * Created by condor on April 04, 2015
 * FastTrackIT, 2015
 */
public class MyListOfToDoMock {

    private static MyListOfToDoMock m;

    public static MyListOfToDoMock getInstance() {

        if(m==null) {
            m=new MyListOfToDoMock();

        }
       return m;
    }


    private List<ToDoBean> toDoList = new ArrayList<ToDoBean>();
    private int id;



   public void addItem(String value) {
      id++;
      toDoList.add(new ToDoBean(id,value));
        }

    public void doneItem(int index) {
        for (ListIterator<ToDoBean> iter = toDoList.listIterator(); iter.hasNext(); ) {
            ToDoBean element = iter.next();

            if (element.getId()==index) {
                element.setDone(true);
                iter.set(element);
            }
        }
    }


    public void printList() {
        for (ListIterator<ToDoBean> iter = toDoList.listIterator(); iter.hasNext(); ) {
            ToDoBean element = iter.next();
            if (!element.isDone()) {
                System.out.print(element.getId() + ":");
                System.out.println(element.getWhatToDo());
            }

        }
    }

    public List getList() {
        return toDoList;
    }

}