package tasks;

import org.openqa.selenium.WebDriver;
import userInterfaces.Elements_CalculoHipoteca;
import java.util.ResourceBundle;

import static org.junit.Assert.assertTrue;

public class CalculaValorHipoteca {

    public static ResourceBundle rb = ResourceBundle.getBundle("VariablesCalculoHipoteca");

    public static void valorHipoteca(WebDriver driver) throws InterruptedException {

        int homePrice = Integer.parseInt(rb.getString("homePrice"));
        int downPayment = Integer.parseInt(rb.getString("downPayment"));
        int loanTerm = Integer.parseInt(rb.getString("loanTerm"));

        int montTotHiptcaCnPagoIni = homePrice - downPayment;

        int mesesTotales = loanTerm * 12;

        double interesMensual = 1.0033333;

        double interesPotenciaMeses = (double) Math.pow(interesMensual, mesesTotales);

        double interesPorInteres = interesPotenciaMeses * 0.0033333;

        double interesMenosUno = interesPotenciaMeses - 1;

        double interesFinal = interesPorInteres / interesMenosUno;

        double cuotaTotal = montTotHiptcaCnPagoIni * interesFinal;

        double roundCuotaTotal = Math.round(cuotaTotal * 100) / 100.0;

        Thread.sleep(3000);

        String pInterest = driver.findElement(Elements_CalculoHipoteca.detailPrincipalInterest).getText().replaceAll("[$ ,]","");
        String totPay = driver.findElement(Elements_CalculoHipoteca.detailTotalPayment).getText().replaceAll("[$ ,]" , "");

        double principalInterest = Double.parseDouble(pInterest);

        double totalPayment = Double.parseDouble(totPay);

        double prinInterestFin = roundCuotaTotal - principalInterest;
        double totPaymentFinal = roundCuotaTotal - totalPayment;

        double roundInterestFin = Math.round(prinInterestFin * 100) / 100.0;
        double roundTotPaymentFin = Math.round(totPaymentFinal * 100) / 100.0;

        System.out.println(roundCuotaTotal);
        System.out.println(roundTotPaymentFin);

        assertTrue(roundInterestFin == 0.01 || roundInterestFin == 0.0 || roundInterestFin == -0.01);
        assertTrue(roundTotPaymentFin == 0.01 || roundTotPaymentFin == 0.0 || roundTotPaymentFin == -0.01);
    }

    public static void calcularPorcentaje(WebDriver driver){
        double homePrice2 = Double.parseDouble(rb.getString("homePrice"));
        double downPayment2 = Double.parseDouble(rb.getString("downPayment"));

        System.out.println(homePrice2);
        System.out.println(downPayment2);

        double porcentaje = downPayment2 / homePrice2;
        double porcentajeFin = porcentaje * 100;

        System.out.println(porcentaje);
        System.out.println(porcentajeFin);
        String porcentajeConvert = String.valueOf(porcentajeFin);

        driver.findElement(Elements_CalculoHipoteca.inpDownPaymentPercent).clear();
        driver.findElement(Elements_CalculoHipoteca.inpDownPaymentPercent).sendKeys(porcentajeConvert);
    }
}
