package com.avito.android.advert.item.header.di;

import com.avito.android.advert.item.header.AdvertDetailsHeaderPresenter;
import com.avito.android.advert.item.header.AdvertDetailsHeaderPresenterImpl;
import com.avito.android.di.PerFragment;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert/item/header/di/AdvertDetailsHeaderModule;", "", "Lcom/avito/android/advert/item/header/AdvertDetailsHeaderPresenterImpl;", "presenter", "Lcom/avito/android/advert/item/header/AdvertDetailsHeaderPresenter;", "bindAdvertDetailsHeaderPresenter", "(Lcom/avito/android/advert/item/header/AdvertDetailsHeaderPresenterImpl;)Lcom/avito/android/advert/item/header/AdvertDetailsHeaderPresenter;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AdvertDetailsHeaderModule {
    @PerFragment
    @Binds
    @NotNull
    AdvertDetailsHeaderPresenter bindAdvertDetailsHeaderPresenter(@NotNull AdvertDetailsHeaderPresenterImpl advertDetailsHeaderPresenterImpl);
}
