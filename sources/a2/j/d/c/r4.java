package a2.j.d.c;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class r4 implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public final Object a;
    public final Object b;

    public r4(Object obj, @NullableDecl Object obj2) {
        this.a = Preconditions.checkNotNull(obj);
        this.b = obj2 == null ? this : obj2;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this.b) {
            objectOutputStream.defaultWriteObject();
        }
    }

    @Override // java.lang.Object
    public String toString() {
        String obj;
        synchronized (this.b) {
            obj = this.a.toString();
        }
        return obj;
    }
}
