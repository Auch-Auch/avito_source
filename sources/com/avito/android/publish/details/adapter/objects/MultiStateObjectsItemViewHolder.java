package com.avito.android.publish.details.adapter.objects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.publish.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "tag", "setTag", "clearItems", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "appendAddMoreButton", "(Lkotlin/jvm/functions/Function0;)V", "text", "clickListener", "addItem", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "t", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateObjectsItemViewHolder extends BaseViewHolder implements MultiStateObjectsItemView {
    public final LayoutInflater s;
    public final ComponentContainer t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(MultiStateObjectsItemViewHolder multiStateObjectsItemViewHolder, String str, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(MultiStateObjectsItemViewHolder multiStateObjectsItemViewHolder, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStateObjectsItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.objects_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.t = (ComponentContainer) findViewById;
    }

    @Override // com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemView
    public void addItem(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        View inflate = this.s.inflate(R.layout.objects_item_select_view, (ViewGroup) this.t, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) inflate;
        Input.setText$default(input, str, false, 2, null);
        input.setOnClickListener(new a(this, str, function0));
        this.t.addView(inflate, -1, input.getLayoutParams());
    }

    @Override // com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemView
    public void appendAddMoreButton(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        View inflate = this.s.inflate(R.layout.objects_item_add_more_view, (ViewGroup) this.t, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) inflate;
        input.setOnClickListener(new b(this, function0));
        this.t.addView(inflate, -1, input.getLayoutParams());
    }

    @Override // com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemView
    public void clearItems() {
        this.t.removeAllViews();
    }

    @Override // com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemView
    public void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.t.setTag(str);
    }

    @Override // com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemView
    public void setTitle(@Nullable String str) {
        this.t.setTitle(str);
    }
}
