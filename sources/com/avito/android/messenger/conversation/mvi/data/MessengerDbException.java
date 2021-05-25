package com.avito.android.messenger.conversation.mvi.data;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B'\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/data/MessengerDbException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", AuthSource.SEND_ABUSE, "Z", "getDbFileDeleted", "()Z", "dbFileDeleted", "", "message", "", "cause", "<init>", "(ZLjava/lang/String;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerDbException extends RuntimeException {
    public final boolean a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessengerDbException(boolean z, String str, Throwable th, int i, j jVar) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : th);
    }

    public final boolean getDbFileDeleted() {
        return this.a;
    }

    public MessengerDbException(boolean z, @Nullable String str, @Nullable Throwable th) {
        super(str, th);
        this.a = z;
    }
}
