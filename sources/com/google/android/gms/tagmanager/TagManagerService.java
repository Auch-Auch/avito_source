package com.google.android.gms.tagmanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepName;
@KeepName
public class TagManagerService extends Service {
    @Keep
    @WorkerThread
    @KeepName
    public static void initialize(Context context) {
        zzbf.zzi(context);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return zzbf.zzh(this);
    }
}
