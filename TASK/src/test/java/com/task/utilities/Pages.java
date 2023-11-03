package com.task.utilities;

import com.task.pages.AnaSayfa;
import com.task.pages.LoginSayfasi;

public class Pages {

    AnaSayfa anaSayfa;
    LoginSayfasi loginSayfasi;


    public Pages() {

        this.anaSayfa = new AnaSayfa();
        this.loginSayfasi = new LoginSayfasi();


    }


    public AnaSayfa anaSayfa() {
        return anaSayfa;
    }

    public LoginSayfasi loginSayfasi() {
        return loginSayfasi;
    }

}
