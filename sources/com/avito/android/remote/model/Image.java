package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.Images;
import com.avito.android.util.Parcels;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u001b\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u0018\u001a\u00020\u00002\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R%\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010\u0016¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/Image;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "find", "(II)Ljava/lang/String;", "getImageId", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/Size;", "Landroid/net/Uri;", "component1", "()Ljava/util/Map;", "variants", "copy", "(Ljava/util/Map;)Lcom/avito/android/remote/model/Image;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getVariants", "<init>", "(Ljava/util/Map;)V", "Companion", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class Image implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Image> CREATOR = Parcels.creator(Image$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<Size, Uri> variants;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Image$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Image;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<com.avito.android.remote.model.Size, ? extends android.net.Uri> */
    /* JADX WARN: Multi-variable type inference failed */
    public Image(@NotNull Map<Size, ? extends Uri> map) {
        Intrinsics.checkNotNullParameter(map, "variants");
        this.variants = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.Image */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Image copy$default(Image image, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = image.variants;
        }
        return image.copy(map);
    }

    @NotNull
    public final Map<Size, Uri> component1() {
        return this.variants;
    }

    @NotNull
    public final Image copy(@NotNull Map<Size, ? extends Uri> map) {
        Intrinsics.checkNotNullParameter(map, "variants");
        return new Image(map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof Image) && Intrinsics.areEqual(this.variants, ((Image) obj).variants);
        }
        return true;
    }

    @Nullable
    public final String find(int i, int i2) {
        Uri width = Images.fit$default(this, i, i2, 0.0f, 0.0f, 0, 28, null).width();
        if (width != null) {
            return width.toString();
        }
        return null;
    }

    @NotNull
    public final String getImageId() {
        String path;
        String substringAfterLast$default;
        Uri uri = (Uri) CollectionsKt___CollectionsKt.firstOrNull(this.variants.values());
        String str = null;
        if (!(uri == null || (path = uri.getPath()) == null || (substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null)) == null)) {
            str = StringsKt__StringsKt.substringBefore$default(substringAfterLast$default, (char) FormatterType.defaultDecimalSeparator, (String) null, 2, (Object) null);
        }
        return str != null ? str : "";
    }

    @NotNull
    public final Map<Size, Uri> getVariants() {
        return this.variants;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Map<Size, Uri> map = this.variants;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.x(a.L("Image(variants="), this.variants, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeMap(this.variants);
    }
}
