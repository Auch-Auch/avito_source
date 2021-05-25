package com.sumsub.sns.presentation.screen.preview.photo.common;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment;
import com.sumsub.sns.presentation.screen.preview.photo.SNSPreviewPhotoDocumentFragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/common/SNSPreviewCommonDocumentFragment;", "Lcom/sumsub/sns/presentation/screen/preview/photo/SNSPreviewPhotoDocumentFragment;", "Lcom/sumsub/sns/presentation/screen/preview/photo/common/SNSPreviewCommonDocumentViewModel;", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/preview/photo/common/SNSPreviewCommonDocumentViewModel;", "viewModel", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSPreviewCommonDocumentFragment extends SNSPreviewPhotoDocumentFragment<SNSPreviewCommonDocumentViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "SNSPreviewCommonDocumentFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSPreviewCommonDocumentViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.preview.photo.common.SNSPreviewCommonDocumentFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.preview.photo.common.SNSPreviewCommonDocumentFragment$$special$$inlined$viewModels$2
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/photo/common/SNSPreviewCommonDocumentFragment$Companion;", "", "Lcom/sumsub/sns/core/data/model/Document;", "document", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/data/model/Document;)Landroidx/fragment/app/Fragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull Document document) {
            Intrinsics.checkNotNullParameter(document, "document");
            SNSPreviewCommonDocumentFragment sNSPreviewCommonDocumentFragment = new SNSPreviewCommonDocumentFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SNSBaseDocumentPreviewFragment.ARGS_DOCUMENT, document);
            Unit unit = Unit.INSTANCE;
            sNSPreviewCommonDocumentFragment.setArguments(bundle);
            return sNSPreviewCommonDocumentFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSPreviewCommonDocumentFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSPreviewCommonDocumentFragment sNSPreviewCommonDocumentFragment) {
            super(0);
            this.a = sNSPreviewCommonDocumentFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSPreviewCommonDocumentFragment sNSPreviewCommonDocumentFragment = this.a;
            return new SNSPreviewCommonDocumentViewModelFactory(sNSPreviewCommonDocumentFragment, sNSPreviewCommonDocumentFragment.getServiceLocator(), this.a.getArguments());
        }
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSPreviewCommonDocumentViewModel getViewModel() {
        return (SNSPreviewCommonDocumentViewModel) this.b.getValue();
    }
}
