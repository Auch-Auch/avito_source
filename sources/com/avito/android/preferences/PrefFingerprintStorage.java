package com.avito.android.preferences;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/preferences/PrefFingerprintStorage;", "Lcom/avito/android/preferences/FingerprintStorage;", "", "isFingerprintAvailable", "()Z", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "getPrefs", "()Lcom/avito/android/util/preferences/Preferences;", "prefs", "", "newFingerprint", "getFingerprint", "()Ljava/lang/String;", "setFingerprint", "(Ljava/lang/String;)V", "fingerprint", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PrefFingerprintStorage implements FingerprintStorage {
    @NotNull
    public final Preferences a;

    public PrefFingerprintStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.preferences.FingerprintStorage
    @Nullable
    public String getFingerprint() {
        return this.a.getString("fpx", null);
    }

    @NotNull
    public final Preferences getPrefs() {
        return this.a;
    }

    @Override // com.avito.android.preferences.FingerprintStorage
    public boolean isFingerprintAvailable() {
        return getFingerprint() != null;
    }

    @Override // com.avito.android.preferences.FingerprintStorage
    public void setFingerprint(@Nullable String str) {
        this.a.putString("fpx", str);
    }
}
