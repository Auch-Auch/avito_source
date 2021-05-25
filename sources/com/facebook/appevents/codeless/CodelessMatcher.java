package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessLoggingEventListener;
import com.facebook.appevents.codeless.RCTCodelessLoggingEventListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
@AutoHandleExceptions
public class CodelessMatcher {
    public static final String f = "com.facebook.appevents.codeless.CodelessMatcher";
    public static CodelessMatcher g;
    public final Handler a = new Handler(Looper.getMainLooper());
    public Set<Activity> b = Collections.newSetFromMap(new WeakHashMap());
    public Set<ViewMatcher> c = new HashSet();
    public HashSet<String> d = new HashSet<>();
    public HashMap<Integer, HashSet<String>> e = new HashMap<>();

    public static class MatchedView {
        public WeakReference<View> a;
        public String b;

        public MatchedView(View view, String str) {
            this.a = new WeakReference<>(view);
            this.b = str;
        }

        @Nullable
        public View getView() {
            WeakReference<View> weakReference = this.a;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }

        public String getViewMapKey() {
            return this.b;
        }
    }

    @UiThread
    public static class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        public WeakReference<View> a;
        @Nullable
        public List<EventBinding> b;
        public final Handler c;
        public HashSet<String> d;
        public final String e;

        public ViewMatcher(View view, Handler handler, HashSet<String> hashSet, String str) {
            this.a = new WeakReference<>(view);
            this.c = handler;
            this.d = hashSet;
            this.e = str;
            handler.postDelayed(this, 200);
        }

