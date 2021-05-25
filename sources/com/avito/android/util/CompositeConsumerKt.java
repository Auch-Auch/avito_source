package com.avito.android.util;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a4\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lcom/avito/android/util/CompositeConsumer;", "Lio/reactivex/functions/Consumer;", "consumer", "plus", "(Lcom/avito/android/util/CompositeConsumer;Lio/reactivex/functions/Consumer;)Lcom/avito/android/util/CompositeConsumer;", "(Lio/reactivex/functions/Consumer;Lio/reactivex/functions/Consumer;)Lcom/avito/android/util/CompositeConsumer;", "rx"}, k = 2, mv = {1, 4, 2})
public final class CompositeConsumerKt {
    @NotNull
    public static final <T> CompositeConsumer<T> plus(@NotNull CompositeConsumer<T> compositeConsumer, @NotNull Consumer<T> consumer) {
        Intrinsics.checkNotNullParameter(compositeConsumer, "$this$plus");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        compositeConsumer.add(consumer);
        return compositeConsumer;
    }

    @NotNull
    public static final <T> CompositeConsumer<T> plus(@NotNull Consumer<T> consumer, @NotNull Consumer<T> consumer2) {
        Intrinsics.checkNotNullParameter(consumer, "$this$plus");
        Intrinsics.checkNotNullParameter(consumer2, "consumer");
        return new CompositeConsumer<>(consumer, consumer2);
    }
}
