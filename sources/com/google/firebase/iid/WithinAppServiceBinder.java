package com.google.firebase.iid;

import a2.j.e.i.f;
import a2.j.e.i.g;
import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.WithinAppServiceBinder;
import com.google.firebase.iid.WithinAppServiceConnection;
import java.util.concurrent.Executor;
@KeepForSdk
public class WithinAppServiceBinder extends Binder {
    public static final /* synthetic */ int b = 0;
    public final IntentHandler a;

    public interface IntentHandler {
        @KeepForSdk
        Task<Void> handle(Intent intent);
    }

    @KeepForSdk
    public WithinAppServiceBinder(IntentHandler intentHandler) {
        this.a = intentHandler;
    }

    public void a(WithinAppServiceConnection.a aVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            Log.isLoggable("FirebaseInstanceId", 3);
            Task<Void> handle = this.a.handle(aVar.a);
            Executor executor = g.a;
            handle.addOnCompleteListener(f.a, new OnCompleteListener(aVar) { // from class: a2.j.e.i.k0
                public final WithinAppServiceConnection.a a;

                {
                    this.a = r1;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    WithinAppServiceConnection.a aVar2 = this.a;
                    int i = WithinAppServiceBinder.b;
                    aVar2.a();
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
