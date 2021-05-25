package com.avito.android.profile.cards;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.IdRes;
import com.avito.android.component.clickable_element.ClickableElement;
import com.avito.android.component.clickable_element.ClickableElementImpl;
import com.avito.android.component.info_block.InfoBlock;
import com.avito.android.component.info_block.InfoBlockImpl;
import com.avito.android.profile.R;
import com.avito.android.util.Views;
import com.avito.konveyor.blueprint.ItemView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u0002*\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\r*\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u00020\u0010*\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\b*\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile/cards/CardItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/info_block/InfoBlock;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setIcon", "(Lcom/avito/android/component/info_block/InfoBlock;Landroid/graphics/drawable/Drawable;)V", "Landroid/view/View;", "", "id", "findInfoBlock", "(Landroid/view/View;I)Lcom/avito/android/component/info_block/InfoBlock;", "Lru/avito/component/button/Button;", "findButton", "(Landroid/view/View;I)Lru/avito/component/button/Button;", "Lcom/avito/android/component/clickable_element/ClickableElement;", "findClickableElement", "(Landroid/view/View;I)Lcom/avito/android/component/clickable_element/ClickableElement;", "withCardPaddings", "(Landroid/view/View;)Landroid/view/View;", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface CardItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Button findButton(@NotNull CardItemView cardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findButton");
            View findViewById = view.findViewById(i);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            return new ButtonImpl(cardItemView.withCardPaddings(findViewById));
        }

        @NotNull
        public static ClickableElement findClickableElement(@NotNull CardItemView cardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findClickableElement");
            View findViewById = view.findViewById(i);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            return new ClickableElementImpl(cardItemView.withCardPaddings(findViewById));
        }

        @NotNull
        public static InfoBlock findInfoBlock(@NotNull CardItemView cardItemView, @NotNull View view, @IdRes int i) {
            Intrinsics.checkNotNullParameter(view, "$this$findInfoBlock");
            View findViewById = view.findViewById(i);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            return new InfoBlockImpl(cardItemView.withCardPaddings(findViewById));
        }

        public static void onUnbind(@NotNull CardItemView cardItemView) {
            ItemView.DefaultImpls.onUnbind(cardItemView);
        }

        public static void setIcon(@NotNull CardItemView cardItemView, @NotNull InfoBlock infoBlock, @Nullable Drawable drawable) {
            Intrinsics.checkNotNullParameter(infoBlock, "$this$setIcon");
            if (drawable != null) {
                infoBlock.setIcon(drawable);
            }
        }

        @NotNull
        public static View withCardPaddings(@NotNull CardItemView cardItemView, @NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "$this$withCardPaddings");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.profile_inside_horizontal_padding);
            Views.changePadding$default(view, dimensionPixelSize, 0, dimensionPixelSize, 0, 10, null);
            return view;
        }
    }

    @NotNull
    Button findButton(@NotNull View view, @IdRes int i);

    @NotNull
    ClickableElement findClickableElement(@NotNull View view, @IdRes int i);

    @NotNull
    InfoBlock findInfoBlock(@NotNull View view, @IdRes int i);

    void setIcon(@NotNull InfoBlock infoBlock, @Nullable Drawable drawable);

    @NotNull
    View withCardPaddings(@NotNull View view);
}
