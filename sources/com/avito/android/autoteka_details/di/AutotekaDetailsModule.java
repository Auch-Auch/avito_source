package com.avito.android.autoteka_details.di;

import com.avito.android.autoteka_details.AutotekaDetailsConverter;
import com.avito.android.autoteka_details.AutotekaDetailsConverterImpl;
import com.avito.android.autoteka_details.AutotekaDetailsPresenter;
import com.avito.android.autoteka_details.AutotekaDetailsPresenterImpl;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.text.AttributedTextFormatterModule;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/autoteka_details/di/AutotekaDetailsModule;", "", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractorImpl;", "presenter", "Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "bindAutotekaDetailsInteractor", "(Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractorImpl;)Lcom/avito/android/autoteka_details/core/AutotekaDetailsInteractor;", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenterImpl;", "Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;", "bindAutotekaDetailsPresenter", "(Lcom/avito/android/autoteka_details/AutotekaDetailsPresenterImpl;)Lcom/avito/android/autoteka_details/AutotekaDetailsPresenter;", "Lcom/avito/android/autoteka_details/AutotekaDetailsConverterImpl;", "converter", "Lcom/avito/android/autoteka_details/AutotekaDetailsConverter;", "bindAutotekaDetailsConverter", "(Lcom/avito/android/autoteka_details/AutotekaDetailsConverterImpl;)Lcom/avito/android/autoteka_details/AutotekaDetailsConverter;", "autoteka-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AttributedTextFormatterModule.class})
public interface AutotekaDetailsModule {
    @PerFragment
    @Binds
    @NotNull
    AutotekaDetailsConverter bindAutotekaDetailsConverter(@NotNull AutotekaDetailsConverterImpl autotekaDetailsConverterImpl);

    @PerFragment
    @Binds
    @NotNull
    AutotekaDetailsInteractor bindAutotekaDetailsInteractor(@NotNull AutotekaDetailsInteractorImpl autotekaDetailsInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    AutotekaDetailsPresenter bindAutotekaDetailsPresenter(@NotNull AutotekaDetailsPresenterImpl autotekaDetailsPresenterImpl);
}
