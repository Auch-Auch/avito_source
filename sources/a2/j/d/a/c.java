package a2.j.d.a;

import com.google.common.base.CharMatcher;
public class c extends CharMatcher.w {
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(CharMatcher charMatcher, CharMatcher charMatcher2, String str) {
        super(charMatcher2);
        this.b = str;
    }

    @Override // com.google.common.base.CharMatcher.v, com.google.common.base.CharMatcher
    public String toString() {
        return this.b;
    }
}
