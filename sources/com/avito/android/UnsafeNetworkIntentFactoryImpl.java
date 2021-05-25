package com.avito.android;

import android.content.Context;
import android.content.Intent;
import com.avito.android.certificate_pinning.UnsafeNetworkActivity;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/UnsafeNetworkIntentFactoryImpl;", "Lcom/avito/android/UnsafeNetworkIntentFactory;", "Landroid/content/Intent;", "certificateUnsafeNetworkWarningIntent", "()Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public final class UnsafeNetworkIntentFactoryImpl implements UnsafeNetworkIntentFactory {
    public final Context a;

    @Inject
    public UnsafeNetworkIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.UnsafeNetworkIntentFactory
    @NotNull
    public Intent certificateUnsafeNetworkWarningIntent() {
        return new Intent(this.a, UnsafeNetworkActivity.class);
    }
}
