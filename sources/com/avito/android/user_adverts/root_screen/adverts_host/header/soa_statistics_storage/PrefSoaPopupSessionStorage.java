package com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/soa_statistics_storage/PrefSoaPopupSessionStorage;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/soa_statistics_storage/SoaPopupSessionStorage;", "", "setSoaPopupWasShown", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "", "getSoaPopupWasShown", "()Z", "soaPopupWasShown", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class PrefSoaPopupSessionStorage implements SoaPopupSessionStorage {
    public final Preferences a;

    @Inject
    public PrefSoaPopupSessionStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage.SoaPopupSessionStorage
    public boolean getSoaPopupWasShown() {
        return this.a.getSharedPreferences().getBoolean(SoaSessionContract.INSTANCE.getPOPUP_WAS_SHOWN(), false);
    }

    @Override // com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage.SoaPopupSessionStorage
    public void setSoaPopupWasShown() {
        this.a.getSharedPreferences().edit().putBoolean(SoaSessionContract.INSTANCE.getPOPUP_WAS_SHOWN(), true).apply();
    }
}
