package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@NotThreadSafe
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B'\u0012\u001e\u0010\u0011\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0010\"\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/util/CompositeConsumer;", "T", "Lio/reactivex/functions/Consumer;", "value", "", "accept", "(Ljava/lang/Object;)V", "consumer", ProductAction.ACTION_ADD, "(Lio/reactivex/functions/Consumer;)V", "clear", "()V", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "consumerList", "", "delegates", "<init>", "([Lio/reactivex/functions/Consumer;)V", "rx"}, k = 1, mv = {1, 4, 2})
public final class CompositeConsumer<T> implements Consumer<T> {
    public List<Consumer<T>> a;

    public CompositeConsumer(@NotNull Consumer<T>... consumerArr) {
        Intrinsics.checkNotNullParameter(consumerArr, "delegates");
        this.a = ArraysKt___ArraysKt.toMutableList(consumerArr);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(T t) {
        for (Consumer<T> consumer : this.a) {
            consumer.accept(t);
        }
    }

    public final void add(@NotNull Consumer<T> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.a.add(consumer);
    }

    public final void clear() {
        this.a.clear();
    }
}
