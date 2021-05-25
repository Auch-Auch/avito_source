package com.avito.android.autoteka_details.core;

import a2.a.a.o.b.c;
import com.avito.android.autoteka.remote.AutotekaApi;
import com.avito.android.autoteka_details.core.di.AutotekaTeaserInteractorState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AutotekaTeaserResponse;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\"\u0010#J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractorImpl;", "Lcom/avito/android/autoteka_details/core/AutotekaTeaserInteractor;", "Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "getResponse", "()Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "", "itemId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "getAutotekaTeaser", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/autoteka/remote/AutotekaApi;", "c", "Lcom/avito/android/autoteka/remote/AutotekaApi;", "api", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/AutotekaTeaserResponse;", "autotekaTeaser", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "e", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/TypedResultException;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/TypedResultException;", "teaserNotAvailableError", "state", "<init>", "(Lcom/avito/android/autoteka/remote/AutotekaApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/Kundle;)V", "autoteka-details-core_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserInteractorImpl implements AutotekaTeaserInteractor {
    public AutotekaTeaserResponse a;
    public final TypedResultException b;
    public final AutotekaApi c;
    public final SchedulersFactory d;
    public final TypedErrorThrowableConverter e;

    public static final class a<T, R> implements Function<AutotekaTeaserResponse, LoadingState<? super AutotekaTeaserResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AutotekaTeaserResponse> apply(AutotekaTeaserResponse autotekaTeaserResponse) {
            AutotekaTeaserResponse autotekaTeaserResponse2 = autotekaTeaserResponse;
            Intrinsics.checkNotNullParameter(autotekaTeaserResponse2, "it");
            return new LoadingState.Loaded(autotekaTeaserResponse2);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super AutotekaTeaserResponse>> {
        public final /* synthetic */ AutotekaTeaserInteractorImpl a;

        public b(AutotekaTeaserInteractorImpl autotekaTeaserInteractorImpl) {
            this.a = autotekaTeaserInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AutotekaTeaserResponse> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return new LoadingState.Error(this.a.e.convert(this.a.b));
        }
    }

    @Inject
    public AutotekaTeaserInteractorImpl(@NotNull AutotekaApi autotekaApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @AutotekaTeaserInteractorState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(autotekaApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.c = autotekaApi;
        this.d = schedulersFactory;
        this.e = typedErrorThrowableConverter;
        this.a = kundle != null ? (AutotekaTeaserResponse) kundle.getParcelable("autoteka_teaser_key") : null;
        this.b = new TypedResultException(new ErrorResult.UnknownError("Can't fetch autoteka teaser", null, null, 6, null));
    }

    @Override // com.avito.android.autoteka_details.core.AutotekaTeaserInteractor
    @NotNull
    public Observable<LoadingState<AutotekaTeaserResponse>> getAutotekaTeaser(@NotNull String str) {
        Observable observable;
        Intrinsics.checkNotNullParameter(str, "itemId");
        AutotekaTeaserResponse autotekaTeaserResponse = this.a;
        if (autotekaTeaserResponse == null) {
            observable = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.empty()");
        } else {
            observable = Observable.just(autotekaTeaserResponse);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(autotekaTeaser)");
        }
        Observable subscribeOn = InteropKt.toV2(this.c.getAutotekaTeaser(str)).doOnNext(new c(this)).subscribeOn(this.d.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getAutotekaTeaser(it…scribeOn(schedulers.io())");
        Observable<LoadingState<AutotekaTeaserResponse>> startWith = observable.switchIfEmpty(subscribeOn).map(a.a).onErrorReturn(new b(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "buildAutotekaTeaserObser…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.autoteka_details.core.AutotekaTeaserInteractor
    @Nullable
    public AutotekaTeaserResponse getResponse() {
        return this.a;
    }

    @Override // com.avito.android.autoteka_details.core.AutotekaTeaserInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("autoteka_teaser_key", this.a);
        return kundle;
    }
}
