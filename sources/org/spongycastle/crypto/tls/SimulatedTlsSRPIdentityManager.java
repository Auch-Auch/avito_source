package org.spongycastle.crypto.tls;

import com.avito.android.util.preferences.Preference;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.agreement.srp.SRP6VerifierGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.SRP6GroupParameters;
import org.spongycastle.util.Strings;
public class SimulatedTlsSRPIdentityManager implements TlsSRPIdentityManager {
    public static final byte[] a = Strings.toByteArray(Preference.PASSWORD);
    public static final byte[] b = Strings.toByteArray("salt");
    public SRP6GroupParameters group;
    public Mac mac;
    public SRP6VerifierGenerator verifierGenerator;

    public SimulatedTlsSRPIdentityManager(SRP6GroupParameters sRP6GroupParameters, SRP6VerifierGenerator sRP6VerifierGenerator, Mac mac2) {
        this.group = sRP6GroupParameters;
        this.verifierGenerator = sRP6VerifierGenerator;
        this.mac = mac2;
    }

    public static SimulatedTlsSRPIdentityManager getRFC5054Default(SRP6GroupParameters sRP6GroupParameters, byte[] bArr) {
        SRP6VerifierGenerator sRP6VerifierGenerator = new SRP6VerifierGenerator();
        sRP6VerifierGenerator.init(sRP6GroupParameters, TlsUtils.createHash((short) 2));
        HMac hMac = new HMac(TlsUtils.createHash((short) 2));
        hMac.init(new KeyParameter(bArr));
        return new SimulatedTlsSRPIdentityManager(sRP6GroupParameters, sRP6VerifierGenerator, hMac);
    }

    @Override // org.spongycastle.crypto.tls.TlsSRPIdentityManager
    public TlsSRPLoginParameters getLoginParameters(byte[] bArr) {
        Mac mac2 = this.mac;
        byte[] bArr2 = b;
        mac2.update(bArr2, 0, bArr2.length);
        this.mac.update(bArr, 0, bArr.length);
        byte[] bArr3 = new byte[this.mac.getMacSize()];
        this.mac.doFinal(bArr3, 0);
        Mac mac3 = this.mac;
        byte[] bArr4 = a;
        mac3.update(bArr4, 0, bArr4.length);
        this.mac.update(bArr, 0, bArr.length);
        byte[] bArr5 = new byte[this.mac.getMacSize()];
        this.mac.doFinal(bArr5, 0);
        return new TlsSRPLoginParameters(this.group, this.verifierGenerator.generateVerifier(bArr3, bArr, bArr5), bArr3);
    }
}
