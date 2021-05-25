package a2.j.e.f.a;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;
public final class e extends d {
    public final TaskCompletionSource<PendingDynamicLinkData> a;
    @Nullable
    public final AnalyticsConnector b;

    public e(AnalyticsConnector analyticsConnector, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) {
        this.b = analyticsConnector;
        this.a = taskCompletionSource;
    }

    @Override // a2.j.e.f.a.d, com.google.firebase.dynamiclinks.internal.zzk
    public final void zza(Status status, DynamicLinkData dynamicLinkData) {
        Bundle bundle;
        TaskUtil.setResultOrApiException(status, dynamicLinkData == null ? null : new PendingDynamicLinkData(dynamicLinkData), this.a);
        if (!(dynamicLinkData == null || (bundle = dynamicLinkData.zzf().getBundle("scionData")) == null || bundle.keySet() == null || this.b == null)) {
            for (String str : bundle.keySet()) {
                this.b.logEvent("fdl", str, bundle.getBundle(str));
            }
        }
    }
}