        public static List<View> a(ViewGroup viewGroup) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    arrayList.add(childAt);
                }
            }
            return arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b8, code lost:
            if (r9.getClass().getSimpleName().equals(r12[r12.length - 1]) == false) goto L_0x0183;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f6, code lost:
            if (r12.equals(r4) == false) goto L_0x0183;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0129, code lost:
            if (r12.equals(r4) == false) goto L_0x0183;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x014f, code lost:
            if (r12.equals(r4) == false) goto L_0x0183;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0181, code lost:
            if (r12.equals(r0) == false) goto L_0x0183;
         */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0188 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0189  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.util.List<com.facebook.appevents.codeless.CodelessMatcher.MatchedView> findViewByPath(com.facebook.appevents.codeless.internal.EventBinding r8, android.view.View r9, java.util.List<com.facebook.appevents.codeless.internal.PathComponent> r10, int r11, int r12, java.lang.String r13) {
            /*
            // Method dump skipped, instructions count: 452
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.findViewByPath(com.facebook.appevents.codeless.internal.EventBinding, android.view.View, java.util.List, int, int, java.lang.String):java.util.List");
        }

        public final void b() {
            if (!(this.b == null || this.a.get() == null)) {
                for (int i = 0; i < this.b.size(); i++) {
                    findView(this.b.get(i), this.a.get());
                }
            }
        }

        public void findView(EventBinding eventBinding, View view) {
            if (!(eventBinding == null || view == null)) {
                if (TextUtils.isEmpty(eventBinding.getActivityName()) || eventBinding.getActivityName().equals(this.e)) {
                    List<PathComponent> viewPath = eventBinding.getViewPath();
                    if (viewPath.size() <= 25) {
                        for (MatchedView matchedView : findViewByPath(eventBinding, view, viewPath, 0, -1, this.e)) {
                            try {
                                View view2 = matchedView.getView();
                                if (view2 != null) {
                                    View findRCTRootView = ViewHierarchy.findRCTRootView(view2);
                                    boolean z = true;
                                    if (findRCTRootView != null && ViewHierarchy.isRCTButton(view2, findRCTRootView)) {
                                        View view3 = matchedView.getView();
                                        if (view3 != null) {
                                            String viewMapKey = matchedView.getViewMapKey();
                                            View.OnTouchListener existingOnTouchListener = ViewHierarchy.getExistingOnTouchListener(view3);
                                            if (!(existingOnTouchListener instanceof RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) || !((RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) existingOnTouchListener).getSupportCodelessLogging()) {
                                                z = false;
                                            }
                                            if (!this.d.contains(viewMapKey) && !z) {
                                                view3.setOnTouchListener(RCTCodelessLoggingEventListener.getOnTouchListener(eventBinding, view, view3));
                                                this.d.add(viewMapKey);
                                            }
                                        }
                                    } else if (!view2.getClass().getName().startsWith("com.facebook.react")) {
                                        if (!(view2 instanceof AdapterView)) {
                                            View view4 = matchedView.getView();
                                            if (view4 != null) {
                                                String viewMapKey2 = matchedView.getViewMapKey();
                                                View.OnClickListener existingOnClickListener = ViewHierarchy.getExistingOnClickListener(view4);
                                                if (!(existingOnClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnClickListener) || !((CodelessLoggingEventListener.AutoLoggingOnClickListener) existingOnClickListener).getSupportCodelessLogging()) {
                                                    z = false;
                                                }
                                                if (!this.d.contains(viewMapKey2) && !z) {
                                                    view4.setOnClickListener(CodelessLoggingEventListener.getOnClickListener(eventBinding, view, view4));
                                                    this.d.add(viewMapKey2);
                                                }
                                            }
                                        } else if (view2 instanceof ListView) {
                                            AdapterView adapterView = (AdapterView) matchedView.getView();
                                            if (adapterView != null) {
                                                String viewMapKey3 = matchedView.getViewMapKey();
                                                AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
                                                if (!(onItemClickListener instanceof CodelessLoggingEventListener.AutoLoggingOnItemClickListener) || !((CodelessLoggingEventListener.AutoLoggingOnItemClickListener) onItemClickListener).getSupportCodelessLogging()) {
                                                    z = false;
                                                }
                                                if (!this.d.contains(viewMapKey3) && !z) {
                                                    adapterView.setOnItemClickListener(CodelessLoggingEventListener.getOnItemClickListener(eventBinding, view, adapterView));
                                                    this.d.add(viewMapKey3);
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                Utility.logd(CodelessMatcher.f, e2);
                            }
                        }
                    }
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            b();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            b();
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                List<EventBinding> parseArray = EventBinding.parseArray(appSettingsWithoutQuery.getEventBindings());
                this.b = parseArray;
                if (parseArray != null && (view = this.a.get()) != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnGlobalLayoutListener(this);
                        viewTreeObserver.addOnScrollChangedListener(this);
                    }
                    b();
                }
            }
        }
    }

    public static synchronized CodelessMatcher a() {
        CodelessMatcher codelessMatcher;
        synchronized (CodelessMatcher.class) {
            if (g == null) {
                g = new CodelessMatcher();
            }
            codelessMatcher = g;
        }
        return codelessMatcher;
    }

    @UiThread
    public static Bundle b(EventBinding eventBinding, View view, View view2) {
        List<ParameterComponent> viewParameters;
        List<MatchedView> list;
        Bundle bundle = new Bundle();
        if (!(eventBinding == null || (viewParameters = eventBinding.getViewParameters()) == null)) {
            for (ParameterComponent parameterComponent : viewParameters) {
                String str = parameterComponent.value;
                if (str != null && str.length() > 0) {
                    bundle.putString(parameterComponent.name, parameterComponent.value);
                } else if (parameterComponent.path.size() > 0) {
                    if (parameterComponent.pathType.equals(Constants.PATH_TYPE_RELATIVE)) {
                        list = ViewMatcher.findViewByPath(eventBinding, view2, parameterComponent.path, 0, -1, view2.getClass().getSimpleName());
                    } else {
                        list = ViewMatcher.findViewByPath(eventBinding, view, parameterComponent.path, 0, -1, view.getClass().getSimpleName());
                    }
                    Iterator<MatchedView> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MatchedView next = it.next();
                        if (next.getView() != null) {
                            String textOfView = ViewHierarchy.getTextOfView(next.getView());
                            if (textOfView.length() > 0) {
                                bundle.putString(parameterComponent.name, textOfView);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return bundle;
    }

    public final void c() {
        for (Activity activity : this.b) {
            if (activity != null) {
                this.c.add(new ViewMatcher(AppEventUtility.getRootView(activity), this.a, this.d, activity.getClass().getSimpleName()));
            }
        }
    }
}
