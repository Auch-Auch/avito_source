package ru.avito.component.serp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import com.avito.android.util.drawable.RoundStateDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\n\u001a\u00020\t*\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/widget/TextView;", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "", "setBadge", "(Landroid/widget/TextView;Lcom/avito/android/remote/model/badge/Badge;)V", "Landroid/view/View;", "Landroid/content/res/ColorStateList;", "backgroundColor", "Lcom/avito/android/util/drawable/RoundStateDrawable;", "getBadgeBackground", "(Landroid/view/View;Landroid/content/res/ColorStateList;)Lcom/avito/android/util/drawable/RoundStateDrawable;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class BadgesKt {
    @NotNull
    public static final RoundStateDrawable getBadgeBackground(@NotNull View view, @Nullable ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(view, "$this$getBadgeBackground");
        return RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, colorStateList, null, view.getResources().getDimensionPixelSize(R.dimen.price_badge_corner_radius), null, 0, 0, 0, 122, null);
    }

    public static /* synthetic */ RoundStateDrawable getBadgeBackground$default(View view, ColorStateList colorStateList, int i, Object obj) {
        if ((i & 1) != 0) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            colorStateList = Contexts.getColorStateListByAttr(context, com.avito.android.lib.design.R.attr.constantWhite);
        }
        return getBadgeBackground(view, colorStateList);
    }

    public static final void setBadge(@NotNull TextView textView, @NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(textView, "$this$setBadge");
        Intrinsics.checkNotNullParameter(badge, "badge");
        textView.setText(badge.getTitle());
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(ContextsKt.getColorFrom(context, badge.getUniversalTitleColor()));
        UniversalColor universalBackgroundColor = badge.getUniversalBackgroundColor();
        if (universalBackgroundColor == null) {
            Views.setBackgroundCompat(textView, (Drawable) null);
            return;
        }
        Context context2 = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ColorStateList valueOf = ColorStateList.valueOf(ContextsKt.getColorFrom(context2, universalBackgroundColor));
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(c…lorFrom(backgroundColor))");
        Views.setBackgroundCompat(textView, getBadgeBackground(textView, valueOf));
    }
}
