package com.dialogs.cutome_search_simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dialogs.R;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;

public class Custom_simple_searchMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SimpleSearchDialogCompat(Custom_simple_searchMainActivity.this, "Search...",
                "What are you looking for...?", null, createSampleData(),
                new SearchResultListener<Custom_SampleSearchModel>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat dialog,
                                           Custom_SampleSearchModel item, int position) {
                        Toast.makeText(Custom_simple_searchMainActivity.this, item.getTitle(),
                                Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).show();
    }

    private ArrayList<Custom_SampleSearchModel> createSampleData(){
        ArrayList<Custom_SampleSearchModel> items = new ArrayList<>();
        items.add(new Custom_SampleSearchModel("First item"));
        items.add(new Custom_SampleSearchModel("Second item"));
        items.add(new Custom_SampleSearchModel("Karun Sing"));
        items.add(new Custom_SampleSearchModel("The ultimate item"));
        items.add(new Custom_SampleSearchModel("Last item"));
        items.add(new Custom_SampleSearchModel("Kumar karan"));
        items.add(new Custom_SampleSearchModel("Dolor sit"));
        items.add(new Custom_SampleSearchModel("Kaju Kumar"));
        items.add(new Custom_SampleSearchModel("guess who's back"));
        return items;
    }
}
