package com.yandex.mobile.ads.video.models.blocksinfo;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.yandex.mobile.ads.impl.ie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public final class BlocksInfo implements Parcelable {
    public static final Parcelable.Creator<BlocksInfo> CREATOR = new Parcelable.Creator<BlocksInfo>() { // from class: com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BlocksInfo createFromParcel(Parcel parcel) {
            return new BlocksInfo(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BlocksInfo[] newArray(int i) {
            return new BlocksInfo[i];
        }
    };
    private static final int INVALID_POSITIVE_VALUE = -1;
    private List<Block> mBlocks;
    private int mBufferEmptyLimit;
    private int mBufferFullTimeout;
    private String mCategoryId;
    private String mCategoryName;
    private int mFirstBuffTimeout;
    private String mPartnerId;
    private String mSessionId;
    private boolean mShowSkipTimeLeft;
    private boolean mShowTimeLeft;
    private String mSkin;
    private int mSkinTimeout;
    private int mSkipDelay;
    private String mTitle;
    private boolean mVPaidEnabled;
    private int mVastTimeout;
    private int mVersion;
    private int mVideoTimeout;
    private int mVpaidTimeout;
    private int mWrapperMaxCount;
    private int mWrapperTimeout;

    private void addBlock(Block block) {
        this.mBlocks.add(block);
    }

    private void addBlocks(Collection<Block> collection) {
        for (Block block : ie.a(collection)) {
            addBlock(block);
        }
    }

    private static boolean parseBooleanWithDefault(String str, boolean z) {
        try {
            return Boolean.parseBoolean(str);
        } catch (Exception unused) {
            return z;
        }
    }

    private static int parsePositiveIntOrInvalidValue(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    private void setBufferEmptyLimit(String str) {
        this.mBufferEmptyLimit = parsePositiveIntOrInvalidValue(str);
    }

    private void setBufferFullTimeout(String str) {
        this.mBufferFullTimeout = parsePositiveIntOrInvalidValue(str);
    }

    private void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    private void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    private void setFirstBuffTimeout(String str) {
        this.mFirstBuffTimeout = parsePositiveIntOrInvalidValue(str);
    }

    private void setPartnerId(String str) {
        this.mPartnerId = str;
    }

    private void setSessionId(String str) {
        this.mSessionId = str;
    }

    private void setShowSkipTimeLeft(String str) {
        this.mShowSkipTimeLeft = parseBooleanWithDefault(str, this.mShowSkipTimeLeft);
    }

    private void setShowTimeLeft(String str) {
        this.mShowTimeLeft = parseBooleanWithDefault(str, this.mShowTimeLeft);
    }

    private void setSkin(String str) {
        this.mSkin = str;
    }

    private void setSkinTimeout(String str) {
        this.mSkinTimeout = parsePositiveIntOrInvalidValue(str);
    }

    private void setSkipDelay(String str) {
        this.mSkipDelay = parsePositiveIntOrInvalidValue(str);
    }

    private void setTitle(String str) {
        this.mTitle = str;
    }

    private void setVPaidEnabled(String str) {
        this.mVPaidEnabled = parseBooleanWithDefault(str, this.mVPaidEnabled);
    }

    private void setVastTimeout(String str) {
        this.mVastTimeout = parsePositiveIntOrInvalidValue(str);
    }

    private void setVersion(String str) {
        this.mVersion = parsePositiveIntOrInvalidValue(str);
    }

    private void setVideoTimeout(String str) {
        this.mVideoTimeout = parsePositiveIntOrInvalidValue(str);
    }

    private void setVpaidTimeout(String str) {
        this.mVpaidTimeout = parsePositiveIntOrInvalidValue(str);
    }

    private void setWrapperMaxCount(String str) {
        this.mWrapperMaxCount = parsePositiveIntOrInvalidValue(str);
    }

    private void setWrapperTimeout(String str) {
        this.mWrapperTimeout = parsePositiveIntOrInvalidValue(str);
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
        if (obj == null || BlocksInfo.class != obj.getClass()) {
            return false;
        }
        BlocksInfo blocksInfo = (BlocksInfo) obj;
        if (this.mBufferEmptyLimit != blocksInfo.mBufferEmptyLimit || this.mBufferFullTimeout != blocksInfo.mBufferFullTimeout || this.mFirstBuffTimeout != blocksInfo.mFirstBuffTimeout || this.mVPaidEnabled != blocksInfo.mVPaidEnabled || this.mShowSkipTimeLeft != blocksInfo.mShowSkipTimeLeft || this.mShowTimeLeft != blocksInfo.mShowTimeLeft || this.mSkinTimeout != blocksInfo.mSkinTimeout || this.mSkipDelay != blocksInfo.mSkipDelay || this.mVastTimeout != blocksInfo.mVastTimeout || this.mVersion != blocksInfo.mVersion || this.mVideoTimeout != blocksInfo.mVideoTimeout || this.mVpaidTimeout != blocksInfo.mVpaidTimeout || this.mWrapperMaxCount != blocksInfo.mWrapperMaxCount || this.mWrapperTimeout != blocksInfo.mWrapperTimeout) {
            return false;
        }
        List<Block> list = this.mBlocks;
        if (list == null ? blocksInfo.mBlocks != null : !list.equals(blocksInfo.mBlocks)) {
            return false;
        }
        String str = this.mCategoryId;
        if (str == null ? blocksInfo.mCategoryId != null : !str.equals(blocksInfo.mCategoryId)) {
            return false;
        }
        String str2 = this.mCategoryName;
        if (str2 == null ? blocksInfo.mCategoryName != null : !str2.equals(blocksInfo.mCategoryName)) {
            return false;
        }
        String str3 = this.mPartnerId;
        if (str3 == null ? blocksInfo.mPartnerId != null : !str3.equals(blocksInfo.mPartnerId)) {
            return false;
        }
        String str4 = this.mSessionId;
        if (str4 == null ? blocksInfo.mSessionId != null : !str4.equals(blocksInfo.mSessionId)) {
            return false;
        }
        String str5 = this.mSkin;
        if (str5 == null ? blocksInfo.mSkin != null : !str5.equals(blocksInfo.mSkin)) {
            return false;
        }
        String str6 = this.mTitle;
        String str7 = blocksInfo.mTitle;
        return str6 == null ? str7 == null : str6.equals(str7);
    }

    public final List<Block> getBlocks() {
        return this.mBlocks;
    }

    public final int getBufferEmptyLimit() {
        return this.mBufferEmptyLimit;
    }

    public final int getBufferFullTimeout() {
        return this.mBufferFullTimeout;
    }

    public final String getCategoryId() {
        return this.mCategoryId;
    }

    public final String getCategoryName() {
        return this.mCategoryName;
    }

    public final int getFirstBuffTimeout() {
        return this.mFirstBuffTimeout;
    }

    public final String getPartnerId() {
        return this.mPartnerId;
    }

    public final String getSessionId() {
        return this.mSessionId;
    }

    public final String getSkin() {
        return this.mSkin;
    }

    public final int getSkinTimeout() {
        return this.mSkinTimeout;
    }

    public final int getSkipDelay() {
        return this.mSkipDelay;
    }

    public final String getTitle() {
        return this.mTitle;
    }

    public final int getVastTimeout() {
        return this.mVastTimeout;
    }

    public final int getVersion() {
        return this.mVersion;
    }

    public final int getVideoTimeout() {
        return this.mVideoTimeout;
    }

    public final int getVpaidTimeout() {
        return this.mVpaidTimeout;
    }

    public final int getWrapperMaxCount() {
        return this.mWrapperMaxCount;
    }

    public final int getWrapperTimeout() {
        return this.mWrapperTimeout;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int i = this.mVersion * 31;
        String str = this.mPartnerId;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mSessionId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mCategoryId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mCategoryName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mSkin;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + (this.mVPaidEnabled ? 1 : 0)) * 31) + this.mBufferEmptyLimit) * 31;
        String str6 = this.mTitle;
        int hashCode6 = (((((((((((((((((((((((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.mSkipDelay) * 31) + this.mSkinTimeout) * 31) + this.mVpaidTimeout) * 31) + this.mWrapperTimeout) * 31) + this.mVideoTimeout) * 31) + this.mVastTimeout) * 31) + (this.mShowTimeLeft ? 1 : 0)) * 31) + (this.mShowSkipTimeLeft ? 1 : 0)) * 31) + this.mBufferFullTimeout) * 31) + this.mWrapperMaxCount) * 31) + this.mFirstBuffTimeout) * 31;
        List<Block> list = this.mBlocks;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode6 + i2;
    }

    public final boolean isVPaidEnabled() {
        return this.mVPaidEnabled;
    }

    public final boolean showSkipTimeLeft() {
        return this.mShowSkipTimeLeft;
    }

    public final boolean showTimeLeft() {
        return this.mShowTimeLeft;
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder("mVersion=");
        sb.append(this.mVersion);
        sb.append('\'');
        sb.append("\nmPartnerId='");
        a.k1(sb, this.mPartnerId, '\'', "\nmSessionId='");
        a.k1(sb, this.mSessionId, '\'', "\nmCategoryId='");
        a.k1(sb, this.mCategoryId, '\'', "\nmCategoryName='");
        a.k1(sb, this.mCategoryName, '\'', "\nmSkin='");
        a.k1(sb, this.mSkin, '\'', "\nmVPaidEnabled=");
        sb.append(this.mVPaidEnabled);
        sb.append("\nmBufferEmptyLimit=");
        sb.append(this.mBufferEmptyLimit);
        sb.append("\nmTitle='");
        a.k1(sb, this.mTitle, '\'', "\nmSkipDelay=");
        sb.append(this.mSkipDelay);
        sb.append("\nmSkinTimeout=");
        sb.append(this.mSkinTimeout);
        sb.append("\nmVpaidTimeout=");
        sb.append(this.mVpaidTimeout);
        sb.append("\nmWrapperTimeout=");
        sb.append(this.mWrapperTimeout);
        sb.append("\nmVideoTimeout=");
        sb.append(this.mVideoTimeout);
        sb.append("\nmVastTimeout=");
        sb.append(this.mVastTimeout);
        sb.append("\nmShowTimeLeft=");
        sb.append(this.mShowTimeLeft);
        sb.append("\nmShowSkipTimeLeft=");
        sb.append(this.mShowSkipTimeLeft);
        sb.append("\nmBufferFullTimeout=");
        sb.append(this.mBufferFullTimeout);
        sb.append("\nmWrapperMaxCount=");
        sb.append(this.mWrapperMaxCount);
        sb.append("\nmFirstBuffTimeout=");
        sb.append(this.mFirstBuffTimeout);
        sb.append("\nmBlocks.size()=");
        sb.append(this.mBlocks.size());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersion);
        parcel.writeString(this.mPartnerId);
        parcel.writeString(this.mSessionId);
        parcel.writeString(this.mCategoryId);
        parcel.writeString(this.mCategoryName);
        parcel.writeString(this.mSkin);
        parcel.writeByte(this.mVPaidEnabled ? (byte) 1 : 0);
        parcel.writeInt(this.mBufferEmptyLimit);
        parcel.writeString(this.mTitle);
        parcel.writeInt(this.mSkipDelay);
        parcel.writeInt(this.mSkinTimeout);
        parcel.writeInt(this.mVpaidTimeout);
        parcel.writeInt(this.mWrapperTimeout);
        parcel.writeInt(this.mVideoTimeout);
        parcel.writeInt(this.mVastTimeout);
        parcel.writeByte(this.mShowTimeLeft ? (byte) 1 : 0);
        parcel.writeByte(this.mShowSkipTimeLeft ? (byte) 1 : 0);
        parcel.writeInt(this.mBufferFullTimeout);
        parcel.writeInt(this.mWrapperMaxCount);
        parcel.writeInt(this.mFirstBuffTimeout);
        parcel.writeTypedList(this.mBlocks);
    }

    private BlocksInfo() {
        this.mVPaidEnabled = false;
        this.mSkipDelay = -1;
        this.mSkinTimeout = -1;
        this.mVpaidTimeout = -1;
        this.mWrapperTimeout = -1;
        this.mVideoTimeout = -1;
        this.mVastTimeout = -1;
        this.mShowTimeLeft = false;
        this.mShowSkipTimeLeft = false;
        this.mBufferFullTimeout = -1;
        this.mWrapperMaxCount = -1;
        this.mFirstBuffTimeout = -1;
        this.mBlocks = new ArrayList();
    }

    private BlocksInfo(Parcel parcel) {
        boolean z = false;
        this.mVPaidEnabled = false;
        this.mSkipDelay = -1;
        this.mSkinTimeout = -1;
        this.mVpaidTimeout = -1;
        this.mWrapperTimeout = -1;
        this.mVideoTimeout = -1;
        this.mVastTimeout = -1;
        this.mShowTimeLeft = false;
        this.mShowSkipTimeLeft = false;
        this.mBufferFullTimeout = -1;
        this.mWrapperMaxCount = -1;
        this.mFirstBuffTimeout = -1;
        this.mBlocks = new ArrayList();
        this.mVersion = parcel.readInt();
        this.mPartnerId = parcel.readString();
        this.mSessionId = parcel.readString();
        this.mCategoryId = parcel.readString();
        this.mCategoryName = parcel.readString();
        this.mSkin = parcel.readString();
        this.mVPaidEnabled = parcel.readByte() != 0;
        this.mBufferEmptyLimit = parcel.readInt();
        this.mTitle = parcel.readString();
        this.mSkipDelay = parcel.readInt();
        this.mSkinTimeout = parcel.readInt();
        this.mVpaidTimeout = parcel.readInt();
        this.mWrapperTimeout = parcel.readInt();
        this.mVideoTimeout = parcel.readInt();
        this.mVastTimeout = parcel.readInt();
        this.mShowTimeLeft = parcel.readByte() != 0;
        this.mShowSkipTimeLeft = parcel.readByte() != 0 ? true : z;
        this.mBufferFullTimeout = parcel.readInt();
        this.mWrapperMaxCount = parcel.readInt();
        this.mFirstBuffTimeout = parcel.readInt();
        parcel.readTypedList(this.mBlocks, Block.CREATOR);
    }
}
