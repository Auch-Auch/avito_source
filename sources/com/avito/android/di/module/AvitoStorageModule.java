package com.avito.android.di.module;

import com.avito.android.advert.di.PersistenceAdvertDeliveryModule;
import com.avito.android.location.di.module.PersistenceUserLocationModule;
import com.avito.android.publish.di.PublishDraftOnboardingSessionStorageModule;
import com.avito.android.user_adverts.di.SoaPopupSessionStorageModule;
import dagger.Module;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/AvitoStorageModule;", "", "<init>", "()V", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PersistenceCoreModule.class, PersistedSerpModule.class, PersistenceAbTestsModule.class, PersistenceAccountStorageModule.class, PersistenceAdvertDeliveryModule.class, PersistenceFingerprintModule.class, PersistenceNotificationModule.class, PersistenceProfileInfoModule.class, PersistenceSearchModule.class, PersistenceSessionModule.class, PersistenceUserLocationModule.class, PublishDraftOnboardingSessionStorageModule.class, SoaPopupSessionStorageModule.class})
public class AvitoStorageModule {
}
