package com.company;

import Chain_of_Responsibility.Employee;
import Chain_of_Responsibility.LeadProgrammer;
import Chain_of_Responsibility.Manager;
import Chain_of_Responsibility.Programmer;
import Iterator.Item;
import Iterator.Menu;
import Mediator.User;
import State.ApplicationFinish;
import State.ApplicationStart;
import State.Context;
import Visitor.*;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	//Iterator

        Item i1 = new Item("spaghetti", 7.50f);
        Item i2 = new Item("hamburger", 6.00f);
        Item i3 = new Item("chicken sandwich", 6.50f);

        Menu menu = new Menu();
        menu.addItem(i1);
        menu.addItem(i2);
        menu.addItem(i3);

        System.out.println("Displaying Menu:");
        Iterator<Item> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item);
        }

        System.out.println("\nRemoving last item returned");
        iterator.remove();

        System.out.println("\nDisplaying Menu:");
        iterator = menu.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item);
       }
        //

        //Visitor
//        ItemElement[] items = new ItemElement[]{new Book(20, "1234"),new Book(100, "5678"),
//                new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")};
//
//        int total = calculatePrice(items);
//        System.out.println("Total Cost = "+total);

        //Mediator
//        User david = new User("David");
//        User scott = new User("Scott");
//
//        david.sendMessage("Hi Oleg! How are you?");
//        scott.sendMessage("I'm great! Thanks for asking. How are you?");

        //State
//        Context context = new Context();
//
//        ApplicationStart start = new ApplicationStart();
//        start.doAction(context);
//
//        System.out.println(context.getState());
//
//        ApplicationFinish finish = new ApplicationFinish();
//        finish.doAction(context);
//
//        System.out.println(context.getState());

        //Chain of Responsibility
//        Employee employeeChain = getChainOfEmployees();
//
//        employeeChain.doWork(Employee.PROGRAMER, "This is basic programming work.");
//        employeeChain.doWork(Employee.LEAD_PROGRAMER, "This is marginally more sophisticated programming work.");
//                employeeChain.doWork(Employee.MANAGER, "This is the work for a manager.");
//
    }
    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
    private static Employee getChainOfEmployees() {
        Employee programmer = new Programmer(Employee.PROGRAMER);
        Employee leadProgrammer = new LeadProgrammer(Employee.LEAD_PROGRAMER);
        Employee manager = new Manager(Employee.MANAGER);

        programmer.setNextEmployee(leadProgrammer);
        leadProgrammer.setNextEmployee(manager);

        return programmer;
    }
}













