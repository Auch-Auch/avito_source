package com.avito.android.lib.design.chips;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B'\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010 \u001a\u00020\u0015\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0005¢\u0006\u0004\b3\u00104J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010)\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010(R\u001f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0013¨\u00066"}, d2 = {"Lcom/avito/android/lib/design/chips/ChipsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/lib/design/chips/ChipsAdapter$ButtonViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/lib/design/chips/ChipsAdapter$ButtonViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/android/lib/design/chips/ChipsAdapter$ButtonViewHolder;I)V", "", "Lcom/avito/android/lib/design/chips/Chipable;", "selected", "()Ljava/util/List;", "pos", "", "isSelected", "(I)Z", "itemAtPos", "(I)Lcom/avito/android/lib/design/chips/Chipable;", "Lcom/avito/android/lib/design/chips/ChipsSelectManager;", "d", "Lcom/avito/android/lib/design/chips/ChipsSelectManager;", "selectManager", "e", "Z", "isContainerEnabled", "()Z", "setContainerEnabled", "(Z)V", g.a, "I", "getUnselectedButtonAppearance", "setUnselectedButtonAppearance", "(I)V", "unselectedButtonAppearance", "f", "getSelectedButtonAppearance", "setSelectedButtonAppearance", "selectedButtonAppearance", "", "c", "Ljava/util/List;", "getData", "data", "<init>", "(Lcom/avito/android/lib/design/chips/ChipsSelectManager;ZII)V", "ButtonViewHolder", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ChipsAdapter extends RecyclerView.Adapter<ButtonViewHolder> {
    @NotNull
    public final List<Chipable> c = new ArrayList();
    public final ChipsSelectManager d;
    public boolean e;
    public int f;
    public int g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/lib/design/chips/ChipsAdapter$ButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class ButtonViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ButtonViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ChipsAdapter a;
        public final /* synthetic */ int b;

        public a(ChipsAdapter chipsAdapter, boolean z, boolean z2, int i) {
            this.a = chipsAdapter;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.d.select(this.b);
        }
    }

    public ChipsAdapter(@NotNull ChipsSelectManager chipsSelectManager, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(chipsSelectManager, "selectManager");
        this.d = chipsSelectManager;
        this.e = z;
        this.f = i;
        this.g = i2;
    }

    @NotNull
    public final List<Chipable> getData() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final int getSelectedButtonAppearance() {
        return this.f;
    }

    public final int getUnselectedButtonAppearance() {
        return this.g;
    }

    public final boolean isContainerEnabled() {
        return this.e;
    }

    public final boolean isSelected(int i) {
        return this.d.isSelected(i);
    }

    @NotNull
    public final Chipable itemAtPos(int i) {
        return this.c.get(i);
    }

    @NotNull
    public final List<Chipable> selected() {
        List<Integer> selected = this.d.selected();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(selected, 10));
        Iterator<T> it = selected.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.get(it.next().intValue()));
        }
        return arrayList;
    }

    public final void setContainerEnabled(boolean z) {
        this.e = z;
    }

    public final void setSelectedButtonAppearance(int i) {
        this.f = i;
    }

    public final void setUnselectedButtonAppearance(int i) {
        this.g = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull com.avito.android.lib.design.chips.ChipsAdapter.ButtonViewHolder r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r7.isSelected(r9)
            boolean r1 = r7.e
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0027
            com.avito.android.lib.design.chips.ChipsSelectManager r1 = r7.d
            boolean r1 = r1.isMaxSelected()
            if (r1 == 0) goto L_0x0022
            com.avito.android.lib.design.chips.ChipsSelectManager r1 = r7.d
            boolean r1 = r1.isSelected(r9)
            if (r1 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r1 = 0
            goto L_0x0023
        L_0x0022:
            r1 = 1
        L_0x0023:
            if (r1 == 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            android.view.View r8 = r8.itemView
            java.lang.String r4 = "null cannot be cast to non-null type com.avito.android.lib.design.button.Button"
            java.util.Objects.requireNonNull(r8, r4)
            com.avito.android.lib.design.button.Button r8 = (com.avito.android.lib.design.button.Button) r8
            r8.setEnabled(r1)
            r8.setSelected(r0)
            if (r0 == 0) goto L_0x003c
            int r4 = r7.f
            goto L_0x003e
        L_0x003c:
            int r4 = r7.g
        L_0x003e:
            r8.setAppearance(r4)
            java.util.List<com.avito.android.lib.design.chips.Chipable> r4 = r7.c
            java.lang.Object r4 = r4.get(r9)
            com.avito.android.lib.design.chips.Chipable r4 = (com.avito.android.lib.design.chips.Chipable) r4
            java.lang.String r4 = r4.getChipTitle()
            r8.setText(r4)
            java.util.List<com.avito.android.lib.design.chips.Chipable> r4 = r7.c
            java.lang.Object r4 = r4.get(r9)
            com.avito.android.lib.design.chips.Chipable r4 = (com.avito.android.lib.design.chips.Chipable) r4
            java.lang.Integer r4 = r4.getImageRes()
            if (r4 == 0) goto L_0x0065
            int r4 = r4.intValue()
            r8.setImageResource(r4)
        L_0x0065:
            java.util.List<com.avito.android.lib.design.chips.Chipable> r4 = r7.c
            java.lang.Object r4 = r4.get(r9)
            com.avito.android.lib.design.chips.Chipable r4 = (com.avito.android.lib.design.chips.Chipable) r4
            java.lang.Integer r4 = r4.getLeftImageRes()
            r5 = 0
            if (r4 == 0) goto L_0x007c
            int r4 = r4.intValue()
            r6 = 2
            com.avito.android.lib.design.button.Button.setImageResource$default(r8, r4, r3, r6, r5)
        L_0x007c:
            java.util.List<com.avito.android.lib.design.chips.Chipable> r4 = r7.c
            java.lang.Object r4 = r4.get(r9)
            com.avito.android.lib.design.chips.Chipable r4 = (com.avito.android.lib.design.chips.Chipable) r4
            java.lang.Integer r4 = r4.getRightImageRes()
            if (r4 == 0) goto L_0x0091
            int r4 = r4.intValue()
            com.avito.android.lib.design.button.Button.setImageResource$default(r8, r3, r4, r2, r5)
        L_0x0091:
            com.avito.android.lib.design.chips.ChipsAdapter$a r2 = new com.avito.android.lib.design.chips.ChipsAdapter$a
            r2.<init>(r7, r1, r0, r9)
            r8.setOnClickListener(r2)
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            boolean r9 = r8 instanceof com.google.android.flexbox.FlexboxLayoutManager.LayoutParams
            if (r9 == 0) goto L_0x00a8
            com.google.android.flexbox.FlexboxLayoutManager$LayoutParams r8 = (com.google.android.flexbox.FlexboxLayoutManager.LayoutParams) r8
            r9 = 1077936128(0x40400000, float:3.0)
            r8.setFlexGrow(r9)
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.chips.ChipsAdapter.onBindViewHolder(com.avito.android.lib.design.chips.ChipsAdapter$ButtonViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ButtonViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.design_button_viewholder_layout, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        return new ButtonViewHolder((Button) inflate);
    }
}
