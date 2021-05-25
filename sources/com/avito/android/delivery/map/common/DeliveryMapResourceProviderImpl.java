package com.avito.android.delivery.map.common;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapResourceProviderImpl;", "Lcom/avito/android/delivery/map/common/DeliveryMapResourceProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLocationNotFoundMessage", "()Ljava/lang/String;", "locationNotFoundMessage", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryMapResourceProviderImpl implements DeliveryMapResourceProvider {
    @NotNull
    public final String a;

    @Inject
    public DeliveryMapResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.no_found_location_search_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…_location_search_message)");
        this.a = string;
    }

    @Override // com.avito.android.delivery.map.common.DeliveryMapResourceProvider
    @NotNull
    public String getLocationNotFoundMessage() {
        return this.a;
    }
}
