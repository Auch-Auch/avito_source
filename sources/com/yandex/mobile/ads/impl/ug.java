package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.yandex.mobile.ads.MobileAds;
public final class ug {
    @NonNull
    private final fo a;
    @NonNull
    private final fq b = new fq();
    @NonNull
    private final ga c = new ga();
    @NonNull
    private final hd d;

    public ug(@NonNull Context context, @NonNull fo foVar) {
        this.a = foVar;
        this.d = hd.a(context);
    }

    private static void a(@NonNull Uri.Builder builder, @NonNull String str, @Nullable gq gqVar) {
        if (gqVar != null && !gqVar.b()) {
            a(builder, str, gqVar.a());
        }
    }

    private static void a(@NonNull Uri.Builder builder, @NonNull String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    public final void a(@NonNull Context context, @NonNull Uri.Builder builder) {
        Location a3;
        a(builder, "app_id", context.getPackageName());
        a(builder, "app_version_code", du.a(context));
        a(builder, "app_version_name", du.b(context));
        a(builder, "sdk_version", MobileAds.getLibraryVersion());
        a(builder, "device_type", this.c.a(context));
        a(builder, "locale", gc.a(context));
        a(builder, "manufacturer", Build.MANUFACTURER);
        a(builder, VerticalFilterCloseDialogEventKt.MODEL_DIALOG, Build.MODEL);
        a(builder, "os_name", "android");
        a(builder, "os_version", Build.VERSION.RELEASE);
        if (!fq.a(context) && (a3 = this.d.a()) != null) {
            a(builder, "location_timestamp", String.valueOf(a3.getTime()));
            a(builder, "lat", String.valueOf(a3.getLatitude()));
            a(builder, MessageBody.Location.LONGITUDE, String.valueOf(a3.getLongitude()));
            a(builder, "precision", String.valueOf(a3.getAccuracy()));
        }
        if (!fq.a(context)) {
            a(builder, "device-id", this.a.g());
            a(builder, "google_aid", this.a.i());
            a(builder, "huawei_oaid", this.a.j());
        }
    }
}
