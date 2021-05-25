package com.sumsub.sns.presentation.screen.documents.reviewed;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
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
import com.sumsub.sns.presentation.adapters.documents.SNSReviewedDocumentsAdapter;
import com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\f\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001d\u0010\"\u001a\u00020\u00028V@\u0016X\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u00104\u001a\u0002018B@\u0002X\u0002¢\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b\b\u00103R\"\u00105\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u0010\f\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010\u0016\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR\"\u0010=\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010\u0016\u001a\u0004\b>\u0010\u0018\"\u0004\b?\u0010\u001a¨\u0006C"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/reviewed/SNSReviewedDocumentsFragment;", "Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsFragment;", "Lcom/sumsub/sns/presentation/screen/documents/reviewed/SNSReviewedDocumentsViewModel;", "", "getLayoutId", "()I", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Lcom/sumsub/sns/core/data/model/Document;", "getAdapter", "()Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "getList", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/widget/TextView;", "tvFooter", "Landroid/widget/TextView;", "getTvFooter", "()Landroid/widget/TextView;", "setTvFooter", "(Landroid/widget/TextView;)V", "tvModerationComment", "getTvModerationComment", "setTvModerationComment", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/presentation/screen/documents/reviewed/SNSReviewedDocumentsViewModel;", "viewModel", "Landroid/widget/ScrollView;", "svModerationComment", "Landroid/widget/ScrollView;", "getSvModerationComment", "()Landroid/widget/ScrollView;", "setSvModerationComment", "(Landroid/widget/ScrollView;)V", "Landroid/widget/ImageView;", "ivResult", "Landroid/widget/ImageView;", "getIvResult", "()Landroid/widget/ImageView;", "setIvResult", "(Landroid/widget/ImageView;)V", "Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter;", "c", "()Lcom/sumsub/sns/presentation/adapters/documents/SNSReviewedDocumentsAdapter;", "adapter", "rvList", "Landroidx/recyclerview/widget/RecyclerView;", "getRvList", "setRvList", "(Landroidx/recyclerview/widget/RecyclerView;)V", "tvTitle", "getTvTitle", "setTvTitle", "tvSubtitle", "getTvSubtitle", "setTvSubtitle", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSReviewedDocumentsFragment extends SNSBaseListDocumentsFragment<SNSReviewedDocumentsViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "ReviewedDocumentsFragment";
    @NotNull
    public final Lazy b = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SNSReviewedDocumentsViewModel.class), new Function0<ViewModelStore>(new Function0<Fragment>(this) { // from class: com.sumsub.sns.presentation.screen.documents.reviewed.SNSReviewedDocumentsFragment$$special$$inlined$viewModels$1
        public final /* synthetic */ Fragment a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Fragment invoke() {
            return this.a;
        }
    }) { // from class: com.sumsub.sns.presentation.screen.documents.reviewed.SNSReviewedDocumentsFragment$$special$$inlined$viewModels$2
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
    }, new b(this));
    public final Lazy c = c.lazy(new a(this));
    @BindView(2241)
    public ImageView ivResult;
    @BindView(2359)
    public RecyclerView rvList;
    @BindView(2418)
    public ScrollView svModerationComment;
    @BindView(2470)
    public TextView tvFooter;
    @BindView(2477)
    public TextView tvModerationComment;
    @BindView(2481)
    public TextView tvSubtitle;
    @BindView(2483)
    public TextView tvTitle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/reviewed/SNSReviewedDocumentsFragment$Companion;", "", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "", "Lcom/sumsub/sns/core/data/model/Document;", "documents", "Landroidx/fragment/app/Fragment;", "newInstance", "(Lcom/sumsub/sns/core/data/model/Applicant;Ljava/util/List;)Landroidx/fragment/app/Fragment;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Fragment newInstance(@NotNull Applicant applicant, @NotNull List<Document> list) {
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(list, "documents");
            SNSReviewedDocumentsFragment sNSReviewedDocumentsFragment = new SNSReviewedDocumentsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SNSBaseListDocumentsFragment.ARGS_APPLICANT, applicant);
            bundle.putParcelableArrayList(SNSBaseListDocumentsFragment.ARGS_DOCUMENTS, new ArrayList<>(list));
            Unit unit = Unit.INSTANCE;
            sNSReviewedDocumentsFragment.setArguments(bundle);
            return sNSReviewedDocumentsFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<SNSReviewedDocumentsAdapter> {
        public final /* synthetic */ SNSReviewedDocumentsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSReviewedDocumentsFragment sNSReviewedDocumentsFragment) {
            super(0);
            this.a = sNSReviewedDocumentsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public SNSReviewedDocumentsAdapter invoke() {
            return new SNSReviewedDocumentsAdapter(new a2.q.a.d.a.c.a.a(this));
        }
    }

    public static final class b extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSReviewedDocumentsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSReviewedDocumentsFragment sNSReviewedDocumentsFragment) {
            super(0);
            this.a = sNSReviewedDocumentsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSReviewedDocumentsFragment sNSReviewedDocumentsFragment = this.a;
            return new SNSReviewedDocumentsViewModelFactory(sNSReviewedDocumentsFragment, sNSReviewedDocumentsFragment.getArguments());
        }
    }

    @Override // com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment
    @NotNull
    public SNSBaseRecyclerAdapter<Document, ?> getAdapter() {
        return (SNSReviewedDocumentsAdapter) this.c.getValue();
    }

    @NotNull
    public final ImageView getIvResult() {
        ImageView imageView = this.ivResult;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivResult");
        }
        return imageView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseFragment
    public int getLayoutId() {
        return R.layout.sns_fragment_reviewed_documents;
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
    public final ScrollView getSvModerationComment() {
        ScrollView scrollView = this.svModerationComment;
        if (scrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("svModerationComment");
        }
        return scrollView;
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
    public final TextView getTvModerationComment() {
        TextView textView = this.tvModerationComment;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvModerationComment");
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
    public SNSReviewedDocumentsViewModel getViewModel() {
        return (SNSReviewedDocumentsViewModel) this.b.getValue();
    }

    @Override // com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment, com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<Integer> title = getViewModel().getTitle();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        title.observe(viewLifecycleOwner, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.documents.reviewed.SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$1
            public final /* synthetic */ SNSReviewedDocumentsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    int intValue = t.intValue();
                    this.a.getTvTitle().setText(intValue == 0 ? null : ExtensionsKt.asHtml(this.a.getStringResource(intValue)));
                    this.a.getTvTitle().setVisibility(intValue == 0 ? 4 : 0);
                }
            }
        });
        LiveData<Integer> subtitle = getViewModel().getSubtitle();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        subtitle.observe(viewLifecycleOwner2, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.documents.reviewed.SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$2
            public final /* synthetic */ SNSReviewedDocumentsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    int intValue = t.intValue();
                    this.a.getTvSubtitle().setText(intValue == 0 ? null : ExtensionsKt.asHtml(this.a.getStringResource(intValue)));
                    this.a.getTvSubtitle().setVisibility(intValue == 0 ? 4 : 0);
                }
            }
        });
        LiveData<Integer> footer = getViewModel().getFooter();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        footer.observe(viewLifecycleOwner3, new SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$3(this));
        LiveData<Integer> showImageResult = getViewModel().getShowImageResult();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        showImageResult.observe(viewLifecycleOwner4, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.documents.reviewed.SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$4
            public final /* synthetic */ SNSReviewedDocumentsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    int intValue = t.intValue();
                    if (intValue != 0) {
                        this.a.getIvResult().setImageResource(intValue);
                        this.a.getIvResult().setVisibility(0);
                        return;
                    }
                    this.a.getIvResult().setVisibility(8);
                }
            }
        });
        LiveData<String> moderationComment = getViewModel().getModerationComment();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        moderationComment.observe(viewLifecycleOwner5, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.documents.reviewed.SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$5
            public final /* synthetic */ SNSReviewedDocumentsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    if (t2.length() == 0) {
                        this.a.getSvModerationComment().setVisibility(4);
                        return;
                    }
                    this.a.getSvModerationComment().setVisibility(0);
                    this.a.getTvModerationComment().setText(t2);
                }
            }
        });
    }

    public final void setIvResult(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivResult = imageView;
    }

    public final void setRvList(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.rvList = recyclerView;
    }

    public final void setSvModerationComment(@NotNull ScrollView scrollView) {
        Intrinsics.checkNotNullParameter(scrollView, "<set-?>");
        this.svModerationComment = scrollView;
    }

    public final void setTvFooter(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvFooter = textView;
    }

    public final void setTvModerationComment(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvModerationComment = textView;
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
