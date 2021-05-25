package com.avito.android.lib.design.picker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B!\u0012\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0 \u0012\u0006\u0010\u001f\u001a\u00020\u001a¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\u00020\u000b*\u00020\u0010H\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0 8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/avito/android/lib/design/picker/WheelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/lib/design/picker/WheelAdapter$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/lib/design/picker/WheelAdapter$ViewHolder;", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/android/lib/design/picker/WheelAdapter$ViewHolder;I)V", "getItemCount", "()I", "Landroid/view/View;", AuthSource.SEND_ABUSE, "(Landroid/view/View;)V", "", "c", "Z", "isCycled", "()Z", "setCycled", "(Z)V", "Lcom/avito/android/lib/design/picker/WheelStyle;", "e", "Lcom/avito/android/lib/design/picker/WheelStyle;", "getWheelStyle", "()Lcom/avito/android/lib/design/picker/WheelStyle;", "wheelStyle", "", "Lcom/avito/android/lib/design/picker/WheelData;", "d", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "items", "<init>", "(Ljava/util/List;Lcom/avito/android/lib/design/picker/WheelStyle;)V", "ViewHolder", "components_release"}, k = 1, mv = {1, 4, 2})
public final class WheelAdapter extends RecyclerView.Adapter<ViewHolder> {
    public boolean c = true;
    @NotNull
    public final List<WheelData<?>> d;
    @NotNull
    public final WheelStyle e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/lib/design/picker/WheelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "t", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "text", "<init>", "(Landroid/view/View;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public final TextView s;
        @NotNull
        public final View t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.t = view;
            View findViewById = view.findViewById(R.id.text);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.s = (TextView) findViewById;
        }

        @NotNull
        public final TextView getText() {
            return this.s;
        }

        @NotNull
        public final View getView() {
            return this.t;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WheelGravity.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[0] = 2;
            iArr[1] = 3;
            WheelGravity.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[2] = 1;
            iArr2[0] = 2;
            iArr2[1] = 3;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.lib.design.picker.WheelData<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public WheelAdapter(@NotNull List<? extends WheelData<?>> list, @NotNull WheelStyle wheelStyle) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(wheelStyle, "wheelStyle");
        this.d = list;
        this.e = wheelStyle;
    }

    @SuppressLint({"RtlHardcoded"})
    public final void a(View view) {
        int i;
        int ordinal = this.e.getTextPositon().ordinal();
        if (ordinal == 0) {
            i = 19;
        } else if (ordinal == 1) {
            i = 21;
        } else if (ordinal == 2) {
            i = 17;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = i;
        view.setLayoutParams(layoutParams2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.c) {
            return 50000;
        }
        return this.d.size() + 6;
    }

    @NotNull
    public final List<WheelData<?>> getItems() {
        return this.d;
    }

    @NotNull
    public final WheelStyle getWheelStyle() {
        return this.e;
    }

    public final boolean isCycled() {
        return this.c;
    }

    public final void setCycled(boolean z) {
        this.c = z;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        a(viewHolder.getText());
        if (this.c) {
            List<WheelData<?>> list = this.d;
            str = list.get(i % list.size()).getName();
        } else {
            str = (i < 3 || i > this.d.size() + 2) ? " " : this.d.get(i - 3).getName();
        }
        viewHolder.getText().setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_picker_wheel_item, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        ViewHolder viewHolder = new ViewHolder((FrameLayout) inflate);
        TextView text = viewHolder.getText();
        int ordinal = this.e.getTextPositon().ordinal();
        int i2 = 2;
        if (ordinal != 0) {
            if (ordinal == 1) {
                i2 = 3;
            } else if (ordinal == 2) {
                i2 = 4;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        text.setTextAlignment(i2);
        a(viewHolder.getText());
        return viewHolder;
    }
}
