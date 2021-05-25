package com.avito.android.advert_core.advert;

import androidx.annotation.ColorInt;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.marketplace.SpecificationItem;
import com.avito.android.remote.model.AdvertParameters;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\n\u0010\u0007J\u0019\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "bind", "(Ljava/util/List;)V", "Lcom/avito/android/remote/marketplace/SpecificationItem;", "specs", "bindOneColumn", "", "color", "forceColors", "(I)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsFlatView {
    void bind(@Nullable List<AdvertParameters.Parameter> list);

    void bindOneColumn(@NotNull List<SpecificationItem> list);

    void forceColors(@ColorInt int i);
}
