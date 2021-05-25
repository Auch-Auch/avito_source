package com.avito.android.developments_catalog;

import com.avito.android.Features;
import com.avito.android.developments_catalog.remote.DevelopmentsCatalogApi;
import com.avito.android.developments_catalog.remote.model.DevelopmentsCatalogResponse;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractorImpl;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractor;", "", "itemId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsCatalogResponse;", "loadDevelopmentsCatalog", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/developments_catalog/remote/DevelopmentsCatalogApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/developments_catalog/remote/DevelopmentsCatalogApi;", "api", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/developments_catalog/remote/DevelopmentsCatalogApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/Features;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogInteractorImpl implements DevelopmentsCatalogInteractor {
    public final DevelopmentsCatalogApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;
    public final Features d;

    public static final class a<T, R> implements Function<TypedResult<DevelopmentsCatalogResponse>, LoadingState<? super DevelopmentsCatalogResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DevelopmentsCatalogResponse> apply(TypedResult<DevelopmentsCatalogResponse> typedResult) {
            TypedResult<DevelopmentsCatalogResponse> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super DevelopmentsCatalogResponse>> {
        public final /* synthetic */ DevelopmentsCatalogInteractorImpl a;

        public b(DevelopmentsCatalogInteractorImpl developmentsCatalogInteractorImpl) {
            this.a = developmentsCatalogInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super DevelopmentsCatalogResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public DevelopmentsCatalogInteractorImpl(@NotNull DevelopmentsCatalogApi developmentsCatalogApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(developmentsCatalogApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = developmentsCatalogApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
        this.d = features;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogInteractor
    @NotNull
    public Observable<LoadingState<DevelopmentsCatalogResponse>> loadDevelopmentsCatalog(@NotNull String str) {
        Observable<TypedResult<DevelopmentsCatalogResponse>> observable;
        Intrinsics.checkNotNullParameter(str, "itemId");
        if (this.d.getDevelopmentsCatalogAlertBanner().invoke().booleanValue() || this.d.getDevelopmentsCatalogBuildingProgress().invoke().booleanValue()) {
            observable = this.a.getDevelopmentsCatalogV2(str);
        } else {
            observable = this.a.getDevelopmentsCatalog(str);
        }
        return a2.b.a.a.a.a2(this.b, observable.map(a.a).startWithItem(LoadingState.Loading.INSTANCE).onErrorReturn(new b(this)), "if (features.development…scribeOn(schedulers.io())");
    }
}
