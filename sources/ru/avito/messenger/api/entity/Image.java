package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0011\u001a\u00020\u00002\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR%\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lru/avito/messenger/api/entity/Image;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "", "Landroid/net/Uri;", "component1", "()Ljava/util/Map;", "variants", "copy", "(Ljava/util/Map;)Lru/avito/messenger/api/entity/Image;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getVariants", "<init>", "(Ljava/util/Map;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Image implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Image> CREATOR = Parcels.creator(Image$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final Map<String, Uri> variants;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/Image$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/Image;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends android.net.Uri> */
    /* JADX WARN: Multi-variable type inference failed */
    public Image(@NotNull Map<String, ? extends Uri> map) {
        Intrinsics.checkNotNullParameter(map, "variants");
        this.variants = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.avito.messenger.api.entity.Image */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Image copy$default(Image image, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = image.variants;
        }
        return image.copy(map);
    }

    @NotNull
    public final Map<String, Uri> component1() {
        return this.variants;
    }

    @NotNull
    public final Image copy(@NotNull Map<String, ? extends Uri> map) {
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

    @NotNull
    public final Map<String, Uri> getVariants() {
        return this.variants;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Map<String, Uri> map = this.variants;
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
        ParcelsKt.writeValueMap(parcel, this.variants);
    }
}
