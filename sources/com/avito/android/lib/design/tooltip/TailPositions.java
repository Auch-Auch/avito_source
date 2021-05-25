package com.avito.android.lib.design.tooltip;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TailPositions;", "", "<init>", "()V", "Center", "End", "Start", "components_release"}, k = 1, mv = {1, 4, 2})
public final class TailPositions {
    @NotNull
    public static final TailPositions INSTANCE = new TailPositions();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TailPositions$Center;", "Lcom/avito/android/lib/design/tooltip/BaseTailPosition;", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "", Tracker.Events.CREATIVE_START, "end", "calculateDefaultTailPosition", "(II)I", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", "calculateDefaultAnchorPosition", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "anchorPosition", "<init>", "(Lcom/avito/android/lib/design/tooltip/AnchorPosition;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Center extends BaseTailPosition implements AnchorPosition {
        public final AnchorPosition b;

        public Center() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Center(AnchorPosition anchorPosition, int i, j jVar) {
            this((i & 1) != 0 ? new AnchorPositions.Center() : anchorPosition);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return this.b.calculateDefaultAnchorPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int calculateDefaultTailPosition(int i, int i2) {
            return a.R1(i2, i, 2, i);
        }

        @Override // com.avito.android.lib.design.tooltip.BaseTailPosition, com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.init(context, i, i2);
            this.b.init(context, i, i2);
        }

        public Center(@NotNull AnchorPosition anchorPosition) {
            Intrinsics.checkNotNullParameter(anchorPosition, "anchorPosition");
            this.b = anchorPosition;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0012\u0010\nR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TailPositions$End;", "Lcom/avito/android/lib/design/tooltip/BaseTailPosition;", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "", "minPadding", "setTailMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/TailPositions$End;", Tracker.Events.CREATIVE_START, "end", "calculateDefaultTailPosition", "(II)I", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", "calculateDefaultAnchorPosition", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "innerMinPadding", "c", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "anchorPosition", "<init>", "(Lcom/avito/android/lib/design/tooltip/AnchorPosition;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class End extends BaseTailPosition implements AnchorPosition {
        public Integer b;
        public final AnchorPosition c;

        public End() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ End(AnchorPosition anchorPosition, int i, j jVar) {
            this((i & 1) != 0 ? new AnchorPositions.Center() : anchorPosition);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return this.c.calculateDefaultAnchorPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int calculateDefaultTailPosition(int i, int i2) {
            int tailHeight = i2 - getTailHeight();
            Integer num = this.b;
            int intValue = tailHeight - (num != null ? num.intValue() : 0);
            return intValue <= i2 ? intValue : a.R1(i2, i, 2, i);
        }

        @Override // com.avito.android.lib.design.tooltip.BaseTailPosition, com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.init(context, i, i2);
            this.c.init(context, i, i2);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Tooltip, i, i2);
            if (this.b == null) {
                this.b = Integer.valueOf(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tooltip_tooltip_tailMinPadding, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @NotNull
        public final End setTailMinPadding(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public End(@NotNull AnchorPosition anchorPosition) {
            Intrinsics.checkNotNullParameter(anchorPosition, "anchorPosition");
            this.c = anchorPosition;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0012\u0010\nR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TailPositions$Start;", "Lcom/avito/android/lib/design/tooltip/BaseTailPosition;", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "", "minPadding", "setTailMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/TailPositions$Start;", Tracker.Events.CREATIVE_START, "end", "calculateDefaultTailPosition", "(II)I", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", "calculateDefaultAnchorPosition", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "innerMinPadding", "c", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "anchorPosition", "<init>", "(Lcom/avito/android/lib/design/tooltip/AnchorPosition;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Start extends BaseTailPosition implements AnchorPosition {
        public Integer b;
        public final AnchorPosition c;

        public Start() {
            this(null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Start(AnchorPosition anchorPosition, int i, j jVar) {
            this((i & 1) != 0 ? new AnchorPositions.Start() : anchorPosition);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return this.c.calculateDefaultAnchorPosition(i, i2);
        }

        @Override // com.avito.android.lib.design.tooltip.TailPosition
        public int calculateDefaultTailPosition(int i, int i2) {
            int tailHeight = getTailHeight() + i;
            Integer num = this.b;
            int intValue = tailHeight + (num != null ? num.intValue() : 0);
            return intValue <= i2 ? intValue : a.R1(i2, i, 2, i);
        }

        @Override // com.avito.android.lib.design.tooltip.BaseTailPosition, com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            super.init(context, i, i2);
            this.c.init(context, i, i2);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Tooltip, i, i2);
            if (this.b == null) {
                this.b = Integer.valueOf(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tooltip_tooltip_tailMinPadding, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @NotNull
        public final Start setTailMinPadding(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public Start(@NotNull AnchorPosition anchorPosition) {
            Intrinsics.checkNotNullParameter(anchorPosition, "anchorPosition");
            this.c = anchorPosition;
        }
    }
}
