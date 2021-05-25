package com.avito.android.section.title_with_action;

import android.view.View;
import com.avito.android.section.action.SectionActionItemView;
import com.avito.android.section.title.SectionTitleItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\f\u0010\u000bJ&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/section/title_with_action/SectionTitleWithActionViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItemView;", "Lcom/avito/android/section/title/SectionTitleItemView;", "Lcom/avito/android/section/action/SectionActionItemView;", "", "onUnbind", "()V", "", "text", "bindSubtitle", "(Ljava/lang/String;)V", "bindTitle", "title", "Lkotlin/Function0;", "action", "setActionButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "visible", "setActionButtonVisible", "(Z)V", "s", "Lcom/avito/android/section/title/SectionTitleItemView;", "titleItemView", "t", "Lcom/avito/android/section/action/SectionActionItemView;", "actionItemView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/section/title/SectionTitleItemView;Lcom/avito/android/section/action/SectionActionItemView;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTitleWithActionViewHolder extends BaseViewHolder implements SectionTitleWithActionItemView, SectionTitleItemView, SectionActionItemView {
    public final SectionTitleItemView s;
    public final SectionActionItemView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SectionTitleWithActionViewHolder(@NotNull View view, @NotNull SectionTitleItemView sectionTitleItemView, @NotNull SectionActionItemView sectionActionItemView) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sectionTitleItemView, "titleItemView");
        Intrinsics.checkNotNullParameter(sectionActionItemView, "actionItemView");
        this.s = sectionTitleItemView;
        this.t = sectionActionItemView;
    }

    @Override // com.avito.android.section.title.SectionTitleItemView
    public void bindSubtitle(@Nullable String str) {
        this.s.bindSubtitle(str);
    }

    @Override // com.avito.android.section.title.SectionTitleItemView
    public void bindTitle(@Nullable String str) {
        this.s.bindTitle(str);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.onUnbind();
        this.t.onUnbind();
    }

    @Override // com.avito.android.section.action.SectionActionItemView
    public void setActionButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "action");
        this.t.setActionButton(str, function0);
    }

    @Override // com.avito.android.section.action.SectionActionItemView
    public void setActionButtonVisible(boolean z) {
        this.t.setActionButtonVisible(z);
    }
}
