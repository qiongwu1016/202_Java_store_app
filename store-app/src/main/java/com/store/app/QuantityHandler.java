package com.store.app;

public class QuantityHandler extends Handler {

    private Database db = Database.getInstance();
    private Order thisOrder;

    public QuantityHandler(Order order) {
        thisOrder = order;
    }

    public Boolean validate() {
        for (Request r: thisOrder.getRequests()) {
            if (!db.checkItemExist(r.getItemName())) {
                // print err;
                OutputFile file = new OutputFile(App.OUTPUT_FILE_PATH);
                file.writeToFile("Item does not exist.");
                file.saveFile("error_message.txt");
                return false;
            }
            if (db.checkItemQuantity(r.getItemName()) < r.getQuantity()) {
                // print err;
                OutputFile file = new OutputFile(App.OUTPUT_FILE_PATH);
                file.writeToFile("Please correct quantities.");
                file.writeToFile("item:" + r.getItemName() + "   quantity:" + r.getQuantity());
                file.saveFile( "error_message.txt");
                return false;
            }
        }
        return validateNext();
    }
}
