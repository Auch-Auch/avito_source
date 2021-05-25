package com.avito.android.advert_core.safedeal;

import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.safedeal.remote.SafeDealApi;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractorImpl;", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesInteractor;", "", "serviceID", "", "isEnabled", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "", "toggleService", "(Ljava/lang/String;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "itemID", "Lcom/avito/android/safedeal/remote/SafeDealApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/safedeal/remote/SafeDealApi;", "api", "<init>", "(Ljava/lang/String;Lcom/avito/android/safedeal/remote/SafeDealApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertSafeDealServicesInteractorImpl implements MyAdvertSafeDealServicesInteractor {
    public final String a;
    public final SafeDealApi b;
    public final TypedErrorThrowableConverter c;
    public final SchedulersFactory3 d;

    public static final class a<T, R> implements Function<TypedResult<Unit>, LoadingState<? super Unit>> {
        public static final a a = new a();

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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super Unit>> {
        public final /* synthetic */ MyAdvertSafeDealServicesInteractorImpl a;

        public b(MyAdvertSafeDealServicesInteractorImpl myAdvertSafeDealServicesInteractorImpl) {
            this.a = myAdvertSafeDealServicesInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Unit> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public MyAdvertSafeDealServicesInteractorImpl(@AdvertId @NotNull String str, @NotNull SafeDealApi safeDealApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(str, "itemID");
        Intrinsics.checkNotNullParameter(safeDealApi, "api");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = str;
        this.b = safeDealApi;
        this.c = typedErrorThrowableConverter;
        this.d = schedulersFactory3;
    }

    @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractor
    @NotNull
    public Observable<LoadingState<Unit>> toggleService(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "serviceID");
        Observable<R> startWithItem = this.b.toggleServiceForItem(this.a, str, z).subscribeOn(this.d.io()).map(a.a).onErrorReturn(new b(this)).startWithItem((R) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "api.toggleServiceForItem…tem(LoadingState.Loading)");
        return startWithItem;
    }
}
