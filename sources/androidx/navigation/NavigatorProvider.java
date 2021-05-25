package androidx.navigation;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigator;
import java.util.HashMap;
@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider {
    public static final HashMap<Class<?>, String> b = new HashMap<>();
    public final HashMap<String, Navigator<? extends NavDestination>> a = new HashMap<>();

    @NonNull
    public static String a(@NonNull Class<? extends Navigator> cls) {
        HashMap<Class<?>, String> hashMap = b;
        String str = hashMap.get(cls);
        if (str == null) {
            Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
            str = name != null ? name.value() : null;
            if (b(str)) {
                hashMap.put(cls, str);
            } else {
                StringBuilder L = a.L("No @Navigator.Name annotation found for ");
                L.append(cls.getSimpleName());
                throw new IllegalArgumentException(L.toString());
            }
        }
        return str;
    }

    public static boolean b(String str) {
        return str != null && !str.isEmpty();
    }

    @Nullable
    public final Navigator<? extends NavDestination> addNavigator(@NonNull Navigator<? extends NavDestination> navigator) {
        return addNavigator(a(navigator.getClass()), navigator);
    }

    @NonNull
    public final <T extends Navigator<?>> T getNavigator(@NonNull Class<T> cls) {
        return (T) getNavigator(a(cls));
    }

    @Nullable
    @CallSuper
    public Navigator<? extends NavDestination> addNavigator(@NonNull String str, @NonNull Navigator<? extends NavDestination> navigator) {
        if (b(str)) {
            return this.a.put(str, navigator);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    @NonNull
    @CallSuper
    public <T extends Navigator<?>> T getNavigator(@NonNull String str) {
        if (b(str)) {
            Navigator<? extends NavDestination> navigator = this.a.get(str);
            if (navigator != null) {
                return navigator;
            }
            throw new IllegalStateException(a.e3("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}
