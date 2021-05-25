package kotlin.text;

import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.preferences.db_preferences.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.v.e;
import t6.y.m;
import t6.y.n;
import t6.y.o;
public class StringsKt__StringsKt extends m {

    public static final class a extends Lambda implements Function1<IntRange, String> {
        public final /* synthetic */ CharSequence a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CharSequence charSequence) {
            super(1);
            this.a = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public String invoke(IntRange intRange) {
            IntRange intRange2 = intRange;
            Intrinsics.checkNotNullParameter(intRange2, "it");
            return StringsKt__StringsKt.substring(this.a, intRange2);
        }
    }

    public static final class b extends Lambda implements Function1<IntRange, String> {
        public final /* synthetic */ CharSequence a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CharSequence charSequence) {
            super(1);
            this.a = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public String invoke(IntRange intRange) {
            IntRange intRange2 = intRange;
            Intrinsics.checkNotNullParameter(intRange2, "it");
            return StringsKt__StringsKt.substring(this.a, intRange2);
        }
    }

    public static final Pair<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        T t;
        T t2;
        if (z || collection.size() != 1) {
            IntProgression intRange = !z2 ? new IntRange(e.coerceAtLeast(i, 0), charSequence.length()) : e.downTo(e.coerceAtMost(i, getLastIndex(charSequence)), 0);
            if (charSequence instanceof String) {
                int first = intRange.getFirst();
                int last = intRange.getLast();
                int step = intRange.getStep();
                if (step < 0 ? first >= last : first <= last) {
                    while (true) {
                        Iterator<T> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t2 = null;
                                break;
                            }
                            t2 = it.next();
                            T t3 = t2;
                            if (m.regionMatches((String) t3, 0, (String) charSequence, first, t3.length(), z)) {
                                break;
                            }
                        }
                        T t4 = t2;
                        if (t4 == null) {
                            if (first == last) {
                                break;
                            }
                            first += step;
                        } else {
                            return TuplesKt.to(Integer.valueOf(first), t4);
                        }
                    }
                }
            } else {
                int first2 = intRange.getFirst();
                int last2 = intRange.getLast();
                int step2 = intRange.getStep();
                if (step2 < 0 ? first2 >= last2 : first2 <= last2) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it2.next();
                            T t5 = t;
                            if (regionMatchesImpl(t5, 0, charSequence, first2, t5.length(), z)) {
                                break;
                            }
                        }
                        T t7 = t;
                        if (t7 == null) {
                            if (first2 == last2) {
                                break;
                            }
                            first2 += step2;
                        } else {
                            return TuplesKt.to(Integer.valueOf(first2), t7);
                        }
                    }
                }
            }
            return null;
        }
        String str = (String) CollectionsKt___CollectionsKt.single(collection);
        int indexOf$default = !z2 ? indexOf$default(charSequence, str, i, false, 4, (Object) null) : lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
        if (indexOf$default < 0) {
            return null;
        }
        return TuplesKt.to(Integer.valueOf(indexOf$default), str);
    }

    public static final int c(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            intProgression = new IntRange(e.coerceAtLeast(i, 0), e.coerceAtMost(i2, charSequence.length()));
        } else {
            intProgression = e.downTo(e.coerceAtMost(i, getLastIndex(charSequence)), e.coerceAtLeast(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intProgression.getFirst();
            int last = intProgression.getLast();
            int step = intProgression.getStep();
            if (step >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!regionMatchesImpl(charSequence2, 0, charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = intProgression.getFirst();
        int last2 = intProgression.getLast();
        int step2 = intProgression.getStep();
        if (step2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!m.regionMatches((String) charSequence2, 0, (String) charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    @NotNull
    public static final String commonPrefixWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$commonPrefixWith");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && t6.y.b.equals(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (hasSurrogatePairAt(charSequence, i2) || hasSurrogatePairAt(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    @NotNull
    public static final String commonSuffixWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$commonSuffixWith");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        int i = 0;
        while (i < min && t6.y.b.equals(charSequence.charAt((length - i) - 1), charSequence2.charAt((length2 - i) - 1), z)) {
            i++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i) - 1) || hasSurrogatePairAt(charSequence2, (length2 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final boolean contains(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$contains");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (d(charSequence, charSequence2, 0, charSequence.length(), z, false, 16) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static /* synthetic */ int d(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3) {
        return c(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static Sequence e(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3) {
        boolean z2 = false;
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        if (i2 >= 0) {
            z2 = true;
        }
        if (z2) {
            return new DelimitedRangesSequence(charSequence, i, i2, new n(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + FormatterType.defaultDecimalSeparator).toString());
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$endsWith");
        return charSequence.length() > 0 && t6.y.b.equals(charSequence.charAt(getLastIndex(charSequence)), c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    public static Sequence f(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3) {
        boolean z2 = false;
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        if (i2 >= 0) {
            z2 = true;
        }
        if (z2) {
            return new DelimitedRangesSequence(charSequence, i, i2, new o(ArraysKt___ArraysJvmKt.asList(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + FormatterType.defaultDecimalSeparator).toString());
    }

    @Nullable
    public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$findAnyOf");
        Intrinsics.checkNotNullParameter(collection, "strings");
        return b(charSequence, collection, i, z, false);
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i, z);
    }

    @Nullable
    public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$findLastAnyOf");
        Intrinsics.checkNotNullParameter(collection, "strings");
        return b(charSequence, collection, i, z, true);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i, z);
    }

    public static final List<String> g(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int indexOf = indexOf(charSequence, str, 0, z);
            if (indexOf == -1 || i == 1) {
                return d.listOf(charSequence.toString());
            }
            boolean z2 = i > 0;
            int i3 = 10;
            if (z2) {
                i3 = e.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                indexOf = indexOf(charSequence, str, i2, z);
            } while (indexOf != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + FormatterType.defaultDecimalSeparator).toString());
    }

    @NotNull
    public static final IntRange getIndices(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indices");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$hasSurrogatePairAt");
        int length = charSequence.length() - 2;
        if (i >= 0 && length >= i && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1))) {
            return true;
        }
        return false;
    }

    public static final int indexOf(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOf");
        if (z || !(charSequence instanceof String)) {
            return indexOfAny(charSequence, new char[]{c}, i, z);
        }
        return ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c, i, z);
    }

    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOfAny");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int coerceAtLeast = e.coerceAtLeast(i, 0);
            int lastIndex = getLastIndex(charSequence);
            if (coerceAtLeast > lastIndex) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(coerceAtLeast);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (t6.y.b.equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtLeast;
                }
                if (coerceAtLeast == lastIndex) {
                    return -1;
                }
                coerceAtLeast++;
            }
        } else {
            return ((String) charSequence).indexOf(ArraysKt___ArraysKt.single(cArr), i);
        }
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i, z);
    }

    @NotNull
    public static final CharIterator iterator(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$iterator");
        return new CharIterator(charSequence) { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            public int a;
            public final /* synthetic */ CharSequence b;

            {
                this.b = r1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < this.b.length();
            }

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence2 = this.b;
                int i = this.a;
                this.a = i + 1;
                return charSequence2.charAt(i);
            }
        };
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        if (z || !(charSequence instanceof String)) {
            return lastIndexOfAny(charSequence, new char[]{c}, i, z);
        }
        return ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int coerceAtMost = e.coerceAtMost(i, getLastIndex(charSequence)); coerceAtMost >= 0; coerceAtMost--) {
                char charAt = charSequence.charAt(coerceAtMost);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (t6.y.b.equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtMost;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.single(cArr), i);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i, z);
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lineSequence");
        return splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    @NotNull
    public static final List<String> lines(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lines");
        return SequencesKt___SequencesKt.toList(lineSequence(charSequence));
    }

    @NotNull
    public static final CharSequence padEnd(@NotNull CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$padEnd");
        if (i < 0) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Desired length ", i, " is less than zero."));
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            sb.append(charSequence);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb;
        }
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(charSequence, i, c);
    }

    @NotNull
    public static final CharSequence padStart(@NotNull CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$padStart");
        if (i < 0) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Desired length ", i, " is less than zero."));
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(charSequence, i, c);
    }

    public static final boolean regionMatchesImpl(@NotNull CharSequence charSequence, int i, @NotNull CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$regionMatchesImpl");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!t6.y.b.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final CharSequence removePrefix(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removePrefix");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        if (startsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removeRange");
        if (i2 < i) {
            throw new IndexOutOfBoundsException(a2.b.a.a.a.S2("End index (", i2, ") is less than start index (", i, ")."));
        } else if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(charSequence.length() - (i2 - i));
            sb.append(charSequence, 0, i);
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence, i2, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
    }

    @NotNull
    public static final CharSequence removeSuffix(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removeSuffix");
        Intrinsics.checkNotNullParameter(charSequence2, "suffix");
        if (endsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "suffix");
        if (charSequence.length() < charSequence3.length() + charSequence2.length() || !startsWith$default(charSequence, charSequence2, false, 2, (Object) null) || !endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length());
        }
        return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$replaceAfter", str2, "replacement", str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange(str, indexOf$default + 1, str.length(), str2).toString();
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c, str2, str3);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a2.b.a.a.a.b1(str, "$this$replaceAfterLast", str2, "delimiter", str3, "replacement", str4, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange(str, str2.length() + lastIndexOf$default, str.length(), str3).toString();
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$replaceBefore", str2, "replacement", str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange(str, 0, indexOf$default, str2).toString();
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c, str2, str3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$replaceBeforeLast", str2, "replacement", str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange(str, 0, lastIndexOf$default, str2).toString();
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c, str2, str3);
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence charSequence, int i, int i2, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$replaceRange");
        Intrinsics.checkNotNullParameter(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException(a2.b.a.a.a.S2("End index (", i2, ") is less than start index (", i, ")."));
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$split");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        boolean z2 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                return g(charSequence, str, z, i);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(f(charSequence, strArr, 0, z, i, 2));
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(charSequence, intRange));
        }
        return arrayList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$splitToSequence");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        return SequencesKt___SequencesKt.map(f(charSequence, strArr, 0, z, i, 2), new a(charSequence));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z, i);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$startsWith");
        return charSequence.length() > 0 && t6.y.b.equals(charSequence.charAt(0), c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    @NotNull
    public static final CharSequence subSequence(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$subSequence");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final String substring(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "$this$substring");
        Intrinsics.checkNotNullParameter(intRange, "range");
        String substring = str.substring(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringAfter(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$substringAfter");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$substringAfterLast");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c, str2);
    }

    @NotNull
    public static final String substringBefore(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$substringBefore");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "$this$substringBeforeLast");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trim");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = ((Boolean) a2.b.a.a.a.h2(charSequence, !z ? i : length, function1)).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (((Boolean) a2.b.a.a.a.h2(charSequence, length, function1)).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trimStart");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!((Boolean) a2.b.a.a.a.h2(charSequence, i, function1)).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$endsWith");
        Intrinsics.checkNotNullParameter(charSequence2, "suffix");
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
        }
        return m.endsWith$default((String) charSequence, (String) charSequence2, false, 2, null);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, collection, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, collection, i, z);
    }

    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(str, i, c);
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(str, i, c);
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c, str2, str3);
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z, i);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$splitToSequence");
        Intrinsics.checkNotNullParameter(cArr, "delimiters");
        return SequencesKt___SequencesKt.map(e(charSequence, cArr, 0, z, i, 2), new b(charSequence));
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, cArr, z, i);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$startsWith");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
        }
        return m.startsWith$default((String) charSequence, (String) charSequence2, false, 2, null);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    @NotNull
    public static final String substring(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$substring");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a2.b.a.a.a.b1(str, "$this$replaceAfter", str2, "delimiter", str3, "replacement", str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange(str, str2.length() + indexOf$default, str.length(), str3).toString();
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$replaceAfterLast", str2, "replacement", str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange(str, lastIndexOf$default + 1, str.length(), str2).toString();
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a2.b.a.a.a.b1(str, "$this$replaceBefore", str2, "delimiter", str3, "replacement", str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange(str, 0, indexOf$default, str3).toString();
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        a2.b.a.a.a.b1(str, "$this$replaceBeforeLast", str2, "delimiter", str3, "replacement", str4, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange(str, 0, lastIndexOf$default, str3).toString();
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i, z);
    }

    @NotNull
    public static final String substringAfter(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$substringAfter", str2, "delimiter", str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(str2.length() + indexOf$default, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$substringAfterLast", str2, "delimiter", str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(str2.length() + lastIndexOf$default, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringBefore(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$substringBefore", str2, "delimiter", str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "$this$substringBeforeLast", str2, "delimiter", str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean contains(@NotNull CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$contains");
        return indexOf$default(charSequence, c, 0, z, 2, null) >= 0;
    }

    public static final int indexOf(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOf");
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        if (z || !(charSequence instanceof String)) {
            return d(charSequence, str, i, charSequence.length(), z, false, 16);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOf");
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        if (z || !(charSequence instanceof String)) {
            return c(charSequence, str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    @NotNull
    public static final String removePrefix(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "$this$removePrefix");
        Intrinsics.checkNotNullParameter(charSequence, "prefix");
        if (!startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public static final String removeSuffix(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "$this$removeSuffix");
        Intrinsics.checkNotNullParameter(charSequence, "suffix");
        if (!endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String str, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(str, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(charSequence, "prefix");
        Intrinsics.checkNotNullParameter(charSequence2, "suffix");
        if (str.length() < charSequence2.length() + charSequence.length() || !startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) || !endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final String trim(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$trim");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(str.charAt(!z ? i : length))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    @NotNull
    public static final String trimEnd(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!function1.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
            } else {
                charSequence = "";
                break;
            }
        }
        return charSequence.toString();
    }

    @NotNull
    public static final String trimStart(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "$this$trimStart");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            } else if (!function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                charSequence = str.subSequence(i, str.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$startsWith");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        if (z || !(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            return regionMatchesImpl(charSequence, i, charSequence2, 0, charSequence2.length(), z);
        }
        return m.startsWith$default((String) charSequence, (String) charSequence2, i, false, 4, null);
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removeRange");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return removeRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(charSequence2, "delimiter");
        return removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence charSequence, @NotNull IntRange intRange, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$replaceRange");
        Intrinsics.checkNotNullParameter(intRange, "range");
        Intrinsics.checkNotNullParameter(charSequence2, "replacement");
        return replaceRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1, charSequence2);
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "$this$removeSurrounding");
        Intrinsics.checkNotNullParameter(charSequence, "delimiter");
        return removeSurrounding(str, charSequence, charSequence);
    }

    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Integer first;
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOfAny");
        Intrinsics.checkNotNullParameter(collection, "strings");
        Pair<Integer, String> b2 = b(charSequence, collection, i, z, false);
        if (b2 == null || (first = b2.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Integer first;
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastIndexOfAny");
        Intrinsics.checkNotNullParameter(collection, "strings");
        Pair<Integer, String> b2 = b(charSequence, collection, i, z, true);
        if (b2 == null || (first = b2.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @NotNull
    public static final String padEnd(@NotNull String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "$this$padEnd");
        return padEnd((CharSequence) str, i, c).toString();
    }

    @NotNull
    public static final String padStart(@NotNull String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "$this$padStart");
        return padStart((CharSequence) str, i, c).toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trim");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!contains) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trimStart");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$split");
        Intrinsics.checkNotNullParameter(cArr, "delimiters");
        if (cArr.length == 1) {
            return g(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(e(charSequence, cArr, 0, z, i, 2));
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(asIterable, 10));
        for (IntRange intRange : asIterable) {
            arrayList.add(substring(charSequence, intRange));
        }
        return arrayList;
    }

    @NotNull
    public static final String trim(@NotNull String str, @NotNull char... cArr) {
        Intrinsics.checkNotNullParameter(str, "$this$trim");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, str.charAt(!z ? i : length));
            if (!z) {
                if (!contains) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    @NotNull
    public static final String trimEnd(@NotNull String str, @NotNull char... cArr) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "$this$trimEnd");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(length))) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                }
            } else {
                charSequence = "";
                break;
            }
        }
        return charSequence.toString();
    }

    @NotNull
    public static final String trimStart(@NotNull String str, @NotNull char... cArr) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "$this$trimStart");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                charSequence = "";
                break;
            } else if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(i))) {
                charSequence = str.subSequence(i, str.length());
                break;
            } else {
                i++;
            }
        }
        return charSequence.toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = t6.y.a.isWhitespace(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!isWhitespace) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trimEnd");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (t6.y.a.isWhitespace(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$trimStart");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!t6.y.a.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }
}
