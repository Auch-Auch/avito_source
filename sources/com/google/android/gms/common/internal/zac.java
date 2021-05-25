package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.avito.android.util.preferences.db_preferences.Types;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
public final class zac {
    @GuardedBy("sCache")
    private static final SimpleArrayMap<String, String> zaa = new SimpleArrayMap<>();
    @Nullable
    @GuardedBy("sCache")
    private static Locale zab;

    @Nullable
    public static String zaa(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_title);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_title);
        }
        if (i == 3) {
            return resources.getString(R.string.common_google_play_services_enable_title);
        }
        if (i == 5) {
            return zaa(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return zaa(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return zaa(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return zaa(context, "common_google_play_services_restricted_profile_title");
    }

    @NonNull
    public static String zab(Context context, int i) {
        String str;
        if (i == 6) {
            str = zaa(context, "common_google_play_services_resolution_required_title");
        } else {
            str = zaa(context, i);
        }
        return str == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : str;
    }

    @NonNull
    public static String zac(Context context, int i) {
        Resources resources = context.getResources();
        String zab2 = zab(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, zab2);
        }
        if (i != 2) {
            if (i == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, zab2);
            }
            if (i == 5) {
                return zaa(context, "common_google_play_services_invalid_account_text", zab2);
            }
            if (i == 7) {
                return zaa(context, "common_google_play_services_network_error_text", zab2);
            }
            if (i == 9) {
                return resources.getString(R.string.common_google_play_services_unsupported_text, zab2);
            }
            if (i == 20) {
                return zaa(context, "common_google_play_services_restricted_profile_text", zab2);
            }
            switch (i) {
                case 16:
                    return zaa(context, "common_google_play_services_api_unavailable_text", zab2);
                case 17:
                    return zaa(context, "common_google_play_services_sign_in_failed_text", zab2);
                case 18:
                    return resources.getString(R.string.common_google_play_services_updating_text, zab2);
                default:
                    return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, zab2);
            }
        } else if (DeviceProperties.isWearableWithoutPlayStore(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, zab2);
        }
    }

    @NonNull
    public static String zad(Context context, int i) {
        if (i == 6 || i == 19) {
            return zaa(context, "common_google_play_services_resolution_required_text", zab(context));
        }
        return zac(context, i);
    }

    @NonNull
    public static String zae(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        if (i != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R.string.common_google_play_services_enable_button);
    }

    private static String zab(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    private static String zaa(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context, str);
        if (zaa2 == null) {
            zaa2 = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zaa2, str2);
    }

    @Nullable
    private static String zaa(Context context, String str) {
        SimpleArrayMap<String, String> simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
            if (!locale.equals(zab)) {
                simpleArrayMap.clear();
                zab = locale;
            }
            String str2 = simpleArrayMap.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, Types.STRING, "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Missing resource: ".concat(valueOf);
                } else {
                    new String("Missing resource: ");
                }
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                if (valueOf2.length() != 0) {
                    "Got empty resource: ".concat(valueOf2);
                } else {
                    new String("Got empty resource: ");
                }
                return null;
            }
            simpleArrayMap.put(str, string);
            return string;
        }
    }

    public static String zaa(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }
}
