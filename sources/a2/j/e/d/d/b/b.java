package a2.j.e.d.d.b;

import com.google.firebase.crashlytics.internal.log.QueueFile;
import java.io.IOException;
import java.io.InputStream;
public class b implements QueueFile.ElementReader {
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ int[] b;

    public b(c cVar, byte[] bArr, int[] iArr) {
        this.a = bArr;
        this.b = iArr;
    }

    @Override // com.google.firebase.crashlytics.internal.log.QueueFile.ElementReader
    public void read(InputStream inputStream, int i) throws IOException {
        try {
            inputStream.read(this.a, this.b[0], i);
            int[] iArr = this.b;
            iArr[0] = iArr[0] + i;
        } finally {
            inputStream.close();
        }
    }
}
