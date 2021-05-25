package com.avito.android.user_advert.advert;

import androidx.annotation.IdRes;
import com.avito.android.remote.model.LocationInfo;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\f8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProvider;", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "", "getPricePostfix", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/LocationInfo;", "loc", "getFullAddress", "(Lcom/avito/android/remote/model/LocationInfo;)Ljava/lang/String;", "getPriceUpdateErrorMessage", "getDraftDeleteConfirmation", "getNetworkErrorMessage", "", "getImvChartContainerId", "()I", "imvChartContainerId", "getImvDescriptionContainerId", "imvDescriptionContainerId", "getImvBadgeContainerId", "imvBadgeContainerId", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertDetailsResourceProvider extends SupportEmailResourceProvider {
    @NotNull
    String getDraftDeleteConfirmation();

    @NotNull
    String getFullAddress(@NotNull LocationInfo locationInfo);

    @IdRes
    int getImvBadgeContainerId();

    @IdRes
    int getImvChartContainerId();

    @IdRes
    int getImvDescriptionContainerId();

    @NotNull
    String getNetworkErrorMessage();

    @NotNull
    String getPricePostfix();

    @NotNull
    String getPriceUpdateErrorMessage();
}
