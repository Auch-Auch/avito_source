package com.avito.android.user_stats.tab.list.items.blueprints.description;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.tab.list.items.DescriptionItem;
import com.avito.konveyor.blueprint.ItemPresenter;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemView;", "Lcom/avito/android/user_stats/tab/list/items/DescriptionItem;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter$DescriptionClickDetails;", "getLinkClicksObservable", "()Lio/reactivex/rxjava3/core/Observable;", "linkClicksObservable", "DescriptionClickDetails", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public interface DescriptionItemPresenter extends ItemPresenter<DescriptionItemView, DescriptionItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter$DescriptionClickDetails;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component2", "()Ljava/lang/String;", "deeplink", "fromType", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)Lcom/avito/android/user_stats/tab/list/items/blueprints/description/DescriptionItemPresenter$DescriptionClickDetails;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFromType", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    public static final class DescriptionClickDetails {
        @NotNull
        public final DeepLink a;
        @Nullable
        public final String b;

        public DescriptionClickDetails(@NotNull DeepLink deepLink, @Nullable String str) {
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            this.a = deepLink;
            this.b = str;
        }

        public static /* synthetic */ DescriptionClickDetails copy$default(DescriptionClickDetails descriptionClickDetails, DeepLink deepLink, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                deepLink = descriptionClickDetails.a;
            }
            if ((i & 2) != 0) {
                str = descriptionClickDetails.b;
            }
            return descriptionClickDetails.copy(deepLink, str);
        }

        @NotNull
        public final DeepLink component1() {
            return this.a;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final DescriptionClickDetails copy(@NotNull DeepLink deepLink, @Nullable String str) {
            Intrinsics.checkNotNullParameter(deepLink, "deeplink");
            return new DescriptionClickDetails(deepLink, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DescriptionClickDetails)) {
                return false;
            }
            DescriptionClickDetails descriptionClickDetails = (DescriptionClickDetails) obj;
            return Intrinsics.areEqual(this.a, descriptionClickDetails.a) && Intrinsics.areEqual(this.b, descriptionClickDetails.b);
        }

        @NotNull
        public final DeepLink getDeeplink() {
            return this.a;
        }

        @Nullable
        public final String getFromType() {
            return this.b;
        }

        public int hashCode() {
            DeepLink deepLink = this.a;
            int i = 0;
            int hashCode = (deepLink != null ? deepLink.hashCode() : 0) * 31;
            String str = this.b;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("DescriptionClickDetails(deeplink=");
            L.append(this.a);
            L.append(", fromType=");
            return a.t(L, this.b, ")");
        }
    }

    @NotNull
    Observable<DescriptionClickDetails> getLinkClicksObservable();
}
