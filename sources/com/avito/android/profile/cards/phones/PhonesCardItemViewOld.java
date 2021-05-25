package com.avito.android.profile.cards.phones;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.clickable_info_block.ClickableInfoBlock;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.profile.cards.CardItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemViewOld;", "Lcom/avito/android/profile/cards/CardItemView;", "", "removePhones", "()V", "", "phone", "", "verified", "locked", "Lio/reactivex/Observable;", "Lcom/avito/android/component/clickable_info_block/ClickableInfoBlock;", "addPhone", "(Ljava/lang/String;ZZ)Lio/reactivex/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PhonesCardItemViewOld extends CardItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull PhonesCardItemViewOld phonesCardItemViewOld, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            return CardItemView.DefaultImpls.findButton(phonesCardItemViewOld, view, i);
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull PhonesCardItemViewOld phonesCardItemViewOld, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            return CardItemView.DefaultImpls.findClickableElement(phonesCardItemViewOld, view, i);
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull PhonesCardItemViewOld phonesCardItemViewOld, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            return CardItemView.DefaultImpls.findInfoBlock(phonesCardItemViewOld, view, i);
        }

        public static void onUnbind(@NotNull PhonesCardItemViewOld phonesCardItemViewOld) {
            CardItemView.DefaultImpls.onUnbind(phonesCardItemViewOld);
        }

        public static void setIcon(@NotNull PhonesCardItemViewOld phonesCardItemViewOld, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            CardItemView.DefaultImpls.setIcon(phonesCardItemViewOld, infoBlock, drawable);
        }

        @NotNull
        public static View withCardPaddings(@NotNull PhonesCardItemViewOld phonesCardItemViewOld, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            return CardItemView.DefaultImpls.withCardPaddings(phonesCardItemViewOld, view);
        }
    }

    @NotNull
    Observable<ClickableInfoBlock> addPhone(@NotNull String str, boolean z, boolean z2);

    void removePhones();

    void setActionListener(@NotNull Function0<Unit> function0);
}
