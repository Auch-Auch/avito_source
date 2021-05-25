package a2.j.d.a;

import com.google.common.base.Splitter;
public class n extends Splitter.f {
    public final /* synthetic */ Splitter.b h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(Splitter.b bVar, Splitter splitter, CharSequence charSequence) {
        super(splitter, charSequence);
        this.h = bVar;
    }

    @Override // com.google.common.base.Splitter.f
    public int b(int i) {
        return this.h.a.length() + i;
    }

    @Override // com.google.common.base.Splitter.f
    public int c(int i) {
        int length = this.h.a.length();
        int length2 = this.c.length() - length;
        while (i <= length2) {
            for (int i2 = 0; i2 < length; i2++) {
                if (this.c.charAt(i2 + i) != this.h.a.charAt(i2)) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }
}
