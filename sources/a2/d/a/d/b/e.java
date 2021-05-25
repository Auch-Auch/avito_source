package a2.d.a.d.b;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
public final class e implements Key {
    public final Key a;
    public final Key b;

    public e(Key key, Key key2) {
        this.a = key;
        this.b = key2;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.a.equals(eVar.a) || !this.b.equals(eVar.b)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder L = a.L("DataCacheKey{sourceKey=");
        L.append(this.a);
        L.append(", signature=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.a.updateDiskCacheKey(messageDigest);
        this.b.updateDiskCacheKey(messageDigest);
    }
}
