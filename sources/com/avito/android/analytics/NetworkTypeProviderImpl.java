package com.avito.android.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/NetworkTypeProviderImpl;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "", "networkType", "()Ljava/lang/String;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class NetworkTypeProviderImpl implements NetworkTypeProvider {
    public final Context a;

    @Inject
    public NetworkTypeProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.analytics.NetworkTypeProvider
    @SuppressLint({"InlinedApi"})
    @NotNull
    public String networkType() {
        Object systemService = this.a.getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return NetworkType.CLASS_NONE.getStr();
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                    return NetworkType.CLASS_GPRS.getStr();
                case 2:
                case 7:
                    return NetworkType.CLASS_2G_PLUS.getStr();
                case 3:
                case 5:
                case 9:
                case 17:
                    return NetworkType.CLASS_3G.getStr();
                case 4:
                case 11:
                case 16:
                    return NetworkType.CLASS_2G.getStr();
                case 6:
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                    return NetworkType.CLASS_3G_PLUS.getStr();
                case 13:
                    return NetworkType.CLASS_4G.getStr();
                case 18:
                    return NetworkType.CLASS_WIFI.getStr();
                default:
                    return NetworkType.CLASS_UNKNOWN.getStr();
            }
        } else if (type == 1) {
            return NetworkType.CLASS_WIFI.getStr();
        } else {
            if (type != 6) {
                return NetworkType.CLASS_UNKNOWN.getStr();
            }
            return NetworkType.CLASS_4G.getStr();
        }
    }
}
