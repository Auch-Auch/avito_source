package com.avito.android.profile.cards;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.cards.CardItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000b\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u001d\u0010\u0015\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/profile/cards/SubscriptionCardItemView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "setSubscriptionActive", "()V", "setSubscriptionInactive", "", "title", "setSubscriptionTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubscriptionSubtitle", "Lcom/avito/android/remote/model/text/AttributedText;", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "showSubscriptionAction", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "hideSubscriptionAction", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SubscriptionCardItemView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull SubscriptionCardItemView subscriptionCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(subscriptionCardItemView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull SubscriptionCardItemView subscriptionCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(subscriptionCardItemView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull SubscriptionCardItemView subscriptionCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(subscriptionCardItemView, view, i);
        }

        public static void onUnbind(@NotNull SubscriptionCardItemView subscriptionCardItemView) {
            CardItemView.DefaultImpls.onUnbind(subscriptionCardItemView);
        }

        public static void setIcon(@NotNull SubscriptionCardItemView subscriptionCardItemView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(subscriptionCardItemView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull SubscriptionCardItemView subscriptionCardItemView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(subscriptionCardItemView, view);
        }
    }

    void hideSubscriptionAction();

    void setActionListener(@NotNull Function0<Unit> function0);

    void setSubscriptionActive();

    void setSubscriptionInactive();

    void setSubscriptionSubtitle(@Nullable AttributedText attributedText);

    void setSubscriptionSubtitle(@Nullable String str);

    void setSubscriptionTitle(@NotNull String str);

    void showSubscriptionAction(@NotNull String str, @NotNull DeepLink deepLink);
}
