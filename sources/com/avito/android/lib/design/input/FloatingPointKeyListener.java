package com.avito.android.lib.design.input;

import a2.b.a.a.a;
import android.text.method.NumberKeyListener;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001*B9\u0012\b\b\u0002\u0010#\u001a\u00020\u0014\u0012\b\b\u0002\u0010$\u001a\u00020\u0014\u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\b\b\u0002\u0010&\u001a\u00020\u0018\u0012\b\b\u0002\u0010'\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007JA\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010 R\u0016\u0010\"\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010 ¨\u0006+"}, d2 = {"Lcom/avito/android/lib/design/input/FloatingPointKeyListener;", "Landroid/text/method/NumberKeyListener;", "", "getAcceptedChars", "()[C", "", "getInputType", "()I", "", "source", Tracker.Events.CREATIVE_START, "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;", "", "c", "", AuthSource.BOOKING_ORDER, "(C)Z", AuthSource.SEND_ABUSE, "", "d", "Ljava/lang/String;", "mDecimalPointChars", "[C", "mAccepted", "e", "mSignChars", "Z", "mSign", "mDecimal", "sign", "decimal", "digits", "decimalSeparators", "allowedSymbols", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingPointKeyListener extends NumberKeyListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final Object f = new Object();
    public static final HashMap<FormatterType, FloatingPointKeyListener> g = new HashMap<>();
    public char[] a;
    public final boolean b;
    public final boolean c;
    public String d;
    public String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR2\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/lib/design/input/FloatingPointKeyListener$Companion;", "", "Lcom/avito/android/lib/design/input/FormatterType;", "formatterType", "Lcom/avito/android/lib/design/input/FloatingPointKeyListener;", "getInstance", "(Lcom/avito/android/lib/design/input/FormatterType;)Lcom/avito/android/lib/design/input/FloatingPointKeyListener;", "", "DEFAULT_SIGN_CHARS", "Ljava/lang/String;", "sLocaleCacheLock", "Ljava/lang/Object;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sLocaleInstanceCache", "Ljava/util/HashMap;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v4 java.lang.Character), (wrap: char : ?: SGET   com.avito.android.lib.design.input.FormatterType.defaultDecimalSeparator char)] */
        @NotNull
        public final FloatingPointKeyListener getInstance(@NotNull FormatterType formatterType) {
            FloatingPointKeyListener floatingPointKeyListener;
            Intrinsics.checkNotNullParameter(formatterType, "formatterType");
            synchronized (FloatingPointKeyListener.f) {
                FloatingPointKeyListener floatingPointKeyListener2 = (FloatingPointKeyListener) FloatingPointKeyListener.g.get(formatterType);
                if (floatingPointKeyListener2 != null) {
                    return floatingPointKeyListener2;
                }
                MaskParameters maskParameters = formatterType.getMaskParameters();
                Character valueOf = maskParameters != null ? Character.valueOf(maskParameters.getDecimalSeparator()) : null;
                if (valueOf == null) {
                    floatingPointKeyListener = new FloatingPointKeyListener(false, false, null, String.valueOf((char) FormatterType.defaultDecimalSeparator), formatterType.getAllowedSymbols(), 7, null);
                } else {
                    String allowedSymbols = formatterType.getAllowedSymbols();
                    StringBuilder sb = new StringBuilder();
                    sb.append(valueOf);
                    sb.append(FormatterType.defaultDecimalSeparator);
                    floatingPointKeyListener = new FloatingPointKeyListener(false, false, null, sb.toString(), allowedSymbols, 7, null);
                }
                return floatingPointKeyListener;
            }
        }

        public Companion(j jVar) {
        }
    }

    public FloatingPointKeyListener() {
        this(false, false, null, null, null, 31, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FloatingPointKeyListener(boolean r4, boolean r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, t6.r.a.j r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0005
            r4 = 0
        L_0x0005:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            r5 = 1
            r10 = 1
            goto L_0x000d
        L_0x000c:
            r10 = r5
        L_0x000d:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            java.lang.String r6 = "0123456789"
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x002d
            java.util.Locale r5 = java.util.Locale.getDefault()
            java.text.DecimalFormatSymbols r5 = java.text.DecimalFormatSymbols.getInstance(r5)
            java.lang.String r6 = "DecimalFormatSymbols.get…ance(Locale.getDefault())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            char r5 = r5.getDecimalSeparator()
            java.lang.String r7 = java.lang.String.valueOf(r5)
        L_0x002d:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0036
            java.lang.String r8 = a2.b.a.a.a.c3(r0, r1)
        L_0x0036:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.input.FloatingPointKeyListener.<init>(boolean, boolean, java.lang.String, java.lang.String, java.lang.String, int, t6.r.a.j):void");
    }

    public final boolean a(char c2) {
        return StringsKt__StringsKt.indexOf$default(this.d, c2, 0, false, 6, null) != -1;
    }

    public final boolean b(char c2) {
        return StringsKt__StringsKt.indexOf$default(this.e, c2, 0, false, 6, null) != -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095 A[LOOP:2: B:28:0x005d->B:47:0x0095, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0098 A[EDGE_INSN: B:59:0x0098->B:48:0x0098 ?: BREAK  , SYNTHETIC] */
    @Override // android.text.method.NumberKeyListener, android.text.InputFilter
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence filter(@org.jetbrains.annotations.NotNull java.lang.CharSequence r9, int r10, int r11, @org.jetbrains.annotations.NotNull android.text.Spanned r12, int r13, int r14) {
        /*
            r8 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "dest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.CharSequence r0 = super.filter(r9, r10, r11, r12, r13, r14)
            boolean r1 = r8.b
            if (r1 != 0) goto L_0x0017
            boolean r1 = r8.c
            if (r1 != 0) goto L_0x0017
            return r0
        L_0x0017:
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r11 = r0.length()
            r9 = r0
            r10 = 0
        L_0x0020:
            int r2 = r12.length()
            r3 = -1
            r4 = -1
            r5 = 0
        L_0x0027:
            if (r5 >= r13) goto L_0x003f
            char r6 = r12.charAt(r5)
            boolean r7 = r8.b(r6)
            if (r7 == 0) goto L_0x0035
            r3 = r5
            goto L_0x003c
        L_0x0035:
            boolean r6 = r8.a(r6)
            if (r6 == 0) goto L_0x003c
            r4 = r5
        L_0x003c:
            int r5 = r5 + 1
            goto L_0x0027
        L_0x003f:
            java.lang.String r5 = ""
            if (r14 >= r2) goto L_0x0058
            char r6 = r12.charAt(r14)
            boolean r7 = r8.b(r6)
            if (r7 == 0) goto L_0x004e
            return r5
        L_0x004e:
            boolean r5 = r8.a(r6)
            if (r5 == 0) goto L_0x0055
            r4 = r14
        L_0x0055:
            int r14 = r14 + 1
            goto L_0x003f
        L_0x0058:
            r12 = 0
            int r14 = r11 + -1
            if (r14 < r10) goto L_0x0098
        L_0x005d:
            char r2 = r9.charAt(r14)
            boolean r6 = r8.b(r2)
            r7 = 1
            if (r6 == 0) goto L_0x0072
            if (r14 != r10) goto L_0x007d
            if (r13 == 0) goto L_0x006d
            goto L_0x007d
        L_0x006d:
            if (r3 < 0) goto L_0x0070
            goto L_0x007d
        L_0x0070:
            r3 = r14
            goto L_0x007c
        L_0x0072:
            boolean r2 = r8.a(r2)
            if (r2 == 0) goto L_0x007c
            if (r4 < 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r4 = r14
        L_0x007c:
            r7 = 0
        L_0x007d:
            if (r7 == 0) goto L_0x0093
            int r2 = r10 + 1
            if (r11 != r2) goto L_0x0084
            return r5
        L_0x0084:
            if (r12 != 0) goto L_0x008b
            android.text.SpannableStringBuilder r12 = new android.text.SpannableStringBuilder
            r12.<init>(r9, r10, r11)
        L_0x008b:
            int r2 = r14 - r10
            int r6 = r14 + 1
            int r6 = r6 - r10
            r12.delete(r2, r6)
        L_0x0093:
            if (r14 == r10) goto L_0x0098
            int r14 = r14 + -1
            goto L_0x005d
        L_0x0098:
            if (r12 == 0) goto L_0x009b
            r0 = r12
        L_0x009b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.input.FloatingPointKeyListener.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }

    @Override // android.text.method.NumberKeyListener
    @NotNull
    public char[] getAcceptedChars() {
        return this.a;
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        int i = this.b ? 4098 : 2;
        return this.c ? i | 8192 : i;
    }

    public FloatingPointKeyListener(boolean z, boolean z2, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "digits", str2, "decimalSeparators", str3, "allowedSymbols");
        this.a = new char[0];
        this.b = z;
        this.c = z2;
        this.d = str2;
        this.e = "-+";
        char[] charArray = str3.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        this.a = charArray;
    }
}
