package x6.e.e.b;

import org.spongycastle.math.field.Polynomial;
import org.spongycastle.util.Arrays;
public class a implements Polynomial {
    public final int[] a;

    public a(int[] iArr) {
        this.a = Arrays.clone(iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.areEqual(this.a, ((a) obj).a);
    }

    @Override // org.spongycastle.math.field.Polynomial
    public int getDegree() {
        int[] iArr = this.a;
        return iArr[iArr.length - 1];
    }

    @Override // org.spongycastle.math.field.Polynomial
    public int[] getExponentsPresent() {
        return Arrays.clone(this.a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }
}
