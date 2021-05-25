package ru.sravni.android.bankproduct.utils.encryption;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preference;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lru/sravni/android/bankproduct/utils/encryption/EncryptionUtil;", "Lru/sravni/android/bankproduct/utils/encryption/IEncryptionUtil;", "", "message", "encrypt", "(Ljava/lang/String;)Ljava/lang/String;", "cryptedMessage", "decrypt", Preference.PASSWORD, "salt", "Ljavax/crypto/SecretKey;", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Ljava/lang/String;)Ljavax/crypto/SecretKey;", "ivSecret", "Ljavax/crypto/spec/IvParameterSpec;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljavax/crypto/spec/IvParameterSpec;", "Lru/sravni/android/bankproduct/utils/encryption/CryptParams;", "Lru/sravni/android/bankproduct/utils/encryption/CryptParams;", "cryptParams", "", "I", "keySize", "Lru/sravni/android/bankproduct/utils/encryption/IBaseConverter;", "c", "Lru/sravni/android/bankproduct/utils/encryption/IBaseConverter;", "baseConverter", "Ljavax/crypto/Cipher;", "d", "Ljavax/crypto/Cipher;", "cipher", "Lru/sravni/android/bankproduct/utils/encryption/ICryptParamsFormer;", "cryptParamsFormer", "<init>", "(Lru/sravni/android/bankproduct/utils/encryption/ICryptParamsFormer;Lru/sravni/android/bankproduct/utils/encryption/IBaseConverter;Ljavax/crypto/Cipher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class EncryptionUtil implements IEncryptionUtil {
    public final int a = 32;
    public final CryptParams b;
    public final IBaseConverter c;
    public final Cipher d;

    public EncryptionUtil(@NotNull ICryptParamsFormer iCryptParamsFormer, @NotNull IBaseConverter iBaseConverter, @NotNull Cipher cipher) {
        Intrinsics.checkParameterIsNotNull(iCryptParamsFormer, "cryptParamsFormer");
        Intrinsics.checkParameterIsNotNull(iBaseConverter, "baseConverter");
        Intrinsics.checkParameterIsNotNull(cipher, "cipher");
        this.c = iBaseConverter;
        this.d = cipher;
        this.b = iCryptParamsFormer.getCryptParams(32, 32, 32);
    }

    public final IvParameterSpec a(String str) {
        Charset charset = Charsets.UTF_8;
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] copyOf = Arrays.copyOf(bytes, 16);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            return new IvParameterSpec(copyOf);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final SecretKey b(String str, String str2) {
        Charset charset = Charsets.UTF_8;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] copyOf = Arrays.copyOf(bytes, 16);
            Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            SecretKeyFactory instance = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            if (str != null) {
                char[] charArray = str.toCharArray();
                Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
                SecretKey generateSecret = instance.generateSecret(new PBEKeySpec(charArray, copyOf, 10, 256));
                Intrinsics.checkExpressionValueIsNotNull(generateSecret, "tmp");
                return new SecretKeySpec(generateSecret.getEncoded(), "AES");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // ru.sravni.android.bankproduct.utils.encryption.IEncryptionUtil
    @NotNull
    public String decrypt(@NotNull String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Intrinsics.checkParameterIsNotNull(str, "cryptedMessage");
        this.d.init(2, b(this.b.getPassword(), this.b.getSalt()), a(this.b.getInitVector()));
        byte[] doFinal = this.d.doFinal(this.c.stringToByte(str));
        Intrinsics.checkExpressionValueIsNotNull(doFinal, "decrypted");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(\"UTF-8\")");
        return new String(doFinal, forName);
    }

    @Override // ru.sravni.android.bankproduct.utils.encryption.IEncryptionUtil
    @NotNull
    public String encrypt(@NotNull String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.d.init(1, b(this.b.getPassword(), this.b.getSalt()), a(this.b.getInitVector()));
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(\"UTF-8\")");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] doFinal = this.d.doFinal(bytes);
        IBaseConverter iBaseConverter = this.c;
        Intrinsics.checkExpressionValueIsNotNull(doFinal, "encrypted");
        return iBaseConverter.byteToString(doFinal);
    }
}
