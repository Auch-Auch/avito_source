package com.avito.android.abuse.category.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.abuse.category.AbuseCategoryInteractor;
import com.avito.android.abuse.category.AbuseCategoryInteractorImpl;
import com.avito.android.abuse.category.AbuseCategoryPresenter;
import com.avito.android.abuse.category.AbuseCategoryPresenterImpl;
import com.avito.android.abuse.category.item.AbuseCategoryItemBlueprint;
import com.avito.android.abuse.category.item.AbuseCategoryItemClickListener;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenter;
import com.avito.android.abuse.category.item.AbuseCategoryItemPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/abuse/category/di/AbuseCategoryModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/ErrorFormatter;", "provideErrorFormatter$abuse_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/ErrorFormatter;", "provideErrorFormatter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "<init>", "()V", "Declarations", "abuse_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AdapterModule.class})
public final class AbuseCategoryModule {
    @NotNull
    public static final AbuseCategoryModule INSTANCE = new AbuseCategoryModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/abuse/category/di/AbuseCategoryModule$Declarations;", "", "Lcom/avito/android/abuse/category/AbuseCategoryInteractorImpl;", "interactor", "Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "bindInteractor", "(Lcom/avito/android/abuse/category/AbuseCategoryInteractorImpl;)Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "Lcom/avito/android/abuse/category/AbuseCategoryPresenterImpl;", "presenter", "Lcom/avito/android/abuse/category/AbuseCategoryPresenter;", "bindPresenter", "(Lcom/avito/android/abuse/category/AbuseCategoryPresenterImpl;)Lcom/avito/android/abuse/category/AbuseCategoryPresenter;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemClickListener;", "bindListener", "(Lcom/avito/android/abuse/category/AbuseCategoryPresenter;)Lcom/avito/android/abuse/category/item/AbuseCategoryItemClickListener;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindItemBlueprint", "(Lcom/avito/android/abuse/category/item/AbuseCategoryItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemPresenterImpl;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemPresenter;", "bindItemPresenter", "(Lcom/avito/android/abuse/category/item/AbuseCategoryItemPresenterImpl;)Lcom/avito/android/abuse/category/item/AbuseCategoryItemPresenter;", "abuse_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AbuseCategoryInteractor bindInteractor(@NotNull AbuseCategoryInteractorImpl abuseCategoryInteractorImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerActivity
        ItemBlueprint<?, ?> bindItemBlueprint(@NotNull AbuseCategoryItemBlueprint abuseCategoryItemBlueprint);

        @PerActivity
        @Binds
        @NotNull
        AbuseCategoryItemPresenter bindItemPresenter(@NotNull AbuseCategoryItemPresenterImpl abuseCategoryItemPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        AbuseCategoryItemClickListener bindListener(@NotNull AbuseCategoryPresenter abuseCategoryPresenter);

        @PerActivity
        @Binds
        @NotNull
        AbuseCategoryPresenter bindPresenter(@NotNull AbuseCategoryPresenterImpl abuseCategoryPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ErrorFormatter provideErrorFormatter$abuse_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }
}
