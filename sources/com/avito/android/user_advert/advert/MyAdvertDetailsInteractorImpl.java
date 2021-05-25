package com.avito.android.user_advert.advert;

import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.CloseReasonsResponse;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.adverts.RestoreAdvertResult;
import com.avito.android.remote.model.profile.ItemActivateResponse;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u00101\u001a\u00020.\u0012\b\u00106\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b7\u00108J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\bJ+\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\bJ+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\f2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\bJ#\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\bJ#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractorImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/profile/ItemActivateResponse;", "activateAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SuccessResult;", "activateAdvertLegacy", "newPrice", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/SimpleMessageResult;", "setAdvertPrice", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "loadAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/CloseReasonsResponse;", "getCloseReasons", "reason", "stopAdvert", "deleteAdvert", "Lcom/avito/android/remote/model/adverts/RestoreAdvertResult;", "restoreAdvert", "", "notifyVasBundlesBannerClosed", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "Lcom/avito/android/util/SchedulersFactory3;", "d", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", "c", "Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", "api", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/CloseReasonsResponse;", "closeReasons", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "e", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/user_advert/advert/PaymentSpecialErrorCase;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_advert/advert/PaymentSpecialErrorCase;", "specialCase", "state", "<init>", "(Lcom/avito/android/user_advert_api/remote/UserAdvertApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/Features;Landroid/os/Bundle;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsInteractorImpl implements MyAdvertDetailsInteractor {
    public final PaymentSpecialErrorCase a = new PaymentSpecialErrorCase();
    public CloseReasonsResponse b;
    public final UserAdvertApi c;
    public final SchedulersFactory3 d;
    public final TypedErrorThrowableConverter e;
    public final Features f;

    public static final class a<T, R> implements Function<ItemActivateResponse, LoadingState<? super ItemActivateResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ItemActivateResponse> apply(ItemActivateResponse itemActivateResponse) {
            return new LoadingState.Loaded(itemActivateResponse);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super ItemActivateResponse>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public b(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ItemActivateResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convertWithSpecialErrorCase(th2, this.a.a));
        }
    }

    public static final class c<T, R> implements Function<SuccessResult, LoadingState<? super SuccessResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(SuccessResult successResult) {
            return new LoadingState.Loaded(successResult);
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super SuccessResult>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public d(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convertWithSpecialErrorCase(th2, this.a.a));
        }
    }

    public static final class e<T, R> implements Function<SuccessResult, LoadingState<? super SuccessResult>> {
        public static final e a = new e();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(SuccessResult successResult) {
            return new LoadingState.Loaded(successResult);
        }
    }

    public static final class f<T, R> implements Function<Throwable, LoadingState<? super SuccessResult>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public f(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class g<T, R> implements Function<Throwable, LoadingState<? super CloseReasonsResponse>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public g(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super CloseReasonsResponse> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class h<T, R> implements Function<TypedResult<Unit>, LoadingState<? super Unit>> {
        public static final h a = new h();

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

    public static final class i<T, R> implements Function<Throwable, LoadingState<? super Unit>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public i(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Unit> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class j<T, R> implements Function<TypedResult<RestoreAdvertResult>, LoadingState<? super RestoreAdvertResult>> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super RestoreAdvertResult> apply(TypedResult<RestoreAdvertResult> typedResult) {
            TypedResult<RestoreAdvertResult> typedResult2 = typedResult;
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

    public static final class k<T, R> implements Function<Throwable, LoadingState<? super RestoreAdvertResult>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public k(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super RestoreAdvertResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class l<T, R> implements Function<TypedResult<SimpleMessageResult>, LoadingState<? super SimpleMessageResult>> {
        public static final l a = new l();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SimpleMessageResult> apply(TypedResult<SimpleMessageResult> typedResult) {
            TypedResult<SimpleMessageResult> typedResult2 = typedResult;
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

    public static final class m<T, R> implements Function<Throwable, LoadingState<? super SimpleMessageResult>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public m(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SimpleMessageResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class n<T, R> implements Function<SuccessResult, LoadingState<? super SuccessResult>> {
        public static final n a = new n();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(SuccessResult successResult) {
            return new LoadingState.Loaded(successResult);
        }
    }

    public static final class o<T, R> implements Function<Throwable, LoadingState<? super SuccessResult>> {
        public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

        public o(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
            this.a = myAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SuccessResult> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.e;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public MyAdvertDetailsInteractorImpl(@NotNull UserAdvertApi userAdvertApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull Features features, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(userAdvertApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = userAdvertApi;
        this.d = schedulersFactory3;
        this.e = typedErrorThrowableConverter;
        this.f = features;
        this.b = bundle != null ? (CloseReasonsResponse) bundle.getParcelable("key_close_reasons") : null;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Observable<LoadingState<ItemActivateResponse>> activateAdvert(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.a2(this.d, this.c.activateAdvert(str).map(a.a).onErrorReturn(new b(this)).toObservable(), "api\n            .activat…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Observable<LoadingState<SuccessResult>> activateAdvertLegacy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.a2(this.d, this.c.activateAdvertLegacy(str).map(c.a).onErrorReturn(new d(this)).toObservable(), "api\n            .activat…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Observable<LoadingState<SuccessResult>> deleteAdvert(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.a2(this.d, this.c.deleteAdvert(str).map(e.a).onErrorReturn(new f(this)), "api\n            .deleteA…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Observable<LoadingState<CloseReasonsResponse>> getCloseReasons(@NotNull String str) {
        Observable observable;
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        CloseReasonsResponse closeReasonsResponse = this.b;
        if (closeReasonsResponse != null) {
            observable = Observable.just(new LoadingState.Loaded(closeReasonsResponse));
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(Loaded(closeReasons))");
        } else {
            observable = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.empty()");
        }
        Observable subscribeOn = observable.subscribeOn(this.d.mainThread());
        Observable<R> map = this.c.getCloseReasons(str).observeOn(this.d.mainThread()).map(new a2.a.a.h3.a.a(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.getCloseReasons(adve…nsResponse>\n            }");
        Observable<LoadingState<CloseReasonsResponse>> onErrorReturn = subscribeOn.switchIfEmpty(map.subscribeOn(this.d.io())).onErrorReturn(new g(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "buildCloseReasonsSource(…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Single<MyAdvertDetails> loadAdvert(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        if (this.f.getMnzVasUnion().invoke().booleanValue()) {
            return a2.b.a.a.a.e2(this.d, UserAdvertApi.DefaultImpls.getMyAdvertDetailsV16$default(this.c, str, false, null, 6, null), "api.getMyAdvertDetailsV1…scribeOn(schedulers.io())");
        }
        return a2.b.a.a.a.e2(this.d, UserAdvertApi.DefaultImpls.getMyAdvertDetailsV15$default(this.c, str, false, null, 6, null), "api.getMyAdvertDetailsV1…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Observable<LoadingState<Unit>> notifyVasBundlesBannerClosed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.a2(this.d, this.c.notifyBannerClosed(str).map(h.a).onErrorReturn(new i(this)), "api.notifyBannerClosed(a…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Observable<LoadingState<RestoreAdvertResult>> restoreAdvert(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.a2(this.d, this.c.restoreAdvert(str).map(j.a).onErrorReturn(new k(this)), "api\n        .restoreAdve…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @Nullable
    public Bundle saveState() {
        CloseReasonsResponse closeReasonsResponse = this.b;
        if (closeReasonsResponse == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_close_reasons", closeReasonsResponse);
        return bundle;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Single<LoadingState<SimpleMessageResult>> setAdvertPrice(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "newPrice");
        return a2.b.a.a.a.e2(this.d, this.c.setAdvertPrice(str, str2).map(l.a).onErrorReturn(new m(this)), "api.setAdvertPrice(adver…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsInteractor
    @NotNull
    public Single<LoadingState<SuccessResult>> stopAdvert(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        return a2.b.a.a.a.e2(this.d, this.c.deactivateAdvert(str2, str).map(n.a).onErrorReturn(new o(this)), "api.deactivateAdvert(adv…scribeOn(schedulers.io())");
    }
}
