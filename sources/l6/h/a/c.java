package l6.h.a;

import java.lang.reflect.Method;
public class c implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;

    public c(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Method method = d.d;
            if (method != null) {
                method.invoke(this.a, this.b, Boolean.FALSE, "AppCompat recreation");
            } else {
                d.e.invoke(this.a, this.b, Boolean.FALSE);
            }
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable unused) {
        }
    }
}
