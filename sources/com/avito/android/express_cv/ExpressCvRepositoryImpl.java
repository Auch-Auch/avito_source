package com.avito.android.express_cv;

import com.avito.android.epress_cv.remote.ExpressCvApi;
import com.avito.android.epress_cv.remote.model.CreateExpressCvResult;
import com.avito.android.epress_cv.remote.model.CvResult;
import com.avito.android.epress_cv.remote.model.ExpressCvInfo;
import com.avito.android.epress_cv.remote.model.NeedPhoneVerificationError;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.Channel;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b&\u0010'J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\bJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\bJ7\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00050\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/express_cv/ExpressCvRepositoryImpl;", "Lcom/avito/android/express_cv/ExpressCvRepository;", "", "context", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;", "getExpressCvInfo", "(Ljava/lang/String;)Lio/reactivex/Observable;", "itemId", "getMessengerChannel", "id", "Lcom/avito/android/epress_cv/remote/model/CvResult;", "activateCv", "", "params", "Lcom/avito/android/epress_cv/remote/model/CreateExpressCvResult$Ok;", "publishExpressCv", "(Ljava/util/Map;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PretendResult;", "validateParams", "(Ljava/util/Map;)Lio/reactivex/Observable;", "disableExpressCv", "()Lio/reactivex/Observable;", "Lru/avito/messenger/api/AvitoMessengerApi;", "c", "Lru/avito/messenger/api/AvitoMessengerApi;", "messengerApi", "Lcom/avito/android/epress_cv/remote/ExpressCvApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/epress_cv/remote/ExpressCvApi;", "api", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/epress_cv/remote/ExpressCvApi;Lru/avito/messenger/api/AvitoMessengerApi;Lcom/avito/android/util/SchedulersFactory;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExpressCvRepositoryImpl implements ExpressCvRepository {
    public final String a;
    public final ExpressCvApi b;
    public final AvitoMessengerApi c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<TypedResult<CvResult>, LoadingState<? super CvResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CvResult> apply(TypedResult<CvResult> typedResult) {
            TypedResult<CvResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, CommonKt.EXTRA_RESPONSE);
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function<TypedResult<CvResult>, LoadingState<? super CvResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CvResult> apply(TypedResult<CvResult> typedResult) {
            TypedResult<CvResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, CommonKt.EXTRA_RESPONSE);
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c<T, R> implements Function<TypedResult<ExpressCvInfo>, LoadingState<? super ExpressCvInfo>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super ExpressCvInfo> apply(TypedResult<ExpressCvInfo> typedResult) {
            TypedResult<ExpressCvInfo> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, CommonKt.EXTRA_RESPONSE);
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T, R> implements Function<Channel, LoadingState<? super String>> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super String> apply(Channel channel) {
            Channel channel2 = channel;
            Intrinsics.checkNotNullParameter(channel2, "it");
            return new LoadingState.Loaded(channel2.getChannelId());
        }
    }

    public static final class e<T, R> implements Function<Throwable, LoadingState<? super String>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super String> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return new LoadingState.Error(new ErrorResult.UnknownStatusError("unknown"));
        }
    }

    public static final class f<T, R> implements Function<TypedResult<CreateExpressCvResult>, LoadingState<? super CreateExpressCvResult.Ok>> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super CreateExpressCvResult.Ok> apply(TypedResult<CreateExpressCvResult> typedResult) {
            TypedResult<CreateExpressCvResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, CommonKt.EXTRA_RESPONSE);
            if (typedResult2 instanceof TypedResult.OfResult) {
                CreateExpressCvResult createExpressCvResult = (CreateExpressCvResult) ((TypedResult.OfResult) typedResult2).getResult();
                if (createExpressCvResult instanceof CreateExpressCvResult.Ok) {
                    return new LoadingState.Loaded(createExpressCvResult);
                }
                if (createExpressCvResult instanceof CreateExpressCvResult.NeedPhoneVerification) {
                    return new LoadingState.Error(new NeedPhoneVerificationError(((CreateExpressCvResult.NeedPhoneVerification) createExpressCvResult).getDeepLink()));
                }
                throw new NoWhenBranchMatchedException();
            } else if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class g<T, R> implements Function<TypedResult<PretendResult>, ObservableSource<? extends PretendResult>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PretendResult> apply(TypedResult<PretendResult> typedResult) {
            TypedResult<PretendResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, CommonKt.EXTRA_RESPONSE);
            if (typedResult2 instanceof TypedResult.OfResult) {
                Observable just = Observable.just(((TypedResult.OfResult) typedResult2).getResult());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (typedResult2 instanceof TypedResult.OfError) {
                Observable error = Observable.error(new Throwable());
                Intrinsics.checkNotNullExpressionValue(error, "Observable.error<PretendResult>(Throwable())");
                return error;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public ExpressCvRepositoryImpl(@NotNull String str, @NotNull ExpressCvApi expressCvApi, @NotNull AvitoMessengerApi avitoMessengerApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, "context");
        Intrinsics.checkNotNullParameter(expressCvApi, "api");
        Intrinsics.checkNotNullParameter(avitoMessengerApi, "messengerApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = str;
        this.b = expressCvApi;
        this.c = avitoMessengerApi;
        this.d = schedulersFactory;
    }

    @Override // com.avito.android.express_cv.ExpressCvRepository
    @NotNull
    public Observable<LoadingState<CvResult>> activateCv(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Observable<LoadingState<CvResult>> startWith = InteropKt.toV2(this.b.activateCv(r.mapOf(TuplesKt.to("cvId", str), TuplesKt.to("context", this.a)))).subscribeOn(this.d.io()).map(a.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.activateCv(mapOf(CV_…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.express_cv.ExpressCvRepository
    @NotNull
    public Observable<LoadingState<CvResult>> disableExpressCv() {
        Observable<LoadingState<CvResult>> startWith = InteropKt.toV2(this.b.disableExpressCv(q.mapOf(TuplesKt.to("context", this.a)))).subscribeOn(this.d.io()).map(b.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.disableExpressCv(map…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.express_cv.ExpressCvRepository
    @NotNull
    public Observable<LoadingState<ExpressCvInfo>> getExpressCvInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "context");
        Observable<LoadingState<ExpressCvInfo>> startWith = InteropKt.toV2(this.b.getExpressCvInfo(str)).subscribeOn(this.d.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.getExpressCvInfo(con…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.express_cv.ExpressCvRepository
    @NotNull
    public Observable<LoadingState<String>> getMessengerChannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Observable<LoadingState<String>> startWith = AvitoMessengerApi.DefaultImpls.createChat$default(this.c, str, null, 2, null).map(d.a).toObservable().subscribeOn(this.d.io()).onErrorReturn(e.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "messengerApi.createChat(…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.express_cv.ExpressCvRepository
    @NotNull
    public Observable<LoadingState<CreateExpressCvResult.Ok>> publishExpressCv(@NotNull Map<String, String> map, @NotNull String str) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(str, "context");
        Observable<LoadingState<CreateExpressCvResult.Ok>> startWith = InteropKt.toV2(this.b.createCv(r.plus(r.toMutableMap(map), TuplesKt.to("context", str)))).subscribeOn(this.d.io()).map(f.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "api.createCv(params.toMu…ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.express_cv.ExpressCvRepository
    @NotNull
    public Observable<PretendResult> validateParams(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "params");
        return a2.b.a.a.a.S1(this.d, InteropKt.toV2(this.b.validateParams(r.plus(map, TuplesKt.to("context", this.a)))).flatMap(g.a), "api.validateParams(param…n(schedulersFactory.io())");
    }
}
