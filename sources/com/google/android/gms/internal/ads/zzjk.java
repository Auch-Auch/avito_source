package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
public final class zzjk extends zzjh {
    public final zzjg zzanw = new zzjg();
    public long zzanx;
    private final int zzany = 0;
    public ByteBuffer zzdd;

    public zzjk(int i) {
    }

    private final ByteBuffer zzaf(int i) {
        ByteBuffer byteBuffer = this.zzdd;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzjh
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzdd;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean isEncrypted() {
        return zzad(1073741824);
    }

    public final void zzae(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzdd;
        if (byteBuffer == null) {
            this.zzdd = zzaf(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzdd.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer zzaf = zzaf(i2);
            if (position > 0) {
                this.zzdd.position(0);
                this.zzdd.limit(position);
                zzaf.put(this.zzdd);
            }
            this.zzdd = zzaf;
        }
    }
}
