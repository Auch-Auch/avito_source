package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat ANYRTL_LTR = new e(a.a, false);
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE = f.b;
    public static final TextDirectionHeuristicCompat LTR = new e(null, false);
    public static final TextDirectionHeuristicCompat RTL = new e(null, true);

    public static class a implements c {
        public static final a a = new a(true);

        public a(boolean z) {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (true) {
                char c = 2;
                if (i >= i3) {
                    return z ? 1 : 2;
                }
                byte directionality = Character.getDirectionality(charSequence.charAt(i));
                TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
                if (directionality == 0) {
                    c = 1;
                } else if (directionality == 1 || directionality == 2) {
                    c = 0;
                }
                if (c == 0) {
                    return 0;
                }
                if (c == 1) {
                    z = true;
                }
                i++;
            }
        }
    }

    public static class b implements c {
        public static final b a = new b();

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i));
                TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
                if (directionality != 0) {
                    if (!(directionality == 1 || directionality == 2)) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                i4 = 2;
                                break;
                        }
                        i++;
                    }
                    i4 = 0;
                    i++;
                }
                i4 = 1;
                i++;
            }
            return i4;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    public static abstract class d implements TextDirectionHeuristicCompat {
        public final c a;

        public d(c cVar) {
            this.a = cVar;
        }

        public abstract boolean a();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl(CharBuffer.wrap(cArr), i, i2);
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            c cVar = this.a;
            if (cVar == null) {
                return a();
            }
            int a3 = cVar.a(charSequence, i, i2);
            if (a3 == 0) {
                return true;
            }
            if (a3 != 1) {
                return a();
            }
            return false;
        }
    }

    public static class e extends d {
        public final boolean b;

        public e(c cVar, boolean z) {
            super(cVar);
            this.b = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.d
        public boolean a() {
            return this.b;
        }
    }

    public static class f extends d {
        public static final f b = new f();

        public f() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.d
        public boolean a() {
            return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.a;
        FIRSTSTRONG_LTR = new e(bVar, false);
        FIRSTSTRONG_RTL = new e(bVar, true);
    }
}
