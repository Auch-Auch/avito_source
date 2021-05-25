package com.avito.android.profile.password_setting;

import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Session;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.password.PasswordChangeResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preference;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingInteractorImpl;", "Lcom/avito/android/profile/password_setting/PasswordSettingInteractor;", "", Preference.PASSWORD, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/password/PasswordChangeResult;", "setPassword", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/account/AccountStorageInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/remote/ProfileApi;", "c", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/account/SessionChangeTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "<init>", "(Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/account/SessionChangeTracker;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordSettingInteractorImpl implements PasswordSettingInteractor {
    public final AccountStorageInteractor a;
    public final SessionChangeTracker b;
    public final ProfileApi c;
    public final SchedulersFactory d;

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
        public final /* synthetic */ PasswordSettingInteractorImpl a;
        public final /* synthetic */ String b;

        public b(PasswordSettingInteractorImpl passwordSettingInteractorImpl, String str) {
            this.a = passwordSettingInteractorImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public TypedResult<PasswordChangeResult> call() {
            Session session = this.a.a.getSession();
            String pushToken = session != null ? session.getPushToken() : null;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            this.a.a.saveSessionBlocking(new a2.a.a.b2.g1.a(this, objectRef, pushToken));
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

    @Inject
    public PasswordSettingInteractorImpl(@NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = accountStorageInteractor;
        this.b = sessionChangeTracker;
        this.c = profileApi;
        this.d = schedulersFactory;
    }

    public static final TypedResult access$setPasswordSync(PasswordSettingInteractorImpl passwordSettingInteractorImpl, String str, String str2) {
        TypedResult<PasswordChangeResult> blockingFirst = passwordSettingInteractorImpl.c.setPassword(str, str2).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "api.setPassword(password, token).blockingFirst()");
        return blockingFirst;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingInteractor
    @NotNull
    public Observable<LoadingState<PasswordChangeResult>> setPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Preference.PASSWORD);
        if (!this.a.isAuthorized()) {
            Observable<LoadingState<PasswordChangeResult>> map = Observable.just(new TypedResult.OfError(new ErrorResult.Unauthorized(""))).map(a.a);
            Intrinsics.checkNotNullExpressionValue(map, "Observable.just(TypedRes…p { it.toLoadingState() }");
            return map;
        }
        Observable<LoadingState<PasswordChangeResult>> startWith = Observable.fromCallable(new b(this, str)).subscribeOn(this.d.io()).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "Observable.fromCallable …ith(LoadingState.Loading)");
        return startWith;
    }
}
