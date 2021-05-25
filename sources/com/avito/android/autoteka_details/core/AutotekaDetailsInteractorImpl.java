package com.avito.android.autoteka_details.core;

import a2.g.r.g;
import com.avito.android.autoteka.remote.AutotekaApi;
import com.avito.android.autoteka_details.core.di.AutotekaInteractorState;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AutotekaDetailsResponse;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b*\u0010+J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractorImpl;", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "getAutotekaItem", "()Lio/reactivex/Observable;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/autoteka/remote/AutotekaApi;", "e", "Lcom/avito/android/autoteka/remote/AutotekaApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", "d", "Ljava/lang/String;", "itemId", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", g.a, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/TypedResultException;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/TypedResultException;", "reportNotAvailableError", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "getAutotekaDetails", "()Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "setAutotekaDetails", "(Lcom/avito/android/remote/model/AutotekaDetailsResponse;)V", "autotekaDetails", "", "c", "Ljava/lang/Boolean;", "reportAvailable", "state", "<init>", "(Ljava/lang/String;Lcom/avito/android/autoteka/remote/AutotekaApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/Kundle;Lcom/avito/android/remote/model/AutotekaDetailsResponse;)V", "autoteka-details-core_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsInteractorImpl implements AutotekaDetailsInteractor {
    public final TypedResultException a = new TypedResultException(new ErrorResult.UnknownError("Report is not available", null, null, 6, null));
    @Nullable
    public AutotekaDetailsResponse b;
    public Boolean c;
    public final String d;
    public final AutotekaApi e;
    public final SchedulersFactory f;
    public final TypedErrorThrowableConverter g;

    public static final class a<T, R> implements Function<AutotekaDetailsResponse, LoadingState<? super AutotekaDetailsResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AutotekaDetailsResponse> apply(AutotekaDetailsResponse autotekaDetailsResponse) {
            AutotekaDetailsResponse autotekaDetailsResponse2 = autotekaDetailsResponse;
            Intrinsics.checkNotNullParameter(autotekaDetailsResponse2, "it");
            return new LoadingState.Loaded(autotekaDetailsResponse2);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super AutotekaDetailsResponse>> {
        public final /* synthetic */ AutotekaDetailsInteractorImpl a;

        public b(AutotekaDetailsInteractorImpl autotekaDetailsInteractorImpl) {
            this.a = autotekaDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AutotekaDetailsResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.g.convert(th2));
        }
    }

    @Inject
    public AutotekaDetailsInteractorImpl(@AdvertId @NotNull String str, @NotNull AutotekaApi autotekaApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @AutotekaInteractorState @Nullable Kundle kundle, @Nullable AutotekaDetailsResponse autotekaDetailsResponse) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(autotekaApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.d = str;
        this.e = autotekaApi;
        this.f = schedulersFactory;
        this.g = typedErrorThrowableConverter;
        if (autotekaDetailsResponse == null) {
            setAutotekaDetails(kundle != null ? (AutotekaDetailsResponse) kundle.getParcelable("autoteka_details_key") : null);
        } else {
            setAutotekaDetails(autotekaDetailsResponse);
        }
    }

    @Override // com.avito.android.autoteka_details.core.AutotekaDetailsInteractor
    @Nullable
    public AutotekaDetailsResponse getAutotekaDetails() {
        return this.b;
    }

    @Override // com.avito.android.autoteka_details.core.AutotekaDetailsInteractor
    @NotNull
    public Observable<LoadingState<AutotekaDetailsResponse>> getAutotekaItem() {
        Observable observable;
        Boolean bool = this.c;
        AutotekaDetailsResponse autotekaDetails = getAutotekaDetails();
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            observable = Observable.error(this.a);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.error(reportNotAvailableError)");
        } else if (autotekaDetails == null) {
            observable = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.empty()");
        } else {
            observable = Observable.just(autotekaDetails);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(autotekaDetails)");
        }
        Observable subscribeOn = InteropKt.toV2(this.e.getAutotekaItem(this.d)).flatMap(new a2.a.a.o.b.a(this)).doOnNext(new a2.a.a.o.b.b(this)).subscribeOn(this.f.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getAutotekaItem(item…scribeOn(schedulers.io())");
        Observable<LoadingState<AutotekaDetailsResponse>> startWith = observable.switchIfEmpty(subscribeOn).map(a.a).onErrorReturn(new b(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "buildAutotekaDetailsObse…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.autoteka_details.core.AutotekaDetailsInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("autoteka_details_key", getAutotekaDetails());
        return kundle;
    }

    @Override // com.avito.android.autoteka_details.core.AutotekaDetailsInteractor
    public void setAutotekaDetails(@Nullable AutotekaDetailsResponse autotekaDetailsResponse) {
        this.b = autotekaDetailsResponse;
    }
}
