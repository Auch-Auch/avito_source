package com.avito.android.serp.adapter;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012j\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/avito/android/serp/adapter/LayoutType;", "", "", "getColumnCount", "()I", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "(Lcom/avito/android/serp/adapter/SerpViewType;)I", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "getName", "(Lcom/avito/android/remote/model/SerpDisplayType;)Ljava/lang/String;", InternalConstsKt.FIRST_IMAGE, "second", AuthSource.SEND_ABUSE, "(II)I", "c", "I", "listCountInRow", "d", "gridCountInRow", "e", "bigCountInRow", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "namePrefix", "columnCount", "<init>", "(Ljava/lang/String;ILjava/lang/String;III)V", "NARROW", "MIDDLE", "WIDE", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public enum LayoutType {
    NARROW("narrow", 1, 2, 1),
    MIDDLE("mid", 2, 3, 2),
    WIDE("wide", 2, 5, 3);
    
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            SerpViewType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
            SerpDisplayType.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            SerpDisplayType serpDisplayType = SerpDisplayType.Grid;
            iArr2[0] = 1;
            SerpDisplayType serpDisplayType2 = SerpDisplayType.List;
            iArr2[1] = 2;
            SerpDisplayType serpDisplayType3 = SerpDisplayType.Rich;
            iArr2[2] = 3;
            SerpDisplayType serpDisplayType4 = SerpDisplayType.Vacancy;
            iArr2[3] = 4;
        }
    }

    /* access modifiers changed from: public */
    LayoutType(String str, int i, int i2, int i3) {
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.a = a(i, a(i2, i3));
    }

    public final int a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("first and second arguments must be greater than zero");
        }
        int i3 = i * i2;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("first and second arguments must be greater than zero");
        }
        while (true) {
            i = i2;
            if (i <= 0) {
                return i3 / i;
            }
            i2 = i % i;
        }
    }

    public final int getColumnCount() {
        return this.a;
    }

    @NotNull
    public final String getName(@NotNull SerpDisplayType serpDisplayType) {
        String str;
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        int ordinal = serpDisplayType.ordinal();
        if (ordinal == 0) {
            str = "Grid";
        } else if (ordinal == 1) {
            str = "List";
        } else if (ordinal == 2) {
            str = "Rich";
        } else if (ordinal == 3) {
            str = "Vacancy";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return a.t(new StringBuilder(), this.b, str);
    }

    public final int getColumnCount(@NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        int ordinal = serpViewType.ordinal();
        if (ordinal == 0) {
            return this.a / this.c;
        }
        if (ordinal == 1) {
            return this.a / this.d;
        }
        if (ordinal == 2) {
            return this.a / this.e;
        }
        if (ordinal == 3) {
            return this.a;
        }
        throw new NoWhenBranchMatchedException();
    }
}
