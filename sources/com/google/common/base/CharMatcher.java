package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;
@GwtCompatible(emulated = true)
public abstract class CharMatcher implements Predicate<Character> {

    public static final class a extends CharMatcher {
        public final CharMatcher a;
        public final CharMatcher b;

        public a(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.a.d(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.b.d(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.a.matches(c) && this.b.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharMatcher.and(");
            L.append(this.a);
            L.append(", ");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public static final class a0 extends z {
        public static final a0 d = new a0();

        public a0() {
            super("CharMatcher.singleWidth()", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    public static final class b extends u {
        public static final b b = new b();

        public b() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.length() == 0 ? "" : String.valueOf(c);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher.h, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c);
            return new String(cArr);
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence2.length() * charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }
    }

    @VisibleForTesting
    public static final class b0 extends u {
        public static final int b = Integer.numberOfLeadingZeros(31);
        public static final b0 c = new b0();

        public b0() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            for (int i = 0; i < 32; i++) {
                bitSet.set(" 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt(i));
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c2) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((48906 * c2) >>> b) == c2;
        }
    }

    public static final class c extends CharMatcher {
        public final char[] a;

        public c(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.a = charArray;
            Arrays.sort(charArray);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            for (char c : this.a) {
                bitSet.set(c);
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Arrays.binarySearch(this.a, c) >= 0;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c : this.a) {
                sb.append(CharMatcher.a(c));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    public static final class d extends u {
        public static final d b = new d();

        public d() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 127;
        }
    }

    @GwtIncompatible
    public static final class e extends u {
        public final BitSet b;

        public e(BitSet bitSet, String str, a2.j.d.a.c cVar) {
            super(str);
            this.b = bitSet.length() + 64 < bitSet.size() ? (BitSet) bitSet.clone() : bitSet;
        }

        @Override // com.google.common.base.CharMatcher
        public void d(BitSet bitSet) {
            bitSet.or(this.b);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.b.get(c);
        }
    }

    public static final class f extends CharMatcher {
        public static final CharMatcher a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            if (!(c == ' ' || c == 133 || c == 5760)) {
                if (c == 8199) {
                    return false;
                }
                if (!(c == 8287 || c == 12288 || c == 8232 || c == 8233)) {
                    switch (c) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c >= 8192 && c <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class g extends z {
        public static final g d = new g();

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public g() {
            /*
                r6 = this;
                java.lang.String r0 = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０"
                char[] r1 = r0.toCharArray()
                r2 = 37
                char[] r3 = new char[r2]
                r4 = 0
            L_0x000b:
                if (r4 >= r2) goto L_0x0019
                char r5 = r0.charAt(r4)
                int r5 = r5 + 9
                char r5 = (char) r5
                r3[r4] = r5
                int r4 = r4 + 1
                goto L_0x000b
            L_0x0019:
                java.lang.String r0 = "CharMatcher.digit()"
                r6.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.CharMatcher.g.<init>():void");
        }
    }

    public static abstract class h extends CharMatcher {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return new w(this);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    public static final class j extends h {
        public final char a;
        public final char b;

        public j(char c, char c2) {
            Preconditions.checkArgument(c2 >= c);
            this.a = c;
            this.b = c2;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            bitSet.set(this.a, this.b + 1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.a <= c && c <= this.b;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharMatcher.inRange('");
            L.append(CharMatcher.a(this.a));
            L.append("', '");
            L.append(CharMatcher.a(this.b));
            L.append("')");
            return L.toString();
        }
    }

    public static final class k extends z {
        public static final k d = new k();

        public k() {
            super("CharMatcher.invisible()", "\u0000­؀؜۝܏࣢ ᠎   ⁦　?﻿￹".toCharArray(), "  ­؅؜۝܏࣢ ᠎‏ ⁤⁯　﻿￻".toCharArray());
        }
    }

    public static final class l extends h {
        public final char a;

        public l(char c) {
            this.a = c;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.a) ? this : CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            bitSet.set(this.a);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.a;
        }

        @Override // com.google.common.base.CharMatcher.h, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.isNot(this.a);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.a) ? charMatcher : CharMatcher.super.or(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString().replace(this.a, c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharMatcher.is('");
            L.append(CharMatcher.a(this.a));
            L.append("')");
            return L.toString();
        }
    }

    public static final class m extends h {
        public final char a;
        public final char b;

        public m(char c, char c2) {
            this.a = c;
            this.b = c2;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            bitSet.set(this.a);
            bitSet.set(this.b);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.a || c == this.b;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharMatcher.anyOf(\"");
            L.append(CharMatcher.a(this.a));
            L.append(CharMatcher.a(this.b));
            L.append("\")");
            return L.toString();
        }
    }

    public static final class n extends h {
        public final char a;

        public n(char c) {
            this.a = c;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.a) ? CharMatcher.super.and(charMatcher) : charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            bitSet.set(0, this.a);
            bitSet.set(this.a + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c != this.a;
        }

        @Override // com.google.common.base.CharMatcher.h, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.is(this.a);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.a) ? CharMatcher.any() : this;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharMatcher.isNot('");
            L.append(CharMatcher.a(this.a));
            L.append("')");
            return L.toString();
        }
    }

    public static final class o extends CharMatcher {
        public static final o a = new o();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class p extends u {
        public static final p b = new p();

        public p() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }
    }

    public static final class q extends CharMatcher {
        public static final q a = new q();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLetter(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class r extends CharMatcher {
        public static final r a = new r();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class s extends CharMatcher {
        public static final s a = new s();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLowerCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class t extends CharMatcher {
        public static final t a = new t();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isUpperCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static abstract class u extends h {
        public final String a;

        public u(String str) {
            this.a = (String) Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.a;
        }
    }

    public static class v extends CharMatcher {
        public final CharMatcher a;

        public v(CharMatcher charMatcher) {
            this.a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.a.countIn(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.a.d(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return !this.a.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return this.a.matchesNoneOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.a.matchesAllOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return this.a;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.a + ".negate()";
        }
    }

    public static class w extends v {
        public w(CharMatcher charMatcher) {
            super(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    public static final class x extends u {
        public static final x b = new x();

        public x() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher.h, com.google.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.any();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i) {
            Preconditions.checkPositionIndex(i, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }
    }

    public static final class y extends CharMatcher {
        public final CharMatcher a;
        public final CharMatcher b;

        public y(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        public void d(BitSet bitSet) {
            this.a.d(bitSet);
            this.b.d(bitSet);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.a.matches(c) || this.b.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharMatcher.or(");
            L.append(this.a);
            L.append(", ");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public static class z extends CharMatcher {
        public final String a;
        public final char[] b;
        public final char[] c;

        public z(String str, char[] cArr, char[] cArr2) {
            this.a = str;
            this.b = cArr;
            this.c = cArr2;
            Preconditions.checkArgument(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                Preconditions.checkArgument(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    Preconditions.checkArgument(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return CharMatcher.super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c2) {
            int binarySearch = Arrays.binarySearch(this.b, c2);
            if (binarySearch >= 0) {
                return true;
            }
            int i = (~binarySearch) - 1;
            if (i < 0 || c2 > this.c[i]) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.a;
        }
    }

    public static String a(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher any() {
        return b.b;
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return none();
        }
        if (length == 1) {
            return is(charSequence.charAt(0));
        }
        if (length != 2) {
            return new c(charSequence);
        }
        return new m(charSequence.charAt(0), charSequence.charAt(1));
    }

    public static CharMatcher ascii() {
        return d.b;
    }

    public static CharMatcher breakingWhitespace() {
        return f.a;
    }

    @GwtIncompatible
    public static CharMatcher c(int i2, BitSet bitSet, String str) {
        int i3;
        if (i2 == 0) {
            return none();
        }
        if (i2 == 1) {
            return is((char) bitSet.nextSetBit(0));
        }
        int i4 = 2;
        if (i2 != 2) {
            if (!(i2 <= 1023 && bitSet.length() > (i2 * 4) * 16)) {
                return new e(bitSet, str, null);
            }
            int cardinality = bitSet.cardinality();
            boolean z2 = bitSet.get(0);
            if (cardinality != 1) {
                i4 = Integer.highestOneBit(cardinality - 1) << 1;
                while (((double) i4) * 0.5d < ((double) cardinality)) {
                    i4 <<= 1;
                }
            }
            char[] cArr = new char[i4];
            int i5 = i4 - 1;
            int nextSetBit = bitSet.nextSetBit(0);
            long j2 = 0;
            while (nextSetBit != -1) {
                j2 = (1 << nextSetBit) | j2;
                int rotateLeft = Integer.rotateLeft(-862048943 * nextSetBit, 15) * 461845907;
                while (true) {
                    i3 = rotateLeft & i5;
                    if (cArr[i3] == 0) {
                        break;
                    }
                    rotateLeft = i3 + 1;
                }
                cArr[i3] = (char) nextSetBit;
                nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            }
            return new a2.j.d.a.l(cArr, j2, z2, str);
        }
        char nextSetBit2 = (char) bitSet.nextSetBit(0);
        return new m(nextSetBit2, (char) bitSet.nextSetBit(nextSetBit2 + 1));
    }

    @Deprecated
    public static CharMatcher digit() {
        return g.d;
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new i(predicate);
    }

    public static CharMatcher inRange(char c2, char c3) {
        return new j(c2, c3);
    }

    @Deprecated
    public static CharMatcher invisible() {
        return k.d;
    }

    public static CharMatcher is(char c2) {
        return new l(c2);
    }

    public static CharMatcher isNot(char c2) {
        return new n(c2);
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return o.a;
    }

    public static CharMatcher javaIsoControl() {
        return p.b;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return q.a;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return r.a;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return s.a;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return t.a;
    }

    public static CharMatcher none() {
        return x.b;
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return a0.d;
    }

    public static CharMatcher whitespace() {
        return b0.c;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new a(this, charMatcher);
    }

    public final String b(CharSequence charSequence, int i2, int i3, char c2, StringBuilder sb, boolean z2) {
        while (i2 < i3) {
            char charAt = charSequence.charAt(i2);
            if (!matches(charAt)) {
                sb.append(charAt);
                z2 = false;
            } else if (!z2) {
                sb.append(c2);
                z2 = true;
            }
            i2++;
        }
        return sb.toString();
    }

    public String collapseFrom(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (matches(charAt)) {
                if (charAt != c2 || (i2 != length - 1 && matches(charSequence.charAt(i2 + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i2);
                    sb.append(c2);
                    return b(charSequence, i2 + 1, length, c2, sb, true);
                }
                i2++;
            }
            i2++;
        }
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (matches(charSequence.charAt(i3))) {
                i2++;
            }
        }
        return i2;
    }

    @GwtIncompatible
    public void d(BitSet bitSet) {
        for (int i2 = 65535; i2 >= 0; i2--) {
            if (matches((char) i2)) {
                bitSet.set(i2);
            }
        }
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean matches(char c2);

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public CharMatcher negate() {
        return new v(this);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new y(this, charMatcher);
    }

    public CharMatcher precomputed() {
        a2.j.d.a.i iVar = a2.j.d.a.j.a;
        BitSet bitSet = new BitSet();
        d(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return c(cardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i2 = 65536 - cardinality;
        String charMatcher = toString();
        return new a2.j.d.a.c(this, c(i2, bitSet, charMatcher.endsWith(".negate()") ? a2.b.a.a.a.O2(charMatcher, -9, 0) : a2.b.a.a.a.c3(charMatcher, ".negate()")), charMatcher);
    }

    public String removeFrom(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i2 = 1;
        while (true) {
            indexIn++;
            while (indexIn != charArray.length) {
                if (matches(charArray[indexIn])) {
                    i2++;
                } else {
                    charArray[indexIn - i2] = charArray[indexIn];
                    indexIn++;
                }
            }
            return new String(charArray, 0, indexIn - i2);
        }
    }

    public String replaceFrom(CharSequence charSequence, char c2) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[indexIn] = c2;
        while (true) {
            indexIn++;
            if (indexIn >= charArray.length) {
                return new String(charArray);
            }
            if (matches(charArray[indexIn])) {
                charArray[indexIn] = c2;
            }
        }
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < length && matches(charSequence.charAt(i3))) {
            i3++;
        }
        int i4 = i2;
        while (i4 > i3 && matches(charSequence.charAt(i4))) {
            i4--;
        }
        if (i3 == 0 && i4 == i2) {
            return collapseFrom(charSequence, c2);
        }
        int i5 = i4 + 1;
        return b(charSequence, i3, i5, c2, new StringBuilder(i5 - i3), false);
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && matches(charSequence.charAt(i2))) {
            i2++;
        }
        int i3 = length - 1;
        while (i3 > i2 && matches(charSequence.charAt(i3))) {
            i3--;
        }
        return charSequence.subSequence(i2, i3 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!matches(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public static final class i extends CharMatcher {
        public final Predicate<? super Character> a;

        public i(Predicate<? super Character> predicate) {
            this.a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public boolean apply(Character ch) {
            return this.a.apply(Preconditions.checkNotNull(ch));
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.a.apply(Character.valueOf(c));
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharMatcher.forPredicate(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean apply(Character ch) {
            return this.a.apply(Preconditions.checkNotNull(ch));
        }
    }

    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public int indexIn(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i2, length);
        while (i2 < length) {
            if (matches(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i2 = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String charSequence3 = charSequence.toString();
        int indexIn = indexIn(charSequence3);
        if (indexIn == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder sb = new StringBuilder(a2.b.a.a.a.y2(length2, 3, 2, 16));
        do {
            sb.append((CharSequence) charSequence3, i2, indexIn);
            sb.append(charSequence2);
            i2 = indexIn + 1;
            indexIn = indexIn(charSequence3, i2);
        } while (indexIn != -1);
        sb.append((CharSequence) charSequence3, i2, length2);
        return sb.toString();
    }
}
