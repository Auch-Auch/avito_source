package com.avito.android.user_adverts_common.safety.storage;

import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.user_adverts_common.safety.AfterPublishWarningSession;
import com.avito.android.user_adverts_common.safety.model.AfterPublishWarningSessionContract;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.preferences.SessionContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_adverts_common/safety/storage/PrefSafetyInfoSessionStorage;", "Lcom/avito/android/user_adverts_common/safety/storage/SafetyInfoSessionStorage;", "", ChannelContext.Item.USER_ID, "Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;", "getLastSessionForUser", "(Ljava/lang/String;)Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;", SessionContract.SESSION, "", "saveSession", "(Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;Ljava/lang/String;)V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public final class PrefSafetyInfoSessionStorage implements SafetyInfoSessionStorage {
    public final Preferences a;

    @Inject
    public PrefSafetyInfoSessionStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.user_adverts_common.safety.storage.SafetyInfoSessionStorage
    @NotNull
    public AfterPublishWarningSession getLastSessionForUser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        SharedPreferences sharedPreferences = this.a.getSharedPreferences();
        return new AfterPublishWarningSession(sharedPreferences.getLong(AfterPublishWarningSessionContract.INSTANCE.getLAST_SHOW_TIMESTAMP() + str, 0));
    }

    @Override // com.avito.android.user_adverts_common.safety.storage.SafetyInfoSessionStorage
    public void saveSession(@NotNull AfterPublishWarningSession afterPublishWarningSession, @NotNull String str) {
        Intrinsics.checkNotNullParameter(afterPublishWarningSession, SessionContract.SESSION);
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        SharedPreferences.Editor edit = this.a.getSharedPreferences().edit();
        edit.putLong(AfterPublishWarningSessionContract.INSTANCE.getLAST_SHOW_TIMESTAMP() + str, afterPublishWarningSession.getLastShowTimestamp()).apply();
    }
}
