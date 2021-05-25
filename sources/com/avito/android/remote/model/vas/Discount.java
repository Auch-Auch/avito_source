package com.avito.android.remote.model.vas;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB-\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/vas/Discount;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/vas/Discount$Limit;", "limit", "Lcom/avito/android/remote/model/vas/Discount$Limit;", "getLimit", "()Lcom/avito/android/remote/model/vas/Discount$Limit;", "amount", "Ljava/lang/Integer;", "getAmount", "()Ljava/lang/Integer;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/vas/Discount$Limit;Ljava/lang/Integer;)V", "Companion", "Limit", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class Discount implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Discount> CREATOR = Parcels.creator(Discount$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("amount")
    @Nullable
    private final Integer amount;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("limit")
    @Nullable
    private final Limit limit;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/vas/Discount$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/vas/Discount;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "vas_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/vas/Discount$Limit;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "dueDate", "J", "getDueDate", "()J", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;J)V", "Companion", "vas_release"}, k = 1, mv = {1, 4, 2})
    public static final class Limit implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Limit> CREATOR = Parcels.creator(Discount$Limit$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("dueDate")
        private final long dueDate;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/vas/Discount$Limit$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/vas/Discount$Limit;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "vas_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Limit(@Nullable String str, long j) {
            this.title = str;
            this.dueDate = j;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final long getDueDate() {
            return this.dueDate;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.title);
            parcel.writeLong(this.dueDate);
        }
    }

    public Discount(@NotNull String str, @Nullable String str2, @Nullable Limit limit2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.limit = limit2;
        this.amount = num;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Limit getLimit() {
        return this.limit;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.limit, i);
        ParcelsKt.writeNullableValue(parcel, this.amount);
    }
}
