package com.avito.android.di.component;

import com.avito.android.AvitoApp;
import com.avito.android.di.PerApplication;
import com.avito.android.di.module.ApplicationDelegateModule;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Subcomponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@PerApplication
@Subcomponent(modules = {ApplicationDelegateModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/component/ApplicationDelegateComponent;", "", "Lcom/avito/android/AvitoApp;", MimeTypes.BASE_TYPE_APPLICATION, "", "inject", "(Lcom/avito/android/AvitoApp;)V", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
public interface ApplicationDelegateComponent {
    void inject(@NotNull AvitoApp avitoApp);
}
