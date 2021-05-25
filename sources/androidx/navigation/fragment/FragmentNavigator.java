package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import com.avito.android.BuildConfig;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
@Navigator.Name("fragment")
public class FragmentNavigator extends Navigator<Destination> {
    public final Context a;
    public final FragmentManager b;
    public final int c;
    public ArrayDeque<Integer> d = new ArrayDeque<>();

    @NavDestination.ClassType(Fragment.class)
    public static class Destination extends NavDestination {
        public String j;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this(navigatorProvider.getNavigator(FragmentNavigator.class));
        }

        @NonNull
        public final String getClassName() {
            String str = this.j;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R.styleable.FragmentNavigator_android_name);
            if (string != null) {
                setClassName(string);
            }
            obtainAttributes.recycle();
        }

        @NonNull
        public final Destination setClassName(@NonNull String str) {
            this.j = str;
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.j;
            if (str == null) {
                sb.append(BuildConfig.ADJUST_DEFAULT_TRACKER);
            } else {
                sb.append(str);
            }
            return sb.toString();
        }

        public Destination(@NonNull Navigator<? extends Destination> navigator) {
            super(navigator);
        }
    }

    public static final class Extras implements Navigator.Extras {
        public final LinkedHashMap<View, String> a;

        public static final class Builder {
            public final LinkedHashMap<View, String> a = new LinkedHashMap<>();

            @NonNull
            public Builder addSharedElement(@NonNull View view, @NonNull String str) {
                this.a.put(view, str);
                return this;
            }

            @NonNull
            public Builder addSharedElements(@NonNull Map<View, String> map) {
                for (Map.Entry<View, String> entry : map.entrySet()) {
                    View key = entry.getKey();
                    String value = entry.getValue();
                    if (!(key == null || value == null)) {
                        addSharedElement(key, value);
                    }
                }
                return this;
            }

            @NonNull
            public Extras build() {
                return new Extras(this.a);
            }
        }

        public Extras(Map<View, String> map) {
            LinkedHashMap<View, String> linkedHashMap = new LinkedHashMap<>();
            this.a = linkedHashMap;
            linkedHashMap.putAll(map);
        }

        @NonNull
        public Map<View, String> getSharedElements() {
            return Collections.unmodifiableMap(this.a);
        }
    }

    public FragmentNavigator(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i) {
        this.a = context;
        this.b = fragmentManager;
        this.c = i;
    }

    @NonNull
    public final String a(int i, int i2) {
        return i + "-" + i2;
    }

    @NonNull
    @Deprecated
    public Fragment instantiateFragment(@NonNull Context context, @NonNull FragmentManager fragmentManager, @NonNull String str, @Nullable Bundle bundle) {
        return fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), str);
    }

    @Override // androidx.navigation.Navigator
    public void onRestoreState(@Nullable Bundle bundle) {
        int[] intArray;
        if (!(bundle == null || (intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds")) == null)) {
            this.d.clear();
            for (int i : intArray) {
                this.d.add(Integer.valueOf(i));
            }
        }
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.d.size()];
        Iterator<Integer> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        if (this.d.isEmpty() || this.b.isStateSaved()) {
            return false;
        }
        this.b.popBackStack(a(this.d.size(), this.d.peekLast().intValue()), 1);
        this.d.removeLast();
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public Destination createDestination() {
        return new Destination(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012d A[RETURN] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.NavDestination navigate(@androidx.annotation.NonNull androidx.navigation.fragment.FragmentNavigator.Destination r9, @androidx.annotation.Nullable android.os.Bundle r10, @androidx.annotation.Nullable androidx.navigation.NavOptions r11, @androidx.annotation.Nullable androidx.navigation.Navigator.Extras r12) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.navigate(androidx.navigation.fragment.FragmentNavigator$Destination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):androidx.navigation.NavDestination");
    }
}
