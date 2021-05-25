package org.spongycastle.crypto.util;

import androidx.appcompat.app.AppCompatDelegateImpl;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
public final class DERMacData {
    public final byte[] a;

    public static final class Builder {
        public final Type a;
        public ASN1OctetString b;
        public ASN1OctetString c;
        public ASN1OctetString d;
        public ASN1OctetString e;
        public byte[] f;

        public Builder(Type type, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.a = type;
            this.b = AppCompatDelegateImpl.i.G0(bArr);
            this.c = AppCompatDelegateImpl.i.G0(bArr2);
            this.d = AppCompatDelegateImpl.i.G0(bArr3);
            this.e = AppCompatDelegateImpl.i.G0(bArr4);
        }

        public DERMacData build() {
            int ordinal = this.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            throw new IllegalStateException("Unknown type encountered in build");
                        }
                    }
                }
                return new DERMacData(Arrays.concatenate(Arrays.concatenate(this.a.getHeader(), AppCompatDelegateImpl.i.Z1(this.c), AppCompatDelegateImpl.i.Z1(this.b)), Arrays.concatenate(AppCompatDelegateImpl.i.Z1(this.e), AppCompatDelegateImpl.i.Z1(this.d), this.f)), null);
            }
            return new DERMacData(Arrays.concatenate(Arrays.concatenate(this.a.getHeader(), AppCompatDelegateImpl.i.Z1(this.b), AppCompatDelegateImpl.i.Z1(this.c)), Arrays.concatenate(AppCompatDelegateImpl.i.Z1(this.d), AppCompatDelegateImpl.i.Z1(this.e), this.f)), null);
        }

        public Builder withText(byte[] bArr) {
            this.f = AppCompatDelegateImpl.i.Z1(new DERTaggedObject(false, 0, AppCompatDelegateImpl.i.G0(bArr)));
            return this;
        }
    }

    public enum Type {
        UNILATERALU("KC_1_U"),
        UNILATERALV("KC_1_V"),
        BILATERALU("KC_2_U"),
        BILATERALV("KC_2_V");
        
        public final String a;

        /* access modifiers changed from: public */
        Type(String str) {
            this.a = str;
        }

        public byte[] getHeader() {
            return Strings.toByteArray(this.a);
        }
    }

    public DERMacData(byte[] bArr, a aVar) {
        this.a = bArr;
    }

    public byte[] getMacData() {
        return Arrays.clone(this.a);
    }
}
