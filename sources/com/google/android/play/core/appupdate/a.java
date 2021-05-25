package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.listener.b;
public final class a extends b<InstallState> {
    public a(Context context) {
        super(new aa("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    @Override // com.google.android.play.core.listener.b
    public final void a(Context context, Intent intent) {
        if (context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.a.a("List of extras in received intent:", new Object[0]);
            for (String str : intent.getExtras().keySet()) {
                this.a.a("Key: %s; value: %s", str, intent.getExtras().get(str));
            }
            aa aaVar = this.a;
            aaVar.a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
            aaVar.a("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
            aaVar.a("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
            InstallState a = InstallState.a(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0), intent.getLongExtra("total.bytes.to.download", 0), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
            this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            a((a) a);
            return;
        }
        this.a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
    }
}
