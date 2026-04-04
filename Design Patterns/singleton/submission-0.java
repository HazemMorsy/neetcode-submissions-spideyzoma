static class Singleton {

    private static Singleton uniqueInstance = null;
    String singleVal;

    private Singleton() {
        
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }

    public String getValue() {
        return this.singleVal;
    }

    public void setValue(String value) {
        this.singleVal = value;
    }
    
}
