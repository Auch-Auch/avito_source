package com.avito.android.messenger.conversation.mvi.data;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "T", "Lio/reactivex/Flowable;", "", "kotlin.jvm.PlatformType", "errors", "Lorg/reactivestreams/Publisher;", "apply", "(Lio/reactivex/Flowable;)Lorg/reactivestreams/Publisher;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class MessageRepoImpl$trackError$2<T, R> implements Function<Flowable<Throwable>, Publisher<?>> {
    public final /* synthetic */ MessageRepoImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;

    public MessageRepoImpl$trackError$2(MessageRepoImpl messageRepoImpl, String str, Map map) {
        this.a = messageRepoImpl;
        this.b = str;
        this.c = map;
    }

    public final Publisher<?> apply(@NotNull Flowable<Throwable> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "errors");
        DatabaseErrorHandler databaseErrorHandler = this.a.e;
        Observable<Throwable> observable = flowable.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "errors.toObservable()");
        return databaseErrorHandler.handleErrors(observable, this.b, this.c).toFlowable(BackpressureStrategy.BUFFER);
    }
}
