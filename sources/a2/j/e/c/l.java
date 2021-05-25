package a2.j.e.c;

import androidx.annotation.GuardedBy;
import com.google.firebase.components.Preconditions;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
public class l implements Subscriber, Publisher {
    @GuardedBy("this")
    public final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> a = new HashMap();
    @GuardedBy("this")
    public Queue<Event<?>> b = new ArrayDeque();
    public final Executor c;

    public l(Executor executor) {
        this.c = executor;
    }

    @Override // com.google.firebase.events.Publisher
    public void publish(Event<?> event) {
        Set<Map.Entry<EventHandler<Object>, Executor>> emptySet;
        Preconditions.checkNotNull(event);
        synchronized (this) {
            Queue<Event<?>> queue = this.b;
            if (queue != null) {
                queue.add(event);
                return;
            }
        }
        synchronized (this) {
            ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap = this.a.get(event.getType());
            emptySet = concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
        }
        for (Map.Entry<EventHandler<Object>, Executor> entry : emptySet) {
            entry.getValue().execute(new Runnable(entry, event) { // from class: a2.j.e.c.k
                public final Map.Entry a;
                public final Event b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Map.Entry entry2 = this.a;
                    ((EventHandler) entry2.getKey()).handle(this.b);
                }
            });
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        Preconditions.checkNotNull(executor);
        if (!this.a.containsKey(cls)) {
            this.a.put(cls, new ConcurrentHashMap<>());
        }
        this.a.get(cls).put(eventHandler, executor);
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized <T> void unsubscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(eventHandler);
        if (this.a.containsKey(cls)) {
            ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap = this.a.get(cls);
            concurrentHashMap.remove(eventHandler);
            if (concurrentHashMap.isEmpty()) {
                this.a.remove(cls);
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        subscribe(cls, this.c, eventHandler);
    }
}
