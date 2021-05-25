package hu.akarnokd.rxjava2.debug.multihook;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
public class MultiHandlerManager<H> {
    public final CopyOnWriteArrayList<a<H>> handlers = new CopyOnWriteArrayList<>();

    public static final class a<H> extends AtomicReference<H> implements Disposable {
        private static final long serialVersionUID = -3761960052630027297L;
        public final MultiHandlerManager<H> a;

        public a(MultiHandlerManager<H> multiHandlerManager, H h) {
            this.a = multiHandlerManager;
            lazySet(h);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) != null) {
                this.a.handlers.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public final void clear() {
        this.handlers.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.reactivex.functions.Consumer<H> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void forEach(@NonNull Consumer<H> consumer) {
        ObjectHelper.requireNonNull(consumer, "consumer is null");
        Iterator<a<H>> it = this.handlers.iterator();
        while (it.hasNext()) {
            try {
                Object obj = it.next().get();
                if (obj != null) {
                    consumer.accept(obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
            }
        }
    }

    public final boolean hasHandlers() {
        return !this.handlers.isEmpty();
    }

    @NonNull
    public final Disposable register(@NonNull H h) {
        ObjectHelper.requireNonNull(h, "handler is null");
        a<H> aVar = new a<>(this, h);
        this.handlers.add(aVar);
        return aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: io.reactivex.functions.BiConsumer<S, H> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <S> void forEach(S s, @NonNull BiConsumer<S, H> biConsumer) {
        ObjectHelper.requireNonNull(biConsumer, "consumer is null");
        Iterator<a<H>> it = this.handlers.iterator();
        while (it.hasNext()) {
            try {
                Object obj = it.next().get();
                if (obj != null) {
                    biConsumer.accept(s, obj);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
            }
        }
    }
}
