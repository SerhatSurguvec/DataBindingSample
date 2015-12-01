package com.example.serhat.databindingex.View;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.serhat.databindingex.Adapter.ContactAdapter;
import com.example.serhat.databindingex.Model.Contact;
import com.example.serhat.databindingex.R;
import com.example.serhat.databindingex.ViewModel.ContactVM;
import com.example.serhat.databindingex.databinding.ActivityMainBinding;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements MainActivityInterface {

    private ObservableArrayList<ContactVM> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //inits
        contacts = new ObservableArrayList<>();
        binding.setContacts(contacts);
        binding.setHandler(this);

        binding.rvContact.setLayoutManager(new LinearLayoutManager(this));
        binding.rvContact.setAdapter(new ContactAdapter(contacts));

    }

    @Override
    public void onAddClicked(View v) {

        if (contacts.size() > 0) {
            Random r = new Random();
            int i = r.nextInt(contacts.size());

            if (i % 2 == 0) {
                contacts.add(i, new ContactVM(new Contact("Luke", "Skywalker", "Jedi")));
            } else {
                contacts.add(i, new ContactVM(new Contact("Darth", "Vader", "Sith Lord")));
            }

        } else {
            contacts.add(new ContactVM(new Contact("R2D2", "!^+!%", "Astromech Droid")));
        }

    }

    @Override
    public void onRemoveClicked(View v) {

        Random r = new Random();
        int i = r.nextInt(contacts.size());

        contacts.remove(i);

    }

    @Override
    public void onChangeClicked(View v) {

        if (contacts.size() > 0) {
            Random r = new Random();
            int i = r.nextInt(contacts.size());
            int changedValue = r.nextInt(9);


            if (i % 2 == 0) {
                contacts.get(i).setSurname("Vader");
            } else {
                contacts.get(i).setName("Luke");
            }

            contacts.get(i).setTitle(contacts.get(i).getTitle() + changedValue);

        }
    }
}
