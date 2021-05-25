package com.avito.android.profile_phones.phones_list.actions;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemPresenter;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PhoneActionsSheetDialogFragment_MembersInjector implements MembersInjector<PhoneActionsSheetDialogFragment> {
    public final Provider<AdapterPresenter> a;
    public final Provider<RecyclerView.Adapter<BaseViewHolder>> b;
    public final Provider<ActionItemPresenter> c;
    public final Provider<PhoneActionItemsConverter> d;
    public final Provider<SchedulersFactory3> e;

    public PhoneActionsSheetDialogFragment_MembersInjector(Provider<AdapterPresenter> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<ActionItemPresenter> provider3, Provider<PhoneActionItemsConverter> provider4, Provider<SchedulersFactory3> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MembersInjector<PhoneActionsSheetDialogFragment> create(Provider<AdapterPresenter> provider, Provider<RecyclerView.Adapter<BaseViewHolder>> provider2, Provider<ActionItemPresenter> provider3, Provider<PhoneActionItemsConverter> provider4, Provider<SchedulersFactory3> provider5) {
        return new PhoneActionsSheetDialogFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment.adapter")
    public static void injectAdapter(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment, RecyclerView.Adapter<BaseViewHolder> adapter) {
        phoneActionsSheetDialogFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment.adapterPresenter")
    public static void injectAdapterPresenter(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment, AdapterPresenter adapterPresenter) {
        phoneActionsSheetDialogFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment.converter")
    public static void injectConverter(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment, PhoneActionItemsConverter phoneActionItemsConverter) {
        phoneActionsSheetDialogFragment.converter = phoneActionItemsConverter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment.itemPresenter")
    public static void injectItemPresenter(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment, ActionItemPresenter actionItemPresenter) {
        phoneActionsSheetDialogFragment.itemPresenter = actionItemPresenter;
    }

    @InjectedFieldSignature("com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment.schedulers")
    public static void injectSchedulers(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment, SchedulersFactory3 schedulersFactory3) {
        phoneActionsSheetDialogFragment.schedulers = schedulersFactory3;
    }

    public void injectMembers(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment) {
        injectAdapterPresenter(phoneActionsSheetDialogFragment, this.a.get());
        injectAdapter(phoneActionsSheetDialogFragment, this.b.get());
        injectItemPresenter(phoneActionsSheetDialogFragment, this.c.get());
        injectConverter(phoneActionsSheetDialogFragment, this.d.get());
        injectSchedulers(phoneActionsSheetDialogFragment, this.e.get());
    }
}
