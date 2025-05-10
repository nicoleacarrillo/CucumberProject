package utils;

import pages.AddEmployeePage;
import pages.LoginPage;
import steps.AddEmployee;

public class PageInitializer {
    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects(){
        loginPage=new LoginPage();
        addEmployeePage= new AddEmployeePage();
    }
}

