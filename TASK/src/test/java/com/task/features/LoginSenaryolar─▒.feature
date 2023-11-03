Feature: Arabam.com Login Senaryoları

  Scenario Outline: TC01-Arabam.com sitesine gidip giris yapma-"<numara>"/ "<sifre>"
    Given Kullanici Anasayfaya gider
    When Kullanici Cerezler icin cikan bildirimde Kabul Et Butonuna tiklar
    And Kullanici Giris yap butonuna tiklar
    And Kullanici acilan pencerede "<numara>" numara girer
    And Kullanici acilan pencerede "<sifre>" sifre girer
    And Kullanici login sayfasındaki giris yap butonuna tiklar
    Then Kullanici acilan sayfada "<login statusu>" dogrular

    Examples:
      | numara         | sifre         | login statusu      |
      | gecersizNumara |               | oturum acma hatasi |
      | gecersizNumara | gecerliSifre  | oturum acma hatasi |
      | gecersizNumara | gecersizSifre | oturum acma hatasi |
      |                | gecerliSifre  | oturum acma hatasi |
      |                | gecersizSifre | oturum acma hatasi |
      |                |               | oturum acma hatasi |
      | gecerliNumara  |               | oturum acma hatasi |
      | gecerliNumara  | gecersizSifre | oturum acma hatasi |
      | gecerliNumara  | gecerliSifre  | basarili oturum    |














