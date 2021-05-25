package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.h;
import t6.n.q;
import t6.n.x;
import t6.n.y;
import t6.y.p;
public class StringsKt___StringsKt extends p {

    public static final class a extends Lambda implements Function1<CharSequence, String> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics.checkNotNullParameter(charSequence2, "it");
            return charSequence2.toString();
        }
    }

    public static final class b extends Lambda implements Function1<CharSequence, String> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics.checkNotNullParameter(charSequence2, "it");
            return charSequence2.toString();
        }
    }

    public static final class c extends Lambda implements Function1<CharSequence, String> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            Intrinsics.checkNotNullParameter(charSequence2, "it");
            return charSequence2.toString();
        }
    }

    public static final class d extends Lambda implements Function1<Integer, R> {
        public final /* synthetic */ CharSequence a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Function1 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(CharSequence charSequence, int i, Function1 function1) {
            super(1);
            this.a = charSequence;
            this.b = i;
            this.c = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Integer num) {
            int intValue = num.intValue();
            int i = this.b + intValue;
            if (i < 0 || i > this.a.length()) {
                i = this.a.length();
            }
            return this.c.invoke(this.a.subSequence(intValue, i));
        }
    }

    public static final class e extends Lambda implements Function0<Iterator<? extends Character>> {
        public final /* synthetic */ CharSequence a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(CharSequence charSequence) {
            super(0);
            this.a = charSequence;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Character> invoke() {
            return StringsKt__StringsKt.iterator(this.a);
        }
    }

    public static final boolean all(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!((Boolean) a2.b.a.a.a.h2(charSequence, i, function1)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$any");
        return !(charSequence.length() == 0);
    }

    @NotNull
    public static final Iterable<Character> asIterable(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$asIterable");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
        }
        return new Object(charSequence) { // from class: kotlin.text.StringsKt___StringsKt$asIterable$$inlined$Iterable$1
            public final /* synthetic */ CharSequence a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Character> iterator() {
                return StringsKt__StringsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Character> asSequence(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$asSequence");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return SequencesKt__SequencesKt.emptySequence();
            }
        }
        return new Sequence<Character>(charSequence) { // from class: kotlin.text.StringsKt___StringsKt$asSequence$$inlined$Sequence$1
            public final /* synthetic */ CharSequence a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Character> iterator() {
                return StringsKt__StringsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            Pair pair = (Pair) a2.b.a.a.a.h2(charSequence, i, function1);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Character> associateBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(function1.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Character> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@NotNull CharSequence charSequence, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(function1.invoke(Character.valueOf(charAt)), Character.valueOf(charAt));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull CharSequence charSequence, @NotNull M m, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            Pair pair = (Pair) a2.b.a.a.a.h2(charSequence, i, function1);
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <V> Map<Character, V> associateWith(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associateWith");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.v.e.coerceAtMost(charSequence.length(), 128)), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(Character.valueOf(charAt), function1.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: M extends java.util.Map<? super java.lang.Character, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(@NotNull CharSequence charSequence, @NotNull M m, @NotNull Function1<? super Character, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(Character.valueOf(charAt), function1.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<String> chunked(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$chunked");
        return windowed(charSequence, i, i, true);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<String> chunkedSequence(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$chunkedSequence");
        return chunkedSequence(charSequence, i, a.a);
    }

    public static final int count(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (((Boolean) a2.b.a.a.a.h2(charSequence, i2, function1)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @NotNull
    public static final CharSequence drop(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$drop");
        if (i >= 0) {
            return charSequence.subSequence(t6.v.e.coerceAtMost(i, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final CharSequence dropLast(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$dropLast");
        if (i >= 0) {
            return take(charSequence, t6.v.e.coerceAtLeast(charSequence.length() - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final CharSequence dropLastWhile(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) a2.b.a.a.a.h2(charSequence, lastIndex, function1)).booleanValue()) {
                return charSequence.subSequence(0, lastIndex + 1);
            }
        }
        return "";
    }

    @NotNull
    public static final CharSequence dropWhile(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!((Boolean) a2.b.a.a.a.h2(charSequence, i, function1)).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @NotNull
    public static final CharSequence filter(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @NotNull
    public static final CharSequence filterIndexed(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, Boolean> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (function2.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return sb;
    }

    @NotNull
    public static final <C extends Appendable> C filterIndexedTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function2<? super Integer, ? super Character, Boolean> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            int i3 = i2 + 1;
            if (function2.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                c2.append(charAt);
            }
            i++;
            i2 = i3;
        }
        return c2;
    }

    @NotNull
    public static final CharSequence filterNot(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @NotNull
    public static final <C extends Appendable> C filterNotTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                c2.append(charAt);
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Appendable> C filterTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                c2.append(charAt);
            }
        }
        return c2;
    }

    public static final char first(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$first");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @Nullable
    public static final Character firstOrNull(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$firstOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            h.addAll(arrayList, (Iterable) a2.b.a.a.a.h2(charSequence, i, function1));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            h.addAll(c2, (Iterable) a2.b.a.a.a.h2(charSequence, i, function1));
        }
        return c2;
    }

    public static final <R> R fold(@NotNull CharSequence charSequence, R r, @NotNull Function2<? super R, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int i = 0; i < charSequence.length(); i++) {
            r = (R) function2.invoke(r, Character.valueOf(charSequence.charAt(i)));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull CharSequence charSequence, R r, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = (R) function3.invoke(valueOf, r, Character.valueOf(charAt));
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull CharSequence charSequence, R r, @NotNull Function2<? super Character, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull CharSequence charSequence, R r, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Character.valueOf(charSequence.charAt(lastIndex)), r);
        }
        return r;
    }

    public static final void forEach(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Unit> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (int i = 0; i < charSequence.length(); i++) {
            function1.invoke(Character.valueOf(charSequence.charAt(i)));
        }
    }

    public static final void forEachIndexed(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, Unit> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Character.valueOf(charAt));
        }
    }

    @Nullable
    public static final Character getOrNull(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$getOrNull");
        if (i < 0 || i > StringsKt__StringsKt.getLastIndex(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    @NotNull
    public static final <K> Map<K, List<Character>> groupBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = function1.invoke(Character.valueOf(charAt));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@NotNull CharSequence charSequence, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = function1.invoke(Character.valueOf(charAt));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Character.valueOf(charAt));
        }
        return m;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K> Grouping<Character, K> groupingBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$groupingBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        return new Grouping<Character, K>(charSequence, function1) { // from class: kotlin.text.StringsKt___StringsKt$groupingBy$1
            public final /* synthetic */ CharSequence a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.collections.Grouping
            public /* bridge */ /* synthetic */ Object keyOf(Character ch) {
                return keyOf(ch.charValue());
            }

            @Override // kotlin.collections.Grouping
            @NotNull
            public Iterator<Character> sourceIterator() {
                return StringsKt__StringsKt.iterator(this.a);
            }

            public K keyOf(char c2) {
                return (K) this.b.invoke(Character.valueOf(c2));
            }
        };
    }

    public static final int indexOfFirst(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (((Boolean) a2.b.a.a.a.h2(charSequence, i, function1)).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (((Boolean) a2.b.a.a.a.h2(charSequence, length, function1)).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final char last(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$last");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(StringsKt__StringsKt.getLastIndex(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @Nullable
    public static final Character lastOrNull(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    @NotNull
    public static final <R> List<R> map(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            arrayList.add(function1.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Character.valueOf(charAt)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexedNotNull(@NotNull CharSequence charSequence, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$mapIndexedNotNull");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            Object invoke = function2.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$mapIndexedNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i2 + 1;
            Object invoke = function2.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i)));
            if (invoke != null) {
                c2.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            c2.add(function2.invoke(valueOf, Character.valueOf(charAt)));
        }
        return c2;
    }

    @NotNull
    public static final <R> List<R> mapNotNull(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$mapNotNull");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < charSequence.length(); i++) {
            Object h2 = a2.b.a.a.a.h2(charSequence, i, function1);
            if (h2 != null) {
                arrayList.add(h2);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapNotNullTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$mapNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            Object h2 = a2.b.a.a.a.h2(charSequence, i, function1);
            if (h2 != null) {
                c2.add(h2);
            }
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull CharSequence charSequence, @NotNull C c2, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (int i = 0; i < charSequence.length(); i++) {
            c2.add(function1.invoke(Character.valueOf(charSequence.charAt(i))));
        }
        return c2;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Character max(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$max");
        return maxOrNull(charSequence);
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Character maxBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) < 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Character maxByOrNull(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) < 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character maxOrNull(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$maxOrNull");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (Intrinsics.compare((int) charAt, (int) charAt2) < 0) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Character maxWith(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(charSequence, comparator);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character maxWithOrNull(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) < 0) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Character min(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$min");
        return minOrNull(charSequence);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Character minBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) > 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Character minByOrNull(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return Character.valueOf(charAt);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(charAt));
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) > 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character minOrNull(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$minOrNull");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (Intrinsics.compare((int) charAt, (int) charAt2) > 0) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Character minWith(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(charSequence, comparator);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character minWithOrNull(@NotNull CharSequence charSequence, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                char charAt2 = charSequence.charAt(i);
                if (comparator.compare(Character.valueOf(charAt), Character.valueOf(charAt2)) > 0) {
                    charAt = charAt2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final boolean none(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$none");
        return charSequence.length() == 0;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S extends CharSequence> S onEach(@NotNull S s, @NotNull Function1<? super Character, Unit> function1) {
        Intrinsics.checkNotNullParameter(s, "$this$onEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (int i = 0; i < s.length(); i++) {
            function1.invoke(Character.valueOf(s.charAt(i)));
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <S extends CharSequence> S onEachIndexed(@NotNull S s, @NotNull Function2<? super Integer, ? super Character, Unit> function2) {
        Intrinsics.checkNotNullParameter(s, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i = 0;
        for (int i2 = 0; i2 < s.length(); i2++) {
            char charAt = s.charAt(i2);
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Character.valueOf(charAt));
        }
        return s;
    }

    @NotNull
    public static final Pair<CharSequence, CharSequence> partition(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        return new Pair<>(sb, sb2);
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@NotNull CharSequence charSequence, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(random.nextInt(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character randomOrNull(@NotNull CharSequence charSequence, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(random.nextInt(charSequence.length())));
    }

    public static final char reduce(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i = 1;
        if (!(charSequence.length() == 0)) {
            char charAt = charSequence.charAt(0);
            int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
            if (1 <= lastIndex) {
                while (true) {
                    charAt = function2.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final char reduceIndexed(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i = 1;
        if (!(charSequence.length() == 0)) {
            char charAt = charSequence.charAt(0);
            int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
            if (1 <= lastIndex) {
                while (true) {
                    charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character reduceIndexedOrNull(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character reduceOrNull(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (1 <= lastIndex) {
            while (true) {
                charAt = function2.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(charAt);
    }

    public static final char reduceRight(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex >= 0) {
            char charAt = charSequence.charAt(lastIndex);
            for (int i = lastIndex - 1; i >= 0; i--) {
                charAt = function2.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final char reduceRightIndexed(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex >= 0) {
            char charAt = charSequence.charAt(lastIndex);
            for (int i = lastIndex - 1; i >= 0; i--) {
                charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
            }
            return charAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character reduceRightIndexedOrNull(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char charAt = charSequence.charAt(lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
        }
        return Character.valueOf(charAt);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character reduceRightOrNull(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex < 0) {
            return null;
        }
        char charAt = charSequence.charAt(lastIndex);
        for (int i = lastIndex - 1; i >= 0; i--) {
            charAt = function2.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charAt)).charValue();
        }
        return Character.valueOf(charAt);
    }

    @NotNull
    public static final CharSequence reversed(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$reversed");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        Intrinsics.checkNotNullExpressionValue(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <R> List<R> runningFold(@NotNull CharSequence charSequence, R r, @NotNull Function2<? super R, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$runningFold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i = 0;
        if (charSequence.length() == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        Object obj = r;
        while (i < charSequence.length()) {
            Object obj2 = (Object) function2.invoke(obj, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(obj2);
            i++;
            obj = obj2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <R> List<R> runningFoldIndexed(@NotNull CharSequence charSequence, R r, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i = 0;
        if (charSequence.length() == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        Object obj = r;
        while (i < length) {
            Object obj2 = (Object) function3.invoke(Integer.valueOf(i), obj, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(obj2);
            i++;
            obj = obj2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final List<Character> runningReduce(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        for (int i = 1; i < length; i++) {
            charAt = function2.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
            arrayList.add(Character.valueOf(charAt));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final List<Character> runningReduceIndexed(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        for (int i = 1; i < length; i++) {
            charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
            arrayList.add(Character.valueOf(charAt));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <R> List<R> scan(@NotNull CharSequence charSequence, R r, @NotNull Function2<? super R, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$scan");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i = 0;
        if (charSequence.length() == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        Object obj = r;
        while (i < charSequence.length()) {
            Object obj2 = (Object) function2.invoke(obj, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(obj2);
            i++;
            obj = obj2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <R> List<R> scanIndexed(@NotNull CharSequence charSequence, R r, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i = 0;
        if (charSequence.length() == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        Object obj = r;
        while (i < length) {
            Object obj2 = (Object) function3.invoke(Integer.valueOf(i), obj, Character.valueOf(charSequence.charAt(i)));
            arrayList.add(obj2);
            i++;
            obj = obj2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduce instead.", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    public static final List<Character> scanReduce(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$scanReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        for (int i = 1; i < length; i++) {
            charAt = function2.invoke(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
            arrayList.add(Character.valueOf(charAt));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduceIndexed instead.", replaceWith = @ReplaceWith(expression = "runningReduceIndexed(operation)", imports = {}))
    public static final List<Character> scanReduceIndexed(@NotNull CharSequence charSequence, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$scanReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char charAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(charAt));
        int length = charSequence.length();
        for (int i = 1; i < length; i++) {
            charAt = function3.invoke(Integer.valueOf(i), Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))).charValue();
            arrayList.add(Character.valueOf(charAt));
        }
        return arrayList;
    }

    public static final char single(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$single");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        } else if (length == 1) {
            return charSequence.charAt(0);
        } else {
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
    }

    @Nullable
    public static final Character singleOrNull(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$singleOrNull");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @NotNull
    public static final CharSequence slice(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return "";
        }
        return StringsKt__StringsKt.subSequence(charSequence, intRange);
    }

    public static final int sumBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Integer> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            i += ((Number) a2.b.a.a.a.h2(charSequence, i2, function1)).intValue();
        }
        return i;
    }

    public static final double sumByDouble(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Double> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (int i = 0; i < charSequence.length(); i++) {
            d2 += ((Number) a2.b.a.a.a.h2(charSequence, i, function1)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final CharSequence take(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$take");
        if (i >= 0) {
            return charSequence.subSequence(0, t6.v.e.coerceAtMost(i, charSequence.length()));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final CharSequence takeLast(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$takeLast");
        if (i >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - t6.v.e.coerceAtMost(i, length), length);
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final CharSequence takeLastWhile(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(charSequence); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) a2.b.a.a.a.h2(charSequence, lastIndex, function1)).booleanValue()) {
                return charSequence.subSequence(lastIndex + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final CharSequence takeWhile(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!((Boolean) a2.b.a.a.a.h2(charSequence, i, function1)).booleanValue()) {
                return charSequence.subSequence(0, i);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C toCollection(@NotNull CharSequence charSequence, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (int i = 0; i < charSequence.length(); i++) {
            c2.add(Character.valueOf(charSequence.charAt(i)));
        }
        return c2;
    }

    @NotNull
    public static final HashSet<Character> toHashSet(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$toHashSet");
        return (HashSet) toCollection(charSequence, new HashSet(q.mapCapacity(t6.v.e.coerceAtMost(charSequence.length(), 128))));
    }

    @NotNull
    public static final List<Character> toList(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$toList");
        int length = charSequence.length();
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(charSequence);
        }
        return t6.n.d.listOf(Character.valueOf(charSequence.charAt(0)));
    }

    @NotNull
    public static final List<Character> toMutableList(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$toMutableList");
        return (List) toCollection(charSequence, new ArrayList(charSequence.length()));
    }

    @NotNull
    public static final Set<Character> toSet(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$toSet");
        int length = charSequence.length();
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(charSequence, new LinkedHashSet(q.mapCapacity(t6.v.e.coerceAtMost(charSequence.length(), 128))));
        }
        return x.setOf(Character.valueOf(charSequence.charAt(0)));
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<String> windowed(@NotNull CharSequence charSequence, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$windowed");
        return windowed(charSequence, i, i2, z, b.a);
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i, i2, z);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final Sequence<String> windowedSequence(@NotNull CharSequence charSequence, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$windowedSequence");
        return windowedSequence(charSequence, i, i2, z, c.a);
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence charSequence, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i, i2, z);
    }

    @NotNull
    public static final Iterable<IndexedValue<Character>> withIndex(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$withIndex");
        return new IndexingIterable(new e(charSequence));
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull Function2<? super Character, ? super Character, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$zip");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence2.charAt(i))));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> List<R> zipWithNext(@NotNull CharSequence charSequence, @NotNull Function2<? super Character, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$zipWithNext");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            i++;
            arrayList.add(function2.invoke(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (((Boolean) a2.b.a.a.a.h2(charSequence, i, function1)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> List<R> chunked(@NotNull CharSequence charSequence, int i, @NotNull Function1<? super CharSequence, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$chunked");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return windowed(charSequence, i, i, true, function1);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> Sequence<R> chunkedSequence(@NotNull CharSequence charSequence, int i, @NotNull Function1<? super CharSequence, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$chunkedSequence");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return windowedSequence(charSequence, i, i, true, function1);
    }

    @Nullable
    public static final Character firstOrNull(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                return Character.valueOf(charAt);
            }
        }
        return null;
    }

    @Nullable
    public static final Character lastOrNull(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        char charAt;
        Intrinsics.checkNotNullParameter(charSequence, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            charAt = charSequence.charAt(length);
        } while (!function1.invoke(Character.valueOf(charAt)).booleanValue());
        return Character.valueOf(charAt);
    }

    public static final boolean none(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            if (((Boolean) a2.b.a.a.a.h2(charSequence, i, function1)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static final Character singleOrNull(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(charAt);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return ch;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> List<R> windowed(@NotNull CharSequence charSequence, int i, int i2, boolean z, @NotNull Function1<? super CharSequence, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$windowed");
        Intrinsics.checkNotNullParameter(function1, "transform");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        int length = charSequence.length();
        int i3 = 0;
        ArrayList arrayList = new ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        while (i3 >= 0 && length > i3) {
            int i4 = i3 + i;
            if (i4 < 0 || i4 > length) {
                if (!z) {
                    break;
                }
                i4 = length;
            }
            arrayList.add(function1.invoke(charSequence.subSequence(i3, i4)));
            i3 += i2;
        }
        return arrayList;
    }

    public static /* synthetic */ List windowed$default(CharSequence charSequence, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(charSequence, i, i2, z, function1);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <R> Sequence<R> windowedSequence(@NotNull CharSequence charSequence, int i, int i2, boolean z, @NotNull Function1<? super CharSequence, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$windowedSequence");
        Intrinsics.checkNotNullParameter(function1, "transform");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        return SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(t6.v.e.step(z ? StringsKt__StringsKt.getIndices(charSequence) : t6.v.e.until(0, (charSequence.length() - i) + 1), i2)), new d(charSequence, i, function1));
    }

    public static /* synthetic */ Sequence windowedSequence$default(CharSequence charSequence, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowedSequence(charSequence, i, i2, z, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull CharSequence charSequence, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            m.put(function1.invoke(Character.valueOf(charAt)), function12.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    @NotNull
    public static final String drop(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$drop");
        if (i >= 0) {
            String substring = str.substring(t6.v.e.coerceAtMost(i, str.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final String dropLast(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$dropLast");
        if (i >= 0) {
            return take(str, t6.v.e.coerceAtLeast(str.length() - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final String filterNot(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    @NotNull
    public static final String slice(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return "";
        }
        return StringsKt__StringsKt.substring(str, intRange);
    }

    @NotNull
    public static final String take(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$take");
        if (i >= 0) {
            String substring = str.substring(0, t6.v.e.coerceAtMost(i, str.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final String dropLastWhile(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(str); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                String substring = str.substring(0, lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "";
    }

    @NotNull
    public static final String dropWhile(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(i);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return "";
    }

    @NotNull
    public static final String filterIndexed(@NotNull String str, @NotNull Function2<? super Integer, ? super Character, Boolean> function2) {
        Intrinsics.checkNotNullParameter(str, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i3 = i2 + 1;
            if (function2.invoke(Integer.valueOf(i2), Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
            i++;
            i2 = i3;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterIndexedTo(StringBu…(), predicate).toString()");
        return sb2;
    }

    public static final char first(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                return charAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    public static final char last(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        char charAt;
        Intrinsics.checkNotNullParameter(charSequence, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length >= 0) {
                charAt = charSequence.charAt(length);
            } else {
                throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
            }
        } while (!function1.invoke(Character.valueOf(charAt)).booleanValue());
        return charAt;
    }

    @NotNull
    public static final String takeLast(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "$this$takeLast");
        if (i >= 0) {
            int length = str.length();
            String substring = str.substring(length - t6.v.e.coerceAtMost(i, length));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested character count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Pair<Character, Character>> zip(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$zip");
        Intrinsics.checkNotNullParameter(charSequence2, "other");
        int min = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Character.valueOf(charSequence.charAt(i)), Character.valueOf(charSequence2.charAt(i))));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(charSequence.length()), 16));
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            linkedHashMap.put(function1.invoke(Character.valueOf(charAt)), function12.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final String filter(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final char single(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Character ch = null;
        boolean z = false;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(charAt);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(ch, "null cannot be cast to non-null type kotlin.Char");
            return ch.charValue();
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @NotNull
    public static final CharSequence slice(@NotNull CharSequence charSequence, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(collectionSizeOrDefault);
        for (Integer num : iterable) {
            sb.append(charSequence.charAt(num.intValue()));
        }
        return sb;
    }

    @NotNull
    public static final String takeLastWhile(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = StringsKt__StringsKt.getLastIndex(str); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(str.charAt(lastIndex))).booleanValue()) {
                String substring = str.substring(lastIndex + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return str;
    }

    @NotNull
    public static final String takeWhile(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
                String substring = str.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return str;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final List<Pair<Character, Character>> zipWithNext(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$zipWithNext");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            i++;
            arrayList.add(TuplesKt.to(Character.valueOf(charAt), Character.valueOf(charSequence.charAt(i))));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull CharSequence charSequence, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = function1.invoke(Character.valueOf(charAt));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Character.valueOf(charAt)));
        }
        return m;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Object invoke = function1.invoke(Character.valueOf(charAt));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Character.valueOf(charAt)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Pair<String, String> partition(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
                sb.append(charAt);
            } else {
                sb2.append(charAt);
            }
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "first.toString()");
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "second.toString()");
        return new Pair<>(sb3, sb4);
    }
}
