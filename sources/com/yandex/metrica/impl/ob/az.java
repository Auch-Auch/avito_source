package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.yandex.metrica.IMetricaService;
public interface az {
    bn a();

    void a(IMetricaService iMetricaService, aa aaVar, co coVar) throws RemoteException;

    void a(@NonNull IMetricaService iMetricaService, @NonNull eu euVar) throws RemoteException;

    Context b();

    void b(@NonNull IMetricaService iMetricaService, @NonNull eu euVar) throws RemoteException;
}
