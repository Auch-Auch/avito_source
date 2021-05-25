package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
public class wi implements wj<gz> {
    public void a(@NonNull Uri.Builder builder, @NonNull gz gzVar) {
        builder.appendPath("diagnostic");
        builder.appendQueryParameter("deviceid", gzVar.s());
        builder.appendQueryParameter("uuid", gzVar.u());
        builder.appendQueryParameter("app_platform", gzVar.m());
        builder.appendQueryParameter("analytics_sdk_version_name", gzVar.j());
        builder.appendQueryParameter("analytics_sdk_build_number", gzVar.k());
        builder.appendQueryParameter("analytics_sdk_build_type", gzVar.l());
        if (gzVar.l().contains("source") && !TextUtils.isEmpty(gzVar.F())) {
            builder.appendQueryParameter("commit_hash", gzVar.F());
        }
        builder.appendQueryParameter("app_version_name", gzVar.r());
        builder.appendQueryParameter("app_build_number", gzVar.q());
        builder.appendQueryParameter(VerticalFilterCloseDialogEventKt.MODEL_DIALOG, gzVar.n());
        builder.appendQueryParameter("manufacturer", gzVar.h());
        builder.appendQueryParameter("os_version", gzVar.o());
        builder.appendQueryParameter("os_api_level", String.valueOf(gzVar.p()));
        builder.appendQueryParameter("screen_width", String.valueOf(gzVar.x()));
        builder.appendQueryParameter("screen_height", String.valueOf(gzVar.y()));
        builder.appendQueryParameter("screen_dpi", String.valueOf(gzVar.z()));
        builder.appendQueryParameter("scalefactor", String.valueOf(gzVar.A()));
        builder.appendQueryParameter("locale", gzVar.B());
        builder.appendQueryParameter("device_type", gzVar.D());
        builder.appendQueryParameter("app_id", gzVar.d());
        builder.appendQueryParameter("api_key_128", gzVar.b());
        builder.appendQueryParameter("app_debuggable", gzVar.G());
        builder.appendQueryParameter("is_rooted", gzVar.v());
        builder.appendQueryParameter("app_framework", gzVar.w());
    }
}
