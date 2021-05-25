package com.avito.android.serp.adapter.empty_placeholder;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PlaceholderAction;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u00014B?\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u000b\u0012\u0006\u0010+\u001a\u00020\u000b\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b2\u00103J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u00020\u00188\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001c\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001c\u0010%\u001a\u00020 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010(\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000fR\u0019\u0010+\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\r\u001a\u0004\b*\u0010\u000fR\u001c\u00101\u001a\u00020,8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "Lcom/avito/android/remote/model/PlaceholderAction;", g.a, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "", "isExternalAd", "Z", "()Z", "d", "I", "getSpanCount", "spanCount", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "e", "getTitle", "title", "f", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "<init>", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyPlaceholderItem implements PersistableSerpItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<EmptyPlaceholderItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final SerpViewType a = SerpViewType.SINGLE;
    public final long b;
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @Nullable
    public final List<PlaceholderAction> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, EmptyPlaceholderItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public EmptyPlaceholderItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new EmptyPlaceholderItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readInt(), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.createParcelableList(parcel2, PlaceholderAction.class));
        }
    }

    public EmptyPlaceholderItem(long j, @NotNull String str, int i, @NotNull String str2, @NotNull String str3, @Nullable List<PlaceholderAction> list) {
        a2.b.a.a.a.Z0(str, "stringId", str2, "title", str3, MessengerShareContentUtility.SUBTITLE);
        this.b = j;
        this.c = str;
        this.d = i;
        this.e = str2;
        this.f = str3;
        this.g = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<PlaceholderAction> getActions() {
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

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final String getSubtitle() {
        return this.f;
    }

    @NotNull
    public final String getTitle() {
        return this.e;
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
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeInt(getSpanCount());
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.g, i);
    }
}
