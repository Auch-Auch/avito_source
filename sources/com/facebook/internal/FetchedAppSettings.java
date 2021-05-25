package com.facebook.internal;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.EnumSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
public final class FetchedAppSettings {
    public boolean a;
    public String b;
    public boolean c;
    public int d;
    public EnumSet<SmartLoginOption> e;
    public Map<String, Map<String, DialogFeatureConfig>> f;
    public boolean g;
    public FacebookRequestErrorClassification h;
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public String m;
    public JSONArray n;
    public boolean o;
    public boolean p;
    @Nullable
    public String q;
    @Nullable
    public String r;
    @Nullable
    public String s;

    public static class DialogFeatureConfig {
        public String a;
        public String b;
        public Uri c;
        public int[] d;

        public DialogFeatureConfig(String str, String str2, Uri uri, int[] iArr) {
            this.a = str;
            this.b = str2;
            this.c = uri;
            this.d = iArr;
        }

        public static DialogFeatureConfig parseDialogConfig(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            int[] iArr = null;
            if (Utility.isNullOrEmpty(optString)) {
                return null;
            }
            String[] split = optString.split("\\|");
            if (split.length != 2) {
                return null;
            }
            String str = split[0];
            String str2 = split[1];
            if (Utility.isNullOrEmpty(str) || Utility.isNullOrEmpty(str2)) {
                return null;
            }
            String optString2 = jSONObject.optString("url");
            Uri parse = !Utility.isNullOrEmpty(optString2) ? Uri.parse(optString2) : null;
            JSONArray optJSONArray = jSONObject.optJSONArray("versions");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                int[] iArr2 = new int[length];
                for (int i = 0; i < length; i++) {
                    int i2 = -1;
                    int optInt = optJSONArray.optInt(i, -1);
                    if (optInt == -1) {
                        String optString3 = optJSONArray.optString(i);
                        if (!Utility.isNullOrEmpty(optString3)) {
                            try {
                                i2 = Integer.parseInt(optString3);
                            } catch (NumberFormatException e) {
                                Utility.logd("FacebookSDK", e);
                            }
                            iArr2[i] = i2;
                        }
                    }
                    i2 = optInt;
                    iArr2[i] = i2;
                }
                iArr = iArr2;
            }
            return new DialogFeatureConfig(str, str2, parse, iArr);
        }

        public String getDialogName() {
            return this.a;
        }

        public Uri getFallbackUrl() {
            return this.c;
        }

        public String getFeatureName() {
            return this.b;
        }

        public int[] getVersionSpec() {
            return this.d;
        }
    }

    public FetchedAppSettings(boolean z, String str, boolean z2, int i2, EnumSet<SmartLoginOption> enumSet, Map<String, Map<String, DialogFeatureConfig>> map, boolean z3, FacebookRequestErrorClassification facebookRequestErrorClassification, String str2, String str3, boolean z4, boolean z5, JSONArray jSONArray, String str4, boolean z7, boolean z8, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.a = z;
        this.b = str;
        this.c = z2;
        this.f = map;
        this.h = facebookRequestErrorClassification;
        this.d = i2;
        this.g = z3;
        this.e = enumSet;
        this.i = str2;
        this.j = str3;
        this.k = z4;
        this.l = z5;
        this.n = jSONArray;
        this.m = str4;
        this.o = z7;
        this.p = z8;
        this.q = str5;
        this.r = str6;
        this.s = str7;
    }

    public static DialogFeatureConfig getDialogFeatureConfig(String str, String str2, String str3) {
        FetchedAppSettings appSettingsWithoutQuery;
        Map<String, DialogFeatureConfig> map;
        if (Utility.isNullOrEmpty(str2) || Utility.isNullOrEmpty(str3) || (appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(str)) == null || (map = appSettingsWithoutQuery.getDialogConfigurations().get(str2)) == null) {
            return null;
        }
        return map.get(str3);
    }

    public boolean getAutomaticLoggingEnabled() {
        return this.g;
    }

    public boolean getCodelessEventsEnabled() {
        return this.l;
    }

    public Map<String, Map<String, DialogFeatureConfig>> getDialogConfigurations() {
        return this.f;
    }

    public FacebookRequestErrorClassification getErrorClassification() {
        return this.h;
    }

    public JSONArray getEventBindings() {
        return this.n;
    }

    public boolean getIAPAutomaticLoggingEnabled() {
        return this.k;
    }

    public boolean getMonitorViaDialogEnabled() {
        return this.p;
    }

    public String getNuxContent() {
        return this.b;
    }

    public boolean getNuxEnabled() {
        return this.c;
    }

    @Nullable
    public String getRawAamRules() {
        return this.q;
    }

    @Nullable
    public String getRestrictiveDataSetting() {
        return this.s;
    }

    public String getSdkUpdateMessage() {
        return this.m;
    }

    public int getSessionTimeoutInSeconds() {
        return this.d;
    }

    public String getSmartLoginBookmarkIconURL() {
        return this.i;
    }

    public String getSmartLoginMenuIconURL() {
        return this.j;
    }

    public EnumSet<SmartLoginOption> getSmartLoginOptions() {
        return this.e;
    }

    @Nullable
    public String getSuggestedEventsSetting() {
        return this.r;
    }

    public boolean getTrackUninstallEnabled() {
        return this.o;
    }

    public boolean supportsImplicitLogging() {
        return this.a;
    }
}
