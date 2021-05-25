package com.avito.android.items;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/items/ItemWithAdditionalButton;", "", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "getAdditionalButton", "()Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "additionalButton", "AdditionalButton", "AdditionalButtonType", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public interface ItemWithAdditionalButton {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getLink", "()Ljava/lang/String;", "link", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButtonType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButtonType;", "getType", "()Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButtonType;", "type", "<init>", "(Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButtonType;Ljava/lang/String;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdditionalButton implements Parcelable {
        public static final Parcelable.Creator<AdditionalButton> CREATOR = new Creator();
        @NotNull
        public final AdditionalButtonType a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AdditionalButton> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdditionalButton createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AdditionalButton((AdditionalButtonType) Enum.valueOf(AdditionalButtonType.class, parcel.readString()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdditionalButton[] newArray(int i) {
                return new AdditionalButton[i];
            }
        }

        public AdditionalButton(@NotNull AdditionalButtonType additionalButtonType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(additionalButtonType, "type");
            this.a = additionalButtonType;
            this.b = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getLink() {
            return this.b;
        }

        @NotNull
        public final AdditionalButtonType getType() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a.name());
            parcel.writeString(this.b);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AdditionalButton(AdditionalButtonType additionalButtonType, String str, int i, j jVar) {
            this(additionalButtonType, (i & 2) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "HELP", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
    public enum AdditionalButtonType {
        HELP
    }

    @Nullable
    AdditionalButton getAdditionalButton();
}
