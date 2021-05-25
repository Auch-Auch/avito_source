package com.avito.android.lib.design.promo_block.grouping;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/promo_block/grouping/GroupingOutput;", "", "Lcom/avito/android/lib/design/promo_block/grouping/EdgeMode;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/promo_block/grouping/EdgeMode;", "getTopEdge$components_release", "()Lcom/avito/android/lib/design/promo_block/grouping/EdgeMode;", "setTopEdge$components_release", "(Lcom/avito/android/lib/design/promo_block/grouping/EdgeMode;)V", "topEdge", AuthSource.BOOKING_ORDER, "getBottomEdge$components_release", "setBottomEdge$components_release", "bottomEdge", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingOutput {
    @NotNull
    public EdgeMode a;
    @NotNull
    public EdgeMode b;

    public GroupingOutput() {
        EdgeMode edgeMode = EdgeMode.ROUNDED;
        this.a = edgeMode;
        this.b = edgeMode;
    }

    @NotNull
    public final EdgeMode getBottomEdge$components_release() {
        return this.b;
    }

    @NotNull
    public final EdgeMode getTopEdge$components_release() {
        return this.a;
    }

    public final void setBottomEdge$components_release(@NotNull EdgeMode edgeMode) {
        Intrinsics.checkNotNullParameter(edgeMode, "<set-?>");
        this.b = edgeMode;
    }

    public final void setTopEdge$components_release(@NotNull EdgeMode edgeMode) {
        Intrinsics.checkNotNullParameter(edgeMode, "<set-?>");
        this.a = edgeMode;
    }
}
