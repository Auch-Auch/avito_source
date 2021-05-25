package org.hamcrest;

import java.io.IOException;
public class StringDescription extends BaseDescription {
    public final Appendable a;

    public StringDescription() {
        this(new StringBuilder());
    }

    public static String asString(SelfDescribing selfDescribing) {
        return toString(selfDescribing);
    }

    public static String toString(SelfDescribing selfDescribing) {
        return new StringDescription().appendDescriptionOf(selfDescribing).toString();
    }

    @Override // org.hamcrest.BaseDescription
    public void append(String str) {
        try {
            this.a.append(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    public StringDescription(Appendable appendable) {
        this.a = appendable;
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // org.hamcrest.BaseDescription
    public void append(char c) {
        try {
            this.a.append(c);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }
}
