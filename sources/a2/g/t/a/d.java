package a2.g.t.a;

import javax.annotation.Nullable;
public class d {
    public static final ThreadLocal<byte[]> a = new a();
    public static long b = -1;
    public static c c = new c();
    public static a d = new a();
    @Nullable
    public static d e;

    public static class a extends ThreadLocal<byte[]> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public byte[] initialValue() {
            return new byte[512];
        }
    }

    public d(String str) {
    }
}
