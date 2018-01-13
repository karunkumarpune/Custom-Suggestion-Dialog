package com.dialogs.search_api;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Filter;
import android.widget.Toast;

import com.dialogs.R;
import com.dialogs.search_api.models.UserModel;
import com.dialogs.search_api.services.UsersService;

import java.io.IOException;
import java.util.ArrayList;

import ir.mirrajabi.okhttpjsonmock.interceptors.OkHttpMockInterceptor;
import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseFilter;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityAPI extends AppCompatActivity {

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;
    private UsersService mUsersService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new OkHttpMockInterceptor(this, 5))
                .build();
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://raw.githubusercontent.com")
                .client(mOkHttpClient)
                .build();
        mUsersService = mRetrofit.create(UsersService.class);




        //call method
        provideSimpleDialogWithApiCalls();
    }


   private void provideSimpleDialogWithApiCalls() {

        final SimpleSearchDialogCompat<UserModel> searchDialog =
                new SimpleSearchDialogCompat(MainActivityAPI.this, "Search...",
                        "What are you looking for...?", null, new ArrayList(),
                        new SearchResultListener<Searchable>() {
                            @Override
                            public void onSelected(BaseSearchDialogCompat dialog,
                                                   Searchable item, int position) {
                                Toast.makeText(MainActivityAPI.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
        BaseFilter apiFilter = new BaseFilter() {
            @Override
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                doBeforeFiltering();
                Filter.FilterResults results = new Filter.FilterResults();
                results.values = new ArrayList<UserModel>();
                results.count = 0;
                try {
                    ArrayList<UserModel> users = mUsersService
                            .getFakeUsersBasedOnASearchTag(charSequence.toString())
                            .execute()
                            .body();
                    if(users != null) {
                        results.values = users;
                        results.count = users.size();
                    }
                    return results;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                if(filterResults != null) {
                    ArrayList<UserModel> filtered = (ArrayList<UserModel>) filterResults.values;
                    if(filtered != null)
                        searchDialog.getFilterResultListener().onFilter(filtered);
                    doAfterFiltering();
                }
            }
        };
        searchDialog.setFilter(apiFilter);
        searchDialog.show();
    }
}
