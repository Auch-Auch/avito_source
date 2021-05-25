package com.sumsub.sns.presentation.screen.documents;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.presentation.base.adapter.SNSBaseRecyclerAdapter;
import com.sumsub.sns.core.presentation.base.adapter.decorator.VerticalSpaceItemDecoration;
import com.sumsub.sns.presentation.screen.base.SNSBaseFragment;
import com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0014*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsFragment;", "Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsViewModel;", "VM", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseFragment;", "Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Lcom/sumsub/sns/core/data/model/Document;", "getAdapter", "()Lcom/sumsub/sns/core/presentation/base/adapter/SNSBaseRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView;", "getList", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseListDocumentsFragment<VM extends SNSBaseListDocumentsViewModel> extends SNSBaseFragment<VM> {
    @NotNull
    public static final String ARGS_APPLICANT = "ARGS_APPLICANT";
    @NotNull
    public static final String ARGS_DOCUMENTS = "ARGS_DOCUMENTS";
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsFragment$Companion;", "", "", SNSBaseListDocumentsFragment.ARGS_APPLICANT, "Ljava/lang/String;", SNSBaseListDocumentsFragment.ARGS_DOCUMENTS, "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public abstract SNSBaseRecyclerAdapter<Document, ?> getAdapter();

    @NotNull
    public abstract RecyclerView getList();

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getList().setLayoutManager(new LinearLayoutManager(requireContext()));
        getList().addItemDecoration(new VerticalSpaceItemDecoration(ExtensionsKt.getPx(12)));
        getList().setAdapter(getAdapter());
        Bundle arguments = getArguments();
        ArrayList arrayList = null;
        Applicant applicant = arguments != null ? (Applicant) arguments.getParcelable(ARGS_APPLICANT) : null;
        Intrinsics.checkNotNull(applicant);
        Intrinsics.checkNotNullExpressionValue(applicant, "arguments?.getParcelable…licant>(ARGS_APPLICANT)!!");
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arrayList = arguments2.getParcelableArrayList(ARGS_DOCUMENTS);
        }
        Intrinsics.checkNotNull(arrayList);
        Intrinsics.checkNotNullExpressionValue(arrayList, "arguments?.getParcelable…cument>(ARGS_DOCUMENTS)!!");
        ((SNSBaseListDocumentsViewModel) getViewModel()).setData(applicant, arrayList);
        ((SNSBaseListDocumentsViewModel) getViewModel()).onLoad();
        LiveData<List<Document>> documents = ((SNSBaseListDocumentsViewModel) getViewModel()).getDocuments();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        documents.observe(viewLifecycleOwner, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment$onViewCreated$$inlined$observe$1
            public final /* synthetic */ SNSBaseListDocumentsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getAdapter().setResources(t);
                }
            }
        });
        LiveData<Boolean> showDocuments = ((SNSBaseListDocumentsViewModel) getViewModel()).getShowDocuments();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        showDocuments.observe(viewLifecycleOwner2, new Observer<T>(this) { // from class: com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsFragment$onViewCreated$$inlined$observe$2
            public final /* synthetic */ SNSBaseListDocumentsFragment a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getList().setVisibility(t.booleanValue() ? 0 : 8);
                }
            }
        });
    }
}
