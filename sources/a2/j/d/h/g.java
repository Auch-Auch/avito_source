package a2.j.d.h;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.io.LineReader;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
@GwtIncompatible
public abstract class g {
    public StringBuilder a = new StringBuilder();
    public boolean b;

    @CanIgnoreReturnValue
    public final boolean a(boolean z) throws IOException {
        boolean z2 = this.b;
        LineReader.this.e.add(this.a.toString());
        this.a = new StringBuilder();
        this.b = false;
        return z;
    }
}
