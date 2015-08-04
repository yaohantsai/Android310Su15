package com.uw.android310.lesson6.api;


import com.uw.android310.lesson6.model.Image;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.mime.TypedFile;


public interface ImgurRestApi {
    static final String server = "https://api.imgur.com";

    /**
     * Upload an image to imgur.
     *
     * @param auth        Type of authorization for upload
     * @param title       Title of image
     * @param description Description of image
     * @param albumId     ID for album (if the user is adding this image to an album)
     * @param username    username for image upload
     * @param file        Image file
     * @param callback    Callback used for success/failures
     */
    @POST("/3/image")
    void uploadImage(
            @Header("Authorization") String auth,
            @Query("title") String title,
            @Query("description") String description,
            @Query("album") String albumId,
            @Query("account_url") String username,
            @Body TypedFile file,
            Callback<Image> callback
    );
}
