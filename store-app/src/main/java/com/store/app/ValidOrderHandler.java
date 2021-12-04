package com.store.app;

public class ValidOrderHandler extends Handler{
    private Database db = Database.getInstance();
    private Order thisOrder;

    public ValidOrderHandler(Order order) {
        thisOrder = order;
    }

    public Boolean validate() {
        Float totalAmount = 0f;
        for (Request r: thisOrder.getRequests()) {
            Item item = db.getItem(r.getItemName());
            totalAmount = totalAmount + item.price * r.getQuantity();
        }

        OutputFile file = new OutputFile(App.OUTPUT_FILE_PATH);
        file.writeToFile("Amt Paid,,,,");
        file.writeToFile(String.format("%.2f", totalAmount) + ",,,,");
        file.saveFile("output.csv");

        return validateNext();
    }
}
