package userInterfaces;

import org.openqa.selenium.By;

import java.util.ResourceBundle;

public class Elements_CalculoHipoteca {

    public static ResourceBundle rb = ResourceBundle.getBundle("VariablesCalculoHipoteca");
    public static String homePrice = rb.getString("homePrice");
    public static String downPayment = rb.getString("downPayment");
    public static String loanTerm = rb.getString("loanTerm");

    public static By logoRocketMortage = By.xpath("//*[@class=\"sprk-c-Masthead__logo c-Masthead__logo c-Masthead__logo--secondary lozad\"]");
    public static By labelMortageCalculator = By.xpath("//*[@class=\"sprk-b-TypeDisplayTwo sprk-b-PageTitle sprk-u-mbl\"]");
    public static By labelEstimatedMonPayment = By.xpath("//*[@class=\"phfc-c-Results__header  phfc-o-Stack__item\"]");
    public static By TableDetailPayment = By.xpath("//*[@class=\"purchResults phfc-c-Result__content phfc-o-Stack__item  phfc-o-Stack phfc-o-Stack--large phfc-o-Stack--split@s phfc-o-Box--large phfc-u-mbh\"]");

    public static By inpHomePrice = By.xpath("//*[@id=\"purchasePrice\"]");
    public static By selectDownPayment$ = By.xpath("//*[@id=\"buttonAmount\"]");
    public static By selectDownPaymentX = By.xpath("//*[@id=\"buttonPercent\"]");
    public static By inpDownPayment = By.xpath("//*[@id=\"downPayment\"]");
    public static By inpDownPaymentPercent = By.xpath("//*[@id=\"downPaymentPercent\"]");
    public static By inpInteresRate = By.xpath("//*[@id=\"rate\"]");
    public static By inpZipCode = By.xpath("//*[@id=\"zip\"]");
    public static By btnCalculate = By.xpath("//*[@id=\"calculateButton\"]");
    public static By detailPrincipalInterest = By.xpath("//*[@data-qa=\"monthlyPayment\"]");
    public static By detailTotalPayment = By.xpath("//*[@data-qa=\"totalMonthlyPayment\"]");

}
