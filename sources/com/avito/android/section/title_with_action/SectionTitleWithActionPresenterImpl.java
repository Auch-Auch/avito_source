package com.avito.android.section.title_with_action;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.title.SectionTitleItemPresenter;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/section/title_with_action/SectionTitleWithActionPresenterImpl;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionPresenter;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItemView;", "view", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/section/title_with_action/SectionTitleWithActionItemView;Lcom/avito/android/section/title_with_action/SectionTitleWithActionItem;I)V", "Lcom/avito/android/section/action/SectionActionPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/section/action/SectionActionPresenter;", "actionPresenter", "Lcom/avito/android/section/title/SectionTitleItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/section/title/SectionTitleItemPresenter;", "titlePresenter", "<init>", "(Lcom/avito/android/section/title/SectionTitleItemPresenter;Lcom/avito/android/section/action/SectionActionPresenter;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTitleWithActionPresenterImpl implements SectionTitleWithActionPresenter {
    public final SectionTitleItemPresenter a;
    public final SectionActionPresenter b;

    @Inject
    public SectionTitleWithActionPresenterImpl(@NotNull SectionTitleItemPresenter sectionTitleItemPresenter, @NotNull SectionActionPresenter sectionActionPresenter) {
        Intrinsics.checkNotNullParameter(sectionTitleItemPresenter, "titlePresenter");
        Intrinsics.checkNotNullParameter(sectionActionPresenter, "actionPresenter");
        this.a = sectionTitleItemPresenter;
        this.b = sectionActionPresenter;
    }

    public void viewAttached(@NotNull SectionTitleWithActionItemView sectionTitleWithActionItemView, int i) {
        Intrinsics.checkNotNullParameter(sectionTitleWithActionItemView, "view");
        SectionTitleWithActionPresenter.DefaultImpls.viewAttached(this, sectionTitleWithActionItemView, i);
    }

    public void viewDetached(@NotNull SectionTitleWithActionItemView sectionTitleWithActionItemView, int i) {
        Intrinsics.checkNotNullParameter(sectionTitleWithActionItemView, "view");
        SectionTitleWithActionPresenter.DefaultImpls.viewDetached(this, sectionTitleWithActionItemView, i);
    }

    public void bindView(@NotNull SectionTitleWithActionItemView sectionTitleWithActionItemView, @NotNull SectionTitleWithActionItem sectionTitleWithActionItem, int i) {
        Intrinsics.checkNotNullParameter(sectionTitleWithActionItemView, "view");
        Intrinsics.checkNotNullParameter(sectionTitleWithActionItem, "item");
        this.a.bindView(sectionTitleWithActionItemView, sectionTitleWithActionItem, i);
        this.b.bindView(sectionTitleWithActionItemView, sectionTitleWithActionItem, i);
    }
}
