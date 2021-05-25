package kotlin.text;

import com.avito.android.html_formatter.jsoup.JsoupExtensionsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.h;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u0002:;B\u0011\b\u0001\u0012\u0006\u0010)\u001a\u00020$¢\u0006\u0004\b4\u00105B\u0011\b\u0016\u0012\u0006\u00103\u001a\u00020\u0016¢\u0006\u0004\b4\u00106B\u0019\b\u0016\u0012\u0006\u00103\u001a\u00020\u0016\u0012\u0006\u00107\u001a\u00020+¢\u0006\u0004\b4\u00108B\u001f\b\u0016\u0012\u0006\u00103\u001a\u00020\u0016\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*¢\u0006\u0004\b4\u00109J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u0019J%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0019\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0013\u00103\u001a\u00020\u00168F@\u0006¢\u0006\u0006\u001a\u0004\b2\u0010#¨\u0006<"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "", "input", "", "matches", "(Ljava/lang/CharSequence;)Z", "containsMatchIn", "", "startIndex", "Lkotlin/text/MatchResult;", "find", "(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;", "Lkotlin/sequences/Sequence;", "findAll", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "matchEntire", "(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "", "replacement", "replace", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "replaceFirst", "limit", "", JsoupExtensionsKt.SPLIT_MARK, "(Ljava/lang/CharSequence;I)Ljava/util/List;", "toString", "()Ljava/lang/String;", "Ljava/util/regex/Pattern;", "toPattern", "()Ljava/util/regex/Pattern;", AuthSource.BOOKING_ORDER, "Ljava/util/regex/Pattern;", "nativePattern", "", "Lkotlin/text/RegexOption;", "getOptions", "()Ljava/util/Set;", "options", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "_options", "getPattern", "pattern", "<init>", "(Ljava/util/regex/Pattern;)V", "(Ljava/lang/String;)V", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "(Ljava/lang/String;Ljava/util/Set;)V", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class Regex implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public Set<? extends RegexOption> a;
    public final Pattern b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "", "literal", "Lkotlin/text/Regex;", "fromLiteral", "(Ljava/lang/String;)Lkotlin/text/Regex;", "escape", "(Ljava/lang/String;)Ljava/lang/String;", "escapeReplacement", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public static final int access$ensureUnicodeCase(Companion companion, int i) {
            Objects.requireNonNull(companion);
            return (i & 2) != 0 ? i | 64 : i;
        }

        @NotNull
        public final String escape(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "literal");
            String quote = Pattern.quote(str);
            Intrinsics.checkNotNullExpressionValue(quote, "Pattern.quote(literal)");
            return quote;
        }

        @NotNull
        public final String escapeReplacement(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "literal");
            String quoteReplacement = Matcher.quoteReplacement(str);
            Intrinsics.checkNotNullExpressionValue(quoteReplacement, "Matcher.quoteReplacement(literal)");
            return quoteReplacement;
        }

        @NotNull
        public final Regex fromLiteral(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "literal");
            return new Regex(str, RegexOption.LITERAL);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0014B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "pattern", "", AuthSource.BOOKING_ORDER, "I", "getFlags", "()I", "flags", "<init>", "(Ljava/lang/String;I)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        @NotNull
        public final String a;
        public final int b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "", "serialVersionUID", "J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        static {
            new Companion(null);
        }

        public Serialized(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "pattern");
            this.a = str;
            this.b = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.a, this.b);
            Intrinsics.checkNotNullExpressionValue(compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    public static final class a extends Lambda implements Function0<MatchResult> {
        public final /* synthetic */ Regex a;
        public final /* synthetic */ CharSequence b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Regex regex, CharSequence charSequence, int i) {
            super(0);
            this.a = regex;
            this.b = charSequence;
            this.c = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public MatchResult invoke() {
            return this.a.find(this.b, this.c);
        }
    }

    @PublishedApi
    public Regex(@NotNull Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "nativePattern");
        this.b = pattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.b.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.b.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return this.b.matcher(charSequence).find();
    }

    @Nullable
    public final MatchResult find(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Matcher matcher = this.b.matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return RegexKt.access$findNext(matcher, i, charSequence);
    }

    @NotNull
    public final Sequence<MatchResult> findAll(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            return SequencesKt__SequencesKt.generateSequence((Function0) new a(this, charSequence, i), (Function1) b.a);
        }
        StringBuilder M = a2.b.a.a.a.M("Start index out of bounds: ", i, ", input length: ");
        M.append(charSequence.length());
        throw new IndexOutOfBoundsException(M.toString());
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Set<? extends kotlin.text.RegexOption>, java.util.Set<kotlin.text.RegexOption> */
    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this.a;
        if (set != null) {
            return set;
        }
        int flags = this.b.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        h.retainAll(allOf, new Function1<T, Boolean>(flags) { // from class: kotlin.text.Regex$fromInt$$inlined$apply$lambda$1
            public final /* synthetic */ int a;

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke((Regex$fromInt$$inlined$apply$lambda$1) ((Enum) obj)));
            }

            public final boolean invoke(T t) {
                T t2 = t;
                return (this.a & t2.getMask()) == t2.getValue();
            }
        });
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this.a = unmodifiableSet;
        return unmodifiableSet;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.b.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @Nullable
    public final MatchResult matchEntire(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Matcher matcher = this.b.matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return RegexKt.access$matchEntire(matcher, charSequence);
    }

    public final boolean matches(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        return this.b.matcher(charSequence).matches();
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(str, "replacement");
        String replaceAll = this.b.matcher(charSequence).replaceAll(str);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(str, "replacement");
        String replaceFirst = this.b.matcher(charSequence).replaceFirst(str);
        Intrinsics.checkNotNullExpressionValue(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.b.matcher(charSequence);
            if (!matcher.find() || i == 1) {
                return d.listOf(charSequence.toString());
            }
            int i3 = 10;
            if (i > 0) {
                i3 = e.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            int i4 = i - 1;
            do {
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if (i4 >= 0 && arrayList.size() == i4) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + FormatterType.defaultDecimalSeparator).toString());
    }

    @NotNull
    public final Pattern toPattern() {
        return this.b;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        String pattern = this.b.toString();
        Intrinsics.checkNotNullExpressionValue(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(function1, "transform");
        int i = 0;
        MatchResult find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            Intrinsics.checkNotNull(find$default);
            sb.append(charSequence, i, find$default.getRange().getStart().intValue());
            sb.append((CharSequence) function1.invoke(find$default));
            i = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.text.Regex$Companion r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.Companion.access$ensureUnicodeCase(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.text.Regex$Companion r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.RegexKt.access$toInt(r3)
            int r3 = kotlin.text.Regex.Companion.access$ensureUnicodeCase(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
