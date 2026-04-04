interface Observer {
    void notify(String itemName);
}

class Customer implements Observer {
    private String name;
    private int notifications;

    public Customer(String name) {
        this.name = name;
        this.notifications = 0;
    }

    public void notify(String itemName) {
        this.notifications += 1;
    }

    public int countNotifications() {
        return this.notifications;
    }
}

class OnlineStoreItem {
    private String itemName;
    private int stock;
    private List<Observer> observers;

    public OnlineStoreItem(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
        observers = new LinkedList<>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.notify(itemName);
        }
    }

    public void updateStock(int newStock) {
        if (newStock > 0 && stock == 0) {
            notifyObservers();
        }
        this.stock = newStock;
    }
}
