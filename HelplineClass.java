package com.example.shreyaghose.umeed;

import android.provider.ContactsContract;

/**
 * Created by Shreya Ghosh on 07-10-2018.
 */

public class HelplineClass {
    private String Name,Contact,Email;

    public HelplineClass()
    {

    }

    public HelplineClass(String name, String contact, String email) {
        this.Name = name;
        this.Contact = contact;
        this.Email= email;
    }

    public String getName() {
        return Name;
    }


    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
