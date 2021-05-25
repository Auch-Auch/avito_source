package com.facebook.gamingservices.cloudgaming;

import a2.b.a.a.a;
import a2.g.o.a.b;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;
import java.io.FileNotFoundException;
public abstract class AppToUserNotificationSender {
    public static Bundle a() {
        return a.y1("upload_source", "A2U");
    }

    public static void scheduleAppToUserNotification(String str, String str2, Bitmap bitmap, int i, @Nullable String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, bitmap, a(), new b(str, str2, i, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, File file, int i, @Nullable String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, file, a(), new b(str, str2, i, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, Uri uri, int i, @Nullable String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, uri, a(), new b(str, str2, i, str3, callback));
    }
}
