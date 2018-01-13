package com.dialogs.image_searh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dialogs.R;
import com.dialogs.image_searh.models.ContactModel;
import com.dialogs.image_searh.services.ContactSearchDialogCompat;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;

public class MainActivityImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ContactSearchDialogCompat<>(MainActivityImage.this, "Search...",
                "What are you looking for...?", null, createSampleContacts(),
                new SearchResultListener<ContactModel>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat dialog,
                                           ContactModel item, int position) {
                        Toast.makeText(MainActivityImage.this, item.getTitle(),
                                Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).show();
    }



    private ArrayList<ContactModel> createSampleContacts(){
        ArrayList<ContactModel> items = new ArrayList<>();
        // Thanks to https://randomuser.me for the images
        items.add(new ContactModel("First item", "https://randomuser.me/api/portraits/women/93.jpg"));
        items.add(new ContactModel("Second item", "https://randomuser.me/api/portraits/women/79.jpg"));
        items.add(new ContactModel("nejha ", "https://randomuser.me/api/portraits/women/56.jpg"));
        items.add(new ContactModel("The ultimate item", "https://randomuser.me/api/portraits/women/44.jpg"));
        items.add(new ContactModel("Last item", "https://randomuser.me/api/portraits/women/82.jpg"));
        items.add(new ContactModel("kaju Singh", "http://1.bp.blogspot.com/-EUVJei-f0qY/ToFgC_gcEHI/AAAAAAAAAJY/wTQZlnsjbNg/s1600/kaju.jpg"));
        items.add(new ContactModel("Dolor sit", "https://randomuser.me/api/portraits/women/60.jpg"));
        items.add(new ContactModel("karun kumar", "http://2.bp.blogspot.com/-7VEqGyQIpSU/TkX1quf_S7I/AAAAAAAAAIw/_FfHr4Ck-Gw/s1600/KARUN+KUMAR+BCA.JPG"));
        items.add(new ContactModel("neha singh", "http://images6.fanpop.com/image/photos/35500000/Karun-kumar-Shekhpurwa-karunkumar2525-Neha-9661962057-mohania-Birthday-katrina-kaif-35575216-2233-2561.jpg"));
        return items;
    }
}
