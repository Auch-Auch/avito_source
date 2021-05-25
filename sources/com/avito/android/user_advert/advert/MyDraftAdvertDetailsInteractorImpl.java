package com.avito.android.user_advert.advert;

import com.avito.android.di.module.publish.PublishDraftUpdateObservable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u000e\b\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractorImpl;", "Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractor;", "", "draftId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "loadDraftAdvert", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/LoadingState;", "", "deleteDraft", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "d", "Lcom/jakewharton/rxrelay3/PublishRelay;", "draftUpdateObservable", "Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_advert_api/remote/UserAdvertApi;", "api", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "c", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/user_advert_api/remote/UserAdvertApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyDraftAdvertDetailsInteractorImpl implements MyDraftAdvertDetailsInteractor {
    public final UserAdvertApi a;
    public final SchedulersFactory3 b;
    public final TypedErrorThrowableConverter c;
    public final PublishRelay<String> d;

    public static final class a<T, R> implements Function<Object, LoadingState<? super Object>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Object> apply(Object obj) {
            return new LoadingState.Loaded(obj);
        }
    }

    public static final class b<T, R> implements Function<Throwable, LoadingState<? super Object>> {
        public final /* synthetic */ MyDraftAdvertDetailsInteractorImpl a;

        public b(MyDraftAdvertDetailsInteractorImpl myDraftAdvertDetailsInteractorImpl) {
            this.a = myDraftAdvertDetailsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super Object> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class c<T> implements Predicate<String> {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(String str) {
            return Intrinsics.areEqual(str, this.a);
        }
    }

    public static final class d<T, R> implements Function<String, SingleSource<? extends MyAdvertDetails>> {
        public final /* synthetic */ MyDraftAdvertDetailsInteractorImpl a;
        public final /* synthetic */ String b;

        public d(MyDraftAdvertDetailsInteractorImpl myDraftAdvertDetailsInteractorImpl, String str) {
            this.a = myDraftAdvertDetailsInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends MyAdvertDetails> apply(String str) {
            Single<TypedResult<MyAdvertDetails>> subscribeOn = this.a.a.getMyDraftAdvertDetails(this.b).subscribeOn(this.a.b.io());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getMyDraftAdvertDeta…scribeOn(schedulers.io())");
            Single<R> flatMap = subscribeOn.flatMap(MyDraftAdvertDetailsInteractorImpl$loadDraftAdvert$2$$special$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
            return flatMap;
        }
    }

    @Inject
    public MyDraftAdvertDetailsInteractorImpl(@NotNull UserAdvertApi userAdvertApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @PublishDraftUpdateObservable @NotNull PublishRelay<String> publishRelay) {
        Intrinsics.checkNotNullParameter(userAdvertApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(publishRelay, "draftUpdateObservable");
        this.a = userAdvertApi;
        this.b = schedulersFactory3;
        this.c = typedErrorThrowableConverter;
        this.d = publishRelay;
    }

    @Override // com.avito.android.user_advert.advert.MyDraftAdvertDetailsInteractor
    @NotNull
    public Single<LoadingState<Object>> deleteDraft(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Single flatMap = a2.b.a.a.a.e2(this.b, this.a.deleteDraft(str), "api.deleteDraft(draftId)…scribeOn(schedulers.io())").flatMap(MyDraftAdvertDetailsInteractorImpl$deleteDraft$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Single<LoadingState<Object>> onErrorReturn = flatMap.map(a.a).onErrorReturn(new b(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.deleteDraft(draftId)…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.user_advert.advert.MyDraftAdvertDetailsInteractor
    @NotNull
    public Observable<MyAdvertDetails> loadDraftAdvert(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Observable<R> flatMapSingle = this.d.filter(new c(str)).startWith(Observable.just(str)).flatMapSingle(new d(this, str));
        Intrinsics.checkNotNullExpressionValue(flatMapSingle, "draftUpdateObservable.fi… .toTyped()\n            }");
        return flatMapSingle;
    }
}
