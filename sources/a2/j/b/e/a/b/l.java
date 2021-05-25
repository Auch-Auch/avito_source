package a2.j.b.e.a.b;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
public final class l extends k<ParcelFileDescriptor> {
    public l(r rVar, i<ParcelFileDescriptor> iVar) {
        super(rVar, iVar);
    }

    @Override // a2.j.b.e.a.b.k, com.google.android.play.core.internal.u
    public final void b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.b.c.a();
        r.f.c("onGetChunkFileDescriptor", new Object[0]);
        this.a.b((i<T>) ((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor")));
    }
}
