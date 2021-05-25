package com.yandex.metrica.impl.ob;

import android.net.Uri;
import android.support.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
public class wk extends wl<sc> {
    private wh a = new wh();
    private long b;

    public void a(@NonNull Uri.Builder builder, @NonNull sc scVar) {
        super.a(builder, (Uri.Builder) scVar);
        builder.appendPath("location");
        builder.appendQueryParameter("deviceid", scVar.s());
        builder.appendQueryParameter("device_type", scVar.D());
        builder.appendQueryParameter("uuid", scVar.u());
        builder.appendQueryParameter("analytics_sdk_version_name", scVar.j());
        builder.appendQueryParameter("analytics_sdk_build_number", scVar.k());
        builder.appendQueryParameter("analytics_sdk_build_type", scVar.l());
        a(scVar.l(), scVar.F(), builder);
        builder.appendQueryParameter("app_version_name", scVar.r());
        builder.appendQueryParameter("app_build_number", scVar.q());
        builder.appendQueryParameter("os_version", scVar.o());
        builder.appendQueryParameter("os_api_level", String.valueOf(scVar.p()));
        builder.appendQueryParameter("is_rooted", scVar.v());
        builder.appendQueryParameter("app_framework", scVar.w());
        builder.appendQueryParameter("app_id", scVar.d());
        builder.appendQueryParameter("app_platform", scVar.m());
        builder.appendQueryParameter("android_id", scVar.C());
        builder.appendQueryParameter(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, String.valueOf(this.b));
        this.a.a(builder, scVar.E());
    }

    public void a(long j) {
        this.b = j;
    }
}
