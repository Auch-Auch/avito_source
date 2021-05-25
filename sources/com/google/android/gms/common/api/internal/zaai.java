package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zaj;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
public final class zaai extends zaan {
    public final /* synthetic */ zaad zaa;
    private final Map<Api.Client, zaaf> zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaai(zaad zaad, Map<Api.Client, zaaf> map) {
        super(zaad, null);
        this.zaa = zaad;
        this.zab = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaan
    @GuardedBy("mLock")
    @WorkerThread
    public final void zaa() {
        zaj zaj = new zaj(zaad.zab(this.zaa));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.zab.keySet()) {
            if (!client.requiresGooglePlayServices() || (this.zab.get(client).zac)) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = -1;
        int i2 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                i = zaj.zaa(zaad.zaa(this.zaa), (Api.Client) obj);
                if (i == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i2 < size2) {
                Object obj2 = arrayList.get(i2);
                i2++;
                i = zaj.zaa(zaad.zaa(this.zaa), (Api.Client) obj2);
                if (i != 0) {
                    break;
                }
            }
        }
        if (i != 0) {
            zaad.zad(this.zaa).zaa(new zaah(this, this.zaa, new ConnectionResult(i, null)));
            return;
        }
        if (zaad.zae(this.zaa) && zaad.zaf(this.zaa) != null) {
            zaad.zaf(this.zaa).zab();
        }
        for (Api.Client client2 : this.zab.keySet()) {
            zaaf zaaf = this.zab.get(client2);
            if (!client2.requiresGooglePlayServices() || zaj.zaa(zaad.zaa(this.zaa), client2) == 0) {
                client2.connect(zaaf);
            } else {
                zaad.zad(this.zaa).zaa(new zaak(this, this.zaa, zaaf));
            }
        }
    }
}
