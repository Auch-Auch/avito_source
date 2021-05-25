package com.avito.android.messenger;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.messenger.Event;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u000e\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0017R\u001b\u0010\t\u001a\u0004\u0018\u00018\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/Result;", "Lcom/avito/android/messenger/Event;", ExifInterface.LONGITUDE_EAST, "T", "", "c", "Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "result", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/Event;", "getEvent", "()Lcom/avito/android/messenger/Event;", "event", "<init>", "(Lcom/avito/android/messenger/Event;Ljava/lang/Object;)V", "(Lcom/avito/android/messenger/Event;Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public class Result<E extends Event, T> {
    @NotNull
    public final E a;
    @Nullable
    public final Throwable b;
    @Nullable
    public final T c;

    public Result(@NotNull E e, T t) {
        Intrinsics.checkNotNullParameter(e, "event");
        this.a = e;
        this.c = t;
        this.b = null;
    }

    @Nullable
    public final Throwable getError() {
        return this.b;
    }

    @NotNull
    public final E getEvent() {
        return this.a;
    }

    @Nullable
    public final T getResult() {
        return this.c;
    }

    public Result(@NotNull E e, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(e, "event");
        Intrinsics.checkNotNullParameter(th, "error");
        this.a = e;
        this.c = null;
        this.b = th;
    }
}
