package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import bolts.AppLinks;
public class SourceApplicationInfo {
    public String a;
    public boolean b;

    public static class Factory {
        public static SourceApplicationInfo create(Activity activity) {
            String str;
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                str = callingActivity.getPackageName();
                if (str.equals(activity.getPackageName())) {
                    return null;
                }
            } else {
                str = "";
            }
            Intent intent = activity.getIntent();
            boolean z = false;
            if (intent != null && !intent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)) {
                intent.putExtra("_fbSourceApplicationHasBeenSet", true);
                Bundle appLinkData = AppLinks.getAppLinkData(intent);
                if (appLinkData != null) {
                    Bundle bundle = appLinkData.getBundle("referer_app_link");
                    if (bundle != null) {
                        str = bundle.getString("package");
                    }
                    z = true;
                }
            }
            if (intent != null) {
                intent.putExtra("_fbSourceApplicationHasBeenSet", true);
            }
            return new SourceApplicationInfo(str, z, null);
        }
    }

    public SourceApplicationInfo(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public String toString() {
        String str = this.b ? "Applink" : "Unclassified";
        return this.a != null ? a2.b.a.a.a.t(a2.b.a.a.a.Q(str, "("), this.a, ")") : str;
    }

    public SourceApplicationInfo(String str, boolean z, a aVar) {
        this.a = str;
        this.b = z;
    }
}
