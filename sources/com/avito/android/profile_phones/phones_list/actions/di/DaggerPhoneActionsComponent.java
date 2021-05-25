package com.avito.android.profile_phones.phones_list.actions.di;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionItemsConverter;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionItemsConverterImpl_Factory;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment_MembersInjector;
import com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsComponent;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemBlueprint;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemPresenter;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemPresenterImpl_Factory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPhoneActionsComponent implements PhoneActionsComponent {
    public final PhoneActionsDependencies a;
    public Provider<ActionItemPresenter> b;
    public Provider<ActionItemBlueprint> c;
    public Provider<ItemBinder> d;
    public Provider<AdapterPresenter> e;
    public Provider<RecyclerView.Adapter<BaseViewHolder>> f;
    public Provider<PhoneActionItemsConverter> g = DoubleCheck.provider(PhoneActionItemsConverterImpl_Factory.create());

    public static final class b implements PhoneActionsComponent.Builder {
        public PhoneActionsDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsComponent.Builder
        public PhoneActionsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PhoneActionsDependencies.class);
            return new DaggerPhoneActionsComponent(new PhoneActionsModule(), this.a, null);
        }

        @Override // com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsComponent.Builder
        public PhoneActionsComponent.Builder phonesListDependencies(PhoneActionsDependencies phoneActionsDependencies) {
            this.a = (PhoneActionsDependencies) Preconditions.checkNotNull(phoneActionsDependencies);
            return this;
        }
    }

    public DaggerPhoneActionsComponent(PhoneActionsModule phoneActionsModule, PhoneActionsDependencies phoneActionsDependencies, a aVar) {
        this.a = phoneActionsDependencies;
        Provider<ActionItemPresenter> provider = DoubleCheck.provider(ActionItemPresenterImpl_Factory.create());
        this.b = provider;
        Provider<ActionItemBlueprint> provider2 = DoubleCheck.provider(PhoneActionsModule_ProvideActionItemBlueprint$profile_phones_releaseFactory.create(phoneActionsModule, provider));
        this.c = provider2;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(PhoneActionsModule_ProvideItemBinder$profile_phones_releaseFactory.create(phoneActionsModule, provider2));
        this.d = provider3;
        Provider<AdapterPresenter> provider4 = DoubleCheck.provider(PhoneActionsModule_ProvideAdapterPresenter$profile_phones_releaseFactory.create(phoneActionsModule, provider3));
        this.e = provider4;
        this.f = DoubleCheck.provider(PhoneActionsModule_ProvideAdapter$profile_phones_releaseFactory.create(phoneActionsModule, provider4, this.d));
    }

    public static PhoneActionsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsComponent
    public void inject(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment) {
        PhoneActionsSheetDialogFragment_MembersInjector.injectAdapterPresenter(phoneActionsSheetDialogFragment, this.e.get());
        PhoneActionsSheetDialogFragment_MembersInjector.injectAdapter(phoneActionsSheetDialogFragment, this.f.get());
        PhoneActionsSheetDialogFragment_MembersInjector.injectItemPresenter(phoneActionsSheetDialogFragment, this.b.get());
        PhoneActionsSheetDialogFragment_MembersInjector.injectConverter(phoneActionsSheetDialogFragment, this.g.get());
        PhoneActionsSheetDialogFragment_MembersInjector.injectSchedulers(phoneActionsSheetDialogFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
    }
}
