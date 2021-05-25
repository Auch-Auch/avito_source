package com.avito.android.user_subscribers;

import android.net.Uri;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.subscriber.UserSubscribersResult;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/user_subscribers/UserSubscribersInteractorImpl;", "Lcom/avito/android/user_subscribers/UserSubscribersInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/user_subscribers/SubscriberList;", "getSubscriberList", "()Lio/reactivex/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/FavoriteSellersApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/FavoriteSellersApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/user_subscribers/UserSubscribersConverter;", "c", "Lcom/avito/android/user_subscribers/UserSubscribersConverter;", "converter", "<init>", "(Lcom/avito/android/remote/FavoriteSellersApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/user_subscribers/UserSubscribersConverter;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class UserSubscribersInteractorImpl implements UserSubscribersInteractor {
    public final FavoriteSellersApi a;
    public final SchedulersFactory b;
    public final UserSubscribersConverter c;

    public static final class a<T, R> implements Function<TypedResult<UserSubscribersResult>, ObservableSource<? extends UserSubscribersResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends UserSubscribersResult> apply(TypedResult<UserSubscribersResult> typedResult) {
            TypedResult<UserSubscribersResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable(typedResult2);
        }
    }

    public static final class b<T, R> implements Function<UserSubscribersResult, SubscriberList> {
        public final /* synthetic */ UserSubscribersInteractorImpl a;

        public b(UserSubscribersInteractorImpl userSubscribersInteractorImpl) {
            this.a = userSubscribersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SubscriberList apply(UserSubscribersResult userSubscribersResult) {
            UserSubscribersResult userSubscribersResult2 = userSubscribersResult;
            Intrinsics.checkNotNullParameter(userSubscribersResult2, "it");
            return this.a.c.convert(userSubscribersResult2);
        }
    }

    public static final class c<T, R> implements Function<TypedResult<UserSubscribersResult>, ObservableSource<? extends UserSubscribersResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends UserSubscribersResult> apply(TypedResult<UserSubscribersResult> typedResult) {
            TypedResult<UserSubscribersResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable(typedResult2);
        }
    }

    public static final class d<T, R> implements Function<UserSubscribersResult, SubscriberList> {
        public final /* synthetic */ UserSubscribersInteractorImpl a;

        public d(UserSubscribersInteractorImpl userSubscribersInteractorImpl) {
            this.a = userSubscribersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SubscriberList apply(UserSubscribersResult userSubscribersResult) {
            UserSubscribersResult userSubscribersResult2 = userSubscribersResult;
            Intrinsics.checkNotNullParameter(userSubscribersResult2, "it");
            return this.a.c.convert(userSubscribersResult2);
        }
    }

    @Inject
    public UserSubscribersInteractorImpl(@NotNull FavoriteSellersApi favoriteSellersApi, @NotNull SchedulersFactory schedulersFactory, @NotNull UserSubscribersConverter userSubscribersConverter) {
        Intrinsics.checkNotNullParameter(favoriteSellersApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(userSubscribersConverter, "converter");
        this.a = favoriteSellersApi;
        this.b = schedulersFactory;
        this.c = userSubscribersConverter;
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersInteractor
    @NotNull
    public Observable<SubscriberList> getSubscriberList() {
        Observable<SubscriberList> map = InteropKt.toV2(this.a.getUserSubscribers()).subscribeOn(this.b.io()).flatMap(a.a).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.getUserSubscribers()…{ converter.convert(it) }");
        return map;
    }

    @Override // com.avito.android.user_subscribers.UserSubscribersInteractor
    @NotNull
    public Observable<SubscriberList> getSubscriberList(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        FavoriteSellersApi favoriteSellersApi = this.a;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.toString()");
        Observable<SubscriberList> map = InteropKt.toV2(favoriteSellersApi.getUserSubscribers(uri2)).subscribeOn(this.b.io()).flatMap(c.a).map(new d(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.getUserSubscribers(n…{ converter.convert(it) }");
        return map;
    }
}
