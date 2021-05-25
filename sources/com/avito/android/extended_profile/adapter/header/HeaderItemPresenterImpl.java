package com.avito.android.extended_profile.adapter.header;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.adapter.header.HeaderItemAction;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileRatingAction;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/extended_profile/adapter/header/HeaderItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/header/HeaderItemPresenter;", "Lcom/avito/android/extended_profile/adapter/header/HeaderItemView;", "view", "Lcom/avito/android/extended_profile/adapter/header/HeaderItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/extended_profile/adapter/header/HeaderItemView;Lcom/avito/android/extended_profile/adapter/header/HeaderItem;I)V", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "subscriptionsPresenter", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "c", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class HeaderItemPresenterImpl implements HeaderItemPresenter {
    public final Consumer<ExtendedProfileItemAction> a;
    public final SubscriptionsPresenter b;
    public final CompositeSnackbarPresenter c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HeaderItemView a;
        public final /* synthetic */ CompositeDisposable b;
        public final /* synthetic */ HeaderItemPresenterImpl c;
        public final /* synthetic */ HeaderItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HeaderItemView headerItemView, CompositeDisposable compositeDisposable, HeaderItemPresenterImpl headerItemPresenterImpl, HeaderItem headerItem, HeaderItemView headerItemView2) {
            super(0);
            this.a = headerItemView;
            this.b = compositeDisposable;
            this.c = headerItemPresenterImpl;
            this.d = headerItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.c.c.removeOptionalElement(this.d);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ HeaderItemPresenterImpl a;
        public final /* synthetic */ HeaderItemView b;

        public b(HeaderItemPresenterImpl headerItemPresenterImpl, HeaderItem headerItem, HeaderItemView headerItemView) {
            this.a = headerItemPresenterImpl;
            this.b = headerItemView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(HeaderItemAction.AvatarClickAction.INSTANCE);
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ HeaderItemView a;
        public final /* synthetic */ ProfileRatingAction b;
        public final /* synthetic */ HeaderItemPresenterImpl c;
        public final /* synthetic */ HeaderItemView d;

        public c(HeaderItemView headerItemView, CompositeDisposable compositeDisposable, ProfileRatingAction profileRatingAction, HeaderItemPresenterImpl headerItemPresenterImpl, HeaderItem headerItem, HeaderItemView headerItemView2) {
            this.a = headerItemView;
            this.b = profileRatingAction;
            this.c = headerItemPresenterImpl;
            this.d = headerItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.c.a.accept(new HeaderItemAction.RatingClickAction(this.b));
        }
    }

    @Inject
    public HeaderItemPresenterImpl(@NotNull Consumer<ExtendedProfileItemAction> consumer, @NotNull SubscriptionsPresenter subscriptionsPresenter, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        Intrinsics.checkNotNullParameter(subscriptionsPresenter, "subscriptionsPresenter");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        this.a = consumer;
        this.b = subscriptionsPresenter;
        this.c = compositeSnackbarPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.extended_profile.adapter.header.HeaderItemView r13, @org.jetbrains.annotations.NotNull com.avito.android.extended_profile.adapter.header.HeaderItem r14, int r15) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.extended_profile.adapter.header.HeaderItemPresenterImpl.bindView(com.avito.android.extended_profile.adapter.header.HeaderItemView, com.avito.android.extended_profile.adapter.header.HeaderItem, int):void");
    }
}
