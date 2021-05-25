package com.avito.android.saved_searches;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0019\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/saved_searches/SavedSearchesPresenterState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/Integer;", "getSelectedFrequencyId", "()Ljava/lang/Integer;", "selectedFrequencyId", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "getSubscriptionParams", "()Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscriptionParams", "", AuthSource.BOOKING_ORDER, "Z", "isDialogOpened", "()Z", "<init>", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;ZLjava/lang/Integer;)V", "saved-searches_release"}, k = 1, mv = {1, 4, 2})
public final class SavedSearchesPresenterState implements Parcelable {
    public static final Parcelable.Creator<SavedSearchesPresenterState> CREATOR = new Creator();
    @Nullable
    public final SearchPushSubscription a;
    public final boolean b;
    @Nullable
    public final Integer c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SavedSearchesPresenterState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SavedSearchesPresenterState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SavedSearchesPresenterState((SearchPushSubscription) parcel.readParcelable(SavedSearchesPresenterState.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SavedSearchesPresenterState[] newArray(int i) {
            return new SavedSearchesPresenterState[i];
        }
    }

    public SavedSearchesPresenterState(@Nullable SearchPushSubscription searchPushSubscription, boolean z, @Nullable Integer num) {
        this.a = searchPushSubscription;
        this.b = z;
        this.c = num;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getSelectedFrequencyId() {
        return this.c;
    }

    @Nullable
    public final SearchPushSubscription getSubscriptionParams() {
        return this.a;
    }

    public final boolean isDialogOpened() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeInt(this.b ? 1 : 0);
        Integer num = this.c;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
