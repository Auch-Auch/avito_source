package com.avito.android.serp.adapter;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BBY\u0012\u0006\u0010;\u001a\u000206\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\b\u00102\u001a\u0004\u0018\u00010\u0015\u0012\b\u00105\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010)\u001a\u0004\u0018\u00010$\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b@\u0010AJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0019\u0010#\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010/\u001a\u00020*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0017\u001a\u0004\b1\u0010\u0019R\u001b\u00105\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010\u0019R\u001c\u0010;\u001a\u0002068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010=\u001a\u00020<8\u0016@\u0016XD¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b=\u0010?¨\u0006C"}, d2 = {"Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "j", "I", "getSpanCount", "spanCount", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/Image;", "h", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "d", "getTitle", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "e", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/remote/model/Color;", "i", "Lcom/avito/android/remote/model/Color;", "getColor", "()Lcom/avito/android/remote/model/Color;", "color", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "f", "getLeftImage", "leftImage", g.a, "getRightImage", "rightImage", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "", "isExternalAd", "Z", "()Z", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Color;I)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutBannerItem implements PersistableSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShortcutBannerItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final SerpViewType a = SerpViewType.GRID;
    public final long b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final DeepLink e;
    @Nullable
    public final Image f;
    @Nullable
    public final Image g;
    @Nullable
    public final Image h;
    @Nullable
    public final Color i;
    public final int j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/ShortcutBannerItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ShortcutBannerItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShortcutBannerItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new ShortcutBannerItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2), (Image) parcel2.readParcelable(Image.class.getClassLoader()), (Image) parcel2.readParcelable(Image.class.getClassLoader()), (Image) parcel2.readParcelable(Image.class.getClassLoader()), (Color) parcel2.readParcelable(Color.class.getClassLoader()), parcel2.readInt());
        }
    }

    public ShortcutBannerItem(long j2, @NotNull String str, @Nullable String str2, @NotNull DeepLink deepLink, @Nullable Image image, @Nullable Image image2, @Nullable Image image3, @Nullable Color color, int i2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.b = j2;
        this.c = str;
        this.d = str2;
        this.e = deepLink;
        this.f = image;
        this.g = image2;
        this.h = image3;
        this.i = color;
        this.j = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Color getColor() {
        return this.i;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b;
    }

    @Nullable
    public final Image getImage() {
        return this.h;
    }

    @Nullable
    public final Image getLeftImage() {
        return this.f;
    }

    @Nullable
    public final Image getRightImage() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.j;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Nullable
    public final String getTitle() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i2);
        parcel.writeParcelable(this.f, i2);
        parcel.writeParcelable(this.g, i2);
        parcel.writeParcelable(this.h, i2);
        parcel.writeParcelable(this.i, i2);
        parcel.writeInt(getSpanCount());
    }
}
