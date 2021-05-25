package com.google.firebase.crashlytics.internal.settings.network;

import a2.j.e.d.d.h.d.a;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppRequestData;
public class UpdateAppSpiCall extends a {
    public UpdateAppSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, HttpMethod.PUT, str3);
    }

    @Override // a2.j.e.d.d.h.d.a
    public /* bridge */ /* synthetic */ boolean invoke(AppRequestData appRequestData, boolean z) {
        return super.invoke(appRequestData, z);
    }
}
