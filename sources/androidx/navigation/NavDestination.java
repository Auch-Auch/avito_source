package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.common.R;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import l6.r.c;
public class NavDestination {
    public static final HashMap<String, Class<?>> i = new HashMap<>();
    public final String a;
    public NavGraph b;
    public int c;
    public String d;
    public CharSequence e;
    public ArrayList<c> f;
    public SparseArrayCompat<NavAction> g;
    public HashMap<String, NavArgument> h;

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassType {
        Class<?> value();
    }

    public static class a implements Comparable<a> {
        @NonNull
        public final NavDestination a;
        @NonNull
        public final Bundle b;
        public final boolean c;

        public a(@NonNull NavDestination navDestination, @NonNull Bundle bundle, boolean z) {
            this.a = navDestination;
            this.b = bundle;
            this.c = z;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            boolean z = this.c;
            if (z && !aVar.c) {
                return 1;
            }
            if (z || !aVar.c) {
                return this.b.size() - aVar.b.size();
            }
            return -1;
        }
    }

    public NavDestination(@NonNull Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.a(navigator.getClass()));
    }

    @NonNull
    public static String c(@NonNull Context context, int i2) {
        if (i2 <= 16777215) {
            return Integer.toString(i2);
        }
        try {
            return context.getResources().getResourceName(i2);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i2);
        }
    }

    @NonNull
    public static <C> Class<? extends C> parseClassFromName(@NonNull Context context, @NonNull String str, @NonNull Class<? extends C> cls) {
        if (str.charAt(0) == '.') {
            str = context.getPackageName() + str;
        }
        HashMap<String, Class<?>> hashMap = i;
        Class<? extends C> cls2 = (Class<? extends C>) hashMap.get(str);
        if (cls2 == null) {
            try {
                cls2 = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                hashMap.put(str, cls2);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        if (cls.isAssignableFrom(cls2)) {
            return cls2;
        }
        throw new IllegalArgumentException(str + " must be a subclass of " + cls);
    }

    @Nullable
    public Bundle a(@Nullable Bundle bundle) {
        HashMap<String, NavArgument> hashMap;
        if (bundle == null && ((hashMap = this.h) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, NavArgument> hashMap2 = this.h;
        if (hashMap2 != null) {
            for (Map.Entry<String, NavArgument> entry : hashMap2.entrySet()) {
                NavArgument value = entry.getValue();
                String key = entry.getKey();
                if (value.c) {
                    value.a.put(bundle2, key, value.d);
                }
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, NavArgument> hashMap3 = this.h;
            if (hashMap3 != null) {
                for (Map.Entry<String, NavArgument> entry2 : hashMap3.entrySet()) {
                    NavArgument value2 = entry2.getValue();
                    String key2 = entry2.getKey();
                    boolean z = false;
                    if (value2.b || !bundle.containsKey(key2) || bundle.get(key2) != null) {
                        try {
                            value2.a.get(bundle, key2);
                            z = true;
                            continue;
                        } catch (ClassCastException unused) {
                            continue;
                        }
                    }
                    if (!z) {
                        StringBuilder L = a2.b.a.a.a.L("Wrong argument type for '");
                        L.append(entry2.getKey());
                        L.append("' in argument bundle. ");
                        L.append(entry2.getValue().getType().getName());
                        L.append(" expected.");
                        throw new IllegalArgumentException(L.toString());
                    }
                }
            }
        }
        return bundle2;
    }

    public final void addArgument(@NonNull String str, @NonNull NavArgument navArgument) {
        if (this.h == null) {
            this.h = new HashMap<>();
        }
        this.h.put(str, navArgument);
    }

    public final void addDeepLink(@NonNull String str) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.add(new c(str));
    }

    @NonNull
    public int[] b() {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination = this;
        while (true) {
            NavGraph parent = navDestination.getParent();
            if (parent == null || parent.getStartDestination() != navDestination.getId()) {
                arrayDeque.addFirst(navDestination);
            }
            if (parent == null) {
                break;
            }
            navDestination = parent;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i2 = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            iArr[i2] = ((NavDestination) it.next()).getId();
            i2++;
        }
        return iArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0108 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.NavDestination.a d(@androidx.annotation.NonNull android.net.Uri r17) {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.d(android.net.Uri):androidx.navigation.NavDestination$a");
    }

    public boolean e() {
        return true;
    }

    @Nullable
    public final NavAction getAction(@IdRes int i2) {
        SparseArrayCompat<NavAction> sparseArrayCompat = this.g;
        NavAction navAction = sparseArrayCompat == null ? null : sparseArrayCompat.get(i2);
        if (navAction != null) {
            return navAction;
        }
        if (getParent() != null) {
            return getParent().getAction(i2);
        }
        return null;
    }

    @NonNull
    public final Map<String, NavArgument> getArguments() {
        HashMap<String, NavArgument> hashMap = this.h;
        if (hashMap == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(hashMap);
    }

    @IdRes
    public final int getId() {
        return this.c;
    }

    @Nullable
    public final CharSequence getLabel() {
        return this.e;
    }

    @NonNull
    public final String getNavigatorName() {
        return this.a;
    }

    @Nullable
    public final NavGraph getParent() {
        return this.b;
    }

    public boolean hasDeepLink(@NonNull Uri uri) {
        return d(uri) != null;
    }

    @CallSuper
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.Navigator);
        setId(obtainAttributes.getResourceId(R.styleable.Navigator_android_id, 0));
        this.d = c(context, this.c);
        setLabel(obtainAttributes.getText(R.styleable.Navigator_android_label));
        obtainAttributes.recycle();
    }

    public final void putAction(@IdRes int i2, @IdRes int i3) {
        putAction(i2, new NavAction(i3));
    }

    public final void removeAction(@IdRes int i2) {
        SparseArrayCompat<NavAction> sparseArrayCompat = this.g;
        if (sparseArrayCompat != null) {
            sparseArrayCompat.delete(i2);
        }
    }

    public final void removeArgument(@NonNull String str) {
        HashMap<String, NavArgument> hashMap = this.h;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    public final void setId(@IdRes int i2) {
        this.c = i2;
        this.d = null;
    }

    public final void setLabel(@Nullable CharSequence charSequence) {
        this.e = charSequence;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.d;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.c));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.e != null) {
            sb.append(" label=");
            sb.append(this.e);
        }
        return sb.toString();
    }

    public NavDestination(@NonNull String str) {
        this.a = str;
    }

    public final void putAction(@IdRes int i2, @NonNull NavAction navAction) {
        if (!e()) {
            throw new UnsupportedOperationException("Cannot add action " + i2 + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        } else if (i2 != 0) {
            if (this.g == null) {
                this.g = new SparseArrayCompat<>();
            }
            this.g.put(i2, navAction);
        } else {
            throw new IllegalArgumentException("Cannot have an action with actionId 0");
        }
    }
}
