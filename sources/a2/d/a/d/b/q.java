package a2.d.a.d.b;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
public final class q implements Key {
    public static final LruCache<Class<?>, byte[]> i = new LruCache<>(50);
    public final ArrayPool a;
    public final Key b;
    public final Key c;
    public final int d;
    public final int e;
    public final Class<?> f;
    public final Options g;
    public final Transformation<?> h;

    public q(ArrayPool arrayPool, Key key, Key key2, int i2, int i3, Transformation<?> transformation, Class<?> cls, Options options) {
        this.a = arrayPool;
        this.b = key;
        this.c = key2;
        this.d = i2;
        this.e = i3;
        this.h = transformation;
        this.f = cls;
        this.g = options;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.e != qVar.e || this.d != qVar.d || !Util.bothNullOrEqual(this.h, qVar.h) || !this.f.equals(qVar.f) || !this.b.equals(qVar.b) || !this.c.equals(qVar.c) || !this.g.equals(qVar.g)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int hashCode = ((((this.c.hashCode() + (this.b.hashCode() * 31)) * 31) + this.d) * 31) + this.e;
        Transformation<?> transformation = this.h;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        int hashCode2 = this.f.hashCode();
        return this.g.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public String toString() {
        StringBuilder L = a.L("ResourceCacheKey{sourceKey=");
        L.append(this.b);
        L.append(", signature=");
        L.append(this.c);
        L.append(", width=");
        L.append(this.d);
        L.append(", height=");
        L.append(this.e);
        L.append(", decodedResourceClass=");
        L.append(this.f);
        L.append(", transformation='");
        L.append(this.h);
        L.append('\'');
        L.append(", options=");
        L.append(this.g);
        L.append('}');
        return L.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.a.getExact(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.d).putInt(this.e).array();
        this.c.updateDiskCacheKey(messageDigest);
        this.b.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.h;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.g.updateDiskCacheKey(messageDigest);
        LruCache<Class<?>, byte[]> lruCache = i;
        byte[] bArr2 = lruCache.get(this.f);
        if (bArr2 == null) {
            bArr2 = this.f.getName().getBytes(Key.CHARSET);
            lruCache.put(this.f, bArr2);
        }
        messageDigest.update(bArr2);
        this.a.put(bArr);
    }
}
