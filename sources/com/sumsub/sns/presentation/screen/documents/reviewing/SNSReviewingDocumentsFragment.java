package com.sumsub.sns.presentation.screen.documents.reviewing;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.R;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.presentation.base.adapter.SNSBaseRecyclerAdapter;
import com.sumsub.sns.presentation.adapters.documents.SNSReviewingDocumentsAdapter;
import com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\"R\u001d\u0010'\u001a\u00020#8B@\u0002X\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\b\u0010&R\"\u0010(\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001d\u0010.\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b+\u0010%\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/reviewing/SNSReviewingDocumentsFragment;", "Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsFragment;", "Lcom/sumsub/sns/presentation/screen/documents/reviewing/SNSReviewingDocumentsViewModel;", "", "getLayoutId", "()I", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Lcom/sumsub/sns/core/data/model/Document;", "getAdapter", "()Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "getList", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "tvFooter", "getTvFooter", "setTvFooter", "rvList", "Landroidx/recyclerview/widget/RecyclerView;", "getRvList", "setRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewingDocumentsAdapter;", "c", "Lkotlin/Lazy;", "()Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewingDocumentsAdapter;", "adapter", "tvSubtitle", "getTvSubtitle", "setTvSubtitle", AuthSource.BOOKING_ORDER, "getViewModel", "()Lcom/sumsub/sns/presentation/screen/documents/reviewing/SNSReviewingDocumentsViewModel;", "viewModel", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSReviewingDocumentsFragment extends SNSBaseListDocumentsFragment<SNSReviewingDocumentsViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "ReviewingDocumentsFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSReviewingDocumentsViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.documents.reviewing.SNSReviewingDocumentsFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.documents.reviewing.SNSReviewingDocumentsFragment$$special$$inlined$viewModels$2
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
    }, new c(this));
    public final Lazy c = t6.c.lazy(a.a);
    @BindView(2359)
    public RecyclerView rvList;
    @BindView(2470)
    public TextView tvFooter;
    @BindView(2481)
    public TextView tvSubtitle;
    @BindView(2483)
    public TextView tvTitle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/reviewing/SNSReviewingDocumentsFragment$Companion;", "", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "", "Lcom/sumsub/sns/core/data/model/Document;", "documents", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/data/model/Applicant;Ljava/util/List;)Landroidx/fragment/app/Fragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull Applicant applicant, @NotNull List<Document> list) {
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(list, "documents");
            SNSReviewingDocumentsFragment sNSReviewingDocumentsFragment = new SNSReviewingDocumentsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SNSBaseListDocumentsFragment.ARGS_APPLICANT, applicant);
            bundle.putParcelableArrayList(SNSBaseListDocumentsFragment.ARGS_DOCUMENTS, new ArrayList<>(list));
            Unit unit = Unit.INSTANCE;
            sNSReviewingDocumentsFragment.setArguments(bundle);
            return sNSReviewingDocumentsFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<SNSReviewingDocumentsAdapter> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SNSReviewingDocumentsAdapter invoke() {
            return new SNSReviewingDocumentsAdapter();
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ SNSReviewingDocumentsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSReviewingDocumentsFragment sNSReviewingDocumentsFragment) {
            super(1);
            this.a = sNSReviewingDocumentsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "url");
            this.a.getViewModel().onLinkClicked(str2);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSReviewingDocumentsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SNSReviewingDocumentsFragment sNSReviewingDocumentsFragment) {
            super(0);
            this.a = sNSReviewingDocumentsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSReviewingDocumentsFragment sNSReviewingDocumentsFragment = this.a;
            return new SNSReviewingDocumentsViewModelFactory(sNSReviewingDocumentsFragment, sNSReviewingDocumentsFragment.getArguments());
        }
    }

    @Override // com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment
    @NotNull
    public SNSBaseRecyclerAdapter<Document, ?> getAdapter() {
        return (SNSReviewingDocumentsAdapter) this.c.getValue();
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_reviewing_documents;
    }

    @Override // com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment
    @NotNull
    public RecyclerView getList() {
        RecyclerView recyclerView = this.rvList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvList");
        }
        return recyclerView;
    }

    @NotNull
    public final RecyclerView getRvList() {
        RecyclerView recyclerView = this.rvList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvList");
        }
        return recyclerView;
    }

    @NotNull
    public final TextView getTvFooter() {
        TextView textView = this.tvFooter;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFooter");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvSubtitle() {
        TextView textView = this.tvSubtitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvTitle() {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        return textView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    @NotNull
    public SNSReviewingDocumentsViewModel getViewModel() {
        return (SNSReviewingDocumentsViewModel) this.b.getValue();
    }

    @Override // com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        }
        textView.setText(ExtensionsKt.asHtml(getStringResource(R.string.sns_status_PENDING_title)));
        TextView textView2 = this.tvSubtitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        }
        textView2.setText(ExtensionsKt.asHtml(getStringResource(R.string.sns_status_PENDING_subtitle)));
        TextView textView3 = this.tvFooter;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFooter");
        }
        textView3.setText(ExtensionsKt.asHtml(getStringResource(R.string.sns_status_PENDING_footerHtml)));
        TextView textView4 = this.tvFooter;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFooter");
        }
        ExtensionsKt.handleUrlClicks(textView4, new b(this));
    }

    public final void setRvList(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.rvList = recyclerView;
    }

    public final void setTvFooter(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvFooter = textView;
    }

    public final void setTvSubtitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvSubtitle = textView;
    }

    public final void setTvTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }
}
