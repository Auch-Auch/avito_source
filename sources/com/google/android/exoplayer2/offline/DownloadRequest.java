package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new a();
    @Nullable
    public final String customCacheKey;
    public final byte[] data;
    public final String id;
    @Nullable
    public final byte[] keySetId;
    @Nullable
    public final String mimeType;
    public final List<StreamKey> streamKeys;
    public final Uri uri;

    public static class Builder {
        public final String a;
        public final Uri b;
        @Nullable
        public String c;
        @Nullable
        public List<StreamKey> d;
        @Nullable
        public byte[] e;
        @Nullable
        public String f;
        @Nullable
        public byte[] g;

        public Builder(String str, Uri uri) {
            this.a = str;
            this.b = uri;
        }

        public DownloadRequest build() {
            String str = this.a;
            Uri uri = this.b;
            String str2 = this.c;
            List list = this.d;
            if (list == null) {
                list = ImmutableList.of();
            }
            return new DownloadRequest(str, uri, str2, list, this.e, this.f, this.g);
        }

        public Builder setCustomCacheKey(@Nullable String str) {
            this.f = str;
            return this;
        }

        public Builder setData(@Nullable byte[] bArr) {
            this.g = bArr;
            return this;
        }

        public Builder setKeySetId(@Nullable byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public Builder setMimeType(@Nullable String str) {
            this.c = str;
            return this;
        }

        public Builder setStreamKeys(@Nullable List<StreamKey> list) {
            this.d = list;
            return this;
        }
    }

    public static class UnsupportedRequestException extends IOException {
    }

    public class a implements Parcelable.Creator<DownloadRequest> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public DownloadRequest[] newArray(int i) {
            return new DownloadRequest[i];
        }
    }

    public DownloadRequest(String str, Uri uri2, @Nullable String str2, List<StreamKey> list, @Nullable byte[] bArr, @Nullable String str3, @Nullable byte[] bArr2) {
        int inferContentTypeForUriAndMimeType = Util.inferContentTypeForUriAndMimeType(uri2, str2);
        boolean z = true;
        if (inferContentTypeForUriAndMimeType == 0 || inferContentTypeForUriAndMimeType == 2 || inferContentTypeForUriAndMimeType == 1) {
            z = str3 != null ? false : z;
            Assertions.checkArgument(z, "customCacheKey must be null for type: " + inferContentTypeForUriAndMimeType);
        }
        this.id = str;
        this.uri = uri2;
        this.mimeType = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : Util.EMPTY_BYTE_ARRAY;
    }

    public DownloadRequest copyWithId(String str) {
        return new DownloadRequest(str, this.uri, this.mimeType, this.streamKeys, this.keySetId, this.customCacheKey, this.data);
    }

    public DownloadRequest copyWithKeySetId(@Nullable byte[] bArr) {
        return new DownloadRequest(this.id, this.uri, this.mimeType, this.streamKeys, bArr, this.customCacheKey, this.data);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0044 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.offline.DownloadRequest copyWithMergedRequest(com.google.android.exoplayer2.offline.DownloadRequest r10) {
        /*
            r9 = this;
            java.lang.String r0 = r9.id
            java.lang.String r1 = r10.id
            boolean r0 = r0.equals(r1)
            com.google.android.exoplayer2.util.Assertions.checkArgument(r0)
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r0 = r9.streamKeys
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0040
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r0 = r10.streamKeys
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001c
            goto L_0x0040
        L_0x001c:
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r1 = r9.streamKeys
            r0.<init>(r1)
            r1 = 0
        L_0x0024:
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r2 = r10.streamKeys
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0044
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r2 = r10.streamKeys
            java.lang.Object r2 = r2.get(r1)
            com.google.android.exoplayer2.offline.StreamKey r2 = (com.google.android.exoplayer2.offline.StreamKey) r2
            boolean r3 = r0.contains(r2)
            if (r3 != 0) goto L_0x003d
            r0.add(r2)
        L_0x003d:
            int r1 = r1 + 1
            goto L_0x0024
        L_0x0040:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0044:
            r5 = r0
            com.google.android.exoplayer2.offline.DownloadRequest r0 = new com.google.android.exoplayer2.offline.DownloadRequest
            java.lang.String r2 = r9.id
            android.net.Uri r3 = r10.uri
            java.lang.String r4 = r10.mimeType
            byte[] r6 = r10.keySetId
            java.lang.String r7 = r10.customCacheKey
            byte[] r8 = r10.data
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadRequest.copyWithMergedRequest(com.google.android.exoplayer2.offline.DownloadRequest):com.google.android.exoplayer2.offline.DownloadRequest");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.id.equals(downloadRequest.id) || !this.uri.equals(downloadRequest.uri) || !Util.areEqual(this.mimeType, downloadRequest.mimeType) || !this.streamKeys.equals(downloadRequest.streamKeys) || !Arrays.equals(this.keySetId, downloadRequest.keySetId) || !Util.areEqual(this.customCacheKey, downloadRequest.customCacheKey) || !Arrays.equals(this.data, downloadRequest.data)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int hashCode = (this.uri.hashCode() + (this.id.hashCode() * 31 * 31)) * 31;
        String str = this.mimeType;
        int i = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = (Arrays.hashCode(this.keySetId) + ((this.streamKeys.hashCode() + ((hashCode + hashCode2) * 31)) * 31)) * 31;
        String str2 = this.customCacheKey;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return Arrays.hashCode(this.data) + ((hashCode3 + i) * 31);
    }

    public MediaItem toMediaItem() {
        return new MediaItem.Builder().setMediaId(this.id).setUri(this.uri).setCustomCacheKey(this.customCacheKey).setMimeType(this.mimeType).setStreamKeys(this.streamKeys).setDrmKeySetId(this.keySetId).build();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.mimeType + ":" + this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.streamKeys.size());
        for (int i2 = 0; i2 < this.streamKeys.size(); i2++) {
            parcel.writeParcelable(this.streamKeys.get(i2), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
    }

    public DownloadRequest(Parcel parcel) {
        this.id = (String) Util.castNonNull(parcel.readString());
        this.uri = Uri.parse((String) Util.castNonNull(parcel.readString()));
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
