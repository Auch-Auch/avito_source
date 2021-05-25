package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import t6.n.h;
import t6.v.e;
import t6.y.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class RegexKt {
    public static final MatchResult access$findNext(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final /* synthetic */ Set access$fromInt(int i) {
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet allOf = EnumSet.allOf(Enum.class);
        h.retainAll(allOf, new Function1<T, Boolean>(i) { // from class: kotlin.text.RegexKt$fromInt$$inlined$apply$lambda$1
            public final /* synthetic */ int a;

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke((RegexKt$fromInt$$inlined$apply$lambda$1) ((Enum) obj)));
            }

            public final boolean invoke(T t) {
                T t2 = t;
                return (this.a & t2.getMask()) == t2.getValue();
            }
        });
        Set unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    public static final MatchResult access$matchEntire(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    public static final IntRange access$range(MatchResult matchResult) {
        return e.until(matchResult.start(), matchResult.end());
    }

    public static final int access$toInt(Iterable iterable) {
        Iterator it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i |= ((c) it.next()).getValue();
        }
        return i;
    }

    public static final IntRange access$range(MatchResult matchResult, int i) {
        return e.until(matchResult.start(i), matchResult.end(i));
    }
}
