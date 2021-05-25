package com.avito.android.in_app_calls.logging;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/in_app_calls/logging/LogHeaderProvider;", "", "Lcom/avito/android/in_app_calls/logging/LogHeader;", "provide", "()Lcom/avito/android/in_app_calls/logging/LogHeader;", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/DeviceIdProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/Features;)V", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public final class LogHeaderProvider {
    public final AccountStateProvider a;
    public final DeviceIdProvider b;
    public final BuildInfo c;
    public final Features d;

    @Inject
    public LogHeaderProvider(@NotNull AccountStateProvider accountStateProvider, @NotNull DeviceIdProvider deviceIdProvider, @NotNull BuildInfo buildInfo, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = accountStateProvider;
        this.b = deviceIdProvider;
        this.c = buildInfo;
        this.d = features;
    }

    @NotNull
    public final LogHeader provide() {
        String currentUserId = this.a.getCurrentUserId();
        if (currentUserId == null) {
            currentUserId = "";
        }
        return new LogHeader(currentUserId, this.b.getValue(), "android", this.c.getManufacturer(), this.c.getModel(), this.c.getVersion(), this.c.getSdkVersion(), this.d.getAppVersionName().invoke());
    }
}
