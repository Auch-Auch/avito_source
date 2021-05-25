package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import l6.u.e;
public class PreferenceManager {
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
    public Context a;
    public long b = 0;
    @Nullable
    public SharedPreferences c;
    @Nullable
    public PreferenceDataStore d;
    @Nullable
    public SharedPreferences.Editor e;
    public boolean f;
    public String g;
    public int h;
    public int i = 0;
    public PreferenceScreen j;
    public PreferenceComparisonCallback k;
    public OnPreferenceTreeClickListener l;
    public OnDisplayPreferenceDialogListener m;
    public OnNavigateToScreenListener n;

    public interface OnDisplayPreferenceDialogListener {
        void onDisplayPreferenceDialog(Preference preference);
    }

    public interface OnNavigateToScreenListener {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    public interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(Preference preference);
    }

    public static abstract class PreferenceComparisonCallback {
        public abstract boolean arePreferenceContentsTheSame(Preference preference, Preference preference2);

        public abstract boolean arePreferenceItemsTheSame(Preference preference, Preference preference2);
    }

    public static class SimplePreferenceComparisonCallback extends PreferenceComparisonCallback {
        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean arePreferenceContentsTheSame(Preference preference, Preference preference2) {
            if (preference.getClass() != preference2.getClass()) {
                return false;
            }
            if ((preference == preference2 && preference.M) || !TextUtils.equals(preference.getTitle(), preference2.getTitle()) || !TextUtils.equals(preference.getSummary(), preference2.getSummary())) {
                return false;
            }
            Drawable icon = preference.getIcon();
            Drawable icon2 = preference2.getIcon();
            if ((icon != icon2 && (icon == null || !icon.equals(icon2))) || preference.isEnabled() != preference2.isEnabled() || preference.isSelectable() != preference2.isSelectable()) {
                return false;
            }
            if ((preference instanceof TwoStatePreference) && ((TwoStatePreference) preference).isChecked() != ((TwoStatePreference) preference2).isChecked()) {
                return false;
            }
            if (!(preference instanceof DropDownPreference) || preference == preference2) {
                return true;
            }
            return false;
        }

        @Override // androidx.preference.PreferenceManager.PreferenceComparisonCallback
        public boolean arePreferenceItemsTheSame(Preference preference, Preference preference2) {
            return preference.a() == preference2.a();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PreferenceManager(Context context) {
        this.a = context;
        setSharedPreferencesName(a(context));
    }

    public static String a(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(a(context), 0);
    }

    public static void setDefaultValues(Context context, int i2, boolean z) {
        setDefaultValues(context, a(context), 0, i2, z);
    }

    public SharedPreferences.Editor b() {
        if (this.d != null) {
            return null;
        }
        if (!this.f) {
            return getSharedPreferences().edit();
        }
        if (this.e == null) {
            this.e = getSharedPreferences().edit();
        }
        return this.e;
    }

    public PreferenceScreen createPreferenceScreen(Context context) {
        PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        return preferenceScreen;
    }

    @Nullable
    public <T extends Preference> T findPreference(@NonNull CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.j;
        if (preferenceScreen == null) {
            return null;
        }
        return (T) preferenceScreen.findPreference(charSequence);
    }

    public Context getContext() {
        return this.a;
    }

    public OnDisplayPreferenceDialogListener getOnDisplayPreferenceDialogListener() {
        return this.m;
    }

    public OnNavigateToScreenListener getOnNavigateToScreenListener() {
        return this.n;
    }

    public OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return this.l;
    }

    public PreferenceComparisonCallback getPreferenceComparisonCallback() {
        return this.k;
    }

    @Nullable
    public PreferenceDataStore getPreferenceDataStore() {
        return this.d;
    }

    public PreferenceScreen getPreferenceScreen() {
        return this.j;
    }

    public SharedPreferences getSharedPreferences() {
        Context context;
        if (getPreferenceDataStore() != null) {
            return null;
        }
        if (this.c == null) {
            if (this.i != 1) {
                context = this.a;
            } else {
                context = ContextCompat.createDeviceProtectedStorageContext(this.a);
            }
            this.c = context.getSharedPreferences(this.g, this.h);
        }
        return this.c;
    }

    public int getSharedPreferencesMode() {
        return this.h;
    }

    public String getSharedPreferencesName() {
        return this.g;
    }

    /* JADX INFO: finally extract failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PreferenceScreen inflateFromResource(Context context, int i2, PreferenceScreen preferenceScreen) {
        this.f = true;
        e eVar = new e(context, this);
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            Preference c2 = eVar.c(xml, preferenceScreen);
            xml.close();
            PreferenceScreen preferenceScreen2 = (PreferenceScreen) c2;
            preferenceScreen2.onAttachedToHierarchy(this);
            SharedPreferences.Editor editor = this.e;
            if (editor != null) {
                editor.apply();
            }
            this.f = false;
            return preferenceScreen2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public boolean isStorageDefault() {
        if (Build.VERSION.SDK_INT < 24 || this.i == 0) {
            return true;
        }
        return false;
    }

    public boolean isStorageDeviceProtected() {
        if (Build.VERSION.SDK_INT < 24 || this.i != 1) {
            return false;
        }
        return true;
    }

    public void setOnDisplayPreferenceDialogListener(OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener) {
        this.m = onDisplayPreferenceDialogListener;
    }

    public void setOnNavigateToScreenListener(OnNavigateToScreenListener onNavigateToScreenListener) {
        this.n = onNavigateToScreenListener;
    }

    public void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.l = onPreferenceTreeClickListener;
    }

    public void setPreferenceComparisonCallback(PreferenceComparisonCallback preferenceComparisonCallback) {
        this.k = preferenceComparisonCallback;
    }

    public void setPreferenceDataStore(PreferenceDataStore preferenceDataStore) {
        this.d = preferenceDataStore;
    }

    public boolean setPreferences(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.j;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.onDetached();
        }
        this.j = preferenceScreen;
        return true;
    }

    public void setSharedPreferencesMode(int i2) {
        this.h = i2;
        this.c = null;
    }

    public void setSharedPreferencesName(String str) {
        this.g = str;
        this.c = null;
    }

    public void setStorageDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.i = 0;
            this.c = null;
        }
    }

    public void setStorageDeviceProtected() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.i = 1;
            this.c = null;
        }
    }

    public void showDialog(Preference preference) {
        OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener = this.m;
        if (onDisplayPreferenceDialogListener != null) {
            onDisplayPreferenceDialogListener.onDisplayPreferenceDialog(preference);
        }
    }

    public static void setDefaultValues(Context context, String str, int i2, int i3, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_HAS_SET_DEFAULT_VALUES, 0);
        if (z || !sharedPreferences.getBoolean(KEY_HAS_SET_DEFAULT_VALUES, false)) {
            PreferenceManager preferenceManager = new PreferenceManager(context);
            preferenceManager.setSharedPreferencesName(str);
            preferenceManager.setSharedPreferencesMode(i2);
            preferenceManager.inflateFromResource(context, i3, null);
            sharedPreferences.edit().putBoolean(KEY_HAS_SET_DEFAULT_VALUES, true).apply();
        }
    }
}
