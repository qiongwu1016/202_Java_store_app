package com.store.app;

public class CategoryCapHandler extends Handler {
    private Database db = Database.getInstance();
    private Order thisOrder;

    public CategoryCapHandler(Order order) {
        thisOrder = order;
    }

    public Boolean validate() {
        Integer requestEssential = 0;
        Integer requestLuxury = 0;
        Integer requestMisc = 0;

        for (Request r: thisOrder.getRequests()) {
            Item item = db.getItem(r.getItemName());
            if (item.category == Item.Category.ESSENTIAL) requestEssential = requestEssential + r.getQuantity();
            if (item.category == Item.Category.LUXURY) requestLuxury = requestLuxury + r.getQuantity();
            if (item.category == Item.Category.MISC) requestMisc = requestMisc + r.getQuantity();
        }
        if (requestEssential > App.ESSENTIAL_CAP) {
            OutputFile file = new OutputFile(App.OUTPUT_FILE_PATH);
            file.writeToFile("Please correct quantities.");
            String message = "Essential CAP:" + Integer.toString(App.ESSENTIAL_CAP) + "   request quantity:" + Integer.toString(requestEssential);
            file.writeToFile(message);
            for (Request r: thisOrder.getRequests()) {
                Item item = db.getItem(r.getItemName());
                if (item.category == Item.Category.ESSENTIAL)
                file.writeToFile("item:" + r.getItemName() + "   quantity:" + r.getQuantity());
            }
            file.saveFile("error_message.txt");
            return false;
        }

        if (requestLuxury > App.LUXURY_CAP) {
            OutputFile file = new OutputFile(App.OUTPUT_FILE_PATH);
            file.writeToFile("Please correct quantities.");
            String message = "Luxury CAP:" + Integer.toString(App.LUXURY_CAP) + "   Request:" + Integer.toString(requestLuxury);
            file.writeToFile(message);
            for (Request r: thisOrder.getRequests()) {
                Item item = db.getItem(r.getItemName());
                if (item.category == Item.Category.LUXURY)
                file.writeToFile("item:" + r.getItemName() + "   quantity:" + r.getQuantity());
            }
            file.saveFile("error_message.txt");
            return false;
        }

        if (requestMisc > App.MISC_CAP) {
            OutputFile file = new OutputFile(App.OUTPUT_FILE_PATH);
            file.writeToFile("Please correct quantities.");
            String message = "MISC CAP:" + Integer.toString(App.MISC_CAP) + "   Request:" + Integer.toString(requestMisc);
            file.writeToFile(message);
            for (Request r: thisOrder.getRequests()) {
                Item item = db.getItem(r.getItemName());
                if (item.category == Item.Category.MISC)
                file.writeToFile("item:" + r.getItemName() + "   quantity:" + r.getQuantity());
            }
            file.saveFile("error_message.txt");
            return false;
        }
        return validateNext();
    }
}
