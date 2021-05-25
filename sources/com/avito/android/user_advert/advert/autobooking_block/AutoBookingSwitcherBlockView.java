package com.avito.android.user_advert.advert.autobooking_block;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.user_advert.R;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockView;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModel;
import com.avito.android.util.Contexts;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_advert/advert/autobooking_block/AutoBookingSwitcherBlockView;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockView;", "Landroid/view/View;", "view", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Landroid/view/View;Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModel;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AutoBookingSwitcherBlockView extends SwitcherBlockView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoBookingSwitcherBlockView(@NotNull View view, @NotNull SwitcherBlockViewModel switcherBlockViewModel, @NotNull LifecycleOwner lifecycleOwner, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view, switcherBlockViewModel, lifecycleOwner, attributedTextFormatter, R.id.auto_booking_block, R.id.auto_booking_switcher);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(switcherBlockViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Context context = view.getContext();
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_auto_24);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int colorByAttr = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28);
        if (drawable != null) {
            drawable.setTint(colorByAttr);
        }
        getSwitcher().setImageDrawable(drawable);
    }
}
