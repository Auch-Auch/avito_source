package com.avito.android.preferences;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/preferences/PrefVersionStorage;", "Lcom/avito/android/preferences/VersionStorage;", "Lcom/avito/android/preferences/UpdateStorage;", "", "code", "", "setVersionCode", "(I)V", "getVersionCode", "()I", "", "isRunAfterUpdate", "()Z", "setRunUi", "()V", "c", "I", "currentVersionCode", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "prefs", AuthSource.SEND_ABUSE, "Z", "runAfterUpdate", "<init>", "(Lcom/avito/android/util/preferences/Preferences;I)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class PrefVersionStorage implements VersionStorage, UpdateStorage {
    public final boolean a;
    public final Preferences b;
    public final int c;

    public PrefVersionStorage(@NotNull Preferences preferences, int i) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.b = preferences;
        this.c = i;
        if (!preferences.contains(Preference.LAST_APP_VERSION_RUN)) {
            preferences.putInt(Preference.LAST_APP_VERSION_RUN, getVersionCode());
        }
        boolean z = false;
        int i2 = preferences.getInt(Preference.LAST_APP_VERSION_RUN, 0);
        if (!(i2 == i || i2 == 0)) {
            z = true;
        }
        this.a = z;
    }

    @Override // com.avito.android.preferences.VersionStorage
    public int getVersionCode() {
        return this.b.getInt(Preference.APP_VERSION, 0);
    }

    @Override // com.avito.android.preferences.UpdateStorage
    public boolean isRunAfterUpdate() {
        return this.a;
    }

    @Override // com.avito.android.preferences.UpdateStorage
    public void setRunUi() {
        this.b.putInt(Preference.LAST_APP_VERSION_RUN, this.c);
    }

    @Override // com.avito.android.preferences.VersionStorage
    public void setVersionCode(int i) {
        this.b.putInt(Preference.APP_VERSION, i);
    }
}
