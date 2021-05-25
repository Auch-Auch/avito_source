package com.avito.android.lib.expected.badge_bar;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0006¨\u0006!"}, d2 = {"Lcom/avito/android/lib/expected/badge_bar/FlexibleLine;", "", "", FirebaseAnalytics.Param.INDEX, "", ProductAction.ACTION_ADD, "(I)V", "", "isEmpty", "()Z", "isNotEmpty", "clear", "()V", AuthSource.BOOKING_ORDER, "I", "getHeight", "()I", "setHeight", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "c", "Ljava/util/List;", "getIndices", "()Ljava/util/List;", "setIndices", "(Ljava/util/List;)V", "indices", AuthSource.SEND_ABUSE, "getWidth", "setWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "<init>", "(IILjava/util/List;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class FlexibleLine {
    public int a;
    public int b;
    @NotNull
    public List<Integer> c;

    public FlexibleLine() {
        this(0, 0, null, 7, null);
    }

    public FlexibleLine(int i, int i2, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "indices");
        this.a = i;
        this.b = i2;
        this.c = list;
    }

    public final void add(int i) {
        this.c.add(Integer.valueOf(i));
    }

    public final void clear() {
        this.a = 0;
        this.b = 0;
        this.c.clear();
    }

    public final int getHeight() {
        return this.b;
    }

    @NotNull
    public final List<Integer> getIndices() {
        return this.c;
    }

    public final int getWidth() {
        return this.a;
    }

    public final boolean isEmpty() {
        return this.a == 0;
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    public final void setHeight(int i) {
        this.b = i;
    }

    public final void setIndices(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.c = list;
    }

    public final void setWidth(int i) {
        this.a = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlexibleLine(int i, int i2, List list, int i3, j jVar) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? new ArrayList() : list);
    }
}
