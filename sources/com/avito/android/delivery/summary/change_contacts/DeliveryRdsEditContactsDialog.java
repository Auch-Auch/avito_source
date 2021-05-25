package com.avito.android.delivery.summary.change_contacts;

import a2.a.a.k0.e.h0.b;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.delivery.R;
import com.avito.android.delivery.di.component.DaggerDeliveryRdsEditContactsComponent;
import com.avito.android.delivery.di.component.DeliverySummaryDependencies;
import com.avito.android.delivery.summary.EditContactsListener;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.ViewSizeKt;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onActivityCreated", "(Landroid/os/Bundle;)V", "Lcom/avito/android/delivery/summary/EditContactsListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/delivery/summary/EditContactsListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModel;", "viewModel", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModel;", "getViewModel$delivery_release", "()Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModel;", "setViewModel$delivery_release", "(Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModel;)V", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "contactsGroup", "<init>", "()V", "Companion", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsEditContactsDialog extends DialogFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public EditContactsListener a;
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    public DeliverySummaryRds.ContactsGroup b;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public DeliveryRdsEditContactsViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsDialog$Companion;", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "contactsGroup", "Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsDialog;", "createInstance", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;)Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsDialog;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final DeliveryRdsEditContactsDialog createInstance(@NotNull DeliverySummaryRds.ContactsGroup contactsGroup) {
            Intrinsics.checkNotNullParameter(contactsGroup, "contactsGroup");
            DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog = new DeliveryRdsEditContactsDialog();
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("ARG_CONTACTS_GROUP", contactsGroup);
            deliveryRdsEditContactsDialog.setArguments(bundle);
            return deliveryRdsEditContactsDialog;
        }

        public Companion(j jVar) {
        }
    }

    public static final void access$onViewInflate(DeliveryRdsEditContactsDialog deliveryRdsEditContactsDialog, View view) {
        DeliveryRdsEditContactsViewModel deliveryRdsEditContactsViewModel = deliveryRdsEditContactsDialog.viewModel;
        if (deliveryRdsEditContactsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = deliveryRdsEditContactsDialog.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        deliveryRdsEditContactsViewModel.setAdapterPresenter(dataAwareAdapterPresenter);
        View findViewById = view.findViewById(R.id.contacts_list);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.addItemDecoration(new PaddingListDecoration(0, ViewSizeKt.getDp(22), 0, 0, 12, null));
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        SimpleRecyclerAdapter simpleRecyclerAdapter = deliveryRdsEditContactsDialog.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        recyclerView.setAdapter(simpleRecyclerAdapter);
    }

    @NotNull
    public final DataAwareAdapterPresenter getAdapterPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final DeliveryRdsEditContactsViewModel getViewModel$delivery_release() {
        DeliveryRdsEditContactsViewModel deliveryRdsEditContactsViewModel = this.viewModel;
        if (deliveryRdsEditContactsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryRdsEditContactsViewModel;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        DeliveryRdsEditContactsViewModel deliveryRdsEditContactsViewModel = this.viewModel;
        if (deliveryRdsEditContactsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryRdsEditContactsViewModel.getSaveChanges().observe(requireActivity(), new a2.a.a.k0.e.h0.a(this));
        deliveryRdsEditContactsViewModel.getSnackBarErrorChanges().observe(requireActivity(), new b(this));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        DeliverySummaryRds.ContactsGroup contactsGroup;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof EditContactsListener)) {
            parentFragment = null;
        }
        EditContactsListener editContactsListener = (EditContactsListener) parentFragment;
        if (editContactsListener != null) {
            this.a = editContactsListener;
            Bundle arguments = getArguments();
            if (arguments == null || (contactsGroup = (DeliverySummaryRds.ContactsGroup) arguments.getParcelable("ARG_CONTACTS_GROUP")) == null) {
                throw new IllegalStateException("Argument ARG_CONTACTS_GROUP must be set");
            }
            this.b = contactsGroup;
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            DaggerDeliveryRdsEditContactsComponent.factory().create((DeliverySummaryDependencies) ComponentDependenciesKt.getDependencies(DeliverySummaryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)), resources, this).inject(this);
            DeliveryRdsEditContactsViewModel deliveryRdsEditContactsViewModel = this.viewModel;
            if (deliveryRdsEditContactsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            DeliverySummaryRds.ContactsGroup contactsGroup2 = this.b;
            if (contactsGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactsGroup");
            }
            deliveryRdsEditContactsViewModel.loadFields(contactsGroup2);
            return;
        }
        throw new IllegalStateException("ParentFragment must implement EditContactsListener");
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, R.style.EditContactsDialog);
        bottomSheetDialog.setContentView(R.layout.delivery_rds_dialog_edit_contacts, new Function1<View, Unit>(this) { // from class: com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsDialog.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                DeliveryRdsEditContactsDialog.access$onViewInflate((DeliveryRdsEditContactsDialog) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        DeliverySummaryRds.ContactsGroup contactsGroup = this.b;
        if (contactsGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsGroup");
        }
        RightCrossHeaderKt.setRightCrossHeader(bottomSheetDialog, contactsGroup.getTitle(), true, true);
        bottomSheetDialog.setSkipCollapsed(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setFitContentPeekHeight(true);
        return bottomSheetDialog;
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    public final void setViewModel$delivery_release(@NotNull DeliveryRdsEditContactsViewModel deliveryRdsEditContactsViewModel) {
        Intrinsics.checkNotNullParameter(deliveryRdsEditContactsViewModel, "<set-?>");
        this.viewModel = deliveryRdsEditContactsViewModel;
    }
}
