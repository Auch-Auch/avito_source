package org.junit.runner.manipulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import org.junit.runner.Description;
public abstract class Ordering {

    public static class Context {
        public final Description a;

        public Context(Description description, a aVar) {
            this.a = description;
        }

        public Description getTarget() {
            return this.a;
        }
    }

    public interface Factory {
        Ordering create(Context context);
    }

    public static class a extends Ordering {
        public final /* synthetic */ Random a;

        public a(Random random) {
            this.a = random;
        }

        @Override // org.junit.runner.manipulation.Ordering
        public boolean a() {
            return false;
        }

        @Override // org.junit.runner.manipulation.Ordering
        public List<Description> orderItems(Collection<Description> collection) {
            ArrayList arrayList = new ArrayList(collection);
            Collections.shuffle(arrayList, this.a);
            return arrayList;
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0045: APUT  (r1v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r2v1 java.lang.String) */
    public static Ordering definedBy(Class<? extends Factory> cls, Description description) throws InvalidOrderingException {
        Objects.requireNonNull(cls, "factoryClass cannot be null");
        Objects.requireNonNull(description, "annotatedTestClass cannot be null");
        try {
            return definedBy((Factory) cls.getConstructor(new Class[0]).newInstance(new Object[0]), description);
        } catch (NoSuchMethodException unused) {
            Object[] objArr = new Object[2];
            String canonicalName = cls.getCanonicalName();
            if (canonicalName == null) {
                canonicalName = cls.getName();
            }
            objArr[0] = canonicalName;
            objArr[1] = cls.getSimpleName();
            throw new InvalidOrderingException(String.format("Ordering class %s should have a public constructor with signature %s(Ordering.Context context)", objArr));
        } catch (Exception e) {
            throw new InvalidOrderingException("Could not create ordering for " + description, e);
        }
    }

    public static Ordering shuffledBy(Random random) {
        return new a(random);
    }

    public boolean a() {
        return true;
    }

    public void apply(Object obj) throws InvalidOrderingException {
        if (obj instanceof Orderable) {
            ((Orderable) obj).order(new Orderer(this));
        }
    }

    public abstract List<Description> orderItems(Collection<Description> collection);

    public static Ordering definedBy(Factory factory, Description description) throws InvalidOrderingException {
        Objects.requireNonNull(factory, "factory cannot be null");
        Objects.requireNonNull(description, "annotatedTestClass cannot be null");
        return factory.create(new Context(description, null));
    }
}
