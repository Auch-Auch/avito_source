package a2.d.a.d.b;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
public final class o<Z> implements Resource<Z>, FactoryPools.Poolable {
    public static final Pools.Pool<o<?>> e = FactoryPools.threadSafe(20, new a());
    public final StateVerifier a = StateVerifier.newInstance();
    public Resource<Z> b;
    public boolean c;
    public boolean d;

    public class a implements FactoryPools.Factory<o<?>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public o<?> create() {
            return new o<>();
        }
    }

    @NonNull
    public static <Z> o<Z> a(Resource<Z> resource) {
        o<Z> oVar = (o) Preconditions.checkNotNull(e.acquire());
        oVar.d = false;
        oVar.c = true;
        oVar.b = resource;
        return oVar;
    }

    public synchronized void b() {
        this.a.throwIfRecycled();
        if (this.c) {
            this.c = false;
            if (this.d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.b.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        return this.b.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.b.getSize();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        this.a.throwIfRecycled();
        this.d = true;
        if (!this.c) {
            this.b.recycle();
            this.b = null;
            e.release(this);
        }
    }
}
