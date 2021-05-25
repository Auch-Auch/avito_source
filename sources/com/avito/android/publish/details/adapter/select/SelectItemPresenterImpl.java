package com.avito.android.publish.details.adapter.select;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/publish/details/adapter/select/SelectItemPresenterImpl;", "Lcom/avito/android/publish/details/adapter/select/SelectItemPresenter;", "Lcom/avito/android/publish/details/adapter/select/SelectItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish/details/adapter/select/SelectItemView;Lcom/avito/android/category_parameters/ParameterElement$Select;I)V", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class SelectItemPresenterImpl implements SelectItemPresenter {
    public final ItemDetailsParameterClickListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SelectItemPresenterImpl a;
        public final /* synthetic */ ParameterElement.Select b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectItemPresenterImpl selectItemPresenterImpl, ParameterElement.Select select) {
            super(0);
            this.a = selectItemPresenterImpl;
            this.b = select;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onElementClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    public SelectItemPresenterImpl(@NotNull ItemDetailsParameterClickListener itemDetailsParameterClickListener) {
        Intrinsics.checkNotNullParameter(itemDetailsParameterClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = itemDetailsParameterClickListener;
    }

    public void bindView(@NotNull SelectItemView selectItemView, @NotNull ParameterElement.Select select, int i) {
        Intrinsics.checkNotNullParameter(selectItemView, "view");
        Intrinsics.checkNotNullParameter(select, "item");
        selectItemView.setTitle(select.getTitle());
        selectItemView.setIconVisible(true);
        selectItemView.setValue(select.getValue());
        selectItemView.setEnabled(select.isEnabled());
        String error = select.getError();
        if (error != null) {
            selectItemView.setError(error);
        }
        selectItemView.setOnClickListener(new a(this, select));
    }
}
