package com.google.android.exoplayer2.metadata.id3;

import a2.j.b.b.w0.a;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
public abstract class Id3Frame implements Metadata.Entry {
    public final String id;

    public Id3Frame(String str) {
        this.id = str;
    }

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
        return this.id;
    }
}
