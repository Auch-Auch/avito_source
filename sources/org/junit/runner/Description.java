package org.junit.runner;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Description implements Serializable {
    public static final Description EMPTY = new Description(null, "No Tests", "No Tests", new Annotation[0]);
    public static final Description TEST_MECHANISM = new Description(null, "Test mechanism", "Test mechanism", new Annotation[0]);
    public static final Pattern f = Pattern.compile("([\\s\\S]*)\\((.*)\\)");
    private static final long serialVersionUID = 1;
    public final Collection<Description> a = new ConcurrentLinkedQueue();
    public final String b;
    public final Serializable c;
    public final Annotation[] d;
    public volatile Class<?> e;

    public Description(Class<?> cls, String str, Serializable serializable, Annotation... annotationArr) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The display name must not be empty.");
        } else if (serializable != null) {
            this.e = cls;
            this.b = str;
            this.c = serializable;
            this.d = annotationArr;
        } else {
            throw new IllegalArgumentException("The unique id must not be null.");
        }
    }

    public static String a(String str, String str2) {
        return String.format("%s(%s)", str, str2);
    }

    public static Description createSuiteDescription(String str, Annotation... annotationArr) {
        return new Description(null, str, str, annotationArr);
    }

    public static Description createTestDescription(String str, String str2, Annotation... annotationArr) {
        String a3 = a(str2, str);
        return new Description(null, a3, a3, annotationArr);
    }

    public void addChild(Description description) {
        this.a.add(description);
    }

    public final String b(int i, String str) {
        Matcher matcher = f.matcher(toString());
        return matcher.matches() ? matcher.group(i) : str;
    }

    public Description childlessCopy() {
        Class<?> cls = this.e;
        String str = this.b;
        return new Description(cls, str, str, this.d);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Description)) {
            return false;
        }
        return this.c.equals(((Description) obj).c);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Annotation[] annotationArr = this.d;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().equals(cls)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.d);
    }

    public ArrayList<Description> getChildren() {
        return new ArrayList<>(this.a);
    }

    public String getClassName() {
        return this.e != null ? this.e.getName() : b(2, toString());
    }

    public String getDisplayName() {
        return this.b;
    }

    public String getMethodName() {
        return b(1, null);
    }

    public Class<?> getTestClass() {
        if (this.e != null) {
            return this.e;
        }
        String className = getClassName();
        if (className == null) {
            return null;
        }
        try {
            this.e = Class.forName(className, false, getClass().getClassLoader());
            return this.e;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.c.hashCode();
    }

    public boolean isEmpty() {
        return equals(EMPTY);
    }

    public boolean isSuite() {
        return !isTest();
    }

    public boolean isTest() {
        return this.a.isEmpty();
    }

    public int testCount() {
        if (isTest()) {
            return 1;
        }
        int i = 0;
        for (Description description : this.a) {
            i += description.testCount();
        }
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        return getDisplayName();
    }

    public static Description createSuiteDescription(String str, Serializable serializable, Annotation... annotationArr) {
        return new Description(null, str, serializable, annotationArr);
    }

    public static Description createTestDescription(Class<?> cls, String str, Annotation... annotationArr) {
        String a3 = a(str, cls.getName());
        return new Description(cls, a3, a3, annotationArr);
    }

    public static Description createSuiteDescription(Class<?> cls) {
        String name = cls.getName();
        return new Description(cls, name, name, cls.getAnnotations());
    }

    public static Description createTestDescription(Class<?> cls, String str) {
        String a3 = a(str, cls.getName());
        return new Description(cls, a3, a3, new Annotation[0]);
    }

    public static Description createSuiteDescription(Class<?> cls, Annotation... annotationArr) {
        String name = cls.getName();
        return new Description(cls, name, name, annotationArr);
    }

    public static Description createTestDescription(String str, String str2, Serializable serializable) {
        return new Description(null, a(str2, str), serializable, new Annotation[0]);
    }
}
