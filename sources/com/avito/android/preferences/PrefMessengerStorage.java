package com.avito.android.preferences;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.MessengerContract;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/preferences/PrefMessengerStorage;", "Lcom/avito/android/preferences/MessengerStorage;", "", "count", "", "putUnreadMessagesCount", "(I)V", "clear", "()V", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "getUnreadMessagesCount", "()I", "unreadMessagesCount", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class PrefMessengerStorage implements MessengerStorage {
    public final Preferences a;

    public PrefMessengerStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.a = preferences;
    }

    @Override // com.avito.android.preferences.MessengerStorage
    public void clear() {
        putUnreadMessagesCount(0);
    }

    @Override // com.avito.android.preferences.MessengerStorage
    public int getUnreadMessagesCount() {
        return this.a.getInt(MessengerContract.INSTANCE.getUNREAD_MESSAGES_COUNTER(), 0);
    }

    @Override // com.avito.android.preferences.MessengerStorage
    public void putUnreadMessagesCount(int i) {
        this.a.putInt(MessengerContract.INSTANCE.getUNREAD_MESSAGES_COUNTER(), i);
    }
}
