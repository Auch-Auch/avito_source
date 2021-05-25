package com.avito.android.serp.adapter.empty_placeholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0019\u001a\n \u0012*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010#\u001a\n \u0012*\u0004\u0018\u00010 0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemViewImpl;", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "", "Lcom/avito/android/serp/adapter/empty_placeholder/EmptyPlaceholderItemView$Action;", "actions", "setActions", "(Ljava/util/List;)V", "clearActionListeners", "()V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "textTitle", "Landroid/view/LayoutInflater;", "w", "Landroid/view/LayoutInflater;", "inflater", "t", "textSubtitle", "", VKApiConst.VERSION, "Ljava/util/List;", "actionViews", "Landroid/widget/LinearLayout;", "u", "Landroid/widget/LinearLayout;", "actionsContainer", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyPlaceholderItemViewImpl extends BaseViewHolder implements EmptyPlaceholderItemView {
    public final TextView s;
    public final TextView t;
    public final LinearLayout u;
    public final List<TextView> v = new ArrayList();
    public final LayoutInflater w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ EmptyPlaceholderItemView.Action a;

        public a(EmptyPlaceholderItemView.Action action) {
            this.a = action;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> listener = this.a.getListener();
            if (listener != null) {
                listener.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyPlaceholderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.subtitle);
        this.u = (LinearLayout) view.findViewById(R.id.actions_container);
        this.w = LayoutInflater.from(view.getContext());
    }

    @Override // com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView
    public void clearActionListeners() {
        Iterator<T> it = this.v.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(null);
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        EmptyPlaceholderItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView
    public void setActions(@NotNull List<EmptyPlaceholderItemView.Action> list) {
        int lastIndex;
        int size;
        Intrinsics.checkNotNullParameter(list, "actions");
        if (this.v.size() < list.size()) {
            int size2 = list.size();
            for (int size3 = this.v.size(); size3 < size2; size3++) {
                View inflate = this.w.inflate(R.layout.advert_item_empty_button, (ViewGroup) this.u, false);
                List<TextView> list2 = this.v;
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                list2.add((TextView) inflate);
                this.u.addView(inflate);
            }
        }
        if (list.size() < this.v.size() && (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.v)) >= (size = list.size())) {
            while (true) {
                this.u.removeView(this.v.remove(lastIndex));
                if (lastIndex == size) {
                    break;
                }
                lastIndex--;
            }
        }
        int size4 = list.size();
        for (int i = 0; i < size4; i++) {
            TextView textView = this.v.get(i);
            EmptyPlaceholderItemView.Action action = list.get(i);
            textView.setText(action.getText());
            textView.setOnClickListener(new a(action));
        }
    }

    @Override // com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView
    public void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "textSubtitle");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.serp.adapter.empty_placeholder.EmptyPlaceholderItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "textTitle");
        textView.setText(str);
    }
}
