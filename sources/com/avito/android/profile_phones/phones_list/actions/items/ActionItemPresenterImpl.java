package com.avito.android.profile_phones.phones_list.actions.items;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nRD\u0010\u0010\u001a0\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004 \f*\u0017\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000b¢\u0006\u0002\b\r0\u000b¢\u0006\u0002\b\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenterImpl;", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemPresenter;", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemView;", "view", "Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItemView;Lcom/avito/android/profile_phones/phones_list/actions/items/ActionItem;I)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "itemSelectedRelay", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getItemSelectedObservable", "()Lio/reactivex/rxjava3/core/Observable;", "itemSelectedObservable", "<init>", "()V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class ActionItemPresenterImpl implements ActionItemPresenter {
    public final PublishRelay<ActionItem> a;
    @NotNull
    public final Observable<ActionItem> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ActionItemPresenterImpl a;
        public final /* synthetic */ ActionItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ActionItemPresenterImpl actionItemPresenterImpl, ActionItem actionItem) {
            super(0);
            this.a = actionItemPresenterImpl;
            this.b = actionItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ActionItemPresenterImpl() {
        PublishRelay<ActionItem> create = PublishRelay.create();
        this.a = create;
        Observable<ActionItem> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "itemSelectedRelay.hide()");
        this.b = hide;
    }

    @Override // com.avito.android.profile_phones.phones_list.actions.items.ActionItemPresenter
    @NotNull
    public Observable<ActionItem> getItemSelectedObservable() {
        return this.b;
    }

    public void bindView(@NotNull ActionItemView actionItemView, @NotNull ActionItem actionItem, int i) {
        Intrinsics.checkNotNullParameter(actionItemView, "view");
        Intrinsics.checkNotNullParameter(actionItem, "item");
        actionItemView.setTitle(actionItem.getAction().getText());
        if (actionItem.getAction().getShouldBeRed()) {
            actionItemView.applyRedState();
        } else {
            actionItemView.applyNormalState();
        }
        actionItemView.setClickListener(new a(this, actionItem));
    }
}
