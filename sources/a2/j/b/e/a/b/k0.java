package a2.j.b.e.a.b;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.ce;
import com.google.android.play.core.tasks.Tasks;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
public final class k0 {
    public final ce<q2> a;

    public k0(ce<q2> ceVar) {
        this.a = ceVar;
    }

    public final InputStream a(int i, String str, String str2, int i2) {
        try {
            return new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor) Tasks.await(this.a.a().a(i, str, str2, i2)));
        } catch (ExecutionException e) {
            throw new q0(String.format("Error opening chunk file, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i), str, str2, Integer.valueOf(i2)), e, i);
        } catch (InterruptedException e2) {
            throw new q0("Extractor was interrupted while waiting for chunk file.", e2, i);
        }
    }
}
