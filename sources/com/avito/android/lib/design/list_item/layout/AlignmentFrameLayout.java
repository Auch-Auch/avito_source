package com.avito.android.lib.design.list_item.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ViewGroupsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\"#$B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010!J3\u0010\b\u001a\u00020\u00072\f\b\u0002\u0010\u0003\u001a\u00060\u0002R\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u00060\u0002R\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ7\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00060\u0002R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u00060\u0002R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;", "before", "after", "", "threshold", "", "setAlignment", "(Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;I)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "c", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;", "alignmentAfter", AuthSource.BOOKING_ORDER, "alignmentBefore", AuthSource.SEND_ABUSE, "I", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Alignment", "Center", "Top", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AlignmentFrameLayout extends FrameLayout {
    public int a;
    public Alignment b = new Center(this, 0.0f, 1, null);
    public Alignment c = new Center(this, 0.0f, 1, null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ7\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;", "", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "", "layout", "(IIII)V", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "layoutChild", "(Landroid/view/View;IIII)V", "<init>", "(Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public abstract class Alignment {
        public Alignment() {
            AlignmentFrameLayout.this = r1;
        }

        public final void layout(int i, int i2, int i3, int i4) {
            Iterator<View> children = ViewGroupsKt.getChildren(AlignmentFrameLayout.this);
            while (children.hasNext()) {
                View next = children.next();
                if (next.getVisibility() != 8) {
                    layoutChild(next, i, i2, i3, i4);
                }
            }
        }

        public abstract void layoutChild(@NotNull View view, int i, int i2, int i3, int i4);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Top;", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "", "layoutChild", "(Landroid/view/View;IIII)V", AuthSource.BOOKING_ORDER, "I", "padding", "<init>", "(Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public final class Top extends Alignment {
        public final int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Top(int i) {
            super();
            AlignmentFrameLayout.this = r1;
            this.b = i;
        }

        @Override // com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.Alignment
        public void layoutChild(@NotNull View view, int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            Intrinsics.checkNotNullParameter(view, VKApiUserFull.RelativeType.CHILD);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int paddingLeft = AlignmentFrameLayout.this.getPaddingLeft();
            int paddingRight = (i3 - i) - AlignmentFrameLayout.this.getPaddingRight();
            int paddingTop = AlignmentFrameLayout.this.getPaddingTop();
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i8 = layoutParams2.gravity & 7;
            if (i8 == 1) {
                i6 = (((paddingRight - paddingLeft) - AlignmentFrameLayout.this.getWidth()) / 2) + paddingLeft + layoutParams2.leftMargin;
                i7 = layoutParams2.rightMargin;
            } else if (i8 == 5 || i8 == 8388613) {
                i6 = paddingRight - measuredWidth;
                i7 = layoutParams2.rightMargin;
            } else {
                i5 = paddingLeft + layoutParams2.leftMargin;
                int i9 = paddingTop + this.b;
                view.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
            }
            i5 = i6 - i7;
            int i9 = paddingTop + this.b;
            view.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Top(AlignmentFrameLayout alignmentFrameLayout, int i, int i2, j jVar) {
            this((i2 & 1) != 0 ? 0 : i);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlignmentFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void setAlignment$default(AlignmentFrameLayout alignmentFrameLayout, Alignment alignment, Alignment alignment2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            alignment = alignmentFrameLayout.b;
        }
        if ((i2 & 2) != 0) {
            alignment2 = alignmentFrameLayout.c;
        }
        if ((i2 & 4) != 0) {
            i = alignmentFrameLayout.a;
        }
        alignmentFrameLayout.setAlignment(alignment, alignment2, i);
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getMeasuredHeight() < this.a) {
            this.b.layout(i, i2, i3, i4);
        } else {
            this.c.layout(i, i2, i3, i4);
        }
    }

    public final void setAlignment(@NotNull Alignment alignment, @NotNull Alignment alignment2, int i) {
        Intrinsics.checkNotNullParameter(alignment, "before");
        Intrinsics.checkNotNullParameter(alignment2, "after");
        this.b = alignment;
        this.c = alignment2;
        this.a = i;
        requestLayout();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Center;", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout$Alignment;", "Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;", "Landroid/view/View;", VKApiUserFull.RelativeType.CHILD, "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "", "layoutChild", "(Landroid/view/View;IIII)V", "", AuthSource.BOOKING_ORDER, "F", "verticalCenter", "<init>", "(Lcom/avito/android/lib/design/list_item/layout/AlignmentFrameLayout;F)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public final class Center extends Alignment {
        public final float b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Center(float f) {
            super();
            AlignmentFrameLayout.this = r1;
            this.b = f;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x007f  */
        @Override // com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.Alignment
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void layoutChild(@org.jetbrains.annotations.NotNull android.view.View r7, int r8, int r9, int r10, int r11) {
            /*
                r6 = this;
                java.lang.String r0 = "child"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
                java.lang.String r1 = "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
                java.util.Objects.requireNonNull(r0, r1)
                android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
                com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout r1 = com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.this
                int r1 = r1.getPaddingLeft()
                float r1 = (float) r1
                int r10 = r10 - r8
                com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout r8 = com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.this
                int r8 = r8.getPaddingRight()
                int r10 = r10 - r8
                com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout r8 = com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.this
                int r8 = r8.getPaddingTop()
                float r8 = (float) r8
                int r11 = r11 - r9
                com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout r9 = com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.this
                int r9 = r9.getPaddingBottom()
                int r11 = r11 - r9
                int r9 = r7.getMeasuredHeight()
                float r9 = (float) r9
                int r2 = r7.getMeasuredWidth()
                float r2 = (float) r2
                int r3 = r0.gravity
                r3 = r3 & 7
                r4 = 1
                r5 = 2
                if (r3 == r4) goto L_0x0052
                r4 = 5
                if (r3 == r4) goto L_0x004d
                r4 = 8388613(0x800005, float:1.175495E-38)
                if (r3 == r4) goto L_0x004d
                int r10 = r0.leftMargin
                float r10 = (float) r10
                float r1 = r1 + r10
                goto L_0x0068
            L_0x004d:
                float r10 = (float) r10
                float r10 = r10 - r2
                int r1 = r0.rightMargin
                goto L_0x0065
            L_0x0052:
                float r10 = (float) r10
                float r10 = r10 - r1
                com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout r3 = com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.this
                int r3 = r3.getWidth()
                float r3 = (float) r3
                float r10 = r10 - r3
                float r3 = (float) r5
                float r10 = r10 / r3
                float r10 = r10 + r1
                int r1 = r0.leftMargin
                float r1 = (float) r1
                float r10 = r10 + r1
                int r1 = r0.rightMargin
            L_0x0065:
                float r1 = (float) r1
                float r1 = r10 - r1
            L_0x0068:
                float r10 = r6.b
                r3 = 0
                float r3 = (float) r3
                int r3 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r3 >= 0) goto L_0x007f
                float r10 = (float) r11
                float r10 = r10 - r8
                float r10 = r10 - r9
                float r11 = (float) r5
                float r10 = r10 / r11
                float r10 = r10 + r8
                int r8 = r0.topMargin
                float r8 = (float) r8
                float r10 = r10 + r8
                int r8 = r0.bottomMargin
                float r8 = (float) r8
                float r10 = r10 - r8
                goto L_0x0085
            L_0x007f:
                float r8 = r8 + r10
                float r10 = (float) r5
                float r10 = r9 / r10
                float r10 = r8 - r10
            L_0x0085:
                int r8 = (int) r1
                int r11 = (int) r10
                float r1 = r1 + r2
                int r0 = (int) r1
                float r10 = r10 + r9
                int r9 = (int) r10
                r7.layout(r8, r11, r0, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.list_item.layout.AlignmentFrameLayout.Center.layoutChild(android.view.View, int, int, int, int):void");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Center(AlignmentFrameLayout alignmentFrameLayout, float f, int i, j jVar) {
            this((i & 1) != 0 ? -1.0f : f);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlignmentFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlignmentFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
