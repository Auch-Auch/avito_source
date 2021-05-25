package androidx.fragment.app;

import a2.b.a.a.a;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
public class FragmentFactory {
    public static final SimpleArrayMap<String, Class<?>> a = new SimpleArrayMap<>();

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Class<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v5. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends androidx.fragment.app.Fragment> */
    @NonNull
    public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader classLoader, @NonNull String str) {
        try {
            SimpleArrayMap<String, Class<?>> simpleArrayMap = a;
            Class<? extends Fragment> cls = (Class) simpleArrayMap.get(str);
            if (cls != null) {
                return cls;
            }
            Class cls2 = Class.forName(str, false, classLoader);
            simpleArrayMap.put(str, cls2);
            return cls2;
        } catch (ClassNotFoundException e) {
            throw new Fragment.InstantiationException(a.e3("Unable to instantiate fragment ", str, ": make sure class name exists"), e);
        } catch (ClassCastException e2) {
            throw new Fragment.InstantiationException(a.e3("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e2);
        }
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String str) {
        try {
            return (Fragment) loadFragmentClass(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e) {
            throw new Fragment.InstantiationException(a.e3("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (IllegalAccessException e2) {
            throw new Fragment.InstantiationException(a.e3("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.InstantiationException(a.e3("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.InstantiationException(a.e3("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }
}
