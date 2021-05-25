package org.spongycastle.crypto.commitments;

import java.security.SecureRandom;
import org.spongycastle.crypto.Commitment;
import org.spongycastle.crypto.Committer;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Arrays;
public class HashCommitter implements Committer {
    public final Digest a;
    public final int b;
    public final SecureRandom c;

    public HashCommitter(ExtendedDigest extendedDigest, SecureRandom secureRandom) {
        this.a = extendedDigest;
        this.b = extendedDigest.getByteLength();
        this.c = secureRandom;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[this.a.getDigestSize()];
        this.a.update(bArr, 0, bArr.length);
        this.a.update(bArr2, 0, bArr2.length);
        this.a.doFinal(bArr3, 0);
        return bArr3;
    }

    @Override // org.spongycastle.crypto.Committer
    public Commitment commit(byte[] bArr) {
        int length = bArr.length;
        int i = this.b;
        if (length <= i / 2) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            this.c.nextBytes(bArr2);
            return new Commitment(bArr2, a(bArr2, bArr));
        }
        throw new DataLengthException("Message to be committed to too large for digest.");
    }

    @Override // org.spongycastle.crypto.Committer
    public boolean isRevealed(Commitment commitment, byte[] bArr) {
        if (bArr.length + commitment.getSecret().length == this.b) {
            return Arrays.constantTimeAreEqual(commitment.getCommitment(), a(commitment.getSecret(), bArr));
        }
        throw new DataLengthException("Message and witness secret lengths do not match.");
    }
}
