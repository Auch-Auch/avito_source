package com.avito.android.str_calendar.seller.edit;

import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.StrSellerCalendarParameters;
import com.avito.android.remote.model.StrSellerCalendarParametersUpdateResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validation.LocalPretendInteractor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b&\u0010'J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f0\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractorImpl;", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersInteractor;", "", "itemId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/StrSellerCalendarParameters;", "getSellerCalendarBaseParameters", "(Ljava/lang/String;)Lio/reactivex/Observable;", "startDate", "endDate", "getSellerCalendarRangeParameters", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "", "validateFields", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lio/reactivex/Observable;", "paramsMap", "Lcom/avito/android/remote/model/StrSellerCalendarParametersUpdateResponse;", "submitParameters", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/ShortTermRentApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ShortTermRentApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/validation/LocalPretendInteractor;", "d", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "<init>", "(Lcom/avito/android/remote/ShortTermRentApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/validation/LocalPretendInteractor;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarParametersInteractorImpl implements SellerCalendarParametersInteractor {
    public final ShortTermRentApi a;
    public final SchedulersFactory b;
    public final TypedErrorThrowableConverter c;
    public final LocalPretendInteractor d;

    public static final class a<T, R> implements Function<TypedResult<StrSellerCalendarParameters>, LoadingState<? super StrSellerCalendarParameters>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrSellerCalendarParameters> apply(TypedResult<StrSellerCalendarParameters> typedResult) {
            TypedResult<StrSellerCalendarParameters> typedResult2 = typedResult;
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

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super StrSellerCalendarParameters>> {
        public final /* synthetic */ SellerCalendarParametersInteractorImpl a;

        public b(SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl) {
            this.a = sellerCalendarParametersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrSellerCalendarParameters> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class c<T, R> implements Function<TypedResult<StrSellerCalendarParameters>, LoadingState<? super StrSellerCalendarParameters>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrSellerCalendarParameters> apply(TypedResult<StrSellerCalendarParameters> typedResult) {
            TypedResult<StrSellerCalendarParameters> typedResult2 = typedResult;
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

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super StrSellerCalendarParameters>> {
        public final /* synthetic */ SellerCalendarParametersInteractorImpl a;

        public d(SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl) {
            this.a = sellerCalendarParametersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrSellerCalendarParameters> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class e<T, R> implements Function<TypedResult<StrSellerCalendarParametersUpdateResponse>, LoadingState<? super StrSellerCalendarParametersUpdateResponse>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrSellerCalendarParametersUpdateResponse> apply(TypedResult<StrSellerCalendarParametersUpdateResponse> typedResult) {
            TypedResult<StrSellerCalendarParametersUpdateResponse> typedResult2 = typedResult;
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

    public static final class f<T, R> implements Function<Throwable, LoadingState<? super StrSellerCalendarParametersUpdateResponse>> {
        public final /* synthetic */ SellerCalendarParametersInteractorImpl a;

        public f(SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl) {
            this.a = sellerCalendarParametersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super StrSellerCalendarParametersUpdateResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    public static final class g<T, R> implements Function<Throwable, LoadingState<? super Map<String, ? extends String>>> {
        public final /* synthetic */ SellerCalendarParametersInteractorImpl a;

        public g(SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl) {
            this.a = sellerCalendarParametersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Map<String, ? extends String>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.c.convert(th2));
        }
    }

    @Inject
    public SellerCalendarParametersInteractorImpl(@NotNull ShortTermRentApi shortTermRentApi, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull LocalPretendInteractor localPretendInteractor) {
        Intrinsics.checkNotNullParameter(shortTermRentApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        this.a = shortTermRentApi;
        this.b = schedulersFactory;
        this.c = typedErrorThrowableConverter;
        this.d = localPretendInteractor;
    }

    public static final LoadingState.Loaded access$toLoadedObservable(SellerCalendarParametersInteractorImpl sellerCalendarParametersInteractorImpl, Map map) {
        Objects.requireNonNull(sellerCalendarParametersInteractorImpl);
        return new LoadingState.Loaded(map);
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractor
    @NotNull
    public Observable<LoadingState<StrSellerCalendarParameters>> getSellerCalendarBaseParameters(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Observable<LoadingState<StrSellerCalendarParameters>> onErrorReturn = InteropKt.toV2(this.a.baseSellerCalendarParameters(str)).subscribeOn(this.b.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.baseSellerCalendarPa…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractor
    @NotNull
    public Observable<LoadingState<StrSellerCalendarParameters>> getSellerCalendarRangeParameters(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "itemId", str2, "startDate", str3, "endDate");
        Observable<LoadingState<StrSellerCalendarParameters>> onErrorReturn = InteropKt.toV2(this.a.rangeSellerCalendarParameters(str, str2, str3)).subscribeOn(this.b.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.rangeSellerCalendarP…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractor
    @NotNull
    public Observable<LoadingState<StrSellerCalendarParametersUpdateResponse>> submitParameters(@NotNull String str, @NotNull Map<String, String> map, @Nullable String str2, @Nullable String str3) {
        Observable observable;
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(map, "paramsMap");
        if (str2 != null) {
            ShortTermRentApi shortTermRentApi = this.a;
            if (str3 == null) {
                str3 = str2;
            }
            observable = InteropKt.toV2(shortTermRentApi.updateRangeSellerCalendarParameters(str, str2, str3, map));
        } else {
            observable = InteropKt.toV2(this.a.updateBaseSellerCalendarParameters(str, map));
        }
        Observable<LoadingState<StrSellerCalendarParametersUpdateResponse>> onErrorReturn = observable.subscribeOn(this.b.io()).map(e.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new f(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "if (startDate != null) {…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractor
    @NotNull
    public Observable<LoadingState<Map<String, String>>> validateFields(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, "parametersTree");
        Observable map = Observable.just(parametersTree).flatMap(new a2.a.a.b3.c.b.c(this)).map(a2.a.a.b3.c.b.d.a).map(new a2.a.a.b3.c.b.e(this));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.just(paramete…it.toLoadedObservable() }");
        Observable<LoadingState<Map<String, String>>> startWith = map.onErrorReturn(new g(this)).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "localFieldsValidate(para…ith(LoadingState.Loading)");
        return startWith;
    }
}
