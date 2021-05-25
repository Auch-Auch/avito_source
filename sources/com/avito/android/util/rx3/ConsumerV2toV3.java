package com.avito.android.util.rx3;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/util/rx3/ConsumerV2toV3;", "T", "Lio/reactivex/rxjava3/functions/Consumer;", "value", "", "accept", "(Ljava/lang/Object;)V", "Lio/reactivex/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "wrap", "<init>", "(Lio/reactivex/functions/Consumer;)V", "rx"}, k = 1, mv = {1, 4, 2})
public final class ConsumerV2toV3<T> implements Consumer<T> {
    public final io.reactivex.functions.Consumer<T> a;

    public ConsumerV2toV3(@NotNull io.reactivex.functions.Consumer<T> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "wrap");
        this.a = consumer;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(T t) {
        this.a.accept(t);
    }
}
