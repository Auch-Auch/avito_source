package ru.avito.component.text_input;

import androidx.annotation.VisibleForTesting;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010!\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0013\u0010\u001b\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, d2 = {"Lru/avito/component/text_input/Mask;", "", "", "text", "Lkotlin/ranges/IntRange;", "range", "rawText", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/CharSequence;", "", "correlatesWithText", "(Ljava/lang/CharSequence;)Z", "", "maskCursor", "previousPlaceholderPosition", "(I)I", "filledText", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "rawCursorPosition", "cursorPosition", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "maskSymbolsIndexed", AuthSource.SEND_ABUSE, "placeholderPositions", "getMaskPlaceholdersCount", "()I", "maskPlaceholdersCount", "", "c", "Ljava/lang/String;", "getMask$ui_components_release", "()Ljava/lang/String;", "mask", "", "d", "C", InternalConstsKt.PLACEHOLDER, "<init>", "(Ljava/lang/String;C)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class Mask {
    public final List<Integer> a;
    public final List<Integer> b;
    @NotNull
    public final String c;
    public final char d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            int i = this.a;
            boolean z = false;
            if (i == 0) {
                if (((Ref.IntRef) this.b).element < ((CharSequence) this.c).length()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (i == 1) {
                if (((Ref.IntRef) this.c).element < ((Mask) this.b).b.size() && ((Number) ((Mask) this.b).b.get(((Ref.IntRef) this.c).element)).intValue() == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function1<Integer, StringBuilder> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj, Object obj2) {
            super(1);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final StringBuilder invoke(Integer num) {
            int i = this.a;
            if (i == 0) {
                int intValue = num.intValue();
                StringBuilder sb = (StringBuilder) this.c;
                sb.append(((Mask) this.b).getMask$ui_components_release().charAt(intValue));
                Intrinsics.checkNotNullExpressionValue(sb, "filledMask.append(mask[position])");
                return sb;
            } else if (i == 1) {
                int intValue2 = num.intValue();
                StringBuilder sb2 = (StringBuilder) this.b;
                sb2.append(((CharSequence) this.c).charAt(intValue2));
                Intrinsics.checkNotNullExpressionValue(sb2, "filledMask.append(rawText[position])");
                return sb2;
            } else {
                throw null;
            }
        }
    }

    public Mask(@VisibleForTesting @NotNull String str, char c2) {
        Intrinsics.checkNotNullParameter(str, "mask");
        this.c = str;
        this.d = c2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i2 + 1;
            if (str.charAt(i) == this.d) {
                arrayList.add(Integer.valueOf(i2));
            }
            i++;
            i2 = i3;
        }
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        String str2 = this.c;
        int i4 = 0;
        for (int i5 = 0; i5 < str2.length(); i5++) {
            if (str2.charAt(i5) == this.d) {
                arrayList2.add(Integer.valueOf(i4));
                i4++;
            } else {
                arrayList2.add(-1);
            }
        }
        this.b = arrayList2;
    }

    public static /* synthetic */ CharSequence rawText$default(Mask mask, CharSequence charSequence, IntRange intRange, int i, Object obj) {
        if ((i & 2) != 0) {
            intRange = new IntRange(0, charSequence.length());
        }
        return mask.rawText(charSequence, intRange);
    }

    public final boolean correlatesWithText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        if (charSequence.length() == 0) {
            return false;
        }
        int min = Math.min(this.c.length(), charSequence.length());
        for (int i = 0; i < min; i++) {
            boolean z = this.c.charAt(i) != this.d;
            boolean z2 = this.c.charAt(i) != charSequence.charAt(i);
            if (z && z2) {
                return false;
            }
        }
        return true;
    }

    public final int cursorPosition(int i) {
        if (i < this.a.size()) {
            return this.a.get(i).intValue();
        }
        return (i - this.a.size()) + this.c.length();
    }

    @NotNull
    public final CharSequence filledText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "rawText");
        StringBuilder sb = new StringBuilder();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = 0;
        b bVar = new b(0, this, sb);
        b bVar2 = new b(1, sb, charSequence);
        boolean z = true;
        while (z) {
            Lazy lazy = c.lazy(new a(1, this, intRef));
            Lazy lazy2 = c.lazy(new a(0, intRef2, charSequence));
            if (((Boolean) lazy.getValue()).booleanValue()) {
                int i = intRef.element;
                StringBuilder sb2 = (StringBuilder) bVar.c;
                sb2.append(((Mask) bVar.b).getMask$ui_components_release().charAt(i));
                Intrinsics.checkNotNullExpressionValue(sb2, "filledMask.append(mask[position])");
            } else if (((Boolean) lazy2.getValue()).booleanValue()) {
                int i2 = intRef2.element;
                intRef2.element = i2 + 1;
                StringBuilder sb3 = (StringBuilder) bVar2.b;
                sb3.append(((CharSequence) bVar2.c).charAt(i2));
                Intrinsics.checkNotNullExpressionValue(sb3, "filledMask.append(rawText[position])");
            } else {
                z = false;
            }
            intRef.element++;
        }
        String sb4 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "filledMask.toString()");
        return sb4;
    }

    @NotNull
    public final String getMask$ui_components_release() {
        return this.c;
    }

    public final int getMaskPlaceholdersCount() {
        return this.a.size();
    }

    public final int previousPlaceholderPosition(int i) {
        if (i > this.b.size()) {
            return i - 1;
        }
        for (int min = Math.min(this.b.size() - 1, i - 1); min >= 0; min--) {
            if (this.b.get(min).intValue() != -1) {
                return min;
            }
        }
        return this.a.get(0).intValue();
    }

    @NotNull
    public final CharSequence rawText(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(intRange, "range");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.a.size() && charSequence.length() > this.a.get(i).intValue()) {
            int intValue = this.a.get(i).intValue();
            if (intRange.contains(intValue)) {
                sb.append(charSequence.charAt(intValue));
            }
            i++;
        }
        if (charSequence.length() > this.c.length() && intRange.contains(this.c.length())) {
            sb.append(charSequence.subSequence(this.c.length(), Math.min(charSequence.length(), intRange.getEndInclusive().intValue())).toString());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "rawChars.toString()");
        return sb2;
    }
}
