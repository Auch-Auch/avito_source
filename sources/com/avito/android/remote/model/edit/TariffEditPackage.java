package com.avito.android.remote.model.edit;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.tariff.bar.TariffBar;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffEditPackage;", "Lcom/avito/android/remote/model/edit/PackageElement;", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "locations", "Ljava/lang/String;", "getLocations", "()Ljava/lang/String;", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "bar", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "getBar", "()Lcom/avito/android/remote/tariff/bar/TariffBar;", "", "Lcom/avito/android/remote/model/edit/TariffEditMicrocategories;", "microcategories", "Ljava/util/List;", "getMicrocategories", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/tariff/bar/TariffBar;Lcom/avito/android/deep_linking/links/DeepLink;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffEditPackage implements PackageElement {
    @SerializedName("bar")
    @NotNull
    private final TariffBar bar;
    @SerializedName("locations")
    @NotNull
    private final String locations;
    @SerializedName("microcategories")
    @Nullable
    private final List<TariffEditMicrocategories> microcategories;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    public TariffEditPackage(@Nullable List<TariffEditMicrocategories> list, @NotNull String str, @NotNull TariffBar tariffBar, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "locations");
        Intrinsics.checkNotNullParameter(tariffBar, "bar");
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        this.microcategories = list;
        this.locations = str;
        this.bar = tariffBar;
        this.uri = deepLink;
    }

    @NotNull
    public final TariffBar getBar() {
        return this.bar;
    }

    @NotNull
    public final String getLocations() {
        return this.locations;
    }

    @Nullable
    public final List<TariffEditMicrocategories> getMicrocategories() {
        return this.microcategories;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }
}
