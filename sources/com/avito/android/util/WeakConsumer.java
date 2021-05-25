package com.avito.android.util;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R<\u0010\f\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004 \t*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b0\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/WeakConsumer;", "T", "Lio/reactivex/functions/Consumer;", "value", "", "accept", "(Ljava/lang/Object;)V", "Ljava/lang/ref/WeakReference;", "Lkotlin/Function1;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/lang/ref/WeakReference;", "weakConsumer", "consumer", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class WeakConsumer<T> implements Consumer<T> {
    public final WeakReference<Function1<T, Unit>> a;

    public WeakConsumer(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "consumer");
        this.a = new WeakReference<>(function1);
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(T t) {
        Function1<T, Unit> function1 = this.a.get();
        if (function1 != null) {
            function1.invoke(t);
        }
    }
}
