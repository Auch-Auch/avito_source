package com.avito.android.abuse.category.item;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/abuse/category/item/AbuseCategoryItemPresenterImpl;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemPresenter;", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemView;", "view", "Lcom/avito/android/abuse/category/item/AbuseCategoryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/abuse/category/item/AbuseCategoryItemView;Lcom/avito/android/abuse/category/item/AbuseCategoryItem;I)V", "Lcom/avito/android/abuse/category/item/AbuseCategoryItemClickListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/abuse/category/item/AbuseCategoryItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/abuse/category/item/AbuseCategoryItemClickListener;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategoryItemPresenterImpl implements AbuseCategoryItemPresenter {
    public final AbuseCategoryItemClickListener a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AbuseCategoryItemPresenterImpl a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AbuseCategoryItemPresenterImpl abuseCategoryItemPresenterImpl, int i) {
            super(0);
            this.a = abuseCategoryItemPresenterImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onItemClick(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AbuseCategoryItemView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AbuseCategoryItemView abuseCategoryItemView) {
            super(0);
            this.a = abuseCategoryItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AbuseCategoryItemPresenterImpl(@NotNull AbuseCategoryItemClickListener abuseCategoryItemClickListener) {
        Intrinsics.checkNotNullParameter(abuseCategoryItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = abuseCategoryItemClickListener;
    }

    public void bindView(@NotNull AbuseCategoryItemView abuseCategoryItemView, @NotNull AbuseCategoryItem abuseCategoryItem, int i) {
        Intrinsics.checkNotNullParameter(abuseCategoryItemView, "view");
        Intrinsics.checkNotNullParameter(abuseCategoryItem, "item");
        abuseCategoryItemView.setText(abuseCategoryItem.getTitle());
        abuseCategoryItemView.setOnClickListener(new a(this, i));
        abuseCategoryItemView.setUnbindListener(new b(abuseCategoryItemView));
        abuseCategoryItemView.setTag(abuseCategoryItem.getWithSubcategories() ? "parent" : AbuseCategoryItemPresenterKt.SINGLE_TAG);
    }
}
