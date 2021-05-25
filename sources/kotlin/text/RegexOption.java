package kotlin.text;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import t6.y.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/text/RegexOption;", "", "Lt6/y/c;", "", AuthSource.SEND_ABUSE, "I", "getValue", "()I", "value", AuthSource.BOOKING_ORDER, "getMask", "mask", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public enum RegexOption implements c {
    IGNORE_CASE(2, 0, 2),
    MULTILINE(8, 0, 2),
    LITERAL(16, 0, 2),
    UNIX_LINES(1, 0, 2),
    COMMENTS(4, 0, 2),
    DOT_MATCHES_ALL(32, 0, 2),
    CANON_EQ(128, 0, 2);
    
    public final int a;
    public final int b;

    /* access modifiers changed from: public */
    RegexOption(int i, int i2, int i3) {
        i2 = (i3 & 2) != 0 ? i : i2;
        this.a = i;
        this.b = i2;
    }

    @Override // t6.y.c
    public int getMask() {
        return this.b;
    }

    @Override // t6.y.c
    public int getValue() {
        return this.a;
    }
}
