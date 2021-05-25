package x6.b.c;

import java.util.Iterator;
import org.jsoup.nodes.Element;
import org.jsoup.select.Evaluator;
public abstract class b extends Evaluator {
    public Evaluator a;

    public static class a extends b {
        public a(Evaluator evaluator) {
            this.a = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Iterator it = element2.getAllElements().iterator();
            while (it.hasNext()) {
                Element element3 = (Element) it.next();
                if (element3 != element2 && this.a.matches(element2, element3)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", this.a);
        }
    }

    /* renamed from: x6.b.c.b$b  reason: collision with other inner class name */
    public static class C0692b extends b {
        public C0692b(Evaluator evaluator) {
            this.a = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element parent;
            if (element == element2 || (parent = element2.parent()) == null || !this.a.matches(element, parent)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", this.a);
        }
    }

    public static class c extends b {
        public c(Evaluator evaluator) {
            this.a = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            Element previousElementSibling;
            if (element == element2 || (previousElementSibling = element2.previousElementSibling()) == null || !this.a.matches(element, previousElementSibling)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format(":prev%s", this.a);
        }
    }

    public static class d extends b {
        public d(Evaluator evaluator) {
            this.a = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return !this.a.matches(element, element2);
        }

        public String toString() {
            return String.format(":not%s", this.a);
        }
    }

    public static class e extends b {
        public e(Evaluator evaluator) {
            this.a = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element parent = element2.parent(); !this.a.matches(element, parent); parent = parent.parent()) {
                if (parent == element) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return String.format(":parent%s", this.a);
        }
    }

    public static class f extends b {
        public f(Evaluator evaluator) {
            this.a = evaluator;
        }

        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (Element previousElementSibling = element2.previousElementSibling(); previousElementSibling != null; previousElementSibling = previousElementSibling.previousElementSibling()) {
                if (this.a.matches(element, previousElementSibling)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", this.a);
        }
    }

    public static class g extends Evaluator {
        @Override // org.jsoup.select.Evaluator
        public boolean matches(Element element, Element element2) {
            return element == element2;
        }
    }
}
