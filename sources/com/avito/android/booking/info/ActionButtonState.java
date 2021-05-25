package com.avito.android.booking.info;

import a2.b.a.a.a;
import com.avito.android.booking.remote.model.BookingInfoActionStyle;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/avito/android/booking/info/ActionButtonState;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", "component2", "()Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "deepLink", "copy", "(Ljava/lang/String;Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/booking/info/ActionButtonState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;", "getStyle", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/booking/remote/model/BookingInfoActionStyle;Lcom/avito/android/deep_linking/links/DeepLink;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class ActionButtonState {
    @NotNull
    public final String a;
    @NotNull
    public final BookingInfoActionStyle b;
    @Nullable
    public final DeepLink c;

    public ActionButtonState(@NotNull String str, @NotNull BookingInfoActionStyle bookingInfoActionStyle, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(bookingInfoActionStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.a = str;
        this.b = bookingInfoActionStyle;
        this.c = deepLink;
    }

    public static /* synthetic */ ActionButtonState copy$default(ActionButtonState actionButtonState, String str, BookingInfoActionStyle bookingInfoActionStyle, DeepLink deepLink, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionButtonState.a;
        }
        if ((i & 2) != 0) {
            bookingInfoActionStyle = actionButtonState.b;
        }
        if ((i & 4) != 0) {
            deepLink = actionButtonState.c;
        }
        return actionButtonState.copy(str, bookingInfoActionStyle, deepLink);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final BookingInfoActionStyle component2() {
        return this.b;
    }

    @Nullable
    public final DeepLink component3() {
        return this.c;
    }

    @NotNull
    public final ActionButtonState copy(@NotNull String str, @NotNull BookingInfoActionStyle bookingInfoActionStyle, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(bookingInfoActionStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        return new ActionButtonState(str, bookingInfoActionStyle, deepLink);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionButtonState)) {
            return false;
        }
        ActionButtonState actionButtonState = (ActionButtonState) obj;
        return Intrinsics.areEqual(this.a, actionButtonState.a) && Intrinsics.areEqual(this.b, actionButtonState.b) && Intrinsics.areEqual(this.c, actionButtonState.c);
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.c;
    }

    @NotNull
    public final BookingInfoActionStyle getStyle() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        BookingInfoActionStyle bookingInfoActionStyle = this.b;
        int hashCode2 = (hashCode + (bookingInfoActionStyle != null ? bookingInfoActionStyle.hashCode() : 0)) * 31;
        DeepLink deepLink = this.c;
        if (deepLink != null) {
            i = deepLink.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ActionButtonState(title=");
        L.append(this.a);
        L.append(", style=");
        L.append(this.b);
        L.append(", deepLink=");
        return a.m(L, this.c, ")");
    }
}
