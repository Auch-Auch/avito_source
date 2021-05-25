package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public class Joiner {
    public final String a;

    public static final class MapJoiner {
        public final Joiner a;
        public final String b;

        public MapJoiner(Joiner joiner, String str) {
            this.a = joiner;
            this.b = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a3, Map<?, ?> map) throws IOException {
            return (A) appendTo((MapJoiner) a3, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.a.useForNull(str), this.b);
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb, Map<?, ?> map) {
            return appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        @Beta
        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @Beta
        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a3, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) appendTo((MapJoiner) a3, iterable.iterator());
        }

        @Beta
        public String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        public MapJoiner(Joiner joiner, String str, a aVar) {
            this.a = joiner;
            this.b = (String) Preconditions.checkNotNull(str);
        }

        @Beta
        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a3, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.checkNotNull(a3);
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                a3.append(this.a.b(entry.getKey()));
                a3.append(this.b);
                a3.append(this.a.b(entry.getValue()));
                while (it.hasNext()) {
                    a3.append(this.a.a);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    a3.append(this.a.b(entry2.getKey()));
                    a3.append(this.b);
                    a3.append(this.a.b(entry2.getValue()));
                }
            }
            return a3;
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo((MapJoiner) sb, it);
                return sb;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    public class a extends Joiner {
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Joiner joiner, String str) {
            super(joiner, null);
            this.b = str;
        }

        @Override // com.google.common.base.Joiner
        public CharSequence b(@NullableDecl Object obj) {
            return obj == null ? this.b : Joiner.this.b(obj);
        }

        @Override // com.google.common.base.Joiner
        public Joiner skipNulls() {
            throw new UnsupportedOperationException("already specified useForNull");
        }

        @Override // com.google.common.base.Joiner
        public Joiner useForNull(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public class b extends Joiner {
        public b(Joiner joiner) {
            super(joiner, null);
        }

        @Override // com.google.common.base.Joiner
        public <A extends Appendable> A appendTo(A a, Iterator<?> it) throws IOException {
            Preconditions.checkNotNull(a, "appendable");
            Preconditions.checkNotNull(it, "parts");
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    if (next != null) {
                        a.append(Joiner.this.b(next));
                        break;
                    }
                } else {
                    break;
                }
            }
            while (it.hasNext()) {
                Object next2 = it.next();
                if (next2 != null) {
                    a.append(Joiner.this.a);
                    a.append(Joiner.this.b(next2));
                }
            }
            return a;
        }

        @Override // com.google.common.base.Joiner
        public Joiner useForNull(String str) {
            throw new UnsupportedOperationException("already specified skipNulls");
        }

        @Override // com.google.common.base.Joiner
        public MapJoiner withKeyValueSeparator(String str) {
            throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
    }

    public static class c extends AbstractList<Object> {
        public final /* synthetic */ Object[] a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public c(Object[] objArr, Object obj, Object obj2) {
            this.a = objArr;
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            if (i == 0) {
                return this.b;
            }
            if (i != 1) {
                return this.a[i - 2];
            }
            return this.c;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.a.length + 2;
        }
    }

    public Joiner(String str) {
        this.a = (String) Preconditions.checkNotNull(str);
    }

    public static Iterable<Object> a(Object obj, Object obj2, Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new c(objArr, obj, obj2);
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a3, Iterable<?> iterable) throws IOException {
        return (A) appendTo((Joiner) a3, iterable.iterator());
    }

    public CharSequence b(Object obj) {
        Preconditions.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    public Joiner skipNulls() {
        return new b(this);
    }

    public Joiner useForNull(String str) {
        Preconditions.checkNotNull(str);
        return new a(this, str);
    }

    public MapJoiner withKeyValueSeparator(char c2) {
        return withKeyValueSeparator(String.valueOf(c2));
    }

    public static Joiner on(char c2) {
        return new Joiner(String.valueOf(c2));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a3, Iterator<?> it) throws IOException {
        Preconditions.checkNotNull(a3);
        if (it.hasNext()) {
            a3.append(b(it.next()));
            while (it.hasNext()) {
                a3.append(this.a);
                a3.append(b(it.next()));
            }
        }
        return a3;
    }

    public final String join(Iterator<?> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(this, str, null);
    }

    public Joiner(Joiner joiner, a aVar) {
        this.a = joiner.a;
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    public final String join(@NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) {
        return join(a(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a3, Object[] objArr) throws IOException {
        return (A) appendTo((Joiner) a3, (Iterable<?>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a3, @NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) throws IOException {
        return (A) appendTo((Joiner) a3, a(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterable<?> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterator<?> it) {
        try {
            appendTo((Joiner) sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Object[] objArr) {
        return appendTo(sb, (Iterable<?>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, @NullableDecl Object obj, @NullableDecl Object obj2, Object... objArr) {
        return appendTo(sb, a(obj, obj2, objArr));
    }
}
