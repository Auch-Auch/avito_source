package com.avito.android.user_adverts_common.safety;

import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.server_time.TimeSource;
import com.avito.android.user_adverts_common.safety.storage.SafetyInfoSessionStorage;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/user_adverts_common/safety/SafetyInfoProviderImpl;", "Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;", "", "categoryId", ChannelContext.Item.USER_ID, "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "loadSafetyInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/user_adverts_common/safety/storage/SafetyInfoSessionStorage;", "c", "Lcom/avito/android/user_adverts_common/safety/storage/SafetyInfoSessionStorage;", "sessionStorage", "Lcom/avito/android/remote/UserAdvertsCommonApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/UserAdvertsCommonApi;", "api", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/UserAdvertsCommonApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/user_adverts_common/safety/storage/SafetyInfoSessionStorage;Lcom/avito/android/server_time/TimeSource;)V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public final class SafetyInfoProviderImpl implements SafetyInfoProvider {
    public final UserAdvertsCommonApi a;
    public final SchedulersFactory3 b;
    public final SafetyInfoSessionStorage c;
    public final TimeSource d;

    public static final class a<T> implements Supplier<MaybeSource<? extends Boolean>> {
        public final /* synthetic */ SafetyInfoProviderImpl a;
        public final /* synthetic */ String b;

        public a(SafetyInfoProviderImpl safetyInfoProviderImpl, String str) {
            this.a = safetyInfoProviderImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public MaybeSource<? extends Boolean> get() {
            return Maybe.just(Boolean.valueOf(this.a.c.getLastSessionForUser(this.b).getLastShowTimestamp() == 0));
        }
    }

    public static final class b<T, R> implements Function<Boolean, MaybeSource<? extends DetailsSheetLinkBody>> {
        public final /* synthetic */ SafetyInfoProviderImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(SafetyInfoProviderImpl safetyInfoProviderImpl, String str, String str2) {
            this.a = safetyInfoProviderImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends DetailsSheetLinkBody> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "shouldShowInfo");
            if (!bool2.booleanValue()) {
                return Maybe.empty();
            }
            Single<R> flatMap = this.a.a.getAfterPublishWarning(this.b).flatMap(SafetyInfoProviderImpl$loadSafetyInfo$2$$special$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
            return flatMap.flatMapMaybe(new a2.a.a.j3.a.a(this)).doOnSuccess(new a2.a.a.j3.a.b(this));
        }
    }

    @Inject
    public SafetyInfoProviderImpl(@NotNull UserAdvertsCommonApi userAdvertsCommonApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SafetyInfoSessionStorage safetyInfoSessionStorage, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(userAdvertsCommonApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(safetyInfoSessionStorage, "sessionStorage");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.a = userAdvertsCommonApi;
        this.b = schedulersFactory3;
        this.c = safetyInfoSessionStorage;
        this.d = timeSource;
    }

    public static final boolean access$isEmpty(SafetyInfoProviderImpl safetyInfoProviderImpl, DetailsSheetLinkBody detailsSheetLinkBody) {
        Objects.requireNonNull(safetyInfoProviderImpl);
        String title = detailsSheetLinkBody.getTitle();
        return (title == null || title.length() == 0) && detailsSheetLinkBody.getAttributedText() == null;
    }

    @Override // com.avito.android.user_adverts_common.safety.SafetyInfoProvider
    @NotNull
    public Maybe<DetailsSheetLinkBody> loadSafetyInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Intrinsics.checkNotNullParameter(str2, ChannelContext.Item.USER_ID);
        Maybe<DetailsSheetLinkBody> onErrorComplete = Maybe.defer(new a(this, str2)).flatMap(new b(this, str, str2)).subscribeOn(this.b.io()).onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "Maybe\n            .defer…       .onErrorComplete()");
        return onErrorComplete;
    }
}
