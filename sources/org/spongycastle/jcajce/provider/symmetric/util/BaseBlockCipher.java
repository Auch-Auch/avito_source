package org.spongycastle.jcajce.provider.symmetric.util;

import com.google.android.gms.stats.CodePackage;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.engines.DSTU7624Engine;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.EAXBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.GOFBBlockCipher;
import org.spongycastle.crypto.modes.KCCMBlockCipher;
import org.spongycastle.crypto.modes.KCTRBlockCipher;
import org.spongycastle.crypto.modes.KGCMBlockCipher;
import org.spongycastle.crypto.modes.OCBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.modes.PGPCFBBlockCipher;
import org.spongycastle.crypto.modes.SICBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO10126d2Padding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.paddings.TBCPadding;
import org.spongycastle.crypto.paddings.X923Padding;
import org.spongycastle.crypto.paddings.ZeroBytePadding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.util.Strings;
public class BaseBlockCipher extends BaseWrapCipher implements PBE {
    public static final Class t = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.spec.GCMParameterSpec");
    public Class[] e = {RC2ParameterSpec.class, RC5ParameterSpec.class, t, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
    public BlockCipher f;
    public BlockCipherProvider g;
    public c h;
    public ParametersWithIV i;
    public AEADParameters j;
    public int k;
    public int l = -1;
    public int m;
    public int n = 0;
    public boolean o;
    public boolean p = true;
    public PBEParameterSpec q = null;
    public String r = null;
    public String s = null;

    public static class a implements c {
        public static final Constructor b;
        public AEADBlockCipher a;

        static {
            Class loadClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.AEADBadTagException");
            Constructor constructor = null;
            if (loadClass != null) {
                try {
                    constructor = loadClass.getConstructor(String.class);
                } catch (Exception unused) {
                }
                b = constructor;
                return;
            }
            b = null;
        }

        public a(AEADBlockCipher aEADBlockCipher) {
            this.a = aEADBlockCipher;
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public void a(byte[] bArr, int i, int i2) {
            this.a.processAADBytes(bArr, i, i2);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public boolean b() {
            return false;
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException {
            try {
                return this.a.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                Constructor constructor = b;
                if (constructor != null) {
                    BadPaddingException badPaddingException = null;
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(e.getMessage());
                    } catch (Exception unused) {
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e.getMessage());
            }
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public String getAlgorithmName() {
            return this.a.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int getOutputSize(int i) {
            return this.a.getOutputSize(i);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public BlockCipher getUnderlyingCipher() {
            return this.a.getUnderlyingCipher();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int getUpdateOutputSize(int i) {
            return this.a.getUpdateOutputSize(i);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.a.init(z, cipherParameters);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.a.processBytes(bArr, i, i2, bArr2, i3);
        }
    }

    public interface c {
        void a(byte[] bArr, int i, int i2);

        boolean b();

        int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException;

        String getAlgorithmName();

        int getOutputSize(int i);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i);

        void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;
    }

    public static class d extends InvalidKeyException {
        public final Throwable a;

        public d(String str, Throwable th) {
            super(str);
            this.a = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.a;
        }
    }

    public BaseBlockCipher(BlockCipher blockCipher) {
        this.f = blockCipher;
        this.h = new b(blockCipher);
    }

    public final boolean a(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || CodePackage.GCM.equals(str) || "OCB".equals(str);
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        int engineGetOutputSize = engineGetOutputSize(i3);
        byte[] bArr2 = new byte[engineGetOutputSize];
        int processBytes = i3 != 0 ? this.h.processBytes(bArr, i2, i3, bArr2, 0) : 0;
        try {
            int doFinal = processBytes + this.h.doFinal(bArr2, processBytes);
            if (doFinal == engineGetOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, doFinal);
            return bArr3;
        } catch (DataLengthException e2) {
            throw new IllegalBlockSizeException(e2.getMessage());
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.f.getBlockSize();
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        AEADParameters aEADParameters = this.j;
        if (aEADParameters != null) {
            return aEADParameters.getNonce();
        }
        ParametersWithIV parametersWithIV = this.i;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i2) {
        return this.h.getOutputSize(i2);
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams == null) {
            if (this.q != null) {
                try {
                    AlgorithmParameters createParametersInstance = createParametersInstance(this.r);
                    this.engineParams = createParametersInstance;
                    createParametersInstance.init(this.q);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.j != null) {
                try {
                    AlgorithmParameters createParametersInstance2 = createParametersInstance(CodePackage.GCM);
                    this.engineParams = createParametersInstance2;
                    createParametersInstance2.init(new GCMParameters(this.j.getNonce(), this.j.getMacSize() / 8).getEncoded());
                } catch (Exception e2) {
                    throw new RuntimeException(e2.toString());
                }
            } else if (this.i != null) {
                String algorithmName = this.h.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    AlgorithmParameters createParametersInstance3 = createParametersInstance(algorithmName);
                    this.engineParams = createParametersInstance3;
                    createParametersInstance3.init(new IvParameterSpec(this.i.getIV()));
                } catch (Exception e3) {
                    throw new RuntimeException(e3.toString());
                }
            }
        }
        return this.engineParams;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:229:0x04ca */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:250:0x051f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v2, types: [org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r2v12, types: [org.spongycastle.crypto.params.ParametersWithIV] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v13, types: [org.spongycastle.crypto.params.RC5Parameters, org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v16, types: [org.spongycastle.crypto.params.RC2Parameters, org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20, types: [org.spongycastle.crypto.params.ParametersWithSBox, org.spongycastle.crypto.CipherParameters] */
    /* JADX WARN: Type inference failed for: r5v23, types: [org.spongycastle.crypto.params.ParametersWithIV] */
    /* JADX WARN: Type inference failed for: r5v26, types: [org.spongycastle.crypto.params.AEADParameters] */
    /* JADX WARN: Type inference failed for: r9v8, types: [org.spongycastle.crypto.params.ParametersWithIV] */
    /* JADX WARN: Type inference failed for: r9v14, types: [org.spongycastle.crypto.params.ParametersWithIV] */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v73 */
    /* JADX WARN: Type inference failed for: r5v74 */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r5v76 */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r5v78 */
    /* JADX WARN: Type inference failed for: r5v79 */
    /* JADX WARN: Type inference failed for: r5v80 */
    /* JADX WARNING: Unknown variable types count: 4 */
    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void engineInit(int r21, java.security.Key r22, java.security.spec.AlgorithmParameterSpec r23, java.security.SecureRandom r24) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
        // Method dump skipped, instructions count: 1434
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        this.s = upperCase;
        if (upperCase.equals("ECB")) {
            this.n = 0;
            this.h = new b(this.f);
        } else if (this.s.equals("CBC")) {
            this.n = this.f.getBlockSize();
            this.h = new b(new CBCBlockCipher(this.f));
        } else if (this.s.startsWith("OFB")) {
            this.n = this.f.getBlockSize();
            if (this.s.length() != 3) {
                this.h = new b(new OFBBlockCipher(this.f, Integer.parseInt(this.s.substring(3))));
                return;
            }
            BlockCipher blockCipher = this.f;
            this.h = new b(new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        } else if (this.s.startsWith("CFB")) {
            this.n = this.f.getBlockSize();
            if (this.s.length() != 3) {
                this.h = new b(new CFBBlockCipher(this.f, Integer.parseInt(this.s.substring(3))));
                return;
            }
            BlockCipher blockCipher2 = this.f;
            this.h = new b(new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
        } else if (this.s.startsWith("PGP")) {
            boolean equalsIgnoreCase = this.s.equalsIgnoreCase("PGPCFBwithIV");
            this.n = this.f.getBlockSize();
            this.h = new b(new PGPCFBBlockCipher(this.f, equalsIgnoreCase));
        } else if (this.s.equalsIgnoreCase("OpenPGPCFB")) {
            this.n = 0;
            this.h = new b(new OpenPGPCFBBlockCipher(this.f));
        } else if (this.s.startsWith("SIC")) {
            int blockSize = this.f.getBlockSize();
            this.n = blockSize;
            if (blockSize >= 16) {
                this.p = false;
                this.h = new b(new BufferedBlockCipher(new SICBlockCipher(this.f)));
                return;
            }
            throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
        } else if (this.s.startsWith("CTR")) {
            this.n = this.f.getBlockSize();
            this.p = false;
            BlockCipher blockCipher3 = this.f;
            if (blockCipher3 instanceof DSTU7624Engine) {
                this.h = new b(new BufferedBlockCipher(new KCTRBlockCipher(blockCipher3)));
            } else {
                this.h = new b(new BufferedBlockCipher(new SICBlockCipher(blockCipher3)));
            }
        } else if (this.s.startsWith("GOFB")) {
            this.n = this.f.getBlockSize();
            this.h = new b(new BufferedBlockCipher(new GOFBBlockCipher(this.f)));
        } else if (this.s.startsWith("GCFB")) {
            this.n = this.f.getBlockSize();
            this.h = new b(new BufferedBlockCipher(new GCFBBlockCipher(this.f)));
        } else if (this.s.startsWith("CTS")) {
            this.n = this.f.getBlockSize();
            this.h = new b(new CTSBlockCipher(new CBCBlockCipher(this.f)));
        } else if (this.s.startsWith("CCM")) {
            this.n = 13;
            if (this.f instanceof DSTU7624Engine) {
                this.h = new a(new KCCMBlockCipher(this.f));
            } else {
                this.h = new a(new CCMBlockCipher(this.f));
            }
        } else if (this.s.startsWith("OCB")) {
            if (this.g != null) {
                this.n = 15;
                this.h = new a(new OCBBlockCipher(this.f, this.g.get()));
                return;
            }
            throw new NoSuchAlgorithmException(a2.b.a.a.a.c3("can't support mode ", str));
        } else if (this.s.startsWith("EAX")) {
            this.n = this.f.getBlockSize();
            this.h = new a(new EAXBlockCipher(this.f));
        } else if (this.s.startsWith(CodePackage.GCM)) {
            this.n = this.f.getBlockSize();
            if (this.f instanceof DSTU7624Engine) {
                this.h = new a(new KGCMBlockCipher(this.f));
            } else {
                this.h = new a(new GCMBlockCipher(this.f));
            }
        } else {
            throw new NoSuchAlgorithmException(a2.b.a.a.a.c3("can't support mode ", str));
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            if (this.h.b()) {
                this.h = new b(new BufferedBlockCipher(this.h.getUnderlyingCipher()));
            }
        } else if (upperCase.equals("WITHCTS")) {
            this.h = new b(new CTSBlockCipher(this.h.getUnderlyingCipher()));
        } else {
            this.o = true;
            if (a(this.s)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            } else if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                this.h = new b(this.h.getUnderlyingCipher());
            } else if (upperCase.equals("ZEROBYTEPADDING")) {
                this.h = new b(this.h.getUnderlyingCipher(), new ZeroBytePadding());
            } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                this.h = new b(this.h.getUnderlyingCipher(), new ISO10126d2Padding());
            } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                this.h = new b(this.h.getUnderlyingCipher(), new X923Padding());
            } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                this.h = new b(this.h.getUnderlyingCipher(), new ISO7816d4Padding());
            } else if (upperCase.equals("TBCPADDING")) {
                this.h = new b(this.h.getUnderlyingCipher(), new TBCPadding());
            } else {
                throw new NoSuchPaddingException(a2.b.a.a.a.e3("Padding ", str, " unknown."));
            }
        }
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i2, int i3) {
        int updateOutputSize = this.h.getUpdateOutputSize(i3);
        if (updateOutputSize > 0) {
            byte[] bArr2 = new byte[updateOutputSize];
            int processBytes = this.h.processBytes(bArr, i2, i3, bArr2, 0);
            if (processBytes == 0) {
                return null;
            }
            if (processBytes == updateOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[processBytes];
            System.arraycopy(bArr2, 0, bArr3, 0, processBytes);
            return bArr3;
        }
        this.h.processBytes(bArr, i2, i3, null, 0);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(byte[] bArr, int i2, int i3) {
        this.h.a(bArr, i2, i3);
    }

    public static class b implements c {
        public BufferedBlockCipher a;

        public b(BufferedBlockCipher bufferedBlockCipher) {
            this.a = bufferedBlockCipher;
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public void a(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public boolean b() {
            return !(this.a instanceof CTSBlockCipher);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int doFinal(byte[] bArr, int i) throws IllegalStateException, BadPaddingException {
            try {
                return this.a.doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public String getAlgorithmName() {
            return this.a.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int getOutputSize(int i) {
            return this.a.getOutputSize(i);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public BlockCipher getUnderlyingCipher() {
            return this.a.getUnderlyingCipher();
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int getUpdateOutputSize(int i) {
            return this.a.getUpdateOutputSize(i);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.a.init(z, cipherParameters);
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.c
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.a.processBytes(bArr, i, i2, bArr2, i3);
        }

        public b(BlockCipher blockCipher) {
            this.a = new PaddedBufferedBlockCipher(blockCipher);
        }

        public b(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.a = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        int arrayOffset = byteBuffer.arrayOffset();
        engineUpdateAAD(byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.limit() - byteBuffer.position());
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int i5;
        if (engineGetOutputSize(i3) + i4 <= bArr2.length) {
            if (i3 != 0) {
                try {
                    i5 = this.h.processBytes(bArr, i2, i3, bArr2, i4);
                } catch (OutputLengthException e2) {
                    throw new IllegalBlockSizeException(e2.getMessage());
                } catch (DataLengthException e3) {
                    throw new IllegalBlockSizeException(e3.getMessage());
                }
            } else {
                i5 = 0;
            }
            return i5 + this.h.doFinal(bArr2, i4 + i5);
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws ShortBufferException {
        if (this.h.getUpdateOutputSize(i3) + i4 <= bArr2.length) {
            try {
                return this.h.processBytes(bArr, i2, i3, bArr2, i4);
            } catch (DataLengthException e2) {
                throw new IllegalStateException(e2.toString());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i2, int i3, int i4, int i5) {
        this.f = blockCipher;
        this.l = i2;
        this.m = i3;
        this.k = i4;
        this.n = i5;
        this.h = new b(blockCipher);
    }

    public BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.f = blockCipherProvider.get();
        this.g = blockCipherProvider;
        this.h = new b(blockCipherProvider.get());
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        BlockCipher underlyingCipher = aEADBlockCipher.getUnderlyingCipher();
        this.f = underlyingCipher;
        this.n = underlyingCipher.getBlockSize();
        this.h = new a(aEADBlockCipher);
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher, boolean z, int i2) {
        this.f = aEADBlockCipher.getUnderlyingCipher();
        this.p = z;
        this.n = i2;
        this.h = new a(aEADBlockCipher);
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i2) {
        this.f = blockCipher;
        this.h = new b(blockCipher);
        this.n = i2 / 8;
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i2) {
        this.f = bufferedBlockCipher.getUnderlyingCipher();
        this.h = new b(bufferedBlockCipher);
        this.n = i2 / 8;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i3 = 0;
            while (true) {
                Class[] clsArr = this.e;
                if (i3 == clsArr.length) {
                    break;
                }
                if (clsArr[i3] != null) {
                    try {
                        algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i3]);
                        break;
                    } catch (Exception unused) {
                        continue;
                    }
                }
                i3++;
            }
            if (algorithmParameterSpec == null) {
                StringBuilder L = a2.b.a.a.a.L("can't handle parameter ");
                L.append(algorithmParameters.toString());
                throw new InvalidAlgorithmParameterException(L.toString());
            }
        }
        engineInit(i2, key, algorithmParameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i2, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i2, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2.getMessage());
        }
    }
}
