package x6.e.e.b;

import java.math.BigInteger;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.Polynomial;
import org.spongycastle.math.field.PolynomialExtensionField;
import org.spongycastle.util.Integers;
public class b implements PolynomialExtensionField {
    public final FiniteField a;
    public final Polynomial b;

    public b(FiniteField finiteField, Polynomial polynomial) {
        this.a = finiteField;
        this.b = polynomial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.a.equals(bVar.a) || !this.b.equals(bVar.b)) {
            return false;
        }
        return true;
    }

    @Override // org.spongycastle.math.field.FiniteField
    public BigInteger getCharacteristic() {
        return this.a.getCharacteristic();
    }

    @Override // org.spongycastle.math.field.ExtensionField
    public int getDegree() {
        return this.b.getDegree();
    }

    @Override // org.spongycastle.math.field.FiniteField
    public int getDimension() {
        return this.b.getDegree() * this.a.getDimension();
    }

    @Override // org.spongycastle.math.field.PolynomialExtensionField
    public Polynomial getMinimalPolynomial() {
        return this.b;
    }

    @Override // org.spongycastle.math.field.ExtensionField
    public FiniteField getSubfield() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Integers.rotateLeft(this.b.hashCode(), 16);
    }
}
