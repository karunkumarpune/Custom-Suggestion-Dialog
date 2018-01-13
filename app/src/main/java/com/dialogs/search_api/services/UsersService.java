package com.dialogs.search_api.services;

import com.dialogs.search_api.models.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersService {
    //post
    @POST("/karunkumarpune/Expandeble/master/search_api")
    Call<ArrayList<UserModel>> getFakeUsersBasedOnASearchTag(@Body String tag);
}
