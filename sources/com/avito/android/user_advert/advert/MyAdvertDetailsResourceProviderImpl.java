package com.avito.android.user_advert.advert;

import android.content.res.Resources;
import com.avito.android.advert_core.utils.LocationUtils;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LocationInfo;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.user_advert.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u0010\u001a\u00020\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0016\u0010\u0014\u001a\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013¨\u0006\""}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProviderImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProvider;", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "", "getPricePostfix", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/LocationInfo;", "loc", "getFullAddress", "(Lcom/avito/android/remote/model/LocationInfo;)Ljava/lang/String;", "getPriceUpdateErrorMessage", "getDraftDeleteConfirmation", "getNetworkErrorMessage", "getSupportEmailAddress", "supportEmailAddress", "getSupportEmailText", "supportEmailText", "", "getImvChartContainerId", "()I", "imvChartContainerId", "getUserEmail", "userEmail", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getImvBadgeContainerId", "imvBadgeContainerId", "getImvDescriptionContainerId", "imvDescriptionContainerId", "supportEmailResourceProviderDelegate", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/shared_providers/SupportEmailResourceProvider;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsResourceProviderImpl implements MyAdvertDetailsResourceProvider, SupportEmailResourceProvider {
    public final Resources a;
    public final /* synthetic */ SupportEmailResourceProvider b;

    @Inject
    public MyAdvertDetailsResourceProviderImpl(@NotNull Resources resources, @NotNull SupportEmailResourceProvider supportEmailResourceProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(supportEmailResourceProvider, "supportEmailResourceProviderDelegate");
        this.b = supportEmailResourceProvider;
        this.a = resources;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    @NotNull
    public String getDraftDeleteConfirmation() {
        String string = this.a.getString(R.string.draft_delete_confirmation);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…raft_delete_confirmation)");
        return string;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    @NotNull
    public String getFullAddress(@NotNull LocationInfo locationInfo) {
        Intrinsics.checkNotNullParameter(locationInfo, "loc");
        return LocationUtils.Companion.generateFullAddress(this.a, locationInfo);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    public int getImvBadgeContainerId() {
        return com.avito.android.advert_core.R.id.advert_details_badge;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    public int getImvChartContainerId() {
        return com.avito.android.advert_core.R.id.imv_chart_container;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    public int getImvDescriptionContainerId() {
        return com.avito.android.advert_core.R.id.imv_description_container;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    @NotNull
    public String getNetworkErrorMessage() {
        String string = this.a.getString(R.string.network_unavailable_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…work_unavailable_message)");
        return string;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    @NotNull
    public String getPricePostfix() {
        String string = this.a.getString(R.string.price_ruble_postfix);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.price_ruble_postfix)");
        return string;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider
    @NotNull
    public String getPriceUpdateErrorMessage() {
        String string = this.a.getString(R.string.price_update_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.price_update_error)");
        return string;
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @NotNull
    public String getSupportEmailAddress() {
        return this.b.getSupportEmailAddress();
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @NotNull
    public String getSupportEmailText() {
        return this.b.getSupportEmailText();
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @Nullable
    public String getUserEmail() {
        return this.b.getUserEmail();
    }
}
