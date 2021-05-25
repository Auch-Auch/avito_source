package com.avito.android.photo_view;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.photo_view.ImageData;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/photo_view/PhotoImageData;", "Lcom/avito/android/photo_view/ImageData;", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "Lcom/avito/android/photo_view/ImageData$State;", "component3", "()Lcom/avito/android/photo_view/ImageData$State;", "id", "localUri", "state", "copy", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/photo_view/ImageData$State;)Lcom/avito/android/photo_view/PhotoImageData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/photo_view/ImageData$State;", "getState", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getLocalUri", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/photo_view/ImageData$State;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoImageData implements ImageData {
    @NotNull
    public final String a;
    @Nullable
    public final Uri b;
    @NotNull
    public final ImageData.State c;

    public PhotoImageData(@NotNull String str, @Nullable Uri uri, @NotNull ImageData.State state) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = str;
        this.b = uri;
        this.c = state;
    }

    public static /* synthetic */ PhotoImageData copy$default(PhotoImageData photoImageData, String str, Uri uri, ImageData.State state, int i, Object obj) {
        if ((i & 1) != 0) {
            str = photoImageData.getId();
        }
        if ((i & 2) != 0) {
            uri = photoImageData.getLocalUri();
        }
        if ((i & 4) != 0) {
            state = photoImageData.getState();
        }
        return photoImageData.copy(str, uri, state);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final Uri component2() {
        return getLocalUri();
    }

    @NotNull
    public final ImageData.State component3() {
        return getState();
    }

    @NotNull
    public final PhotoImageData copy(@NotNull String str, @Nullable Uri uri, @NotNull ImageData.State state) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        return new PhotoImageData(str, uri, state);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoImageData)) {
            return false;
        }
        PhotoImageData photoImageData = (PhotoImageData) obj;
        return Intrinsics.areEqual(getId(), photoImageData.getId()) && Intrinsics.areEqual(getLocalUri(), photoImageData.getLocalUri()) && Intrinsics.areEqual(getState(), photoImageData.getState());
    }

    @Override // com.avito.android.photo_view.ImageData
    @NotNull
    public String getId() {
        return this.a;
    }

    @Override // com.avito.android.photo_view.ImageData
    @Nullable
    public Uri getLocalUri() {
        return this.b;
    }

    @Override // com.avito.android.photo_view.ImageData
    @NotNull
    public ImageData.State getState() {
        return this.c;
    }

    public int hashCode() {
        String id = getId();
        int i = 0;
        int hashCode = (id != null ? id.hashCode() : 0) * 31;
        Uri localUri = getLocalUri();
        int hashCode2 = (hashCode + (localUri != null ? localUri.hashCode() : 0)) * 31;
        ImageData.State state = getState();
        if (state != null) {
            i = state.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PhotoImageData(id=");
        L.append(getId());
        L.append(", localUri=");
        L.append(getLocalUri());
        L.append(", state=");
        L.append(getState());
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoImageData(String str, Uri uri, ImageData.State state, int i, j jVar) {
        this(str, uri, (i & 4) != 0 ? ImageData.State.NotAdded.INSTANCE : state);
    }
}
