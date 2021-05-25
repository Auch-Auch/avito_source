package a2.j.d.a;

import com.google.common.base.Splitter;
public class m extends Splitter.f {
    public final /* synthetic */ Splitter.a h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Splitter.a aVar, Splitter splitter, CharSequence charSequence) {
        super(splitter, charSequence);
        this.h = aVar;
    }

    @Override // com.google.common.base.Splitter.f
    public int b(int i) {
        return i + 1;
    }

    @Override // com.google.common.base.Splitter.f
    public int c(int i) {
        return this.h.a.indexIn(this.c, i);
    }
}
