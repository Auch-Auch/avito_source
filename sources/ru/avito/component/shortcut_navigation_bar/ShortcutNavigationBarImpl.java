package ru.avito.component.shortcut_navigation_bar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TypefaceSpan;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.data_source.ListDataSource;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.adapter.ClarifyButtonItemBlueprint;
import ru.avito.component.shortcut_navigation_bar.adapter.ClarifyButtonItemPresenter;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFiltersNavigationItemBlueprint;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFiltersNavigationItemPresenter;
import ru.avito.component.shortcut_navigation_bar.adapter.RubricatorCategoryItemBlueprint;
import ru.avito.component.shortcut_navigation_bar.adapter.RubricatorItemPresenter;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutClickListener;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemPresenter;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutPrimaryNavigationItemBlueprint;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutSecondaryNavigationItemBlueprint;
import ru.avito.component.shortcut_navigation_bar.adapter.SkeletonItem;
import ru.avito.component.shortcut_navigation_bar.adapter.skeleton.ScrollLinearLayoutManager;
import ru.avito.component.shortcut_navigation_bar.adapter.skeleton.SkeletonNavigationItemBlueprint;
import ru.avito.component.shortcut_navigation_bar.adapter.skeleton.SkeletonPresenter;
import ru.avito.component.shortcut_navigation_bar.adapter.skeleton.SkeletonPrimaryNavigationItemBlueprint;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002:\u0002+.B-\u0012\u0006\u0010d\u001a\u00020-\u0012\b\b\u0002\u0010K\u001a\u00020\u0012\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010A\u0012\u0006\u0010h\u001a\u00020\f¢\u0006\u0004\bi\u0010jJ'\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0018\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0!H\u0016¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0016¢\u0006\u0004\b$\u0010#J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140!H\u0016¢\u0006\u0004\b%\u0010#J\u000f\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010\u0011J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0011J\u000f\u0010(\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010\u0011J\u0019\u0010*\u001a\u00020\b2\b\b\u0001\u0010)\u001a\u00020\u0016H\u0016¢\u0006\u0004\b*\u0010\u001cJ\u001d\u0010+\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107RD\u0010>\u001a0\u0012\f\u0012\n :*\u0004\u0018\u00010\u00140\u0014 :*\u0017\u0012\f\u0012\n :*\u0004\u0018\u00010\u00140\u0014\u0018\u000109¢\u0006\u0002\b;09¢\u0006\u0002\b;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=RD\u0010@\u001a0\u0012\f\u0012\n :*\u0004\u0018\u00010\u00060\u0006 :*\u0017\u0012\f\u0012\n :*\u0004\u0018\u00010\u00060\u0006\u0018\u000109¢\u0006\u0002\b;09¢\u0006\u0002\b;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010=R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010MR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010/R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010/R\u0016\u0010g\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010f¨\u0006k"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBarImpl;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutClickListener;", "Lcom/avito/android/remote/model/Shortcuts$Header;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "items", "", "setShortcutItems", "(Lcom/avito/android/remote/model/Shortcuts$Header;Ljava/util/List;)V", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "", "withText", "setSkeleton", "(Ljava/util/List;Z)V", "hideSkeleton", "()V", "", "headerTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "resetAction", "", "searchResultCount", "setShortcutNavigationBarItems", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;Ljava/util/List;)V", VKApiConst.POSITION, "onShortcutClick", "(I)V", "show", "animate", "animateShortcutBar", "(ZZ)V", "Lio/reactivex/rxjava3/core/Observable;", "allCategoriesClicks", "()Lio/reactivex/rxjava3/core/Observable;", "shortcutClicks", "resetActionClicks", "resetShortcutBarPosition", "hideShortcutBar", "showShortcutBar", "color", "overrideVisibleBackground", AuthSource.SEND_ABUSE, "(Ljava/util/List;)V", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "titleSkeleton", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/ItemBinder;", g.a, "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "resetActionRelay", "i", "shortcutRelay", "Lru/avito/component/shortcut_navigation_bar/RubricatorType;", VKApiConst.Q, "Lru/avito/component/shortcut_navigation_bar/RubricatorType;", "rubricatorType", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "f", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "adapterPresenter", "p", "Ljava/lang/String;", "primaryItemType", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "title", "e", "Ljava/util/List;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBarImpl$a;", "k", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBarImpl$a;", "resetClickableSpan", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBarImpl$b;", "l", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBarImpl$b;", "searchResultsSpan", "Ljava/text/DecimalFormat;", AuthSource.OPEN_CHANNEL_LIST, "Ljava/text/DecimalFormat;", "defaultFormatter", "d", "showAllCategories", "Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/ScrollLinearLayoutManager;", "h", "Lru/avito/component/shortcut_navigation_bar/adapter/skeleton/ScrollLinearLayoutManager;", "layoutManager", "o", "containerView", "n", "I", "onlyHeaderBottomPadding", "loadFontsFromAssets", "<init>", "(Landroid/view/View;Ljava/lang/String;Lru/avito/component/shortcut_navigation_bar/RubricatorType;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutNavigationBarImpl implements ShortcutNavigationBar, ShortcutClickListener {
    public final TextView a;
    public final View b;
    public final RecyclerView c;
    public final View d;
    public List<? extends ShortcutNavigationItem> e;
    public final SimpleAdapterPresenter f;
    public final ItemBinder g;
    public final ScrollLinearLayoutManager h;
    public final PublishRelay<ShortcutNavigationItem> i;
    public final PublishRelay<DeepLink> j;
    public final a k;
    public final b l;
    public final DecimalFormat m;
    public final int n;
    public final View o;
    public final String p;
    public final RubricatorType q;

    public static final class a extends ClickableSpan {
        @Nullable
        public DeepLink a;
        public final Consumer<DeepLink> b;
        public final int c;
        public final int d;
        public final Typeface e;

        public a(@NotNull Consumer<DeepLink> consumer, @ColorInt int i, int i2, @NotNull Typeface typeface) {
            Intrinsics.checkNotNullParameter(consumer, "resetActionConsumer");
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.b = consumer;
            this.c = i;
            this.d = i2;
            this.e = typeface;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            DeepLink deepLink = this.a;
            if (deepLink != null) {
                this.b.accept(deepLink);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            textPaint.setTypeface(this.e);
            textPaint.setColor(this.c);
            textPaint.baselineShift += this.d;
        }
    }

    public static final class b extends TypefaceSpan {
        public final int b;
        public final Typeface c;

        public b(@ColorInt int i, @Nullable Typeface typeface) {
            super(typeface);
            this.b = i;
            this.c = typeface;
        }

        @Override // com.avito.android.util.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "drawState");
            textPaint.setTypeface(this.c);
            textPaint.setColor(this.b);
        }

        @Override // com.avito.android.util.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(@NotNull TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        }
    }

    public ShortcutNavigationBarImpl(@NotNull View view, @NotNull String str, @Nullable RubricatorType rubricatorType, boolean z) {
        Typeface typeface;
        Typeface typeface2;
        ShortcutSecondaryNavigationItemBlueprint shortcutSecondaryNavigationItemBlueprint;
        ItemBlueprint<?, ?> itemBlueprint;
        int i2;
        Intrinsics.checkNotNullParameter(view, "containerView");
        Intrinsics.checkNotNullParameter(str, "primaryItemType");
        this.o = view;
        this.p = str;
        this.q = rubricatorType;
        TextView textView = (TextView) view.findViewById(R.id.shortcuts_header);
        this.a = textView;
        this.b = view.findViewById(R.id.shortcuts_header_skeleton);
        View findViewById = view.findViewById(R.id.shortcuts_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy….shortcuts_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.c = recyclerView;
        this.d = view.findViewById(R.id.show_all_categories);
        this.e = CollectionsKt__CollectionsKt.emptyList();
        this.i = PublishRelay.create();
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.j = create;
        Intrinsics.checkNotNullExpressionValue(create, "resetActionRelay");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        int i3 = com.avito.android.lib.design.R.attr.gray48;
        int colorByAttr = Contexts.getColorByAttr(context, i3);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "containerView.resources");
        int i4 = (int) (resources.getDisplayMetrics().scaledDensity * ((float) 1));
        if (z) {
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "containerView.context");
            typeface = Typefaces.getTypeface(context2, TypefaceType.Regular);
            Intrinsics.checkNotNull(typeface);
        } else {
            typeface = ResourcesCompat.getFont(view.getContext(), TypefaceType.Regular.getFontResId());
            Intrinsics.checkNotNull(typeface);
            Intrinsics.checkNotNullExpressionValue(typeface, "ResourcesCompat.getFont(…Type.Regular.fontResId)!!");
        }
        this.k = new a(create, colorByAttr, i4, typeface);
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "containerView.context");
        int colorByAttr2 = Contexts.getColorByAttr(context3, i3);
        if (z) {
            Context context4 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "containerView.context");
            typeface2 = Typefaces.getTypeface(context4, TypefaceType.Regular);
            Intrinsics.checkNotNull(typeface2);
        } else {
            typeface2 = ResourcesCompat.getFont(view.getContext(), TypefaceType.Regular.getFontResId());
            Intrinsics.checkNotNull(typeface2);
            Intrinsics.checkNotNullExpressionValue(typeface2, "ResourcesCompat.getFont(…Type.Regular.fontResId)!!");
        }
        this.l = new b(colorByAttr2, typeface2);
        NumberFormat instance = DecimalFormat.getInstance(new Locale("ru", "RU"));
        Objects.requireNonNull(instance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) instance;
        decimalFormat.setGroupingSize(3);
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "decimalFormatSymbols");
        decimalFormatSymbols.setGroupingSeparator(StringsKt___StringsKt.single(" "));
        this.m = decimalFormat;
        this.n = view.getResources().getDimensionPixelOffset(R.dimen.serp_vertical_padding);
        Context context5 = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "recycler.context");
        ScrollLinearLayoutManager scrollLinearLayoutManager = new ScrollLinearLayoutManager(context5);
        this.h = scrollLinearLayoutManager;
        recyclerView.setLayoutManager(scrollLinearLayoutManager);
        if (rubricatorType != null) {
            recyclerView.addItemDecoration(new RubricatorItemsDecoration(rubricatorType));
        } else {
            Resources resources2 = recyclerView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "recycler.resources");
            recyclerView.addItemDecoration(new ShortcutsItemDecoration(resources2, 0, 0, 0, 14, null));
        }
        ShortcutNavigationItemPresenter shortcutNavigationItemPresenter = new ShortcutNavigationItemPresenter(this);
        InlineFiltersNavigationItemPresenter inlineFiltersNavigationItemPresenter = new InlineFiltersNavigationItemPresenter(this);
        ClarifyButtonItemPresenter clarifyButtonItemPresenter = new ClarifyButtonItemPresenter(this);
        if (rubricatorType != null) {
            itemBlueprint = new RubricatorCategoryItemBlueprint(new RubricatorItemPresenter(this), rubricatorType.isLargeIcon());
            shortcutSecondaryNavigationItemBlueprint = null;
        } else {
            ShortcutPrimaryNavigationItemBlueprint shortcutPrimaryNavigationItemBlueprint = new ShortcutPrimaryNavigationItemBlueprint(shortcutNavigationItemPresenter, str);
            shortcutSecondaryNavigationItemBlueprint = new ShortcutSecondaryNavigationItemBlueprint(shortcutNavigationItemPresenter);
            itemBlueprint = shortcutPrimaryNavigationItemBlueprint;
        }
        InlineFiltersNavigationItemBlueprint inlineFiltersNavigationItemBlueprint = new InlineFiltersNavigationItemBlueprint(inlineFiltersNavigationItemPresenter);
        ClarifyButtonItemBlueprint clarifyButtonItemBlueprint = new ClarifyButtonItemBlueprint(clarifyButtonItemPresenter);
        SkeletonNavigationItemBlueprint skeletonNavigationItemBlueprint = new SkeletonNavigationItemBlueprint(new SkeletonPresenter());
        ItemBinder.Builder registerItem = new ItemBinder.Builder().registerItem(inlineFiltersNavigationItemBlueprint).registerItem(clarifyButtonItemBlueprint).registerItem(skeletonNavigationItemBlueprint).registerItem(new SkeletonPrimaryNavigationItemBlueprint(new SkeletonPresenter())).registerItem(itemBlueprint);
        if (shortcutSecondaryNavigationItemBlueprint != null) {
            registerItem.registerItem(shortcutSecondaryNavigationItemBlueprint);
        }
        ItemBinder build = registerItem.build();
        this.g = build;
        this.f = new SimpleAdapterPresenter(build, build);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        Context context6 = view.getContext();
        if (rubricatorType == null) {
            i2 = com.avito.android.lib.design.R.attr.oldBackground;
        } else {
            i2 = com.avito.android.lib.design.R.attr.white;
        }
        Intrinsics.checkNotNullExpressionValue(context6, "context");
        overrideVisibleBackground(Contexts.getColorByAttr(context6, i2));
        view.setClickable(true);
    }

    public final void a(List<? extends ShortcutNavigationItem> list) {
        this.e = list;
        this.f.onDataSourceChanged(new ListDataSource(list));
        if (this.c.getAdapter() == null) {
            this.c.setAdapter(new SimpleRecyclerAdapter(this.f, this.g));
            return;
        }
        RecyclerView.Adapter adapter = this.c.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<Unit> allCategoriesClicks() {
        Observable<Unit> clicks;
        View view = this.d;
        if (view != null && (clicks = RxView.clicks(view)) != null) {
            return clicks;
        }
        Observable<Unit> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void animateShortcutBar(boolean z, boolean z2) {
        int i2 = -this.o.getMeasuredHeight();
        if (z) {
            i2 = 0;
        }
        this.o.animate().translationY((float) i2).setDuration(z2 ? 300 : 0).start();
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideShortcutBar() {
        Views.hide(this.o);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void hideSkeleton() {
        View view = this.b;
        if (view != null) {
            Views.hide(view);
        }
        if ((!this.e.isEmpty()) && (CollectionsKt___CollectionsKt.first((List<? extends Object>) this.e) instanceof SkeletonItem)) {
            a(CollectionsKt__CollectionsKt.emptyList());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.jakewharton.rxrelay3.PublishRelay<ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // ru.avito.component.shortcut_navigation_bar.adapter.ShortcutClickListener
    public void onShortcutClick(int i2) {
        if ((!this.e.isEmpty()) && i2 >= 0 && i2 < this.e.size()) {
            this.i.accept(this.e.get(i2));
        }
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void overrideVisibleBackground(@ColorInt int i2) {
        this.o.setBackgroundColor(i2);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<DeepLink> resetActionClicks() {
        PublishRelay<DeepLink> publishRelay = this.j;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "resetActionRelay");
        return publishRelay;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void resetShortcutBarPosition() {
        this.c.scrollToPosition(0);
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setShortcutItems(@Nullable Shortcuts.Header header, @NotNull List<? extends ShortcutNavigationItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.h.setScrollEnabled(true);
        setShortcutNavigationBarItems(header != null ? header.getTitle() : null, header != null ? header.getResetAction() : null, null, list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setShortcutNavigationBarItems(@org.jetbrains.annotations.Nullable java.lang.String r8, @org.jetbrains.annotations.Nullable com.avito.android.deep_linking.links.DeepLink r9, @org.jetbrains.annotations.Nullable java.lang.Integer r10, @org.jetbrains.annotations.NotNull java.util.List<? extends ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem> r11) {
        /*
            r7 = this;
            java.lang.String r0 = "items"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            android.view.View r0 = r7.b
            if (r0 == 0) goto L_0x000c
            com.avito.android.util.Views.hide(r0)
        L_0x000c:
            r7.a(r11)
            r0 = 0
            if (r8 == 0) goto L_0x009a
            int r1 = r8.length()
            if (r1 <= 0) goto L_0x001a
            r1 = 1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            if (r1 == 0) goto L_0x009a
            ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl$a r1 = r7.k
            r1.a = r9
            android.widget.TextView r1 = r7.a
            if (r1 == 0) goto L_0x0092
            if (r10 == 0) goto L_0x003b
            int r2 = r10.intValue()
            if (r2 == 0) goto L_0x003b
            java.text.DecimalFormat r0 = r7.m
            int r10 = r10.intValue()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r0 = r0.format(r10)
        L_0x003b:
            if (r0 == 0) goto L_0x0049
            java.lang.String r10 = " "
            java.lang.String r10 = a2.b.a.a.a.c3(r8, r10)
            java.lang.String r10 = a2.b.a.a.a.c3(r10, r0)
            goto L_0x004a
        L_0x0049:
            r10 = r8
        L_0x004a:
            if (r9 == 0) goto L_0x005a
            java.lang.String r2 = " × "
            java.lang.String r10 = a2.b.a.a.a.c3(r10, r2)
            java.lang.String r2 = "﻿"
            java.lang.String r10 = a2.b.a.a.a.c3(r10, r2)
        L_0x005a:
            android.text.SpannableString r2 = new android.text.SpannableString
            r2.<init>(r10)
            r10 = 33
            if (r0 == 0) goto L_0x007e
            int r8 = r8.length()
            int r8 = r8 + 1
            int r0 = r0.length()
            int r0 = r0 + r8
            ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl$b r3 = r7.l
            r2.setSpan(r3, r8, r0, r10)
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            r4 = 1061997773(0x3f4ccccd, float:0.8)
            r3.<init>(r4)
            r2.setSpan(r3, r8, r0, r10)
        L_0x007e:
            if (r9 == 0) goto L_0x008f
            int r8 = r2.length()
            int r8 = r8 + -3
            int r8 = r8 + -1
            ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl$a r9 = r7.k
            int r0 = r8 + 3
            r2.setSpan(r9, r8, r0, r10)
        L_0x008f:
            r1.setText(r2)
        L_0x0092:
            android.widget.TextView r8 = r7.a
            if (r8 == 0) goto L_0x00a8
            com.avito.android.util.Views.show(r8)
            goto L_0x00a8
        L_0x009a:
            android.widget.TextView r8 = r7.a
            if (r8 == 0) goto L_0x00a1
            r8.setText(r0)
        L_0x00a1:
            android.widget.TextView r8 = r7.a
            if (r8 == 0) goto L_0x00a8
            com.avito.android.util.Views.hide(r8)
        L_0x00a8:
            boolean r8 = r11.isEmpty()
            if (r8 == 0) goto L_0x00bb
            androidx.recyclerview.widget.RecyclerView r8 = r7.c
            com.avito.android.util.Views.hide(r8)
            android.view.View r8 = r7.d
            if (r8 == 0) goto L_0x00cd
            com.avito.android.util.Views.hide(r8)
            goto L_0x00cd
        L_0x00bb:
            androidx.recyclerview.widget.RecyclerView r8 = r7.c
            com.avito.android.util.Views.show(r8)
            ru.avito.component.shortcut_navigation_bar.RubricatorType r8 = r7.q
            ru.avito.component.shortcut_navigation_bar.RubricatorType r9 = ru.avito.component.shortcut_navigation_bar.RubricatorType.BIG_ICON_ALL_CAT_BELOW
            if (r8 != r9) goto L_0x00cd
            android.view.View r8 = r7.d
            if (r8 == 0) goto L_0x00cd
            com.avito.android.util.Views.show(r8)
        L_0x00cd:
            android.widget.TextView r0 = r7.a
            if (r0 == 0) goto L_0x00e5
            r1 = 0
            r2 = 0
            r3 = 0
            boolean r8 = r11.isEmpty()
            if (r8 == 0) goto L_0x00de
            int r8 = r7.n
            r4 = r8
            goto L_0x00e0
        L_0x00de:
            r8 = 0
            r4 = 0
        L_0x00e0:
            r5 = 7
            r6 = 0
            com.avito.android.util.Views.changePadding$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBarImpl.setShortcutNavigationBarItems(java.lang.String, com.avito.android.deep_linking.links.DeepLink, java.lang.Integer, java.util.List):void");
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void setSkeleton(@NotNull List<SkeletonItem> list, boolean z) {
        View view;
        Intrinsics.checkNotNullParameter(list, "items");
        if (this.e.isEmpty()) {
            this.h.setScrollEnabled(false);
            if (z && (view = this.b) != null) {
                Views.show(view);
            }
            TextView textView = this.a;
            if (textView != null) {
                Views.hide(textView);
            }
            a(list);
        }
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    @NotNull
    public Observable<ShortcutNavigationItem> shortcutClicks() {
        PublishRelay<ShortcutNavigationItem> publishRelay = this.i;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "shortcutRelay");
        return publishRelay;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar
    public void showShortcutBar() {
        Views.show(this.o);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShortcutNavigationBarImpl(View view, String str, RubricatorType rubricatorType, boolean z, int i2, j jVar) {
        this(view, (i2 & 2) != 0 ? "default" : str, (i2 & 4) != 0 ? null : rubricatorType, z);
    }
}
