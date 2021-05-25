package com.google.androidbrowserhelper.trusted;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsService;
import com.facebook.common.util.UriUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
public class TwaProviderPicker {

    public static class Action {
        public final int launchMode;
        @Nullable
        public final String provider;

        public Action(int i, @Nullable String str) {
            this.launchMode = i;
            this.provider = str;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
        public static final int BROWSER = 2;
        public static final int CUSTOM_TAB = 1;
        public static final int TRUSTED_WEB_ACTIVITY = 0;
    }

    public static Action pickProvider(PackageManager packageManager) {
        String str = null;
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts(UriUtil.HTTP_SCHEME, "", null));
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(data, 65536);
        if (Build.VERSION.SDK_INT >= 23) {
            queryIntentActivities.addAll(packageManager.queryIntentActivities(data, 131072));
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 64);
        HashMap hashMap = new HashMap();
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            String str2 = next.serviceInfo.packageName;
            if (ChromeLegacyUtils.supportsTrustedWebActivities(packageManager, str2)) {
                hashMap.put(str2, 0);
            } else {
                IntentFilter intentFilter = next.filter;
                if (intentFilter != null && intentFilter.hasCategory(CustomTabsService.TRUSTED_WEB_ACTIVITY_CATEGORY)) {
                    i = 1;
                }
                hashMap.put(str2, Integer.valueOf(i ^ 1));
            }
        }
        String str3 = null;
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str4 = resolveInfo.activityInfo.packageName;
            int intValue = hashMap.containsKey(str4) ? ((Integer) hashMap.get(str4)).intValue() : 2;
            if (intValue == 0) {
                return new Action(0, str4);
            }
            if (intValue != 1) {
                if (intValue == 2 && str3 == null) {
                    str3 = str4;
                }
            } else if (str == null) {
                str = str4;
            }
        }
        if (str != null) {
            return new Action(1, str);
        }
        return new Action(2, str3);
    }
}
