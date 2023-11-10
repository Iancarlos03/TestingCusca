package stepDefinitions;

import interactions.BackspaceChar;
import interactions.CompareMessage;
import interactions.SelectDropDown;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import tasks.CalculaValorHipoteca;
import tasks.TestBase;
import tasks.ValidaHomePageMortageCalculator;
import userInterfaces.Elements_CalculoHipoteca;

public class CalculoDinamicoHipoteca extends TestBase {

    @Given("ingreso en la pagina rocket mortage")
    public void ingreso_en_la_pagina_rocket_mortage() {
        ValidaHomePageMortageCalculator.validaHomePage(driver);
    }

    @When("dejo los campos requeridos vacios")
    public void dejo_los_campos_requeridos_vacios() throws InterruptedException {
        BackspaceChar.backspaceChar(driver, Elements_CalculoHipoteca.inpHomePrice);
        BackspaceChar.backspaceChar(driver, Elements_CalculoHipoteca.inpDownPayment);
        BackspaceChar.backspaceChar(driver, Elements_CalculoHipoteca.inpInteresRate);
        BackspaceChar.backspaceChar(driver, Elements_CalculoHipoteca.inpZipCode);
    }

    @Then("se muestra mensaje de advertencia en cada campo.")
    public void se_muestra_mensaje_de_advertencia_en_cada_campo() {
        CompareMessage.textOfMessage(driver, "Please enter a home price.");
        CompareMessage.textOfMessage(driver, "Please enter a down payment.");
        CompareMessage.textOfMessage(driver, "Please enter a ZIP code.");
        CompareMessage.textOfMessage(driver, "Please enter an interest rate.");
    }

    @Given("ingreso en pagina rocket mortage")
    public void ingreso_en_pagina_rocket_mortage() {
        ValidaHomePageMortageCalculator.validaHomePage(driver);
    }
    @When("ingreso valor {int} en campos Home Price y Interest Rate")
    public void ingreso_valor_en_campos_home_price_y_interest_rate(Integer int1) throws InterruptedException {
        BackspaceChar.backspaceChar(driver, Elements_CalculoHipoteca.inpHomePrice);
        driver.findElement(Elements_CalculoHipoteca.inpHomePrice).sendKeys("0");
        BackspaceChar.backspaceChar(driver, Elements_CalculoHipoteca.inpInteresRate);
        driver.findElement(Elements_CalculoHipoteca.inpInteresRate).sendKeys("0");
    }
    @Then("se muestra mensaje de advertencia en cada campo por colocar {int}")
    public void se_muestra_mensaje_de_advertencia_en_cada_campo_por_colocar(Integer int1) {
        CompareMessage.textOfMessage(driver, "Please enter number greater than zero.");
        CompareMessage.textOfMessage(driver, "Please enter an interest rate greater than zero.");
    }

    @Given("ingreso en ambiente rocket mortage")
    public void ingreso_en_ambiente_rocket_mortage() {
        ValidaHomePageMortageCalculator.validaHomePage(driver);
    }
    @When("ingreso valor mayor a {int} en campos Interest Rate")
    public void ingreso_valor_mayor_a_en_campos_interest_rate(Integer int1) throws InterruptedException {
        BackspaceChar.backspaceChar(driver, Elements_CalculoHipoteca.inpInteresRate);
        driver.findElement(Elements_CalculoHipoteca.inpInteresRate).sendKeys("11");
    }
    @Then("se muestra mensaje de advertencia en campo Interest Rate al colocar numero mayor a {int}")
    public void se_muestra_mensaje_de_advertencia_en_campo_interest_rate_al_colocar_numero_mayor_a(Integer int1) {
        CompareMessage.textOfMessage(driver, "Please enter an interest rate of 10% or less.");
    }

    @Given("ingreso en web rocket mortage")
    public void ingreso_en_web_rocket_mortage() {
        ValidaHomePageMortageCalculator.validaHomePage(driver);
    }
    @When("selecciono $ en down payment y completo los campos requeridos")
    public void selecciono_$_en_down_payment_y_completo_los_campos_requeridos() {
        driver.findElement(Elements_CalculoHipoteca.inpHomePrice).clear();
        driver.findElement(Elements_CalculoHipoteca.inpHomePrice).sendKeys(Elements_CalculoHipoteca.homePrice);
        driver.findElement(Elements_CalculoHipoteca.selectDownPayment$).click();
        driver.findElement(Elements_CalculoHipoteca.inpDownPayment).clear();
        driver.findElement(Elements_CalculoHipoteca.inpDownPayment).sendKeys(Elements_CalculoHipoteca.downPayment);
        SelectDropDown.selectDropDown(driver);
        driver.findElement(Elements_CalculoHipoteca.inpInteresRate).clear();
        driver.findElement(Elements_CalculoHipoteca.inpInteresRate).sendKeys("4");
        driver.findElement(Elements_CalculoHipoteca.btnCalculate).sendKeys(Keys.ENTER);
    }
    @Then("valido que Total Payment sea correcto")
    public void valido_que_total_payment_sea_correcto() throws InterruptedException {
        CalculaValorHipoteca.valorHipoteca(driver);
    }

    @Given("ingreso a web rocket mortage")
    public void ingreso_a_web_rocket_mortage() {
        ValidaHomePageMortageCalculator.validaHomePage(driver);
    }

    @When("selecciono % en down payment y completo los campos requeridos")
    public void selecciono_en_down_payment_y_completo_los_campos_requeridos() {
        driver.findElement(Elements_CalculoHipoteca.inpHomePrice).clear();
        driver.findElement(Elements_CalculoHipoteca.inpHomePrice).sendKeys(Elements_CalculoHipoteca.homePrice);
        driver.findElement(Elements_CalculoHipoteca.selectDownPaymentX).click();
        CalculaValorHipoteca.calcularPorcentaje(driver);
        SelectDropDown.selectDropDown(driver);
        driver.findElement(Elements_CalculoHipoteca.inpInteresRate).clear();
        driver.findElement(Elements_CalculoHipoteca.inpInteresRate).sendKeys("4");
        driver.findElement(Elements_CalculoHipoteca.btnCalculate).sendKeys(Keys.ENTER);
    }

    @Then("valido Total Payment sea correcto")
    public void valido_total_payment_sea_correcto() throws InterruptedException {
        CalculaValorHipoteca.valorHipoteca(driver);
    }
}
