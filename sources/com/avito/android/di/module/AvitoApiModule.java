package com.avito.android.di.module;

import com.avito.android.di.SessionRefresherModule;
import dagger.Module;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/di/module/AvitoApiModule;", "", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ApiModule.class, CertificatePinningModule.class, SessionRefresherModule.class, FirewallErrorModule.class, AvitoDistributedApiModule.class})
public interface AvitoApiModule {
}
