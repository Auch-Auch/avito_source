package com.avito.android.preferences;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/preferences/PrefUserAdvertsInfoStorage;", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "", "getExpiredAdvertsCount", "()I", "count", "", "saveExpiredAdvertsCount", "(I)V", "clear", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PrefUserAdvertsInfoStorage implements UserAdvertsInfoStorage {
    public final Preferences a;

    public PrefUserAdvertsInfoStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.preferences.UserAdvertsInfoStorage
    public void clear() {
        this.a.remove("expired_adverts_count");
    }

    @Override // com.avito.android.preferences.UserAdvertsInfoStorage
    public int getExpiredAdvertsCount() {
        return this.a.getInt("expired_adverts_count", 0);
    }

    @Override // com.avito.android.preferences.UserAdvertsInfoStorage
    public void saveExpiredAdvertsCount(int i) {
        this.a.putInt("expired_adverts_count", i);
    }
}
