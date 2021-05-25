package org.junit.runner.manipulation;

import java.util.Iterator;
import org.junit.runner.Description;
public abstract class Filter {
    public static final Filter ALL = new a();

    public static class a extends Filter {
        @Override // org.junit.runner.manipulation.Filter
        public void apply(Object obj) throws NoTestsRemainException {
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return "all tests";
        }

        @Override // org.junit.runner.manipulation.Filter
        public Filter intersect(Filter filter) {
            return filter;
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(Description description) {
            return true;
        }
    }

    public static class b extends Filter {
        public final /* synthetic */ Description a;

        public b(Description description) {
            this.a = description;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return String.format("Method %s", this.a.getDisplayName());
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(Description description) {
            if (description.isTest()) {
                return this.a.equals(description);
            }
            Iterator<Description> it = description.getChildren().iterator();
            while (it.hasNext()) {
                if (shouldRun(it.next())) {
                    return true;
                }
            }
            return false;
        }
    }

    public class c extends Filter {
        public final /* synthetic */ Filter a;
        public final /* synthetic */ Filter b;

        public c(Filter filter, Filter filter2, Filter filter3) {
            this.a = filter2;
            this.b = filter3;
        }

        @Override // org.junit.runner.manipulation.Filter
        public String describe() {
            return this.a.describe() + " and " + this.b.describe();
        }

        @Override // org.junit.runner.manipulation.Filter
        public boolean shouldRun(Description description) {
            return this.a.shouldRun(description) && this.b.shouldRun(description);
        }
    }

    public static Filter matchMethodDescription(Description description) {
        return new b(description);
    }

    public void apply(Object obj) throws NoTestsRemainException {
        if (obj instanceof Filterable) {
            ((Filterable) obj).filter(this);
        }
    }

    public abstract String describe();

    public Filter intersect(Filter filter) {
        return (filter == this || filter == ALL) ? this : new c(this, this, filter);
    }

    public abstract boolean shouldRun(Description description);
}
