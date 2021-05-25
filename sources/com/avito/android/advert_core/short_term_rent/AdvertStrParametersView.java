package com.avito.android.advert_core.short_term_rent;

import com.avito.android.advert_core.short_term_rent.AdvertStrBlock;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrParametersView;", "", "", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "bindParameters", "(Ljava/util/List;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertStrParametersView {
    void bindParameters(@Nullable List<AdvertStrBlock.Parameter> list);
}
