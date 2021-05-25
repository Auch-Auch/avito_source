package com.avito.android.advert_core.safedeal;

import a2.a.a.g.l.d;
import a2.a.a.g.l.f;
import a2.g.r.g;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.advert_core.R;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.PromoLink;
import com.avito.android.lib.design.list_item.BaseListItem;
import com.avito.android.lib.design.list_item.SwitcherListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.util.DeepLinkSpan;
import com.avito.android.util.Uris;
import com.avito.android.util.Views;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001'B/\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView;", "", "", "", "c", "Ljava/util/Set;", "loadingSwitchersSet", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "layoutInflater", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "view", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "f", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "", "Lcom/avito/android/lib/design/list_item/SwitcherListItem;", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "switchersMap", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;", g.a, "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;", "router", "Landroidx/lifecycle/LifecycleOwner;", "h", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "e", "Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;", "viewModel", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesViewModel;Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;Landroidx/lifecycle/LifecycleOwner;)V", "Router", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertSafeDealServicesView {
    public final LayoutInflater a;
    public final Map<String, SwitcherListItem> b = new LinkedHashMap();
    public final Set<String> c = new LinkedHashSet();
    public final ViewGroup d;
    public final MyAdvertSafeDealServicesViewModel e;
    public final DeepLinkFactory f;
    public final Router g;
    public final LifecycleOwner h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/advert_core/safedeal/MyAdvertSafeDealServicesView$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followServicesDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void followServicesDeepLink(@NotNull DeepLink deepLink);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            MyAdvertSafeDeal.Service.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            MyAdvertSafeDeal.Service.Type type = MyAdvertSafeDeal.Service.Type.LIST_ITEM;
            iArr[0] = 1;
            MyAdvertSafeDeal.Service.Type type2 = MyAdvertSafeDeal.Service.Type.SWITCHER;
            iArr[1] = 2;
            MyAdvertSafeDeal.Service.Content.Icon.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            MyAdvertSafeDeal.Service.Content.Icon icon = MyAdvertSafeDeal.Service.Content.Icon.DELIVERY;
            iArr2[0] = 1;
            MyAdvertSafeDeal.Service.Content.Icon icon2 = MyAdvertSafeDeal.Service.Content.Icon.DELIVERY_COURIER;
            iArr2[1] = 2;
            MyAdvertSafeDeal.Service.Content.Icon icon3 = MyAdvertSafeDeal.Service.Content.Icon.SAFE_PAYMENT;
            iArr2[2] = 3;
            MyAdvertSafeDeal.Service.Content.Icon icon4 = MyAdvertSafeDeal.Service.Content.Icon.DELIVERY_UNAVAILABLE;
            iArr2[3] = 4;
        }
    }

    public MyAdvertSafeDealServicesView(@NotNull ViewGroup viewGroup, @NotNull MyAdvertSafeDealServicesViewModel myAdvertSafeDealServicesViewModel, @NotNull DeepLinkFactory deepLinkFactory, @NotNull Router router, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(myAdvertSafeDealServicesViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.d = viewGroup;
        this.e = myAdvertSafeDealServicesViewModel;
        this.f = deepLinkFactory;
        this.g = router;
        this.h = lifecycleOwner;
        Views.show(viewGroup);
        myAdvertSafeDealServicesViewModel.getDataChanges().observe(lifecycleOwner, new d(this));
        myAdvertSafeDealServicesViewModel.getSwitcherIsLoadingChanges().observe(lifecycleOwner, new g3(0, this));
        myAdvertSafeDealServicesViewModel.getSwitcherIsCheckedChanges().observe(lifecycleOwner, new g3(1, this));
        myAdvertSafeDealServicesViewModel.getSnackbarChanges().observe(lifecycleOwner, new f(new Function1<CharSequence, Unit>(viewGroup) { // from class: a2.a.a.g.l.e
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CharSequence charSequence) {
                CharSequence charSequence2 = charSequence;
                Intrinsics.checkNotNullParameter(charSequence2, "p1");
                Views.showSnackBar$default((ViewGroup) this.receiver, charSequence2, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
                return Unit.INSTANCE;
            }
        }));
        this.a = LayoutInflater.from(viewGroup.getContext());
    }

    public static final void access$bindTexts(MyAdvertSafeDealServicesView myAdvertSafeDealServicesView, BaseListItem baseListItem, MyAdvertSafeDeal.Service.Content content) {
        DeepLink deepLink;
        Objects.requireNonNull(myAdvertSafeDealServicesView);
        baseListItem.setTitle(content.getTitle());
        SpannableString spannableString = new SpannableString(content.getLink().getText());
        Uri uri = content.getLink().getUri();
        if (ArraysKt___ArraysKt.contains(Uris.getURL_SCHEMES_ONLY_LETTERS(), uri.getScheme())) {
            deepLink = new PromoLink(uri, false, 2, null);
        } else {
            deepLink = myAdvertSafeDealServicesView.f.createFromUri(uri);
        }
        spannableString.setSpan(new DeepLinkSpan(deepLink, new Object() { // from class: com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView$sam$i$com_avito_android_deep_linking_links_OnDeepLinkClickListener$0
            public boolean equals(Object obj) {
                return (obj instanceof OnDeepLinkClickListener) && (obj instanceof FunctionAdapter) && Intrinsics.areEqual(Function1.this, ((FunctionAdapter) obj).getFunctionDelegate());
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public Function getFunctionDelegate() {
                return Function1.this;
            }

            public int hashCode() {
                return Function1.this.hashCode();
            }

            @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
            public final /* synthetic */ void onDeepLinkClick(DeepLink deepLink2) {
                Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
                Intrinsics.checkNotNullExpressionValue(Function1.this.invoke(deepLink2), "invoke(...)");
            }
        }, false, 4, null), 0, content.getLink().getText().length(), 33);
        baseListItem.setLink(spannableString);
        MovementMethod instance = LinkMovementMethod.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "LinkMovementMethod.getInstance()");
        baseListItem.setLinkMovementMethod(instance);
    }

    public static final Integer access$getIconRes(MyAdvertSafeDealServicesView myAdvertSafeDealServicesView, MyAdvertSafeDeal.Service.Content.Icon icon) {
        Objects.requireNonNull(myAdvertSafeDealServicesView);
        if (icon != null) {
            int ordinal = icon.ordinal();
            if (ordinal == 0) {
                return Integer.valueOf(R.drawable.ic_delivery_24_gray);
            }
            if (ordinal == 1) {
                return Integer.valueOf(R.drawable.ic_courier_24_gray);
            }
            if (ordinal == 2) {
                return Integer.valueOf(R.drawable.ic_card_24_gray);
            }
            if (ordinal == 3) {
                return Integer.valueOf(R.drawable.ic_delivery_unavailable_24_gray);
            }
        }
        return null;
    }

    public static final View access$inflateAndAddTo(MyAdvertSafeDealServicesView myAdvertSafeDealServicesView, int i, ViewGroup viewGroup, Function1 function1) {
        Objects.requireNonNull(myAdvertSafeDealServicesView);
        View inflate = myAdvertSafeDealServicesView.a.inflate(i, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type T");
        function1.invoke(inflate);
        viewGroup.addView(inflate);
        return inflate;
    }
}
