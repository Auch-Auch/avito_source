package com.avito.android.brandspace.interactor;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001!J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u0015J+\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;", "saveState", "()Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;", "state", "", "restoreState", "(Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;)V", "", "durationToTrackVisit", "sendPageLoaded", "(Ljava/lang/Long;)V", "Lcom/avito/android/brandspace/items/BlockType;", "blockType", "sendBlockViewIfNeeded", "(Lcom/avito/android/brandspace/items/BlockType;)V", "scheduleVisitTrackIfNeeded", "()V", "stopVisitTrackIfNeeded", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "item", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "forceBlockClick", "trackBlockClick", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/deep_linking/links/DeepLink;Z)V", "getDurationToTrackVisit", "()J", "State", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceAnalyticsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void trackBlockClick$default(BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor, BrandspaceItem brandspaceItem, DeepLink deepLink, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                brandspaceAnalyticsInteractor.trackBlockClick(brandspaceItem, deepLink, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackBlockClick");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ \u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJr\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b#\u0010$R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R)\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\nR)\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010\u0004R)\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010)\u001a\u0004\b0\u0010\n¨\u00063"}, d2 = {"Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;", "Landroid/os/Parcelable;", "", "component1", "()J", "component2", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "component3", "()Ljava/util/HashSet;", "component4", "component5", "stateId", "durationToTrackVisit", "trackedBlockTypeViews", "trackedBlockTypeClicks", "trackedAdvertClicks", "copy", "(JJLjava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;)Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor$State;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "J", "getStateId", "e", "Ljava/util/HashSet;", "getTrackedAdvertClicks", "c", "getTrackedBlockTypeViews", AuthSource.BOOKING_ORDER, "getDurationToTrackVisit", "d", "getTrackedBlockTypeClicks", "<init>", "(JJLjava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Creator();
        public final long a;
        public final long b;
        @NotNull
        public final HashSet<String> c;
        @NotNull
        public final HashSet<String> d;
        @NotNull
        public final HashSet<String> e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                long readLong = parcel.readLong();
                long readLong2 = parcel.readLong();
                int readInt = parcel.readInt();
                HashSet hashSet = new HashSet(readInt);
                while (readInt != 0) {
                    hashSet.add(parcel.readString());
                    readInt--;
                }
                int readInt2 = parcel.readInt();
                HashSet hashSet2 = new HashSet(readInt2);
                while (readInt2 != 0) {
                    hashSet2.add(parcel.readString());
                    readInt2--;
                }
                int readInt3 = parcel.readInt();
                HashSet hashSet3 = new HashSet(readInt3);
                while (readInt3 != 0) {
                    hashSet3.add(parcel.readString());
                    readInt3--;
                }
                return new State(readLong, readLong2, hashSet, hashSet2, hashSet3);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final State[] newArray(int i) {
                return new State[i];
            }
        }

        public State(long j, long j2, @NotNull HashSet<String> hashSet, @NotNull HashSet<String> hashSet2, @NotNull HashSet<String> hashSet3) {
            Intrinsics.checkNotNullParameter(hashSet, "trackedBlockTypeViews");
            Intrinsics.checkNotNullParameter(hashSet2, "trackedBlockTypeClicks");
            Intrinsics.checkNotNullParameter(hashSet3, "trackedAdvertClicks");
            this.a = j;
            this.b = j2;
            this.c = hashSet;
            this.d = hashSet2;
            this.e = hashSet3;
        }

        public static /* synthetic */ State copy$default(State state, long j, long j2, HashSet hashSet, HashSet hashSet2, HashSet hashSet3, int i, Object obj) {
            return state.copy((i & 1) != 0 ? state.a : j, (i & 2) != 0 ? state.b : j2, (i & 4) != 0 ? state.c : hashSet, (i & 8) != 0 ? state.d : hashSet2, (i & 16) != 0 ? state.e : hashSet3);
        }

        public final long component1() {
            return this.a;
        }

        public final long component2() {
            return this.b;
        }

        @NotNull
        public final HashSet<String> component3() {
            return this.c;
        }

        @NotNull
        public final HashSet<String> component4() {
            return this.d;
        }

        @NotNull
        public final HashSet<String> component5() {
            return this.e;
        }

        @NotNull
        public final State copy(long j, long j2, @NotNull HashSet<String> hashSet, @NotNull HashSet<String> hashSet2, @NotNull HashSet<String> hashSet3) {
            Intrinsics.checkNotNullParameter(hashSet, "trackedBlockTypeViews");
            Intrinsics.checkNotNullParameter(hashSet2, "trackedBlockTypeClicks");
            Intrinsics.checkNotNullParameter(hashSet3, "trackedAdvertClicks");
            return new State(j, j2, hashSet, hashSet2, hashSet3);
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
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return this.a == state.a && this.b == state.b && Intrinsics.areEqual(this.c, state.c) && Intrinsics.areEqual(this.d, state.d) && Intrinsics.areEqual(this.e, state.e);
        }

        public final long getDurationToTrackVisit() {
            return this.b;
        }

        public final long getStateId() {
            return this.a;
        }

        @NotNull
        public final HashSet<String> getTrackedAdvertClicks() {
            return this.e;
        }

        @NotNull
        public final HashSet<String> getTrackedBlockTypeClicks() {
            return this.d;
        }

        @NotNull
        public final HashSet<String> getTrackedBlockTypeViews() {
            return this.c;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int a3 = ((c.a(this.a) * 31) + c.a(this.b)) * 31;
            HashSet<String> hashSet = this.c;
            int i = 0;
            int hashCode = (a3 + (hashSet != null ? hashSet.hashCode() : 0)) * 31;
            HashSet<String> hashSet2 = this.d;
            int hashCode2 = (hashCode + (hashSet2 != null ? hashSet2.hashCode() : 0)) * 31;
            HashSet<String> hashSet3 = this.e;
            if (hashSet3 != null) {
                i = hashSet3.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(stateId=");
            L.append(this.a);
            L.append(", durationToTrackVisit=");
            L.append(this.b);
            L.append(", trackedBlockTypeViews=");
            L.append(this.c);
            L.append(", trackedBlockTypeClicks=");
            L.append(this.d);
            L.append(", trackedAdvertClicks=");
            L.append(this.e);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.a);
            parcel.writeLong(this.b);
            HashSet<String> hashSet = this.c;
            parcel.writeInt(hashSet.size());
            for (String str : hashSet) {
                parcel.writeString(str);
            }
            HashSet<String> hashSet2 = this.d;
            parcel.writeInt(hashSet2.size());
            for (String str2 : hashSet2) {
                parcel.writeString(str2);
            }
            HashSet<String> hashSet3 = this.e;
            parcel.writeInt(hashSet3.size());
            for (String str3 : hashSet3) {
                parcel.writeString(str3);
            }
        }
    }

    long getDurationToTrackVisit();

    @NotNull
    TreeClickStreamParent getParent();

    void restoreState(@NotNull State state);

    @NotNull
    State saveState();

    void scheduleVisitTrackIfNeeded();

    void sendBlockViewIfNeeded(@NotNull BlockType blockType);

    void sendPageLoaded(@Nullable Long l);

    void stopVisitTrackIfNeeded();

    void trackBlockClick(@NotNull BrandspaceItem brandspaceItem, @Nullable DeepLink deepLink, boolean z);
}
