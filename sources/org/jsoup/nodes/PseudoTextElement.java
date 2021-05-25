package org.jsoup.nodes;

import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
public class PseudoTextElement extends Element {
    public PseudoTextElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public void c(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public void d(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }
}
