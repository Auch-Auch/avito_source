package a2.j.e.b.a.a;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.internal.zzb;
import com.google.firebase.analytics.connector.internal.zze;
public final class b implements AppMeasurementSdk.OnEventListener {
    public final /* synthetic */ zze a;

    public b(zze zze) {
        this.a = zze;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzhf
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (this.a.a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzb.zze(str2));
            this.a.b.onMessageTriggered(2, bundle2);
        }
    }
}
