package org.spongycastle.jcajce.provider.symmetric;

import a2.b.a.a.a;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.pkcs.PBEParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
public class PBEPBKDF1 {

    public static class Mappings extends AlgorithmProvider {
        public static final String a = PBEPBKDF1.class.getName();

        @Override // org.spongycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder Y = a.Y(new StringBuilder(), a, "$AlgParams", configurableProvider, "AlgorithmParameters.PBKDF1");
            Y.append("Alg.Alias.AlgorithmParameters.");
            StringBuilder b0 = a.b0(a.b0(a.b0(a.b0(Y, PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters."), PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, configurableProvider, "PBKDF1", "Alg.Alias.AlgorithmParameters.");
            b0.append(PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC);
            configurableProvider.addAlgorithm(b0.toString(), "PBKDF1");
        }
    }

    public static class AlgParams extends BaseAlgorithmParameters {
        public PBEParameter a;

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() {
            try {
                return this.a.getEncoded(ASN1Encoding.DER);
            } catch (IOException e) {
                StringBuilder L = a.L("Oooops! ");
                L.append(e.toString());
                throw new RuntimeException(L.toString());
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                this.a = new PBEParameter(pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                return;
            }
            throw new InvalidParameterSpecException("PBEParameterSpec required to initialise a PBKDF1 PBE parameters algorithm parameters object");
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "PBKDF1 Parameters";
        }

        @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (cls == PBEParameterSpec.class) {
                return new PBEParameterSpec(this.a.getSalt(), this.a.getIterationCount().intValue());
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PBKDF1 PBE parameters object.");
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) {
            if (isASN1FormatString(str)) {
                return engineGetEncoded();
            }
            return null;
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.a = PBEParameter.getInstance(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (isASN1FormatString(str)) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameters format in PBKDF2 parameters object");
        }
    }
}
