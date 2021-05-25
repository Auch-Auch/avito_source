package com.avito.android.profile.password_change.business;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.LoginSuggest;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Session;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b(\u0010)J?\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/profile/password_change/business/PasswordChangeInteractorImpl;", "Lcom/avito/android/profile/password_change/business/PasswordChangeInteractor;", "", "oldPassword", "newPassword", "sessionHashId", "source", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/password/PasswordChangeResult;", "changePassword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getUserLogin", "()Lio/reactivex/Observable;", "", "isAuthorized", "()Z", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "Lcom/avito/android/account/SessionChangeTracker;", "c", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Lcom/avito/android/remote/ProfileApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/account/LoginSuggestStorage;", "e", "Lcom/avito/android/account/LoginSuggestStorage;", "loginSuggestStorage", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/account/SessionChangeTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/account/LoginSuggestStorage;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangeInteractorImpl implements PasswordChangeInteractor {
    public final AccountStorageInteractor a;
    public final ProfileApi b;
    public final SessionChangeTracker c;
    public final SchedulersFactory d;
    public final LoginSuggestStorage e;

    public static final class a<T, R> implements Function<TypedResult.OfError<PasswordChangeResult>, LoadingState<? super PasswordChangeResult>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PasswordChangeResult> apply(TypedResult.OfError<PasswordChangeResult> ofError) {
            TypedResult.OfError<PasswordChangeResult> ofError2 = ofError;
            Intrinsics.checkNotNullParameter(ofError2, "it");
            if (ofError2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) ofError2).getResult());
            }
            return new LoadingState.Error(ofError2.getError());
        }
    }

    public static final class b<V> implements Callable<TypedResult<PasswordChangeResult>> {
        public final /* synthetic */ PasswordChangeInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public b(PasswordChangeInteractorImpl passwordChangeInteractorImpl, String str, String str2, String str3, String str4) {
            this.a = passwordChangeInteractorImpl;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public TypedResult<PasswordChangeResult> call() {
            Session session = this.a.a.getSession();
            String pushToken = session != null ? session.getPushToken() : null;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            this.a.a.saveSessionBlocking(new a2.a.a.b2.f1.p.a(this, objectRef, pushToken));
            return objectRef.element;
        }
    }

    public static final class c<T, R> implements Function<TypedResult<PasswordChangeResult>, LoadingState<? super PasswordChangeResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super PasswordChangeResult> apply(TypedResult<PasswordChangeResult> typedResult) {
            TypedResult<PasswordChangeResult> typedResult2 = typedResult;
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

    public static final class d<V> implements Callable<List<? extends LoginSuggest>> {
        public final /* synthetic */ PasswordChangeInteractorImpl a;

        public d(PasswordChangeInteractorImpl passwordChangeInteractorImpl) {
            this.a = passwordChangeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends LoginSuggest> call() {
            return this.a.e.get(1);
        }
    }

    public static final class e<T, R> implements Function<List<? extends LoginSuggest>, String> {
        public final /* synthetic */ PasswordChangeInteractorImpl a;

        public e(PasswordChangeInteractorImpl passwordChangeInteractorImpl) {
            this.a = passwordChangeInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(List<? extends LoginSuggest> list) {
            String login;
            List<? extends LoginSuggest> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "it");
            LoginSuggest loginSuggest = (LoginSuggest) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            if (loginSuggest != null && (login = loginSuggest.getLogin()) != null) {
                return login;
            }
            String email = this.a.a.getProfileInfo().getEmail();
            return email != null ? email : "";
        }
    }

    @Inject
    public PasswordChangeInteractorImpl(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull ProfileApi profileApi, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull LoginSuggestStorage loginSuggestStorage) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(loginSuggestStorage, "loginSuggestStorage");
        this.a = accountStorageInteractor;
        this.b = profileApi;
        this.c = sessionChangeTracker;
        this.d = schedulersFactory;
        this.e = loginSuggestStorage;
    }

    public static final TypedResult access$changePasswordSync(PasswordChangeInteractorImpl passwordChangeInteractorImpl, String str, String str2, String str3, String str4, String str5) {
        TypedResult<PasswordChangeResult> blockingFirst = passwordChangeInteractorImpl.b.changePassword(str, str2, str3, str4, str5).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "api.changePassword(oldPa…, source).blockingFirst()");
        return blockingFirst;
    }

    @Override // com.avito.android.profile.password_change.business.PasswordChangeInteractor
    @NotNull
    public Observable<LoadingState<PasswordChangeResult>> changePassword(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "oldPassword");
        Intrinsics.checkNotNullParameter(str2, "newPassword");
        if (!this.a.isAuthorized()) {
            Observable<LoadingState<PasswordChangeResult>> map = Observable.just(new TypedResult.OfError(new ErrorResult.Unauthorized(""))).map(a.a);
            Intrinsics.checkNotNullExpressionValue(map, "Observable.just(TypedRes…p { it.toLoadingState() }");
            return map;
        }
        Observable<LoadingState<PasswordChangeResult>> startWith = Observable.fromCallable(new b(this, str, str2, str3, str4)).subscribeOn(this.d.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "Observable.fromCallable …ith(LoadingState.Loading)");
        return startWith;
    }

    @Override // com.avito.android.profile.password_change.business.PasswordChangeInteractor
    @Nullable
    public String getCurrentUserId() {
        return this.a.getCurrentUserId();
    }

    @Override // com.avito.android.profile.password_change.business.PasswordChangeInteractor
    @NotNull
    public Observable<String> getUserLogin() {
        Observable<String> map = Observable.fromCallable(new d(this)).subscribeOn(this.d.io()).map(new e(this));
        Intrinsics.checkNotNullExpressionValue(map, "Observable.fromCallable …eInfo().email.orEmpty() }");
        return map;
    }

    @Override // com.avito.android.profile.password_change.business.PasswordChangeInteractor
    public boolean isAuthorized() {
        return this.a.isAuthorized();
    }
}
