package com.avito.android.util.rx3;

import io.reactivex.rxjava3.subscribers.DisposableSubscriber;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"com/avito/android/util/rx3/SubscribersKt$createDisposableSubscriber$3", "Lio/reactivex/rxjava3/subscribers/DisposableSubscriber;", "item", "", "onNext", "(Ljava/lang/Object;)V", "onComplete", "()V", "", "t", "onError", "(Ljava/lang/Throwable;)V", "onStart", "rx"}, k = 1, mv = {1, 4, 2})
public final class SubscribersKt$createDisposableSubscriber$3 extends DisposableSubscriber<T> {
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Function1 e;

    public SubscribersKt$createDisposableSubscriber$3(Function2 function2, Function0 function0, Function1 function1, Function1 function12) {
        this.b = function2;
        this.c = function0;
        this.d = function1;
        this.e = function12;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.c.invoke();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(@Nullable Throwable th) {
        this.d.invoke(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "item");
        this.b.invoke(new Function1<Long, Unit>(this) { // from class: com.avito.android.util.rx3.SubscribersKt$createDisposableSubscriber$3$onNext$1
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                ((SubscribersKt$createDisposableSubscriber$3) this.receiver).request(j);
            }
        }, t);
    }

    @Override // io.reactivex.rxjava3.subscribers.DisposableSubscriber
    public void onStart() {
        this.e.invoke(new Function1<Long, Unit>(this) { // from class: com.avito.android.util.rx3.SubscribersKt$createDisposableSubscriber$3$onStart$1
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                ((SubscribersKt$createDisposableSubscriber$3) this.receiver).request(j);
            }
        });
    }
}
