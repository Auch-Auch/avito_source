package com.avito.android.safedeal.profile_settings;

import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.safedeal.remote.model.ProfileDeliverySettings;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00030\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractorImpl;", "Lcom/avito/android/safedeal/profile_settings/ProfileDeliverySettingsInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/safedeal/remote/model/ProfileDeliverySettings;", "getSettings", "()Lio/reactivex/rxjava3/core/Observable;", "", "serviceId", "", "isEnabled", "", "toggleService", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/safedeal/remote/SafeDealApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/safedeal/remote/SafeDealApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/safedeal/remote/SafeDealApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileDeliverySettingsInteractorImpl implements ProfileDeliverySettingsInteractor {
    public final SafeDealApi a;
    public final TypedErrorThrowableConverter b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<TypedResult<ProfileDeliverySettings>, LoadingState<? super ProfileDeliverySettings>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ProfileDeliverySettings> apply(TypedResult<ProfileDeliverySettings> typedResult) {
            TypedResult<ProfileDeliverySettings> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super ProfileDeliverySettings>> {
        public final /* synthetic */ ProfileDeliverySettingsInteractorImpl a;

        public b(ProfileDeliverySettingsInteractorImpl profileDeliverySettingsInteractorImpl) {
            this.a = profileDeliverySettingsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ProfileDeliverySettings> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<Unit>, LoadingState<? super Unit>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Unit> apply(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super Unit>> {
        public final /* synthetic */ ProfileDeliverySettingsInteractorImpl a;

        public d(ProfileDeliverySettingsInteractorImpl profileDeliverySettingsInteractorImpl) {
            this.a = profileDeliverySettingsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Unit> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.b;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public ProfileDeliverySettingsInteractorImpl(@NotNull SafeDealApi safeDealApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(safeDealApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = safeDealApi;
        this.b = typedErrorThrowableConverter;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsInteractor
    @NotNull
    public Observable<LoadingState<ProfileDeliverySettings>> getSettings() {
        Observable<R> onErrorReturn = this.a.deliveryProfileSettings().subscribeOn(this.c.io()).map(a.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.deliveryProfileSetti…rConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.safedeal.profile_settings.ProfileDeliverySettingsInteractor
    @NotNull
    public Observable<LoadingState<Unit>> toggleService(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "serviceId");
        Observable<R> onErrorReturn = this.a.toggleService(str, z).subscribeOn(this.c.io()).map(c.a).startWithItem((R) LoadingState.Loading.INSTANCE).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.toggleService(servic…rConverter.convert(it)) }");
        return onErrorReturn;
    }
}
