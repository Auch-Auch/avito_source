package com.avito.android.advert_core.short_term_rent;

import com.avito.android.advert_core.SnackBarListener;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView;", "", "CalendarButtonClickListener", "Listener", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertStrBlockView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$CalendarButtonClickListener;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onOpenCalendarButtonClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface CalendarButtonClickListener {
        void onOpenCalendarButtonClick(@NotNull DeepLink deepLink);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$Listener;", "Lcom/avito/android/advert_core/SnackBarListener;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener extends SnackBarListener {
    }
}
