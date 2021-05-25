package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW;

import a2.b.a.a.a;
import android.util.Base64;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.jce.ECNamedCurveTable;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECPublicKeySpec;
import timber.log.Timber;
public final class UGPkPVVOmk179tTX8sQoOodQt implements VVeXCTyov0hLti0HOLqom2taL0gk {
    public final KeyPair Cwa7EHp4RmMFhwpOCPWojiqbo = Cwa7EHp4RmMFhwpOCPWojiqbo();
    public SecretKey oVTxbCNkVuXyP468Xhsl9qtSE9v;

    @Override // xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.VVeXCTyov0hLti0HOLqom2taL0gk
    public void Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull String str) {
        PrivateKey privateKey = this.Cwa7EHp4RmMFhwpOCPWojiqbo.getPrivate();
        byte[] decode = Base64.decode(str, 2);
        KeyFactory instance = KeyFactory.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
        ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
        PublicKey generatePublic = instance.generatePublic(new ECPublicKeySpec(parameterSpec.getCurve().decodePoint(decode), parameterSpec));
        KeyAgreement instance2 = KeyAgreement.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
        instance2.init(privateKey);
        instance2.doPhase(generatePublic, true);
        SecretKey generateSecret = instance2.generateSecret("AES");
        StringBuilder L = a.L("Crypto: secret=");
        L.append(Base64.encodeToString(generateSecret.getEncoded(), 2));
        Timber.d(L.toString(), new Object[0]);
        this.oVTxbCNkVuXyP468Xhsl9qtSE9v = generateSecret;
    }

    public final KeyPair Cwa7EHp4RmMFhwpOCPWojiqbo() {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
        ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("secp256r1");
        KeyPairGenerator instance = KeyPairGenerator.getInstance("ECDH", BouncyCastleProvider.PROVIDER_NAME);
        instance.initialize(parameterSpec);
        return instance.generateKeyPair();
    }

    @Override // xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.VVeXCTyov0hLti0HOLqom2taL0gk
    @NotNull
    public byte[] Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        if (this.oVTxbCNkVuXyP468Xhsl9qtSE9v != null) {
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding", BouncyCastleProvider.PROVIDER_NAME);
            instance.init(1, this.oVTxbCNkVuXyP468Xhsl9qtSE9v, new IvParameterSpec(bArr2));
            byte[] doFinal = instance.doFinal(bArr);
            byte[] encoded = this.Cwa7EHp4RmMFhwpOCPWojiqbo.getPublic().getEncoded();
            ByteBuffer allocate = ByteBuffer.allocate(encoded.length + 3 + bArr2.length + 4 + doFinal.length);
            allocate.put((byte) 2);
            allocate.putShort((short) encoded.length);
            allocate.put(encoded);
            allocate.put(bArr2);
            allocate.putInt(doFinal.length);
            allocate.put(doFinal);
            return allocate.array();
        }
        throw new InvalidParameterException("Session key is not set");
    }
}
