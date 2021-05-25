package com.avito.android.di.module;

import com.avito.android.di.PerFragment;
import com.avito.android.serp.InlineFiltersChangesParamsConverter;
import com.avito.android.serp.InlineFiltersChangesParamsConverterImpl;
import com.avito.android.serp.InlineFiltersInteractor;
import com.avito.android.serp.InlineFiltersInteractorImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/module/InlineFiltersInteractorModule;", "", "Lcom/avito/android/serp/InlineFiltersInteractorImpl;", "inlineFiltersInteractor", "Lcom/avito/android/serp/InlineFiltersInteractor;", "bindInlineFiltersInteractor", "(Lcom/avito/android/serp/InlineFiltersInteractorImpl;)Lcom/avito/android/serp/InlineFiltersInteractor;", "Lcom/avito/android/serp/InlineFiltersChangesParamsConverterImpl;", "changesParamsConverter", "Lcom/avito/android/serp/InlineFiltersChangesParamsConverter;", "bindChangesParamsConverter", "(Lcom/avito/android/serp/InlineFiltersChangesParamsConverterImpl;)Lcom/avito/android/serp/InlineFiltersChangesParamsConverter;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface InlineFiltersInteractorModule {
    @PerFragment
    @Binds
    @NotNull
    InlineFiltersChangesParamsConverter bindChangesParamsConverter(@NotNull InlineFiltersChangesParamsConverterImpl inlineFiltersChangesParamsConverterImpl);

    @PerFragment
    @Binds
    @NotNull
    InlineFiltersInteractor bindInlineFiltersInteractor(@NotNull InlineFiltersInteractorImpl inlineFiltersInteractorImpl);
}
