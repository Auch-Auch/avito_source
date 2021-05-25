package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();
    public static final String ID = "CTOC";
    public final Id3Frame[] a;
    public final String[] children;
    public final String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;

    public class a implements Parcelable.Creator<ChapterTocFrame> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ChapterTocFrame[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super(ID);
        this.elementId = str;
        this.isRoot = z;
        this.isOrdered = z2;
        this.children = strArr;
        this.a = id3FrameArr;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.isRoot != chapterTocFrame.isRoot || this.isOrdered != chapterTocFrame.isOrdered || !Util.areEqual(this.elementId, chapterTocFrame.elementId) || !Arrays.equals(this.children, chapterTocFrame.children) || !Arrays.equals(this.a, chapterTocFrame.a)) {
            return false;
        }
        return true;
    }

    public Id3Frame getSubFrame(int i) {
        return this.a[i];
    }

    public int getSubFrameCount() {
        return this.a.length;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = (((527 + (this.isRoot ? 1 : 0)) * 31) + (this.isOrdered ? 1 : 0)) * 31;
        String str = this.elementId;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.elementId);
        parcel.writeByte(this.isRoot ? (byte) 1 : 0);
        parcel.writeByte(this.isOrdered ? (byte) 1 : 0);
        parcel.writeStringArray(this.children);
        parcel.writeInt(this.a.length);
        for (Id3Frame id3Frame : this.a) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterTocFrame(Parcel parcel) {
        super(ID);
        this.elementId = (String) Util.castNonNull(parcel.readString());
        boolean z = true;
        this.isRoot = parcel.readByte() != 0;
        this.isOrdered = parcel.readByte() == 0 ? false : z;
        this.children = (String[]) Util.castNonNull(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.a = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.a[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
