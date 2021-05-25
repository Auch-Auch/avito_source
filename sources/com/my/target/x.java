package com.my.target;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
public class x extends c<ct> {
    @NonNull
    public static c<ct> f() {
        return new x();
    }

    @Nullable
    public ct a(@NonNull String str, @NonNull bp bpVar, @Nullable ct ctVar, @NonNull a aVar, @NonNull Context context) {
        boolean z;
        JSONObject a = a(str, context);
        ct ctVar2 = null;
        if (a == null) {
            return null;
        }
        JSONArray names = a.names();
        dx h = dx.h(bpVar, aVar, context);
        ct ctVar3 = ctVar;
        int i = 0;
        while (true) {
            if (i >= names.length()) {
                z = false;
                break;
            }
            String optString = names.optString(i);
            if ("appwall".equals(optString) || "showcaseApps".equals(optString) || "showcaseGames".equals(optString) || "showcase".equals(optString)) {
                JSONObject optJSONObject = a.optJSONObject(optString);
                if (optJSONObject == null) {
                    ctVar3 = ctVar2;
                } else {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("banners");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        ctVar3 = null;
                    } else {
                        ct A = ct.A(optString);
                        h.a(optJSONObject, A);
                        dw a3 = dw.a(A, bpVar, aVar, context);
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                cj newBanner = cj.newBanner();
                                a3.a(optJSONObject2, newBanner);
                                String bundleId = newBanner.getBundleId();
                                if (!TextUtils.isEmpty(bundleId)) {
                                    PackageManager packageManager = context.getPackageManager();
                                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(bundleId);
                                    newBanner.setAppInstalled(launchIntentForPackage == null ? false : !packageManager.queryIntentActivities(launchIntentForPackage, 65536).isEmpty());
                                }
                                A.a(newBanner);
                            }
                        }
                        ctVar3 = A;
                    }
                }
                if (ctVar3 != null && !ctVar3.ca().isEmpty()) {
                    z = true;
                    break;
                }
            }
            i++;
            ctVar2 = null;
        }
        if (!z) {
            return null;
        }
        ctVar3.s(bpVar.isCached());
        ctVar3.c(a);
        return ctVar3;
    }
}
