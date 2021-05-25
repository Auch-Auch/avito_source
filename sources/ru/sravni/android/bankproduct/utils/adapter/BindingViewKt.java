package ru.sravni.android.bankproduct.utils.adapter;

import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroid/view/View;", "view", "", "dataRGBColor", "", "bindSetBackgroundColor", "(Landroid/view/View;I)V", "Landroidx/cardview/widget/CardView;", "backgroundCustomColor", "bindSetBackgroundColorToCardView", "(Landroidx/cardview/widget/CardView;I)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingViewKt {
    @BindingAdapter({"dataRGBColor"})
    public static final void bindSetBackgroundColor(@NotNull View view, int i) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.setBackgroundColor(i);
    }

    @BindingAdapter({"backgroundCustomColor"})
    public static final void bindSetBackgroundColorToCardView(@NotNull CardView cardView, int i) {
        Intrinsics.checkParameterIsNotNull(cardView, "view");
        cardView.setCardBackgroundColor(i);
    }
}
