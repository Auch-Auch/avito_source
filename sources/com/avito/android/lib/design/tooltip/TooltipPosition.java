package com.avito.android.lib.design.tooltip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.tooltip.TailPosition;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u0019\u0010\u0003\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00060\u000ej\u0002`\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0010J)\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u0019J#\u0010\u001b\u001a\u00060\u000ej\u0002`\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH$¢\u0006\u0004\b\u001b\u0010\u0010J'\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0006\u001a\u00020\u00058D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u000f\u001a\u00020+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010)R*\u00106\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00058\u0006@DX\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010'\"\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00058D@\u0004X\u0004¢\u0006\u0006\u001a\u0004\b7\u0010'¨\u0006;"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "tooltipPosition", "setFallback", "(Lcom/avito/android/lib/design/tooltip/TooltipPosition;)Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "", "minPadding", "setDisplayMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "offset", "setAnchorOffset", "Landroid/view/View;", "anchorView", "tooltipView", "Landroid/graphics/Rect;", "useFallback", "(Landroid/view/View;Landroid/view/View;)Landroid/graphics/Rect;", "Lcom/avito/android/lib/design/tooltip/TooltipWindowRect;", "getTooltipPosition", "Lkotlin/Pair;", "getTailPosition", "(Landroid/view/View;Landroid/view/View;)Lkotlin/Pair;", Tracker.Events.CREATIVE_START, "end", "getDefaultAnchorPosition", "(II)I", "getDefaultTailPosition", "calculateTooltipPosition", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", "d", "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "fallback", "getMinPadding", "()I", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "innerMinPadding", "", "e", "Z", AuthSource.BOOKING_ORDER, "innerAnchorOffset", "<set-?>", "c", "I", "getAnimationStyle", "setAnimationStyle", "(I)V", "animationStyle", "getAnchorOffset", "anchorOffset", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public abstract class TooltipPosition implements TailPosition {
    public Integer a;
    public Integer b;
    public int c;
    public TooltipPosition d;
    public boolean e;

    @NotNull
    public abstract Rect calculateTooltipPosition(@NotNull View view, @NotNull View view2);

    public final int getAnchorOffset() {
        Integer num = this.b;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int getAnimationStyle() {
        return this.c;
    }

    public final int getDefaultAnchorPosition(int i, int i2) {
        TooltipPosition tooltipPosition = this.d;
        if (tooltipPosition != null) {
            if (!this.e) {
                tooltipPosition = null;
            }
            if (tooltipPosition != null) {
                return tooltipPosition.getDefaultAnchorPosition(i, i2);
            }
        }
        return calculateDefaultAnchorPosition(i, i2);
    }

    public final int getDefaultTailPosition(int i, int i2) {
        TooltipPosition tooltipPosition = this.d;
        if (tooltipPosition != null) {
            if (!this.e) {
                tooltipPosition = null;
            }
            if (tooltipPosition != null) {
                return tooltipPosition.getDefaultTailPosition(i, i2);
            }
        }
        return calculateDefaultTailPosition(i, i2);
    }

    public final int getMinPadding() {
        Integer num = this.a;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @NotNull
    public final Pair<Integer, Integer> getTailPosition(@NotNull View view, @NotNull View view2) {
        Pair<Integer, Integer> tailPosition;
        Intrinsics.checkNotNullParameter(view, "anchorView");
        Intrinsics.checkNotNullParameter(view2, "tooltipView");
        TooltipPosition tooltipPosition = this.d;
        if (tooltipPosition != null) {
            if (!this.e) {
                tooltipPosition = null;
            }
            if (!(tooltipPosition == null || (tailPosition = tooltipPosition.getTailPosition(view, view2)) == null)) {
                return tailPosition;
            }
        }
        return calculateTailPosition(view, view2);
    }

    @Override // com.avito.android.lib.design.tooltip.TailPosition
    public int getTailSize() {
        return TailPosition.DefaultImpls.getTailSize(this);
    }

    @NotNull
    public final Rect getTooltipPosition(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "anchorView");
        Intrinsics.checkNotNullParameter(view2, "tooltipView");
        this.e = false;
        return calculateTooltipPosition(view, view2);
    }

    @Override // com.avito.android.lib.design.tooltip.AnchorPosition
    public void init(@NotNull Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Tooltip, i, i2);
        if (this.a == null) {
            this.a = Integer.valueOf(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tooltip_tooltip_displayMinPadding, 0));
        }
        if (this.b == null) {
            this.b = Integer.valueOf(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tooltip_tooltip_anchorOffset, 0));
        }
        this.c = obtainStyledAttributes.getResourceId(R.styleable.Tooltip_tooltip_animationStyle, R.style.Design_Animation_AppCompat_DropDownUp);
        obtainStyledAttributes.recycle();
        TooltipPosition tooltipPosition = this.d;
        if (tooltipPosition != null) {
            tooltipPosition.init(context, i, i2);
        }
    }

    @NotNull
    public TooltipPosition setAnchorOffset(int i) {
        this.b = Integer.valueOf(i);
        return this;
    }

    public final void setAnimationStyle(int i) {
        this.c = i;
    }

    @NotNull
    public TooltipPosition setDisplayMinPadding(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }

    @NotNull
    public TooltipPosition setFallback(@Nullable TooltipPosition tooltipPosition) {
        this.d = tooltipPosition;
        return this;
    }

    @Nullable
    public final Rect useFallback(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "anchorView");
        Intrinsics.checkNotNullParameter(view2, "tooltipView");
        TooltipPosition tooltipPosition = this.d;
        this.e = tooltipPosition != null;
        if (tooltipPosition != null) {
            return tooltipPosition.calculateTooltipPosition(view, view2);
        }
        return null;
    }
}
