package org.jsoup.parser;
public class ParseError {
    public int a;
    public String b;

    public ParseError(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public String getErrorMessage() {
        return this.b;
    }

    public int getPosition() {
        return this.a;
    }

    public String toString() {
        return this.a + ": " + this.b;
    }

    public ParseError(int i, String str, Object... objArr) {
        this.b = String.format(str, objArr);
        this.a = i;
    }
}
