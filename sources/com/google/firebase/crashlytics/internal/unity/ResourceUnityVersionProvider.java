package com.google.firebase.crashlytics.internal.unity;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
public class ResourceUnityVersionProvider implements UnityVersionProvider {
    public final Context a;
    public boolean b = false;
    public String c;

    public ResourceUnityVersionProvider(Context context) {
        this.a = context;
    }

    @Override // com.google.firebase.crashlytics.internal.unity.UnityVersionProvider
    public String getUnityVersion() {
        if (!this.b) {
            this.c = CommonUtils.resolveUnityEditorVersion(this.a);
            this.b = true;
        }
        String str = this.c;
        if (str != null) {
            return str;
        }
        return null;
    }
}
