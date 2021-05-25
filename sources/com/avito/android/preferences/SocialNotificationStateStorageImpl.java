package com.avito.android.preferences;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/preferences/SocialNotificationStateStorageImpl;", "Lcom/avito/android/preferences/SocialNotificationStateStorage;", "", "id", "", "closeNotification", "(Ljava/lang/String;)V", "", "isNotificationClosed", "(Ljava/lang/String;)Z", "", "getClosedNotificationIds", "()Ljava/util/Set;", "clear", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SocialNotificationStateStorageImpl implements SocialNotificationStateStorage {
    public final Preferences a;

    @Inject
    public SocialNotificationStateStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.a = preferences;
    }

    @Override // com.avito.android.preferences.SocialNotificationStateStorage
    public void clear() {
        this.a.remove("closed_social_notifications");
    }

    @Override // com.avito.android.preferences.SocialNotificationStateStorage
    public void closeNotification(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Set<String> stringSet = this.a.getStringSet("closed_social_notifications");
        if (stringSet == null) {
            stringSet = y.emptySet();
        }
        Set<String> mutableSet = CollectionsKt___CollectionsKt.toMutableSet(stringSet);
        mutableSet.add(str);
        this.a.putStringSet("closed_social_notifications", mutableSet);
    }

    @Override // com.avito.android.preferences.SocialNotificationStateStorage
    @NotNull
    public Set<String> getClosedNotificationIds() {
        Set<String> stringSet = this.a.getStringSet("closed_social_notifications");
        return stringSet != null ? stringSet : y.emptySet();
    }

    @Override // com.avito.android.preferences.SocialNotificationStateStorage
    public boolean isNotificationClosed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Set<String> stringSet = this.a.getStringSet("closed_social_notifications");
        if (stringSet != null) {
            return stringSet.contains(str);
        }
        return false;
    }
}
