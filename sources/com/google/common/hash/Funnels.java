package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
public final class Funnels {

    public enum a implements Funnel<byte[]> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.common.hash.PrimitiveSink] */
        @Override // com.google.common.hash.Funnel
        public void funnel(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.mo45putBytes(bArr);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    public enum b implements Funnel<Integer> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.common.hash.PrimitiveSink] */
        @Override // com.google.common.hash.Funnel
        public void funnel(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.mo63putInt(num.intValue());
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    public enum c implements Funnel<Long> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.common.hash.PrimitiveSink] */
        @Override // com.google.common.hash.Funnel
        public void funnel(Long l, PrimitiveSink primitiveSink) {
            primitiveSink.mo59putLong(l.longValue());
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    public static class d<E> implements Funnel<Iterable<? extends E>>, Serializable {
        public final Funnel<E> a;

        public d(Funnel<E> funnel) {
            this.a = (Funnel) Preconditions.checkNotNull(funnel);
        }

        @Override // java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.hash.Funnel<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.hash.Funnel
        public void funnel(Object obj, PrimitiveSink primitiveSink) {
            for (Object obj2 : (Iterable) obj) {
                this.a.funnel(obj2, primitiveSink);
            }
        }

        @Override // java.lang.Object
        public int hashCode() {
            return d.class.hashCode() ^ this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Funnels.sequentialFunnel(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static class e extends OutputStream {
        public final PrimitiveSink a;

        public e(PrimitiveSink primitiveSink) {
            this.a = (PrimitiveSink) Preconditions.checkNotNull(primitiveSink);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Funnels.asOutputStream(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.a.mo61putByte((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.a.mo45putBytes(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.a.mo55putBytes(bArr, i, i2);
        }
    }

    public static class f implements Funnel<CharSequence>, Serializable {
        public final Charset a;

        public static class a implements Serializable {
            private static final long serialVersionUID = 0;
            public final String a;

            public a(Charset charset) {
                this.a = charset.name();
            }

            private Object readResolve() {
                return Funnels.stringFunnel(Charset.forName(this.a));
            }
        }

        public f(Charset charset) {
            this.a = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof f) {
                return this.a.equals(((f) obj).a);
            }
            return false;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.common.hash.PrimitiveSink] */
        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putString(charSequence, this.a);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return f.class.hashCode() ^ this.a.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Funnels.stringFunnel(");
            L.append(this.a.name());
            L.append(")");
            return L.toString();
        }

        public Object writeReplace() {
            return new a(this.a);
        }
    }

    public enum g implements Funnel<CharSequence> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.common.hash.PrimitiveSink] */
        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putUnencodedChars(charSequence);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        return new e(primitiveSink);
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return a.INSTANCE;
    }

    public static Funnel<Integer> integerFunnel() {
        return b.INSTANCE;
    }

    public static Funnel<Long> longFunnel() {
        return c.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> funnel) {
        return new d(funnel);
    }

    public static Funnel<CharSequence> stringFunnel(Charset charset) {
        return new f(charset);
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return g.INSTANCE;
    }
}
