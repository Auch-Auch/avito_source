package com.avito.android.shop.detailed.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.ProfileRatingAction;
import com.avito.android.shop.detailed.ShopHeaderListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenterImpl;", "Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;", "Lcom/avito/android/remote/model/ProfileRating;", "rating", "Lcom/avito/android/shop/detailed/item/RatingView;", "view", "", "bindRatingToView", "(Lcom/avito/android/remote/model/ProfileRating;Lcom/avito/android/shop/detailed/item/RatingView;)V", "Ldagger/Lazy;", "Lcom/avito/android/shop/detailed/ShopHeaderListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopItemRatingPresenterImpl implements ShopItemRatingPresenter {
    public final Lazy<? extends ShopHeaderListener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ProfileRatingAction a;
        public final /* synthetic */ ShopHeaderListener b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProfileRatingAction profileRatingAction, ShopItemRatingPresenterImpl shopItemRatingPresenterImpl, ProfileRating profileRating, ShopHeaderListener shopHeaderListener) {
            super(0);
            this.a = profileRatingAction;
            this.b = shopHeaderListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default(this.b, this.a.getDeepLink(), null, 2, null);
            return Unit.INSTANCE;
        }
    }

    public ShopItemRatingPresenterImpl(@NotNull Lazy<? extends ShopHeaderListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    @Override // com.avito.android.shop.detailed.item.ShopItemRatingPresenter
    public void bindRatingToView(@Nullable ProfileRating profileRating, @NotNull RatingView ratingView) {
        Intrinsics.checkNotNullParameter(ratingView, "view");
        if (profileRating != null) {
            ShopHeaderListener shopHeaderListener = (ShopHeaderListener) this.a.get();
            ProfileRatingAction action = profileRating.getAction();
            if (action == null) {
                ratingView.setRatingTextInactive();
            } else if (!Intrinsics.areEqual(action.getType(), "text")) {
                ratingView.setRatingClickListener(new a(action, this, profileRating, shopHeaderListener));
                ratingView.setRatingTextActive(action.getTitle());
            } else {
                ratingView.setRatingTextNonActionable(action.getTitle());
            }
            Float scoreFloat = profileRating.getScoreFloat();
            ratingView.setRatingScore(scoreFloat != null ? scoreFloat.floatValue() : profileRating.getScore());
            if (Intrinsics.areEqual(profileRating.getHideStars(), Boolean.TRUE)) {
                ratingView.hideRatingScore();
            } else {
                ratingView.showRatingScore();
            }
            ratingView.showRatings();
        }
    }
}
