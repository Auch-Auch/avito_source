package com.avito.android.util;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\t\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/DataDirectoryProviderFactory;", "", "Lcom/avito/android/util/BuildInfo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/DataDirectoryProvider;", "getDataDirectoryProvider", "()Lcom/avito/android/util/DataDirectoryProvider;", "dataDirectoryProvider", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/BuildInfo;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class DataDirectoryProviderFactory {
    public final Context a;
    public final BuildInfo b;

    public DataDirectoryProviderFactory(@NotNull Context context, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = context;
        this.b = buildInfo;
    }

    @NotNull
    public final DataDirectoryProvider getDataDirectoryProvider() {
        if (this.b.getSdkVersion() >= 24) {
            return new NougatDataDirectoryProvider(this.a);
        }
        return new PreNougatDataDirectoryProvider(this.a);
    }
}
