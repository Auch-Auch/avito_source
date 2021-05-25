package com.avito.android.deep_linking.links;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0018\u001a\u00020\u00138F@\u0006X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "version", "getPath", MessageMetaInfo.COLUMN_PATH, "Landroid/net/Uri;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getUri", "()Landroid/net/Uri;", ShareConstants.MEDIA_URI, "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class DeepLink implements Parcelable {
    @NotNull
    public final String a = "1";
    @NotNull
    public final Lazy b = c.lazy(new a(this));

    public static final class a extends Lambda implements Function0<Uri> {
        public final /* synthetic */ DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeepLink deepLink) {
            super(0);
            this.a = deepLink;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Uri invoke() {
            return new Uri.Builder().scheme(DeepLinkKt.DEEPLINK_URI_SCHEME).authority(this.a.getVersion()).path(this.a.getPath()).build();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public abstract String getPath();

    @NotNull
    public final Uri getUri() {
        return (Uri) this.b.getValue();
    }

    @NotNull
    public String getVersion() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
    }
}
