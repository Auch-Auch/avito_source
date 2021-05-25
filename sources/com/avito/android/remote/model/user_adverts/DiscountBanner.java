package com.avito.android.remote.model.user_adverts;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SerpElement;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R(\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\u00020 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/user_adverts/DiscountBanner;", "Lcom/avito/android/remote/model/SerpElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", FirebaseAnalytics.Param.DISCOUNT, "Ljava/lang/String;", "getDiscount", "()Ljava/lang/String;", "title", "getTitle", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "getUniqueId$annotations", "()V", "Lcom/avito/android/remote/model/user_adverts/DiscountBanner$Limit;", "limit", "Lcom/avito/android/remote/model/user_adverts/DiscountBanner$Limit;", "getLimit", "()Lcom/avito/android/remote/model/user_adverts/DiscountBanner$Limit;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lcom/avito/android/remote/model/user_adverts/DiscountBanner$Limit;)V", "Limit", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountBanner implements SerpElement {
    public static final Parcelable.Creator<DiscountBanner> CREATOR = new Creator();
    @SerializedName(FirebaseAnalytics.Param.DISCOUNT)
    @NotNull
    private final String discount;
    @SerializedName("limit")
    @NotNull
    private final Limit limit;
    @SerializedName("title")
    @NotNull
    private final String title;
    private long uniqueId;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DiscountBanner> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DiscountBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DiscountBanner(parcel.readString(), (DeepLink) parcel.readParcelable(DiscountBanner.class.getClassLoader()), parcel.readString(), Limit.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DiscountBanner[] newArray(int i) {
            return new DiscountBanner[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/user_adverts/DiscountBanner$Limit;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "dueDate", "Ljava/lang/Long;", "getDueDate", "()Ljava/lang/Long;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Limit implements Parcelable {
        public static final Parcelable.Creator<Limit> CREATOR = new Creator();
        @SerializedName("dueDate")
        @Nullable
        private final Long dueDate;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Limit> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Limit createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Limit(parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Limit[] newArray(int i) {
                return new Limit[i];
            }
        }

        public Limit(@NotNull String str, @Nullable Long l) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.dueDate = l;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Long getDueDate() {
            return this.dueDate;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Long l = this.dueDate;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    public DiscountBanner(@NotNull String str, @NotNull DeepLink deepLink, @NotNull String str2, @NotNull Limit limit2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(str2, FirebaseAnalytics.Param.DISCOUNT);
        Intrinsics.checkNotNullParameter(limit2, "limit");
        this.title = str;
        this.uri = deepLink;
        this.discount = str2;
        this.limit = limit2;
    }

    public static /* synthetic */ void getUniqueId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getDiscount() {
        return this.discount;
    }

    @NotNull
    public final Limit getLimit() {
        return this.limit;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.uri, i);
        parcel.writeString(this.discount);
        this.limit.writeToParcel(parcel, 0);
    }
}
