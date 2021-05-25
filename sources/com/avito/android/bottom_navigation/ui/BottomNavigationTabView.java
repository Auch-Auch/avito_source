package com.avito.android.bottom_navigation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.R;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b%\u0010)B#\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b%\u0010+J+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b!\u0010\u001c¨\u0006,"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/BottomNavigationTabView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", FirebaseAnalytics.Param.INDEX, "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "initTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "count", "setBadge", "(I)V", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "badge", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "icon", AuthSource.SEND_ABUSE, "title", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class BottomNavigationTabView extends FrameLayout {
    public TextView a;
    public View b;
    public TextView c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationTabView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View view, int i, @Nullable ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == R.id.bn_title) {
            this.a = (TextView) view;
        } else if (id == R.id.bn_icon) {
            this.b = (ImageView) view;
        } else if (id == R.id.bn_badge) {
            this.c = (TextView) view;
        }
    }

    public final void initTab(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        TextView textView = this.a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        }
        textView.setText(navigationTabSetItem.getTitle());
        View view = this.b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
        }
        view.setBackgroundResource(navigationTabSetItem.getIcon());
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = (i3 - i) / 2;
        TextView textView = this.c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        TextView textView2 = this.c;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        int top = textView2.getTop();
        TextView textView3 = this.c;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        int width = textView3.getWidth() + i5;
        TextView textView4 = this.c;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        textView.layout(i5, top, width, textView4.getBottom());
    }

    public final void setBadge(int i) {
        if (i > 0) {
            TextView textView = this.c;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("badge");
            }
            textView.setVisibility(0);
            TextView textView2 = this.c;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("badge");
            }
            textView2.setText(i < 100 ? String.valueOf(i) : "99+");
            return;
        }
        TextView textView3 = this.c;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        textView3.setVisibility(8);
        TextView textView4 = this.c;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("badge");
        }
        textView4.setText((CharSequence) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationTabView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationTabView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
