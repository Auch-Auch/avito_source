package com.avito.android.account;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/account/AccountStateProvider;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "authorized", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "currentAuthorized", "()Lio/reactivex/rxjava3/core/Single;", "", ChannelContext.Item.USER_ID, "Lio/reactivex/rxjava3/core/Maybe;", "currentUserId", "()Lio/reactivex/rxjava3/core/Maybe;", "isAuthorized", "()Z", "getCurrentUserId", "()Ljava/lang/String;", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public interface AccountStateProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T> implements Predicate<String> {
            public static final a a = new a();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Predicate
            public boolean test(String str) {
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                return str2.length() > 0;
            }
        }

        @NotNull
        public static Single<Boolean> currentAuthorized(@NotNull AccountStateProvider accountStateProvider) {
            Single<Boolean> firstOrError = accountStateProvider.authorized().firstOrError();
            Intrinsics.checkNotNullExpressionValue(firstOrError, "authorized().firstOrError()");
            return firstOrError;
        }

        @NotNull
        public static Maybe<String> currentUserId(@NotNull AccountStateProvider accountStateProvider) {
            Maybe<String> filter = accountStateProvider.userId().firstElement().filter(a.a);
            Intrinsics.checkNotNullExpressionValue(filter, "userId().firstElement().filter { it.isNotEmpty() }");
            return filter;
        }
    }

    @NotNull
    Observable<Boolean> authorized();

    @NotNull
    Single<Boolean> currentAuthorized();

    @NotNull
    Maybe<String> currentUserId();

    @Nullable
    String getCurrentUserId();

    boolean isAuthorized();

    @NotNull
    Observable<String> userId();
}
