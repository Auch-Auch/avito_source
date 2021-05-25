package com.avito.android.util;

import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/util/PlatformProxyToast;", "Lcom/avito/android/util/ProxyToast;", "Landroid/widget/Toast;", "toast", "", "show", "(Landroid/widget/Toast;)V", "<init>", "()V", "proxy-toast_release"}, k = 1, mv = {1, 4, 2})
public class PlatformProxyToast implements ProxyToast {
    @Override // com.avito.android.util.ProxyToast
    public void show(@NotNull Toast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        toast.show();
    }
}
