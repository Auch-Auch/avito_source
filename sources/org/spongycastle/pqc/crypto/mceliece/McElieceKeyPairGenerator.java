package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;
public class McElieceKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public McElieceKeyGenerationParameters a;
    public int b;
    public int c;
    public int d;
    public int e;
    public SecureRandom f;
    public boolean g = false;

    public final void a(KeyGenerationParameters keyGenerationParameters) {
        this.a = (McElieceKeyGenerationParameters) keyGenerationParameters;
        this.f = new SecureRandom();
        this.b = this.a.getParameters().getM();
        this.c = this.a.getParameters().getN();
        this.d = this.a.getParameters().getT();
        this.e = this.a.getParameters().getFieldPoly();
        this.g = true;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        if (!this.g) {
            a(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters()));
        }
        GF2mField gF2mField = new GF2mField(this.b, this.e);
        PolynomialGF2mSmallM polynomialGF2mSmallM = new PolynomialGF2mSmallM(gF2mField, this.d, 'I', this.f);
        new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).getSquareRootMatrix();
        GoppaCode.MaMaPe computeSystematicForm = GoppaCode.computeSystematicForm(GoppaCode.createCanonicalCheckMatrix(gF2mField, polynomialGF2mSmallM), this.f);
        GF2Matrix secondMatrix = computeSystematicForm.getSecondMatrix();
        Permutation permutation = computeSystematicForm.getPermutation();
        GF2Matrix gF2Matrix = (GF2Matrix) secondMatrix.computeTranspose();
        GF2Matrix extendLeftCompactForm = gF2Matrix.extendLeftCompactForm();
        int numRows = gF2Matrix.getNumRows();
        GF2Matrix[] createRandomRegularMatrixAndItsInverse = GF2Matrix.createRandomRegularMatrixAndItsInverse(numRows, this.f);
        Permutation permutation2 = new Permutation(this.c, this.f);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new McEliecePublicKeyParameters(this.c, this.d, (GF2Matrix) ((GF2Matrix) createRandomRegularMatrixAndItsInverse[0].rightMultiply(extendLeftCompactForm)).rightMultiply(permutation2)), (AsymmetricKeyParameter) new McEliecePrivateKeyParameters(this.c, numRows, gF2mField, polynomialGF2mSmallM, permutation, permutation2, createRandomRegularMatrixAndItsInverse[1]));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        a(keyGenerationParameters);
    }
}
