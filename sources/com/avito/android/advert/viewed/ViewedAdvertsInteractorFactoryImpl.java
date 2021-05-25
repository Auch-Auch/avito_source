package com.avito.android.advert.viewed;

import com.avito.android.Features;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.util.SchedulersFactory3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorFactoryImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorFactory;", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "dao", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "create", "(Lcom/avito/android/db/viewed/ViewedAdvertsDao;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/Features;)Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "<init>", "()V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedAdvertsInteractorFactoryImpl implements ViewedAdvertsInteractorFactory {
    @Override // com.avito.android.advert.viewed.ViewedAdvertsInteractorFactory
    @NotNull
    public ViewedAdvertsInteractor create(@NotNull ViewedAdvertsDao viewedAdvertsDao, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(viewedAdvertsDao, "dao");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsEventInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ViewedAdvertsInteractorImpl(viewedAdvertsDao, schedulersFactory3, viewedAdvertsEventInteractor);
    }
}
