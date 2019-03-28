package com.example.shreyaghose.umeed;

/**
 * Created by Shreya Ghosh on 07-10-2018.
 */

public class PsychologistsClass {
    private String Name,Contact;

    public PsychologistsClass()
    {

    }

    public PsychologistsClass(String name, String contact) {
        this.Name = Name;
        this.Contact = Contact;
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
}

