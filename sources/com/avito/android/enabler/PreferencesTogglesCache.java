package com.avito.android.enabler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.enabler.model.BooleanToggle;
import com.avito.android.enabler.model.RemoteToggles;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/avito/android/enabler/PreferencesTogglesCache;", "Lcom/avito/android/enabler/PersistentTogglesCache;", "", "drop", "()V", "", "key", "", "getToggle", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Lcom/avito/android/enabler/model/RemoteToggles;", "remoteToggles", "saveToggles", "(Lcom/avito/android/enabler/model/RemoteToggles;)V", "Landroid/content/SharedPreferences;", "togglesPreferences", "Landroid/content/SharedPreferences;", "", "newVersion", "getSavedVersion", "()I", "setSavedVersion", "(I)V", "savedVersion", "versionPreferences", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ApplySharedPref"})
public final class PreferencesTogglesCache implements PersistentTogglesCache {
    private final SharedPreferences togglesPreferences;
    private final SharedPreferences versionPreferences;

    public PreferencesTogglesCache(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.togglesPreferences = PersistentTogglesCacheKt.getTogglesPreferences(context);
        this.versionPreferences = PersistentTogglesCacheKt.getVersionPreferences(context);
    }

    @Override // com.avito.android.enabler.PersistentTogglesCache
    public void drop() {
        this.togglesPreferences.edit().clear().commit();
        this.versionPreferences.edit().clear().commit();
    }

    @Override // com.avito.android.enabler.PersistentTogglesCache
    public int getSavedVersion() {
        return this.versionPreferences.getInt("enabler_version_code_key", 0);
    }

    @Override // com.avito.android.enabler.PersistentTogglesCache
    @Nullable
    public Boolean getToggle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (this.togglesPreferences.contains(str)) {
            return Boolean.valueOf(this.togglesPreferences.getBoolean(str, false));
        }
        return null;
    }

    @Override // com.avito.android.enabler.PersistentTogglesCache
    public void saveToggles(@NotNull RemoteToggles remoteToggles) {
        Intrinsics.checkNotNullParameter(remoteToggles, "remoteToggles");
        SharedPreferences.Editor edit = this.togglesPreferences.edit();
        edit.clear();
        for (BooleanToggle booleanToggle : remoteToggles.getToggles()) {
            edit.putBoolean(booleanToggle.getKey(), booleanToggle.getValue());
        }
        edit.commit();
    }

    @Override // com.avito.android.enabler.PersistentTogglesCache
    public void setSavedVersion(int i) {
        this.versionPreferences.edit().putInt("enabler_version_code_key", i).commit();
    }
}
