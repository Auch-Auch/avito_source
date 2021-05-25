package a2.j.b.e.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;
import java.util.List;
public class k<T> extends t {
    public final i<T> a;
    public final /* synthetic */ r b;

    public k(r rVar, i<T> iVar) {
        this.b = rVar;
        this.a = iVar;
    }

    public k(r rVar, i iVar, byte[] bArr) {
        this.b = rVar;
        this.a = iVar;
    }

    @Override // com.google.android.play.core.internal.u
    public void a() {
        this.b.c.a();
        r.f.c("onCancelDownloads()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.u
    public void b() {
        this.b.c.a();
        r.f.c("onRemoveModule()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.u
    public void c(Bundle bundle) {
        this.b.c.a();
        r.f.c("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID)));
    }

    @Override // com.google.android.play.core.internal.u
    public void d(Bundle bundle) {
        this.b.c.a();
        r.f.c("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID)));
    }

    public k(r rVar, i iVar, char[] cArr) {
        this.b = rVar;
        this.a = iVar;
    }

    public k(r rVar, i iVar, int[] iArr) {
        this.b = rVar;
        this.a = iVar;
    }

    public k(r rVar, i iVar, short[] sArr) {
        this.b = rVar;
        this.a = iVar;
    }

    @Override // com.google.android.play.core.internal.u
    public final void a(int i) {
        this.b.c.a();
        r.f.c("onCancelDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.u
    public final void b(int i) {
        this.b.c.a();
        r.f.c("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.u
    public void c(Bundle bundle, Bundle bundle2) {
        this.b.c.a();
        r.f.c("onRequestDownloadInfo()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.u
    public void a(int i, Bundle bundle) {
        this.b.c.a();
        r.f.c("onStartDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.u
    public void b(Bundle bundle) {
        this.b.c.a();
        r.f.c("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt(SDKAnalyticsEvents.PARAMETER_SESSION_ID)));
    }

    @Override // com.google.android.play.core.internal.u
    public void a(Bundle bundle) {
        this.b.c.a();
        int i = bundle.getInt("error_code");
        r.f.b("onError(%d)", Integer.valueOf(i));
        this.a.b(new AssetPackException(i));
    }

    @Override // com.google.android.play.core.internal.u
    public void b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.b.c.a();
        r.f.c("onGetChunkFileDescriptor", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.u
    public void a(Bundle bundle, Bundle bundle2) {
        this.b.d.a();
        r.f.c("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    @Override // com.google.android.play.core.internal.u
    public void a(List<Bundle> list) {
        this.b.c.a();
        r.f.c("onGetSessionStates", new Object[0]);
    }
}
