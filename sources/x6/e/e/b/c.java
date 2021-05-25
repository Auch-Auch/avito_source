package x6.e.e.b;

import java.math.BigInteger;
import org.spongycastle.math.field.FiniteField;
public class c implements FiniteField {
    public final BigInteger a;

    public c(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.a.equals(((c) obj).a);
    }

    @Override // org.spongycastle.math.field.FiniteField
    public BigInteger getCharacteristic() {
        return this.a;
    }

    @Override // org.spongycastle.math.field.FiniteField
    public int getDimension() {
        return 1;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
