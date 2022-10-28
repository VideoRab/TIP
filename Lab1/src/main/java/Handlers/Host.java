package Handlers;

import Controllers.GenericController;
import Interfaces.IAction;
import Interfaces.IHost;
import Models.Food;
import RuntimeExceptions.MyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Host implements IHost {
    private final String[] args;
    private final GenericController genericController;
    private final Map<String, IAction> actions;

    public Host(String[] args, GenericController genericController) {
        this.args = args;
        this.genericController = genericController;
        actions = new HashMap<>();
        actions.put("-sort", () -> printAllSortedByCalories());
        actions.put("-calories", () -> printSumOfCalories());
    }

    @Override
    public void execute() {
        for (String arg:args) {
            IAction action = actions.get(arg);
            if(action == null) {
                throw new MyException("Argument " + arg + " is not supported!");
            }

            action.invoke();
        }
    }

    public void printSumOfCalories() {
        int sum = genericController.getSumOfCalories();
        System.out.println("Sum of calories: " + sum);
    }

    public void printAllSortedByCalories() {
        ArrayList<Food> result = genericController.getAllSortedByCalories();
        result.forEach(System.out::println);
    }
}