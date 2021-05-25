package com.avito.android.photo_wizard;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.Features;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.permissions.FragmentPermissionHelper;
import com.avito.android.photo_wizard.PhotoWizardViewState;
import com.avito.android.photo_wizard.WizardPhotoPickerPresenter;
import com.avito.android.photo_wizard.di.DaggerPhotoWizardComponent;
import com.avito.android.photo_wizard.di.PhotoWizardComponent;
import com.avito.android.photo_wizard.di.WizardImageUploadDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.util.ImplicitIntentFactory;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\b@\u0010\u001cJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001cR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "()V", "onPause", "onDestroyView", "toAppSettings", "Lcom/avito/android/util/ImplicitIntentFactory;", "intentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/photo_wizard/PhotoWizardViewModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/photo_wizard/PhotoWizardViewModel;", "viewModel", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/photo_wizard/PhotoWizardViewModelFactory;", "viewModelFactory", "Lcom/avito/android/photo_wizard/PhotoWizardViewModelFactory;", "getViewModelFactory", "()Lcom/avito/android/photo_wizard/PhotoWizardViewModelFactory;", "setViewModelFactory", "(Lcom/avito/android/photo_wizard/PhotoWizardViewModelFactory;)V", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;", "presenter", "Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;", "getPresenter", "()Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;", "setPresenter", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerPresenter;)V", "<init>", "Companion", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoWizardFragment extends Fragment implements WizardPhotoPickerPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public PhotoWizardViewModel a;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory intentFactory;
    @Inject
    public WizardPhotoPickerPresenter presenter;
    @Inject
    public PhotoWizardViewModelFactory viewModelFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardFragment$Companion;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Ljava/util/ArrayList;", "Lcom/avito/android/remote/model/VerificationStep;", "Lkotlin/collections/ArrayList;", "steps", "Lcom/avito/android/photo_wizard/PhotoWizardFragment;", "createInstance", "(Ljava/lang/String;Ljava/util/ArrayList;)Lcom/avito/android/photo_wizard/PhotoWizardFragment;", "<init>", "()V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final PhotoWizardFragment createInstance(@NotNull String str, @NotNull ArrayList<VerificationStep> arrayList) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(arrayList, "steps");
            Bundle bundle = new Bundle();
            bundle.putString("advert_id", str);
            bundle.putParcelableArrayList(PhotoWizardActivityKt.EXTRA_STEPS_LIST, arrayList);
            PhotoWizardFragment photoWizardFragment = new PhotoWizardFragment();
            photoWizardFragment.setArguments(bundle);
            return photoWizardFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Observer<PhotoWizardViewState> {
        public final /* synthetic */ PhotoWizardFragment a;

        public a(PhotoWizardFragment photoWizardFragment, WizardPhotoPickerViewImpl wizardPhotoPickerViewImpl) {
            this.a = photoWizardFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(PhotoWizardViewState photoWizardViewState) {
            PhotoWizardViewState photoWizardViewState2 = photoWizardViewState;
            PhotoWizardFragment photoWizardFragment = this.a;
            Intrinsics.checkNotNullExpressionValue(photoWizardViewState2, "state");
            PhotoWizardFragment.access$resolveViewState(photoWizardFragment, photoWizardViewState2);
        }
    }

    public static final class b<T> implements Observer<String> {
        public final /* synthetic */ WizardPhotoPickerViewImpl a;

        public b(PhotoWizardFragment photoWizardFragment, WizardPhotoPickerViewImpl wizardPhotoPickerViewImpl) {
            this.a = wizardPhotoPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(String str) {
            this.a.setTitle(str);
        }
    }

    public static final void access$resolveViewState(PhotoWizardFragment photoWizardFragment, PhotoWizardViewState photoWizardViewState) {
        FragmentActivity activity = photoWizardFragment.getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            if (photoWizardViewState instanceof PhotoWizardViewState.ForceClosed) {
                activity.finish();
            } else if (photoWizardViewState instanceof PhotoWizardViewState.ClosedWithResult) {
                activity.setResult(-1);
                activity.finish();
            } else {
                WizardPhotoPickerPresenter wizardPhotoPickerPresenter = photoWizardFragment.presenter;
                if (wizardPhotoPickerPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                wizardPhotoPickerPresenter.resolveViewState(photoWizardViewState);
            }
        }
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return implicitIntentFactory;
    }

    @NotNull
    public final WizardPhotoPickerPresenter getPresenter() {
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter = this.presenter;
        if (wizardPhotoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return wizardPhotoPickerPresenter;
    }

    @NotNull
    public final PhotoWizardViewModelFactory getViewModelFactory() {
        PhotoWizardViewModelFactory photoWizardViewModelFactory = this.viewModelFactory;
        if (photoWizardViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return photoWizardViewModelFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        ArrayList arrayList = null;
        String string = arguments != null ? arguments.getString("advert_id") : null;
        Intrinsics.checkNotNull(string);
        Intrinsics.checkNotNullExpressionValue(string, "arguments?.getString(EXTRA_ADVERT_ID)!!");
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arrayList = arguments2.getParcelableArrayList(PhotoWizardActivityKt.EXTRA_STEPS_LIST);
        }
        Intrinsics.checkNotNull(arrayList);
        Intrinsics.checkNotNullExpressionValue(arrayList, "arguments?.getParcelable…Step>(EXTRA_STEPS_LIST)!!");
        PhotoWizardComponent.Builder withPermissionHelper = DaggerPhotoWizardComponent.builder().dependencies((WizardImageUploadDependencies) ComponentDependenciesKt.getDependencies(WizardImageUploadDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withAdvertId(string).withVerificationSteps(arrayList).withPermissionHelper(new FragmentPermissionHelper(this));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withPermissionHelper.withResources(resources).build().inject(this);
        PhotoWizardViewModelFactory photoWizardViewModelFactory = this.viewModelFactory;
        if (photoWizardViewModelFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel = ViewModelProviders.of(this, photoWizardViewModelFactory).get(PhotoWizardViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        this.a = (PhotoWizardViewModel) viewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.view_photo_wizard, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter = this.presenter;
        if (wizardPhotoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPhotoPickerPresenter.detachView();
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter2 = this.presenter;
        if (wizardPhotoPickerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPhotoPickerPresenter2.detachRouter();
        PhotoWizardViewModel photoWizardViewModel = this.a;
        if (photoWizardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoWizardViewModel.getViewStateData().removeObservers(getViewLifecycleOwner());
        PhotoWizardViewModel photoWizardViewModel2 = this.a;
        if (photoWizardViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        photoWizardViewModel2.getTitleData().removeObservers(getViewLifecycleOwner());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter = this.presenter;
        if (wizardPhotoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPhotoPickerPresenter.closeCamera();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter = this.presenter;
        if (wizardPhotoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPhotoPickerPresenter.onPermissionsResult();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter = this.presenter;
        if (wizardPhotoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPhotoPickerPresenter.openCamera();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        WizardPhotoPickerViewImpl wizardPhotoPickerViewImpl = new WizardPhotoPickerViewImpl(view, features2);
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter = this.presenter;
        if (wizardPhotoPickerPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPhotoPickerPresenter.attachView(wizardPhotoPickerViewImpl);
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter2 = this.presenter;
        if (wizardPhotoPickerPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        wizardPhotoPickerPresenter2.attachRouter(this);
        WizardPhotoPickerPresenter wizardPhotoPickerPresenter3 = this.presenter;
        if (wizardPhotoPickerPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PhotoWizardViewModel photoWizardViewModel = this.a;
        if (photoWizardViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        wizardPhotoPickerPresenter3.setViewModel(photoWizardViewModel);
        PhotoWizardViewModel photoWizardViewModel2 = this.a;
        if (photoWizardViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        photoWizardViewModel2.getViewStateData().observe(viewLifecycleOwner, new a(this, wizardPhotoPickerViewImpl));
        photoWizardViewModel2.getTitleData().observe(viewLifecycleOwner, new b(this, wizardPhotoPickerViewImpl));
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "<set-?>");
        this.intentFactory = implicitIntentFactory;
    }

    public final void setPresenter(@NotNull WizardPhotoPickerPresenter wizardPhotoPickerPresenter) {
        Intrinsics.checkNotNullParameter(wizardPhotoPickerPresenter, "<set-?>");
        this.presenter = wizardPhotoPickerPresenter;
    }

    public final void setViewModelFactory(@NotNull PhotoWizardViewModelFactory photoWizardViewModelFactory) {
        Intrinsics.checkNotNullParameter(photoWizardViewModelFactory, "<set-?>");
        this.viewModelFactory = photoWizardViewModelFactory;
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerPresenter.Router
    public void toAppSettings() {
        ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(implicitIntentFactory.createAppSettingsIntent());
    }
}
