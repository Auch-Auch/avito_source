package com.avito.android.profile.cards;

import com.avito.android.Features;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.ProfileRatingAction;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile/cards/InfoCardItemPresenterImpl;", "Lcom/avito/android/profile/cards/InfoCardItemPresenter;", "Lcom/avito/android/profile/cards/InfoCardItemView;", "view", "Lcom/avito/android/profile/cards/CardItem$InfoCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/InfoCardItemView;Lcom/avito/android/profile/cards/CardItem$InfoCardItem;I)V", "Lio/reactivex/functions/Consumer;", AuthSource.BOOKING_ORDER, "Lio/reactivex/functions/Consumer;", "ratingClickConsumer", AuthSource.SEND_ABUSE, "valueConsumer", "Lcom/avito/android/Features;", "features", "<init>", "(Lio/reactivex/functions/Consumer;Lio/reactivex/functions/Consumer;Lcom/avito/android/Features;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class InfoCardItemPresenterImpl implements InfoCardItemPresenter {
    public final Consumer<CardItem.InfoCardItem> a;
    public final Consumer<CardItem.InfoCardItem> b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((InfoCardItemPresenterImpl) this.b).a.accept((CardItem.InfoCardItem) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((InfoCardItemPresenterImpl) this.b).a.accept((CardItem.InfoCardItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InfoCardItemPresenterImpl a;
        public final /* synthetic */ InfoCardItemView b;
        public final /* synthetic */ CardItem.InfoCardItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InfoCardItemPresenterImpl infoCardItemPresenterImpl, InfoCardItemView infoCardItemView, CardItem.InfoCardItem infoCardItem) {
            super(0);
            this.a = infoCardItemPresenterImpl;
            this.b = infoCardItemView;
            this.c = infoCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.b.accept(this.c);
            return Unit.INSTANCE;
        }
    }

    public InfoCardItemPresenterImpl(@NotNull Consumer<CardItem.InfoCardItem> consumer, @NotNull Consumer<CardItem.InfoCardItem> consumer2, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        Intrinsics.checkNotNullParameter(consumer2, "ratingClickConsumer");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = consumer;
        this.b = consumer2;
    }

    public void bindView(@NotNull InfoCardItemView infoCardItemView, @NotNull CardItem.InfoCardItem infoCardItem, int i) {
        Float f;
        Intrinsics.checkNotNullParameter(infoCardItemView, "view");
        Intrinsics.checkNotNullParameter(infoCardItem, "item");
        Avatar avatar = infoCardItem.getAvatar();
        String str = null;
        String alert = avatar != null ? avatar.getAlert() : null;
        Avatar avatar2 = infoCardItem.getAvatar();
        String description = avatar2 != null ? avatar2.getDescription() : null;
        infoCardItemView.hideAvatarAlert();
        infoCardItemView.hideAvatarInfo();
        if (alert != null && description != null) {
            infoCardItemView.showAvatarAlert(alert, description);
        } else if (description != null) {
            infoCardItemView.showAvatarInfo(description);
        }
        infoCardItemView.showAvatar(infoCardItem.getAvatar());
        infoCardItemView.setName(infoCardItem.getName());
        if (infoCardItem.getSupport() != null) {
            infoCardItemView.showDescription(infoCardItem.getSupport().getTitle(), infoCardItem.getSupport().getFormattedContactId());
        } else {
            infoCardItemView.hideDescription();
        }
        if (infoCardItem.isIncomplete()) {
            infoCardItemView.setProfileIncomplete();
        } else {
            infoCardItemView.setProfileNormal();
        }
        infoCardItemView.setEmail(infoCardItem.getEmail());
        infoCardItemView.setManager(infoCardItem.getManager());
        infoCardItemView.setAddress(infoCardItem.getAddress());
        infoCardItemView.setRegistered(infoCardItem.getRegistered());
        infoCardItemView.setWebsite(infoCardItem.getShopSite());
        infoCardItemView.setActionListener(new a(0, this, infoCardItem));
        infoCardItemView.setAvatarClickListener(new a(1, this, infoCardItem));
        ProfileRating rating = infoCardItem.getRating();
        ProfileRatingAction action = rating != null ? rating.getAction() : null;
        ProfileRating rating2 = infoCardItem.getRating();
        if (rating2 == null || (f = rating2.getScoreFloat()) == null) {
            ProfileRating rating3 = infoCardItem.getRating();
            f = rating3 != null ? Float.valueOf(rating3.getScore()) : null;
        }
        if (action != null) {
            str = action.getTitle();
        }
        infoCardItemView.setRating(f, str);
        if (action != null && action.getDeepLink() != null) {
            infoCardItemView.setRatingClickListener(new b(this, infoCardItemView, infoCardItem));
        }
    }
}
