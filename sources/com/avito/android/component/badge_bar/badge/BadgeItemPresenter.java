package com.avito.android.component.badge_bar.badge;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/badge_bar/badge/BadgeItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/component/badge_bar/badge/BadgeItemView;", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/badge_bar/badge/BadgeItemView;Lcom/avito/android/component/badge_bar/badge/BadgeItem;I)V", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "badgeClickListener", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeItemPresenter implements ItemPresenter<BadgeItemView, BadgeItem> {
    public final Function1<BadgeItem, Unit> a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BadgeItemPresenter a;
        public final /* synthetic */ BadgeItem b;

        public a(BadgeItemPresenter badgeItemPresenter, BadgeItem badgeItem) {
            this.a = badgeItemPresenter;
            this.b = badgeItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1 = this.a.a;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(this.b);
            }
        }
    }

    public BadgeItemPresenter() {
        this(null, 1, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.component.badge_bar.badge.BadgeItem, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public BadgeItemPresenter(@Nullable Function1<? super BadgeItem, Unit> function1) {
        this.a = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgeItemPresenter(Function1 function1, int i, j jVar) {
        this((i & 1) != 0 ? null : function1);
    }

    public void bindView(@NotNull BadgeItemView badgeItemView, @NotNull BadgeItem badgeItem, int i) {
        Intrinsics.checkNotNullParameter(badgeItemView, "view");
        Intrinsics.checkNotNullParameter(badgeItem, "item");
        badgeItemView.setTitle(badgeItem.getTitle());
        badgeItemView.setDescription(badgeItem.getDescription());
        badgeItemView.setBackground(badgeItem.getBackgroundColor(), badgeItem.getRippleColor());
        badgeItemView.setTextColor(badgeItem.getTextColor());
        badgeItemView.setTitleMaxLines(badgeItem.getTitleMaxLines());
        badgeItemView.setDescriptionMaxLines(badgeItem.getDescriptionMaxLines());
        badgeItemView.setImage(badgeItem.getImage());
        badgeItemView.setOnClickListener(new a(this, badgeItem));
    }
}
