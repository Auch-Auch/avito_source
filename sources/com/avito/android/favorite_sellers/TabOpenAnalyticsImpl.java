package com.avito.android.favorite_sellers;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.Analytics;
import com.avito.android.favorite_sellers.event.FavoriteSellersTabOpenEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.FavoriteSellersResult;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014¨\u0006#"}, d2 = {"Lcom/avito/android/favorite_sellers/TabOpenAnalyticsImpl;", "Lcom/avito/android/favorite_sellers/TabOpenAnalytics;", "Lcom/avito/android/util/Kundle;", "state", "", "initWithState", "(Lcom/avito/android/util/Kundle;)V", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "visibleToUser", "onVisibilityChanged", "(Z)V", "Lcom/avito/android/remote/model/FavoriteSellersResult;", "result", "setResult", "(Lcom/avito/android/remote/model/FavoriteSellersResult;)V", "reset", "()V", AuthSource.SEND_ABUSE, "Z", "tracked", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/favorite_sellers/TabOpenAnalyticsImpl$EventData;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorite_sellers/TabOpenAnalyticsImpl$EventData;", "data", "c", "screenVisible", "<init>", "(Lcom/avito/android/analytics/Analytics;)V", "EventData", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class TabOpenAnalyticsImpl implements TabOpenAnalytics {
    public boolean a;
    public EventData b;
    public boolean c;
    public final Analytics d;

    @Parcelize
    public static final class EventData implements Parcelable {
        public static final Parcelable.Creator<EventData> CREATOR = new Creator();
        public final int a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<EventData> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EventData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new EventData(parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EventData[] newArray(int i) {
                return new EventData[i];
            }
        }

        public EventData(int i, @Nullable String str) {
            this.a = i;
            this.b = str;
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
            if (!(obj instanceof EventData)) {
                return false;
            }
            EventData eventData = (EventData) obj;
            return this.a == eventData.a && Intrinsics.areEqual(this.b, eventData.b);
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = this.a * 31;
            String str = this.b;
            return i + (str != null ? str.hashCode() : 0);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("EventData(favoriteCount=");
            L.append(this.a);
            L.append(", xHash=");
            return a.t(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.a);
            parcel.writeString(this.b);
        }
    }

    public TabOpenAnalyticsImpl(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.d = analytics;
    }

    public final void a() {
        EventData eventData = this.b;
        if (eventData != null && !this.a && this.c) {
            this.d.track(new FavoriteSellersTabOpenEvent(eventData.a, eventData.b));
            this.a = true;
        }
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void initWithState(@Nullable Kundle kundle) {
        Boolean bool;
        this.a = (kundle == null || (bool = kundle.getBoolean("tracked")) == null) ? false : bool.booleanValue();
        this.b = kundle != null ? (EventData) kundle.getParcelable("data") : null;
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putBoolean("tracked", Boolean.valueOf(this.a)).putParcelable("data", this.b);
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void onVisibilityChanged(boolean z) {
        this.c = z;
        if (z) {
            a();
        } else {
            reset();
        }
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void reset() {
        this.a = false;
    }

    @Override // com.avito.android.favorite_sellers.TabOpenAnalytics
    public void setResult(@Nullable FavoriteSellersResult favoriteSellersResult) {
        EventData eventData;
        if (favoriteSellersResult == null) {
            eventData = new EventData(0, null);
        } else {
            eventData = new EventData(favoriteSellersResult.getTotalCount(), favoriteSellersResult.getXHash());
        }
        this.b = eventData;
        a();
    }
}
