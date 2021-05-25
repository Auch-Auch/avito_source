package a2.d.a.d.b;

import a2.d.a.d.b.h;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public final class g<Transcode> {
    public final List<ModelLoader.LoadData<?>> a = new ArrayList();
    public final List<Key> b = new ArrayList();
    public GlideContext c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public h.d h;
    public Options i;
    public Map<Class<?>, Transformation<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public Key n;
    public Priority o;
    public DiskCacheStrategy p;
    public boolean q;
    public boolean r;

    public List<Key> a() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<ModelLoader.LoadData<?>> c2 = c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData<?> loadData = c2.get(i2);
                if (!this.b.contains(loadData.sourceKey)) {
                    this.b.add(loadData.sourceKey);
                }
                for (int i3 = 0; i3 < loadData.alternateKeys.size(); i3++) {
                    if (!this.b.contains(loadData.alternateKeys.get(i3))) {
                        this.b.add(loadData.alternateKeys.get(i3));
                    }
                }
            }
        }
        return this.b;
    }

    public DiskCache b() {
        return ((Engine.c) this.h).a();
    }

    public List<ModelLoader.LoadData<?>> c() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            List modelLoaders = this.c.getRegistry().getModelLoaders(this.d);
            int size = modelLoaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader.LoadData<?> buildLoadData = ((ModelLoader) modelLoaders.get(i2)).buildLoadData(this.d, this.e, this.f, this.i);
                if (buildLoadData != null) {
                    this.a.add(buildLoadData);
                }
            }
        }
        return this.a;
    }

    public <Z> Transformation<Z> d(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation<Z>) this.j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation<Z>) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.j.isEmpty() || !this.q) {
            return UnitTransformation.get();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public boolean e(Class<?> cls) {
        return this.c.getRegistry().getLoadPath(cls, this.g, this.k) != null;
    }
}
