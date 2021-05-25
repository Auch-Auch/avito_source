package com.avito.android.vas_performance.repository;

import com.avito.android.Features;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinkResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.vas.applied.AppliedVasResult;
import com.avito.android.remote.model.vas.performance.VasPerformanceResult;
import com.avito.android.remote.model.vas.visual.VasVisualResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.vas.remote.VasApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\bJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\bJ9\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/avito/android/vas_performance/repository/VasRepositoryImpl;", "Lcom/avito/android/vas_performance/repository/VasRepository;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", "getPerformanceVas", "(Ljava/lang/String;)Lio/reactivex/Observable;", "checkoutContext", "getPerformanceVasV2", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/vas/visual/VasVisualResult;", "getVisualVas", "getVisualVasNew", "Lcom/avito/android/remote/model/vas/applied/AppliedVasResult;", "getAppliedVas", "", "slugs", "Lcom/avito/android/remote/model/DeepLinkResponse;", "getVasContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lio/reactivex/Observable;", "Lcom/avito/android/vas/remote/VasApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/vas/remote/VasApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/vas/remote/VasApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/Features;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VasRepositoryImpl implements VasRepository {
    public final VasApi a;
    public final SchedulersFactory b;

    public static final class a<T, R> implements Function<TypedResult<AppliedVasResult>, LoadingState<? super AppliedVasResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AppliedVasResult> apply(TypedResult<AppliedVasResult> typedResult) {
            TypedResult<AppliedVasResult> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<TypedResult<VasPerformanceResult>, LoadingState<? super VasPerformanceResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super VasPerformanceResult> apply(TypedResult<VasPerformanceResult> typedResult) {
            TypedResult<VasPerformanceResult> typedResult2 = typedResult;
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

    public static final class c<T, R> implements Function<TypedResult<VasPerformanceResult>, LoadingState<? super VasPerformanceResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super VasPerformanceResult> apply(TypedResult<VasPerformanceResult> typedResult) {
            TypedResult<VasPerformanceResult> typedResult2 = typedResult;
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

    public static final class d<T, R> implements Function<TypedResult<DeepLinkResponse>, LoadingState<? super DeepLinkResponse>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super DeepLinkResponse> apply(TypedResult<DeepLinkResponse> typedResult) {
            TypedResult<DeepLinkResponse> typedResult2 = typedResult;
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

    public static final class e<T, R> implements Function<TypedResult<VasVisualResult>, LoadingState<? super VasVisualResult>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super VasVisualResult> apply(TypedResult<VasVisualResult> typedResult) {
            TypedResult<VasVisualResult> typedResult2 = typedResult;
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

    public static final class f<T, R> implements Function<TypedResult<VasVisualResult>, LoadingState<? super VasVisualResult>> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super VasVisualResult> apply(TypedResult<VasVisualResult> typedResult) {
            TypedResult<VasVisualResult> typedResult2 = typedResult;
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

    @Inject
    public VasRepositoryImpl(@NotNull VasApi vasApi, @NotNull SchedulersFactory schedulersFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(vasApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = vasApi;
        this.b = schedulersFactory;
    }

    @Override // com.avito.android.vas_performance.repository.VasRepository
    @NotNull
    public Observable<LoadingState<AppliedVasResult>> getAppliedVas(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Observable<LoadingState<AppliedVasResult>> startWith = InteropKt.toV2(this.a.getAppliedVas(str)).subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getAppliedVas(advert…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.vas_performance.repository.VasRepository
    @NotNull
    public Observable<LoadingState<VasPerformanceResult>> getPerformanceVas(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Observable<LoadingState<VasPerformanceResult>> startWith = InteropKt.toV2(this.a.getPerformanceVas(str)).subscribeOn(this.b.io()).map(b.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getPerformanceVas(ad…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.vas_performance.repository.VasRepository
    @NotNull
    public Observable<LoadingState<VasPerformanceResult>> getPerformanceVasV2(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Observable<LoadingState<VasPerformanceResult>> startWith = InteropKt.toV2(this.a.getPerformanceVasV2(str, str2)).subscribeOn(this.b.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getPerformanceVasV2(…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.vas_performance.repository.VasRepository
    @NotNull
    public Observable<LoadingState<DeepLinkResponse>> getVasContext(@NotNull String str, @NotNull String str2, @NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Intrinsics.checkNotNullParameter(set, "slugs");
        Observable<LoadingState<DeepLinkResponse>> startWith = InteropKt.toV2(this.a.vasContext(str, RequestUtils.INSTANCE.toArrayQueryParams(set, "slug"), str2)).subscribeOn(this.b.io()).map(d.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.vasContext(advertId,…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.vas_performance.repository.VasRepository
    @NotNull
    public Observable<LoadingState<VasVisualResult>> getVisualVas(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Observable<LoadingState<VasVisualResult>> startWith = InteropKt.toV2(this.a.getVisualVas(str)).subscribeOn(this.b.io()).map(e.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getVisualVas(advertI…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.vas_performance.repository.VasRepository
    @NotNull
    public Observable<LoadingState<VasVisualResult>> getVisualVasNew(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "checkoutContext");
        Observable<LoadingState<VasVisualResult>> startWith = InteropKt.toV2(this.a.getVisualVasV3(str, str2)).subscribeOn(this.b.io()).map(f.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getVisualVasV3(adver…ith(LoadingState.Loading)");
        return startWith;
    }
}
