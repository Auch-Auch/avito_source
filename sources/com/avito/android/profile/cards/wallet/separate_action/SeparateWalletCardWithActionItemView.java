package com.avito.android.profile.cards.wallet.separate_action;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.wallet.separate.SeparateWalletCardItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemView;", "Lcom/avito/android/profile/cards/wallet/separate/SeparateWalletCardItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SeparateWalletCardWithActionItemView extends SeparateWalletCardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull SeparateWalletCardWithActionItemView separateWalletCardWithActionItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return SeparateWalletCardItemView.DefaultImpls.findButton(separateWalletCardWithActionItemView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull SeparateWalletCardWithActionItemView separateWalletCardWithActionItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return SeparateWalletCardItemView.DefaultImpls.findClickableElement(separateWalletCardWithActionItemView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull SeparateWalletCardWithActionItemView separateWalletCardWithActionItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return SeparateWalletCardItemView.DefaultImpls.findInfoBlock(separateWalletCardWithActionItemView, view, i);
        }

        public static void onUnbind(@NotNull SeparateWalletCardWithActionItemView separateWalletCardWithActionItemView) {
            SeparateWalletCardItemView.DefaultImpls.onUnbind(separateWalletCardWithActionItemView);
        }

        public static void setIcon(@NotNull SeparateWalletCardWithActionItemView separateWalletCardWithActionItemView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            SeparateWalletCardItemView.DefaultImpls.setIcon(separateWalletCardWithActionItemView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull SeparateWalletCardWithActionItemView separateWalletCardWithActionItemView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return SeparateWalletCardItemView.DefaultImpls.withCardPaddings(separateWalletCardWithActionItemView, view);
        }
    }

    void setActionListener(@NotNull Function0<Unit> function0);
}
