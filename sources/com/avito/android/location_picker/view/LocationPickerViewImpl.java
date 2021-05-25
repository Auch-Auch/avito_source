package com.avito.android.location_picker.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMoveReason;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapPointKt;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.di.PerActivity;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.location_picker.R;
import com.avito.android.location_picker.RadiusItemDecoration;
import com.avito.android.location_picker.UtilsKt;
import com.avito.android.location_picker.analytics.ScreenCloseFromBlock;
import com.avito.android.location_picker.di.AddressKindsValidation;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.location_picker.di.ShowSearchRadius;
import com.avito.android.location_picker.entities.AdvertsCountError;
import com.avito.android.location_picker.entities.AdvertsCountNetworkError;
import com.avito.android.location_picker.entities.ChangeAdvertsCountUpdate;
import com.avito.android.location_picker.entities.ChangeRadiusUpdate;
import com.avito.android.location_picker.entities.EmptyAddressError;
import com.avito.android.location_picker.entities.LocationPickerNotification;
import com.avito.android.location_picker.entities.Message;
import com.avito.android.location_picker.entities.NetworkError;
import com.avito.android.location_picker.entities.NetworkErrorOnConfirmation;
import com.avito.android.location_picker.entities.NoSuggestsError;
import com.avito.android.location_picker.entities.None;
import com.avito.android.location_picker.entities.NotGrantedPermissions;
import com.avito.android.location_picker.entities.NotSuggestedAddressError;
import com.avito.android.location_picker.entities.RadiusWidgetUpdate;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.location_picker.providers.LocationPickerResourceProvider;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.ui.view.BackPressedNotifyingEditText;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Snackbars;
import com.avito.android.util.Views;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxbinding4.widget.RxTextView;
import com.jakewharton.rxbinding4.widget.TextViewAfterTextChangeEvent;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@PerActivity
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005\u0002qÌ\u0001Bb\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\u0010¬\u0001\u001a\u00030©\u0001\u0012\b\b\u0001\u0010Q\u001a\u00020\u0012\u0012\t\b\u0001\u0010\u0001\u001a\u00020\u0012\u0012\b\u0010ú\u0001\u001a\u00030÷\u0001\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010p\u001a\u0004\u0018\u00010m\u0012\b\u0010þ\u0001\u001a\u00030û\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010'\u001a\n $*\u0004\u0018\u00010#0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010.R\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u0012008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\"\u00109\u001a\b\u0012\u0004\u0012\u000206008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00104R\"\u0010=\u001a\b\u0012\u0004\u0012\u00020:008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u00102\u001a\u0004\b<\u00104R\"\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u0016R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010DR\"\u0010J\u001a\b\u0012\u0004\u0012\u0002060\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bH\u0010\u0014\u001a\u0004\bI\u0010\u0016R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR(\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0Z008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b[\u00102\u001a\u0004\b\\\u00104R\"\u0010a\u001a\b\u0012\u0004\u0012\u00020^0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b_\u0010\u000b\u001a\u0004\b`\u0010.R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\"\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bj\u0010\u000b\u001a\u0004\bk\u0010.R\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010DR\u0016\u0010{\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010DR\"\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b|\u0010\u0014\u001a\u0004\b}\u0010\u0016R$\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012008\u0016@\u0016X\u0004¢\u0006\r\n\u0004\b\u00102\u001a\u0005\b\u0001\u00104R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\t8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010.R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00102\u001a\u0005\b\u0001\u00104R%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u0014\u001a\u0005\b\u0001\u0010\u0016R%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u00102\u001a\u0005\b\u0001\u00104R\u0018\u0010\u0001\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010PR&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\t8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u000b\u001a\u0005\b\u0001\u0010.R\u0018\u0010\u0001\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010DR%\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u0002060\u00118\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\u0014\u001a\u0005\b \u0001\u0010\u0016R&\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010\u00118\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b£\u0001\u0010\u0014\u001a\u0005\b¤\u0001\u0010\u0016R%\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u000b\u001a\u0005\b§\u0001\u0010.R\u001a\u0010¬\u0001\u001a\u00030©\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R%\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b­\u0001\u0010\u0014\u001a\u0005\b®\u0001\u0010\u0016R%\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b°\u0001\u00102\u001a\u0005\b±\u0001\u00104R&\u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030³\u0001008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b´\u0001\u00102\u001a\u0005\bµ\u0001\u00104R%\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b·\u0001\u0010\u0014\u001a\u0005\b¸\u0001\u0010\u0016R\u001a\u0010½\u0001\u001a\u00030º\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R%\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b¾\u0001\u00102\u001a\u0005\b¿\u0001\u00104R%\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bÁ\u0001\u0010\u000b\u001a\u0005\bÂ\u0001\u0010.R%\u0010Æ\u0001\u001a\t\u0012\u0005\u0012\u00030Ä\u0001008\u0016@\u0016X\u0004¢\u0006\r\n\u0004\bP\u00102\u001a\u0005\bÅ\u0001\u00104R\u0018\u0010È\u0001\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÇ\u0001\u0010TR%\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u000206008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bÉ\u0001\u00102\u001a\u0005\bÊ\u0001\u00104R\u0018\u0010Í\u0001\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÌ\u0001\u0010DR\u001a\u0010Ð\u0001\u001a\u00030Î\u00018\u0002@\u0002XD¢\u0006\b\n\u0006\bÏ\u0001\u0010·\u0001R%\u0010Ó\u0001\u001a\b\u0012\u0004\u0012\u00020\u0012008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bÑ\u0001\u00102\u001a\u0005\bÒ\u0001\u00104R&\u0010×\u0001\u001a\t\u0012\u0005\u0012\u00030Ô\u0001008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bÕ\u0001\u00102\u001a\u0005\bÖ\u0001\u00104R\u0019\u0010Ú\u0001\u001a\u00030Ø\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÙ\u0001\u0010,R\u0018\u0010Ü\u0001\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÛ\u0001\u0010DR%\u0010ß\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bÝ\u0001\u0010\u0014\u001a\u0005\bÞ\u0001\u0010\u0016R#\u0010å\u0001\u001a\u00030à\u00018B@\u0002X\u0002¢\u0006\u0010\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001R\u001a\u0010é\u0001\u001a\u00030æ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R&\u0010í\u0001\u001a\t\u0012\u0005\u0012\u00030ê\u0001008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bë\u0001\u00102\u001a\u0005\bì\u0001\u00104R&\u0010ð\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\t8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\bî\u0001\u0010\u000b\u001a\u0005\bï\u0001\u0010.R\u001a\u0010ô\u0001\u001a\u00030ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u0018\u0010ö\u0001\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bõ\u0001\u0010DR\u001a\u0010ú\u0001\u001a\u00030÷\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001a\u0010þ\u0001\u001a\u00030û\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u001c\u0010\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010\u000b\u001a\u0005\b\u0002\u0010.R%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010\u0014\u001a\u0005\b\u0002\u0010\u0016R(\u0010\u0002\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¢\u0001008\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0002\u00102\u001a\u0005\b\u0002\u00104¨\u0006\u0002"}, d2 = {"Lcom/avito/android/location_picker/view/LocationPickerViewImpl;", "Lcom/avito/android/location_picker/view/LocationPickerInputView;", "Lcom/avito/android/location_picker/view/LocationPickerOutputView;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", "Lcom/avito/android/avito_map/AvitoMap;", "map", "", "onMapAttach", "(Lcom/avito/android/avito_map/AvitoMap;)V", "Lcom/jakewharton/rxrelay3/Relay;", "B", "Lcom/jakewharton/rxrelay3/Relay;", "mapInitializedRelay", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "h", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "findMeButton", "Lio/reactivex/rxjava3/core/Observable;", "", "Q", "Lio/reactivex/rxjava3/core/Observable;", "getSearchFocus", "()Lio/reactivex/rxjava3/core/Observable;", "searchFocus", ExifInterface.LATITUDE_SOUTH, "getChooseClicked", "chooseClicked", "Landroid/app/Activity;", "o0", "Landroid/app/Activity;", "activity", "Lcom/avito/android/location_picker/view/LocationPickerChooseButtonLocation;", "t0", "Lcom/avito/android/location_picker/view/LocationPickerChooseButtonLocation;", "chooseButtonLocation", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/widget/FrameLayout;", "mapView", "Landroid/widget/HorizontalScrollView;", "n", "Landroid/widget/HorizontalScrollView;", "editQueryContainer", "F", "getSettingsClicked", "()Lcom/jakewharton/rxrelay3/Relay;", "settingsClicked", "Lio/reactivex/rxjava3/functions/Consumer;", "d0", "Lio/reactivex/rxjava3/functions/Consumer;", "getChangeSearchFocus", "()Lio/reactivex/rxjava3/functions/Consumer;", "changeSearchFocus", "", "f0", "getChangeSearchQuery", "changeSearchQuery", "Lcom/avito/android/location_picker/entities/ChangeAdvertsCountUpdate;", "m0", "getChangeAdvertsCount", "changeAdvertsCount", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", ExifInterface.LONGITUDE_WEST, "getSuggestionClicked", "suggestionClicked", "Landroid/view/View;", "e", "Landroid/view/View;", "pinShadow", "k", "clearQueryButton", "P", "getTextQueryChanged", "textQueryChanged", "Lcom/avito/android/location_picker/view/SearchRadiusViewImpl;", "t", "Lcom/avito/android/location_picker/view/SearchRadiusViewImpl;", "searchRadiusView", "q0", "Z", "hasSearchRadius", "Landroidx/recyclerview/widget/RecyclerView;", "o", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "w", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "", "h0", "getChangeShownSuggestions", "changeShownSuggestions", "Lcom/avito/android/location_picker/analytics/ScreenCloseFromBlock;", "u", "getScreenClosed", "screenClosed", "Lcom/avito/android/location_picker/view/RadiusAdapterImpl;", VKApiConst.VERSION, "Lcom/avito/android/location_picker/view/RadiusAdapterImpl;", "radiusAdapter", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "C", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "addressValidationTooltip", "K", "getDialogOkButtonClicked", "dialogOkButtonClicked", "Lcom/avito/android/avito_map/AvitoMapTarget;", "u0", "Lcom/avito/android/avito_map/AvitoMapTarget;", "savedMapTarget", "c", "Lcom/avito/android/avito_map/AvitoMap;", "avitoMap", "Landroid/widget/TextView;", "r", "Landroid/widget/TextView;", "selectRadiusButton", "j", "markerProgress", a2.g.r.g.a, "pinContainer", "T", "getFindMeClicked", "findMeClicked", "b0", "getLoadingIndicatorOnButton", "loadingIndicatorOnButton", "Lcom/avito/android/location_picker/view/SuggestionsAdapter;", "x", "Lcom/avito/android/location_picker/view/SuggestionsAdapter;", "adapter", "Lcom/avito/android/avito_map/AvitoMapBounds;", "L", "getCameraMoveEnd", "cameraMoveEnd", "Lcom/google/android/material/snackbar/Snackbar;", "y", "Lcom/google/android/material/snackbar/Snackbar;", "snackBar", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "i0", "getChangeCameraPosition", "changeCameraPosition", "U", "getMapConcealerClicked", "mapConcealerClicked", "l0", "getChangeRadiusVisibility", "changeRadiusVisibility", "r0", "addressKindsValidation", "H", "getCameraIdlePositionChanged", "cameraIdlePositionChanged", VKApiConst.Q, "searchRadiusContainer", "O", "getSearchClicked", "searchClicked", "Lcom/avito/android/remote/model/SearchRadius;", "X", "getRadiusClicked", "radiusClicked", "G", "getCameraMovedByGesture", "cameraMovedByGesture", "Lcom/avito/android/util/DialogRouter;", "p0", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "N", "getMapInitialized", "mapInitialized", "g0", "getCleanSearchQuery", "cleanSearchQuery", "Lcom/avito/android/location_picker/entities/RadiusWidgetUpdate;", "k0", "getChangeRadiusWidgetSize", "changeRadiusWidgetSize", "J", "getBackClicked", "backClicked", "Lcom/avito/android/ui/view/BackPressedNotifyingEditText;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/ui/view/BackPressedNotifyingEditText;", "editQuery", "Y", "getChangeChooseButtonIsActive", "changeChooseButtonIsActive", "M", "getCameraMoveStart", "cameraMoveStart", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "getCloseWithResults", "closeWithResults", "p", "radiusRecyclerView", "c0", "getShowAddressValidationError", "showAddressValidationError", "d", "mainContainer", "", "D", "searchRadiusAnimationDuration", "e0", "getChangeProgressVisibility", "changeProgressVisibility", "Lcom/avito/android/location_picker/entities/LocationPickerNotification;", "n0", "getChangeNotification", "changeNotification", "", AuthSource.SEND_ABUSE, "animationY", "l", "suggestionContainer", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "getSelectRadiusButtonClicked", "selectRadiusButtonClicked", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Lazy;", "getMapWidth", "()I", "mapWidth", "Lcom/avito/android/location_picker/view/LocationPickerViewImpl$ChooseButton;", "i", "Lcom/avito/android/location_picker/view/LocationPickerViewImpl$ChooseButton;", "chooseButton", "Lcom/avito/android/location_picker/entities/ChangeRadiusUpdate;", "j0", "getSelectRadiusBubble", "selectRadiusBubble", "I", "getVisibleRegionChanged", "visibleRegionChanged", "Landroid/widget/ViewSwitcher;", "s", "Landroid/widget/ViewSwitcher;", "searchRadiusViewSwitcher", "f", "mapConcealer", "Lcom/avito/android/location_picker/job/SendLocationToJobAssistant;", "s0", "Lcom/avito/android/location_picker/job/SendLocationToJobAssistant;", "sendLocationToJobAssistant", "Lcom/avito/android/location_picker/providers/LocationPickerResourceProvider;", "v0", "Lcom/avito/android/location_picker/providers/LocationPickerResourceProvider;", "resourceProvider", "Landroid/app/Dialog;", "z", "Landroid/app/Dialog;", "dialog", ExifInterface.LONGITUDE_EAST, "getRetryClicked", "retryClicked", "R", "getCleanQueryClicked", "cleanQueryClicked", "a0", "getCloseWithRadiusResults", "closeWithRadiusResults", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "mapAttachHelper", "<init>", "(Landroid/app/Activity;Lcom/avito/android/util/DialogRouter;ZZLcom/avito/android/location_picker/job/SendLocationToJobAssistant;Lcom/avito/android/location_picker/view/LocationPickerChooseButtonLocation;Lcom/avito/android/avito_map/AvitoMapAttachHelper;Lcom/avito/android/avito_map/AvitoMapTarget;Lcom/avito/android/location_picker/providers/LocationPickerResourceProvider;)V", "ChooseButton", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerViewImpl implements LocationPickerInputView, LocationPickerOutputView, AvitoMapAttachHelper.MapAttachListener {
    public final Lazy A;
    public final Relay<Unit> B;
    public Tooltip C;
    public final long D;
    @NotNull
    public final Relay<Unit> E;
    @NotNull
    public final Relay<Unit> F;
    @NotNull
    public final Relay<Unit> G;
    @NotNull
    public final Relay<AvitoMapCameraPosition> H;
    @NotNull
    public final Relay<AvitoMapBounds> I;
    @NotNull
    public final Observable<Unit> J;
    @NotNull
    public final Relay<Unit> K;
    @NotNull
    public final Relay<AvitoMapBounds> L;
    @NotNull
    public final Relay<Unit> M;
    @NotNull
    public final Observable<Unit> N;
    @NotNull
    public final Observable<String> O;
    @NotNull
    public final Observable<String> P;
    @NotNull
    public final Observable<Boolean> Q;
    @NotNull
    public final Observable<Unit> R;
    @NotNull
    public final Observable<Unit> S;
    @NotNull
    public final Observable<Unit> T;
    @NotNull
    public final Observable<Unit> U;
    @NotNull
    public final Observable<Unit> V;
    @NotNull
    public final Observable<AddressSuggestion> W;
    @NotNull
    public final Observable<SearchRadius> X;
    @NotNull
    public final Consumer<Boolean> Y;
    @NotNull
    public final Consumer<AddressParameter.Value> Z;
    public final float a;
    @NotNull
    public final Consumer<SearchRadius> a0;
    public final FrameLayout b;
    @NotNull
    public final Consumer<Boolean> b0;
    public AvitoMap c;
    @NotNull
    public final Consumer<String> c0;
    public final View d;
    @NotNull
    public final Consumer<Boolean> d0;
    public final View e;
    @NotNull
    public final Consumer<Boolean> e0;
    public final View f;
    @NotNull
    public final Consumer<String> f0;
    public final View g;
    @NotNull
    public final Consumer<Unit> g0;
    public final FloatingActionButton h;
    @NotNull
    public final Consumer<List<AddressSuggestion>> h0;
    public final ChooseButton i;
    @NotNull
    public final Consumer<AvitoMapCameraPosition> i0;
    public final View j;
    @NotNull
    public final Consumer<ChangeRadiusUpdate> j0;
    public final View k;
    @NotNull
    public final Consumer<RadiusWidgetUpdate> k0;
    public final View l;
    @NotNull
    public final Consumer<Boolean> l0;
    public final BackPressedNotifyingEditText m;
    @NotNull
    public final Consumer<ChangeAdvertsCountUpdate> m0;
    public final HorizontalScrollView n;
    @NotNull
    public final Consumer<LocationPickerNotification> n0;
    public final RecyclerView o;
    public final Activity o0;
    public final RecyclerView p;
    public final DialogRouter p0;
    public final View q;
    public final boolean q0;
    public final TextView r;
    public final boolean r0;
    public final ViewSwitcher s;
    public final SendLocationToJobAssistant s0;
    public final SearchRadiusViewImpl t;
    public final LocationPickerChooseButtonLocation t0;
    @NotNull
    public final Relay<ScreenCloseFromBlock> u;
    public final AvitoMapTarget u0;
    public final RadiusAdapterImpl v;
    public final LocationPickerResourceProvider v0;
    public final ProgressOverlay w;
    public final SuggestionsAdapter x;
    public Snackbar y;
    public Dialog z;

    public interface ChooseButton {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static void setEnabled(@NotNull ChooseButton chooseButton, boolean z) {
                if (z) {
                    chooseButton.enable();
                } else {
                    chooseButton.disable();
                }
            }

            public static void setVisible(@NotNull ChooseButton chooseButton, boolean z) {
                if (z) {
                    chooseButton.show();
                } else {
                    chooseButton.hide();
                }
            }
        }

        void disable();

        void enable();

        @NotNull
        Observable<Unit> getClicksObservable();

        void hide();

        void setEnabled(boolean z);

        void setLoading(boolean z);

        void setVisible(boolean z);

        void show();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LocationPickerChooseButtonLocation.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Boolean bool) {
            int i = this.a;
            if (i == 0) {
                Boolean bool2 = bool;
                ChooseButton chooseButton = ((LocationPickerViewImpl) this.b).i;
                Intrinsics.checkNotNullExpressionValue(bool2, "it");
                chooseButton.setEnabled(bool2.booleanValue());
            } else if (i == 1) {
                Boolean bool3 = bool;
                View view = ((LocationPickerViewImpl) this.b).j;
                Intrinsics.checkNotNullExpressionValue(bool3, "it");
                Views.setVisible(view, bool3.booleanValue());
            } else if (i == 2) {
                Boolean bool4 = bool;
                LocationPickerViewImpl locationPickerViewImpl = (LocationPickerViewImpl) this.b;
                Intrinsics.checkNotNullExpressionValue(bool4, "visible");
                LocationPickerViewImpl.access$animateSearchRadiusAlpha(locationPickerViewImpl, bool4.booleanValue() ? 1.0f : 0.0f);
            } else if (i == 3) {
                Boolean bool5 = bool;
                if (!bool5.booleanValue()) {
                    LocationPickerViewImpl locationPickerViewImpl2 = (LocationPickerViewImpl) this.b;
                    LocationPickerViewImpl.access$scrollToEnd(locationPickerViewImpl2, locationPickerViewImpl2.n);
                    ((LocationPickerViewImpl) this.b).m.clearFocus();
                    Keyboards.hideKeyboard(((LocationPickerViewImpl) this.b).o0);
                } else {
                    ((LocationPickerViewImpl) this.b).m.requestFocus();
                    Keyboards.showKeyboard$default(((LocationPickerViewImpl) this.b).m, 0, 1, null);
                }
                View view2 = ((LocationPickerViewImpl) this.b).f;
                Intrinsics.checkNotNullExpressionValue(bool5, "hasFocus");
                Views.setVisible(view2, bool5.booleanValue());
            } else if (i == 4) {
                Boolean bool6 = bool;
                if (!((LocationPickerViewImpl) this.b).r0) {
                    ChooseButton chooseButton2 = ((LocationPickerViewImpl) this.b).i;
                    Intrinsics.checkNotNullExpressionValue(bool6, "it");
                    chooseButton2.setLoading(bool6.booleanValue());
                    ((LocationPickerViewImpl) this.b).i.setEnabled(!bool6.booleanValue());
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LocationPickerViewImpl a;

        public b(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.a.q0) {
                this.a.getScreenClosed().accept(ScreenCloseFromBlock.CANCEL);
            }
            this.a.o0.finish();
        }
    }

    public static final class c implements ChooseButton {
        public final TextView a;

        public c(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            View findViewById = activity.findViewById(R.id.choose_button);
            Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(R.id.choose_button)");
            TextView textView = (TextView) findViewById;
            this.a = textView;
            Views.show(textView);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void disable() {
            Views.disable(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void enable() {
            Views.enable(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        @NotNull
        public Observable<Unit> getClicksObservable() {
            return RxView.clicks(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void hide() {
            Views.hide(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void setEnabled(boolean z) {
            ChooseButton.DefaultImpls.setEnabled(this, z);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void setLoading(boolean z) {
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void setVisible(boolean z) {
            ChooseButton.DefaultImpls.setVisible(this, z);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void show() {
            Views.show(this.a);
        }
    }

    public static final class d implements ChooseButton {
        public final Button a;

        public d(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            View findViewById = activity.findViewById(R.id.main_button);
            Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(R.id.main_button)");
            Button button = (Button) findViewById;
            this.a = button;
            String string = button.getContext().getString(R.string.lp_choose_footer);
            Intrinsics.checkNotNullExpressionValue(string, "button.context.getString….string.lp_choose_footer)");
            button.setText(string);
            Views.show(button);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void disable() {
            Views.disable(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void enable() {
            Views.enable(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        @NotNull
        public Observable<Unit> getClicksObservable() {
            return RxView.clicks(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void hide() {
            Views.hide(this.a);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void setEnabled(boolean z) {
            ChooseButton.DefaultImpls.setEnabled(this, z);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void setLoading(boolean z) {
            this.a.setLoading(z);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void setVisible(boolean z) {
            ChooseButton.DefaultImpls.setVisible(this, z);
        }

        @Override // com.avito.android.location_picker.view.LocationPickerViewImpl.ChooseButton
        public void show() {
            Views.show(this.a);
        }
    }

    public static final class e<T> implements Consumer<ChangeAdvertsCountUpdate> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public e(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ChangeAdvertsCountUpdate changeAdvertsCountUpdate) {
            this.a.r.setText(this.a.v0.getAdvertsCountTitle((int) changeAdvertsCountUpdate.getCount()));
        }
    }

    public static final class f<T> implements Consumer<AvitoMapCameraPosition> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public f(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AvitoMapCameraPosition avitoMapCameraPosition) {
            AvitoMapCameraPosition avitoMapCameraPosition2 = avitoMapCameraPosition;
            AvitoMap avitoMap = this.a.c;
            if (avitoMap != null) {
                boolean z = avitoMapCameraPosition2.getZoomLevel() != avitoMap.getMapTarget().getZoomLevel();
                boolean z2 = !AvitoMapPointKt.almostEqual(avitoMapCameraPosition2.getMapPoint(), avitoMap.getMapTarget().getPoint());
                if (avitoMapCameraPosition2.getViewportBounds() != null) {
                    AvitoMapBounds viewportBounds = avitoMapCameraPosition2.getViewportBounds();
                    if (viewportBounds != null) {
                        avitoMap.moveTo(viewportBounds, true);
                    }
                } else if (z && z2) {
                    avitoMap.moveTo(avitoMapCameraPosition2.getMapPoint(), true, Float.valueOf(avitoMapCameraPosition2.getZoomLevel()));
                } else if (z) {
                    AvitoMap.DefaultImpls.zoomTo$default(avitoMap, avitoMapCameraPosition2.getZoomLevel(), false, null, 6, null);
                } else if (z2) {
                    AvitoMap.DefaultImpls.moveTo$default(avitoMap, avitoMapCameraPosition2.getMapPoint(), true, null, 4, null);
                }
            }
        }
    }

    public static final class g<T> implements Consumer<LocationPickerNotification> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public g(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LocationPickerNotification locationPickerNotification) {
            String str;
            LocationPickerNotification locationPickerNotification2 = locationPickerNotification;
            if (locationPickerNotification2 instanceof NetworkErrorOnConfirmation) {
                Snackbar snackbar = this.a.y;
                if (!this.a.q0) {
                    Intrinsics.checkNotNullExpressionValue(snackbar.setText(R.string.lp_network_error_confirmation), "setText(R.string.lp_network_error_confirmation)");
                } else {
                    snackbar.setText(R.string.lp_network_error);
                    this.a.r.setText(this.a.v0.getAdvertsCountErrorMessage());
                }
                snackbar.setAction(R.string.lp_repeat, new b2(0, this));
                if (!snackbar.isShown()) {
                    snackbar.show();
                }
            } else if (locationPickerNotification2 instanceof NotGrantedPermissions) {
                Snackbar snackbar2 = this.a.y;
                Snackbars.getTextView(snackbar2).setMaxLines(3);
                snackbar2.setText(com.avito.android.permissions.R.string.location_permission_required);
                snackbar2.setAction(R.string.lp_settings, new b2(1, this));
                if (!snackbar2.isShown()) {
                    snackbar2.show();
                }
            } else if (locationPickerNotification2 instanceof NetworkError) {
                if (this.a.q0) {
                    this.a.r.setText(this.a.v0.getAdvertsCountErrorMessage());
                }
                Snackbar snackbar3 = this.a.y;
                snackbar3.setText(R.string.lp_network_error);
                snackbar3.setAction(R.string.lp_repeat, new b2(2, this));
                if (!snackbar3.isShown()) {
                    snackbar3.show();
                }
            } else if (locationPickerNotification2 instanceof Message) {
                Snackbar snackbar4 = this.a.y;
                snackbar4.setText(((Message) locationPickerNotification2).getMessage());
                snackbar4.setAction((CharSequence) null, (View.OnClickListener) null);
                if (!snackbar4.isShown()) {
                    snackbar4.show();
                }
            } else if (locationPickerNotification2 instanceof NotSuggestedAddressError) {
                Snackbar snackbar5 = this.a.y;
                snackbar5.setText(R.string.lp_not_suggested_address_error);
                snackbar5.setAction((CharSequence) null, (View.OnClickListener) null);
                if (!snackbar5.isShown()) {
                    snackbar5.show();
                }
            } else if (locationPickerNotification2 instanceof NoSuggestsError) {
                Snackbar snackbar6 = this.a.y;
                snackbar6.setText(R.string.lp_no_suggests_error);
                snackbar6.setAction((CharSequence) null, (View.OnClickListener) null);
                if (!snackbar6.isShown()) {
                    snackbar6.show();
                }
            } else if (locationPickerNotification2 instanceof EmptyAddressError) {
                if (this.a.z == null) {
                    SendLocationToJobAssistant sendLocationToJobAssistant = this.a.s0;
                    if (sendLocationToJobAssistant instanceof SendLocationToJobAssistant.ShouldSend) {
                        str = this.a.o0.getString(R.string.lp_empty_address_error_for_job_assistant);
                    } else if (sendLocationToJobAssistant instanceof SendLocationToJobAssistant.Default) {
                        str = this.a.o0.getString(R.string.lp_empty_address_error);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "when (sendLocationToJobA…_error)\n                }");
                    LocationPickerViewImpl locationPickerViewImpl = this.a;
                    DialogRouter dialogRouter = locationPickerViewImpl.p0;
                    String string = this.a.o0.getString(R.string.lp_error_dialog_ok_button_text);
                    Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…or_dialog_ok_button_text)");
                    locationPickerViewImpl.z = dialogRouter.showSimpleNotifyingDialog(str, string, new a2.a.a.n1.x0.b(this));
                }
            } else if (locationPickerNotification2 instanceof AdvertsCountError) {
                this.a.r.setText(this.a.v0.getAdvertsCountErrorMessage());
            } else if (locationPickerNotification2 instanceof AdvertsCountNetworkError) {
                this.a.r.setText(this.a.v0.getAdvertsCountErrorMessage());
                Snackbar snackbar7 = this.a.y;
                snackbar7.setText(R.string.lp_network_error);
                snackbar7.setAction(R.string.lp_repeat, new b2(3, this));
                if (!snackbar7.isShown()) {
                    snackbar7.show();
                }
            } else if (locationPickerNotification2 instanceof None) {
                this.a.y.dismiss();
            }
        }
    }

    public static final class h<T> implements Consumer<RadiusWidgetUpdate> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public h(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(RadiusWidgetUpdate radiusWidgetUpdate) {
            RadiusWidgetUpdate radiusWidgetUpdate2 = radiusWidgetUpdate;
            this.a.t.setRadius((float) (((double) (radiusWidgetUpdate2.getDistanceInMeters() * ((long) LocationPickerViewImpl.access$getMapWidth$p(this.a)))) / radiusWidgetUpdate2.getDistance()));
        }
    }

    public static final class i<T> implements Consumer<String> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public i(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            if (!Intrinsics.areEqual(str2, String.valueOf(this.a.m.getText()))) {
                this.a.m.setText(str2);
                this.a.m.post(new a2.a.a.n1.x0.c(this));
            }
        }
    }

    public static final class j<T> implements Consumer<List<? extends AddressSuggestion>> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public j(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.avito.android.location_picker.view.SuggestionsAdapter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends AddressSuggestion> list) {
            List<? extends AddressSuggestion> list2 = list;
            if (list2.isEmpty()) {
                Views.setVisible(this.a.l, false);
                return;
            }
            Views.setVisible(this.a.l, true);
            SuggestionsAdapter suggestionsAdapter = this.a.x;
            Intrinsics.checkNotNullExpressionValue(list2, "it");
            suggestionsAdapter.updateList(list2);
        }
    }

    public static final class k<T> implements Consumer<Unit> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public k(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.m.setText("");
        }
    }

    public static final class l<T> implements Consumer<SearchRadius> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public l(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SearchRadius searchRadius) {
            this.a.getScreenClosed().accept(ScreenCloseFromBlock.SELECT);
            Activity activity = this.a.o0;
            Intent intent = new Intent();
            intent.putExtra(LocationPickerModuleKt.EXTRA_RADIUS_RESULT, searchRadius);
            activity.setResult(-1, intent);
            this.a.o0.finish();
        }
    }

    public static final class m<T> implements Consumer<AddressParameter.Value> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public m(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AddressParameter.Value value) {
            Activity activity = this.a.o0;
            Intent intent = new Intent();
            intent.putExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT, value);
            activity.setResult(-1, intent);
            this.a.o0.finish();
        }
    }

    public static final class n extends Lambda implements Function0<Integer> {
        public final /* synthetic */ LocationPickerViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(LocationPickerViewImpl locationPickerViewImpl) {
            super(0);
            this.a = locationPickerViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            FrameLayout frameLayout = this.a.b;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mapView");
            return Integer.valueOf(UtilsKt.widthInPixels(frameLayout));
        }
    }

    public static final class o<T> implements Predicate<Integer> {
        public static final o a = new o();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Integer num) {
            Integer num2 = num;
            return num2 != null && num2.intValue() == 3;
        }
    }

    public static final class p<T, R> implements Function<Integer, String> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public p(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(Integer num) {
            return String.valueOf(this.a.m.getText());
        }
    }

    public static final class q<T> implements Consumer<ChangeRadiusUpdate> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public q(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ChangeRadiusUpdate changeRadiusUpdate) {
            AvitoMapBounds mapBounds;
            ChangeRadiusUpdate changeRadiusUpdate2 = changeRadiusUpdate;
            if (this.a.v.isDataEmpty()) {
                this.a.s.showNext();
            }
            this.a.v.updateData(changeRadiusUpdate2.getSearchRadiusList());
            Long distanceInMeters = changeRadiusUpdate2.getDistanceInMeters();
            if ((distanceInMeters == null || distanceInMeters.longValue() != 0) && (mapBounds = changeRadiusUpdate2.getMapBounds()) != null) {
                List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AvitoMapPoint[]{mapBounds.getTopLeft(), mapBounds.getBottomRight()});
                AvitoMap avitoMap = this.a.c;
                if (avitoMap != null) {
                    AvitoMap.DefaultImpls.moveToPointsWithPadding$default(avitoMap, listOf, Integer.valueOf(this.a.v0.getRadiusWidgetOffset()), false, 4, null);
                }
            }
        }
    }

    public static final class r<T> implements Consumer<String> {
        public final /* synthetic */ LocationPickerViewImpl a;

        public r(LocationPickerViewImpl locationPickerViewImpl) {
            this.a = locationPickerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            Tooltip tooltip = this.a.C;
            if (tooltip != null) {
                tooltip.dismiss();
            }
            this.a.C = null;
            this.a.C = TooltipContentKt.content(Tooltip.setSize$default(new Tooltip(this.a.o0, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.Center(new AnchorPositions.Center()))), -2, 0, 2, null), new a2.a.a.n1.x0.d(str2)).show(this.a.n);
        }
    }

    public static final class s<T, R> implements Function<TextViewAfterTextChangeEvent, String> {
        public static final s a = new s();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
            String obj;
            Editable editable = textViewAfterTextChangeEvent.getEditable();
            return (editable == null || (obj = editable.toString()) == null) ? "" : obj;
        }
    }

    @Inject
    public LocationPickerViewImpl(@NotNull Activity activity, @NotNull DialogRouter dialogRouter, @ShowSearchRadius boolean z2, @AddressKindsValidation boolean z3, @NotNull SendLocationToJobAssistant sendLocationToJobAssistant, @NotNull LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, @NotNull AvitoMapAttachHelper avitoMapAttachHelper, @Nullable AvitoMapTarget avitoMapTarget, @NotNull LocationPickerResourceProvider locationPickerResourceProvider) {
        ChooseButton chooseButton;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(sendLocationToJobAssistant, "sendLocationToJobAssistant");
        Intrinsics.checkNotNullParameter(locationPickerChooseButtonLocation, "chooseButtonLocation");
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "mapAttachHelper");
        Intrinsics.checkNotNullParameter(locationPickerResourceProvider, "resourceProvider");
        this.o0 = activity;
        this.p0 = dialogRouter;
        this.q0 = z2;
        this.r0 = z3;
        this.s0 = sendLocationToJobAssistant;
        this.t0 = locationPickerChooseButtonLocation;
        this.u0 = avitoMapTarget;
        this.v0 = locationPickerResourceProvider;
        this.a = (float) activity.getResources().getDimensionPixelSize(R.dimen.location_picker_pin_animation);
        int i2 = R.id.map;
        this.b = (FrameLayout) activity.findViewById(i2);
        View findViewById = activity.findViewById(R.id.location_picker_screen_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(R.…ation_picker_screen_root)");
        this.d = findViewById;
        View findViewById2 = activity.findViewById(R.id.pin_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "activity.findViewById(R.id.pin_shadow)");
        this.e = findViewById2;
        View findViewById3 = activity.findViewById(R.id.map_concealer);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "activity.findViewById(R.id.map_concealer)");
        this.f = findViewById3;
        View findViewById4 = activity.findViewById(R.id.pin_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "activity.findViewById(R.id.pin_container)");
        this.g = findViewById4;
        View findViewById5 = activity.findViewById(R.id.find_me_button);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "activity.findViewById(R.id.find_me_button)");
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById5;
        this.h = floatingActionButton;
        int ordinal = locationPickerChooseButtonLocation.ordinal();
        if (ordinal == 0) {
            chooseButton = new c(activity);
        } else if (ordinal == 1) {
            chooseButton = new d(activity);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.i = chooseButton;
        View findViewById6 = activity.findViewById(R.id.marker_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "activity.findViewById(R.id.marker_progress)");
        this.j = findViewById6;
        View findViewById7 = activity.findViewById(R.id.clear_button);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "activity.findViewById(R.id.clear_button)");
        this.k = findViewById7;
        View findViewById8 = activity.findViewById(R.id.drop_down_suggestions_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "activity.findViewById(R.…wn_suggestions_container)");
        this.l = findViewById8;
        View findViewById9 = activity.findViewById(R.id.edit_query);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "activity.findViewById(R.id.edit_query)");
        BackPressedNotifyingEditText backPressedNotifyingEditText = (BackPressedNotifyingEditText) findViewById9;
        this.m = backPressedNotifyingEditText;
        View findViewById10 = activity.findViewById(R.id.edit_scroll);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "activity.findViewById(R.id.edit_scroll)");
        this.n = (HorizontalScrollView) findViewById10;
        View findViewById11 = activity.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "activity.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById11;
        this.o = recyclerView;
        View findViewById12 = activity.findViewById(R.id.radius_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "activity.findViewById(R.id.radius_recycler_view)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById12;
        this.p = recyclerView2;
        View findViewById13 = activity.findViewById(R.id.linear_radius_list_container);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "activity.findViewById(R.…ar_radius_list_container)");
        this.q = findViewById13;
        View findViewById14 = activity.findViewById(R.id.select_radius_button);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "activity.findViewById(R.id.select_radius_button)");
        this.r = (TextView) findViewById14;
        View findViewById15 = activity.findViewById(R.id.search_radius_view_switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "activity.findViewById(R.…rch_radius_view_switcher)");
        this.s = (ViewSwitcher) findViewById15;
        View findViewById16 = activity.findViewById(R.id.search_radius_view);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "activity.findViewById(R.id.search_radius_view)");
        SearchRadiusViewImpl searchRadiusViewImpl = (SearchRadiusViewImpl) findViewById16;
        this.t = searchRadiusViewImpl;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.u = create;
        RadiusAdapterImpl radiusAdapterImpl = new RadiusAdapterImpl();
        this.v = radiusAdapterImpl;
        View findViewById17 = activity.findViewById(R.id.progress_overlay_container);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "activity.findViewById(R.…ogress_overlay_container)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById17, R.id.container, null, false, 0, 24, null);
        this.w = progressOverlay;
        SuggestionsAdapter suggestionsAdapter = new SuggestionsAdapter();
        this.x = suggestionsAdapter;
        this.y = AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, findViewById, "", -2, null, 0, null, null, 0, 0, 0, 1016, null);
        this.A = t6.c.lazy(new n(this));
        BehaviorRelay create2 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "BehaviorRelay.create()");
        this.B = create2;
        View findViewById18 = this.o0.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "activity.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById18;
        toolbar.setTitle(R.string.lp_address);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        toolbar.setNavigationOnClickListener(new b(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(suggestionsAdapter);
        Views.setVisible(findViewById13, this.q0);
        if (this.q0) {
            progressOverlay.showLoading();
            int radiusPadding = this.v0.getRadiusPadding();
            recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 0, false));
            recyclerView2.addItemDecoration(new RadiusItemDecoration(radiusPadding));
            recyclerView2.setAdapter(radiusAdapterImpl);
            toolbar.setTitle(R.string.lp_search_radius);
            searchRadiusViewImpl.setVisibility(0);
            chooseButton.setVisible(false);
            ViewGroup.LayoutParams layoutParams = floatingActionButton.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = this.v0.getFindMeButtonMargin();
            floatingActionButton.setLayoutParams(marginLayoutParams);
        }
        if (this.r0) {
            chooseButton.disable();
        }
        avitoMapAttachHelper.setMapAttachedListener(this);
        Activity activity2 = this.o0;
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentManager supportFragmentManager = ((FragmentActivity) activity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "(activity as FragmentAct…y).supportFragmentManager");
        avitoMapAttachHelper.attachView(i2, findViewById, supportFragmentManager);
        this.D = 180;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.E = create3;
        PublishRelay create4 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
        this.F = create4;
        PublishRelay create5 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create5, "PublishRelay.create()");
        this.G = create5;
        PublishRelay create6 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create6, "PublishRelay.create()");
        this.H = create6;
        BehaviorRelay create7 = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create7, "BehaviorRelay.create()");
        this.I = create7;
        this.J = backPressedNotifyingEditText.getBackPressedEvents();
        PublishRelay create8 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create8, "PublishRelay.create()");
        this.K = create8;
        PublishRelay create9 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create9, "PublishRelay.create()");
        this.L = create9;
        PublishRelay create10 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create10, "PublishRelay.create()");
        this.M = create10;
        this.N = create2;
        Observable<String> map = RxTextView.editorActions$default(backPressedNotifyingEditText, null, 1, null).filter(o.a).map(new p(this));
        Intrinsics.checkNotNullExpressionValue(map, "editQuery\n        .edito…itQuery.text.toString() }");
        this.O = map;
        Observable<R> share = RxTextView.afterTextChangeEvents(this.m).map(s.a).share();
        Intrinsics.checkNotNullExpressionValue(share, "editQuery\n        .after… ?: \"\" }\n        .share()");
        this.P = share;
        this.Q = RxView.focusChanges(this.m);
        this.R = RxView.clicks(this.k);
        this.S = this.i.getClicksObservable();
        Observable<Unit> share2 = RxView.clicks(this.h).share();
        Intrinsics.checkNotNullExpressionValue(share2, "findMeButton\n        .clicks()\n        .share()");
        this.T = share2;
        this.U = RxView.clicks(this.f);
        this.V = RxView.clicks(this.r);
        this.W = suggestionsAdapter.getClicks();
        this.X = this.v.clicks();
        this.Y = new a(0, this);
        this.Z = new m(this);
        this.a0 = new l(this);
        this.b0 = new a(4, this);
        this.c0 = new r(this);
        this.d0 = new a(3, this);
        this.e0 = new a(1, this);
        this.f0 = new i(this);
        this.g0 = new k(this);
        this.h0 = new j(this);
        this.i0 = new f(this);
        this.j0 = new q(this);
        this.k0 = new h(this);
        this.l0 = new a(2, this);
        this.m0 = new e(this);
        this.n0 = new g(this);
    }

    public static final void access$animateSearchRadiusAlpha(LocationPickerViewImpl locationPickerViewImpl, float f2) {
        locationPickerViewImpl.t.animate().setDuration(locationPickerViewImpl.D).alpha(f2).start();
    }

    public static final int access$getMapWidth$p(LocationPickerViewImpl locationPickerViewImpl) {
        return ((Number) locationPickerViewImpl.A.getValue()).intValue();
    }

    public static final void access$openSettingsScreen(LocationPickerViewImpl locationPickerViewImpl) {
        Objects.requireNonNull(locationPickerViewImpl);
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", locationPickerViewImpl.o0.getPackageName(), null));
        locationPickerViewImpl.o0.startActivity(intent);
    }

    public static final void access$scrollToEnd(LocationPickerViewImpl locationPickerViewImpl, HorizontalScrollView horizontalScrollView) {
        Objects.requireNonNull(locationPickerViewImpl);
        View childAt = horizontalScrollView.getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(0)");
        int width = childAt.getWidth() - horizontalScrollView.getScrollX();
        if (width > 0) {
            horizontalScrollView.smoothScrollBy(width, 0);
        }
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Unit> getBackClicked() {
        return this.J;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<ChangeAdvertsCountUpdate> getChangeAdvertsCount() {
        return this.m0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<AvitoMapCameraPosition> getChangeCameraPosition() {
        return this.i0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<Boolean> getChangeChooseButtonIsActive() {
        return this.Y;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<LocationPickerNotification> getChangeNotification() {
        return this.n0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<Boolean> getChangeProgressVisibility() {
        return this.e0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<Boolean> getChangeRadiusVisibility() {
        return this.l0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<RadiusWidgetUpdate> getChangeRadiusWidgetSize() {
        return this.k0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<Boolean> getChangeSearchFocus() {
        return this.d0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<String> getChangeSearchQuery() {
        return this.f0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<List<AddressSuggestion>> getChangeShownSuggestions() {
        return this.h0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Unit> getChooseClicked() {
        return this.S;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Unit> getCleanQueryClicked() {
        return this.R;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<Unit> getCleanSearchQuery() {
        return this.g0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<SearchRadius> getCloseWithRadiusResults() {
        return this.a0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<AddressParameter.Value> getCloseWithResults() {
        return this.Z;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Unit> getFindMeClicked() {
        return this.T;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<Boolean> getLoadingIndicatorOnButton() {
        return this.b0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Unit> getMapConcealerClicked() {
        return this.U;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Unit> getMapInitialized() {
        return this.N;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<SearchRadius> getRadiusClicked() {
        return this.X;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<String> getSearchClicked() {
        return this.O;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Boolean> getSearchFocus() {
        return this.Q;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<ChangeRadiusUpdate> getSelectRadiusBubble() {
        return this.j0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<Unit> getSelectRadiusButtonClicked() {
        return this.V;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerInputView
    @NotNull
    public Consumer<String> getShowAddressValidationError() {
        return this.c0;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<AddressSuggestion> getSuggestionClicked() {
        return this.W;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Observable<String> getTextQueryChanged() {
        return this.P;
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper.MapAttachListener
    public void onMapAttach(@NotNull AvitoMap avitoMap) {
        Intrinsics.checkNotNullParameter(avitoMap, "map");
        AvitoMapTarget avitoMapTarget = this.u0;
        if (avitoMapTarget != null) {
            avitoMap.restoreTarget(avitoMapTarget);
            if (!this.w.isContentVisible()) {
                this.w.showContent();
            }
        }
        this.c = avitoMap;
        if (avitoMap != null) {
            AvitoMapUiSettings uiSettings = avitoMap.getUiSettings();
            uiSettings.isMyLocationButtonEnabled(true);
            uiSettings.isZoomControlsEnabled(false);
            uiSettings.isCompassEnabled(false);
            uiSettings.isRotateGesturesEnabled(false);
            uiSettings.isFastTapEnabled(true);
            avitoMap.addMoveStartListener(new AvitoMap.MapMoveStartListener(250) { // from class: com.avito.android.location_picker.view.LocationPickerViewImpl$init$2
                public final /* synthetic */ long b;

                {
                    this.b = r2;
                }

                @Override // com.avito.android.avito_map.AvitoMap.MapMoveStartListener
                public void onMapMoveStarted(@NotNull AvitoMapMoveReason avitoMapMoveReason) {
                    Intrinsics.checkNotNullParameter(avitoMapMoveReason, "reason");
                    LocationPickerViewImpl.this.e.animate().setDuration(this.b).alpha(1.0f).scaleX(0.3f).scaleY(0.3f).start();
                    LocationPickerViewImpl.this.g.animate().setDuration(this.b).translationY(-LocationPickerViewImpl.this.a).start();
                    if (avitoMapMoveReason == AvitoMapMoveReason.GESTURE) {
                        LocationPickerViewImpl.this.getCameraMovedByGesture().accept(Unit.INSTANCE);
                    }
                    LocationPickerViewImpl.this.getCameraMoveStart().accept(Unit.INSTANCE);
                }
            });
            avitoMap.addMoveEndListener(new AvitoMap.MapMoveEndListener(250) { // from class: com.avito.android.location_picker.view.LocationPickerViewImpl$init$3
                public final /* synthetic */ long b;

                {
                    this.b = r2;
                }

                @Override // com.avito.android.avito_map.AvitoMap.MapMoveEndListener
                public void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
                    AvitoMapBounds mapBounds;
                    AvitoMapCameraPosition mapCameraPosition;
                    Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "mapCameraPosition");
                    LocationPickerViewImpl.this.e.animate().setDuration(this.b).alpha(0.5f).scaleX(1.0f).scaleY(1.0f).start();
                    LocationPickerViewImpl.this.g.animate().setDuration(this.b).translationY(0.0f).start();
                    AvitoMap avitoMap2 = LocationPickerViewImpl.this.c;
                    if (!(avitoMap2 == null || (mapCameraPosition = avitoMap2.getMapCameraPosition()) == null)) {
                        LocationPickerViewImpl.this.getCameraIdlePositionChanged().accept(mapCameraPosition);
                    }
                    AvitoMap avitoMap3 = LocationPickerViewImpl.this.c;
                    if (!(avitoMap3 == null || (mapBounds = avitoMap3.getMapBounds()) == null)) {
                        LocationPickerViewImpl.this.getVisibleRegionChanged().accept(mapBounds);
                        LocationPickerViewImpl.this.getCameraMoveEnd().accept(mapBounds);
                    }
                    if (LocationPickerViewImpl.this.q0 && !LocationPickerViewImpl.this.w.isContentVisible()) {
                        LocationPickerViewImpl.this.w.showContent();
                    }
                }
            });
        }
        this.B.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<AvitoMapCameraPosition> getCameraIdlePositionChanged() {
        return this.H;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<AvitoMapBounds> getCameraMoveEnd() {
        return this.L;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<Unit> getCameraMoveStart() {
        return this.M;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<Unit> getCameraMovedByGesture() {
        return this.G;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<Unit> getDialogOkButtonClicked() {
        return this.K;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<Unit> getRetryClicked() {
        return this.E;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<ScreenCloseFromBlock> getScreenClosed() {
        return this.u;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<Unit> getSettingsClicked() {
        return this.F;
    }

    @Override // com.avito.android.location_picker.view.LocationPickerOutputView
    @NotNull
    public Relay<AvitoMapBounds> getVisibleRegionChanged() {
        return this.I;
    }
}
