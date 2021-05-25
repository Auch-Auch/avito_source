package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.remote.model.ParametrizedEvent;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B5\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b%\u0010&J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\"\u0010\u0019\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u001d\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/deep_linking/links/SafeDealOrderTypesDeepLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "f", "Ljava/lang/String;", "getSearchContext", "()Ljava/lang/String;", "searchContext", g.a, "getStyle", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "d", "getItemId", "itemId", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "", "e", "Z", "isMarketplace", "()Z", "Lcom/avito/android/remote/model/ParametrizedEvent;", "h", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getContactEvent", "()Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SafeDealOrderTypesDeepLink extends DeepLink {
    public static final Parcelable.Creator<SafeDealOrderTypesDeepLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/safeDeal/item/orderTypes/select";
    @NotNull
    public final String c = PATH;
    @NotNull
    public final String d;
    public final boolean e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final ParametrizedEvent h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/SafeDealOrderTypesDeepLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SafeDealOrderTypesDeepLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDealOrderTypesDeepLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SafeDealOrderTypesDeepLink(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? ParametrizedEvent.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDealOrderTypesDeepLink[] newArray(int i) {
            return new SafeDealOrderTypesDeepLink[i];
        }
    }

    public SafeDealOrderTypesDeepLink(@NotNull String str, boolean z, @Nullable String str2, @Nullable String str3, @Nullable ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.d = str;
        this.e = z;
        this.f = str2;
        this.g = str3;
        this.h = parametrizedEvent;
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Nullable
    public final ParametrizedEvent getContactEvent() {
        return this.h;
    }

    @NotNull
    public final String getItemId() {
        return this.d;
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
    public final String getStyle() {
        return this.g;
    }

    public final boolean isMarketplace() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        ParametrizedEvent parametrizedEvent = this.h;
        if (parametrizedEvent != null) {
            parcel.writeInt(1);
            parametrizedEvent.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
