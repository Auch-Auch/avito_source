package com.avito.android.photo_picker;

import a2.g.r.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ErrorType;
import com.avito.android.remote.model.ErrorTypeKt;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 >2\u00020\u0001:\u0002*>BM\u0012\u0006\u0010,\u001a\u00020 \u0012\u0006\u0010/\u001a\u00020\u0014\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010%\u001a\u00020 \u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u00108\u001a\u0004\u0018\u000100\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\b\u00105\u001a\u0004\u0018\u000100¢\u0006\u0004\b9\u0010:BQ\b\u0016\u0012\u0006\u0010,\u001a\u00020 \u0012\u0006\u0010/\u001a\u00020\u0014\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010;\u001a\u00020 \u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u00108\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u0010<\u001a\u00020\u0005\u0012\b\u00105\u001a\u0004\u0018\u000100¢\u0006\u0004\b9\u0010=J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0007R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010%\u001a\u00020 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010)\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007R\u001c\u0010,\u001a\u00020 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$R\u001c\u0010/\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018R\u001e\u00105\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001e\u00108\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104¨\u0006?"}, d2 = {"Lcom/avito/android/photo_picker/PhotoUploadImpl;", "Lcom/avito/android/photo_picker/PhotoUpload;", "Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "newBuilder", "()Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "e", "Ljava/lang/String;", "getUploadId", "()Ljava/lang/String;", "uploadId", "Lcom/avito/android/remote/model/ErrorType;", g.a, "Lcom/avito/android/remote/model/ErrorType;", "getError", "()Lcom/avito/android/remote/model/ErrorType;", "error", "", "d", "J", "getCreated", "()J", "created", "c", "I", "getPosition", VKApiConst.POSITION, AuthSource.SEND_ABUSE, "getId", "id", AuthSource.BOOKING_ORDER, "getType", "type", "Landroid/net/Uri;", "h", "Landroid/net/Uri;", "getSourceUri", "()Landroid/net/Uri;", "sourceUri", "f", "getContentUri", "contentUri", "<init>", "(JLjava/lang/String;IJLjava/lang/String;Landroid/net/Uri;Lcom/avito/android/remote/model/ErrorType;Landroid/net/Uri;)V", "timestamp", CommonKt.TAG_ERROR_CODE, "(JLjava/lang/String;IJLjava/lang/String;Landroid/net/Uri;ILandroid/net/Uri;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoUploadImpl implements PhotoUpload {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PhotoUploadImpl> CREATOR = Parcels.creator(b.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    public final int c;
    public final long d;
    @Nullable
    public final String e;
    @Nullable
    public final Uri f;
    @NotNull
    public final ErrorType g;
    @Nullable
    public final Uri h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_picker/PhotoUploadImpl$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/photo_picker/PhotoUploadImpl;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements PhotoUpload.Builder {
        public ErrorType a;
        public String b;
        public Uri c;
        public final PhotoUploadImpl d;

        public a(@NotNull PhotoUploadImpl photoUploadImpl) {
            Intrinsics.checkNotNullParameter(photoUploadImpl, "original");
            this.d = photoUploadImpl;
            this.a = photoUploadImpl.getError();
            this.b = photoUploadImpl.getUploadId();
            this.c = photoUploadImpl.getContentUri();
        }

        @Override // com.avito.android.photo_picker.PhotoUpload.Builder
        @NotNull
        public PhotoUpload build() {
            long id = this.d.getId();
            String type = this.d.getType();
            long created = this.d.getCreated();
            return new PhotoUploadImpl(id, type, this.d.getPosition(), created, this.b, this.c, this.a, this.d.getSourceUri());
        }

        @Override // com.avito.android.photo_picker.PhotoUpload.Builder
        @NotNull
        public PhotoUpload.Builder contentUri(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            this.c = uri;
            return this;
        }

        @Override // com.avito.android.photo_picker.PhotoUpload.Builder
        @NotNull
        public PhotoUpload.Builder error(@NotNull ErrorType errorType) {
            Intrinsics.checkNotNullParameter(errorType, "error");
            this.a = errorType;
            return this;
        }

        @Override // com.avito.android.photo_picker.PhotoUpload.Builder
        @NotNull
        public PhotoUpload.Builder uploadId(@Nullable String str) {
            this.b = str;
            return this;
        }
    }

    public static final class b extends Lambda implements Function1<Parcel, PhotoUploadImpl> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PhotoUploadImpl invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new PhotoUploadImpl(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readInt(), parcel2.readLong(), parcel2.readString(), (Uri) parcel2.readParcelable(Uri.class.getClassLoader()), parcel2.readInt(), (Uri) parcel2.readParcelable(Uri.class.getClassLoader()));
        }
    }

    public PhotoUploadImpl(long j, @NotNull String str, int i, long j2, @Nullable String str2, @Nullable Uri uri, @NotNull ErrorType errorType, @Nullable Uri uri2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(errorType, "error");
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = j2;
        this.e = str2;
        this.f = uri;
        this.g = errorType;
        this.h = uri2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoUploadImpl)) {
            return false;
        }
        PhotoUploadImpl photoUploadImpl = (PhotoUploadImpl) obj;
        return getId() == photoUploadImpl.getId() && !(Intrinsics.areEqual(getType(), photoUploadImpl.getType()) ^ true) && getPosition() == photoUploadImpl.getPosition() && getCreated() == photoUploadImpl.getCreated() && !(Intrinsics.areEqual(getUploadId(), photoUploadImpl.getUploadId()) ^ true) && !(Intrinsics.areEqual(getContentUri(), photoUploadImpl.getContentUri()) ^ true) && !(Intrinsics.areEqual(getError(), photoUploadImpl.getError()) ^ true) && !(Intrinsics.areEqual(getSourceUri(), photoUploadImpl.getSourceUri()) ^ true);
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    @Nullable
    public Uri getContentUri() {
        return this.f;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    public long getCreated() {
        return this.d;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    @NotNull
    public ErrorType getError() {
        return this.g;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    public int getPosition() {
        return this.c;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    @Nullable
    public Uri getSourceUri() {
        return this.h;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    @NotNull
    public String getType() {
        return this.b;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    @Nullable
    public String getUploadId() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int position = (((getPosition() + ((getType().hashCode() + (c.a(getId()) * 31)) * 31)) * 31) + c.a(getCreated())) * 31;
        String uploadId = getUploadId();
        int i = 0;
        int hashCode = (position + (uploadId != null ? uploadId.hashCode() : 0)) * 31;
        Uri contentUri = getContentUri();
        int hashCode2 = (getError().hashCode() + ((hashCode + (contentUri != null ? contentUri.hashCode() : 0)) * 31)) * 31;
        Uri sourceUri = getSourceUri();
        if (sourceUri != null) {
            i = sourceUri.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.avito.android.photo_picker.PhotoUpload
    @NotNull
    public PhotoUpload.Builder newBuilder() {
        return new a(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(getId());
        parcel.writeString(getType());
        parcel.writeInt(getPosition());
        parcel.writeLong(getCreated());
        parcel.writeString(getUploadId());
        parcel.writeParcelable(getContentUri(), i);
        parcel.writeInt(getError().getCode());
        parcel.writeParcelable(getSourceUri(), i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoUploadImpl(long j, String str, int i, long j2, String str2, Uri uri, int i2, Uri uri2, int i3, j jVar) {
        this(j, str, i, j2, str2, uri, (i3 & 64) != 0 ? 0 : i2, uri2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PhotoUploadImpl(long j, @NotNull String str, int i, long j2, @Nullable String str2, @Nullable Uri uri, int i2, @Nullable Uri uri2) {
        this(j, str, i, j2, str2, uri, ErrorTypeKt.findErrorByCode(i2), uri2);
        Intrinsics.checkNotNullParameter(str, "type");
    }
}
