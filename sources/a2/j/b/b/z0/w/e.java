package a2.j.b.b.z0.w;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedHashMap;
import java.util.Map;
public final class e {
    public final LinkedHashMap<Uri, byte[]> a;

    public class a extends LinkedHashMap<Uri, byte[]> {
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, float f, boolean z, int i2) {
            super(i, f, z);
            this.a = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
            return size() > this.a;
        }
    }

    public e(int i) {
        this.a = new a(i + 1, 1.0f, false, i);
    }

    @Nullable
    public byte[] a(Uri uri, byte[] bArr) {
        return this.a.put((Uri) Assertions.checkNotNull(uri), (byte[]) Assertions.checkNotNull(bArr));
    }
}
