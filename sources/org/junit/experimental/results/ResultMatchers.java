package org.junit.experimental.results;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
public class ResultMatchers {

    public static class a extends TypeSafeMatcher<PrintableResult> {
        public final /* synthetic */ int c;

        public a(int i) {
            this.c = i;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            StringBuilder L = a2.b.a.a.a.L("has ");
            L.append(this.c);
            L.append(" failures");
            description.appendText(L.toString());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(PrintableResult printableResult) {
            return printableResult.failureCount() == this.c;
        }
    }

    public static class b extends BaseMatcher<Object> {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            StringBuilder L = a2.b.a.a.a.L("has single failure containing ");
            L.append(this.a);
            description.appendText(L.toString());
        }

        @Override // org.hamcrest.Matcher
        public boolean matches(Object obj) {
            return obj.toString().contains(this.a) && ResultMatchers.failureCountIs(1).matches(obj);
        }
    }

    public static class c extends TypeSafeMatcher<PrintableResult> {
        public final /* synthetic */ Matcher c;

        public c(Matcher matcher) {
            this.c = matcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has failure with exception matching ");
            this.c.describeTo(description);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(PrintableResult printableResult) {
            PrintableResult printableResult2 = printableResult;
            return printableResult2.failureCount() == 1 && this.c.matches(printableResult2.failures().get(0).getException());
        }
    }

    public static class d extends TypeSafeMatcher<PrintableResult> {
        public final /* synthetic */ String c;

        public d(String str) {
            this.c = str;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            StringBuilder L = a2.b.a.a.a.L("has failure containing ");
            L.append(this.c);
            description.appendText(L.toString());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(PrintableResult printableResult) {
            PrintableResult printableResult2 = printableResult;
            return printableResult2.failureCount() > 0 && printableResult2.toString().contains(this.c);
        }
    }

    public static Matcher<PrintableResult> failureCountIs(int i) {
        return new a(i);
    }

    public static Matcher<PrintableResult> hasFailureContaining(String str) {
        return new d(str);
    }

    public static Matcher<Object> hasSingleFailureContaining(String str) {
        return new b(str);
    }

    public static Matcher<PrintableResult> hasSingleFailureMatching(Matcher<Throwable> matcher) {
        return new c(matcher);
    }

    public static Matcher<PrintableResult> isSuccessful() {
        return failureCountIs(0);
    }
}
