package org.junit.runners.model;

import com.avito.android.BuildConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.internal.MethodSorter;
public class TestClass implements Annotatable {
    public static final c d = new c(null);
    public static final d e = new d(null);
    public final Class<?> a;
    public final Map<Class<? extends Annotation>, List<FrameworkMethod>> b;
    public final Map<Class<? extends Annotation>, List<FrameworkField>> c;

    public class a implements MemberValueConsumer<T> {
        public final /* synthetic */ List a;

        public a(TestClass testClass, List list) {
            this.a = list;
        }

        @Override // org.junit.runners.model.MemberValueConsumer
        public void accept(FrameworkMember<?> frameworkMember, T t) {
            this.a.add(t);
        }
    }

    public class b implements MemberValueConsumer<T> {
        public final /* synthetic */ List a;

        public b(TestClass testClass, List list) {
            this.a = list;
        }

        @Override // org.junit.runners.model.MemberValueConsumer
        public void accept(FrameworkMember<?> frameworkMember, T t) {
            this.a.add(t);
        }
    }

    public static class c implements Comparator<Field> {
        public c(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    public static class d implements Comparator<FrameworkMethod> {
        public d(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(FrameworkMethod frameworkMethod, FrameworkMethod frameworkMethod2) {
            return MethodSorter.NAME_ASCENDING.compare(frameworkMethod.getMethod(), frameworkMethod2.getMethod());
        }
    }

    public TestClass(Class<?> cls) {
        this.a = cls;
        if (cls == null || cls.getConstructors().length <= 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            scanAnnotatedMembers(linkedHashMap, linkedHashMap2);
            this.b = c(linkedHashMap);
            this.c = c(linkedHashMap2);
            return;
        }
        throw new IllegalArgumentException("Test class can only have one constructor");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: T extends org.junit.runners.model.FrameworkMember<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends FrameworkMember<T>> void addToAnnotationLists(T t, Map<Class<? extends Annotation>, List<T>> map) {
        FrameworkMember frameworkMember;
        for (Annotation annotation : t.getAnnotations()) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            boolean z = true;
            List b2 = b(map, annotationType, true);
            int size = b2.size();
            while (true) {
                size--;
                if (size < 0) {
                    frameworkMember = t;
                    break;
                }
                frameworkMember = (FrameworkMember) b2.get(size);
                if (t.isShadowedBy(frameworkMember)) {
                    if (frameworkMember.a()) {
                        b2.remove(size);
                    } else {
                        frameworkMember = null;
                    }
                }
            }
            if (frameworkMember != null) {
                if (!annotationType.equals(Before.class) && !annotationType.equals(BeforeClass.class)) {
                    z = false;
                }
                if (z) {
                    b2.add(0, frameworkMember);
                } else {
                    b2.add(frameworkMember);
                }
            } else {
                return;
            }
        }
    }

    public static <T> List<T> b(Map<Class<? extends Annotation>, List<T>> map, Class<? extends Annotation> cls, boolean z) {
        if (!map.containsKey(cls) && z) {
            map.put(cls, new ArrayList());
        }
        List<T> list = map.get(cls);
        return list == null ? Collections.emptyList() : list;
    }

    public static <T extends FrameworkMember<T>> Map<Class<? extends Annotation>, List<T>> c(Map<Class<? extends Annotation>, List<T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Class<? extends Annotation>, List<T>> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public final <T> List<T> a(Map<?, List<T>> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (List<T> list : map.values()) {
            linkedHashSet.addAll(list);
        }
        return new ArrayList(linkedHashSet);
    }

    public <T> void collectAnnotatedFieldValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2, MemberValueConsumer<T> memberValueConsumer) {
        for (FrameworkField frameworkField : getAnnotatedFields(cls)) {
            try {
                Object obj2 = frameworkField.get(obj);
                if (cls2.isInstance(obj2)) {
                    memberValueConsumer.accept(frameworkField, cls2.cast(obj2));
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e2);
            }
        }
    }

    public <T> void collectAnnotatedMethodValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2, MemberValueConsumer<T> memberValueConsumer) {
        for (FrameworkMethod frameworkMethod : getAnnotatedMethods(cls)) {
            try {
                if (cls2.isAssignableFrom(frameworkMethod.getReturnType())) {
                    memberValueConsumer.accept(frameworkMethod, cls2.cast(frameworkMethod.invokeExplosively(obj, new Object[0])));
                }
            } catch (Throwable th) {
                StringBuilder L = a2.b.a.a.a.L("Exception in ");
                L.append(frameworkMethod.getName());
                throw new RuntimeException(L.toString(), th);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.a == ((TestClass) obj).a) {
            return true;
        }
        return false;
    }

    public <T> List<T> getAnnotatedFieldValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        collectAnnotatedFieldValues(obj, cls, cls2, new a(this, arrayList));
        return arrayList;
    }

    public List<FrameworkField> getAnnotatedFields() {
        return a(this.c);
    }

    public <T> List<T> getAnnotatedMethodValues(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        collectAnnotatedMethodValues(obj, cls, cls2, new b(this, arrayList));
        return arrayList;
    }

    public List<FrameworkMethod> getAnnotatedMethods() {
        List<FrameworkMethod> a3 = a(this.b);
        Collections.sort(a3, e);
        return a3;
    }

    @Override // org.junit.runners.model.Annotatable
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Class<?> cls2 = this.a;
        if (cls2 == null) {
            return null;
        }
        return (T) cls2.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.Annotatable
    public Annotation[] getAnnotations() {
        Class<?> cls = this.a;
        if (cls == null) {
            return new Annotation[0];
        }
        return cls.getAnnotations();
    }

    public Class<?> getJavaClass() {
        return this.a;
    }

    public String getName() {
        Class<?> cls = this.a;
        if (cls == null) {
            return BuildConfig.ADJUST_DEFAULT_TRACKER;
        }
        return cls.getName();
    }

    public Constructor<?> getOnlyConstructor() {
        Constructor<?>[] constructors = this.a.getConstructors();
        Assert.assertEquals(1L, (long) constructors.length);
        return constructors[0];
    }

    public int hashCode() {
        Class<?> cls = this.a;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public boolean isANonStaticInnerClass() {
        return this.a.isMemberClass() && !Modifier.isStatic(this.a.getModifiers());
    }

    public boolean isPublic() {
        return Modifier.isPublic(this.a.getModifiers());
    }

    public void scanAnnotatedMembers(Map<Class<? extends Annotation>, List<FrameworkMethod>> map, Map<Class<? extends Annotation>, List<FrameworkField>> map2) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = this.a; cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Class cls2 = (Class) it.next();
            for (Method method : MethodSorter.getDeclaredMethods(cls2)) {
                addToAnnotationLists(new FrameworkMethod(method), map);
            }
            Field[] declaredFields = cls2.getDeclaredFields();
            Arrays.sort(declaredFields, d);
            for (Field field : declaredFields) {
                addToAnnotationLists(new FrameworkField(field), map2);
            }
        }
    }

    public List<FrameworkField> getAnnotatedFields(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(b(this.c, cls, false));
    }

    public List<FrameworkMethod> getAnnotatedMethods(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(b(this.b, cls, false));
    }
}
