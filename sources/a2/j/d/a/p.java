package a2.j.d.a;

import com.google.common.base.Splitter;
public class p extends Splitter.f {
    public final /* synthetic */ Splitter.d h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(Splitter.d dVar, Splitter splitter, CharSequence charSequence) {
        super(splitter, charSequence);
        this.h = dVar;
    }

    @Override // com.google.common.base.Splitter.f
    public int b(int i) {
        return i;
    }

    @Override // com.google.common.base.Splitter.f
    public int c(int i) {
        int i2 = i + this.h.a;
        if (i2 < this.c.length()) {
            return i2;
        }
        return -1;
    }
}
