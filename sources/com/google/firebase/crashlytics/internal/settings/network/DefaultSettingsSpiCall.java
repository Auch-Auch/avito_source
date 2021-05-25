package com.google.firebase.crashlytics.internal.settings.network;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
public class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
    public Logger f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultSettingsSpiCall(java.lang.String r3, java.lang.String r4, com.google.firebase.crashlytics.internal.network.HttpRequestFactory r5) {
        /*
            r2 = this;
            com.google.firebase.crashlytics.internal.network.HttpMethod r0 = com.google.firebase.crashlytics.internal.network.HttpMethod.GET
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            r2.<init>(r3, r4, r5, r0)
            r2.f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall.<init>(java.lang.String, java.lang.String, com.google.firebase.crashlytics.internal.network.HttpRequestFactory):void");
    }

    public final HttpRequest a(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        String str = settingsRequest.googleAppId;
        if (str != null) {
            httpRequest.header(AbstractSpiCall.HEADER_GOOGLE_APP_ID, str);
        }
        httpRequest.header(AbstractSpiCall.HEADER_CLIENT_TYPE, "android");
        String version = CrashlyticsCore.getVersion();
        if (version != null) {
            httpRequest.header(AbstractSpiCall.HEADER_CLIENT_VERSION, version);
        }
        httpRequest.header("Accept", AbstractSpiCall.ACCEPT_JSON_VALUE);
        String str2 = settingsRequest.deviceModel;
        if (str2 != null) {
            httpRequest.header("X-CRASHLYTICS-DEVICE-MODEL", str2);
        }
        String str3 = settingsRequest.osBuildVersion;
        if (str3 != null) {
            httpRequest.header("X-CRASHLYTICS-OS-BUILD-VERSION", str3);
        }
        String str4 = settingsRequest.osDisplayVersion;
        if (str4 != null) {
            httpRequest.header("X-CRASHLYTICS-OS-DISPLAY-VERSION", str4);
        }
        String crashlyticsInstallId = settingsRequest.installIdProvider.getCrashlyticsInstallId();
        if (crashlyticsInstallId != null) {
            httpRequest.header("X-CRASHLYTICS-INSTALLATION-ID", crashlyticsInstallId);
        }
        return httpRequest;
    }

    public final Map<String, String> b(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.buildVersion);
        hashMap.put("display_version", settingsRequest.displayVersion);
        hashMap.put("source", Integer.toString(settingsRequest.source));
        String str = settingsRequest.instanceId;
        if (!CommonUtils.isNullOrEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    public JSONObject c(HttpResponse httpResponse) {
        int code = httpResponse.code();
        Logger logger = this.f;
        logger.d("Settings result was: " + code);
        if (code == 200 || code == 201 || code == 202 || code == 203) {
            String body = httpResponse.body();
            try {
                return new JSONObject(body);
            } catch (Exception e) {
                Logger logger2 = this.f;
                StringBuilder L = a.L("Failed to parse settings JSON from ");
                L.append(getUrl());
                logger2.d(L.toString(), e);
                Logger logger3 = this.f;
                logger3.d("Settings response " + body);
                return null;
            }
        } else {
            Logger logger4 = this.f;
            StringBuilder L2 = a.L("Failed to retrieve settings from ");
            L2.append(getUrl());
            logger4.e(L2.toString());
            return null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall
    public JSONObject invoke(SettingsRequest settingsRequest, boolean z) {
        if (z) {
            try {
                Map<String, String> b = b(settingsRequest);
                HttpRequest httpRequest = getHttpRequest(b);
                a(httpRequest, settingsRequest);
                Logger logger = this.f;
                logger.d("Requesting settings from " + getUrl());
                Logger logger2 = this.f;
                logger2.d("Settings query params were: " + b);
                HttpResponse execute = httpRequest.execute();
                Logger logger3 = this.f;
                logger3.d("Settings request ID: " + execute.header(AbstractSpiCall.HEADER_REQUEST_ID));
                return c(execute);
            } catch (IOException e) {
                this.f.e("Settings request failed.", e);
                return null;
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }
}
