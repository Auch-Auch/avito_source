package com.avito.android.advert.viewed;

import com.avito.android.Features;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.util.SchedulersFactory3;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorFactory;", "", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "dao", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "create", "(Lcom/avito/android/db/viewed/ViewedAdvertsDao;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/Features;)Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ViewedAdvertsInteractorFactory {
    @NotNull
    ViewedAdvertsInteractor create(@NotNull ViewedAdvertsDao viewedAdvertsDao, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull Features features);
}
