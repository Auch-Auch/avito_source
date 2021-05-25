package com.avito.android.messenger.blacklist.mvi.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.date_time_formatter.BlacklistDateFormatter;
import com.avito.android.di.PerFragment;
import com.avito.android.messenger.blacklist.mvi.BlacklistInteractor;
import com.avito.android.messenger.blacklist.mvi.BlacklistInteractorImpl;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenter;
import com.avito.android.messenger.blacklist.mvi.BlacklistPresenterImpl;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserBlueprint;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.BlockedUserPresenter;
import com.avito.android.messenger.blacklist.mvi.adapter.blocked_user.UnblockClickListener;
import com.avito.android.messenger.blacklist.mvi.adapter.pagination_in_progress.PaginationInProgressBlueprint;
import com.avito.android.messenger.blacklist.mvi.adapter.pagination_in_progress.PaginationInProgressPresenterImpl;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u000267B\t\b\u0002¢\u0006\u0004\b4\u00105J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010%\u001a\u00020\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0 H\u0001¢\u0006\u0004\b#\u0010$J\u0017\u0010)\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\"H\u0001¢\u0006\u0004\b'\u0010(J\u0017\u0010.\u001a\u00020+2\u0006\u0010*\u001a\u00020&H\u0001¢\u0006\u0004\b,\u0010-J\u0019\u00103\u001a\u0002002\b\b\u0001\u0010/\u001a\u00020+H\u0001¢\u0006\u0004\b1\u00102¨\u00068"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/di/BlacklistFragmentModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;", "provideBlacklistInteractor$messenger_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractor;", "provideBlacklistInteractor", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Landroid/content/res/Resources;", "resources", "Ljava/util/Locale;", "locale", "Lcom/avito/android/date_time_formatter/BlacklistDateFormatter;", "provideBlacklistDateFormatter", "(Lcom/avito/android/server_time/TimeSource;Landroid/content/res/Resources;Ljava/util/Locale;)Lcom/avito/android/date_time_formatter/BlacklistDateFormatter;", "Lcom/avito/android/util/Formatter;", "", "provideErrorFormatter", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;", "provideBlacklistPresenter$messenger_release", "(Landroidx/fragment/app/Fragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;", "provideBlacklistPresenter", "presenter", "Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/UnblockClickListener;", "provideUnblockClickListener$messenger_release", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenter;)Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/UnblockClickListener;", "provideUnblockClickListener", "Ldagger/Lazy;", "unblockClickListener", "Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserPresenter;", "provideBlockedUserPresenter$messenger_release", "(Ldagger/Lazy;)Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserPresenter;", "provideBlockedUserPresenter", "Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserBlueprint;", "provideBlockedUserBlueprint$messenger_release", "(Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserPresenter;)Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserBlueprint;", "provideBlockedUserBlueprint", "blockedUserBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideListItemBinder$messenger_release", "(Lcom/avito/android/messenger/blacklist/mvi/adapter/blocked_user/BlockedUserBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideListItemBinder", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$messenger_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "<init>", "()V", "Blacklist", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class BlacklistFragmentModule {
    @NotNull
    public static final BlacklistFragmentModule INSTANCE = new BlacklistFragmentModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/di/BlacklistFragmentModule$Blacklist;", "", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface Blacklist {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/blacklist/mvi/di/BlacklistFragmentModule$Declarations;", "", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindBlacklistInteractorViewModel", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenterImpl;", "bindBlacklistPresenterViewModel", "(Lcom/avito/android/messenger/blacklist/mvi/BlacklistPresenterImpl;)Landroidx/lifecycle/ViewModel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @ClassKey(BlacklistInteractorImpl.class)
        @PerFragment
        @IntoMap
        ViewModel bindBlacklistInteractorViewModel(@NotNull BlacklistInteractorImpl blacklistInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(BlacklistPresenterImpl.class)
        @PerFragment
        @IntoMap
        ViewModel bindBlacklistPresenterViewModel(@NotNull BlacklistPresenterImpl blacklistPresenterImpl);
    }

    @Provides
    @Blacklist
    @NotNull
    @PerFragment
    public final AdapterPresenter provideAdapterPresenter$messenger_release(@Blacklist @NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final BlacklistDateFormatter provideBlacklistDateFormatter(@NotNull TimeSource timeSource, @NotNull Resources resources, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new BlacklistDateFormatter(timeSource, resources, locale);
    }

    @Provides
    @PerFragment
    @NotNull
    public final BlacklistInteractor provideBlacklistInteractor$messenger_release(@NotNull Fragment fragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(BlacklistInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (BlacklistInteractor) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final BlacklistPresenter provideBlacklistPresenter$messenger_release(@NotNull Fragment fragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(fragment, viewModelFactory).get(BlacklistPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (BlacklistPresenter) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final BlockedUserBlueprint provideBlockedUserBlueprint$messenger_release(@NotNull BlockedUserPresenter blockedUserPresenter) {
        Intrinsics.checkNotNullParameter(blockedUserPresenter, "presenter");
        return new BlockedUserBlueprint(blockedUserPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final BlockedUserPresenter provideBlockedUserPresenter$messenger_release(@NotNull Lazy<UnblockClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "unblockClickListener");
        return new BlockedUserPresenter(lazy);
    }

    @Provides
    @NotNull
    @PerFragment
    public final Formatter<Throwable> provideErrorFormatter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @Blacklist
    @NotNull
    @PerFragment
    public final ItemBinder provideListItemBinder$messenger_release(@NotNull BlockedUserBlueprint blockedUserBlueprint) {
        Intrinsics.checkNotNullParameter(blockedUserBlueprint, "blockedUserBlueprint");
        return new ItemBinder.Builder().registerItem(blockedUserBlueprint).registerItem(new PaginationInProgressBlueprint(new PaginationInProgressPresenterImpl())).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final UnblockClickListener provideUnblockClickListener$messenger_release(@NotNull BlacklistPresenter blacklistPresenter) {
        Intrinsics.checkNotNullParameter(blacklistPresenter, "presenter");
        return blacklistPresenter;
    }
}
