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
    public void fillUser(ArrayList<Library> libraries) {
        for (Library library : libraries) {
            User currentUser = library.getUser();
            ArrayList<Book> currentBookList = library.getBooksOnHandsList();

            DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(currentUser.getFullName());

            for (Book book : currentBookList) {
                userNode.add(new DefaultMutableTreeNode(book.getName()));
            }

            if (currentUser.getType().equals("преподаватель")) {
                professorNode.add(userNode);
            } else {
                studentNode.add(userNode);
            }
        }
    }

}
