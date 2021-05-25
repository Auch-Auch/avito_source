package com.avito.android.account;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/account/PrefLastUserStorage;", "Lcom/avito/android/account/MutableLastUserStorage;", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "", "value", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", ChannelContext.Item.USER_ID, "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class PrefLastUserStorage implements MutableLastUserStorage {
    public final Preferences a;

    public PrefLastUserStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.account.MutableLastUserStorage, com.avito.android.account.LastUserStorage
    @Nullable
    public String getUserId() {
        return this.a.getString(Preference.LAST_LOGGED_USER_ID);
    }

    @Override // com.avito.android.account.MutableLastUserStorage
    public void setUserId(@Nullable String str) {
        this.a.putString(Preference.LAST_LOGGED_USER_ID, str);
    }
}
