package Selenium;

import org.testng.annotations.*;

public class Selenium8 {

    //Before class se izvrsava samo jednom na pocetku
    @BeforeClass
    public void beforeClass() {
        System.out.println("************");
        System.out.println("Ispis iz before class");
        System.out.println("************");
    }

    //Before method se izvrsava pre svake test metode
    //Koliko ima test metoda toliko ce puta i da se ponovi before method kod pokretanja klase
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("----------");
        System.out.println("Ispis iz before metode");
        System.out.println("----------");
    }

    @Test (priority = 10)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test (priority = 20)
    public void test2() {
        System.out.println("Test 2");
    }

    @Test (priority = 30)
    public void test3() {
        System.out.println("Test 3");
    }

    @Test (priority = 40)
    public void test0() {
        System.out.println("Test 0 potrebno izvrsiti pre svih");
    }

    @Test
    public void test5() {
        System.out.println("Test 5");
    }

    //After method se izvrsava posle test metode
    //Koliko ima test metoda toliko ce puta i da se ponovi after method kod pokretanja klase
    @AfterMethod
    public void afterMethod() {
        System.out.println("===========");
        System.out.println("Ispis iz after metode");
        System.out.println("===========");
    }

    //After class se izvrsava na kraju samo
    @AfterClass
    public void afterClass() {
        System.out.println("******************");
        System.out.println("Ispis iz after class");
        System.out.println("******************");
    }

}