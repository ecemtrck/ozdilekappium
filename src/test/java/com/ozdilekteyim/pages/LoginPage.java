package com.ozdilekteyim.pages;

import com.ozdilekteyim.driver.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;


public class LoginPage extends BaseTest {
    @Step("LoginPage Kontrol Et")
    public void checkLoginPage()  {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/btnLogin"));
        String checkText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/btnLogin")).getText();
        Assertions.assertEquals("Giriş Yap", checkText,"Giriş Başarılı Bir Şekilde Yapılmadı");
        logger.info("LoginPage Kontrol Ediliyor");
    }
    @Step("Kullanıcı <email> email ve <password> sifre girilir")
    public void writeLoginBoxes(String email, String password) {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/etEposta")).sendKeys(email);
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/etPassword")).sendKeys(password);
        logger.info("Mail ve Şifre Girişi Yapılıyor");

    }
    @Step("Önceki Sayfaya Geri Dön")
    public void backToPage() {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/ivBack")).click();
        logger.info("Önceki Sayfaya Geri Dönülüyor");
    }
    @Step("Sepete ekle")
    public  void addToBasket() {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn")).click();
        logger.info("Ürün Sepete Ekleniyor");
    }

}
