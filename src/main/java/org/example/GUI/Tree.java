package org.example.GUI;

import org.example.Library;
import org.example.Literature.Book;
import org.example.User.User;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class Tree {
    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Посетители");

    DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode("Студенты", true);
    DefaultMutableTreeNode professorNode = new DefaultMutableTreeNode("Преподаватели", true);

    Library libraries;
    JTree tree;
    public Tree(ArrayList<Library> libraries){
        fillUser(libraries);
        rootNode.add(professorNode);
        rootNode.add(studentNode);

        this.tree=new JTree(rootNode);
    }
    public JTree getTree(){
        return tree;
    }
    public void fillUser(ArrayList<Library> libraries){
        DefaultMutableTreeNode users;
        for (int i=0; i<libraries.size() ; i++){
            User currentUser=libraries.get(i).getUser();
            ArrayList<Book> currentBookList=libraries.get(i).getBooksOnHandsList();
            if(currentUser.getType().equals("преподаватель")){
                users=new DefaultMutableTreeNode(currentUser.getFullName());
                for (int k=0;k<currentBookList.size();k++){
                    users.add(new DefaultMutableTreeNode(currentBookList.get(k).getName()));
                }
                professorNode.add(users);

            }else {
                users=new DefaultMutableTreeNode(currentUser.getFullName());
                for (int k=0;k<currentBookList.size();k++){
                    users.add(new DefaultMutableTreeNode(currentBookList.get(k).getName()));
                }
                studentNode.add(users);
            }
        }
    }
}
