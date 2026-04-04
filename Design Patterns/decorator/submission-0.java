abstract class Coffee {
    public abstract double getCost();
}

class SimpleCoffee extends Coffee {
    @Override
    public double getCost() {
        return 1.1;
    }
}

abstract class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}

class CreamDecorator extends CoffeeDecorator {
    CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.7;
    }
}
