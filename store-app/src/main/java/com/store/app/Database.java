package com.store.app;
import java.util.HashMap; // import the HashMap class
import java.util.Vector;

public class Database {
    private HashMap<String, Item> items;
    private Vector<String> cards;

    // create a singleton object
    private static Database instance = new Database();

    //private constructor
    private Database(){
       items = new HashMap<String,Item>();
       cards = new Vector<String>();
    }

    //get a singleton object
    public static Database getInstance(){
        return instance;
    }


    public void addItem(Item item) {
        items.put(item.itemName, item);
    }

    public void setCards(Vector<String> cards) {
        this.cards = cards;
    }
    public void addCard(String cardNumber) {
        cards.add(cardNumber);
    }

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    // public Vector<String> getCards() {
    //     return cards;
    // }

    // public HashMap<String, Item> getItems() {
    //     return items;
    // }

    public Boolean checkItemExist(String item) {
        if (items.containsKey(item)) return true; 
        else return false;
    }

    public Boolean checkCardExist(String card) {
        if (cards.contains(card)) return true;
        else return false;
    }

    public Integer checkItemQuantity(String item) {
        return items.get(item).stockQuantity;
    }

}
