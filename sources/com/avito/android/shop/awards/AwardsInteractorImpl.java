package com.avito.android.shop.awards;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/shop/awards/AwardsInteractorImpl;", "Lcom/avito/android/shop/awards/AwardsInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "getShopAwards", "()Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "awards", "<init>", "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class AwardsInteractorImpl implements AwardsInteractor {
    public final SellerVerification.AwardsItem a;

    public AwardsInteractorImpl(@NotNull SellerVerification.AwardsItem awardsItem) {
        Intrinsics.checkNotNullParameter(awardsItem, "awards");
        this.a = awardsItem;
    }

    @Override // com.avito.android.shop.awards.AwardsInteractor
    @NotNull
    public Observable<LoadingState<SellerVerification.AwardsItem>> getShopAwards() {
        Observable<LoadingState<SellerVerification.AwardsItem>> just = Observable.just(new LoadingState.Loaded(this.a));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(LoadingState.Loaded(awards))");
        return just;
    }
}
