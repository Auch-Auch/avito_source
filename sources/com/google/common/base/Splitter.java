package com.google.common.base;

import a2.j.d.a.b;
import a2.j.d.a.i;
import a2.j.d.a.j;
import a2.j.d.a.m;
import a2.j.d.a.n;
import a2.j.d.a.o;
import a2.j.d.a.p;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@GwtCompatible(emulated = true)
public final class Splitter {
    public final CharMatcher a;
    public final boolean b;
    public final g c;
    public final int d;

    @Beta
    public static final class MapSplitter {
        public final Splitter a;
        public final Splitter b;

        public MapSplitter(Splitter splitter, Splitter splitter2, a aVar) {
            this.a = splitter;
            this.b = (Splitter) Preconditions.checkNotNull(splitter2);
        }

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.a.split(charSequence)) {
                Splitter splitter = this.b;
                Iterator<String> a3 = splitter.c.a(splitter, str);
                Preconditions.checkArgument(a3.hasNext(), "Chunk [%s] is not a valid entry", str);
                String next = a3.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(next), "Duplicate key [%s] found.", next);
                Preconditions.checkArgument(a3.hasNext(), "Chunk [%s] is not a valid entry", str);
                linkedHashMap.put(next, a3.next());
                Preconditions.checkArgument(!a3.hasNext(), "Chunk [%s] is not a valid entry", str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    public static class a implements g {
        public final /* synthetic */ CharMatcher a;

        public a(CharMatcher charMatcher) {
            this.a = charMatcher;
        }

        @Override // com.google.common.base.Splitter.g
        public Iterator a(Splitter splitter, CharSequence charSequence) {
            return new m(this, splitter, charSequence);
        }
    }

    public static class b implements g {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // com.google.common.base.Splitter.g
        public Iterator a(Splitter splitter, CharSequence charSequence) {
            return new n(this, splitter, charSequence);
        }
    }

    public static class c implements g {
        public final /* synthetic */ a2.j.d.a.e a;

        public c(a2.j.d.a.e eVar) {
            this.a = eVar;
        }

        @Override // com.google.common.base.Splitter.g
        public Iterator a(Splitter splitter, CharSequence charSequence) {
            return new o(this, splitter, charSequence, this.a.b(charSequence));
        }
    }

    public static class d implements g {
        public final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // com.google.common.base.Splitter.g
        public Iterator a(Splitter splitter, CharSequence charSequence) {
            return new p(this, splitter, charSequence);
        }
    }

    public class e implements Iterable<String> {
        public final /* synthetic */ CharSequence a;

        public e(CharSequence charSequence) {
            this.a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            Splitter splitter = Splitter.this;
            return splitter.c.a(splitter, this.a);
        }

        @Override // java.lang.Object
        public String toString() {
            Joiner on = Joiner.on(", ");
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            StringBuilder appendTo = on.appendTo(sb, (Iterable<?>) this);
            appendTo.append(']');
            return appendTo.toString();
        }
    }

    public static abstract class f extends a2.j.d.a.b<String> {
        public final CharSequence c;
        public final CharMatcher d;
        public final boolean e;
        public int f = 0;
        public int g;

        public f(Splitter splitter, CharSequence charSequence) {
            this.d = splitter.a;
            this.e = splitter.b;
            this.g = splitter.d;
            this.c = charSequence;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // a2.j.d.a.b
        public String a() {
            int c2;
            int i = this.f;
            while (true) {
                int i2 = this.f;
                if (i2 != -1) {
                    c2 = c(i2);
                    if (c2 == -1) {
                        c2 = this.c.length();
                        this.f = -1;
                    } else {
                        this.f = b(c2);
                    }
                    int i3 = this.f;
                    if (i3 == i) {
                        int i4 = i3 + 1;
                        this.f = i4;
                        if (i4 > this.c.length()) {
                            this.f = -1;
                        }
                    } else {
                        while (i < c2 && this.d.matches(this.c.charAt(i))) {
                            i++;
                        }
                        while (c2 > i) {
                            int i5 = c2 - 1;
                            if (!this.d.matches(this.c.charAt(i5))) {
                                break;
                            }
                            c2 = i5;
                        }
                        if (!this.e || i != c2) {
                            break;
                        }
                        i = this.f;
                    }
                } else {
                    this.a = b.a.DONE;
                    return null;
                }
            }
            int i6 = this.g;
            if (i6 == 1) {
                c2 = this.c.length();
                this.f = -1;
                while (c2 > i) {
                    int i7 = c2 - 1;
                    if (!this.d.matches(this.c.charAt(i7))) {
                        break;
                    }
                    c2 = i7;
                }
            } else {
                this.g = i6 - 1;
            }
            return this.c.subSequence(i, c2).toString();
        }

        public abstract int b(int i);

        public abstract int c(int i);
    }

    public interface g {
        Iterator<String> a(Splitter splitter, CharSequence charSequence);
    }

    public Splitter(g gVar) {
        CharMatcher none = CharMatcher.none();
        this.c = gVar;
        this.b = false;
        this.a = none;
        this.d = Integer.MAX_VALUE;
    }

    public static Splitter a(a2.j.d.a.e eVar) {
        Preconditions.checkArgument(!((Matcher) Preconditions.checkNotNull(((a2.j.d.a.g) eVar).a.matcher(""))).matches(), "The pattern may not match the empty string: %s", eVar);
        return new Splitter(new c(eVar));
    }

    public static Splitter fixedLength(int i) {
        Preconditions.checkArgument(i > 0, "The length may not be less than 1");
        return new Splitter(new d(i));
    }

    public static Splitter on(char c2) {
        return on(CharMatcher.is(c2));
    }

    @GwtIncompatible
    public static Splitter onPattern(String str) {
        i iVar = j.a;
        Preconditions.checkNotNull(str);
        Objects.requireNonNull((j.b) j.a);
        return a(new a2.j.d.a.g(Pattern.compile(str)));
    }

    public Splitter limit(int i) {
        Preconditions.checkArgument(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.c, this.b, this.a, i);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.c, true, this.a, this.d);
    }

    public Iterable<String> split(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new e(charSequence);
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> a3 = this.c.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (a3.hasNext()) {
            arrayList.add(a3.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    @Beta
    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    public static Splitter on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new a(charMatcher));
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.c, this.b, charMatcher, this.d);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(char c2) {
        return withKeyValueSeparator(on(c2));
    }

    @Beta
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(this, splitter, null);
    }

    public static Splitter on(String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new b(str));
    }

    public Splitter(g gVar, boolean z, CharMatcher charMatcher, int i) {
        this.c = gVar;
        this.b = z;
        this.a = charMatcher;
        this.d = i;
    }

    @GwtIncompatible
    public static Splitter on(Pattern pattern) {
        return a(new a2.j.d.a.g(pattern));
    }
}
