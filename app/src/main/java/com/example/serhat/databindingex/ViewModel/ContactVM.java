package com.example.serhat.databindingex.ViewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.serhat.databindingex.BR;
import com.example.serhat.databindingex.Model.Contact;

/**
 * Created by Serhat on 01/12/15.
 */
public class ContactVM extends BaseObservable {

    private Contact contact;

    public ContactVM(Contact contact) {
        this.setContact(contact);
    }

    @Bindable
    public String getName() {
        return contact.getName();
    }

    @Bindable
    public String getSurname() {
        return contact.getSurname();
    }

    @Bindable
    public String getTitle() {
        return contact.getTitle();
    }


    @Bindable
    public String getImageUrl() {
        return contact.getImageUrl();
    }

    public void setName(String name) {
        this.contact.setName(name);
        notifyPropertyChanged(BR.name);
    }

    public void setSurname(String surname) {
        this.contact.setSurname(surname);
        notifyPropertyChanged(BR.surname);
    }

    public void setTitle(String title) {
        this.contact.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    public void setImageUrl(String imageUrl) {
        this.contact.setImageUrl(imageUrl);
        notifyPropertyChanged(BR.imageUrl);
    }

    public void setContact(Contact contact) {
        this.contact = contact;
        notifyPropertyChanged(BR.name);
        notifyPropertyChanged(BR.surname);
        notifyPropertyChanged(BR.title);
        notifyPropertyChanged(BR.imageUrl);
    }

}
