package a2.g.k.a0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
@AutoHandleExceptions
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final Map<Integer, d> d = new HashMap();
    public WeakReference<Activity> a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public AtomicBoolean c = new AtomicBoolean(false);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                View rootView = AppEventUtility.getRootView(d.this.a.get());
                Activity activity = d.this.a.get();
                if (rootView == null) {
                    return;
                }
                if (activity != null) {
                    Iterator it = ((ArrayList) c.a(rootView)).iterator();
                    while (it.hasNext()) {
                        View view = (View) it.next();
                        if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                            String d = c.d(view);
                            if (!d.isEmpty() && d.length() <= 300) {
                                String localClassName = activity.getLocalClassName();
                                String str = ViewOnClickListener.OTHER_EVENT;
                                int hashCode = view.hashCode();
                                Set<Integer> set = ViewOnClickListener.e;
                                if (!set.contains(Integer.valueOf(hashCode))) {
                                    ViewHierarchy.setOnClickListener(view, new ViewOnClickListener(view, rootView, localClassName));
                                    set.add(Integer.valueOf(hashCode));
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public d(Activity activity) {
        this.a = new WeakReference<>(activity);
    }

    public static void b(Activity activity) {
        View rootView;
        int hashCode = activity.hashCode();
        Map<Integer, d> map = d;
        if (!map.containsKey(Integer.valueOf(hashCode))) {
            d dVar = new d(activity);
            map.put(Integer.valueOf(hashCode), dVar);
            if (!dVar.c.getAndSet(true) && (rootView = AppEventUtility.getRootView(dVar.a.get())) != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(dVar);
                    dVar.a();
                    dVar.a.get();
                }
            }
        }
    }

    public static void c(Activity activity) {
        View rootView;
        int hashCode = activity.hashCode();
        Map<Integer, d> map = d;
        if (map.containsKey(Integer.valueOf(hashCode))) {
            d dVar = map.get(Integer.valueOf(hashCode));
            map.remove(Integer.valueOf(hashCode));
            if (dVar.c.getAndSet(false) && (rootView = AppEventUtility.getRootView(dVar.a.get())) != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(dVar);
                }
            }
        }
    }

    public final void a() {
        a aVar = new a();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            aVar.run();
        } else {
            this.b.post(aVar);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        a();
    }
}
