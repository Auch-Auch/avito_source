package com.avito.android.lib.design.chips;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010-\u001a\u00020&\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0017\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0017\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013\u0012\b\b\u0002\u00105\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\b\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u00048\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00048B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0012R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010-\u001a\u00020&8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0019R*\u00105\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00028\u0016@VX\u000e¢\u0006\u0012\n\u0004\b!\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\t¨\u00068"}, d2 = {"Lcom/avito/android/lib/design/chips/ChipsSelectManagerImpl;", "Lcom/avito/android/lib/design/chips/ChipsSelectManager;", "", VKApiConst.POSITION, "", "isSelected", "(I)Z", "", "select", "(I)V", "", "selected", "()Ljava/util/List;", "", "positions", "(Ljava/util/Collection;)V", "clearSelected", "isMaxSelected", "()Z", "Lkotlin/Function0;", g.a, "Lkotlin/jvm/functions/Function0;", "onMaxSelectedStateChanged", "Lkotlin/Function1;", "f", "Lkotlin/jvm/functions/Function1;", "unSelectCallback", "d", "Z", "getKeepLastSelected", "setKeepLastSelected", "(Z)V", "keepLastSelected", AuthSource.SEND_ABUSE, "keepSelected", "", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "Lcom/avito/android/lib/design/chips/SelectStrategy;", "c", "Lcom/avito/android/lib/design/chips/SelectStrategy;", "getSelectStrategy", "()Lcom/avito/android/lib/design/chips/SelectStrategy;", "setSelectStrategy", "(Lcom/avito/android/lib/design/chips/SelectStrategy;)V", "selectStrategy", "e", "selectCallback", "value", "I", "getMaxSelected", "()I", "setMaxSelected", "maxSelected", "<init>", "(Lcom/avito/android/lib/design/chips/SelectStrategy;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ChipsSelectManagerImpl implements ChipsSelectManager {
    public int a;
    public final Set<Integer> b;
    @NotNull
    public SelectStrategy c;
    public boolean d;
    public final Function1<Integer, Unit> e;
    public final Function1<Integer, Unit> f;
    public final Function0<Unit> g;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChipsSelectManagerImpl(@NotNull SelectStrategy selectStrategy, boolean z, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super Integer, Unit> function12, @NotNull Function0<Unit> function0, int i) {
        Intrinsics.checkNotNullParameter(selectStrategy, "selectStrategy");
        Intrinsics.checkNotNullParameter(function1, "selectCallback");
        Intrinsics.checkNotNullParameter(function12, "unSelectCallback");
        Intrinsics.checkNotNullParameter(function0, "onMaxSelectedStateChanged");
        this.c = selectStrategy;
        this.d = z;
        this.e = function1;
        this.f = function12;
        this.g = function0;
        this.a = i;
        this.b = new LinkedHashSet();
    }

    public final boolean a() {
        return this.b.size() == 1 && getKeepLastSelected();
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    @NotNull
    public List<Integer> clearSelected() {
        List<Integer> list = CollectionsKt___CollectionsKt.toList(this.b);
        this.b.clear();
        return list;
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public boolean getKeepLastSelected() {
        return this.d;
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public int getMaxSelected() {
        return this.a;
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    @NotNull
    public SelectStrategy getSelectStrategy() {
        return this.c;
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public boolean isMaxSelected() {
        return getMaxSelected() != -1 && this.b.size() == getMaxSelected();
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public boolean isSelected(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public void select(int i) {
        if (!isSelected(i)) {
            if (getSelectStrategy() == SelectStrategy.SINGLE) {
                Integer num = (Integer) CollectionsKt___CollectionsKt.firstOrNull(this.b);
                if (num != null) {
                    this.f.invoke(Integer.valueOf(num.intValue()));
                }
                this.b.clear();
            }
            this.b.add(Integer.valueOf(i));
            this.e.invoke(Integer.valueOf(i));
            if (this.b.size() == getMaxSelected()) {
                this.g.invoke();
            }
        } else if (!a()) {
            if (this.b.size() == getMaxSelected()) {
                this.g.invoke();
            }
            this.b.remove(Integer.valueOf(i));
            this.f.invoke(Integer.valueOf(i));
        }
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    @NotNull
    public List<Integer> selected() {
        return CollectionsKt___CollectionsKt.toList(this.b);
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public void setKeepLastSelected(boolean z) {
        this.d = z;
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public void setMaxSelected(int i) {
        this.a = i;
        if (getMaxSelected() != -1 && this.b.size() > getMaxSelected()) {
            int size = this.b.size();
            for (int maxSelected = getMaxSelected(); maxSelected < size; maxSelected++) {
                this.b.remove(Integer.valueOf(maxSelected));
            }
        }
        this.g.invoke();
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public void setSelectStrategy(@NotNull SelectStrategy selectStrategy) {
        Intrinsics.checkNotNullParameter(selectStrategy, "<set-?>");
        this.c = selectStrategy;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChipsSelectManagerImpl(SelectStrategy selectStrategy, boolean z, Function1 function1, Function1 function12, Function0 function0, int i, int i2, j jVar) {
        this(selectStrategy, z, function1, function12, function0, (i2 & 32) != 0 ? -1 : i);
    }

    @Override // com.avito.android.lib.design.chips.ChipsSelectManager
    public void select(@NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "positions");
        if ((getSelectStrategy() == SelectStrategy.SINGLE) && collection.size() > 1) {
            throw new IllegalStateException("Attempt to select more than one chip with single strategy.");
        } else if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (!isSelected(intValue)) {
                    this.b.add(Integer.valueOf(intValue));
                } else if (!a()) {
                    this.b.remove(Integer.valueOf(intValue));
                }
            }
        }
    }
}
