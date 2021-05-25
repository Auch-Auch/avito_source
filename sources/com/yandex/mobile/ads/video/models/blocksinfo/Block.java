package com.yandex.mobile.ads.video.models.blocksinfo;

import android.os.Parcel;
import android.os.Parcelable;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
public final class Block implements Parcelable {
    public static final Parcelable.Creator<Block> CREATOR = new Parcelable.Creator<Block>() { // from class: com.yandex.mobile.ads.video.models.blocksinfo.Block.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Block createFromParcel(Parcel parcel) {
            return new Block(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Block[] newArray(int i) {
            return new Block[i];
        }
    };
    private int mDuration;
    private String mId;
    private int mPositionsCount;
    private int mStartTime;
    private Type mType;

    public enum Type {
        PREROLL(AdBreak.BreakId.PREROLL),
        MIDROLL(AdBreak.BreakId.MIDROLL),
        POSTROLL(AdBreak.BreakId.POSTROLL),
        PAUSEROLL(AdBreak.BreakId.PAUSEROLL),
        OVERLAYROLL("overlayroll");
        
        private final String mType;

        private Type(String str) {
            this.mType = str;
        }

        public static Type getByType(String str) {
            Type[] values = values();
            for (int i = 0; i < 5; i++) {
                Type type = values[i];
                if (type.mType.equals(str)) {
                    return type;
                }
            }
            return null;
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            return this.mType;
        }
    }

    private void setDuration(String str) {
        try {
            this.mDuration = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
        }
    }

    private void setId(String str) {
        this.mId = str;
    }

    private void setPositionsCount(String str) {
        try {
            this.mPositionsCount = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
        }
    }

    private void setStartTime(String str) {
        try {
            this.mStartTime = Integer.valueOf(str).intValue();
        } catch (Exception unused) {
        }
    }

    private void setType(String str) {
        this.mType = Type.getByType(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Block.class != obj.getClass()) {
            return false;
        }
        Block block = (Block) obj;
        if (this.mDuration != block.mDuration || this.mPositionsCount != block.mPositionsCount || this.mStartTime != block.mStartTime) {
            return false;
        }
        String str = this.mId;
        if (str == null ? block.mId == null : str.equals(block.mId)) {
            return this.mType == block.mType;
        }
        return false;
    }

    public final int getDuration() {
        return this.mDuration;
    }

    public final String getId() {
        return this.mId;
    }

    public final int getPositionsCount() {
        return this.mPositionsCount;
    }

    public final int getStartTime() {
        return this.mStartTime;
    }

    public final Type getType() {
        return this.mType;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        String str = this.mId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Type type = this.mType;
        if (type != null) {
            i = type.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.mStartTime) * 31) + this.mDuration) * 31) + this.mPositionsCount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        Type type = this.mType;
        parcel.writeInt(type == null ? -1 : type.ordinal());
        parcel.writeInt(this.mStartTime);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mPositionsCount);
    }

    private Block() {
    }

    private Block(Parcel parcel) {
        Type type;
        this.mId = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            type = null;
        } else {
            type = Type.values()[readInt];
        }
        this.mType = type;
        this.mStartTime = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mPositionsCount = parcel.readInt();
    }
}
