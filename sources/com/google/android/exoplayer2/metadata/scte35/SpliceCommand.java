package com.google.android.exoplayer2.metadata.scte35;

import a2.j.b.b.w0.a;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
public abstract class SpliceCommand implements Metadata.Entry {
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return a.$default$getWrappedMetadataBytes(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format getWrappedMetadataFormat() {
        return a.$default$getWrappedMetadataFormat(this);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SCTE-35 splice command: type=");
        L.append(getClass().getSimpleName());
        return L.toString();
    }
}
