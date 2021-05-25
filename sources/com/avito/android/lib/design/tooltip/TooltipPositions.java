package com.avito.android.lib.design.tooltip;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipPositions;", "", "<init>", "()V", "Bottom", "Left", "Right", "Top", "components_release"}, k = 1, mv = {1, 4, 2})
public final class TooltipPositions {
    @NotNull
    public static final TooltipPositions INSTANCE = new TooltipPositions();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0001¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00038V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b(\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipPositions$Bottom;", "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "", "minPadding", "setDisplayMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Bottom;", "offset", "setAnchorOffset", "tooltipPosition", "setFallback", "(Lcom/avito/android/lib/design/tooltip/TooltipPosition;)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Bottom;", "Landroid/view/View;", "anchorView", "tooltipView", "Landroid/graphics/Rect;", "Lcom/avito/android/lib/design/tooltip/TooltipWindowRect;", "calculateTooltipPosition", "(Landroid/view/View;Landroid/view/View;)Landroid/graphics/Rect;", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "calculateDefaultTailPosition", "Lkotlin/Pair;", "calculateTailPosition", "(Landroid/view/View;Landroid/view/View;)Lkotlin/Pair;", "f", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "tailPosition", "getTailHeight", "()I", "tailHeight", "getTailSize", "tailSize", "<init>", "(Lcom/avito/android/lib/design/tooltip/TailPosition;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Bottom extends TooltipPosition implements TailPosition {
        public final TailPosition f;

        public Bottom() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Bottom(TailPosition tailPosition, int i, j jVar) {
            this((i & 1) != 0 ? new TailPositions.Center(null, 1, null) : tailPosition);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return this.f.calculateDefaultAnchorPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int calculateDefaultTailPosition(int i, int i2) {
            return this.f.calculateDefaultTailPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        @SuppressLint({"RtlHardcoded"})
        @NotNull
        public Pair<Integer, Integer> calculateTailPosition(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            return this.f.calculateTailPosition(view, view2);
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Rect calculateTooltipPosition(@NotNull View view, @NotNull View view2) {
            Rect useFallback;
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            TooltipUtils tooltipUtils = TooltipUtils.INSTANCE;
            View rootView = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "anchorView.rootView");
            Rect measureAbsoluteRect = tooltipUtils.measureAbsoluteRect(rootView);
            Rect measureAbsoluteRect2 = tooltipUtils.measureAbsoluteRect(view);
            int max = Math.max(getMinPadding() - getTailHeight(), 0);
            Rect rect = new Rect(measureAbsoluteRect.left + max, measureAbsoluteRect.top + max, measureAbsoluteRect.right - max, measureAbsoluteRect.bottom - max);
            rect.top = getAnchorOffset() + measureAbsoluteRect2.bottom;
            if (!tooltipUtils.measureTooltip(view2, rect) && (useFallback = useFallback(view, view2)) != null) {
                return useFallback;
            }
            Rect forAnchorWindow = tooltipUtils.forAnchorWindow(tooltipUtils.measureAbsoluteRect(view2), measureAbsoluteRect);
            Rect rect2 = new Rect(view2.getPaddingLeft() + forAnchorWindow.left, view2.getPaddingTop() + forAnchorWindow.top, forAnchorWindow.right - view2.getPaddingRight(), forAnchorWindow.bottom - view2.getPaddingBottom());
            forAnchorWindow.offset(calculateDefaultAnchorPosition(measureAbsoluteRect2.left, measureAbsoluteRect2.right) - calculateDefaultTailPosition(rect2.left, rect2.right), (getAnchorOffset() + measureAbsoluteRect2.bottom) - forAnchorWindow.top);
            tooltipUtils.fitTooltipIntoDisplay(forAnchorWindow, rect);
            return tooltipUtils.forTooltipWindow(forAnchorWindow, measureAbsoluteRect);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int getTailHeight() {
            return this.f.getTailHeight();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.TailPosition
        public int getTailSize() {
            return this.f.getTailSize();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.init(context, i, i2);
            this.f.init(context, i, i2);
            setAnimationStyle(R.style.Design_Animation_AppCompat_DropDownUp_Bottom);
        }

        public Bottom(@NotNull TailPosition tailPosition) {
            Intrinsics.checkNotNullParameter(tailPosition, "tailPosition");
            this.f = tailPosition;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Bottom setAnchorOffset(int i) {
            super.setAnchorOffset(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Bottom setDisplayMinPadding(int i) {
            super.setDisplayMinPadding(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Bottom setFallback(@Nullable TooltipPosition tooltipPosition) {
            super.setFallback(tooltipPosition);
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0001¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00038V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b(\u0010#¨\u0006,"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipPositions$Left;", "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "", "minPadding", "setDisplayMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Left;", "offset", "setAnchorOffset", "tooltipPosition", "setFallback", "(Lcom/avito/android/lib/design/tooltip/TooltipPosition;)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Left;", "Landroid/view/View;", "anchorView", "tooltipView", "Landroid/graphics/Rect;", "Lcom/avito/android/lib/design/tooltip/TooltipWindowRect;", "calculateTooltipPosition", "(Landroid/view/View;Landroid/view/View;)Landroid/graphics/Rect;", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "calculateDefaultTailPosition", "Lkotlin/Pair;", "calculateTailPosition", "(Landroid/view/View;Landroid/view/View;)Lkotlin/Pair;", "getTailSize", "()I", "tailSize", "f", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "tailPosition", "getTailHeight", "tailHeight", "<init>", "(Lcom/avito/android/lib/design/tooltip/TailPosition;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Left extends TooltipPosition implements TailPosition {
        public final TailPosition f;

        public Left() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Left(TailPosition tailPosition, int i, j jVar) {
            this((i & 1) != 0 ? new TailPositions.Center(null, 1, null) : tailPosition);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return this.f.calculateDefaultAnchorPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int calculateDefaultTailPosition(int i, int i2) {
            return this.f.calculateDefaultTailPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        @SuppressLint({"RtlHardcoded"})
        @NotNull
        public Pair<Integer, Integer> calculateTailPosition(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            return this.f.calculateTailPosition(view, view2);
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Rect calculateTooltipPosition(@NotNull View view, @NotNull View view2) {
            Rect useFallback;
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            TooltipUtils tooltipUtils = TooltipUtils.INSTANCE;
            View rootView = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "anchorView.rootView");
            Rect measureAbsoluteRect = tooltipUtils.measureAbsoluteRect(rootView);
            Rect measureAbsoluteRect2 = tooltipUtils.measureAbsoluteRect(view);
            int max = Math.max(getMinPadding() - getTailHeight(), 0);
            Rect rect = new Rect(measureAbsoluteRect.left + max, measureAbsoluteRect.top + max, measureAbsoluteRect.right - max, measureAbsoluteRect.bottom - max);
            rect.right = measureAbsoluteRect2.left - getAnchorOffset();
            if (!tooltipUtils.measureTooltip(view2, rect) && (useFallback = useFallback(view, view2)) != null) {
                return useFallback;
            }
            Rect forAnchorWindow = tooltipUtils.forAnchorWindow(tooltipUtils.measureAbsoluteRect(view2), measureAbsoluteRect);
            Rect rect2 = new Rect(view2.getPaddingLeft() + forAnchorWindow.left, view2.getPaddingTop() + forAnchorWindow.top, forAnchorWindow.right - view2.getPaddingRight(), forAnchorWindow.bottom - view2.getPaddingBottom());
            forAnchorWindow.offset((measureAbsoluteRect2.left - getAnchorOffset()) - forAnchorWindow.right, calculateDefaultAnchorPosition(measureAbsoluteRect2.top, measureAbsoluteRect2.bottom) - calculateDefaultTailPosition(rect2.top, rect2.bottom));
            tooltipUtils.fitTooltipIntoDisplay(forAnchorWindow, rect);
            return tooltipUtils.forTooltipWindow(forAnchorWindow, measureAbsoluteRect);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int getTailHeight() {
            return this.f.getTailHeight();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.TailPosition
        public int getTailSize() {
            return this.f.getTailSize();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.init(context, i, i2);
            this.f.init(context, i, i2);
            setAnimationStyle(R.style.Design_Animation_AppCompat_DropDownUp_Left);
        }

        public Left(@NotNull TailPosition tailPosition) {
            Intrinsics.checkNotNullParameter(tailPosition, "tailPosition");
            this.f = tailPosition;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Left setAnchorOffset(int i) {
            super.setAnchorOffset(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Left setDisplayMinPadding(int i) {
            super.setDisplayMinPadding(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Left setFallback(@Nullable TooltipPosition tooltipPosition) {
            super.setFallback(tooltipPosition);
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0001¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00038V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b(\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipPositions$Right;", "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "", "minPadding", "setDisplayMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Right;", "offset", "setAnchorOffset", "tooltipPosition", "setFallback", "(Lcom/avito/android/lib/design/tooltip/TooltipPosition;)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Right;", "Landroid/view/View;", "anchorView", "tooltipView", "Landroid/graphics/Rect;", "Lcom/avito/android/lib/design/tooltip/TooltipWindowRect;", "calculateTooltipPosition", "(Landroid/view/View;Landroid/view/View;)Landroid/graphics/Rect;", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "calculateDefaultTailPosition", "Lkotlin/Pair;", "calculateTailPosition", "(Landroid/view/View;Landroid/view/View;)Lkotlin/Pair;", "f", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "tailPosition", "getTailHeight", "()I", "tailHeight", "getTailSize", "tailSize", "<init>", "(Lcom/avito/android/lib/design/tooltip/TailPosition;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Right extends TooltipPosition implements TailPosition {
        public final TailPosition f;

        public Right() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Right(TailPosition tailPosition, int i, j jVar) {
            this((i & 1) != 0 ? new TailPositions.Center(null, 1, null) : tailPosition);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return this.f.calculateDefaultAnchorPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int calculateDefaultTailPosition(int i, int i2) {
            return this.f.calculateDefaultTailPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        @SuppressLint({"RtlHardcoded"})
        @NotNull
        public Pair<Integer, Integer> calculateTailPosition(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            return this.f.calculateTailPosition(view, view2);
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Rect calculateTooltipPosition(@NotNull View view, @NotNull View view2) {
            Rect useFallback;
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            TooltipUtils tooltipUtils = TooltipUtils.INSTANCE;
            View rootView = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "anchorView.rootView");
            Rect measureAbsoluteRect = tooltipUtils.measureAbsoluteRect(rootView);
            Rect measureAbsoluteRect2 = tooltipUtils.measureAbsoluteRect(view);
            int max = Math.max(getMinPadding() - getTailHeight(), 0);
            Rect rect = new Rect(measureAbsoluteRect.left + max, measureAbsoluteRect.top + max, measureAbsoluteRect.right - max, measureAbsoluteRect.bottom - max);
            rect.left = getAnchorOffset() + measureAbsoluteRect2.right;
            if (!tooltipUtils.measureTooltip(view2, rect) && (useFallback = useFallback(view, view2)) != null) {
                return useFallback;
            }
            Rect forAnchorWindow = tooltipUtils.forAnchorWindow(tooltipUtils.measureAbsoluteRect(view2), measureAbsoluteRect);
            Rect rect2 = new Rect(view2.getPaddingLeft() + forAnchorWindow.left, view2.getPaddingTop() + forAnchorWindow.top, forAnchorWindow.right - view2.getPaddingRight(), forAnchorWindow.bottom - view2.getPaddingBottom());
            forAnchorWindow.offset((getAnchorOffset() + measureAbsoluteRect2.right) - forAnchorWindow.left, calculateDefaultAnchorPosition(measureAbsoluteRect2.top, measureAbsoluteRect2.bottom) - calculateDefaultTailPosition(rect2.top, rect2.bottom));
            tooltipUtils.fitTooltipIntoDisplay(forAnchorWindow, rect);
            return tooltipUtils.forTooltipWindow(forAnchorWindow, measureAbsoluteRect);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int getTailHeight() {
            return this.f.getTailHeight();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.TailPosition
        public int getTailSize() {
            return this.f.getTailSize();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.init(context, i, i2);
            this.f.init(context, i, i2);
            setAnimationStyle(R.style.Design_Animation_AppCompat_DropDownUp_Right);
        }

        public Right(@NotNull TailPosition tailPosition) {
            Intrinsics.checkNotNullParameter(tailPosition, "tailPosition");
            this.f = tailPosition;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Right setAnchorOffset(int i) {
            super.setAnchorOffset(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Right setDisplayMinPadding(int i) {
            super.setDisplayMinPadding(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Right setFallback(@Nullable TooltipPosition tooltipPosition) {
            super.setFallback(tooltipPosition);
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ,\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0001¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00038V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b(\u0010#¨\u0006,"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipPositions$Top;", "Lcom/avito/android/lib/design/tooltip/TooltipPosition;", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "", "minPadding", "setDisplayMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Top;", "offset", "setAnchorOffset", "tooltipPosition", "setFallback", "(Lcom/avito/android/lib/design/tooltip/TooltipPosition;)Lcom/avito/android/lib/design/tooltip/TooltipPositions$Top;", "Landroid/view/View;", "anchorView", "tooltipView", "Landroid/graphics/Rect;", "Lcom/avito/android/lib/design/tooltip/TooltipWindowRect;", "calculateTooltipPosition", "(Landroid/view/View;Landroid/view/View;)Landroid/graphics/Rect;", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "calculateDefaultTailPosition", "Lkotlin/Pair;", "calculateTailPosition", "(Landroid/view/View;Landroid/view/View;)Lkotlin/Pair;", "getTailHeight", "()I", "tailHeight", "f", "Lcom/avito/android/lib/design/tooltip/TailPosition;", "tailPosition", "getTailSize", "tailSize", "<init>", "(Lcom/avito/android/lib/design/tooltip/TailPosition;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Top extends TooltipPosition implements TailPosition {
        public final TailPosition f;

        public Top() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Top(TailPosition tailPosition, int i, j jVar) {
            this((i & 1) != 0 ? new TailPositions.Center(null, 1, null) : tailPosition);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return this.f.calculateDefaultAnchorPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int calculateDefaultTailPosition(int i, int i2) {
            return this.f.calculateDefaultTailPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        @SuppressLint({"RtlHardcoded"})
        @NotNull
        public Pair<Integer, Integer> calculateTailPosition(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            return this.f.calculateTailPosition(view, view2);
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Rect calculateTooltipPosition(@NotNull View view, @NotNull View view2) {
            Rect useFallback;
            Intrinsics.checkNotNullParameter(view, "anchorView");
            Intrinsics.checkNotNullParameter(view2, "tooltipView");
            TooltipUtils tooltipUtils = TooltipUtils.INSTANCE;
            View rootView = view.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "anchorView.rootView");
            Rect measureAbsoluteRect = tooltipUtils.measureAbsoluteRect(rootView);
            Rect measureAbsoluteRect2 = tooltipUtils.measureAbsoluteRect(view);
            int max = Math.max(getMinPadding() - getTailHeight(), 0);
            Rect rect = new Rect(measureAbsoluteRect.left + max, measureAbsoluteRect.top + max, measureAbsoluteRect.right - max, measureAbsoluteRect.bottom - max);
            rect.bottom = measureAbsoluteRect2.top - getAnchorOffset();
            if (!tooltipUtils.measureTooltip(view2, rect) && (useFallback = useFallback(view, view2)) != null) {
                return useFallback;
            }
            Rect forAnchorWindow = tooltipUtils.forAnchorWindow(tooltipUtils.measureAbsoluteRect(view2), measureAbsoluteRect);
            Rect rect2 = new Rect(view2.getPaddingLeft() + forAnchorWindow.left, view2.getPaddingTop() + forAnchorWindow.top, forAnchorWindow.right - view2.getPaddingRight(), forAnchorWindow.bottom - view2.getPaddingBottom());
            forAnchorWindow.offset(calculateDefaultAnchorPosition(measureAbsoluteRect2.left, measureAbsoluteRect2.right) - calculateDefaultTailPosition(rect2.left, rect2.right), (measureAbsoluteRect2.top - getAnchorOffset()) - forAnchorWindow.bottom);
            tooltipUtils.fitTooltipIntoDisplay(forAnchorWindow, rect);
            return tooltipUtils.forTooltipWindow(forAnchorWindow, measureAbsoluteRect);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int getTailHeight() {
            return this.f.getTailHeight();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.TailPosition
        public int getTailSize() {
            return this.f.getTailSize();
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition, com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.init(context, i, i2);
            this.f.init(context, i, i2);
            setAnimationStyle(R.style.Design_Animation_AppCompat_DropDownUp_Top);
        }

        public Top(@NotNull TailPosition tailPosition) {
            Intrinsics.checkNotNullParameter(tailPosition, "tailPosition");
            this.f = tailPosition;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Top setAnchorOffset(int i) {
            super.setAnchorOffset(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Top setDisplayMinPadding(int i) {
            super.setDisplayMinPadding(i);
            return this;
        }

        @Override // com.avito.android.lib.design.tooltip.TooltipPosition
        @NotNull
        public Top setFallback(@Nullable TooltipPosition tooltipPosition) {
            super.setFallback(tooltipPosition);
            return this;
        }
    }
}
