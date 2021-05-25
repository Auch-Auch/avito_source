package com.avito.android.messenger.conversation.mvi.send;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler;", "", "", "operationId", "Lio/reactivex/Single;", "", "Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler$Photo;", "handlePhotoPickerResult", "(Ljava/lang/String;)Lio/reactivex/Single;", "Photo", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoPickerResultHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler$Photo;", "", "", "component1", "()J", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "uploadId", ShareConstants.MEDIA_URI, "copy", "(JLandroid/net/Uri;)Lcom/avito/android/messenger/conversation/mvi/send/PhotoPickerResultHandler$Photo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "J", "getUploadId", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getUri", "<init>", "(JLandroid/net/Uri;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Photo {
        public final long a;
        @NotNull
        public final Uri b;

        public Photo(long j, @NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            this.a = j;
            this.b = uri;
        }

        public static /* synthetic */ Photo copy$default(Photo photo, long j, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                j = photo.a;
            }
            if ((i & 2) != 0) {
                uri = photo.b;
            }
            return photo.copy(j, uri);
        }

        public final long component1() {
            return this.a;
        }

        @NotNull
        public final Uri component2() {
            return this.b;
        }

        @NotNull
        public final Photo copy(long j, @NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
            return new Photo(j, uri);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Photo)) {
                return false;
            }
            Photo photo = (Photo) obj;
            return this.a == photo.a && Intrinsics.areEqual(this.b, photo.b);
        }

        public final long getUploadId() {
            return this.a;
        }

        @NotNull
        public final Uri getUri() {
            return this.b;
        }

        public int hashCode() {
            int a3 = c.a(this.a) * 31;
            Uri uri = this.b;
            return a3 + (uri != null ? uri.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Photo(uploadId=");
            L.append(this.a);
            L.append(", uri=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @NotNull
    Single<List<Photo>> handlePhotoPickerResult(@NotNull String str);
}
