package com.sumsub.sns.presentation.screen.documents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.presentation.screen.base.SNSBaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u001f\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00168F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00168F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018¨\u0006 "}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsViewModel;", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseViewModel;", "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "", "Lcom/sumsub/sns/core/data/model/Document;", "documents", "", "setData", "(Lcom/sumsub/sns/core/data/model/Applicant;Ljava/util/List;)V", "document", "onDocumentClicked", "(Lcom/sumsub/sns/core/data/model/Document;)V", "Landroidx/lifecycle/MutableLiveData;", "", "l", "Landroidx/lifecycle/MutableLiveData;", "get_showDocumentsLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_showDocumentsLiveData", "k", "_applicantLiveData", "Landroidx/lifecycle/LiveData;", "getApplicant", "()Landroidx/lifecycle/LiveData;", "j", "_documentsLiveData", "getDocuments", "getShowDocuments", "showDocuments", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseListDocumentsViewModel extends SNSBaseViewModel {
    public final MutableLiveData<List<Document>> j = new MutableLiveData<>();
    public final MutableLiveData<Applicant> k = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> l = new MutableLiveData<>();

    @NotNull
    public final LiveData<Applicant> getApplicant() {
        return this.k;
    }

    @NotNull
    public final LiveData<List<Document>> getDocuments() {
        return this.j;
    }

    @NotNull
    public final LiveData<Boolean> getShowDocuments() {
        return this.l;
    }

    @NotNull
    public final MutableLiveData<Boolean> get_showDocumentsLiveData() {
        return this.l;
    }

    public void onDocumentClicked(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
    }

    public final void setData(@NotNull Applicant applicant, @NotNull List<Document> list) {
        Intrinsics.checkNotNullParameter(applicant, "applicant");
        Intrinsics.checkNotNullParameter(list, "documents");
        this.k.setValue(applicant);
        this.j.setValue(list);
    }
}
