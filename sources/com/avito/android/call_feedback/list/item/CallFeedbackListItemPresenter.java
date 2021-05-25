package com.avito.android.call_feedback.list.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemView;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItem;", "Impl", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
public interface CallFeedbackListItemPresenter extends ItemPresenter<CallFeedbackListItemView, CallFeedbackListItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemPresenter$Impl;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemPresenter;", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemView;", "view", "Lcom/avito/android/call_feedback/list/item/CallFeedbackListItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/call_feedback/list/item/CallFeedbackListItemView;Lcom/avito/android/call_feedback/list/item/CallFeedbackListItem;I)V", "Lcom/jakewharton/rxrelay2/Relay;", "", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/Relay;", "consumer", "<init>", "(Lcom/jakewharton/rxrelay2/Relay;)V", "call-feedback_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements CallFeedbackListItemPresenter {
        public final Relay<String> a;

        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Impl a;
            public final /* synthetic */ CallFeedbackListItem b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Impl impl, CallFeedbackListItem callFeedbackListItem) {
                super(0);
                this.a = impl;
                this.b = callFeedbackListItem;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.a.a.accept(this.b.getStringId());
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ CallFeedbackListItemView a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(CallFeedbackListItemView callFeedbackListItemView) {
                super(0);
                this.a = callFeedbackListItemView;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                this.a.setClickListener(null);
                this.a.setUnbindListener(null);
                return Unit.INSTANCE;
            }
        }

        @Inject
        public Impl(@NotNull Relay<String> relay) {
            Intrinsics.checkNotNullParameter(relay, "consumer");
            this.a = relay;
        }

        public void bindView(@NotNull CallFeedbackListItemView callFeedbackListItemView, @NotNull CallFeedbackListItem callFeedbackListItem, int i) {
            Intrinsics.checkNotNullParameter(callFeedbackListItemView, "view");
            Intrinsics.checkNotNullParameter(callFeedbackListItem, "item");
            callFeedbackListItemView.setTitle(callFeedbackListItem.getTitle());
            callFeedbackListItemView.setClickListener(new a(this, callFeedbackListItem));
            callFeedbackListItemView.setUnbindListener(new b(callFeedbackListItemView));
        }
    }
}
