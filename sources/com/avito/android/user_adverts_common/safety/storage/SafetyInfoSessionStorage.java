package com.avito.android.user_adverts_common.safety.storage;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.user_adverts_common.safety.AfterPublishWarningSession;
import com.avito.android.util.preferences.SessionContract;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_adverts_common/safety/storage/SafetyInfoSessionStorage;", "", "", ChannelContext.Item.USER_ID, "Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;", "getLastSessionForUser", "(Ljava/lang/String;)Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;", SessionContract.SESSION, "", "saveSession", "(Lcom/avito/android/user_adverts_common/safety/AfterPublishWarningSession;Ljava/lang/String;)V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public interface SafetyInfoSessionStorage {
    @NotNull
    AfterPublishWarningSession getLastSessionForUser(@NotNull String str);

    void saveSession(@NotNull AfterPublishWarningSession afterPublishWarningSession, @NotNull String str);
}
