package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;
public class Collector {

    public static class a implements NodeVisitor {
        public final Element a;
        public final Elements b;
        public final Evaluator c;

        public a(Element element, Elements elements, Evaluator evaluator) {
            this.a = element;
            this.b = elements;
            this.c = evaluator;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.c.matches(this.a, element)) {
                    this.b.add(element);
                }
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
        }
    }

    public static class b implements NodeFilter {
        public final Element a;
        public Element b = null;
        public final Evaluator c;

        public b(Element element, Evaluator evaluator) {
            this.a = element;
            this.c = evaluator;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.c.matches(this.a, element)) {
                    this.b = element;
                    return NodeFilter.FilterResult.STOP;
                }
            }
            return NodeFilter.FilterResult.CONTINUE;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult tail(Node node, int i) {
            return NodeFilter.FilterResult.CONTINUE;
        }
    }

    public static Elements collect(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        NodeTraversor.traverse(new a(element, elements, evaluator), element);
        return elements;
    }

    public static Element findFirst(Evaluator evaluator, Element element) {
        b bVar = new b(element, evaluator);
        NodeTraversor.filter(bVar, element);
        return bVar.b;
    }
}
