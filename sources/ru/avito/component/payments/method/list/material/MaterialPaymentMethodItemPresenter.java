package ru.avito.component.payments.method.list.material;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.list.MaterialPaymentMethodItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0013"}, d2 = {"Lru/avito/component/payments/method/list/material/MaterialPaymentMethodItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/payments/method/list/material/MaterialPaymentMethodViewHolder;", "Lru/avito/component/payments/method/list/MaterialPaymentMethodItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/payments/method/list/material/MaterialPaymentMethodViewHolder;Lru/avito/component/payments/method/list/MaterialPaymentMethodItem;I)V", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, AuthSource.BOOKING_ORDER, "viewClickListener", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MaterialPaymentMethodItemPresenter implements ItemPresenter<MaterialPaymentMethodViewHolder, MaterialPaymentMethodItem> {
    public final Function1<MaterialPaymentMethodItem, Unit> a;
    public final Function1<Integer, Unit> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MaterialPaymentMethodItemPresenter a;
        public final /* synthetic */ MaterialPaymentMethodItem b;
        public final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MaterialPaymentMethodItemPresenter materialPaymentMethodItemPresenter, MaterialPaymentMethodItem materialPaymentMethodItem, int i) {
            super(0);
            this.a = materialPaymentMethodItemPresenter;
            this.b = materialPaymentMethodItem;
            this.c = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.invoke(this.b);
            this.a.b.invoke(Integer.valueOf(this.c));
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super ru.avito.component.payments.method.list.MaterialPaymentMethodItem, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public MaterialPaymentMethodItemPresenter(@NotNull Function1<? super MaterialPaymentMethodItem, Unit> function1, @NotNull Function1<? super Integer, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(function12, "viewClickListener");
        this.a = function1;
        this.b = function12;
    }

    public void bindView(@NotNull MaterialPaymentMethodViewHolder materialPaymentMethodViewHolder, @NotNull MaterialPaymentMethodItem materialPaymentMethodItem, int i) {
        Intrinsics.checkNotNullParameter(materialPaymentMethodViewHolder, "view");
        Intrinsics.checkNotNullParameter(materialPaymentMethodItem, "item");
        materialPaymentMethodViewHolder.setClickListener(new a(this, materialPaymentMethodItem, i));
        materialPaymentMethodViewHolder.setEnabled(materialPaymentMethodItem.isEnabled());
        materialPaymentMethodViewHolder.setLabel(materialPaymentMethodItem.getLabel());
        materialPaymentMethodViewHolder.setTitle(materialPaymentMethodItem.getTitle());
        materialPaymentMethodViewHolder.setSubtitle(materialPaymentMethodItem.getSubtitle());
        materialPaymentMethodViewHolder.setInformation(materialPaymentMethodItem.getInformation());
        materialPaymentMethodViewHolder.setChecked(materialPaymentMethodItem.isChecked());
        materialPaymentMethodViewHolder.setViewTag(materialPaymentMethodItem.getLabel());
    }
}
