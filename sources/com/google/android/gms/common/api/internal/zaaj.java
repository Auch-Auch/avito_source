package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
public final class zaaj extends zaan {
    private final ArrayList<Api.Client> zaa;
    private final /* synthetic */ zaad zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaaj(zaad zaad, ArrayList<Api.Client> arrayList) {
        super(zaad, null);
        this.zab = zaad;
        this.zaa = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaan
    @WorkerThread
    public final void zaa() {
        zaad.zad(this.zab).zad.zac = zaad.zag(this.zab);
        ArrayList<Api.Client> arrayList = this.zaa;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.Client client = arrayList.get(i);
            i++;
            client.getRemoteService(zaad.zah(this.zab), zaad.zad(this.zab).zad.zac);
        }
    }
}
