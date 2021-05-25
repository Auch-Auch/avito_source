package com.avito.android.serp.ad;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/serp/ad/AdEventListenerHolder;", "", "Lcom/avito/android/serp/ad/AdEventListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setAdEventListener", "(Lcom/avito/android/serp/ad/AdEventListener;)V", "getAdEventListener", "()Lcom/avito/android/serp/ad/AdEventListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/ad/AdEventListener;", "adEventListener", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdEventListenerHolder {
    public AdEventListener a;

    @Nullable
    public final AdEventListener getAdEventListener() {
        return this.a;
    }

    public final void setAdEventListener(@NotNull AdEventListener adEventListener) {
        Intrinsics.checkNotNullParameter(adEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = adEventListener;
    }
}
