package com.sumsub.sns.presentation.screen.preview;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.sumsub.sns.core.common.SNSAppListener;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.presentation.screen.base.SNSBaseFragment;
import com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u0017*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewFragment;", "Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewViewModel;", "VM", "Lcom/sumsub/sns/presentation/screen/base/SNSBaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onMoveToNextDocument", "()Lkotlin/Unit;", "", "isCanceled", "onMoveToVerificationScreen", "(Z)Lkotlin/Unit;", "Lcom/sumsub/sns/core/data/model/Document;", "document", "onDocumentUploaded", "(Lcom/sumsub/sns/core/data/model/Document;)Lkotlin/Unit;", "<init>", "()V", "Companion", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSBaseDocumentPreviewFragment<VM extends SNSBaseDocumentPreviewViewModel> extends SNSBaseFragment<VM> {
    @NotNull
    public static final String ARGS_DOCUMENT = "ARGS_DOCUMENT";
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/SNSBaseDocumentPreviewFragment$Companion;", "", "", SNSBaseDocumentPreviewFragment.ARGS_DOCUMENT, "Ljava/lang/String;", "<init>", "()V", "idensic-mobile-sdk_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Nullable
    public final Unit onDocumentUploaded(@NotNull Document document) {
        Intrinsics.checkNotNullParameter(document, "document");
        FragmentActivity activity = getActivity();
        if (!(activity instanceof SNSAppListener)) {
            activity = null;
        }
        SNSAppListener sNSAppListener = (SNSAppListener) activity;
        if (sNSAppListener == null) {
            return null;
        }
        sNSAppListener.onDocumentUploaded(document);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Unit onMoveToNextDocument() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof SNSAppListener)) {
            activity = null;
        }
        SNSAppListener sNSAppListener = (SNSAppListener) activity;
        if (sNSAppListener == null) {
            return null;
        }
        sNSAppListener.onMoveToNextDocument();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Unit onMoveToVerificationScreen(boolean z) {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof SNSAppListener)) {
            activity = null;
        }
        SNSAppListener sNSAppListener = (SNSAppListener) activity;
        if (sNSAppListener == null) {
            return null;
        }
        sNSAppListener.onMoveToVerificationScreen(z);
        return Unit.INSTANCE;
    }

    @Override // com.sumsub.sns.presentation.screen.base.SNSBaseFragment, com.sumsub.sns.core.presentation.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LiveData<Event<Object>> showNextDocument = ((SNSBaseDocumentPreviewViewModel) getViewModel()).getShowNextDocument();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        showNextDocument.observe(viewLifecycleOwner, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment$onViewCreated$$inlined$observeEvent$1
            public final /* synthetic */ SNSBaseDocumentPreviewFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
                    this.a.onMoveToNextDocument();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        LiveData<Event<Boolean>> showVerificationScreen = ((SNSBaseDocumentPreviewViewModel) getViewModel()).getShowVerificationScreen();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        showVerificationScreen.observe(viewLifecycleOwner2, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment$onViewCreated$$inlined$observeEvent$2
            public final /* synthetic */ SNSBaseDocumentPreviewFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    this.a.onMoveToVerificationScreen(((Boolean) contentIfNotHandled).booleanValue());
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        MutableLiveData<Event<Document>> documentUploaded = ((SNSBaseDocumentPreviewViewModel) getViewModel()).getDocumentUploaded();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        documentUploaded.observe(viewLifecycleOwner3, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.presentation.screen.preview.SNSBaseDocumentPreviewFragment$onViewCreated$$inlined$observeEvent$3
            public final /* synthetic */ SNSBaseDocumentPreviewFragment a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    this.a.onDocumentUploaded((Document) contentIfNotHandled);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }
}
