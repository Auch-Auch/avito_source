package t6.y;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
public class f extends e {

    public static final class a extends Lambda implements Function1<String, String> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public String invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "line");
            return str2;
        }
    }

    public static final class b extends Lambda implements Function1<String, String> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public String invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "line");
            return a2.b.a.a.a.t(new StringBuilder(), this.a, str2);
        }
    }

    public static final class c extends Lambda implements Function1<String, String> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.a = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public String invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            if (!m.isBlank(str2)) {
                return a2.b.a.a.a.t(new StringBuilder(), this.a, str2);
            }
            if (str2.length() < this.a.length()) {
                return this.a;
            }
            return str2;
        }
    }

    public static final Function1<String, String> a(String str) {
        if (str.length() == 0) {
            return a.a;
        }
        return new b(str);
    }

    @NotNull
    public static final String prependIndent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$prependIndent");
        Intrinsics.checkNotNullParameter(str2, "indent");
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.map(StringsKt__StringsKt.lineSequence(str), new c(str2)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    @NotNull
    public static final String replaceIndent(@NotNull String str, @NotNull String str2) {
        int i;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "$this$replaceIndent");
        Intrinsics.checkNotNullParameter(str2, "newIndent");
        List<String> lines = StringsKt__StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (T t : lines) {
            if (!m.isBlank(t)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            int length = str3.length();
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (!a.isWhitespace(str3.charAt(i))) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                i = str3.length();
            }
            arrayList2.add(Integer.valueOf(i));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable<? extends Comparable>) arrayList2);
        int intValue = num != null ? num.intValue() : 0;
        int size = (lines.size() * str2.length()) + str.length();
        Function1<String, String> a3 = a(str2);
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        for (T t2 : lines) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t3 = t2;
            if ((i == 0 || i == lastIndex) && m.isBlank(t3)) {
                t3 = null;
            } else {
                String drop = StringsKt___StringsKt.drop((String) t3, intValue);
                if (!(drop == null || (invoke = a3.invoke(drop)) == 0)) {
                    t3 = invoke;
                }
            }
            if (t3 != null) {
                arrayList3.add(t3);
            }
            i = i2;
        }
        String sb = ((StringBuilder) CollectionsKt___CollectionsKt.joinTo$default(arrayList3, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return replaceIndent(str, str2);
    }

    @NotNull
    public static final String replaceIndentByMargin(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        int i;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "$this$replaceIndentByMargin");
        Intrinsics.checkNotNullParameter(str2, "newIndent");
        Intrinsics.checkNotNullParameter(str3, "marginPrefix");
        if (!m.isBlank(str3)) {
            List<String> lines = StringsKt__StringsKt.lines(str);
            int size = (lines.size() * str2.length()) + str.length();
            Function1<String, String> a3 = a(str2);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (T t : lines) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                String str4 = null;
                if (!(i2 == 0 || i2 == lastIndex) || !m.isBlank(t2)) {
                    int length = t2.length();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            i = -1;
                            break;
                        } else if (!a.isWhitespace(t2.charAt(i4))) {
                            i = i4;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (i != -1 && m.startsWith$default(t2, str3, i, false, 4, null)) {
                        Objects.requireNonNull(t2, "null cannot be cast to non-null type java.lang.String");
                        str4 = t2.substring(str3.length() + i);
                        Intrinsics.checkNotNullExpressionValue(str4, "(this as java.lang.String).substring(startIndex)");
                    }
                    if (!(str4 == null || (invoke = a3.invoke(str4)) == null)) {
                        t2 = invoke;
                    }
                    str4 = t2;
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i2 = i3;
            }
            String sb = ((StringBuilder) CollectionsKt___CollectionsKt.joinTo$default(arrayList, new StringBuilder(size), "\n", null, null, 0, null, null, 124, null)).toString();
            Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    @NotNull
    public static final String trimIndent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$trimIndent");
        return replaceIndent(str, "");
    }

    @NotNull
    public static final String trimMargin(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$trimMargin");
        Intrinsics.checkNotNullParameter(str2, "marginPrefix");
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
