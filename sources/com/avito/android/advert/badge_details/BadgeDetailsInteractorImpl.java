package com.avito.android.advert.badge_details;

import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.advert_badge_bar.BadgeDetailsResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J3\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/badge_details/BadgeDetailsInteractorImpl;", "Lcom/avito/android/advert/badge_details/BadgeDetailsInteractor;", "", "objectId", "objectEntity", "", "badgeId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse;", "getBadgeDetails", "(Ljava/lang/String;Ljava/lang/String;I)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "advertDetailsApi", "<init>", "(Lcom/avito/android/advert_details/remote/AdvertDetailsApi;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeDetailsInteractorImpl implements BadgeDetailsInteractor {
    public final AdvertDetailsApi a;

    public static final class a<T, R> implements Function<TypedResult<BadgeDetailsResponse>, LoadingState<? super BadgeDetailsResponse>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super BadgeDetailsResponse> apply(TypedResult<BadgeDetailsResponse> typedResult) {
            TypedResult<BadgeDetailsResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
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
    public BadgeDetailsInteractorImpl(@NotNull AdvertDetailsApi advertDetailsApi) {
        Intrinsics.checkNotNullParameter(advertDetailsApi, "advertDetailsApi");
        this.a = advertDetailsApi;
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsInteractor
    @NotNull
    public Observable<LoadingState<BadgeDetailsResponse>> getBadgeDetails(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "objectId");
        Intrinsics.checkNotNullParameter(str2, "objectEntity");
        Observable<R> map = this.a.getBadgeDetails(str, str2, i).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "advertDetailsApi.getBadg…p { it.toLoadingState() }");
        return map;
    }
}
