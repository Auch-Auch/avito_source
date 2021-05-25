package com.facebook.gamingservices;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.io.FileNotFoundException;
public class GamingImageUploader {
    public Context a;

    public GamingImageUploader(Context context) {
        this.a = context;
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z) {
        uploadToMediaLibrary(str, bitmap, z, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z, GraphRequest.Callback callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), ShareInternalUtility.MY_PHOTOS, bitmap, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.a, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, File file, boolean z) throws FileNotFoundException {
        uploadToMediaLibrary(str, file, z, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, File file, boolean z, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), ShareInternalUtility.MY_PHOTOS, file, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.a, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, z, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), ShareInternalUtility.MY_PHOTOS, uri, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.a, callback) : callback).executeAsync();
    }
}
