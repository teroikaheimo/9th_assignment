package com.example.a9th_assingment;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
* Make an application which has three screens:

First screen displayed when you open the application is the log in-screen. In the screen you can do two things

1) Enter username and password to advance to the content screen.
2) Move to a screen where you can register a new username and a password.

In the password registeration screen you can either return back to the login page or enter a new username and password.
* Upon entering a new username successfully (the username was not in use before) you are returned to login screen.

On the login page if user enters username and password correctly the content page opens.
* Content page has only a button and a list of login attempts (failed and successful, with timestamps) of the current logged in user.
* The button logs the user out and returns to login page.

Usernames, passwords and login information is stored in SQLite database and it's accessed through Room-objects.
* */

public class MainActivity extends AppCompatActivity {
    private Toast loginFailedToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFailedToast = Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_LONG);
    }
}