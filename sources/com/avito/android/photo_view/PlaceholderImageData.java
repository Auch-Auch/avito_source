package com.avito.android.photo_view;

import a2.b.a.a.a;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.photo_view.ImageData;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJH\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\nR\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0004R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\"R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0007¨\u00061"}, d2 = {"Lcom/avito/android/photo_view/PlaceholderImageData;", "Lcom/avito/android/photo_view/ImageData;", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "Lcom/avito/android/photo_view/ImageData$State;", "component3", "()Lcom/avito/android/photo_view/ImageData$State;", "", "component4", "()Ljava/lang/Integer;", "component5", "id", "localUri", "state", "placeholderText", "placeholderIcon", "copy", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/photo_view/ImageData$State;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/avito/android/photo_view/PlaceholderImageData;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/Integer;", "getPlaceholderIcon", "setPlaceholderIcon", "(Ljava/lang/Integer;)V", "c", "Lcom/avito/android/photo_view/ImageData$State;", "getState", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "d", "getPlaceholderText", "setPlaceholderText", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getLocalUri", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/photo_view/ImageData$State;Ljava/lang/Integer;Ljava/lang/Integer;)V", "photo-view_release"}, k = 1, mv = {1, 4, 2})
public final class PlaceholderImageData implements ImageData {
    @NotNull
    public final String a;
    @Nullable
    public final Uri b;
    @NotNull
    public final ImageData.State c;
    @Nullable
    public Integer d;
    @Nullable
    public Integer e;

    public PlaceholderImageData(@NotNull String str, @Nullable Uri uri, @NotNull ImageData.State state, @StringRes @Nullable Integer num, @DrawableRes @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = str;
        this.b = uri;
        this.c = state;
        this.d = num;
        this.e = num2;
    }

    public static /* synthetic */ PlaceholderImageData copy$default(PlaceholderImageData placeholderImageData, String str, Uri uri, ImageData.State state, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = placeholderImageData.getId();
        }
        if ((i & 2) != 0) {
            uri = placeholderImageData.getLocalUri();
        }
        if ((i & 4) != 0) {
            state = placeholderImageData.getState();
        }
        if ((i & 8) != 0) {
            num = placeholderImageData.d;
        }
        if ((i & 16) != 0) {
            num2 = placeholderImageData.e;
        }
        return placeholderImageData.copy(str, uri, state, num, num2);
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

    @Nullable
    public final Integer component4() {
        return this.d;
    }

    @Nullable
    public final Integer component5() {
        return this.e;
    }

    @NotNull
    public final PlaceholderImageData copy(@NotNull String str, @Nullable Uri uri, @NotNull ImageData.State state, @StringRes @Nullable Integer num, @DrawableRes @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        return new PlaceholderImageData(str, uri, state, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceholderImageData)) {
            return false;
        }
        PlaceholderImageData placeholderImageData = (PlaceholderImageData) obj;
        return Intrinsics.areEqual(getId(), placeholderImageData.getId()) && Intrinsics.areEqual(getLocalUri(), placeholderImageData.getLocalUri()) && Intrinsics.areEqual(getState(), placeholderImageData.getState()) && Intrinsics.areEqual(this.d, placeholderImageData.d) && Intrinsics.areEqual(this.e, placeholderImageData.e);
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

    @Nullable
    public final Integer getPlaceholderIcon() {
        return this.e;
    }

    @Nullable
    public final Integer getPlaceholderText() {
        return this.d;
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
        int hashCode3 = (hashCode2 + (state != null ? state.hashCode() : 0)) * 31;
        Integer num = this.d;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.e;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setPlaceholderIcon(@Nullable Integer num) {
        this.e = num;
    }

    public final void setPlaceholderText(@Nullable Integer num) {
        this.d = num;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("PlaceholderImageData(id=");
        L.append(getId());
        L.append(", localUri=");
        L.append(getLocalUri());
        L.append(", state=");
        L.append(getState());
        L.append(", placeholderText=");
        L.append(this.d);
        L.append(", placeholderIcon=");
        return a.p(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaceholderImageData(String str, Uri uri, ImageData.State state, Integer num, Integer num2, int i, j jVar) {
        this(str, uri, (i & 4) != 0 ? ImageData.State.NotAdded.INSTANCE : state, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
    }
}
