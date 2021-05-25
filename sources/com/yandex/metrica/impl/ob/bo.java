package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
public interface bo extends bs {
    void a(Bundle bundle);

    @Deprecated
    void a(String str, int i, String str2, Bundle bundle) throws RemoteException;

    void b(@NonNull Bundle bundle);

    void c(@NonNull Bundle bundle);
}
