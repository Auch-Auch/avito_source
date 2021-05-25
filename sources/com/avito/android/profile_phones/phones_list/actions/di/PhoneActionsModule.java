package com.avito.android.profile_phones.phones_list.actions.di;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionItemsConverter;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionItemsConverterImpl;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemBlueprint;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemPresenter;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemPresenterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsModule;", "", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemBlueprint;", "blueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$profile_phones_release", "(Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;", "presenter", "provideActionItemBlueprint$profile_phones_release", "(Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;)Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemBlueprint;", "provideActionItemBlueprint", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$profile_phones_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "provideAdapter$profile_phones_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "<init>", "()V", "Dependencies", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class PhoneActionsModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/di/PhoneActionsModule$Dependencies;", "", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverterImpl;", "converter", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverter;", "bindConverter", "(Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverterImpl;)Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverter;", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenterImpl;", "impl", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;", "bindActionItemPresenter", "(Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenterImpl;)Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        ActionItemPresenter bindActionItemPresenter(@NotNull ActionItemPresenterImpl actionItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PhoneActionItemsConverter bindConverter(@NotNull PhoneActionItemsConverterImpl phoneActionItemsConverterImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ActionItemBlueprint provideActionItemBlueprint$profile_phones_release(@NotNull ActionItemPresenter actionItemPresenter) {
        Intrinsics.checkNotNullParameter(actionItemPresenter, "presenter");
        return new ActionItemBlueprint(actionItemPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final RecyclerView.Adapter<BaseViewHolder> provideAdapter$profile_phones_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$profile_phones_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$profile_phones_release(@NotNull ActionItemBlueprint actionItemBlueprint) {
        Intrinsics.checkNotNullParameter(actionItemBlueprint, "blueprint");
        return new ItemBinder.Builder().registerItem(actionItemBlueprint).build();
    }
}
