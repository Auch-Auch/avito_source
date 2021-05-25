package com.avito.android.select;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.VariantItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/select/VariantItemPresenterImpl;", "Lcom/avito/android/select/VariantItemPresenter;", "Lcom/avito/android/select/VariantItemView;", "view", "Lcom/avito/android/select/VariantItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/select/VariantItemView;Lcom/avito/android/select/VariantItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/select/VariantItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class VariantItemPresenterImpl implements VariantItemPresenter {
    public final Lazy<VariantItemPresenter.Listener> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VariantItemPresenterImpl a;
        public final /* synthetic */ VariantItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(VariantItemPresenterImpl variantItemPresenterImpl, VariantItem variantItem) {
            super(0);
            this.a = variantItemPresenterImpl;
            this.b = variantItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((VariantItemPresenter.Listener) this.a.a.get()).onItemClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public VariantItemPresenterImpl(@NotNull Lazy<VariantItemPresenter.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public void bindView(@NotNull VariantItemView variantItemView, @NotNull VariantItem variantItem, int i) {
        Intrinsics.checkNotNullParameter(variantItemView, "view");
        Intrinsics.checkNotNullParameter(variantItem, "item");
        variantItemView.setTitle(variantItem.getTitle());
        variantItemView.setSubtitle(variantItem.getSubtitle());
        variantItemView.setImage(variantItem.getImage());
        variantItemView.setSelected(variantItem.getSelected());
        variantItemView.enableMultiselect(variantItem.isMultiselect());
        variantItemView.setOnClickListener(new a(this, variantItem));
    }
}
