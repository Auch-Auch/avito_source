package com.avito.android.component.badge_bar.title;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/badge_bar/title/TitleItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/component/badge_bar/title/TitleItemView;", "Lcom/avito/android/component/badge_bar/title/TitleItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/badge_bar/title/TitleItemView;Lcom/avito/android/component/badge_bar/title/TitleItem;I)V", "Lkotlin/Function0;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function0;", "clickListener", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TitleItemPresenter implements ItemPresenter<TitleItemView, TitleItem> {
    public final Function0<Unit> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ TitleItemPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TitleItemPresenter titleItemPresenter) {
            super(0);
            this.a = titleItemPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Function0 function0 = this.a.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    public TitleItemPresenter() {
        this(null, 1, null);
    }

    public TitleItemPresenter(@Nullable Function0<Unit> function0) {
        this.a = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TitleItemPresenter(Function0 function0, int i, j jVar) {
        this((i & 1) != 0 ? null : function0);
    }

    public void bindView(@NotNull TitleItemView titleItemView, @NotNull TitleItem titleItem, int i) {
        Intrinsics.checkNotNullParameter(titleItemView, "view");
        Intrinsics.checkNotNullParameter(titleItem, "item");
        titleItemView.setText(titleItem.getTitle());
        titleItemView.setOnClickListener(new a(this));
    }
}
