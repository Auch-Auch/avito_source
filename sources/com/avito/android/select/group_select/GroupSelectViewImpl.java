package com.avito.android.select.group_select;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.R;
import com.avito.android.select.group_select.SelectableView;
import com.avito.android.util.ViewGroupsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010 J5\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectViewImpl;", "Lcom/avito/android/select/group_select/GroupSelectView;", "", "title", "", "isSelected", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addSelectOption", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/select/group_select/GroupSelectItemViewPresenter;", "presenter", "addSelectGroup", "(Lcom/avito/android/select/group_select/GroupSelectItemViewPresenter;)V", "Lkotlin/Function0;", "setApplyListener", "(Lkotlin/jvm/functions/Function0;)V", "clearSelection", "()V", "Landroid/view/View;", "c", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "applyButton", AuthSource.SEND_ABUSE, "container", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectViewImpl implements GroupSelectView {
    public final ViewGroup a;
    public final ViewGroup b;
    public final View c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    public GroupSelectViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = view;
        this.a = (ViewGroup) view.findViewById(R.id.options_container);
        this.b = (ViewGroup) view.findViewById(R.id.apply_button);
    }

    @Override // com.avito.android.select.group_select.GroupSelectView
    public void addSelectGroup(@NotNull GroupSelectItemViewPresenter groupSelectItemViewPresenter) {
        Intrinsics.checkNotNullParameter(groupSelectItemViewPresenter, "presenter");
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        GroupSelectItemViewImpl groupSelectItemViewImpl = new GroupSelectItemViewImpl(context);
        groupSelectItemViewPresenter.bindView(groupSelectItemViewImpl);
        this.a.addView(groupSelectItemViewImpl);
    }

    @Override // com.avito.android.select.group_select.GroupSelectView
    public void addSelectOption(@NotNull String str, boolean z, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "title");
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        GroupSelectOption groupSelectOption = new GroupSelectOption(context);
        groupSelectOption.setTitle(str);
        groupSelectOption.select(z, false);
        groupSelectOption.setSelectionListener(function1);
        this.a.addView(groupSelectOption);
    }

    @Override // com.avito.android.select.group_select.GroupSelectView
    public void clearSelection() {
        ViewGroup viewGroup = this.a;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "container");
        Iterator<View> children = ViewGroupsKt.getChildren(viewGroup);
        while (children.hasNext()) {
            View next = children.next();
            if (next instanceof SelectableView) {
                SelectableView.DefaultImpls.select$default((SelectableView) next, false, false, 2, null);
            }
        }
    }

    @Override // com.avito.android.select.group_select.GroupSelectView
    public void setApplyListener(@Nullable Function0<Unit> function0) {
        this.b.setOnClickListener(new a(function0));
    }
}
