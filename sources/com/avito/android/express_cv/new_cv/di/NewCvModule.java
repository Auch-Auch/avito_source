package com.avito.android.express_cv.new_cv.di;

import android.content.Context;
import android.text.TextWatcher;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.ButtonItemPresenterImpl;
import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.blueprints.InputItemPresenterImpl;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.blueprints.publish.SelectItemBlueprint;
import com.avito.android.blueprints.publish.SelectItemPresenter;
import com.avito.android.blueprints.publish.SelectItemPresenterImpl;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemBlueprint;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemPresenter;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.InputItemFormatterProviderModule;
import com.avito.android.express_cv.existed_cv.item.DisclaimerBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.TextItemBlueprint;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u001a\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#J\u001d\u0010&\u001a\u00020\u001f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0016H\u0007¢\u0006\u0004\b&\u0010'J/\u0010-\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020(0\u00162\b\b\u0001\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b-\u0010.JG\u0010;\u001a\u00020\u00022\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u000f2\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0001¢\u0006\u0004\b9\u0010:¨\u0006@"}, d2 = {"Lcom/avito/android/express_cv/new_cv/di/NewCvModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideSimpleAdapter$express_cv_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideSimpleAdapter", "Lcom/avito/android/blueprints/InputItemPresenter;", "presenter", "Lcom/avito/android/blueprints/InputItemBlueprint;", "provideInputItemBluePrint", "(Lcom/avito/android/blueprints/InputItemPresenter;)Lcom/avito/android/blueprints/InputItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenter;", "itemPresenter", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemBlueprint;", "providePhoneInputItemBlueprint$express_cv_release", "(Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenter;)Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemBlueprint;", "providePhoneInputItemBlueprint", "providePhoneInputItemPresenter$express_cv_release", "()Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenter;", "providePhoneInputItemPresenter", "Ldagger/Lazy;", "Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClickListener;", "clickListener", "Lcom/avito/android/blueprints/publish/SelectItemPresenter;", "selectItemPresenter", "(Ldagger/Lazy;)Lcom/avito/android/blueprints/publish/SelectItemPresenter;", "Lcom/avito/android/blueprints/publish/SelectItemBlueprint;", "locationSelectItemBluePrint", "(Lcom/avito/android/blueprints/publish/SelectItemPresenter;)Lcom/avito/android/blueprints/publish/SelectItemBlueprint;", "Lcom/avito/android/blueprints/ButtonItemPresenter;", "buttonItemPresenter", "Lcom/avito/android/blueprints/ButtonItemBlueprint;", "provideButtonBlueprint", "(Lcom/avito/android/blueprints/ButtonItemPresenter;)Lcom/avito/android/blueprints/ButtonItemBlueprint;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "provideButtonItemPresenter", "(Ldagger/Lazy;)Lcom/avito/android/blueprints/ButtonItemPresenter;", "Lcom/avito/android/blueprints/publish/PrimaryParametersListener;", "Landroid/text/TextWatcher;", "phoneTextWatcher", "Lcom/avito/android/provider/InputItemFormatterProvider;", "formatterProvider", "provideInputItemPresenter", "(Ldagger/Lazy;Landroid/text/TextWatcher;Lcom/avito/android/provider/InputItemFormatterProvider;)Lcom/avito/android/blueprints/InputItemPresenter;", "Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;", "textItemBlueprint", "selectItemBlueprint", "inputItemBlueprint", "buttonItemBlueprint", "phoneInputItemBlueprint", "Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;", "disclaimerBlueprint", "Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;", "flatButtonBlueprint", "provideNewCvItemBinder$express_cv_release", "(Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;Lcom/avito/android/blueprints/publish/SelectItemBlueprint;Lcom/avito/android/blueprints/InputItemBlueprint;Lcom/avito/android/blueprints/ButtonItemBlueprint;Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemBlueprint;Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideNewCvItemBinder", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, InputItemFormatterProviderModule.class})
public final class NewCvModule {

