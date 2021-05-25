package com.avito.android.profile.cards;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/profile/cards/ShopSettingsCardItemView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "showAction", "hideAction", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface ShopSettingsCardItemView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull ShopSettingsCardItemView shopSettingsCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(shopSettingsCardItemView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull ShopSettingsCardItemView shopSettingsCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(shopSettingsCardItemView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull ShopSettingsCardItemView shopSettingsCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(shopSettingsCardItemView, view, i);
        }

        public static void onUnbind(@NotNull ShopSettingsCardItemView shopSettingsCardItemView) {
            CardItemView.DefaultImpls.onUnbind(shopSettingsCardItemView);
        }

        public static void setIcon(@NotNull ShopSettingsCardItemView shopSettingsCardItemView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(shopSettingsCardItemView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull ShopSettingsCardItemView shopSettingsCardItemView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(shopSettingsCardItemView, view);
        }
    }

    void hideAction();

    void setActionListener(@NotNull Function0<Unit> function0);

    void setTitle(@NotNull String str);

    void showAction(@NotNull String str);
}
