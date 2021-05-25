package com.avito.android.serp.adapter.warning;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u00019BG\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010'\u001a\u00020$\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b7\u00108J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\nR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001d\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010'\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001f\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u00100\u001a\u00020$8\u0016@\u0016XD¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b0\u0010(R\u001c\u00106\u001a\u0002018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "h", "I", "getSpanCount", "spanCount", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "d", "getTitle", "title", "Lcom/avito/android/remote/model/Image;", "e", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", "f", "Z", "isCloseable", "()Z", "", "Lcom/avito/android/remote/model/Action;", g.a, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "isExternalAd", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLjava/util/List;I)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpWarningItem implements PersistableSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpWarningItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final SerpViewType a = SerpViewType.SINGLE;
    public final long b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final Image e;
    public final boolean f;
    @NotNull
    public final List<Action> g;
    public final int h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/warning/SerpWarningItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SerpWarningItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SerpWarningItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            Image image = (Image) parcel2.readParcelable(Image.class.getClassLoader());
            boolean readBool = ParcelsKt.readBool(parcel2);
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, Action.class);
            if (createParcelableList == null) {
                createParcelableList = CollectionsKt__CollectionsKt.emptyList();
            }
            return new SerpWarningItem(readLong, u2, u22, image, readBool, createParcelableList, parcel2.readInt());
        }
    }

    public SerpWarningItem(long j, @NotNull String str, @NotNull String str2, @Nullable Image image, boolean z, @NotNull List<Action> list, int i) {
        a2.b.a.a.a.c1(str, "stringId", str2, "title", list, "actions");
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = image;
        this.f = z;
        this.g = list;
        this.h = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Action> getActions() {
        return this.g;
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
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    public final boolean isCloseable() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
        ParcelsKt.writeBool(parcel, this.f);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.g, i);
        parcel.writeInt(getSpanCount());
    }
}
