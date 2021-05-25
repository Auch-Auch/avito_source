package com.avito.android.user_stats.tab.list.items.blueprints.chart;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UniversalColor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/chart/BarItemPayload;", "", "", AuthSource.SEND_ABUSE, "Z", "isSelected", "()Z", "Lcom/avito/android/remote/model/UniversalColor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/UniversalColor;", "getColor", "()Lcom/avito/android/remote/model/UniversalColor;", "color", "<init>", "(ZLcom/avito/android/remote/model/UniversalColor;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemPayload {
    public final boolean a;
    @NotNull
    public final UniversalColor b;

    public BarItemPayload(boolean z, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        this.a = z;
        this.b = universalColor;
    }

    @NotNull
    public final UniversalColor getColor() {
        return this.b;
    }

    public final boolean isSelected() {
        return this.a;
    }
}
