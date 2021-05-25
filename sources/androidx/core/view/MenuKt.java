package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\u000f\u0010\u000e\u001a7\u0010\u0014\u001a\u00020\n*\u00020\u00002!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0010H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001aL\u0010\u0017\u001a\u00020\n*\u00020\u000026\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0016H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019*\u00020\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\"\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0018\u0010\"\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroid/view/Menu;", "", FirebaseAnalytics.Param.INDEX, "Landroid/view/MenuItem;", "get", "(Landroid/view/Menu;I)Landroid/view/MenuItem;", "item", "", "contains", "(Landroid/view/Menu;Landroid/view/MenuItem;)Z", "", "minusAssign", "(Landroid/view/Menu;Landroid/view/MenuItem;)V", "isEmpty", "(Landroid/view/Menu;)Z", "isNotEmpty", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroid/view/Menu;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "forEachIndexed", "(Landroid/view/Menu;Lkotlin/jvm/functions/Function2;)V", "", "iterator", "(Landroid/view/Menu;)Ljava/util/Iterator;", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "children", "getSize", "(Landroid/view/Menu;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class MenuKt {
    public static final boolean contains(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$contains");
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu menu, @NotNull Function1<? super MenuItem, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            function1.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull Menu menu, @NotNull Function2<? super Integer, ? super MenuItem, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            Integer valueOf = Integer.valueOf(i);
            MenuItem item = menu.getItem(i);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
            function2.invoke(valueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu menu, int i) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$get");
        MenuItem item = menu.getItem(i);
        Intrinsics.checkExpressionValueIsNotNull(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final Sequence<MenuItem> getChildren(@NotNull Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$children");
        return new Sequence<MenuItem>(menu) { // from class: androidx.core.view.MenuKt$children$1
            public final /* synthetic */ Menu a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(this.a);
            }
        };
    }

    public static final int getSize(@NotNull Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$size");
        return menu.size();
    }

    public static final boolean isEmpty(@NotNull Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$isEmpty");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$isNotEmpty");
        return menu.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$iterator");
        return new Object(menu) { // from class: androidx.core.view.MenuKt$iterator$1
            public int a;
            public final /* synthetic */ Menu b;

            {
                this.b = r1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < this.b.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                Menu menu2 = this.b;
                int i = this.a - 1;
                this.a = i;
                menu2.removeItem(i);
            }

            @Override // java.util.Iterator
            @NotNull
            public MenuItem next() {
                Menu menu2 = this.b;
                int i = this.a;
                this.a = i + 1;
                MenuItem item = menu2.getItem(i);
                if (item != null) {
                    return item;
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    public static final void minusAssign(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menu, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
