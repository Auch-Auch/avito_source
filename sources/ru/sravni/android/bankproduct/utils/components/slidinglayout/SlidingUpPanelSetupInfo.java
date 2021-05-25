package ru.sravni.android.bankproduct.utils.components.slidinglayout;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;", "", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "applyButtonTextResId", "cancelButtonTextResId", "applyButtonTextWithCountResId", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getApplyButtonTextResId", "c", "getCancelButtonTextResId", "d", "getApplyButtonTextWithCountResId", AuthSource.SEND_ABUSE, "Z", "isEmpty", "()Z", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SlidingUpPanelSetupInfo {
    public final boolean a;
    @Nullable
    public final Integer b;
    @Nullable
    public final Integer c;
    @Nullable
    public final Integer d;

    public SlidingUpPanelSetupInfo() {
        this(null, null, null, 7, null);
    }

    public SlidingUpPanelSetupInfo(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.b = num;
        this.c = num2;
        this.d = num3;
        this.a = num == null && num2 == null && num3 == null;
    }

    public static /* synthetic */ SlidingUpPanelSetupInfo copy$default(SlidingUpPanelSetupInfo slidingUpPanelSetupInfo, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = slidingUpPanelSetupInfo.b;
        }
        if ((i & 2) != 0) {
            num2 = slidingUpPanelSetupInfo.c;
        }
        if ((i & 4) != 0) {
            num3 = slidingUpPanelSetupInfo.d;
        }
        return slidingUpPanelSetupInfo.copy(num, num2, num3);
    }

    @Nullable
    public final Integer component1() {
        return this.b;
    }

    @Nullable
    public final Integer component2() {
        return this.c;
    }

    @Nullable
    public final Integer component3() {
        return this.d;
    }

    @NotNull
    public final SlidingUpPanelSetupInfo copy(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return new SlidingUpPanelSetupInfo(num, num2, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SlidingUpPanelSetupInfo)) {
            return false;
        }
        SlidingUpPanelSetupInfo slidingUpPanelSetupInfo = (SlidingUpPanelSetupInfo) obj;
        return Intrinsics.areEqual(this.b, slidingUpPanelSetupInfo.b) && Intrinsics.areEqual(this.c, slidingUpPanelSetupInfo.c) && Intrinsics.areEqual(this.d, slidingUpPanelSetupInfo.d);
    }

    @Nullable
    public final Integer getApplyButtonTextResId() {
        return this.b;
    }

    @Nullable
    public final Integer getApplyButtonTextWithCountResId() {
        return this.d;
    }

    @Nullable
    public final Integer getCancelButtonTextResId() {
        return this.c;
    }

    public int hashCode() {
        Integer num = this.b;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.c;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.d;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode2 + i;
    }

    public final boolean isEmpty() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SlidingUpPanelSetupInfo(applyButtonTextResId=");
        L.append(this.b);
        L.append(", cancelButtonTextResId=");
        L.append(this.c);
        L.append(", applyButtonTextWithCountResId=");
        return a.p(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SlidingUpPanelSetupInfo(Integer num, Integer num2, Integer num3, int i, j jVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
    }
}
