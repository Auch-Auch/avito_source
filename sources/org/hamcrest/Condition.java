package org.hamcrest;
public abstract class Condition<T> {
    public static final c<Object> NOT_MATCHED = new c<>(null);

    public interface Step<I, O> {
        Condition<O> apply(I i, Description description);
    }

    public static final class b<T> extends Condition<T> {
        public final T a;
        public final Description b;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Object obj, Description description, a aVar) {
            super(null);
            this.a = obj;
            this.b = description;
        }

        @Override // org.hamcrest.Condition
        public <U> Condition<U> and(Step<? super T, U> step) {
            return step.apply(this.a, this.b);
        }

        @Override // org.hamcrest.Condition
        public boolean matching(Matcher<T> matcher, String str) {
            if (matcher.matches(this.a)) {
                return true;
            }
            this.b.appendText(str);
            matcher.describeMismatch(this.a, this.b);
            return false;
        }
    }

    public static final class c<T> extends Condition<T> {
        public c(a aVar) {
            super(null);
        }

        @Override // org.hamcrest.Condition
        public <U> Condition<U> and(Step<? super T, U> step) {
            return Condition.notMatched();
        }

        @Override // org.hamcrest.Condition
        public boolean matching(Matcher<T> matcher, String str) {
            return false;
        }
    }

    public Condition() {
    }

    public static <T> Condition<T> matched(T t, Description description) {
        return new b(t, description, null);
    }

    public static <T> Condition<T> notMatched() {
        return NOT_MATCHED;
    }

    public abstract <U> Condition<U> and(Step<? super T, U> step);

    public final boolean matching(Matcher<T> matcher) {
        return matching(matcher, "");
    }

    public abstract boolean matching(Matcher<T> matcher, String str);

    public final <U> Condition<U> then(Step<? super T, U> step) {
        return and(step);
    }

    public Condition(a aVar) {
    }
}
