package com.avito.android.rating.user_contacts;

import android.net.Uri;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.rating.user_contacts.di.UserContactsContext;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.user_contacts.UserContactsResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsInteractorImpl;", "Lcom/avito/android/rating/user_contacts/UserContactsInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/user_contacts/UserContactsResult;", "getContactList", "()Lio/reactivex/rxjava3/core/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Observable;", "", "userKey", "itemId", "", "removeContact", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "context", "Lcom/avito/android/rating/remote/RatingApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/remote/RatingApi;", "api", "<init>", "(Lcom/avito/android/rating/remote/RatingApi;Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory3;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactsInteractorImpl implements UserContactsInteractor {
    public final RatingApi a;
    public final String b;
    public final SchedulersFactory3 c;

    public static final class a<T, R> implements Function<TypedResult<UserContactsResult>, ObservableSource<? extends UserContactsResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends UserContactsResult> apply(TypedResult<UserContactsResult> typedResult) {
            TypedResult<UserContactsResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    public static final class b<T, R> implements Function<TypedResult<UserContactsResult>, ObservableSource<? extends UserContactsResult>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends UserContactsResult> apply(TypedResult<UserContactsResult> typedResult) {
            TypedResult<UserContactsResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    public static final class c<T, R> implements Function<TypedResult<Unit>, ObservableSource<? extends Unit>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Unit> apply(TypedResult<Unit> typedResult) {
            TypedResult<Unit> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return TypedObservablesKt.toTypedObservable3(typedResult2);
        }
    }

    @Inject
    public UserContactsInteractorImpl(@NotNull RatingApi ratingApi, @UserContactsContext @Nullable String str, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(ratingApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = ratingApi;
        this.b = str;
        this.c = schedulersFactory3;
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsInteractor
    @NotNull
    public Observable<UserContactsResult> getContactList() {
        Observable<R> flatMap = this.a.getContactList(this.b).subscribeOn(this.c.io()).flatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.getContactList(conte…it.toTypedObservable3() }");
        return flatMap;
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsInteractor
    @NotNull
    public Observable<Unit> removeContact(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str2, "itemId");
        Observable<R> flatMap = this.a.removeContact(str, str2).subscribeOn(this.c.io()).flatMap(c.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.removeContact(userKe…it.toTypedObservable3() }");
        return flatMap;
    }

    @Override // com.avito.android.rating.user_contacts.UserContactsInteractor
    @NotNull
    public Observable<UserContactsResult> getContactList(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "nextPage");
        RatingApi ratingApi = this.a;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "nextPage.toString()");
        Observable<R> flatMap = ratingApi.getContactListNextPage(uri2).subscribeOn(this.c.io()).flatMap(b.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "api.getContactListNextPa…it.toTypedObservable3() }");
        return flatMap;
    }
}
