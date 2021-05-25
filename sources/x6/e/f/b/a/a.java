package x6.e.f.b.a;

import java.security.PrivilegedAction;
public final class a implements PrivilegedAction {
    public final /* synthetic */ String a;

    public a(String str) {
        this.a = str;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        try {
            return Class.forName(this.a);
        } catch (Exception unused) {
            return null;
        }
    }
}
