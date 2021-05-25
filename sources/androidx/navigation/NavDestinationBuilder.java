package androidx.navigation;

import androidx.annotation.IdRes;
import androidx.navigation.NavDestination;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@NavDestinationDsl
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B!\u0012\u000e\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u000001\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b7\u00108J.\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001c\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020.0%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010(R$\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u0000018\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/NavDestination;", "D", "", "", "name", "Lkotlin/Function1;", "Landroidx/navigation/NavArgumentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "argumentBuilder", "argument", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "uriPattern", "deepLink", "(Ljava/lang/String;)V", "", "actionId", "Landroidx/navigation/NavActionBuilder;", "actionBuilder", "action", "(ILkotlin/jvm/functions/Function1;)V", "build", "()Landroidx/navigation/NavDestination;", "f", "I", "getId", "()I", "id", "", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "label", "", "Landroidx/navigation/NavArgument;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "arguments", "", "c", "Ljava/util/List;", "deepLinks", "Landroidx/navigation/NavAction;", "d", "actions", "Landroidx/navigation/Navigator;", "e", "Landroidx/navigation/Navigator;", "getNavigator", "()Landroidx/navigation/Navigator;", "navigator", "<init>", "(Landroidx/navigation/Navigator;I)V", "navigation-common-ktx_release"}, k = 1, mv = {1, 4, 0})
public class NavDestinationBuilder<D extends NavDestination> {
    @Nullable
    public CharSequence a;
    public Map<String, NavArgument> b = new LinkedHashMap();
    public List<String> c = new ArrayList();
    public Map<Integer, NavAction> d = new LinkedHashMap();
    @NotNull
    public final Navigator<? extends D> e;
    public final int f;

    public NavDestinationBuilder(@NotNull Navigator<? extends D> navigator, @IdRes int i) {
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        this.e = navigator;
        this.f = i;
    }

    public final void action(int i, @NotNull Function1<? super NavActionBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "actionBuilder");
        Map<Integer, NavAction> map = this.d;
        Integer valueOf = Integer.valueOf(i);
        NavActionBuilder navActionBuilder = new NavActionBuilder();
        function1.invoke(navActionBuilder);
        map.put(valueOf, navActionBuilder.build$navigation_common_ktx_release());
    }

    public final void argument(@NotNull String str, @NotNull Function1<? super NavArgumentBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(function1, "argumentBuilder");
        Map<String, NavArgument> map = this.b;
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        function1.invoke(navArgumentBuilder);
        map.put(str, navArgumentBuilder.build());
    }

    @NotNull
    public D build() {
        D d2 = (D) this.e.createDestination();
        d2.setId(this.f);
        d2.setLabel(this.a);
        for (Map.Entry<String, NavArgument> entry : this.b.entrySet()) {
            d2.addArgument(entry.getKey(), entry.getValue());
        }
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            d2.addDeepLink(it.next());
        }
        for (Map.Entry<Integer, NavAction> entry2 : this.d.entrySet()) {
            d2.putAction(entry2.getKey().intValue(), entry2.getValue());
        }
        return d2;
    }

    public final void deepLink(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "uriPattern");
        this.c.add(str);
    }

    public final int getId() {
        return this.f;
    }

    @Nullable
    public final CharSequence getLabel() {
        return this.a;
    }

    @NotNull
    public final Navigator<? extends D> getNavigator() {
        return this.e;
    }

    public final void setLabel(@Nullable CharSequence charSequence) {
        this.a = charSequence;
    }
}
