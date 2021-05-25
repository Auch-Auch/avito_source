package l6.h.f;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.LocaleListCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
public final class a implements b {
    public static final Locale[] c = new Locale[0];
    public static final Locale d = new Locale("en", "XA");
    public static final Locale e = new Locale("ar", "XB");
    public static final Locale f = LocaleListCompat.a("en-Latn");
    public final Locale[] a;
    @NonNull
    public final String b;

    public a(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.a = c;
            this.b = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException(a2.b.a.a.a.Q2("list[", i, "] is null"));
            } else if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                localeArr2[i] = locale2;
                sb.append(locale2.getLanguage());
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    sb.append('-');
                    sb.append(locale2.getCountry());
                }
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.Q2("list[", i, "] is a repetition"));
            }
        }
        this.a = localeArr2;
        this.b = sb.toString();
    }

    public static boolean f(Locale locale) {
        return d.equals(locale) || e.equals(locale);
    }

    @Override // l6.h.f.b
    public String a() {
        return this.b;
    }

    @Override // l6.h.f.b
    @Nullable
    public Object b() {
        return null;
    }

    @Override // l6.h.f.b
    public Locale c(@NonNull String[] strArr) {
        List asList = Arrays.asList(strArr);
        Locale[] localeArr = this.a;
        int i = 0;
        if (localeArr.length != 1) {
            if (localeArr.length == 0) {
                i = -1;
            } else {
                Iterator it = asList.iterator();
                int i2 = Integer.MAX_VALUE;
                while (true) {
                    if (it.hasNext()) {
                        int e2 = e(LocaleListCompat.a((String) it.next()));
                        if (e2 == 0) {
                            break;
                        } else if (e2 < i2) {
                            i2 = e2;
                        }
                    } else if (i2 != Integer.MAX_VALUE) {
                        i = i2;
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.a[i];
    }

    @Override // l6.h.f.b
    public int d(Locale locale) {
        int i = 0;
        while (true) {
            Locale[] localeArr = this.a;
            if (i >= localeArr.length) {
                return -1;
            }
            if (localeArr[i].equals(locale)) {
                return i;
            }
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Locale] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r3.equals(r2.getCountry()) == false) goto L_0x0056;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int e(java.util.Locale r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            java.util.Locale[] r2 = r7.a
            int r3 = r2.length
            if (r1 >= r3) goto L_0x006d
            r2 = r2[r1]
            boolean r3 = r8.equals(r2)
            r4 = 1
            if (r3 == 0) goto L_0x0011
            goto L_0x0067
        L_0x0011:
            java.lang.String r3 = r8.getLanguage()
            java.lang.String r5 = r2.getLanguage()
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0020
            goto L_0x0056
        L_0x0020:
            boolean r3 = f(r8)
            if (r3 != 0) goto L_0x0056
            boolean r3 = f(r2)
            if (r3 == 0) goto L_0x002d
            goto L_0x0056
        L_0x002d:
            java.lang.String r3 = r8.getScript()
            boolean r5 = r3.isEmpty()
            java.lang.String r6 = ""
            if (r5 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r3 = r6
        L_0x003b:
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0058
            java.lang.String r3 = r8.getCountry()
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0067
            java.lang.String r2 = r2.getCountry()
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0056
            goto L_0x0067
        L_0x0056:
            r4 = 0
            goto L_0x0067
        L_0x0058:
            java.lang.String r2 = r2.getScript()
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0063
            r6 = r2
        L_0x0063:
            boolean r4 = r3.equals(r6)
        L_0x0067:
            if (r4 <= 0) goto L_0x006a
            return r1
        L_0x006a:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x006d:
            r8 = 2147483647(0x7fffffff, float:NaN)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.h.f.a.e(java.util.Locale):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        Locale[] localeArr = ((a) obj).a;
        if (this.a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.a;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // l6.h.f.b
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.a;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    @Override // l6.h.f.b
    public boolean isEmpty() {
        return this.a.length == 0;
    }

    @Override // l6.h.f.b
    public int size() {
        return this.a.length;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.a;
            if (i < localeArr.length) {
                L.append(localeArr[i]);
                if (i < this.a.length - 1) {
                    L.append(',');
                }
                i++;
            } else {
                L.append("]");
                return L.toString();
            }
        }
    }
}
