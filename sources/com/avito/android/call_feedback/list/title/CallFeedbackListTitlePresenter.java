package com.avito.android.call_feedback.list.title;

import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitlePresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleView;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitle;", "Impl", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackListTitlePresenter extends ItemPresenter<CallFeedbackListTitleView, CallFeedbackListTitle> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitlePresenter$Impl;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitlePresenter;", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleView;", "view", "Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitle;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitleView;Lcom/avito/android/call_feedback/list/title/CallFeedbackListTitle;I)V", "<init>", "()V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements CallFeedbackListTitlePresenter {
        public void bindView(@NotNull CallFeedbackListTitleView callFeedbackListTitleView, @NotNull CallFeedbackListTitle callFeedbackListTitle, int i) {
            Intrinsics.checkNotNullParameter(callFeedbackListTitleView, "view");
            Intrinsics.checkNotNullParameter(callFeedbackListTitle, "item");
            callFeedbackListTitleView.setTitle(callFeedbackListTitle.getTitle());
        }
    }
}
