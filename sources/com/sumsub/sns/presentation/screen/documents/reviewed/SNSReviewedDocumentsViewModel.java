package com.sumsub.sns.presentation.screen.documents.reviewed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsViewModel;
import com.vk.sdk.api.VKApiConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\fR\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u00138F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\f¨\u0006$"}, d2 = {"Lcom/sumsub/sns/presentation/screen/documents/reviewed/SNSReviewedDocumentsViewModel;", "Lcom/sumsub/sns/presentation/screen/documents/SNSBaseListDocumentsViewModel;", "Lcom/sumsub/sns/core/data/model/Document;", "document", "", "onDocumentClicked", "(Lcom/sumsub/sns/core/data/model/Document;)V", "onLoad", "()V", "Landroidx/lifecycle/MutableLiveData;", "", "n", "Landroidx/lifecycle/MutableLiveData;", "_subtitleLiveData", AuthSource.OPEN_CHANNEL_LIST, "_titleLiveData", "", VKApiConst.Q, "_moderationComment", "Landroidx/lifecycle/LiveData;", "getSubtitle", "()Landroidx/lifecycle/LiveData;", MessengerShareContentUtility.SUBTITLE, "getShowImageResult", "showImageResult", "getModerationComment", "moderationComment", "getFooter", "footer", "p", "_showImageResultLiveData", "getTitle", "title", "o", "_footerLiveData", "<init>", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public final class SNSReviewedDocumentsViewModel extends SNSBaseListDocumentsViewModel {
    public final MutableLiveData<Integer> m = new MutableLiveData<>();
    public final MutableLiveData<Integer> n = new MutableLiveData<>();
    public final MutableLiveData<Integer> o = new MutableLiveData<>();
    public final MutableLiveData<Integer> p;
    public final MutableLiveData<String> q;

    public SNSReviewedDocumentsViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.p = mutableLiveData;
        this.q = new MutableLiveData<>();
        Timber.i("ReviewedDocumentsViewModel is created", new Object[0]);
        mutableLiveData.setValue(0);
    }

    @NotNull
    public final LiveData<Integer> getFooter() {
        return this.o;
    }

    @NotNull
    public final LiveData<String> getModerationComment() {
        return this.q;
    }

    @NotNull
    public final LiveData<Integer> getShowImageResult() {
        return this.p;
    }

    @NotNull
    public final LiveData<Integer> getSubtitle() {
        return this.n;
    }

    @NotNull
    public final LiveData<Integer> getTitle() {
        return this.m;
    }

    @Override // com.sumsub.sns.presentation.screen.documents.SNSBaseListDocumentsViewModel
    public void onDocumentClicked(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        if (document.isRejected() || !document.isSubmitted()) {
            get_showDocumentPreviewActionLiveData().setValue(new Event<>(document));
        }
    }

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseViewModel
    public void onLoad() {
        boolean z;
        int i;
        int i2;
        Applicant value;
        Applicant.Review review;
        Applicant.Review.Result result;
        Applicant.Review review2;
        Applicant.Review.Result result2;
        super.onLoad();
        Applicant value2 = getApplicant().getValue();
        Intrinsics.checkNotNull(value2);
        Intrinsics.checkNotNullExpressionValue(value2, "applicant.value!!");
        Applicant applicant = value2;
        String str = null;
        if (applicant.isFinallyRejected()) {
            get_showDocumentsLiveData().setValue(Boolean.FALSE);
            this.p.setValue(Integer.valueOf(R.drawable.sns_ic_fatal));
            this.m.setValue(Integer.valueOf(R.string.sns_status_FINAL_REJECT_title));
            this.n.setValue(Integer.valueOf(R.string.sns_status_FINAL_REJECT_subtitle));
            this.o.setValue(Integer.valueOf(R.string.sns_status_FINAL_REJECT_footerHtml));
            MutableLiveData<String> mutableLiveData = this.q;
            Applicant value3 = getApplicant().getValue();
            if (!(value3 == null || (review2 = value3.getReview()) == null || (result2 = review2.getResult()) == null)) {
                str = result2.getModerationComment();
            }
            mutableLiveData.setValue(str);
        } else if (applicant.isApproved()) {
            get_showDocumentsLiveData().setValue(Boolean.FALSE);
            this.p.setValue(Integer.valueOf(R.drawable.sns_ic_success));
            this.m.setValue(Integer.valueOf(R.string.sns_status_APPROVED_title));
            this.n.setValue(Integer.valueOf(R.string.sns_status_APPROVED_subtitle));
            this.o.setValue(Integer.valueOf(R.string.sns_status_APPROVED_footerHtml));
        } else {
            boolean z2 = true;
            int i3 = 0;
            if (applicant.isTemporarilyDeclined()) {
                List<Document> value4 = getDocuments().getValue();
                if (value4 == null) {
                    z2 = false;
                } else if (!value4.isEmpty()) {
                    Iterator<T> it = value4.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().isApproved()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                get_showDocumentsLiveData().setValue(Boolean.valueOf(!z2));
                MutableLiveData<Integer> mutableLiveData2 = this.p;
                if (z2) {
                    i3 = R.drawable.sns_ic_fatal;
                }
                mutableLiveData2.setValue(Integer.valueOf(i3));
                MutableLiveData<String> mutableLiveData3 = this.q;
                if (!(!z2 || (value = getApplicant().getValue()) == null || (review = value.getReview()) == null || (result = review.getResult()) == null)) {
                    str = result.getModerationComment();
                }
                mutableLiveData3.setValue(str);
                this.m.setValue(Integer.valueOf(R.string.sns_status_REJECT_title));
                this.n.setValue(Integer.valueOf(R.string.sns_status_REJECT_subtitle));
                this.o.setValue(Integer.valueOf(R.string.sns_status_REJECT_footerHtml));
                return;
            }
            get_showDocumentsLiveData().setValue(Boolean.TRUE);
            this.p.setValue(0);
            List<Document> value5 = getDocuments().getValue();
            Intrinsics.checkNotNull(value5);
            Intrinsics.checkNotNullExpressionValue(value5, "documents.value!!");
            List<Document> list = value5;
            boolean z3 = list instanceof Collection;
            if (!z3 || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().isApproved()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                i3 = R.string.sns_status_APPROVED_title;
                i2 = R.string.sns_status_APPROVED_subtitle;
                i = R.string.sns_status_APPROVED_footerHtml;
            } else {
                if (!z3 || !list.isEmpty()) {
                    Iterator<T> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (it3.next().isRejected()) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z2 = false;
                if (z2) {
                    i3 = R.string.sns_status_REJECT_title;
                    i2 = R.string.sns_status_REJECT_subtitle;
                    i = R.string.sns_status_REJECT_footerHtml;
                } else {
                    i2 = 0;
                    i = 0;
                }
            }
            this.m.setValue(Integer.valueOf(i3));
            this.n.setValue(Integer.valueOf(i2));
            this.o.setValue(Integer.valueOf(i));
        }
    }
}
