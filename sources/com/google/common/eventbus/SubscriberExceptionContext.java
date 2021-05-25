package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;
public class SubscriberExceptionContext {
    public final EventBus a;
    public final Object b;
    public final Object c;
    public final Method d;

    public SubscriberExceptionContext(EventBus eventBus, Object obj, Object obj2, Method method) {
        this.a = (EventBus) Preconditions.checkNotNull(eventBus);
        this.b = Preconditions.checkNotNull(obj);
        this.c = Preconditions.checkNotNull(obj2);
        this.d = (Method) Preconditions.checkNotNull(method);
    }

    public Object getEvent() {
        return this.b;
    }

    public EventBus getEventBus() {
        return this.a;
    }

    public Object getSubscriber() {
        return this.c;
    }

    public Method getSubscriberMethod() {
        return this.d;
    }
}
