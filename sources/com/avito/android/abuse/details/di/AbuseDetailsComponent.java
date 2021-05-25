package com.avito.android.abuse.details.di;

import android.content.res.Resources;
import com.avito.android.abuse.details.AbuseDetailsActivity;
import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.PerActivity;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.remote.model.Action;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00072\u00020\u0001:\u0002\b\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/abuse/details/di/AbuseDetailsComponent;", "", "Lcom/avito/android/abuse/details/AbuseDetailsActivity;", "activity", "", "inject", "(Lcom/avito/android/abuse/details/AbuseDetailsActivity;)V", "Companion", "Builder", "abuse_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AbuseDetailsDependencies.class}, modules = {AdapterModule.class, AbuseDetailsModule.class})
@PerActivity
public interface AbuseDetailsComponent {
    @NotNull
    public static final String CATEGORY_ID = "category_id";
    @NotNull
    public static final String CHANGED = "changed";
    @NotNull
    public static final String CLICKED = "clicked";
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String FOCUSED = "focused";
    @NotNull
    public static final String ITEM_ID = "item_id";
    @NotNull
    public static final String SRC = "src";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00002\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\rH'¢\u0006\u0004\b\u0012\u0010\u0010J\u001f\u0010\b\u001a\u00020\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H'¢\u0006\u0004\b\b\u0010\u0016J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0004\b\b\u0010\u0019J\u001f\u0010\u001d\u001a\u00020\u00002\u000e\b\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00002\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH'¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010#\u001a\u00020\u00002\u000e\b\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001aH'¢\u0006\u0004\b#\u0010\u001eJ\u000f\u0010%\u001a\u00020$H&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "", "Lcom/avito/android/abuse/details/di/AbuseDetailsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/abuse/details/di/AbuseDetailsDependencies;)Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "with", "(Landroid/content/res/Resources;)Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "", "categoryId", "(I)Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "", "itemId", "withItemId", "(Ljava/lang/String;)Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "src", "withSrc", "", "Lcom/avito/android/remote/model/Action;", "actions", "(Ljava/util/List;)Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "presenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "fieldChangedStream", "withChanged", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Builder;", "fieldFocusedStream", "withFocused", "Lcom/avito/android/deep_linking/links/DeepLink;", "fieldClickStream", "withClicked", "Lcom/avito/android/abuse/details/di/AbuseDetailsComponent;", "build", "()Lcom/avito/android/abuse/details/di/AbuseDetailsComponent;", "abuse_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AbuseDetailsComponent build();

        @NotNull
        Builder dependentOn(@NotNull AbuseDetailsDependencies abuseDetailsDependencies);

        @BindsInstance
        @NotNull
        Builder with(@Named("category_id") int i);

        @BindsInstance
        @NotNull
        Builder with(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder with(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder with(@Nullable List<Action> list);

        @BindsInstance
        @NotNull
        Builder withChanged(@Named("changed") @NotNull PublishRelay<AbuseField> publishRelay);

        @BindsInstance
        @NotNull
        Builder withClicked(@Named("clicked") @NotNull PublishRelay<DeepLink> publishRelay);

        @BindsInstance
        @NotNull
        Builder withFocused(@Named("focused") @NotNull PublishRelay<AbuseField> publishRelay);

        @BindsInstance
        @NotNull
        Builder withItemId(@Named("item_id") @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withSrc(@Named("src") @Nullable String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/avito/android/abuse/details/di/AbuseDetailsComponent$Companion;", "", "", "ITEM_ID", "Ljava/lang/String;", "CHANGED", "CLICKED", "FOCUSED", "SRC", "CATEGORY_ID", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String CATEGORY_ID = "category_id";
        @NotNull
        public static final String CHANGED = "changed";
        @NotNull
        public static final String CLICKED = "clicked";
        @NotNull
        public static final String FOCUSED = "focused";
        @NotNull
        public static final String ITEM_ID = "item_id";
        @NotNull
        public static final String SRC = "src";
        public static final /* synthetic */ Companion a = new Companion();
    }

    void inject(@NotNull AbuseDetailsActivity abuseDetailsActivity);
}
