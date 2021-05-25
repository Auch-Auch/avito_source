package com.avito.android.safedeal.delivery_courier.time_interval_select;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProviderImpl;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/DeliveryCourierTimeIntervalSelectResourceProvider;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "", "getNetworkError", "()Ljava/lang/String;", "networkError", "getUnknownError", "unknownError", "<init>", "(Landroid/content/res/Resources;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierTimeIntervalSelectResourceProviderImpl implements DeliveryCourierTimeIntervalSelectResourceProvider {
    public final Resources a;

    @Inject
    public DeliveryCourierTimeIntervalSelectResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProvider
    @NotNull
    public String getNetworkError() {
        String string = this.a.getString(R.string.network_loading_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.network_loading_error)");
        return string;
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectResourceProvider
    @NotNull
    public String getUnknownError() {
        String string = this.a.getString(R.string.delivery_courier_has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…urier_has_error_occurred)");
        return string;
    }
}
