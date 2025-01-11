package locators;

import org.openqa.selenium.By;

public class Locators {
    public static class ActionBuilderPageLocators {
        public static By openCalculator = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div/div[2]");
        public static By buttonAC = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[1]");
        public static By buttonPositiveNegative = By.xpath("b//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[2]");
        public static By buttonOne = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[13]");
        public static By buttonTwo = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[14]");
        public static By buttonThree = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[15]");
        public static By buttonFour = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[9]");
        public static By buttonFive = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[10]");
        public static By buttonSix = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[11]");
        public static By buttonSeven = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[5]");
        public static By buttonEight = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[6]");
        public static By buttonNine = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[7]");
        public static By buttonZero = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[17]");
        public static By buttonAdd = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[16]");
        public static By buttonSubstract = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[12]");
        public static By buttonMultiply = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[8]");
        public static By buttonDivide = By.xpath("#//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[4]");
        public static By buttonEqual = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[20]");
        public static By buttonDot = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[2]/div[19]");
        public static By areaResults = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[1]");
        public static By actualResults = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div/span");
    }
}