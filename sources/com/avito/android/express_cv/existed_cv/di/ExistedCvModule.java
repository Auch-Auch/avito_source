package com.avito.android.express_cv.existed_cv.di;

import a2.b.a.a.a;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.ButtonItemPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.express_cv.existed_cv.item.CvItemClickListener;
import com.avito.android.express_cv.existed_cv.item.DisclaimerBlueprint;
import com.avito.android.express_cv.existed_cv.item.ExistedCvItemBlueprint;
import com.avito.android.express_cv.existed_cv.item.ExistedCvItemPresenter;
import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.TextItemBlueprint;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010&\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/express_cv/existed_cv/di/ExistedCvModule;", "", "Lcom/avito/android/express_cv/existed_cv/item/ExistedCvItemPresenter;", "itemPresenter", "Lcom/avito/android/express_cv/existed_cv/item/ExistedCvItemBlueprint;", "provideExistedCvBlueprint$express_cv_release", "(Lcom/avito/android/express_cv/existed_cv/item/ExistedCvItemPresenter;)Lcom/avito/android/express_cv/existed_cv/item/ExistedCvItemBlueprint;", "provideExistedCvBlueprint", "Ldagger/Lazy;", "Lcom/avito/android/express_cv/existed_cv/item/CvItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "provideExistedCvItemPresenter$express_cv_release", "(Ldagger/Lazy;)Lcom/avito/android/express_cv/existed_cv/item/ExistedCvItemPresenter;", "provideExistedCvItemPresenter", "Lcom/avito/android/blueprints/ButtonItemPresenter;", "buttonItemPresenter", "Lcom/avito/android/blueprints/ButtonItemBlueprint;", "provideButtonBlueprint", "(Lcom/avito/android/blueprints/ButtonItemPresenter;)Lcom/avito/android/blueprints/ButtonItemBlueprint;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "provideButtonItemPresenter", "(Ldagger/Lazy;)Lcom/avito/android/blueprints/ButtonItemPresenter;", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideSimpleAdapter$express_cv_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideSimpleAdapter", "Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;", "textItemBlueprint", "existedCvItemBlueprint", "buttonItemBlueprint", "Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;", "disclaimerBlueprint", "Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;", "flatButtonBlueprint", "provideExistedCvItemBinder$express_cv_release", "(Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;Lcom/avito/android/express_cv/existed_cv/item/ExistedCvItemBlueprint;Lcom/avito/android/blueprints/ButtonItemBlueprint;Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideExistedCvItemBinder", "<init>", "()V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ExistedCvModule {
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
    public final ExistedCvItemBlueprint provideExistedCvBlueprint$express_cv_release(@NotNull ExistedCvItemPresenter existedCvItemPresenter) {
        Intrinsics.checkNotNullParameter(existedCvItemPresenter, "itemPresenter");
        return new ExistedCvItemBlueprint(existedCvItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideExistedCvItemBinder$express_cv_release(@NotNull TextItemBlueprint textItemBlueprint, @NotNull ExistedCvItemBlueprint existedCvItemBlueprint, @NotNull ButtonItemBlueprint buttonItemBlueprint, @NotNull DisclaimerBlueprint disclaimerBlueprint, @NotNull FlatButtonBlueprint flatButtonBlueprint) {
        Intrinsics.checkNotNullParameter(textItemBlueprint, "textItemBlueprint");
        Intrinsics.checkNotNullParameter(existedCvItemBlueprint, "existedCvItemBlueprint");
        Intrinsics.checkNotNullParameter(buttonItemBlueprint, "buttonItemBlueprint");
        Intrinsics.checkNotNullParameter(disclaimerBlueprint, "disclaimerBlueprint");
        Intrinsics.checkNotNullParameter(flatButtonBlueprint, "flatButtonBlueprint");
        return new ItemBinder.Builder().registerItem(textItemBlueprint).registerItem(existedCvItemBlueprint).registerItem(buttonItemBlueprint).registerItem(disclaimerBlueprint).registerItem(flatButtonBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final ExistedCvItemPresenter provideExistedCvItemPresenter$express_cv_release(@NotNull Lazy<CvItemClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ExistedCvItemPresenter(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideSimpleAdapter$express_cv_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }
}
