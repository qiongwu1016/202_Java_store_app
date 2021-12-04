package com.store.app;

public class Item {

    // public Item() {

    // }

    public Item(String itemName, Integer quantity, Float price) {
        category = Category.MISC;
        this.itemName = itemName;
        this.stockQuantity = quantity;
        this.price = price;
    }
    
    enum Category {
        ESSENTIAL, LUXURY, MISC
    }

    public Category category;
    public String itemName;
    public Integer stockQuantity;
    public Float price;

    public void setCategory(String cat) {
        switch(cat) {
            case "Essential": 
            this.category = Category.ESSENTIAL;
            break;
            case "Luxury":
            this.category = Category.LUXURY;
            break; 
            case "Misc":
            this.category = Category.MISC;
            break;
        }
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setStockQuantity(Integer quantity) {
        this.stockQuantity = quantity;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String toString() {
		return "In stock [category=" + category + ", name=" +  itemName + ", quantity=" + stockQuantity + ", price=" + price
				+ "]";
	}

}