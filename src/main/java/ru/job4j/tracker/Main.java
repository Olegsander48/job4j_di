package ru.job4j.tracker;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("How old are you?");
        ui.add("Where are you from?");
        ui.print();
    }
}
