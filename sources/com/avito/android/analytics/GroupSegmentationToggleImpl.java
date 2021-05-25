package com.avito.android.analytics;

import com.avito.android.Features;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Strings;
import java.math.BigInteger;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014B\u0019\b\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\u00020\u000e8V@\u0016X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/GroupSegmentationToggleImpl;", "Lcom/avito/android/analytics/GroupSegmentationToggle;", "Lcom/avito/android/remote/DeviceIdProvider;", "c", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "", AuthSource.BOOKING_ORDER, "I", "groupCount", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "isEnabled", "()Z", "<init>", "(ILcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/Features;)V", "(Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/Features;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSegmentationToggleImpl implements GroupSegmentationToggle {
    @NotNull
    public final Lazy a;
    public final int b;
    public final DeviceIdProvider c;
    public final Features d;

    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ GroupSegmentationToggleImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GroupSegmentationToggleImpl groupSegmentationToggleImpl) {
            super(0);
            this.a = groupSegmentationToggleImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            boolean z;
            try {
                if (this.a.d.getScreenLifeCycleEvents().invoke().booleanValue()) {
                    z = true;
                } else {
                    BigInteger md5rawNumber = Strings.md5rawNumber(this.a.c.getValue());
                    BigInteger valueOf = BigInteger.valueOf((long) this.a.b);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "BigInteger.valueOf(this.toLong())");
                    z = Intrinsics.areEqual(md5rawNumber.mod(valueOf), BigInteger.ZERO);
                }
            } catch (Exception unused) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public GroupSegmentationToggleImpl(int i, @NotNull DeviceIdProvider deviceIdProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = i;
        this.c = deviceIdProvider;
        this.d = features;
        this.a = c.lazy(new a(this));
    }

    @Override // com.avito.android.analytics.GroupSegmentationToggle
    public boolean isEnabled() {
        return ((Boolean) this.a.getValue()).booleanValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public GroupSegmentationToggleImpl(@NotNull DeviceIdProvider deviceIdProvider, @NotNull Features features) {
        this(20, deviceIdProvider, features);
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(features, "features");
    }
}
