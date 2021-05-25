package org.jsoup.parser;

import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;
public class ParseSettings {
    public static final ParseSettings htmlDefault = new ParseSettings(false, false);
    public static final ParseSettings preserveCase = new ParseSettings(true, true);
    public final boolean a;
    public final boolean b;

    public ParseSettings(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public Attributes a(Attributes attributes) {
        if (attributes != null && !this.b) {
            attributes.normalize();
        }
        return attributes;
    }

    public String normalizeAttribute(String str) {
        String trim = str.trim();
        return !this.b ? Normalizer.lowerCase(trim) : trim;
    }

    public String normalizeTag(String str) {
        String trim = str.trim();
        return !this.a ? Normalizer.lowerCase(trim) : trim;
    }

    public boolean preserveAttributeCase() {
        return this.b;
    }

    public boolean preserveTagCase() {
        return this.a;
    }
}
