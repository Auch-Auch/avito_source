package com.avito.android.profile.cards.wallet.separate;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import com.avito.android.tariff.count.recycler.TariffCountPayloadCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/profile/cards/wallet/separate/SeparateWalletCardItemView;", "Lcom/avito/android/profile/cards/CardItemView;", "", "real", "", "setRealBalance", "(Ljava/lang/String;)V", TariffCountPayloadCreator.PAYLOAD_BONUS, "setBonusBalance", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface SeparateWalletCardItemView extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull SeparateWalletCardItemView separateWalletCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(separateWalletCardItemView, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull SeparateWalletCardItemView separateWalletCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(separateWalletCardItemView, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull SeparateWalletCardItemView separateWalletCardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(separateWalletCardItemView, view, i);
        }

        public static void onUnbind(@NotNull SeparateWalletCardItemView separateWalletCardItemView) {
            CardItemView.DefaultImpls.onUnbind(separateWalletCardItemView);
        }

        public static void setIcon(@NotNull SeparateWalletCardItemView separateWalletCardItemView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(separateWalletCardItemView, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull SeparateWalletCardItemView separateWalletCardItemView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(separateWalletCardItemView, view);
        }
    }

    void setBonusBalance(@NotNull String str);

    void setRealBalance(@NotNull String str);
}
