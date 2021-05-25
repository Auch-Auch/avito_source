package com.avito.android.select.new_metro;

import android.content.Context;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.SelectMetroIntentFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 JQ\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/select/new_metro/SelectMetroIntentFactoryImpl;", "Lcom/avito/android/SelectMetroIntentFactory;", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "metroWithLines", "", "requestId", "", "locationId", "categoryId", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedValues", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Landroid/content/Intent;", "selectMetroIntent", "(Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;Ljava/lang/String;ILjava/lang/Integer;Ljava/util/List;Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/CoreActivityIntentFactory;", "c", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Landroid/content/Context;Lcom/avito/android/Features;Lcom/avito/android/CoreActivityIntentFactory;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroIntentFactoryImpl implements SelectMetroIntentFactory {
    @NotNull
    public final Context a;
    public final Features b;
    public final CoreActivityIntentFactory c;

    @Inject
    public SelectMetroIntentFactoryImpl(@NotNull Context context, @NotNull Features features, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = context;
        this.b = features;
        this.c = coreActivityIntentFactory;
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }

    @Override // com.avito.android.SelectMetroIntentFactory
    @NotNull
    public Intent selectMetroIntent(@Nullable MetroResponseBody metroResponseBody, @NotNull String str, int i, @Nullable Integer num, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable NavigationTab navigationTab) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedValues");
        SelectMetroParams selectMetroParams = new SelectMetroParams(metroResponseBody, str, i, num, list);
        if (!this.b.getSelectMetroWithoutActivity().invoke().booleanValue() || navigationTab == null) {
            return SelectMetroActivityKt.createSelectMetroActivityIntent(this.a, selectMetroParams);
        }
        return this.c.mainScreenWithTab(new SelectMetroFragmentData(selectMetroParams, navigationTab));
    }
}
