package com.facebook.imagepipeline.producers;

import a2.g.p.e.c;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {
    public static final String EXTRAS_STARTED_AS_PREFETCH = "started_as_prefetch";
    @VisibleForTesting
    @GuardedBy("this")
    public final Map<K, MultiplexProducer<K, T>.b> a;
    public final Producer<T> b;
    public final boolean c;
    public final String d;
    public final String e;

    /* JADX WARN: Field signature parse error: a */
    @VisibleForTesting
    public class b {
        public final Object a;
        public final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> b = Sets.newCopyOnWriteArraySet();
        @GuardedBy("Multiplexer.this")
        @Nullable
        public T c;
        @GuardedBy("Multiplexer.this")
        public float d;
        @GuardedBy("Multiplexer.this")
        public int e;
        @GuardedBy("Multiplexer.this")
        @Nullable
        public BaseProducerContext f;
        @GuardedBy("Multiplexer.this")
        @Nullable
        public MultiplexProducer<K, T>.b.a g;

        public class a extends BaseConsumer<T> {
            public a(a aVar) {
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onCancellationImpl() {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onCancellation");
                    }
                    b bVar = b.this;
                    synchronized (bVar) {
                        if (bVar.g == this) {
                            bVar.g = null;
                            bVar.f = null;
                            bVar.b(bVar.c);
                            bVar.c = null;
                            bVar.i(TriState.UNSET);
                        }
                    }
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onFailureImpl(Throwable th) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onFailure");
                    }
                    b.this.f(this, th);
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer$b */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(Object obj, int i) {
                Closeable closeable = (Closeable) obj;
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onNewResult");
                    }
                    b.this.g(this, closeable, i);
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onProgressUpdateImpl(float f) {
                try {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");
                    }
                    b.this.h(this, f);
                } finally {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                }
            }
        }

        public b(K k) {
            this.a = k;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.producers.Consumer<T extends java.io.Closeable> */
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(Consumer<T> consumer, ProducerContext producerContext) {
            List<ProducerContextCallbacks> k;
            List<ProducerContextCallbacks> l;
            List<ProducerContextCallbacks> j;
            Closeable closeable;
            float f2;
            int i;
            Pair create = Pair.create(consumer, producerContext);
            synchronized (this) {
                if (MultiplexProducer.this.getExistingMultiplexer(this.a) != this) {
                    return false;
                }
                this.b.add(create);
                k = k();
                l = l();
                j = j();
                closeable = this.c;
                f2 = this.d;
                i = this.e;
            }
            BaseProducerContext.callOnIsPrefetchChanged(k);
            BaseProducerContext.callOnPriorityChanged(l);
            BaseProducerContext.callOnIsIntermediateResultExpectedChanged(j);
            synchronized (create) {
                synchronized (this) {
                    if (closeable != this.c) {
                        closeable = null;
                    } else if (closeable != null) {
                        closeable = MultiplexProducer.this.cloneOrNull(closeable);
                    }
                }
                if (closeable != null) {
                    if (f2 > 0.0f) {
                        consumer.onProgressUpdate(f2);
                    }
                    consumer.onNewResult(closeable, i);
                    b(closeable);
                }
            }
            producerContext.addCallbacks(new c(this, create));
            return true;
        }

        public final void b(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        public final synchronized boolean c() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.b.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) it.next().second).isIntermediateResultExpected()) {
                    return true;
                }
            }
            return false;
        }

        public final synchronized boolean d() {
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.b.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) it.next().second).isPrefetch()) {
                    return false;
                }
            }
            return true;
        }

        public final synchronized Priority e() {
            Priority priority;
            priority = Priority.LOW;
            Iterator<Pair<Consumer<T>, ProducerContext>> it = this.b.iterator();
            while (it.hasNext()) {
                priority = Priority.getHigherPriority(priority, ((ProducerContext) it.next().second).getPriority());
            }
            return priority;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX WARN: Multi-variable type inference failed */
        public void f(MultiplexProducer<K, T>.b.a aVar, Throwable th) {
            Iterator<Pair<Consumer<T>, ProducerContext>> it;
            synchronized (this) {
                if (this.g == aVar) {
                    it = this.b.iterator();
                    this.b.clear();
                    MultiplexProducer.this.removeMultiplexer(this.a, this);
                    b(this.c);
                    this.c = null;
                } else {
                    return;
                }
            }
            while (it.hasNext()) {
                Pair<Consumer<T>, ProducerContext> next = it.next();
                synchronized (next) {
                    ((ProducerContext) next.second).getProducerListener().onProducerFinishWithFailure((ProducerContext) next.second, MultiplexProducer.this.d, th, null);
                    ((Consumer) next.first).onFailure(th);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX WARN: Multi-variable type inference failed */
        public void g(MultiplexProducer<K, T>.b.a aVar, T t, int i) {
            Iterator<Pair<Consumer<T>, ProducerContext>> it;
            int size;
            synchronized (this) {
                if (this.g == aVar) {
                    b(this.c);
                    this.c = null;
                    it = this.b.iterator();
                    size = this.b.size();
                    if (BaseConsumer.isNotLast(i)) {
                        this.c = (T) MultiplexProducer.this.cloneOrNull(t);
                        this.e = i;
                    } else {
                        this.b.clear();
                        MultiplexProducer.this.removeMultiplexer(this.a, this);
                    }
                } else {
                    return;
                }
            }
            while (it.hasNext()) {
                Pair<Consumer<T>, ProducerContext> next = it.next();
                synchronized (next) {
                    if (BaseConsumer.isLast(i)) {
                        ((ProducerContext) next.second).getProducerListener().onProducerFinishWithSuccess((ProducerContext) next.second, MultiplexProducer.this.d, null);
                        BaseProducerContext baseProducerContext = this.f;
                        if (baseProducerContext != null) {
                            ((ProducerContext) next.second).putExtras(baseProducerContext.getExtras());
                        }
                        ((ProducerContext) next.second).setExtra(MultiplexProducer.this.e, Integer.valueOf(size));
                    }
                    ((Consumer) next.first).onNewResult(t, i);
                }
            }
        }

        public void h(MultiplexProducer<K, T>.b.a aVar, float f2) {
            Iterator<Pair<Consumer<T>, ProducerContext>> it;
            synchronized (this) {
                if (this.g == aVar) {
                    this.d = f2;
                    it = this.b.iterator();
                } else {
                    return;
                }
            }
            while (it.hasNext()) {
                Pair<Consumer<T>, ProducerContext> next = it.next();
                synchronized (next) {
                    ((Consumer) next.first).onProgressUpdate(f2);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r13v5, resolved type: com.facebook.imagepipeline.producers.MultiplexProducer */
        /* JADX WARN: Multi-variable type inference failed */
        public final void i(TriState triState) {
            synchronized (this) {
                boolean z = true;
                Preconditions.checkArgument(this.f == null);
                if (this.g != null) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                if (this.b.isEmpty()) {
                    MultiplexProducer.this.removeMultiplexer(this.a, this);
                    return;
                }
                ProducerContext producerContext = (ProducerContext) this.b.iterator().next().second;
                BaseProducerContext baseProducerContext = new BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), d(), c(), e(), producerContext.getImagePipelineConfig());
                this.f = baseProducerContext;
                baseProducerContext.putExtras(producerContext.getExtras());
                if (triState.isSet()) {
                    this.f.setExtra(MultiplexProducer.EXTRAS_STARTED_AS_PREFETCH, Boolean.valueOf(triState.asBoolean()));
                }
                MultiplexProducer<K, T>.b.a aVar = new a(null);
                this.g = aVar;
                MultiplexProducer.this.b.produceResults(aVar, this.f);
            }
        }

        @Nullable
        public final synchronized List<ProducerContextCallbacks> j() {
            BaseProducerContext baseProducerContext = this.f;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setIsIntermediateResultExpectedNoCallbacks(c());
        }

        @Nullable
        public final synchronized List<ProducerContextCallbacks> k() {
            BaseProducerContext baseProducerContext = this.f;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setIsPrefetchNoCallbacks(d());
        }

        @Nullable
        public final synchronized List<ProducerContextCallbacks> l() {
            BaseProducerContext baseProducerContext = this.f;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setPriorityNoCallbacks(e());
        }
    }

    public MultiplexProducer(Producer<T> producer, String str, @ProducerContext.ExtraKeys String str2) {
        this(producer, str, str2, false);
    }

    public abstract T cloneOrNull(T t);

    public synchronized MultiplexProducer<K, T>.b getExistingMultiplexer(K k) {
        return this.a.get(k);
    }

    public abstract K getKey(ProducerContext producerContext);

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        MultiplexProducer<K, T>.b existingMultiplexer;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("MultiplexProducer#produceResults");
            }
            producerContext.getProducerListener().onProducerStart(producerContext, this.d);
            K key = getKey(producerContext);
            do {
                z = false;
                synchronized (this) {
                    existingMultiplexer = getExistingMultiplexer(key);
                    if (existingMultiplexer == null) {
                        synchronized (this) {
                            existingMultiplexer = new b(key);
                            this.a.put(key, existingMultiplexer);
                            z = true;
                        }
                    }
                }
            } while (!existingMultiplexer.a(consumer, producerContext));
            if (z) {
                existingMultiplexer.i(TriState.valueOf(producerContext.isPrefetch()));
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public synchronized void removeMultiplexer(K k, MultiplexProducer<K, T>.b bVar) {
        if (this.a.get(k) == bVar) {
            this.a.remove(k);
        }
    }

    public MultiplexProducer(Producer<T> producer, String str, @ProducerContext.ExtraKeys String str2, boolean z) {
        this.b = producer;
        this.a = new HashMap();
        this.c = z;
        this.d = str;
        this.e = str2;
    }
}
