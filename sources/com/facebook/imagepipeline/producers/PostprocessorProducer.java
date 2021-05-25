package com.facebook.imagepipeline.producers;

import a2.g.p.e.f;
import a2.g.p.e.g;
import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
public class PostprocessorProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String NAME = "PostprocessorProducer";
    public final Producer<CloseableReference<CloseableImage>> a;
    public final PlatformBitmapFactory b;
    public final Executor c;

    public class b extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public final ProducerListener2 c;
        public final ProducerContext d;
        public final Postprocessor e;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean f;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable
        public CloseableReference<CloseableImage> g = null;
        @GuardedBy("PostprocessorConsumer.this")
        public int h = 0;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean i = false;
        @GuardedBy("PostprocessorConsumer.this")
        public boolean j = false;

        public class a extends BaseProducerContextCallbacks {
            public a(PostprocessorProducer postprocessorProducer) {
            }

            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                b bVar = b.this;
                if (bVar.b()) {
                    bVar.getConsumer().onCancellation();
                }
            }
        }

        public b(Consumer<CloseableReference<CloseableImage>> consumer, ProducerListener2 producerListener2, Postprocessor postprocessor, ProducerContext producerContext) {
            super(consumer);
            this.c = producerListener2;
            this.e = postprocessor;
            this.d = producerContext;
            producerContext.addCallbacks(new a(PostprocessorProducer.this));
        }

        public static void a(b bVar, CloseableReference closeableReference, int i2) {
            Objects.requireNonNull(bVar);
            Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
            if (!(((CloseableImage) closeableReference.get()) instanceof CloseableStaticBitmap)) {
                bVar.d(closeableReference, i2);
                return;
            }
            bVar.c.onProducerStart(bVar.d, PostprocessorProducer.NAME);
            CloseableReference<CloseableImage> closeableReference2 = null;
            try {
                closeableReference2 = bVar.e((CloseableImage) closeableReference.get());
                try {
                    ProducerListener2 producerListener2 = bVar.c;
                    ProducerContext producerContext = bVar.d;
                    producerListener2.onProducerFinishWithSuccess(producerContext, PostprocessorProducer.NAME, bVar.c(producerListener2, producerContext, bVar.e));
                    bVar.d(closeableReference2, i2);
                    CloseableReference.closeSafely(closeableReference2);
                } catch (Throwable th) {
                    CloseableReference.closeSafely(closeableReference2);
                    throw th;
                }
            } catch (Exception e2) {
                ProducerListener2 producerListener22 = bVar.c;
                ProducerContext producerContext2 = bVar.d;
                producerListener22.onProducerFinishWithFailure(producerContext2, PostprocessorProducer.NAME, e2, bVar.c(producerListener22, producerContext2, bVar.e));
                if (bVar.b()) {
                    bVar.getConsumer().onFailure(e2);
                }
            }
        }

        public final boolean b() {
            synchronized (this) {
                if (this.f) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.g;
                this.g = null;
                this.f = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        @Nullable
        public final Map<String, String> c(ProducerListener2 producerListener2, ProducerContext producerContext, Postprocessor postprocessor) {
            if (!producerListener2.requiresExtraMap(producerContext, PostprocessorProducer.NAME)) {
                return null;
            }
            return ImmutableMap.of("Postprocessor", postprocessor.getName());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
            if (r1 != false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> r3, int r4) {
            /*
                r2 = this;
                boolean r0 = com.facebook.imagepipeline.producers.BaseConsumer.isLast(r4)
                if (r0 != 0) goto L_0x0010
                monitor-enter(r2)
                boolean r1 = r2.f     // Catch:{ all -> 0x000d }
                monitor-exit(r2)
                if (r1 == 0) goto L_0x0018
                goto L_0x0010
            L_0x000d:
                r3 = move-exception
                monitor-exit(r2)
                throw r3
            L_0x0010:
                if (r0 == 0) goto L_0x001f
                boolean r0 = r2.b()
                if (r0 == 0) goto L_0x001f
            L_0x0018:
                com.facebook.imagepipeline.producers.Consumer r0 = r2.getConsumer()
                r0.onNewResult(r3, r4)
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.PostprocessorProducer.b.d(com.facebook.common.references.CloseableReference, int):void");
        }

        public final CloseableReference<CloseableImage> e(CloseableImage closeableImage) {
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            CloseableReference<Bitmap> process = this.e.process(closeableStaticBitmap.getUnderlyingBitmap(), PostprocessorProducer.this.b);
            try {
                CloseableStaticBitmap closeableStaticBitmap2 = new CloseableStaticBitmap(process, closeableImage.getQualityInfo(), closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                closeableStaticBitmap2.setImageExtras(closeableStaticBitmap.getExtras());
                return CloseableReference.of(closeableStaticBitmap2);
            } finally {
                CloseableReference.closeSafely(process);
            }
        }

        public final synchronized boolean f() {
            if (this.f || !this.i || this.j || !CloseableReference.isValid(this.g)) {
                return false;
            }
            this.j = true;
            return true;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            if (b()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            if (b()) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i2) {
            CloseableReference<CloseableImage> closeableReference;
            boolean f2;
            CloseableReference closeableReference2 = (CloseableReference) obj;
            if (CloseableReference.isValid(closeableReference2)) {
                synchronized (this) {
                    if (!this.f) {
                        closeableReference = this.g;
                        this.g = CloseableReference.cloneOrNull(closeableReference2);
                        this.h = i2;
                        this.i = true;
                        f2 = f();
                    } else {
                        return;
                    }
                }
                CloseableReference.closeSafely(closeableReference);
                if (f2) {
                    PostprocessorProducer.this.c.execute(new f(this));
                }
            } else if (BaseConsumer.isLast(i2)) {
                d(null, i2);
            }
        }
    }

    public class c extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> implements RepeatedPostprocessorRunner {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        public boolean c = false;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable
        public CloseableReference<CloseableImage> d = null;

        public c(PostprocessorProducer postprocessorProducer, b bVar, RepeatedPostprocessor repeatedPostprocessor, ProducerContext producerContext, a aVar) {
            super(bVar);
            repeatedPostprocessor.setCallback(this);
            producerContext.addCallbacks(new g(this, postprocessorProducer));
        }

        public final boolean a() {
            synchronized (this) {
                if (this.c) {
                    return false;
                }
                CloseableReference<CloseableImage> closeableReference = this.d;
                this.d = null;
                this.c = true;
                CloseableReference.closeSafely(closeableReference);
                return true;
            }
        }

        public final void b() {
            synchronized (this) {
                if (!this.c) {
                    CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.d);
                    try {
                        getConsumer().onNewResult(cloneOrNull, 0);
                    } finally {
                        CloseableReference.closeSafely(cloneOrNull);
                    }
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            if (a()) {
                getConsumer().onCancellation();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            if (a()) {
                getConsumer().onFailure(th);
            }
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!BaseConsumer.isNotLast(i)) {
                synchronized (this) {
                    if (!this.c) {
                        CloseableReference<CloseableImage> closeableReference2 = this.d;
                        this.d = CloseableReference.cloneOrNull(closeableReference);
                        CloseableReference.closeSafely(closeableReference2);
                    }
                }
                b();
            }
        }

        @Override // com.facebook.imagepipeline.request.RepeatedPostprocessorRunner
        public synchronized void update() {
            b();
        }
    }

    public class d extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public d(PostprocessorProducer postprocessorProducer, b bVar, a aVar) {
            super(bVar);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!BaseConsumer.isNotLast(i)) {
                getConsumer().onNewResult(closeableReference, i);
            }
        }
    }

    public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> producer, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        this.a = (Producer) Preconditions.checkNotNull(producer);
        this.b = platformBitmapFactory;
        this.c = (Executor) Preconditions.checkNotNull(executor);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<CloseableReference<CloseableImage>> consumer2;
        ProducerListener2 producerListener = producerContext.getProducerListener();
        Postprocessor postprocessor = producerContext.getImageRequest().getPostprocessor();
        b bVar = new b(consumer, producerListener, postprocessor, producerContext);
        if (postprocessor instanceof RepeatedPostprocessor) {
            consumer2 = new c(this, bVar, (RepeatedPostprocessor) postprocessor, producerContext, null);
        } else {
            consumer2 = new d(this, bVar, null);
        }
        this.a.produceResults(consumer2, producerContext);
    }
}
