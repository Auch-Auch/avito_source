package com.avito.android.design.widget.search_view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.design.widget.circular_progress.CircularProgressDrawable;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.lib.util.VerticalCenteredImageSpan;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.MenuItemsKt;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.Views;
import com.getkeepsafe.taptargetview.AvitoBrandTapTargetStyle;
import com.getkeepsafe.taptargetview.PersistableTabTarget;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.getkeepsafe.taptargetview.TapTargetViewExtensionsKt;
import com.getkeepsafe.taptargetview.TapTargetsKt;
import com.jakewharton.rxbinding4.widget.RxTextView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiPhotoSize;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¯\u0001B.\b\u0017\u0012\b\u0010©\u0001\u001a\u00030¨\u0001\u0012\f\b\u0002\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001\u0012\t\b\u0002\u0010¬\u0001\u001a\u00020\u0004¢\u0006\u0006\b­\u0001\u0010®\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u001b\u0010\u0014\u001a\u00020\b*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\b*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u0013\u0010\u0019\u001a\u00020\b*\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\b2\b\b\u0001\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001c\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010\u001fJ\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\nJ\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$H\u0016¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0$H\u0016¢\u0006\u0004\b'\u0010&J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0$H\u0016¢\u0006\u0004\b(\u0010&J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120$H\u0016¢\u0006\u0004\b)\u0010&J\u0019\u0010+\u001a\u00020\b2\b\b\u0001\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010\u001dJ\u0019\u0010-\u001a\u00020\b2\b\b\u0001\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u001dJ\u0019\u0010/\u001a\u00020\b2\b\b\u0001\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u001dJ\u0019\u00101\u001a\u00020\b2\b\b\u0001\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u001dJ\u0015\u00102\u001a\b\u0012\u0004\u0012\u00020\b0$H\u0016¢\u0006\u0004\b2\u0010&J\u0017\u00105\u001a\u00020\b2\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001eH\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0012H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010\nJ/\u0010@\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\u0012H\u0016¢\u0006\u0004\b@\u0010AJ\u001f\u0010C\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bC\u0010DJ\u001f\u0010E\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0012H\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\u00122\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u0011\u0010N\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\bH\u0016¢\u0006\u0004\bP\u0010\nJ\u001d\u0010S\u001a\u00020\b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\b0QH\u0016¢\u0006\u0004\bS\u0010TJ/\u0010X\u001a\u00020\b2\b\b\u0001\u0010U\u001a\u00020\u00042\b\b\u0001\u0010V\u001a\u00020\u00042\n\b\u0001\u0010W\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\bH\u0016¢\u0006\u0004\bZ\u0010\nJ\u0017\u0010\\\u001a\u00020\b2\u0006\u0010[\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\\\u0010\u001dJ\u000f\u0010]\u001a\u00020\bH\u0016¢\u0006\u0004\b]\u0010\nJ\u0011\u0010_\u001a\u0004\u0018\u00010^H\u0014¢\u0006\u0004\b_\u0010`J\u0019\u0010b\u001a\u00020\b2\b\u0010a\u001a\u0004\u0018\u00010^H\u0014¢\u0006\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010gR\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00040i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kRD\u0010p\u001a0\u0012\f\u0012\n m*\u0004\u0018\u00010\u00120\u0012 m*\u0017\u0012\f\u0012\n m*\u0004\u0018\u00010\u00120\u0012\u0018\u00010i¢\u0006\u0002\bn0i¢\u0006\u0002\bn8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010kR\u0016\u0010s\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010rR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010uR\u0016\u0010x\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010wR\u0018\u0010z\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010wR\u0018\u0010~\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010\u0001\u001a\u0004\u0018\u000108\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010}R\u0017\u0010\u0001\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010wR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0016\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\f\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010eR@\u0010\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00018\u0016@VX\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010gR\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010wR\u001e\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\b0i8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010kR\u0017\u0010.\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b¢\u0001\u0010gR\u001c\u0010¦\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010§\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u000f\u0010\u0001¨\u0006°\u0001"}, d2 = {"Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl;", "Landroid/widget/FrameLayout;", "Landroidx/appcompat/widget/Toolbar$OnMenuItemClickListener;", "Lcom/avito/android/design/widget/search_view/ToolbarSearchView;", "", "getSelectionPosition", "()I", "getLastCharPosition", "", "k", "()V", a2.g.r.g.a, "d", "h", AuthSource.BOOKING_ORDER, "j", "c", "Landroid/view/Menu;", "", "visible", "f", "(Landroid/view/Menu;Z)V", "e", "i", "Landroid/view/View;", AuthSource.SEND_ABUSE, "(Landroid/view/View;)V", "text", "setQuery", "(I)V", "", "(Ljava/lang/String;)V", "updateActiveQuery", "hint", "setHint", "removeHint", "Lio/reactivex/rxjava3/core/Observable;", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "submitCallbacks", "textChangeCallbacks", "openCallbacks", "menuId", "setMenu", "menuTintColorAttr", "setMenuTintColorAttr", "menuTintColor", "setMenuTintColor", "drawableRes", "setNavigationIcon", "navigationCallbacks", "Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;", "subscriptionButtonState", "toggleSubscriptionButton", "(Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;)V", "showTooltipToMenuItem", "(ILjava/lang/String;)V", "isSearchOpen", "()Z", "notifyDataSetChanged", "itemId", "drawableId", "needToTint", "favoritesIconRedesignNeedToTint", "replaceMenuItemIcon", "(IIZZ)V", "stringRes", "replaceMenuItemTitle", "(II)V", "setMenuItemVisible", "(IZ)V", "enabled", "setSearchEnabled", "(Z)V", "Landroid/view/MenuItem;", "item", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "getQuery", "()Ljava/lang/String;", "close", "Lkotlin/Function0;", "onCloseAction", "closeDelayed", "(Lkotlin/jvm/functions/Function0;)V", "targetIdRes", "titleRes", "descriptionRes", "showTapTarget", "(IILjava/lang/Integer;)V", "showActionProgress", "count", "showSelectedFiltersCount", "hideNavigationIcon", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "w", "Z", "isSearchEnabled", "I", "selectedFiltersCount", "Lcom/jakewharton/rxrelay3/PublishRelay;", "n", "Lcom/jakewharton/rxrelay3/PublishRelay;", "menuRelay", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "p", "openRelay", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/design/widget/search_view/SearchEditText;", "Lcom/avito/android/design/widget/search_view/SearchEditText;", "editText", "Landroid/view/View;", "divider", AuthSource.OPEN_CHANNEL_LIST, "savedSearchButton", "clearButton", VKApiConst.Q, "Ljava/lang/Integer;", "navigationIcon", "", VKApiConst.VERSION, "Ljava/lang/Float;", "selectedFiltersCounterDefaultSize", "t", "lastSelection", "shadow", "Landroidx/appcompat/widget/Toolbar;", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Ljava/lang/Runnable;", "s", "Ljava/lang/Runnable;", "onDetachAction", "Landroid/util/SparseBooleanArray;", "u", "Landroid/util/SparseBooleanArray;", "menuItemVisibility", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "currentQuery", "r", "isOpen", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "y", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "recyclerPadding", "clarifyPlaceholder", "o", "navigationRelay", "x", "Landroid/widget/ImageView;", "l", "Landroid/widget/ImageView;", "savedSearchImage", "selectedFiltersCounter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ToolbarSearchViewImpl extends FrameLayout implements Toolbar.OnMenuItemClickListener, ToolbarSearchView {
    public final RecyclerView a;
    public final View b;
    public final SearchEditText c;
    public final TextView d;
    public final Toolbar e;
    public final View f;
    public final int g;
    public final View h;
    public View i;
    public TextView j;
    public int k;
    public ImageView l;
    public View m;
    public PublishRelay<Integer> n;
    public PublishRelay<Unit> o;
    public PublishRelay<Boolean> p;
    public Integer q;
    public boolean r;
    public Runnable s;
    public Integer t;
    public SparseBooleanArray u;
    public Float v;
    public boolean w;
    @ColorInt
    public int x;
    @Nullable
    public RecyclerView.Adapter<?> y;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SubscriptionButtonState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ToolbarSearchViewImpl a;

        public a(ToolbarSearchViewImpl toolbarSearchViewImpl) {
            this.a = toolbarSearchViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Editable text = this.a.c.getText();
            if (text != null) {
                text.clear();
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ToolbarSearchViewImpl a;
        public final /* synthetic */ Function0 b;

        public b(ToolbarSearchViewImpl toolbarSearchViewImpl, Function0 function0) {
            this.a = toolbarSearchViewImpl;
            this.b = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.close();
            this.b.invoke();
            this.a.s = null;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ToolbarSearchViewImpl a;

        public c(ToolbarSearchViewImpl toolbarSearchViewImpl) {
            this.a = toolbarSearchViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.o.accept(Unit.INSTANCE);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ToolbarSearchViewImpl a;
        public final /* synthetic */ MenuItem b;

        public d(ToolbarSearchViewImpl toolbarSearchViewImpl, MenuItem menuItem) {
            this.a = toolbarSearchViewImpl;
            this.b = menuItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onMenuItemClick(this.b);
        }
    }

    public static final class e extends Lambda implements Function0<View> {
        public final /* synthetic */ ToolbarSearchViewImpl a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ToolbarSearchViewImpl toolbarSearchViewImpl, int i) {
            super(0);
            this.a = toolbarSearchViewImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public View invoke() {
            View findViewById = this.a.e.findViewById(this.b);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            return findViewById;
        }
    }

    public static final class f extends Lambda implements Function1<TooltipContent, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TooltipContent tooltipContent) {
            TooltipContent tooltipContent2 = tooltipContent;
            Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
            tooltipContent2.setBody(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class g<T, R> implements Function<Integer, String> {
        public final /* synthetic */ ToolbarSearchViewImpl a;

        public g(ToolbarSearchViewImpl toolbarSearchViewImpl) {
            this.a = toolbarSearchViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(Integer num) {
            return String.valueOf(this.a.c.getText());
        }
    }

    public static final class h<T> implements Consumer<String> {
        public final /* synthetic */ ToolbarSearchViewImpl a;

        public h(ToolbarSearchViewImpl toolbarSearchViewImpl) {
            this.a = toolbarSearchViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            this.a.d.setText(str);
        }
    }

    public static final class i<T> implements Consumer<CharSequence> {
        public final /* synthetic */ ToolbarSearchViewImpl a;

        public i(ToolbarSearchViewImpl toolbarSearchViewImpl) {
            this.a = toolbarSearchViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            ToolbarSearchViewImpl toolbarSearchViewImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(charSequence2, "it");
            ToolbarSearchViewImpl.access$onTextChanged(toolbarSearchViewImpl, charSequence2);
        }
    }

    public static final class j<T, R> implements Function<CharSequence, String> {
        public static final j a = new j();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(CharSequence charSequence) {
            return charSequence.toString();
        }
    }

    @JvmOverloads
    public ToolbarSearchViewImpl(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public ToolbarSearchViewImpl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ToolbarSearchViewImpl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        PublishRelay<Integer> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.n = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.o = create2;
        this.p = PublishRelay.create();
        this.w = true;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.x = Contexts.getColorByAttr(context2, R.attr.blue);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.avito.android.ui_components.R.styleable.ToolbarSearchView, i2, 0);
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(com.avito.android.ui_components.R.styleable.ToolbarSearchView_android_layout, com.avito.android.ui_components.R.layout.toolbar_search_view), this);
        View findViewById = findViewById(com.avito.android.ui_components.R.id.suggests_recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = findViewById(com.avito.android.ui_components.R.id.search_edit_text);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.design.widget.search_view.SearchEditText");
        SearchEditText searchEditText = (SearchEditText) findViewById2;
        this.c = searchEditText;
        View findViewById3 = findViewById(com.avito.android.ui_components.R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.e = toolbar;
        View findViewById4 = findViewById(com.avito.android.ui_components.R.id.shadow);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById4;
        View findViewById5 = findViewById(com.avito.android.ui_components.R.id.search_divider);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
        View findViewById6 = findViewById(com.avito.android.ui_components.R.id.search_current_query);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById6;
        this.d = textView;
        View findViewById7 = findViewById(com.avito.android.ui_components.R.id.clear_button);
        this.h = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(new a(this));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Views.hide(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.avito.android.design.widget.search_view.ToolbarSearchViewImpl$initRecycler$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView2, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (i3 == 1) {
                    Keyboards.hideKeyboard(ToolbarSearchViewImpl.this, false);
                }
            }
        });
        toolbar.setOnMenuItemClickListener(this);
        findViewById4.setOnClickListener(new u(0, this));
        searchEditText.setSearchView$ui_components_release(this);
        searchEditText.setOnFocusChangeListener(new a2.a.a.l0.a.c.c(this));
        searchEditText.clearFocus();
        textView.setOnClickListener(new u(1, this));
        String string = obtainStyledAttributes.getString(com.avito.android.ui_components.R.styleable.ToolbarSearchView_android_hint);
        setHint(string == null ? "" : string);
        searchEditText.setText(obtainStyledAttributes.getString(com.avito.android.ui_components.R.styleable.ToolbarSearchView_android_text));
        obtainStyledAttributes.recycle();
        View findViewById8 = findViewById(com.avito.android.ui_components.R.id.toolbar_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        ViewGroup.LayoutParams layoutParams = findViewById8.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = getPaddingLeft();
        marginLayoutParams.rightMargin = getPaddingRight();
        findViewById8.requestLayout();
        this.g = getResources().getDimensionPixelOffset(com.avito.android.ui_components.R.dimen.search_bar_suggest_padding);
    }

    public static final void access$onEditTextFocus(ToolbarSearchViewImpl toolbarSearchViewImpl, boolean z) {
        boolean z2 = true;
        if (z) {
            toolbarSearchViewImpl.c.setSelection(toolbarSearchViewImpl.getSelectionPosition());
            toolbarSearchViewImpl.r = true;
            toolbarSearchViewImpl.e.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
            toolbarSearchViewImpl.e.setNavigationOnClickListener(new a2.a.a.l0.a.c.e(toolbarSearchViewImpl));
            if (!Views.isVisible(toolbarSearchViewImpl.a)) {
                Views.setVisible(toolbarSearchViewImpl.a, true);
                toolbarSearchViewImpl.i();
                toolbarSearchViewImpl.a(toolbarSearchViewImpl.a);
            }
            Views.setVisible(toolbarSearchViewImpl.b, true);
            toolbarSearchViewImpl.a(toolbarSearchViewImpl.b);
            Keyboards.showKeyboardWithAttempt$default(toolbarSearchViewImpl.c, 0, 0, 3, null);
            Editable text = toolbarSearchViewImpl.c.getText();
            if (!(text == null || text.length() == 0)) {
                z2 = false;
            }
            if (z2) {
                toolbarSearchViewImpl.c();
            } else {
                toolbarSearchViewImpl.h();
            }
            toolbarSearchViewImpl.j();
            return;
        }
        Views.setVisible(toolbarSearchViewImpl.c, false);
        Views.setVisible(toolbarSearchViewImpl.d, true);
        if (!Intrinsics.areEqual(String.valueOf(toolbarSearchViewImpl.c.getText()), toolbarSearchViewImpl.d.getText())) {
            toolbarSearchViewImpl.c.setText(toolbarSearchViewImpl.d.getText());
            Editable text2 = toolbarSearchViewImpl.c.getText();
            toolbarSearchViewImpl.t = text2 != null ? Integer.valueOf(text2.length()) : null;
            SearchEditText searchEditText = toolbarSearchViewImpl.c;
            Editable text3 = searchEditText.getText();
            searchEditText.setSelection(text3 != null ? text3.length() : 0);
        } else {
            toolbarSearchViewImpl.t = Integer.valueOf(toolbarSearchViewImpl.c.getSelectionStart());
        }
        toolbarSearchViewImpl.r = false;
        toolbarSearchViewImpl.d();
        View view = toolbarSearchViewImpl.b;
        if (Views.isVisible(view) || view.getAlpha() != 0.0f) {
            view.animate().alpha(0.0f).setDuration(400).setListener(new AnimatorListenerAdapter(view) { // from class: com.avito.android.design.widget.search_view.ToolbarSearchViewImpl$fadeOut$1
                public final /* synthetic */ View b;

                {
                    this.b = r2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(@Nullable Animator animator) {
                    Views.setVisible(this.b, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animation");
                    this.b.animate().setListener(null);
                    if (this.b.getAlpha() == 0.0f) {
                        Views.setVisible(this.b, false);
                        ToolbarSearchViewImpl.this.p.accept(Boolean.FALSE);
                    }
                }
            });
        }
        Views.setVisible(toolbarSearchViewImpl.f, false);
        Views.setVisible(toolbarSearchViewImpl.a, false);
        Menu menu = toolbarSearchViewImpl.e.getMenu();
        if (menu != null) {
            View view2 = toolbarSearchViewImpl.h;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            ToolbarSearchViewKt.access$foreach(menu, new a2.a.a.l0.a.c.g(toolbarSearchViewImpl));
            toolbarSearchViewImpl.b();
            toolbarSearchViewImpl.e(menu, false);
            toolbarSearchViewImpl.f(menu, false);
        }
        Keyboards.hideKeyboard$default(toolbarSearchViewImpl, false, 1, null);
    }

    public static final void access$onTextChanged(ToolbarSearchViewImpl toolbarSearchViewImpl, CharSequence charSequence) {
        if (toolbarSearchViewImpl.c.hasFocus()) {
            if (charSequence.length() > 0) {
                toolbarSearchViewImpl.h();
            } else {
                toolbarSearchViewImpl.b();
                toolbarSearchViewImpl.c();
            }
            toolbarSearchViewImpl.j();
        }
    }

    public static final void access$showSearch(ToolbarSearchViewImpl toolbarSearchViewImpl) {
        if (toolbarSearchViewImpl.w) {
            Views.setVisible(toolbarSearchViewImpl.d, false);
            Views.setVisible(toolbarSearchViewImpl.c, true);
            toolbarSearchViewImpl.c.requestFocus();
        }
    }

    private final int getLastCharPosition() {
        Editable text = this.c.getText();
        if (text != null) {
            return text.length();
        }
        return 0;
    }

    private final int getSelectionPosition() {
        Integer num = this.t;
        int intValue = num != null ? num.intValue() : getLastCharPosition();
        return intValue <= this.c.length() ? intValue : getLastCharPosition();
    }

    public final void a(View view) {
        if (!Views.isVisible(view) || view.getAlpha() != 1.0f) {
            this.p.accept(Boolean.TRUE);
            view.animate().alpha(1.0f).setDuration(400).start();
        }
    }

    public final void b() {
        Menu menu = this.e.getMenu();
        if (menu != null) {
            View view = this.h;
            if (view != null) {
                Views.setVisible(view, false);
                return;
            }
            MenuItem findItem = menu.findItem(com.avito.android.ui_components.R.id.discard_search);
            if (findItem != null) {
                findItem.setVisible(false);
            }
        }
    }

    public final void c() {
        Menu menu = this.e.getMenu();
        if (menu != null) {
            View view = this.h;
            if (view != null) {
                view.setVisibility(8);
            }
            ToolbarSearchViewKt.access$foreach(menu, a2.a.a.l0.a.c.b.a);
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void close() {
        this.c.clearFocus();
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void closeDelayed(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onCloseAction");
        this.s = new b(this, function0);
    }

    public final void d() {
        Integer num = this.q;
        if (num == null) {
            this.e.setNavigationIcon((Drawable) null);
            this.e.setNavigationOnClickListener(null);
            return;
        }
        this.e.setNavigationIcon(num.intValue());
        this.e.setNavigationOnClickListener(new c(this));
    }

    public final void e(Menu menu, boolean z) {
        MenuItem findItem = menu.findItem(com.avito.android.ui_components.R.id.search_action);
        if (findItem != null) {
            findItem.setVisible(z);
        }
    }

    public final void f(Menu menu, boolean z) {
        MenuItem findItem = menu.findItem(com.avito.android.ui_components.R.id.progress_indicator);
        if (findItem != null) {
            findItem.setVisible(z);
        }
    }

    public final void g() {
        MenuItem findItem;
        if ((this.m == null || this.l == null) && (findItem = this.e.getMenu().findItem(com.avito.android.ui_components.R.id.menu_subscription)) != null) {
            findItem.setActionView(com.avito.android.ui_components.R.layout.save_search_action);
            View actionView = findItem.getActionView();
            this.m = actionView;
            this.l = actionView != null ? (ImageView) actionView.findViewById(com.avito.android.ui_components.R.id.save_search_image) : null;
            View view = this.m;
            if (view != null) {
                view.setOnClickListener(new d(this, findItem));
            }
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    @Nullable
    public RecyclerView.Adapter<?> getAdapter() {
        return this.y;
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    @Nullable
    public String getQuery() {
        Editable text = this.c.getText();
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public final void h() {
        Menu menu = this.e.getMenu();
        if (menu != null) {
            View view = this.h;
            if (view != null) {
                view.setVisibility(8);
            }
            ToolbarSearchViewKt.access$foreach(menu, a2.a.a.l0.a.c.b.a);
            View view2 = this.h;
            if (view2 != null) {
                Views.setVisible(view2, true);
            } else {
                MenuItem findItem = menu.findItem(com.avito.android.ui_components.R.id.discard_search);
                if (findItem != null) {
                    findItem.setVisible(true);
                }
            }
            e(menu, true);
            f(menu, false);
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void hideNavigationIcon() {
        this.q = null;
        this.e.setNavigationIcon((Drawable) null);
        this.e.setContentInsetsAbsolute(Views.dpToPx(this, 16), this.e.getContentInsetRight());
    }

    public final void i() {
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter == null || adapter.getItemCount() <= 0 || !Views.isVisible(this.a)) {
            Views.setVisible(this.f, false);
            this.a.setPadding(0, 0, 0, 0);
            return;
        }
        Views.setVisible(this.f, true);
        RecyclerView recyclerView = this.a;
        int i2 = this.g;
        recyclerView.setPadding(0, i2, 0, i2);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public boolean isSearchOpen() {
        return this.r;
    }

    public final void j() {
        Menu menu = this.e.getMenu();
        if (menu != null) {
            e(menu, true);
        }
    }

    public final void k() {
        Menu menu = this.e.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "toolbar.menu");
        Context context = this.e.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "toolbar.context");
        ToolbarSearchViewKt.tintIcons(menu, context, this.x);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.n;
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        if (!isSearchOpen()) {
            d();
        }
        return this.o;
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void notifyDataSetChanged() {
        RecyclerView.Adapter adapter = this.a.getAdapter();
        if (adapter != null) {
            i();
            adapter.notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("Adapter must be provided via setter".toString());
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == com.avito.android.ui_components.R.id.discard_search) {
            Editable text = this.c.getText();
            if (text == null) {
                return true;
            }
            text.clear();
            return true;
        }
        this.n.accept(Integer.valueOf(menuItem.getItemId()));
        return true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.r = savedState.isOpen();
        this.t = savedState.getLastSelection();
        if (this.r) {
            this.d.performClick();
        }
        this.u = savedState.getMenuItemVisibility();
        setSearchEnabled(savedState.isSearchEnabled());
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Runnable runnable = this.s;
        if (runnable != null) {
            runnable.run();
        }
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        boolean z = this.r;
        Integer num = this.t;
        SparseBooleanArray sparseBooleanArray = this.u;
        if (sparseBooleanArray == null) {
            sparseBooleanArray = new SparseBooleanArray(0);
        }
        return new SavedState(z, num, sparseBooleanArray, this.w, onSaveInstanceState);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    @NotNull
    public Observable<Boolean> openCallbacks() {
        PublishRelay<Boolean> publishRelay = this.p;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "openRelay");
        return publishRelay;
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void removeHint() {
        this.c.setHint("");
        this.d.setHint("");
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void replaceMenuItemIcon(int i2, int i3, boolean z, boolean z2) {
        MenuItem findItem = this.e.getMenu().findItem(i2);
        if (findItem != null) {
            findItem.setIcon(getContext().getDrawable(i3));
            if (z) {
                if (z2) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    MenuItemsKt.tintIconByColorRes(findItem, context, com.avito.android.lib.design.avito.R.color.expected_favorites_icon_selected);
                    return;
                }
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                MenuItemsKt.tintIconByAttr(findItem, context2, R.attr.blue);
            }
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void replaceMenuItemTitle(int i2, int i3) {
        MenuItem findItem = this.e.getMenu().findItem(i2);
        if (findItem != null) {
            findItem.setTitle(getResources().getString(i3));
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setAdapter(@Nullable RecyclerView.Adapter<?> adapter) {
        this.y = adapter;
        this.a.setAdapter(adapter);
        this.a.setItemAnimator(null);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        SpannableString spannableString = new SpannableString(VKApiPhotoSize.X + str);
        Drawable drawable = getContext().getDrawable(com.avito.android.ui_components.R.drawable.ic_search_16_with_right_padding);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.getDrawable(R.dr…_16_with_right_padding)!!");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Drawable wrapForTinting = DrawablesKt.wrapForTinting(drawable, Contexts.getColorByAttr(context, R.attr.gray28));
        wrapForTinting.setBounds(0, 0, wrapForTinting.getIntrinsicWidth(), wrapForTinting.getIntrinsicHeight());
        spannableString.setSpan(new VerticalCenteredImageSpan(wrapForTinting), 0, 1, 34);
        this.c.setHint(spannableString);
        this.d.setHint(spannableString);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setMenu(@MenuRes int i2) {
        View findViewById;
        this.e.getMenu().clear();
        this.e.inflateMenu(i2);
        this.u = new SparseBooleanArray(this.e.getMenu().size());
        Menu menu = this.e.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "toolbar.menu");
        ToolbarSearchViewKt.access$foreach(menu, new a2.a.a.l0.a.c.d(this));
        boolean z = false;
        if (this.h == null) {
            this.e.getMenu().add(0, com.avito.android.ui_components.R.id.discard_search, 0, getResources().getString(com.avito.android.ui_components.R.string.dismiss)).setIcon(com.avito.android.ui_components.R.drawable.ic_clear_states).setVisible(false).setShowAsAction(2);
        }
        int i3 = com.avito.android.ui_components.R.layout.search_action;
        Menu menu2 = this.e.getMenu();
        int i4 = com.avito.android.ui_components.R.id.search_action;
        menu2.add(0, i4, 0, com.avito.android.ui_components.R.string.search).setActionView(i3).setVisible(false).setShowAsAction(2);
        MenuItem findItem = this.e.getMenu().findItem(i4);
        View actionView = findItem != null ? findItem.getActionView() : null;
        if (actionView != null) {
            Views.changePadding(actionView, 0, 0, Views.dpToPx(this.c, 6), 0);
        }
        if (!(actionView == null || (findViewById = actionView.findViewById(com.avito.android.ui_components.R.id.search_button)) == null)) {
            findViewById.setOnClickListener(new a2.a.a.l0.a.c.a(this));
        }
        this.e.getMenu().add(0, com.avito.android.ui_components.R.id.progress_indicator, 0, "").setActionView(com.avito.android.ui_components.R.layout.progress_action).setVisible(false).setShowAsAction(2);
        if (isSearchOpen()) {
            Editable text = this.c.getText();
            if (text == null || text.length() == 0) {
                z = true;
            }
            if (z) {
                c();
            } else {
                h();
            }
            j();
        }
        int i5 = com.avito.android.ui_components.R.menu.item_list_saved_searches_push;
        if (i2 == i5) {
            g();
        }
        if (i2 == com.avito.android.ui_components.R.menu.item_list_custom_clarify || i2 == i5) {
            showSelectedFiltersCount(this.k);
        }
        k();
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setMenuItemVisible(int i2, boolean z) {
        MenuItem findItem;
        if (!this.r && (findItem = this.e.getMenu().findItem(i2)) != null) {
            findItem.setVisible(z);
        }
        SparseBooleanArray sparseBooleanArray = this.u;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(i2, z);
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setMenuTintColor(@ColorRes int i2) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.x = Contexts.getColorCompat(context, i2);
        k();
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setMenuTintColorAttr(@AttrRes int i2) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.x = Contexts.getColorByAttr(context, i2);
        k();
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setNavigationIcon(@DrawableRes int i2) {
        this.q = Integer.valueOf(i2);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setQuery(@StringRes int i2) {
        this.c.setText(i2);
        this.d.setText(i2);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setSearchEnabled(boolean z) {
        this.w = z;
        this.c.setFocusableInTouchMode(z);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void showActionProgress() {
        Menu menu = this.e.getMenu();
        if (menu != null) {
            View view = this.h;
            if (view != null) {
                view.setVisibility(8);
            }
            ToolbarSearchViewKt.access$foreach(menu, a2.a.a.l0.a.c.b.a);
            b();
            e(menu, false);
            f(menu, true);
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void showSelectedFiltersCount(int i2) {
        Drawable background;
        Drawable mutate;
        MenuItem findItem;
        this.k = i2;
        if ((this.i == null || this.j == null) && (findItem = this.e.getMenu().findItem(com.avito.android.ui_components.R.id.menu_clarify)) != null) {
            findItem.setActionView(com.avito.android.ui_components.R.layout.clarify_action);
            findItem.setTitle(com.avito.android.ui_components.R.string.clarify);
            View actionView = findItem.getActionView();
            Intrinsics.checkNotNullExpressionValue(actionView, "clarifyActionItem.actionView");
            View findViewById = actionView.findViewById(com.avito.android.ui_components.R.id.clarify_placeholder);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            this.i = findViewById;
            View actionView2 = findItem.getActionView();
            Intrinsics.checkNotNullExpressionValue(actionView2, "clarifyActionItem.actionView");
            View findViewById2 = actionView2.findViewById(com.avito.android.ui_components.R.id.filters_badge_counter);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById2;
            this.j = textView;
            this.v = Float.valueOf(textView.getTextSize());
            findItem.getActionView().setOnClickListener(new a2.a.a.l0.a.c.f(this, findItem));
        }
        View view = this.i;
        if (!(view == null || (background = view.getBackground()) == null || (mutate = background.mutate()) == null)) {
            Intrinsics.checkNotNullExpressionValue(mutate, "clarifyPlaceholder?.background?.mutate() ?: return");
            mutate.setTint(this.x);
            View view2 = this.i;
            if (view2 != null) {
                view2.setBackground(mutate);
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setBackground(getContext().getDrawable(com.avito.android.ui_components.R.drawable.bg_badge_blue));
            }
        }
        TextView textView3 = this.j;
        if (textView3 == null) {
            return;
        }
        if (i2 == 0) {
            Views.setVisible(textView3, false);
            return;
        }
        Views.setVisible(textView3, true);
        textView3.setText(String.valueOf(i2));
        Float f2 = this.v;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            if (String.valueOf(i2).length() > 1) {
                floatValue *= 1.0f;
            }
            textView3.setTextSize(0, floatValue);
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void showTapTarget(@IdRes int i2, @StringRes int i3, @StringRes @Nullable Integer num) {
        String string = getResources().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(titleRes)");
        PersistableTabTarget persistableTabTarget = new PersistableTabTarget(new e(this, i2), string, num != null ? getResources().getString(num.intValue()) : null);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TapTarget applyStyle = TapTargetsKt.applyStyle(persistableTabTarget, new AvitoBrandTapTargetStyle(context));
        Context context2 = getContext();
        Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
        TapTargetView showFor = TapTargetView.showFor((Activity) context2, applyStyle);
        Intrinsics.checkNotNullExpressionValue(showFor, "TapTargetView.showFor(co…t as Activity, tapTarget)");
        TapTargetViewExtensionsKt.setDimAlpha(showFor, 0.88f);
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void showTooltipToMenuItem(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        ImageView imageView = this.l;
        if (imageView != null) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            TooltipContentKt.content(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.Center(new AnchorPositions.Center()))), new f(str)).show(imageView);
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    @NotNull
    public Observable<String> submitCallbacks() {
        Observable<String> doOnNext = RxTextView.editorActions$default(this.c, null, 1, null).map(new g(this)).doOnNext(new h(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "editText\n            .ed…y.text = it\n            }");
        return doOnNext;
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    @NotNull
    public Observable<String> textChangeCallbacks() {
        Observable<R> map = RxTextView.textChanges(this.c).doOnNext(new i(this)).map(j.a);
        Intrinsics.checkNotNullExpressionValue(map, "editText\n            .te…   .map { it.toString() }");
        return map;
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void toggleSubscriptionButton(@NotNull SubscriptionButtonState subscriptionButtonState) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(subscriptionButtonState, "subscriptionButtonState");
        g();
        int ordinal = subscriptionButtonState.ordinal();
        if (ordinal == 0) {
            ImageView imageView2 = this.l;
            if (imageView2 != null) {
                imageView2.setImageResource(com.avito.android.ui_components.R.drawable.ic_saved_search_24);
            }
        } else if (ordinal == 1) {
            ImageView imageView3 = this.l;
            if (imageView3 != null) {
                imageView3.setImageResource(com.avito.android.ui_components.R.drawable.ic_save_search_24);
            }
        } else if (ordinal == 2 && (imageView = this.l) != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            CircularProgressDrawable.Builder builder = new CircularProgressDrawable.Builder(context, false, 2, null);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            CircularProgressDrawable build = builder.color(Contexts.getColorByAttr(context2, R.attr.blue)).build();
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            build.setSize(Views.dpToPx(context3, 16));
            imageView.setImageDrawable(build);
        }
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void updateActiveQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.c.setText(str);
        this.c.setSelection(str.length());
    }

    @Override // com.avito.android.design.widget.search_view.ToolbarSearchView
    public void setQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.c.setText(str);
        this.d.setText(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dB3\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001c\u0010 J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getLastSelection", "()Ljava/lang/Integer;", "lastSelection", "", "d", "Z", "isSearchEnabled", "()Z", AuthSource.SEND_ABUSE, "isOpen", "Landroid/util/SparseBooleanArray;", "c", "Landroid/util/SparseBooleanArray;", "getMenuItemVisibility", "()Landroid/util/SparseBooleanArray;", "menuItemVisibility", "source", "<init>", "(Landroid/os/Parcel;)V", "Landroid/os/Parcelable;", "superState", "(ZLjava/lang/Integer;Landroid/util/SparseBooleanArray;ZLandroid/os/Parcelable;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public final boolean a;
        @Nullable
        public final Integer b;
        @NotNull
        public final SparseBooleanArray c;
        public final boolean d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/search_view/ToolbarSearchViewImpl$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(t6.r.a.j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "source");
            this.a = ParcelsKt.readBool(parcel);
            Object readValue = parcel.readValue(Integer.class.getClassLoader());
            this.b = (Integer) (!(readValue instanceof Integer) ? null : readValue);
            SparseBooleanArray readSparseBooleanArray = parcel.readSparseBooleanArray();
            Intrinsics.checkNotNull(readSparseBooleanArray);
            this.c = readSparseBooleanArray;
            this.d = ParcelsKt.readBool(parcel);
        }

        @Nullable
        public final Integer getLastSelection() {
            return this.b;
        }

        @NotNull
        public final SparseBooleanArray getMenuItemVisibility() {
            return this.c;
        }

        public final boolean isOpen() {
            return this.a;
        }

        public final boolean isSearchEnabled() {
            return this.d;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
            super.writeToParcel(parcel, i);
            ParcelsKt.writeBool(parcel, this.a);
            ParcelsKt.writeNullableValue(parcel, this.b);
            parcel.writeSparseBooleanArray(this.c);
            ParcelsKt.writeBool(parcel, this.d);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(boolean z, @Nullable Integer num, @NotNull SparseBooleanArray sparseBooleanArray, boolean z2, @NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(sparseBooleanArray, "menuItemVisibility");
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            this.a = z;
            this.b = num;
            this.c = sparseBooleanArray;
            this.d = z2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ToolbarSearchViewImpl(Context context, AttributeSet attributeSet, int i2, int i3, t6.r.a.j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
