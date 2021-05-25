package com.avito.android.remote.notification;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.NotificationCounterContract;
import com.avito.android.util.preferences.Preferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/notification/NotificationCounterStorageImpl;", "Lcom/avito/android/remote/notification/NotificationCounterStorage;", "", "generateNext", "()I", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "preferences", AuthSource.SEND_ABUSE, "I", "count", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCounterStorageImpl implements NotificationCounterStorage {
    public int a;
    public final Preferences b;

    @Inject
    public NotificationCounterStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.b = preferences;
        this.a = preferences.getInt(NotificationCounterContract.KEY, 0);
    }

    @Override // com.avito.android.remote.notification.NotificationCounterStorage
    public int generateNext() {
        int i = this.a + 1;
        this.a = i;
        if (i == 100000) {
            this.a = 0;
        }
        this.b.putInt(NotificationCounterContract.KEY, this.a);
        return this.a;
    }
}
