package com.avito.android.account;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/account/PrefLastLoggedEmailStorage;", "Lcom/avito/android/account/MutableLastLoggedEmailStorage;", "", "email", "", "saveEmail", "(Ljava/lang/String;)V", "Landroid/content/SharedPreferences;", AuthSource.SEND_ABUSE, "Landroid/content/SharedPreferences;", "sharedPreferences", "getEmail", "()Ljava/lang/String;", "<init>", "(Landroid/content/SharedPreferences;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class PrefLastLoggedEmailStorage implements MutableLastLoggedEmailStorage {
    public final SharedPreferences a;

    public PrefLastLoggedEmailStorage(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.a = sharedPreferences;
    }

    @Override // com.avito.android.account.LastLoggedEmailStorage
    @Nullable
    public String getEmail() {
        return this.a.getString(Preference.LAST_LOGGED_EMAIL, null);
    }

    @Override // com.avito.android.account.MutableLastLoggedEmailStorage
    public void saveEmail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        SharedPreferences.Editor edit = this.a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove(Preference.LAST_LOGGED_EMAIL);
        } else {
            edit.putString(Preference.LAST_LOGGED_EMAIL, str);
        }
        edit.apply();
    }
}
