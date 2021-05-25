package com.avito.android.inline_filters.di;

import com.avito.android.di.PerFragment;
import com.avito.android.di.module.InlineFiltersInteractorModule;
import com.avito.android.inline_filters.InlineFiltersPresenter;
import com.avito.android.inline_filters.InlineFiltersPresenterImpl;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactory;
import com.avito.android.inline_filters.dialog.InlineFilterDialogFactoryImpl;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverter;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverterImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/inline_filters/di/InlineFiltersModule;", "", "Lcom/avito/android/inline_filters/InlineFiltersPresenterImpl;", "inlineFiltersPresenter", "Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "bindInlineFiltersPresenter", "(Lcom/avito/android/inline_filters/InlineFiltersPresenterImpl;)Lcom/avito/android/inline_filters/InlineFiltersPresenter;", "Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverterImpl;", "dialogItemConverter", "Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;", "bindDialogItemConverter", "(Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverterImpl;)Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactoryImpl;", "factoryImpl", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "bindInlineDialogFactory", "(Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactoryImpl;)Lcom/avito/android/inline_filters/dialog/InlineFilterDialogFactory;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {InlineFiltersInteractorModule.class})
public interface InlineFiltersModule {
    @PerFragment
    @Binds
    @NotNull
    InlineFiltersDialogItemConverter bindDialogItemConverter(@NotNull InlineFiltersDialogItemConverterImpl inlineFiltersDialogItemConverterImpl);

    @PerFragment
    @Binds
    @NotNull
    InlineFilterDialogFactory bindInlineDialogFactory(@NotNull InlineFilterDialogFactoryImpl inlineFilterDialogFactoryImpl);

    @PerFragment
    @Binds
    @NotNull
    InlineFiltersPresenter bindInlineFiltersPresenter(@NotNull InlineFiltersPresenterImpl inlineFiltersPresenterImpl);
}
