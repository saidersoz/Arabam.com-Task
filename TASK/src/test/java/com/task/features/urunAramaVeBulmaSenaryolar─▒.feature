Feature: Ana Task
  Background:
    Given Kullanici Anasayfaya gider
    When Kullanici Cerezler icin cikan bildirimde Kabul Et Butonuna tiklar
    And Kullanici Giris yap butonuna tiklar
    And Kullanici acilan pencerede "gecerliNumara" numara girer
    And Kullanici acilan pencerede "gecerliSifre" sifre girer
    And Kullanici login sayfasındaki giris yap butonuna tiklar
    Then Kullanici acilan sayfada "basarili oturum" dogrular

  Scenario: Arabam.com sitesine login olduktan sonra istenen urunu aratma

    When Kullanici urun arama alanina "golf" girer
    And Kullanici urun arama butonuna tiklar
    Then Kullanici arama sonuclarinin "golf" icerdigini dogrular
    And Kullanici aranan urunler arasindan ilk uc urunun en ucuzunu bulur

  Scenario:Arabam.com sitesine login olduktan sonra olmayan urun aratma
    When Kullanici urun arama alanina "veyron" girer
    And Kullanici urun arama butonuna tiklar
    Then Kullanici "Sonuç bulunamadı." yazisini gorur

  Scenario:Arabam.com sitesine login olduktan sonra gecersiz anahtar kelime ile urun aratma
    When Kullanici urun arama alanina "dsfgrgrw" girer
    And Kullanici urun arama butonuna tiklar
    Then Kullanici "Sonuç bulunamadı." yazisini gorur





