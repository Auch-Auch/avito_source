package com.avito.android.profile.cards.verified_profile;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface VerifiedProfileCardView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull VerifiedProfileCardView verifiedProfileCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(verifiedProfileCardView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull VerifiedProfileCardView verifiedProfileCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(verifiedProfileCardView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull VerifiedProfileCardView verifiedProfileCardView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(verifiedProfileCardView, view, i);
        }

        public static void onUnbind(@NotNull VerifiedProfileCardView verifiedProfileCardView) {
            CardItemView.DefaultImpls.onUnbind(verifiedProfileCardView);
        }

        public static void setIcon(@NotNull VerifiedProfileCardView verifiedProfileCardView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(verifiedProfileCardView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull VerifiedProfileCardView verifiedProfileCardView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(verifiedProfileCardView, view);
        }
    }

    void setTitle(@NotNull CharSequence charSequence);
}
