package com.sumsub.sns.presentation.screen.documents.reviewed;

import androidx.lifecycle.Observer;
import com.sumsub.sns.core.common.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/sumsub/sns/core/common/ExtensionsKt$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$3<T> implements Observer<T> {
    public final /* synthetic */ SNSReviewedDocumentsFragment a;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$3 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$3 sNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$3) {
            super(1);
            this.a = sNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "url");
            this.a.a.getViewModel().onLinkClicked(str2);
            return Unit.INSTANCE;
        }
    }

    public SNSReviewedDocumentsFragment$onViewCreated$$inlined$observe$3(SNSReviewedDocumentsFragment sNSReviewedDocumentsFragment) {
        this.a = sNSReviewedDocumentsFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            int intValue = t.intValue();
            this.a.getTvFooter().setText(intValue == 0 ? null : ExtensionsKt.asHtml(this.a.getStringResource(intValue)));
            this.a.getTvFooter().setVisibility(intValue == 0 ? 4 : 0);
            ExtensionsKt.handleUrlClicks(this.a.getTvFooter(), new a(this));
        }
    }
}
