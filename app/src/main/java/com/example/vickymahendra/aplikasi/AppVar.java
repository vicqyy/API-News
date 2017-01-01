package com.example.vickymahendra.aplikasi;

/**
 * Created by Vicky Mahendra on 12/31/2016.
 */


public class AppVar {

    //URL to our login.php file, url bisa diganti sesuai dengan alamat server kita
    public static final String LOGIN_URL = "http://192.168.1.6/apps/login.php";
    public static final String REGISTER_URL = "http://192.168.1.6/apps/registrasi.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_USERNAME = "username";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

}