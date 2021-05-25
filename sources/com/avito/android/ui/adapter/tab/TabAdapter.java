package com.avito.android.ui.adapter.tab;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.TabItemView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B'\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000+\u0012\u0006\u00102\u001a\u000201\u0012\b\b\u0001\u0010!\u001a\u00020\u0010¢\u0006\u0004\b3\u00104J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\tJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u001a\u001a\u00028\u0000H&¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010&\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000+8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/avito/android/ui/adapter/tab/TabAdapter;", "T", "Lcom/avito/android/ui/adapter/tab/TabItemView;", "TIV", "", "Landroid/database/DataSetObserver;", "observer", "", "registerDataSetObserver", "(Landroid/database/DataSetObserver;)V", "unregisterDataSetObserver", "unregisterAllObservers", "()V", "notifyDataSetChanged", "notifyDataSetInvalidated", "view", "", VKApiConst.POSITION, "updateItem", "(Lcom/avito/android/ui/adapter/tab/TabItemView;I)Lcom/avito/android/ui/adapter/tab/TabItemView;", "getItem", "(I)Lcom/avito/android/ui/adapter/tab/TabItemView;", "Landroid/view/View;", "createTabItemView", "(Landroid/view/View;)Lcom/avito/android/ui/adapter/tab/TabItemView;", "tabItemView", "item", "bind", "(Lcom/avito/android/ui/adapter/tab/TabItemView;Ljava/lang/Object;)V", "getCount", "()I", "d", "I", "itemLayoutRes", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/database/DataSetObservable;", AuthSource.BOOKING_ORDER, "Landroid/database/DataSetObservable;", "dataSetObservable", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "c", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "getTabs", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroid/content/Context;", "context", "<init>", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/content/Context;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class TabAdapter<T, TIV extends TabItemView> {
    public final LayoutInflater a;
    public final DataSetObservable b = new DataSetObservable();
    @NotNull
    public final TabsDataProvider<T> c;
    public final int d;

    public TabAdapter(@NotNull TabsDataProvider<T> tabsDataProvider, @NotNull Context context, @LayoutRes int i) {
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = tabsDataProvider;
        this.d = i;
        this.a = LayoutInflater.from(context);
    }

    public abstract void bind(@NotNull TIV tiv, T t);

    @NotNull
    public abstract TIV createTabItemView(@NotNull View view);

    public final int getCount() {
        return this.c.getCount();
    }

    @NotNull
    public final TIV getItem(int i) {
        T item = this.c.getItem(i);
        View inflate = this.a.inflate(this.d, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        TIV createTabItemView = createTabItemView(inflate);
        bind(createTabItemView, item);
        return createTabItemView;
    }

    @NotNull
    public final TabsDataProvider<T> getTabs() {
        return this.c;
    }

    public final void notifyDataSetChanged() {
        this.b.notifyChanged();
    }

    public final void notifyDataSetInvalidated() {
        this.b.notifyInvalidated();
    }

    public final void registerDataSetObserver(@NotNull DataSetObserver dataSetObserver) {
        Intrinsics.checkNotNullParameter(dataSetObserver, "observer");
        this.b.registerObserver(dataSetObserver);
    }

    public final void unregisterAllObservers() {
        this.b.unregisterAll();
    }

    public final void unregisterDataSetObserver(@NotNull DataSetObserver dataSetObserver) {
        Intrinsics.checkNotNullParameter(dataSetObserver, "observer");
        this.b.unregisterObserver(dataSetObserver);
    }

    @NotNull
    public TabItemView updateItem(@NotNull TabItemView tabItemView, int i) {
        Intrinsics.checkNotNullParameter(tabItemView, "view");
        return getItem(i);
    }
}
