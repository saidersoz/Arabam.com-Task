package com.task.stepDefs;

import com.task.utilities.ConfigurationReader;
import com.task.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefs extends BaseStep{
    @Given("Kullanici Anasayfaya gider")
    public void kullanici_anasayfaya_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("Kullanici Cerezler icin cikan bildirimde Kabul Et Butonuna tiklar")
    public void kullanici_cerezler_icin_cikan_bildirimde_kabul_et_butonuna_tiklar() {
        pages.anaSayfa().cerezKabulEtButonunaTikla();
    }
    @When("Kullanici Giris yap butonuna tiklar")
    public void kullanici_giris_yap_butonuna_tiklar() {
        pages.anaSayfa().girisYapButonunaTikla();
    }
    @And("Kullanici acilan pencerede {string} numara girer")
    public void kullanici_acilan_pencerede_girer(String numara) {
        pages.loginSayfasi().setNumaraKutusu(numara);

    }
    @And("Kullanici acilan pencerede {string} sifre girer")
    public void kullanici_acilan_pencerede_girer_sifre(String sifre) {
        pages.loginSayfasi().setSifreKutusu(sifre);

    }
    @And("Kullanici login sayfasındaki giris yap butonuna tiklar")
    public void kullanici_login_sayfasindaki_giris_yap_butonuna_tiklar() {
        pages.loginSayfasi().girisYapButonunaTikla();

    }
    @Then("Kullanici acilan sayfada {string} dogrular")
    public void kullanici_acilan_sayfada_dogrular(String loginStatusu) {
        pages.loginSayfasi().loginDogrulama(loginStatusu);
    }
    @When("Kullanici urun arama alanina {string} girer")
    public void kullanici_urun_arama_alanina_girer(String model) {
        pages.anaSayfa().setAramaKutusu(model);

    }

    @When("Kullanici urun arama butonuna tiklar")
    public void kullanici_urun_arama_butonuna_tiklar() {
        pages.anaSayfa().aramaButonunaTikla();
    }
    @Then("Kullanici arama sonuclarinin {string} icerdigini dogrular")
    public void kullanici_arama_sonuclarinin_icerdigini_dogrular(String model) {
        pages.anaSayfa().urunDogrulama(model);
    }
    @Then("Kullanici aranan urunler arasindan ilk uc urunun en ucuzunu bulur")
    public void kullanici_aranan_urunler_arasindan_ilk_uc_urunun_en_ucuzunu_bulur() {
       pages.anaSayfa().ilkUcUrundenEnUcuzunuBulma();
    }
    @Then("Kullanici {string} yazisini gorur")
    public void kullanici_yazisini_gorur(String text) {
        pages.anaSayfa().sonucBulunamadiTextDogrulama(text);
    }


}
