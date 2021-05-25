package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ModelLoaderRegistry {
    public final MultiModelLoaderFactory a;
    public final a b = new a();

    public static class a {
        public final Map<Class<?>, C0176a<?>> a = new HashMap();

        /* renamed from: com.bumptech.glide.load.model.ModelLoaderRegistry$a$a  reason: collision with other inner class name */
        public static class C0176a<Model> {
            public final List<ModelLoader<Model, ?>> a;

            public C0176a(List<ModelLoader<Model, ?>> list) {
                this.a = list;
            }
        }
    }

    public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> pool) {
        MultiModelLoaderFactory multiModelLoaderFactory = new MultiModelLoaderFactory(pool);
        this.a = multiModelLoaderFactory;
    }

    public final <Model, Data> void a(@NonNull List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory : list) {
            modelLoaderFactory.teardown();
        }
    }

    public synchronized <Model, Data> void append(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.a.a(cls, cls2, modelLoaderFactory);
        this.b.a.clear();
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.a.build(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> getDataClasses(@NonNull Class<?> cls) {
        return this.a.c(cls);
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> getModelLoaders(@NonNull A a3) {
        List<ModelLoader<Model, ?>> list;
        Class<?> cls = a3.getClass();
        synchronized (this) {
            a.C0176a<?> aVar = this.b.a.get(cls);
            if (aVar == null) {
                list = null;
            } else {
                list = aVar.a;
            }
            if (list == null) {
                list = Collections.unmodifiableList(this.a.b(cls));
                if (this.b.a.put(cls, new a.C0176a<>(list)) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (!list.isEmpty()) {
            int size = list.size();
            List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                ModelLoader<A, ?> modelLoader = (ModelLoader) list.get(i);
                if (modelLoader.handles(a3)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i);
                        z = false;
                    }
                    emptyList.add(modelLoader);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a3, (List<ModelLoader<A, ?>>) list);
        }
        throw new Registry.NoModelLoaderAvailableException(a3);
    }

    public synchronized <Model, Data> void prepend(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        MultiModelLoaderFactory multiModelLoaderFactory = this.a;
        synchronized (multiModelLoaderFactory) {
            multiModelLoaderFactory.a.add(0, new MultiModelLoaderFactory.b<>(cls, cls2, modelLoaderFactory));
        }
        this.b.a.clear();
    }

    public synchronized <Model, Data> void remove(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        a(this.a.d(cls, cls2));
        this.b.a.clear();
    }

    public synchronized <Model, Data> void replace(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> d;
        MultiModelLoaderFactory multiModelLoaderFactory = this.a;
        synchronized (multiModelLoaderFactory) {
            d = multiModelLoaderFactory.d(cls, cls2);
            multiModelLoaderFactory.a(cls, cls2, modelLoaderFactory);
        }
        a(d);
        this.b.a.clear();
    }
}
