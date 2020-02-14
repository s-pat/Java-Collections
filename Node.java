/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author G00256260
 */
public class Node<E> {
   private E data;
   private Node<E> link;

   /**
      Constructor
      @param initialData The data for the new node.
      @param initialLink The link for the new node.
   */

   public Node( E initialData, Node<E> initialLink)
   {
      data = initialData;
      link = initialLink;
   }

   /**
      The getData method returns the node's data
      @return String with value from data field.
   */

   public E getData()
   {
       return data;
   }

   /**
      The getLink method returns the node's pointer to the next node
      @return a StringNode from the link field (pointer to next node).
   */

   public Node<E> getLink()
   {
       return link;
   }

   /**
      The setData method stores a value in the data field for the node.
      @param initialData The value to store in data.
   */

   public void setData(E initialData)
   {
      data = initialData;
   }

   /**
      The setLink method stores a value in the link field for the node
      which points to the next node in the linked list.
      @param initialLink The value to store in link.
   */

   public void setLink(Node<E> initialLink)
   {
      link = initialLink;
   }
}

