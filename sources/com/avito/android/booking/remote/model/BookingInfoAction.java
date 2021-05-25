package com.avito.android.booking.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/booking/remote/model/BookingInfoAction;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", "component3", "()Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", "title", "deeplink", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;)Lcom/avito/android/booking/remote/model/BookingInfoAction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", "getStyle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoAction implements Parcelable {
    public static final Parcelable.Creator<BookingInfoAction> CREATOR = new Creator();
    @SerializedName("deeplink")
    @Nullable
    private final DeepLink deeplink;
    @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
    @Nullable
    private final BookingInfoActionStyle style;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BookingInfoAction> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingInfoAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BookingInfoAction(parcel.readString(), (DeepLink) parcel.readParcelable(BookingInfoAction.class.getClassLoader()), parcel.readInt() != 0 ? (BookingInfoActionStyle) Enum.valueOf(BookingInfoActionStyle.class, parcel.readString()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BookingInfoAction[] newArray(int i) {
            return new BookingInfoAction[i];
        }
    }

    public BookingInfoAction(@NotNull String str, @Nullable DeepLink deepLink, @Nullable BookingInfoActionStyle bookingInfoActionStyle) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.deeplink = deepLink;
        this.style = bookingInfoActionStyle;
    }

    public static /* synthetic */ BookingInfoAction copy$default(BookingInfoAction bookingInfoAction, String str, DeepLink deepLink, BookingInfoActionStyle bookingInfoActionStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bookingInfoAction.title;
        }
        if ((i & 2) != 0) {
            deepLink = bookingInfoAction.deeplink;
        }
        if ((i & 4) != 0) {
            bookingInfoActionStyle = bookingInfoAction.style;
        }
        return bookingInfoAction.copy(str, deepLink, bookingInfoActionStyle);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final DeepLink component2() {
        return this.deeplink;
    }

    @Nullable
    public final BookingInfoActionStyle component3() {
        return this.style;
    }

    @NotNull
    public final BookingInfoAction copy(@NotNull String str, @Nullable DeepLink deepLink, @Nullable BookingInfoActionStyle bookingInfoActionStyle) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new BookingInfoAction(str, deepLink, bookingInfoActionStyle);
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
        if (!(obj instanceof BookingInfoAction)) {
            return false;
        }
        BookingInfoAction bookingInfoAction = (BookingInfoAction) obj;
        return Intrinsics.areEqual(this.title, bookingInfoAction.title) && Intrinsics.areEqual(this.deeplink, bookingInfoAction.deeplink) && Intrinsics.areEqual(this.style, bookingInfoAction.style);
    }

    @Nullable
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final BookingInfoActionStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        DeepLink deepLink = this.deeplink;
        int hashCode2 = (hashCode + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        BookingInfoActionStyle bookingInfoActionStyle = this.style;
        if (bookingInfoActionStyle != null) {
            i = bookingInfoActionStyle.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BookingInfoAction(title=");
        L.append(this.title);
        L.append(", deeplink=");
        L.append(this.deeplink);
        L.append(", style=");
        L.append(this.style);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.deeplink, i);
        BookingInfoActionStyle bookingInfoActionStyle = this.style;
        if (bookingInfoActionStyle != null) {
            parcel.writeInt(1);
            parcel.writeString(bookingInfoActionStyle.name());
            return;
        }
        parcel.writeInt(0);
    }
}
