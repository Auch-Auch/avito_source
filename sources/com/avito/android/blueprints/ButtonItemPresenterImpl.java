package com.avito.android.blueprints;

import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/blueprints/ButtonItemPresenterImpl;", "Lcom/avito/android/blueprints/ButtonItemPresenter;", "Lcom/avito/android/blueprints/ButtonItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Button;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/ButtonItemView;Lcom/avito/android/category_parameters/ParameterElement$Button;I)V", "Ldagger/Lazy;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItemPresenterImpl implements ButtonItemPresenter {
    public final Lazy<? extends ButtonItemPresenter.Listener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ButtonItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Button b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ButtonItemPresenterImpl buttonItemPresenterImpl, ParameterElement.Button button) {
            super(0);
            this.a = buttonItemPresenterImpl;
            this.b = button;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((ButtonItemPresenter.Listener) this.a.a.get()).onItemButtonClicked(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    public ButtonItemPresenterImpl(@NotNull Lazy<? extends ButtonItemPresenter.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull ButtonItemView buttonItemView, @NotNull ParameterElement.Button button, int i) {
        Intrinsics.checkNotNullParameter(buttonItemView, "view");
        Intrinsics.checkNotNullParameter(button, "item");
        buttonItemView.setButtonTitle(button.getTitle());
        buttonItemView.setOnButtonClickListener(new a(this, button));
    }
}
