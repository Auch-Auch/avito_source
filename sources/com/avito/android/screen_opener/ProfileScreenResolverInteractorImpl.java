package com.avito.android.screen_opener;

import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.PublicProfileResult;
import com.avito.android.public_profile.remote.model.PublicUserProfile;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.Observables;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverInteractorImpl;", "Lcom/avito/android/screen_opener/ProfileScreenResolverInteractor;", "", "userKey", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "loadPublicUserProfile", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/public_profile/remote/PublicProfileApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/public_profile/remote/PublicProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/public_profile/remote/PublicProfileApi;Lcom/avito/android/util/SchedulersFactory3;)V", "UserBannedError", "UserRemovedError", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileScreenResolverInteractorImpl implements ProfileScreenResolverInteractor {
    public final PublicProfileApi a;
    public final SchedulersFactory3 b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverInteractorImpl$UserBannedError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserBannedError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public UserBannedError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverInteractorImpl$UserRemovedError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserRemovedError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public UserRemovedError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    public static final class a<T, R> implements Function<PublicProfileResult, ObservableSource<? extends PublicUserProfile>> {
        public final /* synthetic */ ProfileScreenResolverInteractorImpl a;

        public a(ProfileScreenResolverInteractorImpl profileScreenResolverInteractorImpl) {
            this.a = profileScreenResolverInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends PublicUserProfile> apply(PublicProfileResult publicProfileResult) {
            PublicProfileResult publicProfileResult2 = publicProfileResult;
            if (publicProfileResult2 instanceof PublicProfileResult.Ok) {
                Observable just = Observable.just(((PublicProfileResult.Ok) publicProfileResult2).getProfile());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (publicProfileResult2 instanceof PublicProfileResult.UserBanned) {
                return ProfileScreenResolverInteractorImpl.access$toErrorObservable(this.a, new UserBannedError(((PublicProfileResult.UserBanned) publicProfileResult2).getMessage()));
            } else {
                if (publicProfileResult2 instanceof PublicProfileResult.UserRemoved) {
                    return ProfileScreenResolverInteractorImpl.access$toErrorObservable(this.a, new UserRemovedError(((PublicProfileResult.UserRemoved) publicProfileResult2).getMessage()));
                }
                if (publicProfileResult2 instanceof PublicProfileResult.FailedWithMessage) {
                    return ProfileScreenResolverInteractorImpl.access$toErrorObservable(this.a, new ErrorWithMessage.SimpleMessageError(((PublicProfileResult.FailedWithMessage) publicProfileResult2).getMessage()));
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Inject
    public ProfileScreenResolverInteractorImpl(@NotNull PublicProfileApi publicProfileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(publicProfileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = publicProfileApi;
        this.b = schedulersFactory3;
    }

    public static final Observable access$toErrorObservable(ProfileScreenResolverInteractorImpl profileScreenResolverInteractorImpl, TypedError typedError) {
        Objects.requireNonNull(profileScreenResolverInteractorImpl);
        return Observables.toObservable(new TypedResultException(typedError));
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverInteractor
    @NotNull
    public Observable<PublicUserProfile> loadPublicUserProfile(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return a2.b.a.a.a.a2(this.b, TypedObservablesKt.toTyped(this.a.getPublicUserProfile(str, str2)).flatMap(new a(this)), "api.getPublicUserProfile…scribeOn(schedulers.io())");
    }
}
