package com.avito.android.di.module;

import com.avito.android.serp.adapter.header.HeaderBlueprint;
import com.avito.android.serp.adapter.header.HeaderItem;
import com.avito.android.serp.adapter.header.HeaderPresenter;
import com.avito.android.serp.adapter.header.HeaderPresenterImpl;
import com.avito.android.serp.adapter.header.HeaderView;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/module/HeaderModule;", "", "Lcom/avito/android/serp/adapter/header/HeaderBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/header/HeaderView;", "Lcom/avito/android/serp/adapter/header/HeaderItem;", "bindHeaderBlueprint", "(Lcom/avito/android/serp/adapter/header/HeaderBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/serp/adapter/header/HeaderPresenterImpl;", "presenter", "Lcom/avito/android/serp/adapter/header/HeaderPresenter;", "bindHeaderPresenter", "(Lcom/avito/android/serp/adapter/header/HeaderPresenterImpl;)Lcom/avito/android/serp/adapter/header/HeaderPresenter;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface HeaderModule {
    @Reusable
    @Binds
    @NotNull
    ItemBlueprint<HeaderView, HeaderItem> bindHeaderBlueprint(@NotNull HeaderBlueprint headerBlueprint);

    @Reusable
    @Binds
    @NotNull
    HeaderPresenter bindHeaderPresenter(@NotNull HeaderPresenterImpl headerPresenterImpl);
}
