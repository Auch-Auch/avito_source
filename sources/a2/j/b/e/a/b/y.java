package a2.j.b.e.a.b;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.assetpacks.AssetPackExtractionService;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.internal.bt;
import com.google.android.play.core.internal.v;
import java.util.Arrays;
public final class y extends v {
    public final aa a = new aa("AssetPackExtractionService");
    public final Context b;
    public final AssetPackExtractionService c;
    public final a0 d;

    public y(Context context, AssetPackExtractionService assetPackExtractionService, a0 a0Var) {
        this.b = context;
        this.c = assetPackExtractionService;
        this.d = a0Var;
    }

    @Override // com.google.android.play.core.internal.w
    public final void a(Bundle bundle, com.google.android.play.core.internal.y yVar) throws RemoteException {
        String[] packagesForUid;
        this.a.a("updateServiceState AIDL call", new Object[0]);
        if (bt.a(this.b) && (packagesForUid = this.b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) != null && Arrays.asList(packagesForUid).contains("com.android.vending")) {
            yVar.a(this.c.a(bundle), new Bundle());
            return;
        }
        yVar.a(new Bundle());
        this.c.b();
    }

    @Override // com.google.android.play.core.internal.w
    public final void a(com.google.android.play.core.internal.y yVar) throws RemoteException {
        a0.n(this.d.x());
        yVar.b(new Bundle());
    }
}
