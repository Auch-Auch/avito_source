package org.jsoup.parser;

import a2.b.a.a.a;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
public class TokenQueue {
    public String a;
    public int b = 0;

    public TokenQueue(String str) {
        Validate.notNull(str);
        this.a = str;
    }

    public static String unescape(String str) {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '\\') {
                borrowBuilder.append(c2);
            } else if (c != 0 && c == '\\') {
                borrowBuilder.append(c2);
            }
            i++;
            c = c2;
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public final int a() {
        return this.a.length() - this.b;
    }

    public void addFirst(Character ch) {
        addFirst(ch.toString());
    }

    public void advance() {
        if (!isEmpty()) {
            this.b++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0048 A[EDGE_INSN: B:36:0x0048->B:30:0x0048 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String chompBalanced(char r10, char r11) {
        /*
            r9 = this;
            r0 = 0
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L_0x0007:
            boolean r7 = r9.isEmpty()
            if (r7 == 0) goto L_0x000e
            goto L_0x0048
        L_0x000e:
            char r7 = r9.consume()
            if (r0 == 0) goto L_0x0018
            r8 = 92
            if (r0 == r8) goto L_0x003f
        L_0x0018:
            r8 = 39
            if (r7 != r8) goto L_0x0023
            if (r7 == r10) goto L_0x0023
            if (r2 != 0) goto L_0x0023
            r3 = r3 ^ 1
            goto L_0x002d
        L_0x0023:
            r8 = 34
            if (r7 != r8) goto L_0x002d
            if (r7 == r10) goto L_0x002d
            if (r3 != 0) goto L_0x002d
            r2 = r2 ^ 1
        L_0x002d:
            if (r3 != 0) goto L_0x0046
            if (r2 == 0) goto L_0x0032
            goto L_0x0046
        L_0x0032:
            if (r7 != r10) goto L_0x003b
            int r4 = r4 + 1
            if (r5 != r1) goto L_0x003f
            int r5 = r9.b
            goto L_0x003f
        L_0x003b:
            if (r7 != r11) goto L_0x003f
            int r4 = r4 + -1
        L_0x003f:
            if (r4 <= 0) goto L_0x0045
            if (r0 == 0) goto L_0x0045
            int r6 = r9.b
        L_0x0045:
            r0 = r7
        L_0x0046:
            if (r4 > 0) goto L_0x0007
        L_0x0048:
            if (r6 < 0) goto L_0x0051
            java.lang.String r10 = r9.a
            java.lang.String r10 = r10.substring(r5, r6)
            goto L_0x0053
        L_0x0051:
            java.lang.String r10 = ""
        L_0x0053:
            if (r4 <= 0) goto L_0x006e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Did not find balanced marker at '"
            r11.append(r0)
            r11.append(r10)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            org.jsoup.helper.Validate.fail(r11)
        L_0x006e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.TokenQueue.chompBalanced(char, char):java.lang.String");
    }

    public String chompTo(String str) {
        String consumeTo = consumeTo(str);
        matchChomp(str);
        return consumeTo;
    }

    public String chompToIgnoreCase(String str) {
        String consumeToIgnoreCase = consumeToIgnoreCase(str);
        matchChomp(str);
        return consumeToIgnoreCase;
    }

    public char consume() {
        String str = this.a;
        int i = this.b;
        this.b = i + 1;
        return str.charAt(i);
    }

    public String consumeAttributeKey() {
        int i = this.b;
        while (!isEmpty() && (matchesWord() || matchesAny('-', '_', ':'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public String consumeCssIdentifier() {
        int i = this.b;
        while (!isEmpty() && (matchesWord() || matchesAny('-', '_'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public String consumeElementSelector() {
        int i = this.b;
        while (!isEmpty() && (matchesWord() || matchesAny("*|", "|", "_", "-"))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public String consumeTagName() {
        int i = this.b;
        while (!isEmpty() && (matchesWord() || matchesAny(':', '_', '-'))) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public String consumeTo(String str) {
        int indexOf = this.a.indexOf(str, this.b);
        if (indexOf == -1) {
            return remainder();
        }
        String substring = this.a.substring(this.b, indexOf);
        this.b = substring.length() + this.b;
        return substring;
    }

    public String consumeToAny(String... strArr) {
        int i = this.b;
        while (!isEmpty() && !matchesAny(strArr)) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public String consumeToIgnoreCase(String str) {
        int i = this.b;
        String substring = str.substring(0, 1);
        boolean equals = substring.toLowerCase().equals(substring.toUpperCase());
        while (!isEmpty() && !matches(str)) {
            if (equals) {
                int indexOf = this.a.indexOf(substring, this.b);
                int i2 = this.b;
                int i3 = indexOf - i2;
                if (i3 == 0) {
                    this.b = i2 + 1;
                } else if (i3 < 0) {
                    this.b = this.a.length();
                } else {
                    this.b = i2 + i3;
                }
            } else {
                this.b++;
            }
        }
        return this.a.substring(i, this.b);
    }

    public boolean consumeWhitespace() {
        boolean z = false;
        while (matchesWhitespace()) {
            this.b++;
            z = true;
        }
        return z;
    }

    public String consumeWord() {
        int i = this.b;
        while (matchesWord()) {
            this.b++;
        }
        return this.a.substring(i, this.b);
    }

    public boolean isEmpty() {
        return a() == 0;
    }

    public boolean matchChomp(String str) {
        if (!matches(str)) {
            return false;
        }
        this.b = str.length() + this.b;
        return true;
    }

    public boolean matches(String str) {
        return this.a.regionMatches(true, this.b, str, 0, str.length());
    }

    public boolean matchesAny(String... strArr) {
        for (String str : strArr) {
            if (matches(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesCS(String str) {
        return this.a.startsWith(str, this.b);
    }

    public boolean matchesStartTag() {
        return a() >= 2 && this.a.charAt(this.b) == '<' && Character.isLetter(this.a.charAt(this.b + 1));
    }

    public boolean matchesWhitespace() {
        return !isEmpty() && StringUtil.isWhitespace(this.a.charAt(this.b));
    }

    public boolean matchesWord() {
        return !isEmpty() && Character.isLetterOrDigit(this.a.charAt(this.b));
    }

    public char peek() {
        if (isEmpty()) {
            return 0;
        }
        return this.a.charAt(this.b);
    }

    public String remainder() {
        String str = this.a;
        String substring = str.substring(this.b, str.length());
        this.b = this.a.length();
        return substring;
    }

    public String toString() {
        return this.a.substring(this.b);
    }

    public void addFirst(String str) {
        StringBuilder L = a.L(str);
        L.append(this.a.substring(this.b));
        this.a = L.toString();
        this.b = 0;
    }

    public void consume(String str) {
        if (matches(str)) {
            int length = str.length();
            if (length <= a()) {
                this.b += length;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        for (char c : cArr) {
            if (this.a.charAt(this.b) == c) {
                return true;
            }
        }
        return false;
    }
}
