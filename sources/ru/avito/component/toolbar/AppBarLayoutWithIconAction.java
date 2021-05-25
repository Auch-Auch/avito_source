package ru.avito.component.toolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010J%\u0010\u0006\u001a\u00020\u00052\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "", "drawableRes", "iconTintColor", "", "setActionIcon", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "h", "()V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AppBarLayoutWithIconAction extends CollapsingTitleAppBarLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarLayoutWithIconAction(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        h();
    }

    public static /* synthetic */ void setActionIcon$default(AppBarLayoutWithIconAction appBarLayoutWithIconAction, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num2 = null;
        }
        appBarLayoutWithIconAction.setActionIcon(num, num2);
    }

    public final void h() {
        ImageView imageView = new ImageView(getContext());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.publish_toolbar_home_icon_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_publish_toolbar_arrow));
        super.setActionView(imageView);
    }

    public final void setActionIcon(@DrawableRes @Nullable Integer num, @ColorInt @Nullable Integer num2) {
        Views.setVisible(getActionView(), num != null);
        if (num != null) {
            int intValue = num.intValue();
            View actionView = getActionView();
            Objects.requireNonNull(actionView, "null cannot be cast to non-null type android.widget.ImageView");
            ((ImageView) actionView).setImageResource(intValue);
            if (num2 != null) {
                int intValue2 = num2.intValue();
                View actionView2 = getActionView();
                Objects.requireNonNull(actionView2, "null cannot be cast to non-null type android.widget.ImageView");
                ImageViewsKt.setImageTintListCompat((ImageView) actionView2, ColorStateList.valueOf(intValue2));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarLayoutWithIconAction(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        h();
    }
}
