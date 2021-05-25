package com.avito.android.publish.start_publish;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.publish.R;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.events.AddItemEvent;
import com.avito.android.publish.start_publish.blueprint.CategoryShortcutItemPresenter;
import com.avito.android.publish.start_publish.di.DaggerStartPublishSheetComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.util.AdapterPresentersKt;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002>?B-\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u00101\u001a\u00020.\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000402¢\u0006\u0004\b<\u0010=J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010!\u001a\u0006\u0012\u0002\b\u00030 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u0004028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006@"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishSheet;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;", "data", "setData", "(Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;)V", "Lcom/avito/android/publish/start_publish/StartPublishSheet$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/start_publish/StartPublishSheet$Router;)V", "u", "Lcom/avito/android/publish/start_publish/StartPublishSheet$Router;", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "t", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "categoryShortcutItemPresenter", "Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "getCategoryShortcutItemPresenter", "()Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;", "setCategoryShortcutItemPresenter", "(Lcom/avito/android/publish/start_publish/blueprint/CategoryShortcutItemPresenter;)V", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "w", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "eventTracker", "Lkotlin/Function0;", "x", "Lkotlin/jvm/functions/Function0;", "onDismissCallback", "Lcom/avito/android/analytics/Analytics;", VKApiConst.VERSION, "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/publish/analytics/PublishEventTracker;Lkotlin/jvm/functions/Function0;)V", "Router", "SheetData", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StartPublishSheet extends BottomSheetDialog {
    @Inject
    public RecyclerView.Adapter<?> adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public CategoryShortcutItemPresenter categoryShortcutItemPresenter;
    public RecyclerView s;
    public final CompositeDisposable t = new CompositeDisposable();
    public Router u;
    public final Analytics v;
    public final PublishEventTracker w;
    public final Function0<Unit> x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishSheet$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        @Override // com.avito.android.dialog.DialogWithDeeplinkActionsRouter
        void openDeepLink(@NotNull DeepLink deepLink);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;", "", "", "Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;", "component1", "()Ljava/util/List;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "copy", "(Ljava/util/List;)Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getShortcuts", "<init>", "(Ljava/util/List;)V", "CategoryShortcutItem", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class SheetData {
        @NotNull
        public final List<CategoryShortcutItem> a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Navigation;", "component2", "()Lcom/avito/android/remote/model/Navigation;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "navigation", "deeplink", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/publish/start_publish/StartPublishSheet$SheetData$CategoryShortcutItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "stringId", AuthSource.BOOKING_ORDER, "getTitle", "c", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/deep_linking/links/DeepLink;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
        public static final class CategoryShortcutItem implements Item {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final Navigation c;
            @NotNull
            public final DeepLink d;

            public CategoryShortcutItem(@NotNull String str, @NotNull Navigation navigation, @NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(navigation, "navigation");
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                this.b = str;
                this.c = navigation;
                this.d = deepLink;
                this.a = navigation.toString();
            }

            public static /* synthetic */ CategoryShortcutItem copy$default(CategoryShortcutItem categoryShortcutItem, String str, Navigation navigation, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = categoryShortcutItem.b;
                }
                if ((i & 2) != 0) {
                    navigation = categoryShortcutItem.c;
                }
                if ((i & 4) != 0) {
                    deepLink = categoryShortcutItem.d;
                }
                return categoryShortcutItem.copy(str, navigation, deepLink);
            }

            @NotNull
            public final String component1() {
                return this.b;
            }

            @NotNull
            public final Navigation component2() {
                return this.c;
            }

            @NotNull
            public final DeepLink component3() {
                return this.d;
            }

            @NotNull
            public final CategoryShortcutItem copy(@NotNull String str, @NotNull Navigation navigation, @NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(navigation, "navigation");
                Intrinsics.checkNotNullParameter(deepLink, "deeplink");
                return new CategoryShortcutItem(str, navigation, deepLink);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CategoryShortcutItem)) {
                    return false;
                }
                CategoryShortcutItem categoryShortcutItem = (CategoryShortcutItem) obj;
                return Intrinsics.areEqual(this.b, categoryShortcutItem.b) && Intrinsics.areEqual(this.c, categoryShortcutItem.c) && Intrinsics.areEqual(this.d, categoryShortcutItem.d);
            }

            @NotNull
            public final DeepLink getDeeplink() {
                return this.d;
            }

            @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
            public long getId() {
                return Item.DefaultImpls.getId(this);
            }

            @NotNull
            public final Navigation getNavigation() {
                return this.c;
            }

            @Override // com.avito.conveyor_item.Item
            @NotNull
            public String getStringId() {
                return this.a;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }

            public int hashCode() {
                String str = this.b;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                Navigation navigation = this.c;
                int hashCode2 = (hashCode + (navigation != null ? navigation.hashCode() : 0)) * 31;
                DeepLink deepLink = this.d;
                if (deepLink != null) {
                    i = deepLink.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("CategoryShortcutItem(title=");
                L.append(this.b);
                L.append(", navigation=");
                L.append(this.c);
                L.append(", deeplink=");
                return a2.b.a.a.a.m(L, this.d, ")");
            }
        }

        public SheetData(@NotNull List<CategoryShortcutItem> list) {
            Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
            this.a = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.publish.start_publish.StartPublishSheet$SheetData */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SheetData copy$default(SheetData sheetData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sheetData.a;
            }
            return sheetData.copy(list);
        }

        @NotNull
        public final List<CategoryShortcutItem> component1() {
            return this.a;
        }

        @NotNull
        public final SheetData copy(@NotNull List<CategoryShortcutItem> list) {
            Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
            return new SheetData(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof SheetData) && Intrinsics.areEqual(this.a, ((SheetData) obj).a);
            }
            return true;
        }

        @NotNull
        public final List<CategoryShortcutItem> getShortcuts() {
            return this.a;
        }

        public int hashCode() {
            List<CategoryShortcutItem> list = this.a;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a2.b.a.a.a.w(a2.b.a.a.a.L("SheetData(shortcuts="), this.a, ")");
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ StartPublishSheet a;

        public b(StartPublishSheet startPublishSheet) {
            this.a = startPublishSheet;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            StartPublishSheet.access$detach(this.a);
            this.a.x.invoke();
        }
    }

    public static final class c<T> implements Consumer<SheetData.CategoryShortcutItem> {
        public final /* synthetic */ StartPublishSheet a;

        public c(StartPublishSheet startPublishSheet) {
            this.a = startPublishSheet;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SheetData.CategoryShortcutItem categoryShortcutItem) {
            SheetData.CategoryShortcutItem categoryShortcutItem2 = categoryShortcutItem;
            this.a.w.trackPublishVerticalChosen(categoryShortcutItem2.getNavigation());
            this.a.v.track(new AddItemEvent.CategoryButtonClick());
            StartPublishSheet.access$openDeeplink(this.a, categoryShortcutItem2.getDeeplink());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartPublishSheet(@NotNull Context context, @NotNull Analytics analytics, @NotNull PublishEventTracker publishEventTracker, @NotNull Function0<Unit> function0) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(function0, "onDismissCallback");
        this.v = analytics;
        this.w = publishEventTracker;
        this.x = function0;
        setContentView(R.layout.start_publish_sheet, new Function1<View, Unit>(this) { // from class: com.avito.android.publish.start_publish.StartPublishSheet.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                StartPublishSheet.access$setupContentView((StartPublishSheet) this.receiver, view2);
                return Unit.INSTANCE;
            }
        });
        BottomSheetDialog.setHeaderParams$default(this, null, null, false, true, 7, null);
        setCancelable(true);
        setSkipCollapsed(true);
        setCanceledOnTouchOutside(true);
        setOnDismissListener(new b(this));
        setShowOnStart(false);
    }

    public static final void access$detach(StartPublishSheet startPublishSheet) {
        startPublishSheet.u = null;
        startPublishSheet.t.dispose();
    }

    public static final void access$openDeeplink(StartPublishSheet startPublishSheet, DeepLink deepLink) {
        Router router = startPublishSheet.u;
        if (router != null) {
            router.openDeepLink(deepLink);
        }
    }

    public static final void access$setupContentView(StartPublishSheet startPublishSheet, View view) {
        Objects.requireNonNull(startPublishSheet);
        View findViewById = view.findViewById(R.id.verticals_list);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.verticals_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        startPublishSheet.s = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    public final void attachRouter(@NotNull Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.u = router;
    }

    @NotNull
    public final RecyclerView.Adapter<?> getAdapter() {
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final CategoryShortcutItemPresenter getCategoryShortcutItemPresenter() {
        CategoryShortcutItemPresenter categoryShortcutItemPresenter2 = this.categoryShortcutItemPresenter;
        if (categoryShortcutItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryShortcutItemPresenter");
        }
        return categoryShortcutItemPresenter2;
    }

    @Override // com.avito.android.lib.design.bottom_sheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerStartPublishSheetComponent.builder().build().inject(this);
        RecyclerView recyclerView = this.s;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(adapter2);
        CompositeDisposable compositeDisposable = this.t;
        CategoryShortcutItemPresenter categoryShortcutItemPresenter2 = this.categoryShortcutItemPresenter;
        if (categoryShortcutItemPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryShortcutItemPresenter");
        }
        Disposable subscribe = categoryShortcutItemPresenter2.getItemClickObservable().subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "categoryShortcutItemPres….deeplink) \n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setCategoryShortcutItemPresenter(@NotNull CategoryShortcutItemPresenter categoryShortcutItemPresenter2) {
        Intrinsics.checkNotNullParameter(categoryShortcutItemPresenter2, "<set-?>");
        this.categoryShortcutItemPresenter = categoryShortcutItemPresenter2;
    }

    public final void setData(@NotNull SheetData sheetData) {
        Intrinsics.checkNotNullParameter(sheetData, "data");
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        AdapterPresentersKt.updateItems(adapterPresenter2, sheetData.getShortcuts());
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        adapter2.notifyDataSetChanged();
    }
}
