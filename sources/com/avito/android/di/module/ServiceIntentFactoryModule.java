package com.avito.android.di.module;

import com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceIntentFactoryModule;
import com.avito.android.messenger.di.module.MessengerServiceIntentFactoryModule;
import com.avito.android.user_advert.advert.service.di.UserAdvertServiceIntentFactoryModule;
import dagger.Module;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/di/module/ServiceIntentFactoryModule;", "", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {MessengerServiceIntentFactoryModule.class, NotificationServiceIntentFactoryModule.class, FavoriteSellerServiceIntentFactoryModule.class, UserAdvertServiceIntentFactoryModule.class})
public interface ServiceIntentFactoryModule {
}
