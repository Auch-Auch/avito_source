package org.jsoup.parser;

import java.util.ArrayList;
public class ParseErrorList extends ArrayList<ParseError> {
    public final int a;

    public ParseErrorList(int i, int i2) {
        super(i);
        this.a = i2;
    }

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList tracking(int i) {
        return new ParseErrorList(16, i);
    }

    public boolean a() {
        return size() < this.a;
    }
}
