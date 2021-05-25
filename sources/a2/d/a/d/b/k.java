package a2.d.a.d.b;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;
public class k implements Key {
    public final Object a;
    public final int b;
    public final int c;
    public final Class<?> d;
    public final Class<?> e;
    public final Key f;
    public final Map<Class<?>, Transformation<?>> g;
    public final Options h;
    public int i;

    public k(Object obj, Key key, int i2, int i3, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.a = Preconditions.checkNotNull(obj);
        this.f = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.b = i2;
        this.c = i3;
        this.g = (Map) Preconditions.checkNotNull(map);
        this.d = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.e = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.h = (Options) Preconditions.checkNotNull(options);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!this.a.equals(kVar.a) || !this.f.equals(kVar.f) || this.c != kVar.c || this.b != kVar.b || !this.g.equals(kVar.g) || !this.d.equals(kVar.d) || !this.e.equals(kVar.e) || !this.h.equals(kVar.h)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.i == 0) {
            int hashCode = this.a.hashCode();
            this.i = hashCode;
            int hashCode2 = this.f.hashCode() + (hashCode * 31);
            this.i = hashCode2;
            int i2 = (hashCode2 * 31) + this.b;
            this.i = i2;
            int i3 = (i2 * 31) + this.c;
            this.i = i3;
            int hashCode3 = this.g.hashCode() + (i3 * 31);
            this.i = hashCode3;
            int hashCode4 = this.d.hashCode() + (hashCode3 * 31);
            this.i = hashCode4;
            int hashCode5 = this.e.hashCode() + (hashCode4 * 31);
            this.i = hashCode5;
            this.i = this.h.hashCode() + (hashCode5 * 31);
        }
        return this.i;
    }

    public String toString() {
        StringBuilder L = a.L("EngineKey{model=");
        L.append(this.a);
        L.append(", width=");
        L.append(this.b);
        L.append(", height=");
        L.append(this.c);
        L.append(", resourceClass=");
        L.append(this.d);
        L.append(", transcodeClass=");
        L.append(this.e);
        L.append(", signature=");
        L.append(this.f);
        L.append(", hashCode=");
        L.append(this.i);
        L.append(", transformations=");
        L.append(this.g);
        L.append(", options=");
        L.append(this.h);
        L.append('}');
        return L.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
