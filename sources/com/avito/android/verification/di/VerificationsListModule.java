package com.avito.android.verification.di;

import a2.b.a.a.a;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.di.PerFragment;
import com.avito.android.verification.verifications_list.VerificationOptionsListConverter;
import com.avito.android.verification.verifications_list.VerificationOptionsListConverterImpl;
import com.avito.android.verification.verifications_list.VerificationsListInteractor;
import com.avito.android.verification.verifications_list.VerificationsListInteractorImpl;
import com.avito.android.verification.verifications_list.VerificationsListViewModel;
import com.avito.android.verification.verifications_list.VerificationsListViewModelFactory;
import com.avito.android.verification.verifications_list.list.VerificationsListBlueprint;
import com.avito.android.verification.verifications_list.list.VerificationsListItemPresenter;
import com.avito.android.verification.verifications_list.list.VerificationsListItemPresenterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001d\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001b¢\u0006\u0002\b\u001c0\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/verification/di/VerificationsListModule;", "", "Lcom/avito/android/verification/verifications_list/list/VerificationsListBlueprint;", "verificationsListBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$verification_release", "(Lcom/avito/android/verification/verifications_list/list/VerificationsListBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter$verification_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideRecyclerAdapter", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModelFactory;", "factory", "Lcom/avito/android/verification/verifications_list/VerificationsListViewModel;", "provideUserStats", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/avito/android/verification/verifications_list/VerificationsListViewModelFactory;)Lcom/avito/android/verification/verifications_list/VerificationsListViewModel;", "Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenter;", "listItemPresenter", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "provideItemPresentersSet", "(Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenter;)Ljava/util/Set;", "<init>", "()V", "Declarations", "verification_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class VerificationsListModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/verification/di/VerificationsListModule$Declarations;", "", "Lcom/avito/android/verification/verifications_list/VerificationsListInteractorImpl;", "impl", "Lcom/avito/android/verification/verifications_list/VerificationsListInteractor;", "bindInteractor", "(Lcom/avito/android/verification/verifications_list/VerificationsListInteractorImpl;)Lcom/avito/android/verification/verifications_list/VerificationsListInteractor;", "Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenterImpl;", "Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenter;", "bindItemPresenter", "(Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenterImpl;)Lcom/avito/android/verification/verifications_list/list/VerificationsListItemPresenter;", "Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverterImpl;", "Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverter;", "bindConverter", "(Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverterImpl;)Lcom/avito/android/verification/verifications_list/VerificationOptionsListConverter;", "verification_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        VerificationOptionsListConverter bindConverter(@NotNull VerificationOptionsListConverterImpl verificationOptionsListConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        VerificationsListInteractor bindInteractor(@NotNull VerificationsListInteractorImpl verificationsListInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        VerificationsListItemPresenter bindItemPresenter(@NotNull VerificationsListItemPresenterImpl verificationsListItemPresenterImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$verification_release(@NotNull VerificationsListBlueprint verificationsListBlueprint) {
        Intrinsics.checkNotNullParameter(verificationsListBlueprint, "verificationsListBlueprint");
        return new ItemBinder.Builder().registerItem(verificationsListBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet(@NotNull VerificationsListItemPresenter verificationsListItemPresenter) {
        Intrinsics.checkNotNullParameter(verificationsListItemPresenter, "listItemPresenter");
        return x.setOf(verificationsListItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter$verification_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final VerificationsListViewModel provideUserStats(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull VerificationsListViewModelFactory verificationsListViewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(verificationsListViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, verificationsListViewModelFactory).get(VerificationsListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…istViewModel::class.java)");
        return (VerificationsListViewModel) viewModel;
    }
}
