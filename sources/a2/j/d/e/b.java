package a2.j.d.e;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
public class b implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ c b;

    public b(c cVar, Object obj) {
        this.b = cVar;
        this.a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable cause;
        try {
            this.b.a(this.a);
        } catch (InvocationTargetException e) {
            EventBus eventBus = this.b.a;
            cause = e.getCause();
            c cVar = this.b;
            SubscriberExceptionContext subscriberExceptionContext = new SubscriberExceptionContext(cVar.a, this.a, cVar.b, cVar.c);
            Objects.requireNonNull(eventBus);
            Preconditions.checkNotNull(cause);
            Preconditions.checkNotNull(subscriberExceptionContext);
            eventBus.c.handleException(cause, subscriberExceptionContext);
        } catch (Throwable th) {
            EventBus.f.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th, cause), th);
        }
    }
}
