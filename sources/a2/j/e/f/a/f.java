package a2.j.e.f.a;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.dynamiclinks.internal.zzd;
import com.google.firebase.dynamiclinks.internal.zzm;
public final class f extends TaskApiCall<zzd, ShortDynamicLink> {
    public final Bundle a;

    public f(Bundle bundle) {
        this.a = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzd zzd, TaskCompletionSource<ShortDynamicLink> taskCompletionSource) throws RemoteException {
        zzd zzd2 = zzd;
        try {
            ((zzm) zzd2.getService()).zza(new c(taskCompletionSource), this.a);
        } catch (RemoteException unused) {
        }
    }
}
