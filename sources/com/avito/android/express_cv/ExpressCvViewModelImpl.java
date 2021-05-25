package com.avito.android.express_cv;

import a2.a.a.p0.h;
import a2.a.a.p0.i;
import a2.a.a.p0.j;
import a2.a.a.p0.k;
import a2.a.a.p0.l;
import a2.a.a.p0.m;
import a2.g.r.g;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.blueprints.publish.SelectItemPresenter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.CreateChannelLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.epress_cv.remote.model.ExpressCvInfo;
import com.avito.android.epress_cv.remote.model.PublishCv;
import com.avito.android.express_cv.events.CvDialogEvent;
import com.avito.android.express_cv.events.DialogParams;
import com.avito.android.express_cv.events.PhoneCallEvent;
import com.avito.android.express_cv.existed_cv.item.CvItemClickListener;
import com.avito.android.express_cv.existed_cv.item.ExistedCvItem;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.items.InputItem;
import com.avito.android.location_picker.di.LocationPickerModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.IntentDataHolder;
import com.avito.android.util.architecture_components.IntentForResultDataHolder;
import com.avito.android.util.architecture_components.MessageEvent;
import com.avito.android.util.architecture_components.StartActivityEvent;
import com.avito.android.util.architecture_components.StartActivityForResultEvent;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\tBc\u0012\u0006\u0010o\u001a\u00020\n\u0012\u0006\u0010f\u001a\u00020c\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010§\u0001\u001a\u00030¤\u0001\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010b\u001a\u00020_\u0012\b\u0010­\u0001\u001a\u00030ª\u0001\u0012\u0006\u00107\u001a\u000204\u0012\b\u0010±\u0001\u001a\u00030®\u0001\u0012\b\u0010µ\u0001\u001a\u00030´\u0001¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u0014J)\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\u000eJ\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\f2\u0006\u0010&\u001a\u00020)2\u0006\u0010*\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\f2\u0006\u0010&\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\f2\u0006\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u0010\u000eJ\u0017\u00101\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b1\u0010\u0014J\u000f\u00102\u001a\u00020\fH\u0014¢\u0006\u0004\b2\u0010\u0010J\u000f\u00103\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u0010\u0010R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR \u0010K\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030I088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010;R\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020L088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010;R\"\u0010S\u001a\b\u0012\u0004\u0012\u00020O088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010;\u001a\u0004\bQ\u0010RR\"\u0010W\u001a\b\u0012\u0004\u0012\u00020T088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010;\u001a\u0004\bV\u0010RR\"\u0010[\u001a\b\u0012\u0004\u0012\u00020X088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010;\u001a\u0004\bZ\u0010RR&\u0010^\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030I088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\\\u0010;\u001a\u0004\b]\u0010RR\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020)0A8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bg\u0010CR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\"\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0p088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010;R\u0016\u0010u\u001a\u00020s8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010tR\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020\u0016088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010;R\u0018\u0010x\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010nR\u0016\u0010z\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\by\u0010nR&\u0010}\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030I088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b{\u0010;\u001a\u0004\b|\u0010RR)\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0A088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b~\u0010;\u001a\u0004\b\u0010RR%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u0016088\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010;\u001a\u0005\b\u0001\u0010RR%\u0010\u0001\u001a\b\u0012\u0004\u0012\u000209088\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010;\u001a\u0005\b\u0001\u0010RR&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001088\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010;\u001a\u0005\b\u0001\u0010RR\u001a\u0010\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010nR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0A088\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010;\u001a\u0005\b\u0001\u0010RR$\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0A088\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010;R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020O088\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010;R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020X088\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010;R%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020L088\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010;\u001a\u0005\b\u0001\u0010RR#\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0A088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010;R+\u0010 \u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0p088\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010;\u001a\u0005\b\u0001\u0010RR\u001f\u0010¢\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001088\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¡\u0001\u0010;R!\u0010£\u0001\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030I088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010;R\u001a\u0010§\u0001\u001a\u00030¤\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001e\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020T088\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¨\u0001\u0010;R\u001a\u0010­\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010±\u0001\u001a\u00030®\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010³\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010n¨\u0006¸\u0001"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/express_cv/ExpressCvViewModel;", "Lcom/avito/android/express_cv/ExistedCvDataProvider;", "Lcom/avito/android/express_cv/NewCvDataProvider;", "Lcom/avito/android/express_cv/existed_cv/item/CvItemClickListener;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/blueprints/publish/PrimaryParametersListener;", "Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClickListener;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "", "itemId", "", "f", "(Ljava/lang/String;)V", g.a, "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "d", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "e", "", "shouldFinish", "c", "(Lcom/avito/android/deep_linking/links/DeepLink;Z)V", "action", "onDialogDismiss", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "id", "onItemButtonClicked", "Lcom/avito/android/category_parameters/ParameterElement$Select;", "element", "onItemClicked", "(Lcom/avito/android/category_parameters/ParameterElement$Select;)V", "Lcom/avito/conveyor_item/Item;", "newValue", "onElementValueChanged", "(Lcom/avito/conveyor_item/Item;Ljava/lang/String;)V", "Lcom/avito/android/items/InputItem;", "onElementErrorDismissed", "(Lcom/avito/android/items/InputItem;)V", "onExistedCvItemClicked", "onDeepLinkClick", "onCleared", "onReload", "Lcom/avito/android/ActivityIntentFactory;", "Q", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/express_cv/events/CvDialogEvent;", "k", "Landroidx/lifecycle/MutableLiveData;", "showDialogEventData", "Lcom/avito/android/remote/model/text/AttributedText;", "s", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "", "w", "Ljava/util/List;", "existedItems", "Lcom/avito/android/validation/LocalPretendInteractor;", "N", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/util/LoadingState;", "i", "activateProgressLiveData", "Lcom/avito/android/express_cv/events/PhoneCallEvent;", "j", "phoneCallEventData", "Lcom/avito/android/util/architecture_components/MessageEvent;", "F", "getMessageEvents", "()Landroidx/lifecycle/MutableLiveData;", "messageEvents", "Lcom/avito/android/util/architecture_components/StartActivityForResultEvent;", "D", "getStartActivityForResultEvents", "startActivityForResultEvents", "Lcom/avito/android/util/architecture_components/StartActivityEvent;", ExifInterface.LONGITUDE_EAST, "getStartActivityEvents", "startActivityEvents", "B", "getProgressChanges", "progressChanges", "Lcom/avito/android/express_cv/ParametersConverter;", "O", "Lcom/avito/android/express_cv/ParametersConverter;", "categoryParametersConverter", "Lcom/avito/android/util/SchedulersFactory;", "K", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", VKApiConst.VERSION, "publishCvItems", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "p", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParams", "J", "Ljava/lang/String;", "context", "Lcom/avito/konveyor/data_source/ListDataSource;", "Lcom/avito/android/express_cv/tabs/CvTabItem;", "tabsLiveData", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscription", "tabsVisibilityChangesData", VKApiConst.Q, "itemIdToChatWith", "t", "actionTitle", "x", "getActivateProgressChanges", "activateProgressChanges", "z", "getNewCvItems", "newCvItems", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getTabsVisibilityChanges", "tabsVisibilityChanges", "I", "getShowDialogEvents", "showDialogEvents", "", "G", "getCvSuccessfullyPostedEvents", "cvSuccessfullyPostedEvents", "u", "disableTitle", "Lcom/avito/android/express_cv/ExpressCvRepository;", "L", "Lcom/avito/android/express_cv/ExpressCvRepository;", "repository", "y", "getExistedCvItems", "existedCvItems", "h", "newCvLiveData", "o", "messageEventsData", "n", "startActivityEventData", "H", "getPhoneCallEvents", "phoneCallEvents", "existedCvLiveData", "C", "getDataChanges", "dataChanges", "l", "cvSuccessfullyPostedLiveData", "progressChangesLiveData", "Lcom/avito/android/express_cv/ExpressCvDataConverter;", "M", "Lcom/avito/android/express_cv/ExpressCvDataConverter;", "itemsConverter", AuthSource.OPEN_CHANNEL_LIST, "startActivityForResultEventData", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "P", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "Lcom/avito/android/express_cv/ExpressCvResourceProvider;", "R", "Lcom/avito/android/express_cv/ExpressCvResourceProvider;", "expressCvResourceProvider", "r", "publishDescription", "Lcom/avito/android/Features;", "features", "<init>", "(Ljava/lang/String;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/express_cv/ExpressCvRepository;Lcom/avito/android/express_cv/ExpressCvDataConverter;Lcom/avito/android/validation/LocalPretendInteractor;Lcom/avito/android/express_cv/ParametersConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/express_cv/ExpressCvResourceProvider;Lcom/avito/android/Features;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExpressCvViewModelImpl extends ViewModel implements ExpressCvViewModel, ExistedCvDataProvider, NewCvDataProvider, CvItemClickListener, OnDeepLinkClickListener, PrimaryParametersListener, SelectItemPresenter.ClickListener, ButtonItemPresenter.Listener {
    @NotNull
    public final MutableLiveData<Boolean> A;
    @NotNull
    public final MutableLiveData<LoadingState<?>> B;
    @NotNull
    public final MutableLiveData<ListDataSource<CvTabItem>> C;
    @NotNull
    public final MutableLiveData<StartActivityForResultEvent> D;
    @NotNull
    public final MutableLiveData<StartActivityEvent> E;
    @NotNull
    public final MutableLiveData<MessageEvent> F;
    @NotNull
    public final MutableLiveData<Object> G;
    @NotNull
    public final MutableLiveData<PhoneCallEvent> H;
    @NotNull
    public final MutableLiveData<CvDialogEvent> I;
    public final String J;
    public final SchedulersFactory K;
    public final ExpressCvRepository L;
    public final ExpressCvDataConverter M;
    public final LocalPretendInteractor N;
    public final ParametersConverter O;
    public final DeepLinkIntentFactory P;
    public final ActivityIntentFactory Q;
    public final ExpressCvResourceProvider R;
    public CompositeDisposable c = new CompositeDisposable();
    public final MutableLiveData<LoadingState<?>> d;
    public final MutableLiveData<Boolean> e;
    public final MutableLiveData<ListDataSource<CvTabItem>> f;
    public final MutableLiveData<List<Item>> g;
    public final MutableLiveData<List<Item>> h;
    public final MutableLiveData<LoadingState<?>> i;
    public final MutableLiveData<PhoneCallEvent> j;
    public final MutableLiveData<CvDialogEvent> k;
    public final MutableLiveData<Object> l;
    public final MutableLiveData<StartActivityForResultEvent> m;
    public final MutableLiveData<StartActivityEvent> n;
    public final MutableLiveData<MessageEvent> o;
    public CategoryParameters p;
    public String q;
    public String r;
    public AttributedText s;
    public String t;
    public String u;
    public List<? extends Item> v;
    public List<? extends Item> w;
    @NotNull
    public final MutableLiveData<LoadingState<?>> x;
    @NotNull
    public final MutableLiveData<List<Item>> y;
    @NotNull
    public final MutableLiveData<List<Item>> z;

    public static final class a<T> implements Consumer<LoadingState<? super String>> {
        public final /* synthetic */ ExpressCvViewModelImpl a;

        public a(ExpressCvViewModelImpl expressCvViewModelImpl) {
            this.a = expressCvViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super String> loadingState) {
            LoadingState<? super String> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.n.postValue(new StartActivityEvent(new IntentDataHolder(MessengerIntentFactory.DefaultImpls.channelIntent$default(this.a.Q, (String) ((LoadingState.Loaded) loadingState2).getData(), null, null, null, false, 30, null), true)));
                this.a.i.postValue(loadingState2);
            } else if (loadingState2 instanceof LoadingState.Loading) {
                this.a.i.postValue(loadingState2);
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.i.postValue(loadingState2);
                this.a.getProgressChanges().postValue(loadingState2);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super ExpressCvInfo>> {
        public final /* synthetic */ ExpressCvViewModelImpl a;

        public c(ExpressCvViewModelImpl expressCvViewModelImpl) {
            this.a = expressCvViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v19, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super ExpressCvInfo> loadingState) {
            LoadingState<? super ExpressCvInfo> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                PublishCv publishCv = ((ExpressCvInfo) loaded.getData()).getPublishCv();
                this.a.p = publishCv.getCategoryParameters();
                this.a.r = publishCv.getDescription();
                this.a.t = publishCv.getActionText();
                this.a.s = publishCv.getDisclaimer();
                this.a.u = publishCv.getDisableText();
                ExpressCvViewModelImpl expressCvViewModelImpl = this.a;
                expressCvViewModelImpl.v = expressCvViewModelImpl.M.convertPublishItems(ExpressCvViewModelImpl.access$getCategoryParams$p(this.a), this.a.r, ExpressCvViewModelImpl.access$getAttributedText$p(this.a), ExpressCvViewModelImpl.access$getActionTitle$p(this.a), this.a.u);
                ExpressCvViewModelImpl expressCvViewModelImpl2 = this.a;
                expressCvViewModelImpl2.w = expressCvViewModelImpl2.M.convertExistedItems(((ExpressCvInfo) loaded.getData()).getExistedCv());
                List<CvTabItem> convertTabs = this.a.M.convertTabs((ExpressCvInfo) loaded.getData());
                this.a.f.postValue(new ListDataSource(convertTabs));
                this.a.h.postValue(ExpressCvViewModelImpl.access$getPublishCvItems$p(this.a));
                this.a.g.postValue(this.a.w);
                MutableLiveData mutableLiveData = this.a.e;
                boolean z = true;
                if (convertTabs.size() <= 1) {
                    z = false;
                }
                mutableLiveData.postValue(Boolean.valueOf(z));
            } else if (loadingState2 instanceof LoadingState.Error) {
                TypedError error = ((LoadingState.Error) loadingState2).getError();
                if (error instanceof ErrorResult.Unauthenticated) {
                    ExpressCvViewModelImpl expressCvViewModelImpl3 = this.a;
                    ExpressCvViewModelImpl.access$startActivityForResult(expressCvViewModelImpl3, AuthIntentFactory.DefaultImpls.authIntent$default(expressCvViewModelImpl3.Q, null, AuthSource.SEND_CV, null, 4, null), 4);
                } else if (error instanceof ErrorWithMessage) {
                    this.a.getMessageEvents().postValue(new MessageEvent(((ErrorWithMessage) error).getMessage()));
                }
            }
            this.a.d.postValue(loadingState2);
        }
    }

    public static final class d<T, R> implements Function<PretendResult, ObservableSource<? extends PretendResult>> {
        public final /* synthetic */ ExpressCvViewModelImpl a;

        public d(ExpressCvViewModelImpl expressCvViewModelImpl) {
            this.a = expressCvViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends PretendResult> apply(PretendResult pretendResult) {
            PretendResult pretendResult2 = pretendResult;
            Intrinsics.checkNotNullParameter(pretendResult2, "it");
            if (pretendResult2.getSuccess()) {
                return this.a.L.validateParams(this.a.O.convertToMap(ExpressCvViewModelImpl.access$getCategoryParams$p(this.a)));
            }
            Observable just = Observable.just(pretendResult2);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class e<T> implements Consumer<PretendResult> {
        public final /* synthetic */ ExpressCvViewModelImpl a;

        public e(ExpressCvViewModelImpl expressCvViewModelImpl) {
            this.a = expressCvViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PretendResult pretendResult) {
            PretendResult pretendResult2 = pretendResult;
            ExpressCvViewModelImpl expressCvViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(pretendResult2, "it");
            ExpressCvViewModelImpl.access$handleValidationOkResult(expressCvViewModelImpl, pretendResult2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public final /* synthetic */ ExpressCvViewModelImpl a;

        public f(ExpressCvViewModelImpl expressCvViewModelImpl) {
            this.a = expressCvViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getMessageEvents().postValue(new MessageEvent(this.a.R.getProvideValidationErrorMessage()));
            Logs.error(th);
        }
    }

    public ExpressCvViewModelImpl(@NotNull String str, @NotNull SchedulersFactory schedulersFactory, @NotNull ExpressCvRepository expressCvRepository, @NotNull ExpressCvDataConverter expressCvDataConverter, @NotNull LocalPretendInteractor localPretendInteractor, @NotNull ParametersConverter parametersConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ExpressCvResourceProvider expressCvResourceProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, "context");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(expressCvRepository, "repository");
        Intrinsics.checkNotNullParameter(expressCvDataConverter, "itemsConverter");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        Intrinsics.checkNotNullParameter(parametersConverter, "categoryParametersConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deeplinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(expressCvResourceProvider, "expressCvResourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.J = str;
        this.K = schedulersFactory;
        this.L = expressCvRepository;
        this.M = expressCvDataConverter;
        this.N = localPretendInteractor;
        this.O = parametersConverter;
        this.P = deepLinkIntentFactory;
        this.Q = activityIntentFactory;
        this.R = expressCvResourceProvider;
        MutableLiveData<LoadingState<?>> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        MutableLiveData<ListDataSource<CvTabItem>> mutableLiveData3 = new MutableLiveData<>();
        this.f = mutableLiveData3;
        MutableLiveData<List<Item>> mutableLiveData4 = new MutableLiveData<>();
        this.g = mutableLiveData4;
        MutableLiveData<List<Item>> mutableLiveData5 = new MutableLiveData<>();
        this.h = mutableLiveData5;
        MutableLiveData<LoadingState<?>> mutableLiveData6 = new MutableLiveData<>();
        this.i = mutableLiveData6;
        MutableLiveData<PhoneCallEvent> mutableLiveData7 = new MutableLiveData<>();
        this.j = mutableLiveData7;
        MutableLiveData<CvDialogEvent> mutableLiveData8 = new MutableLiveData<>();
        this.k = mutableLiveData8;
        MutableLiveData<Object> mutableLiveData9 = new MutableLiveData<>();
        this.l = mutableLiveData9;
        MutableLiveData<StartActivityForResultEvent> mutableLiveData10 = new MutableLiveData<>();
        this.m = mutableLiveData10;
        MutableLiveData<StartActivityEvent> mutableLiveData11 = new MutableLiveData<>();
        this.n = mutableLiveData11;
        MutableLiveData<MessageEvent> mutableLiveData12 = new MutableLiveData<>();
        this.o = mutableLiveData12;
        f(str);
        this.x = mutableLiveData6;
        this.y = mutableLiveData4;
        this.z = mutableLiveData5;
        this.A = mutableLiveData2;
        this.B = mutableLiveData;
        this.C = mutableLiveData3;
        this.D = mutableLiveData10;
        this.E = mutableLiveData11;
        this.F = mutableLiveData12;
        this.G = mutableLiveData9;
        this.H = mutableLiveData7;
        this.I = mutableLiveData8;
    }

    public static final /* synthetic */ String access$getActionTitle$p(ExpressCvViewModelImpl expressCvViewModelImpl) {
        String str = expressCvViewModelImpl.t;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionTitle");
        }
        return str;
    }

    public static final /* synthetic */ AttributedText access$getAttributedText$p(ExpressCvViewModelImpl expressCvViewModelImpl) {
        AttributedText attributedText = expressCvViewModelImpl.s;
        if (attributedText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedText");
        }
        return attributedText;
    }

    public static final /* synthetic */ CategoryParameters access$getCategoryParams$p(ExpressCvViewModelImpl expressCvViewModelImpl) {
        CategoryParameters categoryParameters = expressCvViewModelImpl.p;
        if (categoryParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
        }
        return categoryParameters;
    }

    public static final /* synthetic */ List access$getPublishCvItems$p(ExpressCvViewModelImpl expressCvViewModelImpl) {
        List<? extends Item> list = expressCvViewModelImpl.v;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishCvItems");
        }
        return list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v6, resolved type: androidx.lifecycle.MutableLiveData<java.util.List<com.avito.conveyor_item.Item>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleValidationOkResult(ExpressCvViewModelImpl expressCvViewModelImpl, PretendResult pretendResult) {
        Objects.requireNonNull(expressCvViewModelImpl);
        if (pretendResult.getSuccess()) {
            CompositeDisposable compositeDisposable = expressCvViewModelImpl.c;
            ExpressCvRepository expressCvRepository = expressCvViewModelImpl.L;
            ParametersConverter parametersConverter = expressCvViewModelImpl.O;
            CategoryParameters categoryParameters = expressCvViewModelImpl.p;
            if (categoryParameters == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
            }
            Disposable subscribe = expressCvRepository.publishExpressCv(parametersConverter.convertToMap(categoryParameters), expressCvViewModelImpl.J).observeOn(expressCvViewModelImpl.K.mainThread()).subscribe(new l(expressCvViewModelImpl), m.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "repository.publishExpres…   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        CategoryParameters categoryParameters2 = expressCvViewModelImpl.p;
        if (categoryParameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
        }
        categoryParameters2.applyPretendResult(pretendResult.getErrors());
        ExpressCvDataConverter expressCvDataConverter = expressCvViewModelImpl.M;
        CategoryParameters categoryParameters3 = expressCvViewModelImpl.p;
        if (categoryParameters3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
        }
        String str = expressCvViewModelImpl.r;
        AttributedText attributedText = expressCvViewModelImpl.s;
        if (attributedText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedText");
        }
        String str2 = expressCvViewModelImpl.t;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionTitle");
        }
        expressCvViewModelImpl.v = expressCvDataConverter.convertPublishItems(categoryParameters3, str, attributedText, str2, expressCvViewModelImpl.u);
        String singleMessage = ((PretendErrorValue) CollectionsKt___CollectionsKt.first(pretendResult.getErrors().values())).getSingleMessage();
        if (singleMessage != null) {
            expressCvViewModelImpl.o.postValue(new MessageEvent(singleMessage));
        }
        MutableLiveData<List<Item>> mutableLiveData = expressCvViewModelImpl.h;
        List<? extends Item> list = expressCvViewModelImpl.v;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishCvItems");
        }
        mutableLiveData.postValue(list);
    }

    public static final void access$processCvResult(ExpressCvViewModelImpl expressCvViewModelImpl, String str, String str2, DeepLink deepLink) {
        Objects.requireNonNull(expressCvViewModelImpl);
        expressCvViewModelImpl.k.postValue(new CvDialogEvent(new DialogParams(str, str2, deepLink)));
    }

    public static final void access$startActivityForResult(ExpressCvViewModelImpl expressCvViewModelImpl, Intent intent, int i2) {
        expressCvViewModelImpl.m.postValue(new StartActivityForResultEvent(new IntentForResultDataHolder(intent, i2)));
    }

    public final void c(DeepLink deepLink, boolean z2) {
        Intent intent = this.P.getIntent(deepLink);
        if (intent != null) {
            this.n.postValue(new StartActivityEvent(new IntentDataHolder(intent, z2)));
        }
    }

    public final void d(DeepLink deepLink) {
        getCvSuccessfullyPostedEvents().postValue(new Object());
        if (deepLink instanceof CreateChannelLink) {
            CreateChannelLink createChannelLink = (CreateChannelLink) deepLink;
            this.q = createChannelLink.getItemId();
            e(createChannelLink.getItemId());
        } else if (deepLink instanceof PhoneLink.Call) {
            this.j.postValue(new PhoneCallEvent((PhoneLink.Call) deepLink));
        } else {
            c(deepLink, true);
        }
    }

    public final void e(String str) {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.L.getMessengerChannel(str).observeOn(this.K.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getMessengerC…   }, { Logs.error(it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void f(String str) {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.L.getExpressCvInfo(str).observeOn(this.K.mainThread()).subscribe(new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "repository.getExpressCvI…stValue(it)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void g() {
        CompositeDisposable compositeDisposable = this.c;
        LocalPretendInteractor localPretendInteractor = this.N;
        CategoryParameters categoryParameters = this.p;
        if (categoryParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
        }
        Disposable subscribe = InteropKt.toV2(localPretendInteractor.pretend(new SimpleParametersTree(categoryParameters.getParameters(), null, 2, null))).flatMap(new d(this)).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "localPretendInteractor\n ….error(it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        AddressParameter.Value value;
        Object obj;
        if (this.p != null) {
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5 && i3 == -1 && intent != null && (value = (AddressParameter.Value) intent.getParcelableExtra(LocationPickerModuleKt.EXTRA_ADDRESS_RESULT)) != null) {
                        CategoryParameters categoryParameters = this.p;
                        if (categoryParameters == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
                        }
                        Iterator it = categoryParameters.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (((ParameterSlot) obj) instanceof AddressParameter) {
                                break;
                            }
                        }
                        if (!(obj instanceof AddressParameter)) {
                            obj = null;
                        }
                        AddressParameter addressParameter = (AddressParameter) obj;
                        if (addressParameter != null) {
                            addressParameter.setValue(value);
                            addressParameter.setError(null);
                        }
                        ExpressCvDataConverter expressCvDataConverter = this.M;
                        CategoryParameters categoryParameters2 = this.p;
                        if (categoryParameters2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
                        }
                        String str = this.r;
                        AttributedText attributedText = this.s;
                        if (attributedText == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("attributedText");
                        }
                        String str2 = this.t;
                        if (str2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("actionTitle");
                        }
                        List<Item> convertPublishItems = expressCvDataConverter.convertPublishItems(categoryParameters2, str, attributedText, str2, this.u);
                        this.v = convertPublishItems;
                        MutableLiveData<List<Item>> mutableLiveData = this.h;
                        if (convertPublishItems == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("publishCvItems");
                        }
                        mutableLiveData.postValue(convertPublishItems);
                    }
                } else if (i3 == -1) {
                    f(this.J);
                }
            } else if (i3 == -1) {
                g();
            }
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        c(deepLink, false);
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    public void onDialogDismiss(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "action");
        d(deepLink);
    }

    @Override // com.avito.android.blueprints.InputItemPresenter.Listener
    public void onElementErrorDismissed(@NotNull InputItem inputItem) {
        Intrinsics.checkNotNullParameter(inputItem, "element");
        CategoryParameters categoryParameters = this.p;
        if (categoryParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
        }
        ParameterSlot findParameter = categoryParameters.findParameter(inputItem.getStringId());
        if (findParameter != null && (findParameter instanceof EditableParameter)) {
            ((EditableParameter) findParameter).setError(null);
        }
    }

    @Override // com.avito.android.blueprints.InputItemPresenter.Listener
    public void onElementValueChanged(@NotNull Item item, @NotNull String str) {
        Intrinsics.checkNotNullParameter(item, "element");
        Intrinsics.checkNotNullParameter(str, "newValue");
        CategoryParameters categoryParameters = this.p;
        if (categoryParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
        }
        ParameterSlot findParameter = categoryParameters.findParameter(item.getStringId());
        if (findParameter == null) {
            return;
        }
        if (findParameter instanceof CharParameter) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter.getValue(), str)) {
                editableParameter.setValue(str);
                editableParameter.setError(null);
            }
        } else if (findParameter instanceof PhoneParameter) {
            EditableParameter editableParameter2 = (EditableParameter) findParameter;
            if (!Intrinsics.areEqual(editableParameter2.getValue(), str)) {
                editableParameter2.setValue(str);
                editableParameter2.setError(null);
            }
            ((PhoneParameter) findParameter).setError(null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: androidx.lifecycle.MutableLiveData<java.util.List<com.avito.conveyor_item.Item>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.express_cv.existed_cv.item.CvItemClickListener
    public void onExistedCvItemClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        List<? extends Item> list = this.w;
        if (list != null) {
            for (T t2 : list) {
                if (t2 instanceof ExistedCvItem) {
                    t2.setSelected(false);
                    if (Intrinsics.areEqual(t2.getStringId(), str)) {
                        t2.setSelected(true);
                    }
                }
            }
        }
        this.g.postValue(this.w);
    }

    @Override // com.avito.android.blueprints.ButtonItemPresenter.Listener
    public void onItemButtonClicked(@NotNull String str) {
        List<? extends Item> list;
        T t2;
        boolean z2;
        Intrinsics.checkNotNullParameter(str, "id");
        int hashCode = str.hashCode();
        if (hashCode != -1618901718) {
            if (hashCode != -1146907841) {
                if (hashCode == 1919845795 && str.equals(ExpressCvDataConverterKt.PUBLISH_CV_BUTTON)) {
                    g();
                }
            } else if (str.equals(ExpressCvDataConverterKt.ACTIVATE_CV_BUTTON) && (list = this.w) != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t2 = null;
                        break;
                    }
                    t2 = it.next();
                    T t3 = t2;
                    if (!(t3 instanceof ExistedCvItem) || !t3.isSelected()) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
                T t4 = t2;
                if (t4 != null) {
                    CompositeDisposable compositeDisposable = this.c;
                    Disposable subscribe = this.L.activateCv(t4.getStringId()).observeOn(this.K.mainThread()).subscribe(new h(this), i.a);
                    Intrinsics.checkNotNullExpressionValue(subscribe, "repository\n            .…   }, { Logs.error(it) })");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                }
            }
        } else if (str.equals(ExpressCvDataConverterKt.DISABLE_CV_CREATION_BUTTON)) {
            CompositeDisposable compositeDisposable2 = this.c;
            Disposable subscribe2 = this.L.disableExpressCv().observeOn(this.K.mainThread()).subscribe(new j(this), k.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "repository.disableExpres…   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    @Override // com.avito.android.blueprints.publish.SelectItemPresenter.ClickListener
    public void onItemClicked(@NotNull ParameterElement.Select select) {
        Object obj;
        Intrinsics.checkNotNullParameter(select, "element");
        CategoryParameters categoryParameters = this.p;
        if (categoryParameters == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryParams");
        }
        Iterator it = categoryParameters.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(select.getStringId(), ((ParameterSlot) obj).getId())) {
                break;
            }
        }
        ParameterSlot parameterSlot = (ParameterSlot) obj;
        if (parameterSlot instanceof AddressParameter) {
            this.m.postValue(new StartActivityForResultEvent(new IntentForResultDataHolder(PublishIntentFactory.DefaultImpls.locationPickerIntent$default(this.Q, (AddressParameter.Value) ((AddressParameter) parameterSlot).getValue(), null, null, null, null, null, null, null, 254, null), 5)));
        }
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    public void onReload() {
        String str = this.q;
        if (str != null) {
            e(str);
        } else {
            f(this.J);
        }
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getActivateProgressChanges() {
        return this.x;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<Object> getCvSuccessfullyPostedEvents() {
        return this.G;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<ListDataSource<CvTabItem>> getDataChanges() {
        return this.C;
    }

    @Override // com.avito.android.express_cv.ExistedCvDataProvider
    @NotNull
    public MutableLiveData<List<Item>> getExistedCvItems() {
        return this.y;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<MessageEvent> getMessageEvents() {
        return this.F;
    }

    @Override // com.avito.android.express_cv.NewCvDataProvider
    @NotNull
    public MutableLiveData<List<Item>> getNewCvItems() {
        return this.z;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<PhoneCallEvent> getPhoneCallEvents() {
        return this.H;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<LoadingState<?>> getProgressChanges() {
        return this.B;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<CvDialogEvent> getShowDialogEvents() {
        return this.I;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<StartActivityEvent> getStartActivityEvents() {
        return this.E;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<StartActivityForResultEvent> getStartActivityForResultEvents() {
        return this.D;
    }

    @Override // com.avito.android.express_cv.ExpressCvViewModel
    @NotNull
    public MutableLiveData<Boolean> getTabsVisibilityChanges() {
        return this.A;
    }
}
