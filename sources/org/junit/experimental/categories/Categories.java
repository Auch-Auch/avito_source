package org.junit.experimental.categories;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
public class Categories extends Suite {
    public static final /* synthetic */ int g = 0;

    public static class CategoryFilter extends Filter {
        public final Set<Class<?>> a;
        public final Set<Class<?>> b;
        public final boolean c;
        public final boolean d;

        @Deprecated
        public CategoryFilter(Class<?> cls, Class<?> cls2) {
            this.c = true;
            this.d = true;
            int i = Categories.g;
            this.a = cls == null ? Collections.emptySet() : Collections.singleton(cls);
            this.b = cls2 == null ? Collections.emptySet() : Collections.singleton(cls2);
        }

        public static Class<?>[] a(Description description) {
            if (description == null) {
                return new Class[0];
            }
            Category category = (Category) description.getAnnotation(Category.class);
            if (category == null) {
                return new Class[0];
            }
            return category.value();
        }

        public static CategoryFilter categoryFilter(boolean z, Set<Class<?>> set, boolean z2, Set<Class<?>> set2) {
            return new CategoryFilter(z, set, z2, set2);
        }

        public static CategoryFilter exclude(boolean z, Class<?>... clsArr) {
            return new CategoryFilter(true, (Class<?>[]) null, z, clsArr);
        }

        public static CategoryFilter include(boolean z, Class<?>... clsArr) {
            return new CategoryFilter(z, clsArr, true, (Class<?>[]) null);
        }

        public final boolean b(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> cls : set2) {
                if (!Categories.b(set, cls)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean c(Set<Class<?>> set, Set<Class<?>> set2) {
            for (Class<?> cls : set2) {
                if (Categories.b(set, cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return toString();
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(Description description) {
            Description description2;
            boolean z;
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, a(description));
            Class<?> testClass = description.getTestClass();
            if (testClass == null) {
                description2 = null;
            } else {
                description2 = Description.createSuiteDescription(testClass);
            }
            Collections.addAll(hashSet, a(description2));
            if (hashSet.isEmpty()) {
                z = this.a.isEmpty();
            } else if (!this.b.isEmpty() && (!this.d ? b(hashSet, this.b) : c(hashSet, this.b))) {
                z = false;
            } else if (this.a.isEmpty()) {
                z = true;
            } else if (this.c) {
                z = c(hashSet, this.a);
            } else {
                z = b(hashSet, this.a);
            }
            if (z) {
                return true;
            }
            Iterator<Description> it = description.getChildren().iterator();
            while (it.hasNext()) {
                if (shouldRun(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("categories ");
            sb.append(this.a.isEmpty() ? "[all]" : this.a);
            if (!this.b.isEmpty()) {
                sb.append(" - ");
                sb.append(this.b);
            }
            return sb.toString();
        }

        public static CategoryFilter exclude(Class<?> cls) {
            return exclude(true, cls);
        }

        public static CategoryFilter include(Class<?> cls) {
            return include(true, cls);
        }

        public static CategoryFilter exclude(Class<?>... clsArr) {
            return exclude(true, clsArr);
        }

        public static CategoryFilter include(Class<?>... clsArr) {
            return include(true, clsArr);
        }

        public CategoryFilter(boolean z, Set<Class<?>> set, boolean z2, Set<Class<?>> set2) {
            this.c = z;
            this.d = z2;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (set != null) {
                linkedHashSet.addAll(set);
            }
            linkedHashSet.remove(null);
            this.a = linkedHashSet;
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            if (set2 != null) {
                linkedHashSet2.addAll(set2);
            }
            linkedHashSet2.remove(null);
            this.b = linkedHashSet2;
        }

        public CategoryFilter(boolean z, Class<?>[] clsArr, boolean z2, Class<?>[] clsArr2) {
            this.c = z;
            this.d = z2;
            this.a = Categories.c(clsArr);
            this.b = Categories.c(clsArr2);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExcludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface IncludeCategory {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    public Categories(Class<?> cls, RunnerBuilder runnerBuilder) throws InitializationError {
        super(cls, runnerBuilder);
        Class<?>[] clsArr;
        boolean z;
        try {
            IncludeCategory includeCategory = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
            Class<?>[] clsArr2 = null;
            if (includeCategory == null) {
                clsArr = null;
            } else {
                clsArr = includeCategory.value();
            }
            Set<Class<?>> c = c(clsArr);
            ExcludeCategory excludeCategory = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
            if (excludeCategory != null) {
                clsArr2 = excludeCategory.value();
            }
            Set<Class<?>> c2 = c(clsArr2);
            IncludeCategory includeCategory2 = (IncludeCategory) cls.getAnnotation(IncludeCategory.class);
            boolean z2 = false;
            if (includeCategory2 != null) {
                if (!includeCategory2.matchAny()) {
                    z = false;
                    ExcludeCategory excludeCategory2 = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
                    filter(CategoryFilter.categoryFilter(z, c, (excludeCategory2 == null || excludeCategory2.matchAny()) ? true : z2, c2));
                }
            }
            z = true;
            ExcludeCategory excludeCategory2 = (ExcludeCategory) cls.getAnnotation(ExcludeCategory.class);
            filter(CategoryFilter.categoryFilter(z, c, (excludeCategory2 == null || excludeCategory2.matchAny()) ? true : z2, c2));
        } catch (NoTestsRemainException e) {
            throw new InitializationError(e);
        }
    }

    public static boolean b(Set set, Class cls) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static Set<Class<?>> c(Class<?>[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return Collections.emptySet();
        }
        for (Class<?> cls : clsArr) {
            Objects.requireNonNull(cls, "has null category");
        }
        return clsArr.length == 1 ? Collections.singleton(clsArr[0]) : new LinkedHashSet(Arrays.asList(clsArr));
    }
}
