package com.avito.android.contact_access;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.avito.android.contact_access.di.ContactAccessDependencies;
import com.avito.android.contact_access.di.ContactAccessPackageFragmentComponent;
import com.avito.android.contact_access.di.DaggerContactAccessPackageFragmentComponent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessPackageFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "outState", "onSaveInstanceState", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/avito/android/contact_access/ContactAccessPackageRouter;", "router", "setRouter", "(Lcom/avito/android/contact_access/ContactAccessPackageRouter;)V", "Lcom/avito/android/contact_access/ContactAccessPackageView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/contact_access/ContactAccessPackageView;", "contactPackageView", "Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "presenter", "Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "getPresenter", "()Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "setPresenter", "(Lcom/avito/android/contact_access/ContactAccessPackagePresenter;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/contact_access/ContactAccessPackageRouter;", "<init>", "()V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessPackageFragment extends DialogFragment {
    public ContactAccessPackageRouter a;
    public ContactAccessPackageView b;
    @Inject
    public ContactAccessPackagePresenter presenter;

    @NotNull
    public final ContactAccessPackagePresenter getPresenter() {
        ContactAccessPackagePresenter contactAccessPackagePresenter = this.presenter;
        if (contactAccessPackagePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return contactAccessPackagePresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = requireArguments().getString("key_item_id");
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(KEY_ITEM_ID)!!");
        ContactAccessPackageFragmentComponent.Builder withState = DaggerContactAccessPackageFragmentComponent.builder().dependentOn((ContactAccessDependencies) ComponentDependenciesKt.getDependencies(ContactAccessDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withAdvertId(string).withState(bundle);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withState.withResources(resources).build().inject(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cv_paid_choose_package, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        ContactAccessPackagePresenter contactAccessPackagePresenter = this.presenter;
        if (contactAccessPackagePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        this.b = new ContactAccessPackageViewImpl(viewGroup, contactAccessPackagePresenter);
        ContactAccessPackagePresenter contactAccessPackagePresenter2 = this.presenter;
        if (contactAccessPackagePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ContactAccessPackageView contactAccessPackageView = this.b;
        Intrinsics.checkNotNull(contactAccessPackageView);
        contactAccessPackagePresenter2.subscribe(contactAccessPackageView);
        ContactAccessPackagePresenter contactAccessPackagePresenter3 = this.presenter;
        if (contactAccessPackagePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessPackagePresenter3.attachRouter(this.a);
        AlertDialog create = new AlertDialog.Builder(requireContext()).setView(inflate).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…ew)\n            .create()");
        return create;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        LastClick.Updater.update();
        super.onDismiss(dialogInterface);
        ContactAccessPackagePresenter contactAccessPackagePresenter = this.presenter;
        if (contactAccessPackagePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessPackagePresenter.detachRouter();
        ContactAccessPackagePresenter contactAccessPackagePresenter2 = this.presenter;
        if (contactAccessPackagePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessPackagePresenter2.unsubscribe();
        this.a = null;
        this.b = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ContactAccessPackagePresenter contactAccessPackagePresenter = this.presenter;
        if (contactAccessPackagePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        contactAccessPackagePresenter.onSaveState(bundle);
    }

    public final void setPresenter(@NotNull ContactAccessPackagePresenter contactAccessPackagePresenter) {
        Intrinsics.checkNotNullParameter(contactAccessPackagePresenter, "<set-?>");
        this.presenter = contactAccessPackagePresenter;
    }

    public final void setRouter(@Nullable ContactAccessPackageRouter contactAccessPackageRouter) {
        this.a = contactAccessPackageRouter;
    }
}
