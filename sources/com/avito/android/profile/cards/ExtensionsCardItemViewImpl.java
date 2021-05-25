package com.avito.android.profile.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.profile.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J%\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001e\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/profile/cards/ExtensionsCardItemViewImpl;", "Lcom/avito/android/profile/cards/ExtensionsCardItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "text", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addActionButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "addExtensionInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "onUnbind", "()V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "descriptionView", "t", "titleView", "Landroid/widget/LinearLayout;", VKApiConst.VERSION, "Landroid/widget/LinearLayout;", "extensionsContainer", "w", "actionsContainer", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtensionsCardItemViewImpl extends BaseViewHolder implements ExtensionsCardItemView {
    public final LayoutInflater s;
    public final TextView t;
    public final TextView u;
    public final LinearLayout v;
    public final LinearLayout w;

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
    public ExtensionsCardItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.s = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.extensions_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.v = (LinearLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.actions_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.w = (LinearLayout) findViewById4;
    }

    @Override // com.avito.android.profile.cards.ExtensionsCardItemView
    public void addActionButton(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        View inflate = this.s.inflate(R.layout.user_profile_action, (ViewGroup) this.w, false);
        TextView textView = (TextView) inflate.findViewById(R.id.action_text);
        Intrinsics.checkNotNullExpressionValue(textView, "actionTitle");
        textView.setText(str);
        textView.setOnClickListener(new a(function0));
        this.w.addView(inflate);
    }

    @Override // com.avito.android.profile.cards.ExtensionsCardItemView
    public void addExtensionInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        View inflate = this.s.inflate(R.layout.user_profile_extension, (ViewGroup) this.v, false);
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(textView, "extensionTitle");
        textView.setText(str);
        Intrinsics.checkNotNullExpressionValue(textView2, "extensionDescription");
        textView2.setText(str2);
        this.v.addView(inflate);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.v.removeAllViews();
        this.w.removeAllViews();
    }

    @Override // com.avito.android.profile.cards.ExtensionsCardItemView
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.profile.cards.ExtensionsCardItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }
}
