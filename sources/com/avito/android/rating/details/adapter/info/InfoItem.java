package com.avito.android.rating.details.adapter.info;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB+\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0019\u0010\u001a\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/avito/android/rating/details/adapter/info/InfoItem;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;", "d", "Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;", "getHint", "()Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;", "hint", AuthSource.SEND_ABUSE, "getStringId", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;)V", "Companion", "Hint", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class InfoItem extends RatingDetailsItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<InfoItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final Hint d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/details/adapter/info/InfoItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/rating/details/adapter/info/InfoItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ>\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\tR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010$\u001a\u0004\b'\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/deep_linking/links/DeepLink;", "component4", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "text", "actionText", "deepLink", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/rating/details/adapter/info/InfoItem$Hint;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", AuthSource.BOOKING_ORDER, "getText", "c", "getActionText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Hint implements Parcelable {
        public static final Parcelable.Creator<Hint> CREATOR = new Creator();
        @Nullable
        public final String a;
        @NotNull
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final DeepLink d;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Hint> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Hint createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Hint(parcel.readString(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(Hint.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Hint[] newArray(int i) {
                return new Hint[i];
            }
        }

        public Hint(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str2, "text");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = deepLink;
        }

        public static /* synthetic */ Hint copy$default(Hint hint, String str, String str2, String str3, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hint.a;
            }
            if ((i & 2) != 0) {
                str2 = hint.b;
            }
            if ((i & 4) != 0) {
                str3 = hint.c;
            }
            if ((i & 8) != 0) {
                deepLink = hint.d;
            }
            return hint.copy(str, str2, str3, deepLink);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final DeepLink component4() {
            return this.d;
        }

        @NotNull
        public final Hint copy(@Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str2, "text");
            return new Hint(str, str2, str3, deepLink);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Hint)) {
                return false;
            }
            Hint hint = (Hint) obj;
            return Intrinsics.areEqual(this.a, hint.a) && Intrinsics.areEqual(this.b, hint.b) && Intrinsics.areEqual(this.c, hint.c) && Intrinsics.areEqual(this.d, hint.d);
        }

        @Nullable
        public final String getActionText() {
            return this.c;
        }

        @Nullable
        public final DeepLink getDeepLink() {
            return this.d;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }

        @Nullable
        public final String getTitle() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            DeepLink deepLink = this.d;
            if (deepLink != null) {
                i = deepLink.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Hint(title=");
            L.append(this.a);
            L.append(", text=");
            L.append(this.b);
            L.append(", actionText=");
            L.append(this.c);
            L.append(", deepLink=");
            return a2.b.a.a.a.m(L, this.d, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeParcelable(this.d, i);
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, InfoItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public InfoItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new InfoItem(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), (Hint) parcel2.readParcelable(Hint.class.getClassLoader()));
        }
    }

    public InfoItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Hint hint) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = hint;
    }

    @Nullable
    public final Hint getHint() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getSubtitle() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getStringId());
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
    }
}
