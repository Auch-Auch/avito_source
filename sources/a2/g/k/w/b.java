package a2.g.k.w;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
@AutoHandleExceptions
public final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {
    public static final Map<Integer, b> e = new HashMap();
    public final Set<String> a = new HashSet();
    public final Handler b;
    public WeakReference<Activity> c;
    public AtomicBoolean d;

    public class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.a;
            if (view instanceof EditText) {
                b bVar = b.this;
                Objects.requireNonNull(bVar);
                String lowerCase = ((EditText) view).getText().toString().trim().toLowerCase();
                if (!(lowerCase.isEmpty() || bVar.a.contains(lowerCase) || lowerCase.length() > 100)) {
                    bVar.a.add(lowerCase);
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(ViewHierarchy.getHintOfView(view));
                    Object tag = view.getTag();
                    if (tag != null) {
                        arrayList.add(tag.toString());
                    }
                    CharSequence contentDescription = view.getContentDescription();
                    if (contentDescription != null) {
                        arrayList.add(contentDescription.toString());
                    }
                    try {
                        if (view.getId() != -1) {
                            String[] split = view.getResources().getResourceName(view.getId()).split("/");
                            if (split.length == 2) {
                                arrayList.add(split[1]);
                            }
                        }
                    } catch (Resources.NotFoundException unused) {
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!str.isEmpty() && str.length() <= 100) {
                            arrayList2.add(str.toLowerCase());
                        }
                    }
                    ArrayList arrayList3 = null;
                    Set<MetadataRule> set = MetadataRule.d;
                    Iterator it2 = new HashSet(MetadataRule.d).iterator();
                    while (it2.hasNext()) {
                        MetadataRule metadataRule = (MetadataRule) it2.next();
                        String replaceAll = "r2".equals(metadataRule.a) ? lowerCase.replaceAll("[^\\d.]", "") : lowerCase;
                        if (metadataRule.c.isEmpty() || replaceAll.matches(metadataRule.c)) {
                            if (a.b(arrayList2, new ArrayList(metadataRule.b))) {
                                b.b(hashMap, metadataRule.a, replaceAll);
                            } else {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                    ViewGroup parentOfView = ViewHierarchy.getParentOfView(view);
                                    if (parentOfView != null) {
                                        for (View view2 : ViewHierarchy.getChildrenOfView(parentOfView)) {
                                            if (view != view2) {
                                                arrayList3.addAll(a.a(view2));
                                            }
                                        }
                                    }
                                }
                                if (a.b(arrayList3, new ArrayList(metadataRule.b))) {
                                    b.b(hashMap, metadataRule.a, replaceAll);
                                }
                            }
                        }
                    }
                    InternalAppEventsLogger.setInternalUserData(hashMap);
                }
            }
        }
    }

    public b(Activity activity) {
        this.c = new WeakReference<>(activity);
        this.b = new Handler(Looper.getMainLooper());
        this.d = new AtomicBoolean(false);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(Map<String, String> map, String str, String str2) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case 3585:
                if (str.equals("r3")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3586:
                if (str.equals("r4")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3587:
                if (str.equals("r5")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3588:
                if (str.equals("r6")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            str2 = (str2.startsWith(AuthSource.OPEN_CHANNEL_LIST) || str2.startsWith(AuthSource.BOOKING_ORDER) || str2.startsWith(UserDataStore.GENDER)) ? AuthSource.OPEN_CHANNEL_LIST : "f";
        } else if (c2 == 1 || c2 == 2) {
            str2 = str2.replaceAll("[^a-z]+", "");
        } else if (c2 == 3 && str2.contains("-")) {
            str2 = str2.split("-")[0];
        }
        map.put(str, str2);
    }

    @UiThread
    public static void c(Activity activity) {
        b bVar;
        View rootView;
        int hashCode = activity.hashCode();
        Map<Integer, b> map = e;
        if (!map.containsKey(Integer.valueOf(hashCode))) {
            bVar = new b(activity);
            map.put(Integer.valueOf(activity.hashCode()), bVar);
        } else {
            bVar = map.get(Integer.valueOf(hashCode));
        }
        if (!bVar.d.getAndSet(true) && (rootView = AppEventUtility.getRootView(bVar.c.get())) != null) {
            ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalFocusChangeListener(bVar);
            }
        }
    }

    public final void a(View view) {
        a aVar = new a(view);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            aVar.run();
        } else {
            this.b.post(aVar);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(@Nullable View view, @Nullable View view2) {
        if (view != null) {
            a(view);
        }
        if (view2 != null) {
            a(view2);
        }
    }
}
