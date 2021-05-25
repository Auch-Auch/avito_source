package com.avito.android.profile_phones.phones_list.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.phones_list.PhonesConverter;
import com.avito.android.profile_phones.phones_list.PhonesConverterImpl;
import com.avito.android.profile_phones.phones_list.PhonesListInteractor;
import com.avito.android.profile_phones.phones_list.PhonesListInteractorImpl;
import com.avito.android.profile_phones.phones_list.PhonesListResourceProvider;
import com.avito.android.profile_phones.phones_list.PhonesListViewModelFactory;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemBlueprint;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemPresenter;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItemPresenterImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b0\u00101J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u001b\u001a\f\u0012\u0004\u0012\u00020\u00120\u0017j\u0002`\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010%\u001a\u0006\u0012\u0002\b\u00030\"2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0004H\u0001¢\u0006\u0004\b#\u0010$RD\u0010+\u001a0\u0012\f\u0012\n '*\u0004\u0018\u00010\u00120\u0012 '*\u0017\u0012\f\u0012\n '*\u0004\u0018\u00010\u00120\u0012\u0018\u00010&¢\u0006\u0002\b(0&¢\u0006\u0002\b(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/di/PhonesListModule;", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemBlueprint;", "blueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$profile_phones_release", "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;", "presenter", "providePhonesCardBlueprint$profile_phones_release", "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;)Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemBlueprint;", "providePhonesCardBlueprint", "Lcom/avito/android/profile_phones/phones_list/PhonesListResourceProvider;", "provideUserProfileResourceProvider$profile_phones_release", "()Lcom/avito/android/profile_phones/phones_list/PhonesListResourceProvider;", "provideUserProfileResourceProvider", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemClickConsumer;", "providePhoneListItemClickConsumer$profile_phones_release", "()Lio/reactivex/rxjava3/functions/Consumer;", "providePhoneListItemClickConsumer", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemClickObservable;", "providePhoneListItemClickObservable$profile_phones_release", "()Lio/reactivex/rxjava3/core/Observable;", "providePhoneListItemClickObservable", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$profile_phones_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter$profile_phones_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "phoneItemClickStream", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "Dependencies", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class PhonesListModule {
    public final PublishRelay<PhoneListItem> a = PublishRelay.create();
    public final Resources b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/di/PhonesListModule$Dependencies;", "", "Lcom/avito/android/profile_phones/phones_list/PhonesListViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/profile_phones/phones_list/PhonesListViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/profile_phones/phones_list/PhonesListInteractorImpl;", "interactor", "Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", "bindPhonesListInteractor", "(Lcom/avito/android/profile_phones/phones_list/PhonesListInteractorImpl;)Lcom/avito/android/profile_phones/phones_list/PhonesListInteractor;", "Lcom/avito/android/profile_phones/phones_list/PhonesConverterImpl;", "converter", "Lcom/avito/android/profile_phones/phones_list/PhonesConverter;", "bindPhonesConverter", "(Lcom/avito/android/profile_phones/phones_list/PhonesConverterImpl;)Lcom/avito/android/profile_phones/phones_list/PhonesConverter;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenterImpl;", "impl", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;", "bindPhoneListItemPresenter", "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenterImpl;)Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItemPresenter;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        PhoneListItemPresenter bindPhoneListItemPresenter(@NotNull PhoneListItemPresenterImpl phoneListItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PhonesConverter bindPhonesConverter(@NotNull PhonesConverterImpl phonesConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        PhonesListInteractor bindPhonesListInteractor(@NotNull PhonesListInteractorImpl phonesListInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull PhonesListViewModelFactory phonesListViewModelFactory);
    }

    public PhonesListModule(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = resources;
    }

    @Provides
    @NotNull
    @PerFragment
    public final RecyclerView.Adapter<?> provideAdapter$profile_phones_release(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
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
    public final ItemBinder provideItemBinder$profile_phones_release(@NotNull PhoneListItemBlueprint phoneListItemBlueprint) {
        Intrinsics.checkNotNullParameter(phoneListItemBlueprint, "blueprint");
        return new ItemBinder.Builder().registerItem(phoneListItemBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Consumer<PhoneListItem> providePhoneListItemClickConsumer$profile_phones_release() {
        PublishRelay<PhoneListItem> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "phoneItemClickStream");
        return publishRelay;
    }

    @Provides
    @NotNull
    @PerFragment
    public final Observable<PhoneListItem> providePhoneListItemClickObservable$profile_phones_release() {
        PublishRelay<PhoneListItem> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "phoneItemClickStream");
        return publishRelay;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneListItemBlueprint providePhonesCardBlueprint$profile_phones_release(@NotNull PhoneListItemPresenter phoneListItemPresenter) {
        Intrinsics.checkNotNullParameter(phoneListItemPresenter, "presenter");
        return new PhoneListItemBlueprint(phoneListItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhonesListResourceProvider provideUserProfileResourceProvider$profile_phones_release() {
        return new PhonesListResourceProvider(this.b);
    }
}
