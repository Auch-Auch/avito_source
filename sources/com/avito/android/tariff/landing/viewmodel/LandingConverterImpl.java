package com.avito.android.tariff.landing.viewmodel;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.model.IconSection;
import com.avito.android.remote.model.TariffLandingResult;
import com.avito.android.remote.model.TariffLandingSection;
import com.avito.android.remote.model.TextSection;
import com.avito.android.tariff.landing.item.icon.IconItem;
import com.avito.android.tariff.landing.item.text.TextItem;
import com.avito.android.util.LoadingState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/landing/viewmodel/LandingConverterImpl;", "Lcom/avito/android/tariff/landing/viewmodel/LandingConverter;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/TariffLandingResult;", "state", "Lcom/avito/android/tariff/landing/viewmodel/TariffLanding;", "convert", "(Lcom/avito/android/util/LoadingState;)Lcom/avito/android/util/LoadingState;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class LandingConverterImpl implements LandingConverter {
    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.TariffLandingResult> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.tariff.landing.viewmodel.LandingConverter
    @NotNull
    public LoadingState<TariffLanding> convert(@NotNull LoadingState<? super TariffLandingResult> loadingState) {
        Object obj;
        Intrinsics.checkNotNullParameter(loadingState, "state");
        if (loadingState instanceof LoadingState.Loaded) {
            TariffLandingResult tariffLandingResult = (TariffLandingResult) ((LoadingState.Loaded) loadingState).getData();
            int i = 0;
            List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PaidServiceHeaderItem("headerId", tariffLandingResult.getTitle(), null));
            List<TariffLandingSection> list = tariffLandingResult.getList();
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                if (t2 instanceof IconSection) {
                    T t3 = t2;
                    obj = new IconItem(String.valueOf(i), AvitoPictureKt.pictureOf$default(t3.getIcon(), true, 0.0f, 0.0f, null, 28, null), t3.getTitle());
                } else if (t2 instanceof TextSection) {
                    T t4 = t2;
                    obj = new TextItem(String.valueOf(i), t4.getTitle(), t4.getDescription());
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
                i = i2;
            }
            h.addAll(mutableListOf, arrayList);
            return new LoadingState.Loaded(new TariffLanding(mutableListOf, tariffLandingResult.getAction()));
        } else if ((loadingState instanceof LoadingState.Error) || (loadingState instanceof LoadingState.Loading)) {
            return loadingState;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
