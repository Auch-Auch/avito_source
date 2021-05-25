package com.avito.android.publish_limits_info;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/publish_limits_info/ItemId;", "Landroid/os/Parcelable;", "<init>", "()V", "Advert", "Draft", "Lcom/avito/android/publish_limits_info/ItemId$Advert;", "Lcom/avito/android/publish_limits_info/ItemId$Draft;", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public abstract class ItemId implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish_limits_info/ItemId$Advert;", "Lcom/avito/android/publish_limits_info/ItemId;", "", "component1", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "copy", "(Ljava/lang/String;)Lcom/avito/android/publish_limits_info/ItemId$Advert;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", "<init>", "(Ljava/lang/String;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    public static final class Advert extends ItemId {
        public static final Parcelable.Creator<Advert> CREATOR = new Creator();
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Advert> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Advert(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert[] newArray(int i) {
                return new Advert[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Advert(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            this.a = str;
        }

        public static /* synthetic */ Advert copy$default(Advert advert, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = advert.a;
            }
            return advert.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Advert copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            return new Advert(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Advert) && Intrinsics.areEqual(this.a, ((Advert) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getAdvertId() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("Advert(advertId="), this.a, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish_limits_info/ItemId$Draft;", "Lcom/avito/android/publish_limits_info/ItemId;", "", "component1", "()Ljava/lang/String;", "draftId", "copy", "(Ljava/lang/String;)Lcom/avito/android/publish_limits_info/ItemId$Draft;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDraftId", "<init>", "(Ljava/lang/String;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    public static final class Draft extends ItemId {
        public static final Parcelable.Creator<Draft> CREATOR = new Creator();
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Draft> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Draft createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Draft(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Draft[] newArray(int i) {
                return new Draft[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Draft(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "draftId");
            this.a = str;
        }

        public static /* synthetic */ Draft copy$default(Draft draft, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = draft.a;
            }
            return draft.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final Draft copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "draftId");
            return new Draft(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Draft) && Intrinsics.areEqual(this.a, ((Draft) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getDraftId() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("Draft(draftId="), this.a, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    public ItemId() {
    }

    public ItemId(j jVar) {
    }
}
