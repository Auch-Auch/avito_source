package com.avito.android.profile.cards.verified_profile;

import com.avito.android.profile.cards.CardItem;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardPresenterImpl;", "Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardPresenter;", "Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardView;", "view", "Lcom/avito/android/profile/cards/CardItem$VerifiedProfileCardItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardView;Lcom/avito/android/profile/cards/CardItem$VerifiedProfileCardItem;I)V", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerifiedProfileCardPresenterImpl implements VerifiedProfileCardPresenter {
    public void bindView(@NotNull VerifiedProfileCardView verifiedProfileCardView, @NotNull CardItem.VerifiedProfileCardItem verifiedProfileCardItem, int i) {
        Intrinsics.checkNotNullParameter(verifiedProfileCardView, "view");
        Intrinsics.checkNotNullParameter(verifiedProfileCardItem, "item");
        verifiedProfileCardView.setTitle(verifiedProfileCardItem.getTitle());
    }
}
