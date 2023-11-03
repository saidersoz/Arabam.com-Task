package com.task.pages;

import com.beust.ah.A;
import com.task.utilities.BrowserUtils;
import com.task.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AnaSayfa extends BasePage {
    @FindBy(xpath = "//img[@alt='arabam.com']")
    private WebElement anasayfaDogrulamaNesnesi;
    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    private WebElement cerezKabulEtButonu;
    @FindBy(xpath = "//a[contains(text(),'Giriş Yap')]")
    private WebElement girisYapButonu;
    @FindBy(xpath = "//input[@placeholder='Kelime, galeri adı veya ilan no ile ara']")
    private WebElement aramaKutusu;
    @FindBy(xpath = "//button[@aria-label='Ara']//*[name()='svg']")
    private WebElement aramaButonu;
    @FindBy(xpath = "//tr//td//h3")
    private List<WebElement> urunAdlari;
    @FindBy(xpath = "//span[@class='db no-wrap listing-price']")
    private List<WebElement> urunFiyatlari;
    @FindBy(xpath = "//h1[contains(text(),'Sonuç bulunamadı.')]")
    private WebElement sonucBulunamadiText;

    public AnaSayfa() {
    }
    public void cerezKabulEtButonunaTikla(){
        if(cerezKabulEtButonu.isDisplayed()){
            cerezKabulEtButonu.click();
        }else{
            Assert.assertTrue(true);
        }
    }
    public void girisYapButonunaTikla(){
        BrowserUtils.waitForVisibility(girisYapButonu,20);
        girisYapButonu.click();
    }
    public void anasayfaDogrulamaNesnesiniGoruntule(){
        driver.navigate().to(ConfigurationReader.getProperty("url"));
        BrowserUtils.waitForVisibility(anasayfaDogrulamaNesnesi,20);
        Assert.assertTrue(anasayfaDogrulamaNesnesi.isDisplayed());
    }
    public void setAramaKutusu(String urun){
        aramaKutusu.sendKeys(urun);
    }
    public void aramaButonunaTikla(){
        aramaButonu.click();
    }
    public void urunDogrulama(String urun){
        BrowserUtils.wait(3);
        for(int i=0;i<urunAdlari.size();i++){
            if(!urunAdlari.get(i).getText().toLowerCase().contains(urun)){
                Assert.assertTrue(false);
            }
        }
    }
    public void ilkUcUrundenEnUcuzunuBulma(){
        System.out.println("İlk üç ürün arasından en ucuz olan ürün: "+urunAdlari.get(enUcuzUrununIndexiniBul()).getText());
    }
    private int enUcuzUrununIndexiniBul() {
        List<Double> fiyatlar = new ArrayList<>();

        // İlk 3 ürünün fiyatını dönüştür ve fiyatlar listesine ekle.
        for (int i = 0; i < 3; i++) {
            String fiyatStr = urunFiyatlari.get(i).getText().replace(".", "").replace(" TL", "").replace(",", ".");
            double fiyat = Double.parseDouble(fiyatStr);
            fiyatlar.add(fiyat);
        }

        double minFiyat = Double.MAX_VALUE;
        int minFiyatIndex = -1;

        // İlk 3 ürün arasında en ucuz olanın indeksini bul.
        for (int i = 0; i < fiyatlar.size(); i++) {
            if (fiyatlar.get(i) < minFiyat) {
                minFiyat = fiyatlar.get(i);
                minFiyatIndex = i;
            }
        }

        // En ucuz ürünün indeksini döndür.
        return minFiyatIndex;
    }
    public void sonucBulunamadiTextDogrulama(String text){
        BrowserUtils.waitForVisibility(sonucBulunamadiText,20);
        Assert.assertTrue(sonucBulunamadiText.getText().equalsIgnoreCase(text));
    }
}
