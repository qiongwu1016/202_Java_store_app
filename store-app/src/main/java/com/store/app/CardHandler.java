package com.store.app;

public class CardHandler extends Handler {

    private Database db = Database.getInstance();
    private Order thisOrder;

    public CardHandler(Order order) {
        thisOrder = order;
    }

    public Boolean validate() {
        for (Request r: thisOrder.getRequests()) {
            String thisCard =  r.getCardNumber();
            if (!db.checkCardExist(thisCard)) {
                db.addCard(thisCard);
                System.out.println("New card number added to database: " + thisCard);
            }
        }

        return validateNext();
    }
}
