package com.avito.android.express_cv.existed_cv.item;

import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/express_cv/existed_cv/item/FlatButtonPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/express_cv/existed_cv/item/FlatButtonView;", "Lcom/avito/android/express_cv/existed_cv/item/FlatButtonItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/express_cv/existed_cv/item/FlatButtonView;Lcom/avito/android/express_cv/existed_cv/item/FlatButtonItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class FlatButtonPresenter implements ItemPresenter<FlatButtonView, FlatButtonItem> {
    public final Lazy<? extends ButtonItemPresenter.Listener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FlatButtonPresenter a;
        public final /* synthetic */ FlatButtonItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FlatButtonPresenter flatButtonPresenter, FlatButtonItem flatButtonItem) {
            super(0);
            this.a = flatButtonPresenter;
            this.b = flatButtonItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((ButtonItemPresenter.Listener) this.a.a.get()).onItemButtonClicked(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    public FlatButtonPresenter(@NotNull Lazy<? extends ButtonItemPresenter.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull FlatButtonView flatButtonView, @NotNull FlatButtonItem flatButtonItem, int i) {
        Intrinsics.checkNotNullParameter(flatButtonView, "view");
        Intrinsics.checkNotNullParameter(flatButtonItem, "item");
        flatButtonView.setText(flatButtonItem.getTitle());
        flatButtonView.setClickListener(new a(this, flatButtonItem));
    }
}
