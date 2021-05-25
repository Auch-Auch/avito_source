package org.junit.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.FixMethodOrder;
public class MethodSorter {
    public static final Comparator<Method> DEFAULT = new a();
    public static final Comparator<Method> NAME_ASCENDING = new b();

    public static class a implements Comparator<Method> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            Method method3 = method;
            Method method4 = method2;
            int hashCode = method3.getName().hashCode();
            int hashCode2 = method4.getName().hashCode();
            if (hashCode != hashCode2) {
                return hashCode < hashCode2 ? -1 : 1;
            }
            return MethodSorter.NAME_ASCENDING.compare(method3, method4);
        }
    }

    public static class b implements Comparator<Method> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            Method method3 = method;
            Method method4 = method2;
            int compareTo = method3.getName().compareTo(method4.getName());
            return compareTo != 0 ? compareTo : method3.toString().compareTo(method4.toString());
        }
    }

    public static Method[] getDeclaredMethods(Class<?> cls) {
        Comparator<Method> comparator;
        FixMethodOrder fixMethodOrder = (FixMethodOrder) cls.getAnnotation(FixMethodOrder.class);
        if (fixMethodOrder == null) {
            comparator = DEFAULT;
        } else {
            comparator = fixMethodOrder.value().getComparator();
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (comparator != null) {
            Arrays.sort(declaredMethods, comparator);
        }
        return declaredMethods;
    }
}
