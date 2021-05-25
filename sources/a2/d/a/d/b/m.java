package a2.d.a.d.b;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
public class m<Z> implements Resource<Z> {
    public final boolean a;
    public final boolean b;
    public final Resource<Z> c;
    public final a d;
    public final Key e;
    public int f;
    public boolean g;

    public interface a {
        void onResourceReleased(Key key, m<?> mVar);
    }

    public m(Resource<Z> resource, boolean z, boolean z2, Key key, a aVar) {
        this.c = (Resource) Preconditions.checkNotNull(resource);
        this.a = z;
        this.b = z2;
        this.e = key;
        this.d = (a) Preconditions.checkNotNull(aVar);
    }

    public synchronized void a() {
        if (!this.g) {
            this.f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public void b() {
        boolean z;
        synchronized (this) {
            int i = this.f;
            if (i > 0) {
                z = true;
                int i2 = i - 1;
                this.f = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.d.onResourceReleased(this.e, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.c.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.c.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.g) {
            this.g = true;
            if (this.b) {
                this.c.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + '}';
    }
}
