package a2.j.e.f.a;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.dynamiclinks.internal.zzo;
public final class c extends d {
    public final TaskCompletionSource<ShortDynamicLink> a;

    public c(TaskCompletionSource<ShortDynamicLink> taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // a2.j.e.f.a.d, com.google.firebase.dynamiclinks.internal.zzk
    public final void zza(Status status, zzo zzo) {
        TaskUtil.setResultOrApiException(status, zzo, this.a);
    }
}
