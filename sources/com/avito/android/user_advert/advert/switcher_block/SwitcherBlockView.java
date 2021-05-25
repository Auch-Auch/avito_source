package com.avito.android.user_advert.advert.switcher_block;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.lib.design.list_item.CompoundButtonListItem;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.user_advert.advert.switcher_block.SwitcherState;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\u00028\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockView;", "", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "getSwitcher", "()Lcom/avito/android/lib/design/list_item/SwitcherListItem;", "switcher", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModel;", "c", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModel;", "viewModel", "Landroid/view/ViewGroup;", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "containerView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "d", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/View;", "view", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "containerViewId", "switcherViewId", "<init>", "(Landroid/view/View;Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModel;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/util/text/AttributedTextFormatter;II)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public class SwitcherBlockView {
    public final ViewGroup a;
    @NotNull
    public final SwitcherListItem b;
    public final SwitcherBlockViewModel c;
    public final AttributedTextFormatter d;

    public static final class a<T> implements Observer<String> {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(String str) {
            String str2 = str;
            boolean z = false;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                View view = this.a;
                Intrinsics.checkNotNull(str2);
                Views.showSnackBar$default(view, str2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
            }
        }
    }

    public static final class b<T> implements Observer<SwitcherInfo> {
        public final /* synthetic */ SwitcherBlockView a;

        public b(SwitcherBlockView switcherBlockView) {
            this.a = switcherBlockView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(SwitcherInfo switcherInfo) {
            SwitcherInfo switcherInfo2 = switcherInfo;
            SwitcherBlockView.access$setupSwitcher(this.a);
            SwitcherBlockView.access$setTitleAndSubtitle(this.a, switcherInfo2.getTitle(), switcherInfo2.getSubtitle());
        }
    }

    public static final class c<T> implements Observer<SwitcherState> {
        public final /* synthetic */ SwitcherBlockView a;

        public c(SwitcherBlockView switcherBlockView) {
            this.a = switcherBlockView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(SwitcherState switcherState) {
            SwitcherState switcherState2 = switcherState;
            if (Intrinsics.areEqual(switcherState2, SwitcherState.Progress.INSTANCE)) {
                this.a.getSwitcher().setLoading(true);
            } else if (switcherState2 instanceof SwitcherState.Specified) {
                this.a.getSwitcher().setLoading(false);
                this.a.getSwitcher().setChecked(((SwitcherState.Specified) switcherState2).isChecked());
            } else if (switcherState2 instanceof SwitcherState.Warning) {
                this.a.getSwitcher().setLoading(true);
                Dialog.Companion.create$default(Dialog.Companion, this.a.getSwitcher().getContext(), 0, 0, ((SwitcherState.Warning) switcherState2).getConfig(), 6, null).show();
            }
        }
    }

    public SwitcherBlockView(@NotNull View view, @NotNull SwitcherBlockViewModel switcherBlockViewModel, @NotNull LifecycleOwner lifecycleOwner, @NotNull AttributedTextFormatter attributedTextFormatter, @IdRes int i, @IdRes int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(switcherBlockViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.c = switcherBlockViewModel;
        this.d = attributedTextFormatter;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.a = viewGroup;
        View findViewById2 = viewGroup.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.list_item.SwitcherListItem");
        this.b = (SwitcherListItem) findViewById2;
        switcherBlockViewModel.getErrors().removeObservers(lifecycleOwner);
        switcherBlockViewModel.getErrors().observe(lifecycleOwner, new a(view));
        switcherBlockViewModel.getDataChanges().removeObservers(lifecycleOwner);
        switcherBlockViewModel.getDataChanges().observe(lifecycleOwner, new b(this));
        switcherBlockViewModel.getSwitcherState().removeObservers(lifecycleOwner);
        switcherBlockViewModel.getSwitcherState().observe(lifecycleOwner, new c(this));
    }

    public static final void access$setTitleAndSubtitle(SwitcherBlockView switcherBlockView, String str, AttributedText attributedText) {
        SwitcherListItem switcherListItem = switcherBlockView.b;
        switcherListItem.setTitle(str);
        AttributedTextFormatter attributedTextFormatter = switcherBlockView.d;
        Context context = switcherBlockView.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        switcherListItem.setLink(attributedTextFormatter.format(context, attributedText));
        MovementMethod instance = LinkMovementMethod.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "LinkMovementMethod.getInstance()");
        switcherListItem.setLinkMovementMethod(instance);
    }

    public static final void access$setupSwitcher(SwitcherBlockView switcherBlockView) {
        switcherBlockView.b.addOnCheckedChangeListener(new CompoundButtonListItem.OnCheckedChangeListener() { // from class: com.avito.android.user_advert.advert.switcher_block.SwitcherBlockView$setupSwitcher$1
            @Override // com.avito.android.lib.design.list_item.CompoundButtonListItem.OnCheckedChangeListener
            public void onCheckedChanged(@NotNull CompoundButtonListItem compoundButtonListItem, boolean z) {
                Intrinsics.checkNotNullParameter(compoundButtonListItem, "view");
                SwitcherBlockView.this.c.onSwitchChanged(SwitcherBlockView.this.getSwitcher().isChecked());
            }
        });
        Views.setVisible(switcherBlockView.a, true);
    }

    @NotNull
    public final SwitcherListItem getSwitcher() {
        return this.b;
    }
}
