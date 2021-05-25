package com.facebook.internal;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.browser.customtabs.CustomTabsService;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
@AutoHandleExceptions
public class CustomTabUtils {
    public static final String[] a = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    public static String getChromePackage() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        List<ResolveInfo> queryIntentServices = applicationContext.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        if (queryIntentServices == null) {
            return null;
        }
        HashSet hashSet = new HashSet(Arrays.asList(a));
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                return serviceInfo.packageName;
            }
        }
        return null;
    }

    public static String getDefaultRedirectURI() {
        StringBuilder L = a.L(Validate.CUSTOM_TAB_REDIRECT_URI_PREFIX);
        L.append(FacebookSdk.getApplicationContext().getPackageName());
        return L.toString();
    }

    public static String getValidRedirectURI(String str) {
        if (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), str)) {
            return str;
        }
        return Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), getDefaultRedirectURI()) ? getDefaultRedirectURI() : "";
    }
}
