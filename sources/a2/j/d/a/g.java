package a2.j.d.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@GwtIncompatible
public final class g extends e implements Serializable {
    private static final long serialVersionUID = 0;
    public final Pattern a;

    public static final class a extends d {
        public final Matcher a;

        public a(Matcher matcher) {
            this.a = (Matcher) Preconditions.checkNotNull(matcher);
        }
    }

    public g(Pattern pattern) {
        this.a = (Pattern) Preconditions.checkNotNull(pattern);
    }

    @Override // a2.j.d.a.e
    public int a() {
        return this.a.flags();
    }

    @Override // a2.j.d.a.e
    public d b(CharSequence charSequence) {
        return new a(this.a.matcher(charSequence));
    }

    @Override // a2.j.d.a.e
    public String c() {
        return this.a.pattern();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a.toString();
    }
}
