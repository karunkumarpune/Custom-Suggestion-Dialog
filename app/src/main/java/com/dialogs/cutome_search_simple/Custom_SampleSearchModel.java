package com.dialogs.cutome_search_simple;

import ir.mirrajabi.searchdialog.core.Searchable;

public class Custom_SampleSearchModel implements Searchable {
    private String mTitle;

    public Custom_SampleSearchModel(String title) {
        mTitle = title;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public Custom_SampleSearchModel setTitle(String title) {
        mTitle = title;
        return this;
    }
}