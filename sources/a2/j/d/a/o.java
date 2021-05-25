package a2.j.d.a;

import a2.j.d.a.g;
import com.google.common.base.Splitter;
public class o extends Splitter.f {
    public final /* synthetic */ d h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(Splitter.c cVar, Splitter splitter, CharSequence charSequence, d dVar) {
        super(splitter, charSequence);
        this.h = dVar;
    }

    @Override // com.google.common.base.Splitter.f
    public int b(int i) {
        return ((g.a) this.h).a.end();
    }

    @Override // com.google.common.base.Splitter.f
    public int c(int i) {
        if (((g.a) this.h).a.find(i)) {
            return ((g.a) this.h).a.start();
        }
        return -1;
    }
}
