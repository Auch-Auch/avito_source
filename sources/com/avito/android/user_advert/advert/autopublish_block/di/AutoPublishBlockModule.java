package com.avito.android.user_advert.advert.autopublish_block.di;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModel;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModelFactory;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/user_advert/advert/autopublish_block/di/AutoPublishBlockModule;", "", "Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockViewModelFactory;", "factory", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockViewModel;", "provideAdvertDeliveryBlockViewModel", "(Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockViewModelFactory;Landroidx/fragment/app/FragmentActivity;)Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockViewModel;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AutoPublishBlockModule {
    @NotNull
    public static final AutoPublishBlockModule INSTANCE = new AutoPublishBlockModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final AutoPublishBlockViewModel provideAdvertDeliveryBlockViewModel(@NotNull AutoPublishBlockViewModelFactory autoPublishBlockViewModelFactory, @NotNull FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(autoPublishBlockViewModelFactory, "factory");
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        ViewModel viewModel = new ViewModelProvider(fragmentActivity, autoPublishBlockViewModelFactory).get(AutoPublishBlockViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi…ockViewModel::class.java)");
        return (AutoPublishBlockViewModel) viewModel;
    }
}
