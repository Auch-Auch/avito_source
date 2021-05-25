package x6.b.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Evaluator;
public abstract class a extends Evaluator {
    public final ArrayList<Evaluator> a = new ArrayList<>();
    public int b = 0;

    public void a() {
        this.b = this.a.size();
    }

    /* renamed from: x6.b.c.a$a  reason: collision with other inner class name */
    public static final class C0691a extends a {
        public C0691a(Collection<Evaluator> collection) {
            this.a.addAll(collection);
            a();
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (int i = 0; i < this.b; i++) {
                if (!this.a.get(i).matches(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.join(this.a, " ");
        }

        public C0691a(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }
    }

    public static final class b extends a {
        public b(Evaluator... evaluatorArr) {
            List asList = Arrays.asList(evaluatorArr);
            if (this.b > 1) {
                this.a.add(new C0691a(asList));
            } else {
                this.a.addAll(asList);
            }
            a();
        }

        public void b(Evaluator evaluator) {
            this.a.add(evaluator);
            a();
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            for (int i = 0; i < this.b; i++) {
                if (this.a.get(i).matches(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return StringUtil.join(this.a, ", ");
        }

        public b() {
        }
    }
}
