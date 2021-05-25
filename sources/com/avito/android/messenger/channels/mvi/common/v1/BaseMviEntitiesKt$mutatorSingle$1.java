package com.avito.android.messenger.channels.mvi.common.v1;

import io.reactivex.Single;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00018\u00008\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "T", "oldState", "Lio/reactivex/Single;", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)Lio/reactivex/Single;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class BaseMviEntitiesKt$mutatorSingle$1 extends Lambda implements Function1<T, Single<T>> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMviEntitiesKt$mutatorSingle$1(Function1 function1) {
        super(1);
        this.a = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Single<T> invoke(@NotNull final T t) {
        Intrinsics.checkNotNullParameter(t, "oldState");
        Single<T> fromCallable = Single.fromCallable(new Callable<T>(this) { // from class: com.avito.android.messenger.channels.mvi.common.v1.BaseMviEntitiesKt$mutatorSingle$1.1
            public final /* synthetic */ BaseMviEntitiesKt$mutatorSingle$1 a;

            {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public final T call() {
                return (T) this.a.a.invoke(t);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …tator(oldState)\n        }");
        return fromCallable;
    }
}
