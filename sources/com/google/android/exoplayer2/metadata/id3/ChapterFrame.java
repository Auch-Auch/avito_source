package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();
    public static final String ID = "CHAP";
    public final Id3Frame[] a;
    public final String chapterId;
    public final long endOffset;
    public final int endTimeMs;
    public final long startOffset;
    public final int startTimeMs;

    public class a implements Parcelable.Creator<ChapterFrame> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ChapterFrame[] newArray(int i) {
            return new ChapterFrame[i];
        }
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super(ID);
        this.chapterId = str;
        this.startTimeMs = i;
        this.endTimeMs = i2;
        this.startOffset = j;
        this.endOffset = j2;
        this.a = id3FrameArr;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.startTimeMs == chapterFrame.startTimeMs && this.endTimeMs == chapterFrame.endTimeMs && this.startOffset == chapterFrame.startOffset && this.endOffset == chapterFrame.endOffset && Util.areEqual(this.chapterId, chapterFrame.chapterId) && Arrays.equals(this.a, chapterFrame.a)) {
            return true;
        }
        return false;
    }

    public Id3Frame getSubFrame(int i) {
        return this.a[i];
    }

    public int getSubFrameCount() {
        return this.a.length;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = (((((((527 + this.startTimeMs) * 31) + this.endTimeMs) * 31) + ((int) this.startOffset)) * 31) + ((int) this.endOffset)) * 31;
        String str = this.chapterId;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.chapterId);
        parcel.writeInt(this.startTimeMs);
        parcel.writeInt(this.endTimeMs);
        parcel.writeLong(this.startOffset);
        parcel.writeLong(this.endOffset);
        parcel.writeInt(this.a.length);
        for (Id3Frame id3Frame : this.a) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }

    public ChapterFrame(Parcel parcel) {
        super(ID);
        this.chapterId = (String) Util.castNonNull(parcel.readString());
        this.startTimeMs = parcel.readInt();
        this.endTimeMs = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.endOffset = parcel.readLong();
        int readInt = parcel.readInt();
        this.a = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.a[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }
}
