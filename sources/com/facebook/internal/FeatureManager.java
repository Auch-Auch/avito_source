package com.facebook.internal;

import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class FeatureManager {
    public static final Map<Feature, String[]> a = new HashMap();

    public interface Callback {
        void onCompleted(boolean z);
    }

    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        Monitoring(196608),
        Login(16777216),
        ChromeCustomTabsPrefetching(16842752),
        IgnoreAppSwitchToLoggedOut(16908288),
        Share(33554432),
        Places(50331648);
        
        public final int a;

        /* access modifiers changed from: public */
        Feature(int i) {
            this.a = i;
        }

        public static Feature a(int i) {
            Feature[] values = values();
            for (int i2 = 0; i2 < 22; i2++) {
                Feature feature = values[i2];
                if (feature.a == i) {
                    return feature;
                }
            }
            return Unknown;
        }

        public String b() {
            StringBuilder L = a2.b.a.a.a.L("FBSDKFeature");
            L.append(toString());
            return L.toString();
        }

        public Feature getParent() {
            int i = this.a;
            if ((i & 255) > 0) {
                return a(i & InputDeviceCompat.SOURCE_ANY);
            }
            if ((65280 & i) > 0) {
                return a(i & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i) > 0) {
                return a(i & ViewCompat.MEASURED_STATE_MASK);
            }
            return a(0);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            switch (ordinal()) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "RestrictiveDataFiltering";
                case 5:
                    return "AAM";
                case 6:
                    return "PrivacyProtection";
                case 7:
                    return "SuggestedEvents";
                case 8:
                    return "IntelligentIntegrity";
                case 9:
                    return "ModelRequest";
                case 10:
                    return "EventDeactivation";
                case 11:
                    return "Instrument";
                case 12:
                    return "CrashReport";
                case 13:
                    return "CrashShield";
                case 14:
                    return "ThreadCheck";
                case 15:
                    return "ErrorReport";
                case 16:
                    return "Monitoring";
                case 17:
                    return "LoginKit";
                case 18:
                    return "ChromeCustomTabsPrefetching";
                case 19:
                    return "IgnoreAppSwitchToLoggedOut";
                case 20:
                    return "ShareKit";
                case 21:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }
    }

    public static class a implements FetchedAppGateKeepersManager.Callback {
        public final /* synthetic */ Callback a;
        public final /* synthetic */ Feature b;

        public a(Callback callback, Feature feature) {
            this.a = callback;
            this.b = feature;
        }

        @Override // com.facebook.internal.FetchedAppGateKeepersManager.Callback
        public void onCompleted() {
            this.a.onCompleted(FeatureManager.isEnabled(this.b));
        }
    }

    public static boolean a(Feature feature) {
        boolean z;
        switch (feature.ordinal()) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
            case 19:
                z = false;
                break;
            case 17:
            default:
                z = true;
                break;
        }
        return FetchedAppGateKeepersManager.getGateKeeperForKey(feature.b(), FacebookSdk.getApplicationId(), z);
    }

    public static void checkFeature(Feature feature, Callback callback) {
        FetchedAppGateKeepersManager.b(new a(callback, feature));
    }

    public static void disableFeature(Feature feature) {
        FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString(feature.b(), FacebookSdk.getSdkVersion()).apply();
    }

    public static Feature getFeature(String str) {
        Map<Feature, String[]> map;
        synchronized (FeatureManager.class) {
            map = a;
            if (map.isEmpty()) {
                map.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
                map.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
                map.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
                map.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
                map.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
                map.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
                map.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
                map.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
                map.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
            }
        }
        for (Map.Entry<Feature, String[]> entry : map.entrySet()) {
            String[] value = entry.getValue();
            int length = value.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (str.startsWith(value[i])) {
                        return entry.getKey();
                    }
                    i++;
                }
            }
        }
        return Feature.Unknown;
    }

    public static boolean isEnabled(Feature feature) {
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).getString(feature.b(), null);
        if (string != null && string.equals(FacebookSdk.getSdkVersion())) {
            return false;
        }
        Feature parent = feature.getParent();
        if (parent == feature) {
            return a(feature);
        }
        if (!isEnabled(parent) || !a(feature)) {
            return false;
        }
        return true;
    }
}
