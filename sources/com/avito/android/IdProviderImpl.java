package com.avito.android;

import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/IdProviderImpl;", "Lcom/avito/android/IdProvider;", "", "value", "", "restore", "(J)V", "generateId", "()J", "Ljava/util/concurrent/atomic/AtomicLong;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/atomic/AtomicLong;", "lastId", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class IdProviderImpl implements IdProvider {
    public AtomicLong a = new AtomicLong(1);

    @Override // com.avito.android.IdProvider
    public long generateId() {
        return this.a.incrementAndGet();
    }

    @Override // com.avito.android.IdProvider
    public void restore(long j) {
        this.a = new AtomicLong(j);
    }
}
