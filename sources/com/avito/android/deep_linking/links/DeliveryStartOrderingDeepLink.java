package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParametrizedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:Be\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010\u0002\u0012\b\u00107\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010&\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u00104\u001a\u00020\u0012\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b8\u00109J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001b\u0010\u0010R\u001b\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010&\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016R\u001b\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010R\u001b\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010\u0010R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010\u0010\"\u0004\b/\u00100R\u0019\u00104\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016R\u001b\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b6\u0010\u0010¨\u0006;"}, d2 = {"Lcom/avito/android/deep_linking/links/DeliveryStartOrderingDeepLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "", "newLocationId", "copyWithNewLocationId", "(Ljava/lang/String;)Lcom/avito/android/deep_linking/links/DeliveryStartOrderingDeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "j", "Ljava/lang/String;", "getLocationId", "()Ljava/lang/String;", "locationId", "", "h", "Z", "isCart", "()Z", "l", "getCartItems", "cartItems", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "Lcom/avito/android/remote/model/ParametrizedEvent;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/ParametrizedEvent;", "getContactEvent", "()Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, g.a, "isMarketplace", "k", "getFirstCartItemId", "firstCartItemId", "d", "getItemId", "itemId", "e", "getSource", "setSource", "(Ljava/lang/String;)V", "source", "i", "getAutozoom", "autozoom", "f", "getSearchContext", "searchContext", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryStartOrderingDeepLink extends DeepLink {
    public static final Parcelable.Creator<DeliveryStartOrderingDeepLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/delivery/order/create";
    @NotNull
    public final String c = PATH;
    @Nullable
    public final String d;
    @Nullable
    public String e;
    @Nullable
    public final String f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    @Nullable
    public final String j;
    @Nullable
    public final String k;
    @Nullable
    public final String l;
    @Nullable
    public final ParametrizedEvent m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/DeliveryStartOrderingDeepLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryStartOrderingDeepLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryStartOrderingDeepLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryStartOrderingDeepLink(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? ParametrizedEvent.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryStartOrderingDeepLink[] newArray(int i) {
            return new DeliveryStartOrderingDeepLink[i];
        }
    }

    public DeliveryStartOrderingDeepLink(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, boolean z3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ParametrizedEvent parametrizedEvent) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = str4;
        this.k = str5;
        this.l = str6;
        this.m = parametrizedEvent;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @NotNull
    public final DeliveryStartOrderingDeepLink copyWithNewLocationId(@Nullable String str) {
        return new DeliveryStartOrderingDeepLink(this.d, this.e, this.f, this.g, this.h, this.i, str, this.k, this.l, this.m);
    }

    public final boolean getAutozoom() {
        return this.i;
    }

    @Nullable
    public final String getCartItems() {
        return this.l;
    }

    @Nullable
    public final ParametrizedEvent getContactEvent() {
        return this.m;
    }

    @Nullable
    public final String getFirstCartItemId() {
        return this.k;
    }

    @Nullable
    public final String getItemId() {
        return this.d;
    }

    @Nullable
    public final String getLocationId() {
        return this.j;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getSearchContext() {
        return this.f;
    }

    @Nullable
    public final String getSource() {
        return this.e;
    }

    public final boolean isCart() {
        return this.h;
    }

    public final boolean isMarketplace() {
        return this.g;
    }

    public final void setSource(@Nullable String str) {
        this.e = str;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        ParametrizedEvent parametrizedEvent = this.m;
        if (parametrizedEvent != null) {
            parcel.writeInt(1);
            parametrizedEvent.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
