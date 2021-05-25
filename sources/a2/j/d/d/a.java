package a2.j.d.d;

import com.google.common.annotations.GwtCompatible;
@GwtCompatible(emulated = true)
public final class a {
    public static final ThreadLocal<char[]> a = new C0067a();

    /* renamed from: a2.j.d.d.a$a  reason: collision with other inner class name */
    public static class C0067a extends ThreadLocal<char[]> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    }
}
