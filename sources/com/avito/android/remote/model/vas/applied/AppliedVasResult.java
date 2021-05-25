package com.avito.android.remote.model.vas.applied;

import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/vas/applied/AppliedVasResult;", "", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "Lcom/avito/android/remote/model/vas/applied/AppliedService;", VKApiConst.SERVICES, "Ljava/util/List;", "getServices", "()Ljava/util/List;", "Lcom/avito/android/remote/model/vas/applied/VasBundleBanner;", "banner", "Lcom/avito/android/remote/model/vas/applied/VasBundleBanner;", "getBanner", "()Lcom/avito/android/remote/model/vas/applied/VasBundleBanner;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/vas/applied/VasBundleBanner;Ljava/util/List;Lcom/avito/android/remote/model/Action;)V", "vas_release"}, k = 1, mv = {1, 4, 2})
public final class AppliedVasResult {
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("banner")
    @Nullable
    private final VasBundleBanner banner;
    @SerializedName(VKApiConst.SERVICES)
    @NotNull
    private final List<AppliedService> services;
    @SerializedName("title")
    @NotNull
    private final String title;

    public AppliedVasResult(@NotNull String str, @Nullable VasBundleBanner vasBundleBanner, @NotNull List<AppliedService> list, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
        this.title = str;
        this.banner = vasBundleBanner;
        this.services = list;
        this.action = action2;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final VasBundleBanner getBanner() {
        return this.banner;
    }

    @NotNull
    public final List<AppliedService> getServices() {
        return this.services;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
