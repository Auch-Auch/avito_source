package com.avito.security;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.preferences.db_preferences.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
public class p2 extends o2 {

    public static final class a extends k1 implements f1<CharSequence, Integer, p<? extends Integer, ? extends Integer>> {
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(List list, boolean z) {
            super(2);
            this.a = list;
            this.b = z;
        }

        public final p<Integer, Integer> a(CharSequence charSequence, int i) {
            j1.b(charSequence, "$receiver");
            p b2 = p2.b(charSequence, this.a, i, this.b, false);
            if (b2 != null) {
                return r.a(b2.c(), Integer.valueOf(((String) b2.d()).length()));
            }
            return null;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.avito.security.f1
        public /* bridge */ /* synthetic */ p<? extends Integer, ? extends Integer> a(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    public static final int a(CharSequence charSequence) {
        j1.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int a(CharSequence charSequence, char c, int i, boolean z) {
        j1.b(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? a(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, c, i, z);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        o1 q1Var = !z2 ? new q1(r1.a(i, 0), r1.b(i2, charSequence.length())) : r1.c(r1.b(i, a(charSequence)), r1.a(i2, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a3 = q1Var.a();
            int b = q1Var.b();
            int c = q1Var.c();
            if (c >= 0) {
                if (a3 > b) {
                    return -1;
                }
            } else if (a3 < b) {
                return -1;
            }
            while (!a(charSequence2, 0, charSequence, a3, charSequence2.length(), z)) {
                if (a3 == b) {
                    return -1;
                }
                a3 += c;
            }
            return a3;
        }
        int a4 = q1Var.a();
        int b2 = q1Var.b();
        int c2 = q1Var.c();
        if (c2 >= 0) {
            if (a4 > b2) {
                return -1;
            }
        } else if (a4 < b2) {
            return -1;
        }
        while (!o2.a((String) charSequence2, 0, (String) charSequence, a4, charSequence2.length(), z)) {
            if (a4 == b2) {
                return -1;
            }
            a4 += c2;
        }
        return a4;
    }

    public static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        j1.b(charSequence, "$this$indexOf");
        j1.b(str, Types.STRING);
        return (z || !(charSequence instanceof String)) ? a(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        j1.b(charSequence, "$this$indexOfAny");
        j1.b(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int a3 = r1.a(i, 0);
            int a4 = a(charSequence);
            if (a3 > a4) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(a3);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (c2.a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return a3;
                }
                if (a3 == a4) {
                    return -1;
                }
                a3++;
            }
        } else {
            return ((String) charSequence).indexOf(t.a(cArr), i);
        }
    }

    private static final u1<q1> a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new e2(charSequence, i, i2, new a(t.a((Object[]) strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + FormatterType.defaultDecimalSeparator).toString());
    }

    public static /* synthetic */ u1 a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    public static final String a(CharSequence charSequence, q1 q1Var) {
        j1.b(charSequence, "$this$substring");
        j1.b(q1Var, "range");
        return charSequence.subSequence(q1Var.g().intValue(), q1Var.f().intValue() + 1).toString();
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int a3 = a(charSequence, str, 0, z);
            if (a3 == -1 || i == 1) {
                return a0.a(charSequence.toString());
            }
            boolean z2 = i > 0;
            int i3 = 10;
            if (z2) {
                i3 = r1.b(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, a3).toString());
                i2 = str.length() + a3;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                a3 = a(charSequence, str, i2, z);
            } while (a3 != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + FormatterType.defaultDecimalSeparator).toString());
    }

    public static final List<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        j1.b(charSequence, "$this$split");
        j1.b(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable<q1> a3 = v1.a(a(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(c0.a(a3, 10));
        for (q1 q1Var : a3) {
            arrayList.add(a(charSequence, q1Var));
        }
        return arrayList;
    }

    public static /* synthetic */ List a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return a(charSequence, strArr, z, i);
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        j1.b(charSequence, "$this$regionMatchesImpl");
        j1.b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!c2.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        j1.b(charSequence, "$this$contains");
        j1.b(charSequence2, "other");
        return !(charSequence2 instanceof String) ? a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0 : a(charSequence, (String) charSequence2, 0, z, 2, null) >= 0;
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(charSequence, charSequence2, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        j1.b(charSequence, "$this$lastIndexOf");
        j1.b(str, Types.STRING);
        return (z || !(charSequence instanceof String)) ? a(charSequence, (CharSequence) str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = a(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(charSequence, str, i, z);
    }

    /* access modifiers changed from: private */
    public static final p<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        int a3;
        T t;
        T t2;
        T t3;
        if (z || collection.size() != 1) {
            o1 q1Var = !z2 ? new q1(r1.a(i, 0), charSequence.length()) : r1.c(r1.b(i, a(charSequence)), 0);
            if (charSequence instanceof String) {
                a3 = q1Var.a();
                int b = q1Var.b();
                int c = q1Var.c();
                if (c < 0 ? a3 >= b : a3 <= b) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t3 = null;
                                break;
                            }
                            t3 = it.next();
                            T t4 = t3;
                            if (o2.a(t4, 0, (String) charSequence, a3, t4.length(), z)) {
                                break;
                            }
                        }
                        t2 = t3;
                        if (t2 == null) {
                            if (a3 == b) {
                                break;
                            }
                            a3 += c;
                        } else {
                            break;
                        }
                    }
                }
                return null;
            }
            a3 = q1Var.a();
            int b2 = q1Var.b();
            int c2 = q1Var.c();
            if (c2 < 0 ? a3 >= b2 : a3 <= b2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t = null;
                            break;
                        }
                        t = it2.next();
                        T t5 = t;
                        if (a(t5, 0, charSequence, a3, t5.length(), z)) {
                            break;
                        }
                    }
                    t2 = t;
                    if (t2 == null) {
                        if (a3 == b2) {
                            break;
                        }
                        a3 += c2;
                    } else {
                        break;
                    }
                }
            }
            return null;
            return r.a(Integer.valueOf(a3), t2);
        }
        String str = (String) z.b(collection);
        int a4 = !z2 ? a(charSequence, str, i, false, 4, (Object) null) : b(charSequence, str, i, false, 4, null);
        if (a4 < 0) {
            return null;
        }
        return r.a(Integer.valueOf(a4), str);
    }
}
