package com.avito.android.profile.cards;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/cards/DeliverySettingsItemView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "title", MessengerShareContentUtility.SUBTITLE, "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "bind", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface DeliverySettingsItemView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull DeliverySettingsItemView deliverySettingsItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(deliverySettingsItemView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull DeliverySettingsItemView deliverySettingsItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(deliverySettingsItemView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull DeliverySettingsItemView deliverySettingsItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(deliverySettingsItemView, view, i);
        }

        public static void onUnbind(@NotNull DeliverySettingsItemView deliverySettingsItemView) {
            CardItemView.DefaultImpls.onUnbind(deliverySettingsItemView);
        }

        public static void setIcon(@NotNull DeliverySettingsItemView deliverySettingsItemView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(deliverySettingsItemView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull DeliverySettingsItemView deliverySettingsItemView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(deliverySettingsItemView, view);
        }
    }

    void bind(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0);
}
