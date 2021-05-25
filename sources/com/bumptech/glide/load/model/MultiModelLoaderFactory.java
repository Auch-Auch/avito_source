package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
public class MultiModelLoaderFactory {
    public static final c e = new c();
    public static final ModelLoader<Object, Object> f = new a();
    public final List<b<?, ?>> a = new ArrayList();
    public final c b;
    public final Set<b<?, ?>> c = new HashSet();
    public final Pools.Pool<List<Throwable>> d;

    public static class a implements ModelLoader<Object, Object> {
        @Override // com.bumptech.glide.load.model.ModelLoader
        @Nullable
        public ModelLoader.LoadData<Object> buildLoadData(@NonNull Object obj, int i, int i2, @NonNull Options options) {
            return null;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean handles(@NonNull Object obj) {
            return false;
        }
    }

    public static class b<Model, Data> {
        public final Class<Model> a;
        public final Class<Data> b;
        public final ModelLoaderFactory<? extends Model, ? extends Data> c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.a = cls;
            this.b = cls2;
            this.c = modelLoaderFactory;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && this.b.isAssignableFrom(cls2);
        }
    }

    public static class c {
    }

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        c cVar = e;
        this.d = pool;
        this.b = cVar;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        b<?, ?> bVar = new b<>(cls, cls2, modelLoaderFactory);
        List<b<?, ?>> list = this.a;
        list.add(list.size(), bVar);
    }

    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> b(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.a) {
                if (!this.c.contains(bVar)) {
                    if (bVar.a.isAssignableFrom(cls)) {
                        this.c.add(bVar);
                        arrayList.add((ModelLoader) Preconditions.checkNotNull(bVar.c.build(this)));
                        this.c.remove(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.c.add(bVar);
                    arrayList.add((ModelLoader) Preconditions.checkNotNull(bVar.c.build(this)));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                c cVar = this.b;
                Pools.Pool<List<Throwable>> pool = this.d;
                Objects.requireNonNull(cVar);
                return new a2.d.a.d.c.a(arrayList, pool);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return (ModelLoader<Model, Data>) f;
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a.isAssignableFrom(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.a(cls, cls2)) {
                it.remove();
                arrayList.add(next.c);
            }
        }
        return arrayList;
    }
}
