package com.avito.android.profile_phones.phones_list.actions;

import a2.a.a.c2.f.l.a;
import a2.a.a.c2.f.l.b;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.phones_list.actions.di.DaggerPhoneActionsComponent;
import com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsDependencies;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItem;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroyView", "()V", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverter;", "converter", "Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverter;", "getConverter", "()Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverter;", "setConverter", "(Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionItemsConverter;)V", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lio/reactivex/rxjava3/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;", "itemPresenter", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;", "getItemPresenter", "()Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;", "setItemPresenter", "(Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneActionsSheetDialogFragment extends DialogFragment {
    public RecyclerView a;
    @Inject
    public RecyclerView.Adapter<BaseViewHolder> adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    public Disposable b;
    @Inject
    public PhoneActionItemsConverter converter;
    @Inject
    public ActionItemPresenter itemPresenter;
    @Inject
    public SchedulersFactory3 schedulers;

    @NotNull
    public final RecyclerView.Adapter<BaseViewHolder> getAdapter() {
        RecyclerView.Adapter<BaseViewHolder> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final PhoneActionItemsConverter getConverter() {
        PhoneActionItemsConverter phoneActionItemsConverter = this.converter;
        if (phoneActionItemsConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("converter");
        }
        return phoneActionItemsConverter;
    }

    @NotNull
    public final ActionItemPresenter getItemPresenter() {
        ActionItemPresenter actionItemPresenter = this.itemPresenter;
        if (actionItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenter");
        }
        return actionItemPresenter;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerPhoneActionsComponent.builder().phonesListDependencies((PhoneActionsDependencies) ComponentDependenciesKt.getDependencies(PhoneActionsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        Parcelable parcelable = requireArguments.getParcelable("arguments");
        Intrinsics.checkNotNull(parcelable);
        Intrinsics.checkNotNullExpressionValue(parcelable, "arguments.getParcelable<…guments>(KEY_ARGUMENTS)!!");
        PhoneActionsSheetDialogArguments phoneActionsSheetDialogArguments = (PhoneActionsSheetDialogArguments) parcelable;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, 0, 2, null);
        bottomSheetDialog.setContentView(R.layout.phone_actions_sheet, -1);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, true, 3, null);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        Context context = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        View findViewById = bottomSheetDialog.findViewById(R.id.actions_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.a = (RecyclerView) findViewById;
        PhoneActionItemsConverter phoneActionItemsConverter = this.converter;
        if (phoneActionItemsConverter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("converter");
        }
        List<ActionItem> convert = phoneActionItemsConverter.convert(phoneActionsSheetDialogArguments.getPhone(), phoneActionsSheetDialogArguments.getActions());
        ActionItemPresenter actionItemPresenter = this.itemPresenter;
        if (actionItemPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPresenter");
        }
        this.b = actionItemPresenter.getItemSelectedObservable().subscribe(new a(this), b.a);
        RecyclerView recyclerView = this.a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        RecyclerView.Adapter<BaseViewHolder> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(adapter2);
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        RecyclerView recyclerView3 = this.a;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycler");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        a2.b.a.a.a.s1(convert, adapterPresenter2);
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroyView();
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<BaseViewHolder> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setConverter(@NotNull PhoneActionItemsConverter phoneActionItemsConverter) {
        Intrinsics.checkNotNullParameter(phoneActionItemsConverter, "<set-?>");
        this.converter = phoneActionItemsConverter;
    }

    public final void setItemPresenter(@NotNull ActionItemPresenter actionItemPresenter) {
        Intrinsics.checkNotNullParameter(actionItemPresenter, "<set-?>");
        this.itemPresenter = actionItemPresenter;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }
}
