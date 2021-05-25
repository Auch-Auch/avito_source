package com.avito.android.advert_core.contactbar;

import com.avito.android.remote.model.AdvertAction;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "", "Lcom/avito/android/remote/model/AdvertAction;", "action", "Lkotlin/Pair;", "", "getActionIconRes", "(Lcom/avito/android/remote/model/AdvertAction;)Lkotlin/Pair;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertActionIconFactory {
    @NotNull
    Pair<Integer, Integer> getActionIconRes(@NotNull AdvertAction advertAction);
}
