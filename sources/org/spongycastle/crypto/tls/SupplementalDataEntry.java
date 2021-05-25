package org.spongycastle.crypto.tls;
public class SupplementalDataEntry {
    public byte[] data;
    public int dataType;

    public SupplementalDataEntry(int i, byte[] bArr) {
        this.dataType = i;
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDataType() {
        return this.dataType;
    }
}
