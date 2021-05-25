package a2.j.e.f.a;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.internal.zzd;
import com.google.firebase.dynamiclinks.internal.zzm;
public final class g extends TaskApiCall<zzd, PendingDynamicLinkData> {
    public final String a;
    @Nullable
    public final AnalyticsConnector b;

    public g(AnalyticsConnector analyticsConnector, String str) {
        this.a = str;
        this.b = analyticsConnector;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzd zzd, TaskCompletionSource<PendingDynamicLinkData> taskCompletionSource) throws RemoteException {
        zzd zzd2 = zzd;
        try {
            ((zzm) zzd2.getService()).zza(new e(this.b, taskCompletionSource), this.a);
        } catch (RemoteException unused) {
        }
    }
}