    public static final class a<T> implements Consumer<PhoneInputItem> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PhoneInputItem phoneInputItem) {
        }
    }

    public NewCvModule(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Provides
    @PerFragment
    @NotNull
    public final SelectItemBlueprint locationSelectItemBluePrint(@NotNull SelectItemPresenter selectItemPresenter) {
        Intrinsics.checkNotNullParameter(selectItemPresenter, "presenter");
        return new SelectItemBlueprint(selectItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ButtonItemBlueprint provideButtonBlueprint(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "buttonItemPresenter");
        return new ButtonItemBlueprint(buttonItemPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final ButtonItemPresenter provideButtonItemPresenter(@NotNull Lazy<ButtonItemPresenter.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ButtonItemPresenterImpl(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final InputItemBlueprint provideInputItemBluePrint(@NotNull InputItemPresenter inputItemPresenter) {
        Intrinsics.checkNotNullParameter(inputItemPresenter, "presenter");
        return new InputItemBlueprint(inputItemPresenter, null, 2, null);
    }

    @Provides
    @NotNull
    @PerFragment
    public final InputItemPresenter provideInputItemPresenter(@NotNull Lazy<PrimaryParametersListener> lazy, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull TextWatcher textWatcher, @NotNull InputItemFormatterProvider inputItemFormatterProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(textWatcher, "phoneTextWatcher");
        Intrinsics.checkNotNullParameter(inputItemFormatterProvider, "formatterProvider");
        return new InputItemPresenterImpl(lazy, textWatcher, inputItemFormatterProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideNewCvItemBinder$express_cv_release(@NotNull TextItemBlueprint textItemBlueprint, @NotNull SelectItemBlueprint selectItemBlueprint, @NotNull InputItemBlueprint inputItemBlueprint, @NotNull ButtonItemBlueprint buttonItemBlueprint, @NotNull PhoneInputItemBlueprint phoneInputItemBlueprint, @NotNull DisclaimerBlueprint disclaimerBlueprint, @NotNull FlatButtonBlueprint flatButtonBlueprint) {
        Intrinsics.checkNotNullParameter(textItemBlueprint, "textItemBlueprint");
        Intrinsics.checkNotNullParameter(selectItemBlueprint, "selectItemBlueprint");
        Intrinsics.checkNotNullParameter(inputItemBlueprint, "inputItemBlueprint");
        Intrinsics.checkNotNullParameter(buttonItemBlueprint, "buttonItemBlueprint");
        Intrinsics.checkNotNullParameter(phoneInputItemBlueprint, "phoneInputItemBlueprint");
        Intrinsics.checkNotNullParameter(disclaimerBlueprint, "disclaimerBlueprint");
        Intrinsics.checkNotNullParameter(flatButtonBlueprint, "flatButtonBlueprint");
        return new ItemBinder.Builder().registerItem(inputItemBlueprint).registerItem(textItemBlueprint).registerItem(selectItemBlueprint).registerItem(phoneInputItemBlueprint).registerItem(buttonItemBlueprint).registerItem(disclaimerBlueprint).registerItem(flatButtonBlueprint).build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneInputItemBlueprint providePhoneInputItemBlueprint$express_cv_release(@NotNull PhoneInputItemPresenter phoneInputItemPresenter) {
        Intrinsics.checkNotNullParameter(phoneInputItemPresenter, "itemPresenter");
        return new PhoneInputItemBlueprint(phoneInputItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneInputItemPresenter providePhoneInputItemPresenter$express_cv_release() {
        return new PhoneInputItemPresenterImpl(a.a);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideSimpleAdapter$express_cv_release(@NotNull ItemBinder itemBinder) {
        return a2.b.a.a.a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerFragment
    public final SelectItemPresenter selectItemPresenter(@NotNull Lazy<SelectItemPresenter.ClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "clickListener");
        return new SelectItemPresenterImpl(lazy, null);
    }
}
