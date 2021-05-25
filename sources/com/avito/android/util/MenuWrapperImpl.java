package com.avito.android.util;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.MenuWrapper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b#\u0010$J2\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJG\u0010\u0011\u001a\u00020\u000726\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRH\u0010\u001f\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR3\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/util/MenuWrapperImpl;", "Lcom/avito/android/util/MenuWrapper;", "Lkotlin/Function1;", "Landroid/view/MenuItem;", "Lkotlin/ParameterName;", "name", "item", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemClicked", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "inflater", "callback", "changeMenu", "(Lkotlin/jvm/functions/Function2;)V", "onCreateMenu", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "onItemClicked", "(Landroid/view/MenuItem;)V", "clear", "()V", "Landroid/app/Activity;", "c", "Landroid/app/Activity;", "activity", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function2;", "changeMenuCallback", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "itemClickedListener", "<init>", "(Landroid/app/Activity;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MenuWrapperImpl implements MenuWrapper {
    public Function1<? super MenuItem, Unit> a;
    public Function2<? super Menu, ? super MenuInflater, Unit> b;
    public final Activity c;

    public MenuWrapperImpl(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c = activity;
    }

    @Override // com.avito.android.util.MenuWrapper
    public void changeMenu(@NotNull Function2<? super Menu, ? super MenuInflater, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        this.b = function2;
        this.c.invalidateOptionsMenu();
    }

    @Override // com.avito.android.util.MenuWrapper
    public void clear() {
        this.a = null;
        this.b = null;
    }

    @Override // com.avito.android.util.MenuWrapper
    @NotNull
    public Observable<MenuItem> itemClicks() {
        return MenuWrapper.DefaultImpls.itemClicks(this);
    }

    @Override // com.avito.android.util.MenuWrapper
    public void onCreateMenu(@NotNull Menu menu, @NotNull MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        Function2<? super Menu, ? super MenuInflater, Unit> function2 = this.b;
        if (function2 != null) {
            function2.invoke(menu, menuInflater);
        }
    }

    @Override // com.avito.android.util.MenuWrapper
    public void onItemClicked(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        Function1<? super MenuItem, Unit> function1 = this.a;
        if (function1 != null) {
            function1.invoke(menuItem);
        }
    }

    @Override // com.avito.android.util.MenuWrapper
    public void setOnItemClicked(@NotNull Function1<? super MenuItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = function1;
    }
}
