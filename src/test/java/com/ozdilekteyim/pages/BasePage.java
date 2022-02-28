package com.ozdilekteyim.pages;

import com.thoughtworks.gauge.Step;
import com.ozdilekteyim.driver.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class BasePage extends BaseTest {

    @Step("Uygulamanın Çalıştığını Kontrol Et")
    public void uygulamaKontrol() {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingMarket"));
        String checkText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingMarket")).getText();
        Assertions.assertEquals("TESLİMAT BÖLGESİ SEÇ", checkText, "Uygulama doğru bir biçimde açılmadı");
        logger.info("Uygulama doğru bir şekilde açıldı");
    }
    @Step("Alışverişe Başla Butonuna Tıkla")
    public void clickStartShopping()  {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore"));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).click();
        logger.info("Alışverişe Başla Butonuna Tıklanıyor");
    }
    @Step("Alışveriş Sayfasının Açıldığını Kontrol Et")
    public void checkMainPageText()  {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/tvMarketName"));
        String checkText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvMarketName")).getText();
        Assertions.assertEquals("Market", checkText, "Alışveriş sayfası doğru açılmadı");
        logger.info("Alışveriş sayfası doğru açıldı mı kontrol ediliyor");
    }
}
