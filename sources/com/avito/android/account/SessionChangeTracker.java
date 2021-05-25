package com.avito.android.account;

import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.SessionContract;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/account/SessionChangeTracker;", "", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "", "source", "", "trackSessionUpdate", "(Lcom/avito/android/remote/model/Session;Ljava/lang/String;)V", "trackLogout", "(Ljava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public interface SessionChangeTracker {
    void trackLogout(@Nullable String str);

    void trackSessionUpdate(@Nullable Session session, @Nullable String str);
}
