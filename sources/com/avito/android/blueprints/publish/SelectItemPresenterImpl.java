package com.avito.android.blueprints.publish;

import com.avito.android.blueprints.publish.SelectItemPresenter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0012\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0010\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/avito/android/blueprints/publish/SelectItemPresenterImpl;", "Lcom/avito/android/blueprints/publish/SelectItemPresenter;", "Lcom/avito/android/blueprints/publish/SelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/blueprints/publish/SelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select;I)V", "Ldagger/Lazy;", "Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClickListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "clickListener", "Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClearListener;", AuthSource.BOOKING_ORDER, "clearListener", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class SelectItemPresenterImpl implements SelectItemPresenter {
    public final Lazy<? extends SelectItemPresenter.ClickListener> a;
    public final Lazy<? extends SelectItemPresenter.ClearListener> b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            SelectItemPresenter.ClearListener clearListener;
            int i = this.a;
            if (i == 0) {
                ((SelectItemPresenter.ClickListener) ((SelectItemPresenterImpl) this.b).a.get()).onItemClicked((ParameterElement.Select) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                Lazy lazy = ((SelectItemPresenterImpl) this.b).b;
                if (!(lazy == null || (clearListener = (SelectItemPresenter.ClearListener) lazy.get()) == null)) {
                    clearListener.onClearClicked((ParameterElement.Select) this.c);
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public SelectItemPresenterImpl(@NotNull Lazy<? extends SelectItemPresenter.ClickListener> lazy, @Nullable Lazy<? extends SelectItemPresenter.ClearListener> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "clickListener");
        this.a = lazy;
        this.b = lazy2;
    }

    public void bindView(@NotNull SelectItemView selectItemView, @NotNull ParameterElement.Select select, int i) {
        Intrinsics.checkNotNullParameter(selectItemView, "view");
        Intrinsics.checkNotNullParameter(select, "item");
        selectItemView.setTitle(select.getTitle());
        selectItemView.setCleanable(!select.isRequired() && this.b != null);
        selectItemView.setIconVisible(select.getIconVisible());
        selectItemView.setValue(select.getValue());
        String error = select.getError();
        if (error != null) {
            selectItemView.setError(error);
        }
        selectItemView.setOnClickListener(new a(0, this, select));
        selectItemView.setOnClearListener(new a(1, this, select));
    }
}
