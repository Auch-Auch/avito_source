package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class MatcherMatchResult implements MatchResult {
    @NotNull
    public final MatchGroupCollection a = new MatcherMatchResult$groups$1(this);
    public List<String> b;
    public final Matcher c;
    public final CharSequence d;

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        this.c = matcher;
        this.d = charSequence;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public List<String> getGroupValues() {
        if (this.b == null) {
            this.b = new AbstractList<String>(this) { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                public final /* synthetic */ MatcherMatchResult a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return contains((String) obj);
                    }
                    return false;
                }

                @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
                public int getSize() {
                    return this.a.c.groupCount() + 1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return indexOf((String) obj);
                    }
                    return -1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return lastIndexOf((String) obj);
                    }
                    return -1;
                }

                public /* bridge */ boolean contains(String str) {
                    return super.contains((Object) str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                @NotNull
                public String get(int i) {
                    String group = this.a.c.group(i);
                    return group != null ? group : "";
                }

                public /* bridge */ int indexOf(String str) {
                    return super.indexOf((Object) str);
                }

                public /* bridge */ int lastIndexOf(String str) {
                    return super.lastIndexOf((Object) str);
                }
            };
        }
        List<String> list = this.b;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public MatchGroupCollection getGroups() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public IntRange getRange() {
        return RegexKt.access$range(this.c);
    }

    @Override // kotlin.text.MatchResult
    @NotNull
    public String getValue() {
        String group = this.c.group();
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    @Nullable
    public MatchResult next() {
        int end = this.c.end() + (this.c.end() == this.c.start() ? 1 : 0);
        if (end > this.d.length()) {
            return null;
        }
        Matcher matcher = this.c.pattern().matcher(this.d);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return RegexKt.access$findNext(matcher, end, this.d);
    }
}
