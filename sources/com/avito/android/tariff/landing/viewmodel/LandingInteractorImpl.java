package com.avito.android.tariff.landing.viewmodel;

import com.avito.android.remote.TariffApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.model.TariffLandingResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/tariff/landing/viewmodel/LandingInteractorImpl;", "Lcom/avito/android/tariff/landing/viewmodel/LandingInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/tariff/landing/viewmodel/TariffLanding;", "getLanding", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/TariffApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/TariffApi;", "api", "Lcom/avito/android/tariff/landing/viewmodel/LandingConverter;", "c", "Lcom/avito/android/tariff/landing/viewmodel/LandingConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "checkoutContext", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/TariffApi;Lcom/avito/android/tariff/landing/viewmodel/LandingConverter;Lcom/avito/android/util/SchedulersFactory;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class LandingInteractorImpl implements LandingInteractor {
    public final String a;
    public final TariffApi b;
    public final LandingConverter c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<TypedResult<TariffLandingResult>, LoadingState<? super TariffLandingResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffLandingResult> apply(TypedResult<TariffLandingResult> typedResult) {
            TypedResult<TariffLandingResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<LoadingState<? super TariffLandingResult>, LoadingState<? super TariffLanding>> {
        public final /* synthetic */ LandingInteractorImpl a;

        public b(LandingInteractorImpl landingInteractorImpl) {
            this.a = landingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffLanding> apply(LoadingState<? super TariffLandingResult> loadingState) {
            LoadingState<? super TariffLandingResult> loadingState2 = loadingState;
            Intrinsics.checkNotNullParameter(loadingState2, "it");
            return this.a.c.convert(loadingState2);
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super TariffLanding>> {
        public final /* synthetic */ LandingInteractorImpl a;

        public c(LandingInteractorImpl landingInteractorImpl) {
            this.a = landingInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super TariffLanding> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return LandingInteractorImpl.access$toSimpleMessageError(this.a, th2);
        }
    }

    @Inject
    public LandingInteractorImpl(@NotNull String str, @NotNull TariffApi tariffApi, @NotNull LandingConverter landingConverter, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(tariffApi, "api");
        Intrinsics.checkNotNullParameter(landingConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = str;
        this.b = tariffApi;
        this.c = landingConverter;
        this.d = schedulersFactory;
    }

    public static final LoadingState access$toSimpleMessageError(LandingInteractorImpl landingInteractorImpl, Throwable th) {
        Objects.requireNonNull(landingInteractorImpl);
        return new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(th.toString()));
    }

    @Override // com.avito.android.tariff.landing.viewmodel.LandingInteractor
    @NotNull
    public Observable<LoadingState<TariffLanding>> getLanding() {
        Observable<LoadingState<TariffLanding>> onErrorReturn = InteropKt.toV2(this.b.getTariffLanding(this.a)).subscribeOn(this.d.io()).map(a.a).map(new b(this)).onErrorReturn(new c(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "chooseMethodBasedOnToggl….toSimpleMessageError() }");
        return onErrorReturn;
    }
}
