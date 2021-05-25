package com.avito.android.user_adverts_common.charity;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CharityDialogResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.avito.android.user_adverts_common.charity.events.CharityButtonClickEventKt;
import com.avito.android.user_adverts_common.charity.events.CharityDialogShowEvent;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_adverts_common/charity/CharityInteractorImpl;", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;", "source", "Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Dialog;", "requestDialog", "(Ljava/lang/String;Lcom/avito/android/user_adverts_common/charity/CharityInteractor$Source;)Lio/reactivex/rxjava3/core/Maybe;", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "c", "Lcom/avito/android/analytics/provider/CurrentUserIdProvider;", "currentUserIdProvider", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/remote/UserAdvertsCommonApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/UserAdvertsCommonApi;", "api", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/UserAdvertsCommonApi;Lcom/avito/android/analytics/provider/CurrentUserIdProvider;Lcom/avito/android/analytics/Analytics;)V", "user-adverts-common_release"}, k = 1, mv = {1, 4, 2})
public final class CharityInteractorImpl implements CharityInteractor {
    public final SchedulersFactory3 a;
    public final UserAdvertsCommonApi b;
    public final CurrentUserIdProvider c;
    public final Analytics d;

    public static final class a<T, R> implements Function<TypedResult<CharityDialogResponse>, MaybeSource<? extends CharityInteractor.Dialog>> {
        public final /* synthetic */ CharityInteractorImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CharityInteractor.Source c;

        public a(CharityInteractorImpl charityInteractorImpl, String str, CharityInteractor.Source source) {
            this.a = charityInteractorImpl;
            this.b = str;
            this.c = source;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MaybeSource<? extends CharityInteractor.Dialog> apply(TypedResult<CharityDialogResponse> typedResult) {
            TypedResult<CharityDialogResponse> typedResult2 = typedResult;
            String currentUserId = this.a.c.getCurrentUserId();
            if (typedResult2 instanceof TypedResult.OfResult) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                if (ofResult.getResult() instanceof CharityDialogResponse.Ok) {
                    if (currentUserId != null) {
                        this.a.d.track(new CharityDialogShowEvent(currentUserId, this.b, this.c));
                    }
                    Object result = ofResult.getResult();
                    Objects.requireNonNull(result, "null cannot be cast to non-null type com.avito.android.remote.model.CharityDialogResponse.Ok");
                    return Maybe.just(new CharityInteractor.Dialog(((CharityDialogResponse.Ok) result).getBody(), currentUserId != null ? CharityButtonClickEventKt.getCharityButtonClickEvent(currentUserId, this.b, this.c) : null));
                }
            }
            return Maybe.empty();
        }
    }

    @Inject
    public CharityInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull UserAdvertsCommonApi userAdvertsCommonApi, @NotNull CurrentUserIdProvider currentUserIdProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(userAdvertsCommonApi, "api");
        Intrinsics.checkNotNullParameter(currentUserIdProvider, "currentUserIdProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = schedulersFactory3;
        this.b = userAdvertsCommonApi;
        this.c = currentUserIdProvider;
        this.d = analytics;
    }

    @Override // com.avito.android.user_adverts_common.charity.CharityInteractor
    @NotNull
    public Maybe<CharityInteractor.Dialog> requestDialog(@NotNull String str, @NotNull CharityInteractor.Source source) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(source, "source");
        Maybe<R> subscribeOn = this.b.getCharityDialog(str, source.getTag()).flatMapMaybe(new a(this, str, source)).onErrorComplete().subscribeOn(this.a.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "api.getCharityDialog(adv…scribeOn(schedulers.io())");
        return subscribeOn;
    }
}
