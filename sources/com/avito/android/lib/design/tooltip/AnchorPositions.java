package com.avito.android.lib.design.tooltip;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/avito/android/lib/design/tooltip/AnchorPositions;", "", "<init>", "()V", "Center", "End", "Start", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AnchorPositions {
    @NotNull
    public static final AnchorPositions INSTANCE = new AnchorPositions();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/tooltip/AnchorPositions$Center;", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Center implements AnchorPosition {
        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            return a.R1(i2, i, 2, i);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/design/tooltip/AnchorPositions$End;", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "", "minPadding", "setAnchorMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/AnchorPositions$End;", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "innerMinPadding", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class End implements AnchorPosition {
        public Integer a;

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            Integer num = this.a;
            return i2 - (num != null ? num.intValue() : 0);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Tooltip, i, i2);
            if (this.a == null) {
                this.a = Integer.valueOf(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tooltip_tooltip_anchorMinPadding, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @NotNull
        public final End setAnchorMinPadding(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/design/tooltip/AnchorPositions$Start;", "Lcom/avito/android/lib/design/tooltip/AnchorPosition;", "", "minPadding", "setAnchorMinPadding", "(I)Lcom/avito/android/lib/design/tooltip/AnchorPositions$Start;", Tracker.Events.CREATIVE_START, "end", "calculateDefaultAnchorPosition", "(II)I", "Landroid/content/Context;", "context", "defStyleAttr", "defStyleRes", "", "init", "(Landroid/content/Context;II)V", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "innerMinPadding", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Start implements AnchorPosition {
        public Integer a;

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public int calculateDefaultAnchorPosition(int i, int i2) {
            Integer num = this.a;
            return i + (num != null ? num.intValue() : 0);
        }

        @Override // com.avito.android.lib.design.tooltip.AnchorPosition
        public void init(@NotNull Context context, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.Tooltip, i, i2);
            if (this.a == null) {
                this.a = Integer.valueOf(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Tooltip_tooltip_anchorMinPadding, 0));
            }
            obtainStyledAttributes.recycle();
        }

        @NotNull
        public final Start setAnchorMinPadding(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }
    }
}
