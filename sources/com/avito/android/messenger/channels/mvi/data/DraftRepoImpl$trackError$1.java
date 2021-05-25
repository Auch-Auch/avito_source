package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.messenger.conversation.mvi.data.DatabaseErrorHandler;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u00042\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/reactivex/Flowable;", "", "kotlin.jvm.PlatformType", "errors", "Lorg/reactivestreams/Publisher;", "apply", "(Lio/reactivex/Flowable;)Lorg/reactivestreams/Publisher;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class DraftRepoImpl$trackError$1<T, R> implements Function<Flowable<Throwable>, Publisher<?>> {
    public final /* synthetic */ DraftRepoImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;

    public DraftRepoImpl$trackError$1(DraftRepoImpl draftRepoImpl, String str, Map map) {
        this.a = draftRepoImpl;
        this.b = str;
        this.c = map;
    }

    public final Publisher<?> apply(@NotNull Flowable<Throwable> flowable) {
        Intrinsics.checkNotNullParameter(flowable, "errors");
        DatabaseErrorHandler databaseErrorHandler = this.a.b;
        Observable<Throwable> observable = flowable.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "errors.toObservable()");
        return databaseErrorHandler.handleErrors(observable, this.b, this.c).toFlowable(BackpressureStrategy.BUFFER);
    }
}
