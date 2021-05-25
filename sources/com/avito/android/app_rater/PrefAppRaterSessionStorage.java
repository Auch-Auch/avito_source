package com.avito.android.app_rater;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AppRaterSession;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.preferences.SessionContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/app_rater/PrefAppRaterSessionStorage;", "Lcom/avito/android/app_rater/AppRaterSessionStorage;", "Lcom/avito/android/remote/model/AppRaterSession;", SessionContract.SESSION, "", "saveAppRaterSession", "(Lcom/avito/android/remote/model/AppRaterSession;)V", "getLastSession", "()Lcom/avito/android/remote/model/AppRaterSession;", "lastSession", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "app-rater_release"}, k = 1, mv = {1, 4, 2})
public final class PrefAppRaterSessionStorage implements AppRaterSessionStorage {
    public final Preferences a;

    @Inject
    public PrefAppRaterSessionStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.app_rater.AppRaterSessionStorage
    @NotNull
    public AppRaterSession getLastSession() {
        return new AppRaterSession(this.a.getSharedPreferences().getLong(AppRaterSessionContract.INSTANCE.getLAST_SHOW_TIMESTAMP(), 0));
    }

    @Override // com.avito.android.app_rater.AppRaterSessionStorage
    public void saveAppRaterSession(@NotNull AppRaterSession appRaterSession) {
        Intrinsics.checkNotNullParameter(appRaterSession, SessionContract.SESSION);
        this.a.getSharedPreferences().edit().putLong(AppRaterSessionContract.INSTANCE.getLAST_SHOW_TIMESTAMP(), appRaterSession.getLastShowTimestamp()).apply();
    }
}
