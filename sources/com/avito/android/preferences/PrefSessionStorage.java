package com.avito.android.preferences;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.preferences.SessionContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/preferences/PrefSessionStorage;", "Lcom/avito/android/preferences/MutableSessionStorage;", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "", "saveSession", "(Lcom/avito/android/remote/model/Session;)V", "getSession", "()Lcom/avito/android/remote/model/Session;", "removeSession", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "session_release"}, k = 1, mv = {1, 4, 2})
public final class PrefSessionStorage implements MutableSessionStorage {
    public final Preferences a;

    public PrefSessionStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.preferences.SessionStorage
    @Nullable
    public Session getSession() {
        String string = this.a.getString(SessionContract.SESSION, null);
        if (string == null) {
            return null;
        }
        String string2 = this.a.getString("refresh_token", null);
        String string3 = this.a.getString(SessionContract.PUSH_TOKEN, null);
        if (string.length() > 0) {
            return new Session(string, string2, string3);
        }
        return null;
    }

    @Override // com.avito.android.preferences.MutableSessionStorage
    public void removeSession() {
        this.a.getSharedPreferences().edit().remove(Preference.PASSWORD).remove(SessionContract.SESSION).remove(SessionContract.SIGNATURE).remove(SessionContract.PUSH_TOKEN).remove("refresh_token").apply();
    }

    @Override // com.avito.android.preferences.MutableSessionStorage
    public void saveSession(@NotNull Session session) {
        Intrinsics.checkNotNullParameter(session, SessionContract.SESSION);
        this.a.getSharedPreferences().edit().putString(SessionContract.SESSION, session.getSession()).putString(SessionContract.PUSH_TOKEN, session.getPushToken()).putString("refresh_token", session.getRefreshToken()).apply();
    }
}
