package com.avito.android.cart_fab;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.util.SearchContextWrapper;
import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/cart_fab/CartFabModule;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "Lcom/avito/android/cart_fab/CartFabViewModelFactory;", "factory", "Lcom/avito/android/cart_fab/CartFabViewModel;", "provideCartFabViewModel", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/avito/android/cart_fab/CartFabViewModelFactory;)Lcom/avito/android/cart_fab/CartFabViewModel;", "<init>", "()V", "Declarations", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class CartFabModule {
    @NotNull
    public static final CartFabModule INSTANCE = new CartFabModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/cart_fab/CartFabModule$Declarations;", "", "Lcom/avito/android/util/SearchContextWrapper;", "bindSearchContextWrapper", "()Lcom/avito/android/util/SearchContextWrapper;", "Lcom/avito/android/cart_fab/CartFabQuantityVisibilityHandler;", "handler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "bindCartQuantityChangesHandler", "(Lcom/avito/android/cart_fab/CartFabQuantityVisibilityHandler;)Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "Lcom/avito/android/cart_fab/CartFabPreferencesImpl;", "prefs", "Lcom/avito/android/cart_fab/CartFabPreferences;", "bindCartFabPreferences", "(Lcom/avito/android/cart_fab/CartFabPreferencesImpl;)Lcom/avito/android/cart_fab/CartFabPreferences;", "Lcom/avito/android/cart_fab/CartFabRepositoryImpl;", "repo", "Lcom/avito/android/cart_fab/CartFabRepository;", "bindCartFabRepository", "(Lcom/avito/android/cart_fab/CartFabRepositoryImpl;)Lcom/avito/android/cart_fab/CartFabRepository;", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        CartFabPreferences bindCartFabPreferences(@NotNull CartFabPreferencesImpl cartFabPreferencesImpl);

        @Reusable
        @Binds
        @NotNull
        CartFabRepository bindCartFabRepository(@NotNull CartFabRepositoryImpl cartFabRepositoryImpl);

        @Reusable
        @Binds
        @NotNull
        CartQuantityChangesHandler bindCartQuantityChangesHandler(@NotNull CartFabQuantityVisibilityHandler cartFabQuantityVisibilityHandler);

        @BindsOptionalOf
        @NotNull
        SearchContextWrapper bindSearchContextWrapper();
    }

    @Provides
    @Reusable
    @NotNull
    public final CartFabViewModel provideCartFabViewModel(@NotNull ViewModelStoreOwner viewModelStoreOwner, @NotNull CartFabViewModelFactory cartFabViewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(cartFabViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, cartFabViewModelFactory).get(CartFabViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewMo…FabViewModel::class.java)");
        return (CartFabViewModel) viewModel;
    }
}
