package com.avito.android.lib.design.tooltip;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewTreeObservers;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.badge.BadgeDrawable;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u00101\u001a\u000200\u0012\b\b\u0002\u0010(\u001a\u00020\u0011\u0012\b\b\u0002\u0010/\u001a\u00020\u0011¢\u0006\u0004\b2\u00103J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u001e¨\u00064"}, d2 = {"Lcom/avito/android/lib/design/tooltip/Tooltip;", "Landroid/widget/PopupWindow;", "Landroid/view/View;", "contentView", "", "setContentView", "(Landroid/view/View;)V", "getContentView", "()Landroid/view/View;", "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", VKApiConst.POSITION, "setTooltipPosition", "(Lcom/avito/android/lib/design/tooltip/TooltipPosition;)Lcom/avito/android/lib/design/tooltip/Tooltip;", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTooltipClickListener", "(Landroid/view/View$OnClickListener;)Lcom/avito/android/lib/design/tooltip/Tooltip;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setSize", "(II)Lcom/avito/android/lib/design/tooltip/Tooltip;", "anchor", "show", "(Landroid/view/View;)Lcom/avito/android/lib/design/tooltip/Tooltip;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "e", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "callback", AuthSource.BOOKING_ORDER, "I", "contentStyle", "f", "initialWidth", g.a, "initialHeight", "d", "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "tooltipPosition", "h", "defStyleAttr", AuthSource.SEND_ABUSE, "Landroid/view/View;", "c", "Landroid/view/View$OnClickListener;", "tooltipClickListener", "i", "defStyleRes", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Tooltip extends PopupWindow {
    public View a;
    public int b;
    public View.OnClickListener c;
    public TooltipPosition d;
    public ViewTreeObserver.OnGlobalLayoutListener e;
    public int f;
    public int g;
    public final int h;
    public final int i;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ Tooltip a;
        public final /* synthetic */ View b;

        public a(Tooltip tooltip, View view) {
            this.a = tooltip;
            this.b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Tooltip.access$clearCallback(this.a, this.b);
            Tooltip.access$run(this.a, this.b);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Tooltip a;

        public b(Tooltip tooltip) {
            this.a = tooltip;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Tooltip(Context context, int i2, int i3, int i4, j jVar) {
        this(context, (i4 & 2) != 0 ? R.attr.tooltip : i2, (i4 & 4) != 0 ? R.style.Design_Widget_Tooltip : i3);
    }

    public static final void access$clearCallback(Tooltip tooltip, View view) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = tooltip.e;
        if (!(onGlobalLayoutListener == null || view == null || (viewTreeObserver = view.getViewTreeObserver()) == null)) {
            ViewTreeObservers.removeGlobalLayoutListener(viewTreeObserver, onGlobalLayoutListener);
        }
        tooltip.e = null;
    }

    public static final void access$run(Tooltip tooltip, View view) {
        View contentView = super.getContentView();
        Objects.requireNonNull(contentView, "null cannot be cast to non-null type com.avito.android.lib.design.tooltip.TooltipContainer");
        TooltipContainer tooltipContainer = (TooltipContainer) contentView;
        TooltipPosition tooltipPosition = tooltip.d;
        Context context = tooltipContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "tooltipContainer.context");
        tooltipPosition.init(context, tooltip.h, tooltip.i);
        tooltip.setAnimationStyle(tooltip.d.getAnimationStyle());
        tooltipContainer.setAnchorView(view);
        tooltipContainer.setTooltipPosition$components_release(tooltip.d);
        tooltipContainer.setLayoutParams(new FrameLayout.LayoutParams(tooltip.f, tooltip.g));
        Rect tooltipPosition2 = tooltip.d.getTooltipPosition(view, tooltipContainer);
        tooltip.setWidth(tooltipPosition2.width());
        tooltip.setHeight(tooltipPosition2.height());
        tooltip.showAtLocation(view, BadgeDrawable.TOP_START, tooltipPosition2.left, tooltipPosition2.top);
    }

    public static /* synthetic */ Tooltip setSize$default(Tooltip tooltip, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = tooltip.f;
        }
        if ((i4 & 2) != 0) {
            i3 = tooltip.g;
        }
        return tooltip.setSize(i2, i3);
    }

    @Override // android.widget.PopupWindow
    @Nullable
    public View getContentView() {
        return this.a;
    }

    @Override // android.widget.PopupWindow
    public void setContentView(@Nullable View view) {
        View contentView = super.getContentView();
        if (!(contentView instanceof ViewGroup)) {
            contentView = null;
        }
        ViewGroup viewGroup = (ViewGroup) contentView;
        if (viewGroup == null) {
            super.setContentView(view);
            return;
        }
        viewGroup.removeAllViews();
        this.a = view;
        if (view != null) {
            viewGroup.addView(view);
        }
    }

    @NotNull
    public final Tooltip setSize(int i2, int i3) {
        this.f = i2;
        this.g = i3;
        return this;
    }

    @NotNull
    public final Tooltip setTooltipClickListener(@Nullable View.OnClickListener onClickListener) {
        View contentView = super.getContentView();
        if (contentView != null) {
            if (onClickListener == null) {
                onClickListener = this.c;
            }
            contentView.setOnClickListener(onClickListener);
        }
        return this;
    }

    @NotNull
    public final Tooltip setTooltipPosition(@NotNull TooltipPosition tooltipPosition) {
        Intrinsics.checkNotNullParameter(tooltipPosition, VKApiConst.POSITION);
        this.d = tooltipPosition;
        return this;
    }

    @NotNull
    public final Tooltip show(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        dismiss();
        this.e = new a(this, view);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
        view.requestLayout();
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Tooltip(@NotNull Context context, int i2, int i3) {
        super(new TooltipContainer(context, null, i2, i3));
        Intrinsics.checkNotNullParameter(context, "context");
        this.h = i2;
        this.i = i3;
        this.c = new b(this);
        this.d = new TooltipPositions.Top(new TailPositions.End(new AnchorPositions.Center()));
        this.f = -2;
        this.g = -2;
        setBackgroundDrawable(new ColorDrawable(0));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Tooltip, i2, i3);
        this.f = obtainStyledAttributes.getLayoutDimension(R.styleable.Tooltip_android_layout_width, "layout_width");
        this.g = obtainStyledAttributes.getLayoutDimension(R.styleable.Tooltip_android_layout_height, "layout_height");
        setWidth(this.f);
        setHeight(this.g);
        this.b = obtainStyledAttributes.getResourceId(R.styleable.Tooltip_tooltip_contentStyle, this.b);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Tooltip_tooltip_content, 0);
        if (resourceId > 0) {
            LayoutInflater from = LayoutInflater.from(new ContextThemeWrapper(context, this.b));
            View contentView = super.getContentView();
            Objects.requireNonNull(contentView, "null cannot be cast to non-null type android.view.ViewGroup");
            View inflate = from.inflate(resourceId, (ViewGroup) contentView, false);
            this.a = inflate;
            setContentView(inflate);
        }
        obtainStyledAttributes.recycle();
        setOutsideTouchable(true);
        View contentView2 = super.getContentView();
        if (contentView2 != null) {
            contentView2.setOnClickListener(this.c);
        }
    }
}
