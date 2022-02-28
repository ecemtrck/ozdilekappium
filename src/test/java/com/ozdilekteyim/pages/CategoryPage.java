package com.ozdilekteyim.pages;

import com.ozdilekteyim.driver.BaseTest;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.By.xpath;

public class CategoryPage extends BaseTest {
    @Step("Kategoriler Butonuna Tıkla")
    public void openCategoryPage()  {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/nav_categories"));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/nav_categories")).click();
        logger.info("Kategoriler Sayfası Açılıyor");


    }

    @Step("Kategoriler Sayfasının Açıldığını Kontrol Et")
    public void checkCategoryPage()  {
        waitUntilElementVisible(By.xpath("//android.widget.LinearLayout[@content-desc='Kategoriler']/android.widget.TextView"));
        String checkText = appiumDriver.findElement(xpath("//android.widget.LinearLayout[@content-desc='Kategoriler']/android.widget.TextView")).getText();
        Assertions.assertEquals("Kategoriler", checkText);
        logger.info("Kategoriler Sayfasının Açıldığı Kontrol Ediliyor");

    }

    @Step("Menüden Kadın Seçeneğine Tıkla")
    public void clickKadin()  {
        waitUntilElementVisible(By.xpath("//android.widget.RelativeLayout[@index='1']"));
        appiumDriver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']")).click();
        logger.info("Kadin Seçeneği Açılıyor");

    }

    @Step("Pantolon Seçeneğine Tıkla")
    public void clickPantolon()  {
        waitUntilElementVisible(By.xpath("//android.widget.RelativeLayout[@index='13']"));
        appiumDriver.findElement(By.xpath("//android.widget.RelativeLayout[@index='13']")).click();
        logger.info("Pantolon Seçeneği Açılıyor");

    }

    @Step("Sayfayı Aşağı Yönde Kaydır")
    public void scrollDown()  {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/relLayFilter"));
        for (int i = 0; i < 2; i++) {
            Dimension dimension = appiumDriver.manage().window().getSize();
            int start_x = (int) (dimension.width * 0.3);
            int start_y = (int) (dimension.height * 0.9);

            int end_x = (int) (dimension.width * 0.1);
            int end_y = (int) (dimension.height * 0.1);

            TouchAction touch = new TouchAction(appiumDriver);
            touch.press(PointOption.point(start_x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(end_x, end_y)).release().perform();

        }

        logger.info("Sayfa Aşağı Yönde Kaydırılıyor");
    }

    @Step("<Key> Rastgele Bir Ürün Seç")
    public void findAllProducts(String Key) throws InterruptedException {
        List<MobileElement> productList = appiumDriver.findElementsByXPath(Key);
        int size = productList.size();
        Random rnd = new Random();
        int randNum = rnd.nextInt(size);
        productList.get(randNum).click();

    }

    @Step("Ürün Detay Sayfasını Kontrol Et")
    public void checkProductDetail()  {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/tvSizeDesc"));
        String checkText = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvSizeDesc")).getText();
        Assertions.assertEquals("Beden:", checkText, "Ürün detay sayfası doğru açılmadı");
        logger.info("Ürün Detay Sayfası Kontrol Ediliyor");
    }

    @Step("Favorilere Ekle")
    public void addFav()  {
        waitUntilElementVisible(By.id("com.ozdilek.ozdilekteyim:id/relLayFav"));
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/relLayFav")).click();
        logger.info("Favorilere Ekleniyor");

    }


}
