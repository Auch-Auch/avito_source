package com.avito.android.section.expand_sections_button;

import android.view.View;
import android.widget.TextView;
import com.avito.android.section.action.SectionActionItemView;
import com.avito.android.section.title.SectionTitleItemView;
import com.avito.android.section.title_with_action.SectionTitleWithActionItemView;
import com.avito.android.section.title_with_action.SectionTitleWithActionViewHolder;
import com.avito.android.serp_core.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J'\u0010\t\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItemViewImpl;", "Lcom/avito/android/section/expand_sections_button/ExpandSectionsButtonItemView;", "Lcom/avito/android/section/title_with_action/SectionTitleWithActionItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "Lkotlin/Function0;", "", "action", "bindExpandButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "text", "bindSubtitle", "(Ljava/lang/String;)V", "bindTitle", "onUnbind", "()V", "setActionButton", "", "visible", "setActionButtonVisible", "(Z)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getExpandButton", "()Landroid/widget/TextView;", "expandButton", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Lcom/avito/android/section/title/SectionTitleItemView;", "titleItemView", "Lcom/avito/android/section/action/SectionActionItemView;", "actionItemView", "<init>", "(Landroid/view/View;Lcom/avito/android/section/title/SectionTitleItemView;Lcom/avito/android/section/action/SectionActionItemView;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ExpandSectionsButtonItemViewImpl extends BaseViewHolder implements ExpandSectionsButtonItemView, SectionTitleWithActionItemView {
    @NotNull
    public final TextView s;
    public final View t;
    public final /* synthetic */ SectionTitleWithActionViewHolder u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandSectionsButtonItemViewImpl(@NotNull View view, @NotNull SectionTitleItemView sectionTitleItemView, @NotNull SectionActionItemView sectionActionItemView) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(sectionTitleItemView, "titleItemView");
        Intrinsics.checkNotNullParameter(sectionActionItemView, "actionItemView");
        this.u = new SectionTitleWithActionViewHolder(view, sectionTitleItemView, sectionActionItemView);
        this.t = view;
        View findViewById = view.findViewById(R.id.expand_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.section.expand_sections_button.ExpandSectionsButtonItemView
    public void bindExpandButton(@Nullable String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        TextViews.bindText$default(this.s, str, false, 2, null);
        this.s.setOnClickListener(new a(function0));
        if (str != null) {
            setActionButtonVisible(false);
        }
    }

    @Override // com.avito.android.section.title.SectionTitleItemView
    public void bindSubtitle(@Nullable String str) {
        this.u.bindSubtitle(str);
    }

    @Override // com.avito.android.section.title.SectionTitleItemView
    public void bindTitle(@Nullable String str) {
        this.u.bindTitle(str);
    }

    @NotNull
    public final TextView getExpandButton() {
        return this.s;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.u.onUnbind();
    }

    @Override // com.avito.android.section.action.SectionActionItemView
    public void setActionButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "action");
        this.u.setActionButton(str, function0);
    }

    @Override // com.avito.android.section.action.SectionActionItemView
    public void setActionButtonVisible(boolean z) {
        this.u.setActionButtonVisible(z);
    }
}
