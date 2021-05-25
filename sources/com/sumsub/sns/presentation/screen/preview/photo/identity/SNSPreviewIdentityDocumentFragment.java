package com.sumsub.sns.presentation.screen.preview.photo.identity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.data.model.IdentityType;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment;
import com.sumsub.sns.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentFragment;", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentFragment;", "Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "getTitle", "()Ljava/lang/CharSequence;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "idDocType", "c", "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentViewModel;", "viewModel", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSPreviewIdentityDocumentFragment extends SNSPreviewPhotoDocumentFragment<SNSPreviewIdentityDocumentViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "SNSPreviewIdentityDocumentFragment";
    public String b;
    @NotNull
    public final Lazy c = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSPreviewIdentityDocumentViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentFragment$$special$$inlined$viewModels$2
        public final /* synthetic */ Function0 a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.a.invoke()).getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }, new a(this));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/identity/SNSPreviewIdentityDocumentFragment$Companion;", "", "Lcom/sumsub/sns/core/data/model/Document;", "document", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/data/model/Document;)Landroidx/fragment/app/Fragment;", "", "REQUEST_DOCUMENT_SELECTOR", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull Document document) {
            Intrinsics.checkNotNullParameter(document, "document");
            SNSPreviewIdentityDocumentFragment sNSPreviewIdentityDocumentFragment = new SNSPreviewIdentityDocumentFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SNSBaseDocumentPreviewFragment.ARGS_DOCUMENT, document);
            Unit unit = Unit.INSTANCE;
            sNSPreviewIdentityDocumentFragment.setArguments(bundle);
            return sNSPreviewIdentityDocumentFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSPreviewIdentityDocumentFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSPreviewIdentityDocumentFragment sNSPreviewIdentityDocumentFragment) {
            super(0);
            this.a = sNSPreviewIdentityDocumentFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSPreviewIdentityDocumentFragment sNSPreviewIdentityDocumentFragment = this.a;
            return new SNSPreviewIdentityDocumentViewModelFactory(sNSPreviewIdentityDocumentFragment, sNSPreviewIdentityDocumentFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment
    @NotNull
    public CharSequence getTitle() {
        String str = this.b;
        if (str != null) {
            String r0 = IdentityType.m202constructorimpl(str);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            CharSequence r02 = IdentityType.m206getTitleimpl(r0, requireContext);
            if (r02 != null) {
                return r02;
            }
        }
        return super.getTitle();
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSPreviewIdentityDocumentViewModel getViewModel() {
        return (SNSPreviewIdentityDocumentViewModel) this.c.getValue();
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 41) {
            if (i2 == -1) {
                String str = null;
                String stringExtra = intent != null ? intent.getStringExtra(SNSDocumentSelectorActivity.RESULT_SELECTED_COUNTRY) : null;
                if (intent != null) {
                    str = intent.getStringExtra(SNSDocumentSelectorActivity.RESULT_SELECTED_ID_DOC_TYPE);
                }
                Timber.d("Document selected: " + stringExtra + ' ' + str, new Object[0]);
                if (stringExtra == null || str == null) {
                    getViewModel().onMoveToVerificationScreen(true);
                    return;
                }
                this.b = str;
                getViewModel().onDocumentAndCountrySelected(stringExtra, str);
                return;
            }
            getViewModel().onMoveToVerificationScreen(true);
        }
    }

    @Override // com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment, com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MutableLiveData<Event<SNSPreviewIdentityDocumentViewModel.SelectorRequest>> showSelector = getViewModel().getShowSelector();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        showSelector.observe(viewLifecycleOwner, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.identity.SNSPreviewIdentityDocumentFragment$onViewCreated$$inlined$observeEvent$1
            public final /* synthetic */ SNSPreviewIdentityDocumentFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSPreviewIdentityDocumentViewModel.SelectorRequest selectorRequest = (SNSPreviewIdentityDocumentViewModel.SelectorRequest) contentIfNotHandled;
                    SNSPreviewIdentityDocumentFragment sNSPreviewIdentityDocumentFragment = this.a;
                    SNSDocumentSelectorActivity.Companion companion = SNSDocumentSelectorActivity.Companion;
                    Context requireContext = sNSPreviewIdentityDocumentFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    sNSPreviewIdentityDocumentFragment.startActivityForResult(companion.newIntent(requireContext, SNSPreviewIdentityDocumentFragment.access$getSession$p(this.a), selectorRequest.getApplicant(), selectorRequest.getDocumentType()), 41);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }
}
