package com.avito.android.authorization.login_suggests;

import com.avito.android.account.LoginSuggest;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RequestUtils;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractorImpl;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsInteractor;", "Lio/reactivex/Single;", "", "Lcom/avito/android/authorization/login_suggests/Suggest;", "getSuggests", "()Lio/reactivex/Single;", "Lcom/avito/android/remote/ProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/account/LoginSuggestStorage;", "c", "Lcom/avito/android/account/LoginSuggestStorage;", "loginSuggestStorage", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/account/LoginSuggestStorage;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginSuggestsInteractorImpl implements LoginSuggestsInteractor {
    public final ProfileApi a;
    public final SchedulersFactory b;
    public final LoginSuggestStorage c;

    public static final class a<V> implements Callable<List<? extends LoginSuggest>> {
        public final /* synthetic */ LoginSuggestsInteractorImpl a;

        public a(LoginSuggestsInteractorImpl loginSuggestsInteractorImpl) {
            this.a = loginSuggestsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends LoginSuggest> call() {
            return this.a.c.get();
        }
    }

    public static final class b<T, R> implements Function<List<? extends LoginSuggest>, ObservableSource<? extends List<? extends Suggest>>> {
        public final /* synthetic */ LoginSuggestsInteractorImpl a;

        public b(LoginSuggestsInteractorImpl loginSuggestsInteractorImpl) {
            this.a = loginSuggestsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends Suggest>> apply(List<? extends LoginSuggest> list) {
            List<? extends LoginSuggest> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            return LoginSuggestsInteractorImpl.access$getAuthSuggests(this.a, list2);
        }
    }

    @Inject
    public LoginSuggestsInteractorImpl(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull LoginSuggestStorage loginSuggestStorage) {
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(loginSuggestStorage, "loginSuggestStorage");
        this.a = profileApi;
        this.b = schedulersFactory;
        this.c = loginSuggestStorage;
    }

    public static final Observable access$getAuthSuggests(LoginSuggestsInteractorImpl loginSuggestsInteractorImpl, List list) {
        Objects.requireNonNull(loginSuggestsInteractorImpl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LoginSuggest loginSuggest = (LoginSuggest) it.next();
            linkedHashMap.put(loginSuggest.getUserHashId(), loginSuggest);
        }
        Observable onErrorReturn = TypedObservablesKt.toTyped(InteropKt.toV2(loginSuggestsInteractorImpl.a.getAuthSuggests(RequestUtils.INSTANCE.toArrayQueryParams(linkedHashMap.keySet(), "hashUserIds")))).map(new a2.a.a.b.f.a(linkedHashMap)).onErrorReturn(a2.a.a.b.f.b.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "profileApi.getAuthSugges…rorReturn { emptyList() }");
        return onErrorReturn;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsInteractor
    @NotNull
    public Single<List<Suggest>> getSuggests() {
        Single<List<Suggest>> firstOrError = Observable.fromCallable(new a(this)).subscribeOn(this.b.io()).flatMap(new b(this)).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "Observable.fromCallable …          .firstOrError()");
        return firstOrError;
    }
}
