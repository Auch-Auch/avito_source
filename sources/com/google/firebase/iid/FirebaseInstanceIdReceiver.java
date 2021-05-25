package com.google.firebase.iid;

import a2.j.e.i.a;
import a2.j.e.i.g;
import a2.j.e.i.q;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.util.concurrent.ExecutorService;
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final ExecutorService a = g.a();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(@NonNull Context context, @NonNull Intent intent) {
        a aVar;
        if (intent != null) {
            Intent unwrapServiceIntent = ServiceStarter.unwrapServiceIntent(intent);
            if (unwrapServiceIntent != null) {
                intent = unwrapServiceIntent;
            }
            intent.setComponent(null);
            intent.setPackage(context.getPackageName());
            if ("google.com/iid".equals(intent.getStringExtra("from"))) {
                aVar = new q(this.a);
            } else {
                aVar = new FcmBroadcastProcessor(context, this.a);
            }
            aVar.process(intent).addOnCompleteListener(this.a, new OnCompleteListener(isOrderedBroadcast(), goAsync()) { // from class: a2.j.e.i.n
                public final boolean a;
                public final BroadcastReceiver.PendingResult b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    boolean z = this.a;
                    BroadcastReceiver.PendingResult pendingResult = this.b;
                    int i = FirebaseInstanceIdReceiver.b;
                    if (z) {
                        pendingResult.setResultCode(task.isSuccessful() ? ((Integer) task.getResult()).intValue() : 500);
                    }
                    pendingResult.finish();
                }
            });
        }
    }
}
