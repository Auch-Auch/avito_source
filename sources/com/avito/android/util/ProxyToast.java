package com.avito.android.util;

import android.widget.Toast;
import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/util/ProxyToast;", "", "Landroid/widget/Toast;", "toast", "", "show", "(Landroid/widget/Toast;)V", "Companion", "proxy-toast_release"}, k = 1, mv = {1, 4, 2})
public interface ProxyToast {
    @NotNull
    public static final Companion Companion = Companion.b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\nR(\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/util/ProxyToast$Companion;", "", "Lcom/avito/android/util/ProxyToast;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/ProxyToast;", "getInstance", "()Lcom/avito/android/util/ProxyToast;", "setInstance", "(Lcom/avito/android/util/ProxyToast;)V", "getInstance$annotations", "()V", "instance", "<init>", "proxy-toast_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static ProxyToast a = new PlatformProxyToast();
        public static final /* synthetic */ Companion b = new Companion();

        @VisibleForTesting
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final ProxyToast getInstance() {
            return a;
        }

        public final void setInstance(@NotNull ProxyToast proxyToast) {
            Intrinsics.checkNotNullParameter(proxyToast, "<set-?>");
            a = proxyToast;
        }
    }

    void show(@NotNull Toast toast);
}
