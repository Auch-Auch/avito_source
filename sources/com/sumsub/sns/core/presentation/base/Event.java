package com.sumsub.sns.core.presentation.base;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0004R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00028\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/presentation/base/Event;", "T", "", "getContentIfNotHandled", "()Ljava/lang/Object;", "peekContent", "", "<set-?>", AuthSource.SEND_ABUSE, "Z", "getHasBeenHandled", "()Z", "hasBeenHandled", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "content", "<init>", "(Ljava/lang/Object;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public class Event<T> {
    public boolean a;
    public final T b;

    public Event(T t) {
        this.b = t;
    }

    @Nullable
    public final T getContentIfNotHandled() {
        if (this.a) {
            return null;
        }
        this.a = true;
        return this.b;
    }

    public final boolean getHasBeenHandled() {
        return this.a;
    }

    public final T peekContent() {
        return this.b;
    }
}
