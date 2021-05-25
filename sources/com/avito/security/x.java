package com.avito.security;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
public class x extends w {
    public static char a(char[] cArr) {
        j1.b(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final <A extends Appendable> A a(byte[] bArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1<? super Byte, ? extends CharSequence> e1Var) {
        j1.b(bArr, "$this$joinTo");
        j1.b(a, "buffer");
        j1.b(charSequence, "separator");
        j1.b(charSequence2, "prefix");
        j1.b(charSequence3, "postfix");
        j1.b(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            a.append(e1Var != null ? (CharSequence) e1Var.a(Byte.valueOf(b)) : String.valueOf((int) b));
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <A extends Appendable> A a(int[] iArr, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1<? super Integer, ? extends CharSequence> e1Var) {
        j1.b(iArr, "$this$joinTo");
        j1.b(a, "buffer");
        j1.b(charSequence, "separator");
        j1.b(charSequence2, "prefix");
        j1.b(charSequence3, "postfix");
        j1.b(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (int i3 : iArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            a.append(e1Var != null ? (CharSequence) e1Var.a(Integer.valueOf(i3)) : String.valueOf(i3));
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final String a(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1<? super Byte, ? extends CharSequence> e1Var) {
        j1.b(bArr, "$this$joinToString");
        j1.b(charSequence, "separator");
        j1.b(charSequence2, "prefix");
        j1.b(charSequence3, "postfix");
        j1.b(charSequence4, "truncated");
        String sb = ((StringBuilder) a(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, e1Var)).toString();
        j1.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String a(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1 e1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            e1Var = null;
        }
        return a(bArr, charSequence, charSequence6, charSequence5, i3, charSequence4, (e1<? super Byte, ? extends CharSequence>) e1Var);
    }

    public static final String a(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1<? super Integer, ? extends CharSequence> e1Var) {
        j1.b(iArr, "$this$joinToString");
        j1.b(charSequence, "separator");
        j1.b(charSequence2, "prefix");
        j1.b(charSequence3, "postfix");
        j1.b(charSequence4, "truncated");
        String sb = ((StringBuilder) a(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, e1Var)).toString();
        j1.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String a(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, e1 e1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            e1Var = null;
        }
        return a(iArr, charSequence, charSequence6, charSequence5, i3, charSequence4, e1Var);
    }

    public static <T extends Comparable<? super T>> List<T> a(T[] tArr) {
        j1.b(tArr, "$this$sorted");
        return w.a(b((Comparable[]) tArr));
    }

    public static final <T extends Comparable<? super T>> T[] b(T[] tArr) {
        j1.b(tArr, "$this$sortedArray");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        j1.a((Object) copyOf, "java.util.Arrays.copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        w.b(tArr2);
        return tArr2;
    }

    public static final <T> T[] b(T[] tArr, Comparator<? super T> comparator) {
        j1.b(tArr, "$this$sortedArrayWith");
        j1.b(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        j1.a((Object) tArr2, "java.util.Arrays.copyOf(this, size)");
        w.a(tArr2, comparator);
        return tArr2;
    }

    public static <T> T c(T[] tArr) {
        j1.b(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static <T> List<T> c(T[] tArr, Comparator<? super T> comparator) {
        j1.b(tArr, "$this$sortedWith");
        j1.b(comparator, "comparator");
        return w.a(b(tArr, comparator));
    }
}
