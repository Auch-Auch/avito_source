package com.avito.android.section.action;

import a2.a.a.l2.f.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.section.SectionRouter;
import com.avito.android.section.action.SectionActionPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/section/action/SectionActionPresenterImpl;", "Lcom/avito/android/section/action/SectionActionPresenter;", "Lcom/avito/android/section/SectionRouter;", "router", "", "attachRouter", "(Lcom/avito/android/section/SectionRouter;)V", "detachRouter", "()V", "Lcom/avito/android/section/action/SectionActionItemView;", "view", "Lcom/avito/android/section/action/SectionActionItem;", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/section/action/SectionActionItemView;Lcom/avito/android/section/action/SectionActionItem;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/section/SectionRouter;", "<init>", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionActionPresenterImpl implements SectionActionPresenter {
    public SectionRouter a;

    @Override // com.avito.android.section.action.SectionActionPresenter
    public void attachRouter(@NotNull SectionRouter sectionRouter) {
        Intrinsics.checkNotNullParameter(sectionRouter, "router");
        this.a = sectionRouter;
    }

    @Override // com.avito.android.section.action.SectionActionPresenter
    public void detachRouter() {
        this.a = null;
    }

    public void viewAttached(@NotNull SectionActionItemView sectionActionItemView, int i) {
        Intrinsics.checkNotNullParameter(sectionActionItemView, "view");
        SectionActionPresenter.DefaultImpls.viewAttached(this, sectionActionItemView, i);
    }

    public void viewDetached(@NotNull SectionActionItemView sectionActionItemView, int i) {
        Intrinsics.checkNotNullParameter(sectionActionItemView, "view");
        SectionActionPresenter.DefaultImpls.viewDetached(this, sectionActionItemView, i);
    }

    public void bindView(@NotNull SectionActionItemView sectionActionItemView, @NotNull SectionActionItem sectionActionItem, int i) {
        Intrinsics.checkNotNullParameter(sectionActionItemView, "view");
        Intrinsics.checkNotNullParameter(sectionActionItem, "item");
        Action action = sectionActionItem.getAction();
        if (action != null) {
            sectionActionItemView.setActionButtonVisible(true);
            sectionActionItemView.setActionButton(action.getTitle(), new a(this, action));
            return;
        }
        sectionActionItemView.setActionButtonVisible(false);
    }
}
