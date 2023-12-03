package model;

public enum Menu {
    ALL(1, "- View of Contacts"), FIN(2, "- Find Contact"), ADD(3, "- Add new Contact"), REM(4, "- Delete Contact"), EXIT(5, "- Exit")
    ;
    private int choice;
    private String name;

    Menu(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    public int getChoice() {
        return choice;
    }

    public String getName() {
        return name;
    }

    public static void printMenu(){
        Menu[] menus = Menu.values();
        for (Menu menu : menus) {
            System.out.println(menu.getChoice() + " " + menu.getName());
        }
    }
    public static void exit(){
        System.out.println("--Good Bay--");
        System.exit(0);
    }
}
