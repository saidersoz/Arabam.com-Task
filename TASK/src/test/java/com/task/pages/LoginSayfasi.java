package com.task.pages;

import com.task.utilities.BrowserUtils;
import com.task.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSayfasi extends BasePage{
    @FindBy(id = "emailOrPhone")
    private WebElement numaraKutusu;
    @FindBy(id = "password")
    private WebElement sifreKutusu;
    @FindBy(xpath = "//div[@class='form-row-error']//small")
    private WebElement uyariYazisi;
    @FindBy(xpath = "//button[contains(text(),'Giriş Yap')]")
    private WebElement girisYapButonu;
    @FindBy(xpath = "//img[@alt='arabam.com']")
    private WebElement loginDogrulamaNesnesi;

    public LoginSayfasi() {
    }
    public void setNumaraKutusu(String numara){
        if(numara.equalsIgnoreCase("gecerliNumara")){
            numaraKutusu.sendKeys(ConfigurationReader.getProperty("gecerliNumara"));
        }else if(numara.equalsIgnoreCase("gecersizNumara")){
            numaraKutusu.sendKeys(ConfigurationReader.getProperty("gecersizNumara"));
        }else{
            numaraKutusu.sendKeys("");
        }
    }
    public void setSifreKutusu(String sifre){
        if(sifre.equalsIgnoreCase("gecerliSifre")){
            sifreKutusu.sendKeys(ConfigurationReader.getProperty("gecerliSifre"));
        }else if(sifre.equalsIgnoreCase("gecersizSifre")){
            sifreKutusu.sendKeys(ConfigurationReader.getProperty("gecersizSifre"));
        }else{
            sifreKutusu.sendKeys("");
        }
    }
    public void girisYapButonunaTikla(){
        girisYapButonu.click();
    }
    public void loginDogrulama(String loginStatusu){
        if(loginStatusu.equalsIgnoreCase("oturum acma hatasi")){
            BrowserUtils.waitForVisibility(uyariYazisi,20);
            Assert.assertTrue(uyariYazisi.isDisplayed());
        }
        else{
            BrowserUtils.waitForVisibility(loginDogrulamaNesnesi,20);
            Assert.assertTrue(loginDogrulamaNesnesi.isDisplayed());
        }
    }

}
