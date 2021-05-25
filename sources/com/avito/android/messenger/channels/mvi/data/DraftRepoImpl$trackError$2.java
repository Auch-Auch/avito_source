package com.avito.android.messenger.channels.mvi.data;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "T", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", "errors", "Lio/reactivex/ObservableSource;", "apply", "(Lio/reactivex/Observable;)Lio/reactivex/ObservableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class DraftRepoImpl$trackError$2<T, R> implements Function<Observable<Throwable>, ObservableSource<?>> {
    public final /* synthetic */ DraftRepoImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;

    public DraftRepoImpl$trackError$2(DraftRepoImpl draftRepoImpl, String str, Map map) {
        this.a = draftRepoImpl;
        this.b = str;
        this.c = map;
    }

    public final ObservableSource<?> apply(@NotNull Observable<Throwable> observable) {
        Intrinsics.checkNotNullParameter(observable, "errors");
        return this.a.b.handleErrors(observable, this.b, this.c);
    }
}
