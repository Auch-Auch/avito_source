package com.avito.android.category_parameters;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.items.InputItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithState;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Quarter;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.android.remote.model.category_parameters.EditCategoryParameter;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.FormatterType;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.NumericParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.ParamButton;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.PriceParameter;
import com.avito.android.remote.model.category_parameters.RangeParameter;
import com.avito.android.remote.model.category_parameters.Restrictions;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasPlaceholder;
import com.avito.android.remote.model.category_parameters.base.TextParameter;
import com.avito.android.remote.model.delivery.CategoryParameterGroup;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.ObjectsSummaryFormatter;
import com.avito.android.validation.CategoryParameterStringValueConverterImpl;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\f\u0010s\u001a\b\u0012\u0004\u0012\u00020&0r\u0012\u0006\u0010i\u001a\u00020g\u0012\u0006\u0010V\u001a\u00020T\u0012\b\b\u0002\u0010S\u001a\u00020\f\u0012\b\b\u0002\u0010j\u001a\u00020\f\u0012\u0006\u0010u\u001a\u00020t\u0012\b\b\u0002\u0010b\u001a\u00020\f\u0012\b\b\u0002\u0010Z\u001a\u00020\f\u0012\b\b\u0002\u0010a\u001a\u00020\f\u0012\b\b\u0002\u0010k\u001a\u00020\f\u0012\u0006\u0010n\u001a\u00020l\u0012\u0006\u0010q\u001a\u00020o\u0012\u0006\u0010Q\u001a\u00020O¢\u0006\u0004\bv\u0010wJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\t*\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\t*\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\f*\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0016*\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0016H\u0002¢\u0006\u0004\b \u0010!J\u0013\u0010$\u001a\u00020#*\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u0004\u0018\u00010&*\u00020\u0002H\u0002¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u0004\u0018\u00010)*\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u0004\u0018\u00010&*\u00020\u0002H\u0002¢\u0006\u0004\b,\u0010(J\u0013\u0010-\u001a\u00020\u0016*\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010\u001eJ\u0015\u0010/\u001a\u0004\u0018\u00010.*\u00020\u0002H\u0002¢\u0006\u0004\b/\u00100J\u0013\u00102\u001a\u00020\u0013*\u000201H\u0002¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u00020\u0013*\u000201H\u0002¢\u0006\u0004\b4\u00103J/\u00109\u001a\u00020\u0013*\u0002012\u0006\u00105\u001a\u00020&2\b\u00107\u001a\u0004\u0018\u0001062\b\u00108\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b9\u0010:J\u0015\u0010=\u001a\u0004\u0018\u00010<*\u00020;H\u0002¢\u0006\u0004\b=\u0010>J!\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\u00062\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?¢\u0006\u0004\bC\u0010DJ?\u0010L\u001a\b\u0012\u0004\u0012\u00020B0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020E0?2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G2\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020J0IH\u0016¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\u0004\u0018\u00010&*\u00020\u0002H\u0014¢\u0006\u0004\bN\u0010(R\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010PR\u0016\u0010S\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010XR\u0016\u0010Z\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010RR\u0016\u0010]\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\\R\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010_R\u0016\u0010a\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010RR\u0016\u0010b\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010RR\u001e\u0010f\u001a\n d*\u0004\u0018\u00010c0c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010eR\u0016\u0010i\u001a\u00020g8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010hR\u0016\u0010j\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010RR\u0016\u0010k\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010RR\u0016\u0010n\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010mR\u0016\u0010q\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010p¨\u0006x"}, d2 = {"Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "p", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "selectedValue", "Lcom/avito/android/items/SelectableItem;", "s", "(Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;)Ljava/util/List;", "", "isSelected", "r", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;Z)Lcom/avito/android/items/SelectableItem;", "Lcom/avito/android/remote/model/Quarter;", VKApiConst.Q, "(Lcom/avito/android/remote/model/Quarter;Z)Lcom/avito/android/items/SelectableItem;", "Lcom/avito/android/items/InputItem;", "n", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Lcom/avito/android/items/InputItem;", "", "androidSdkInputType", "Lcom/avito/android/lib/design/input/FormatterType;", "e", "(I)Lcom/avito/android/lib/design/input/FormatterType;", "k", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Z", "i", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)I", "rawInputType", "f", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;I)Lcom/avito/android/lib/design/input/FormatterType;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", "Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "l", "(Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;)Lcom/avito/android/category_parameters/ParameterElement$DateTime;", "", "c", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Ljava/lang/String;", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "d", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "h", g.a, "Lcom/avito/android/remote/model/text/AttributedText;", "j", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/category_parameters/RangeParameter;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/remote/model/category_parameters/RangeParameter;)Lcom/avito/android/items/InputItem;", AuthSource.OPEN_CHANNEL_LIST, "title", "", "value", "error", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/category_parameters/RangeParameter;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/avito/android/items/InputItem;", "Lcom/avito/android/remote/model/category_parameters/ParamButton;", "Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "o", "(Lcom/avito/android/remote/model/category_parameters/ParamButton;)Lcom/avito/android/items/ItemWithAdditionalButton$AdditionalButton;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/remote/model/delivery/CategoryParameterGroup;", "groups", "Lcom/avito/conveyor_item/Item;", "convertGroup", "(Lcom/avito/konveyor/data_source/DataSource;)Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/category_parameters/CategoryParametersItemFactory;", "categoryParametersItemFactory", "", "Lcom/avito/android/category_parameters/SlotElementsProvider;", "slots", "convert", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/android/category_parameters/CategoryParametersItemFactory;Ljava/util/Set;)Ljava/util/List;", "getError", "Lcom/avito/android/Features;", "Lcom/avito/android/Features;", "features", "Z", "filterImmutable", "Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/util/ObjectsSummaryFormatter;", "Lcom/avito/android/util/ObjectsSummaryFormatter;", "summaryFormatter", "hideTitleSupported", "", "J", "minimumDate", "Lcom/avito/android/validation/CategoryParameterStringValueConverterImpl;", "Lcom/avito/android/validation/CategoryParameterStringValueConverterImpl;", "stringValueConverter", "rangeParam", "isOnlySortShown", "Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "Ljava/text/NumberFormat;", "decimalFormat", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "strDatesSearch", "videoPicker", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/util/Formatter;", "phoneFormatter", "Ljava/util/Locale;", "locale", "<init>", "(Lcom/avito/android/util/Formatter;Landroid/content/res/Resources;Lcom/avito/android/server_time/TimeSource;ZZLjava/util/Locale;ZZZZLcom/avito/android/html_formatter/HtmlNodeFactory;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/Features;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public class CategoryParametersElementConverter {
    public final NumberFormat a;
    public final ObjectsSummaryFormatter b;
    public final CategoryParameterStringValueConverterImpl c;
    public final long d;
    public final Resources e;
    public final TimeSource f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final HtmlNodeFactory m;
    public final HtmlCleaner n;
    public final Features o;

    @JvmOverloads
    public CategoryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlCleaner htmlCleaner, @NotNull Features features) {
        this(formatter, resources, timeSource, false, false, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 984, null);
    }

    @JvmOverloads
    public CategoryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, boolean z, @NotNull Locale locale, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlCleaner htmlCleaner, @NotNull Features features) {
        this(formatter, resources, timeSource, z, false, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 976, null);
    }

    @JvmOverloads
    public CategoryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, boolean z, boolean z2, @NotNull Locale locale, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlCleaner htmlCleaner, @NotNull Features features) {
        this(formatter, resources, timeSource, z, z2, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 960, null);
    }

    @JvmOverloads
    public CategoryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, boolean z, boolean z2, @NotNull Locale locale, boolean z3, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlCleaner htmlCleaner, @NotNull Features features) {
        this(formatter, resources, timeSource, z, z2, locale, z3, false, false, false, htmlNodeFactory, htmlCleaner, features, 896, null);
    }

    @JvmOverloads
    public CategoryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, boolean z, boolean z2, @NotNull Locale locale, boolean z3, boolean z4, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlCleaner htmlCleaner, @NotNull Features features) {
        this(formatter, resources, timeSource, z, z2, locale, z3, z4, false, false, htmlNodeFactory, htmlCleaner, features, 768, null);
    }

    @JvmOverloads
    public CategoryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, boolean z, boolean z2, @NotNull Locale locale, boolean z3, boolean z4, boolean z5, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlCleaner htmlCleaner, @NotNull Features features) {
        this(formatter, resources, timeSource, z, z2, locale, z3, z4, z5, false, htmlNodeFactory, htmlCleaner, features, 512, null);
    }

    @JvmOverloads
    public CategoryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, boolean z, boolean z2, @NotNull Locale locale, boolean z3, boolean z4, boolean z5, boolean z7, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlCleaner htmlCleaner, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(features, "features");
        this.e = resources;
        this.f = timeSource;
        this.g = z;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = z5;
        this.l = z7;
        this.m = htmlNodeFactory;
        this.n = htmlCleaner;
        this.o = features;
        NumberFormat instance = DecimalFormat.getInstance(locale);
        instance.setGroupingUsed(false);
        Unit unit = Unit.INSTANCE;
        this.a = instance;
        this.b = new ObjectsSummaryFormatter(resources);
        Intrinsics.checkNotNullExpressionValue(instance, "decimalFormat");
        this.c = new CategoryParameterStringValueConverterImpl(instance, formatter, resources);
        Calendar instance2 = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance2.set(1960, 0, 1);
        Intrinsics.checkNotNullExpressionValue(instance2, "GregorianCalendar.getIns…apply { set(1960, 0, 1) }");
        this.d = instance2.getTimeInMillis();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.category_parameters.CategoryParametersElementConverter */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List convert$default(CategoryParametersElementConverter categoryParametersElementConverter, DataSource dataSource, CategoryParametersItemFactory categoryParametersItemFactory, Set set, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                categoryParametersItemFactory = null;
            }
            if ((i2 & 4) != 0) {
                set = y.emptySet();
            }
            return categoryParametersElementConverter.convert(dataSource, categoryParametersItemFactory, set);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
    }

    public final InputItem a(RangeParameter rangeParameter, String str, Double d2, String str2) {
        int i2 = i(rangeParameter);
        return new ParameterElement.Input(rangeParameter.getId(), str, d2 != null ? this.a.format(d2.doubleValue()) : null, null, null, i2, 1, null, null, null, null, null, null, "Введите значение", null, str2 != null ? new ItemWithState.State.Error(str2, null, 2, null) : new ItemWithState.State.Normal(null, 1, null), f(rangeParameter, i2), false, null, 417664, null);
    }

    public final InputItem b(RangeParameter rangeParameter) {
        String fromTitle = rangeParameter.getDisplaying().getFromTitle();
        if (fromTitle == null) {
            fromTitle = "";
        }
        RangeParameter.RangeValue rangeValue = (RangeParameter.RangeValue) rangeParameter.getValue();
        return a(rangeParameter, fromTitle, rangeValue != null ? rangeValue.getFrom() : null, rangeParameter.getFromError());
    }

    public final String c(CategoryParameter categoryParameter) {
        if (categoryParameter instanceof EditableParameter) {
            EditableParameter editableParameter = (EditableParameter) categoryParameter;
            if (editableParameter.hasError() && editableParameter.hasValue()) {
                return editableParameter.getError();
            }
        }
        if (categoryParameter instanceof EditCategoryParameter) {
            EditCategoryParameter editCategoryParameter = (EditCategoryParameter) categoryParameter;
            if (editCategoryParameter.hasError()) {
                return editCategoryParameter.getError();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r53v0, types: [com.avito.android.category_parameters.CategoryParametersElementConverter] */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v5, types: [com.avito.android.items.InputItem] */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r37v0, types: [com.avito.android.items.ItemWithAdditionalButton$AdditionalButton] */
    /* JADX WARN: Type inference failed for: r37v1 */
    /* JADX WARN: Type inference failed for: r23v7, types: [com.avito.android.category_parameters.ParameterElement$SelectDeepLink] */
    /* JADX WARN: Type inference failed for: r23v8, types: [com.avito.android.category_parameters.ParameterElement$Multiselect] */
    /* JADX WARN: Type inference failed for: r23v9, types: [com.avito.android.items.RangeItem$CreRangeItem] */
    /* JADX WARN: Type inference failed for: r23v11, types: [com.avito.android.items.CheckBoxItem] */
    /* JADX WARN: Type inference failed for: r23v12 */
    /* JADX WARN: Type inference failed for: r23v13, types: [com.avito.android.category_parameters.ParameterElement$Objects] */
    /* JADX WARN: Type inference failed for: r23v14, types: [com.avito.android.category_parameters.ParameterElement$Input] */
    /* JADX WARN: Type inference failed for: r23v15, types: [com.avito.android.category_parameters.ParameterElement$TextAreaInput] */
    /* JADX WARN: Type inference failed for: r23v16, types: [com.avito.android.category_parameters.ParameterElement$Multiselect] */
    /* JADX WARN: Type inference failed for: r29v5, types: [com.avito.android.category_parameters.ParameterElement$Select$Sectioned] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0290, code lost:
        if (r11.equals(com.avito.android.remote.model.category_parameters.MultiselectParameterKt.DISPLAY_TYPE_INLINE) != false) goto L_0x0292;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0292, code lost:
        r4 = com.avito.android.category_parameters.ParameterElement.DisplayType.Inlined.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
        if (((com.avito.android.remote.model.category_parameters.base.CategoryParameter) r10).getImmutable() != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x024b, code lost:
        if (r11.equals("inlined") != false) goto L_0x0292;
     */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:367:0x091e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.conveyor_item.Item> convert(@org.jetbrains.annotations.NotNull com.avito.konveyor.data_source.DataSource<com.avito.android.remote.model.category_parameters.base.ParameterSlot> r54, @org.jetbrains.annotations.Nullable com.avito.android.category_parameters.CategoryParametersItemFactory r55, @org.jetbrains.annotations.NotNull java.util.Set<? extends com.avito.android.category_parameters.SlotElementsProvider> r56) {
        /*
        // Method dump skipped, instructions count: 2392
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.category_parameters.CategoryParametersElementConverter.convert(com.avito.konveyor.data_source.DataSource, com.avito.android.category_parameters.CategoryParametersItemFactory, java.util.Set):java.util.List");
    }

    @NotNull
    public final List<Item> convertGroup(@NotNull DataSource<CategoryParameterGroup> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "groups");
        ArrayList arrayList = new ArrayList();
        int count = dataSource.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            arrayList.addAll(convert$default(this, new ListDataSource(dataSource.getItem(i2).getFields()), null, null, 6, null));
        }
        return CollectionsKt___CollectionsKt.filterNotNull(arrayList);
    }

    public final DisplayingOptions d(CategoryParameter categoryParameter) {
        if (categoryParameter instanceof TextParameter) {
            return ((TextParameter) categoryParameter).getDisplayingOptions();
        }
        if (categoryParameter instanceof PriceParameter) {
            DisplayingOptions displayingOptions = ((PriceParameter) categoryParameter).getDisplayingOptions();
            if (displayingOptions == null) {
                return null;
            }
            if (displayingOptions.getFormatter() == null) {
                return DisplayingOptions.copy$default(displayingOptions, null, null, null, null, null, null, FormatterType.PRICE, null, false, null, null, null, 4031, null);
            }
            return displayingOptions;
        } else if (categoryParameter instanceof AddressParameter) {
            return ((AddressParameter) categoryParameter).getDisplaying();
        } else {
            if (categoryParameter instanceof PhotoParameter) {
                return ((PhotoParameter) categoryParameter).getDisplayingOptions();
            }
            if (categoryParameter instanceof ObjectsParameter) {
                return ((ObjectsParameter) categoryParameter).getDisplayingOptions();
            }
            return null;
        }
    }

    public final com.avito.android.lib.design.input.FormatterType e(int i2) {
        return new com.avito.android.lib.design.input.FormatterType(0, "", Integer.valueOf(i2), null, 1, null);
    }

    public final com.avito.android.lib.design.input.FormatterType f(CategoryParameter categoryParameter, int i2) {
        com.avito.android.lib.design.input.FormatterType decimal;
        DisplayingOptions displayingOptions;
        CategoryParameter categoryParameter2 = categoryParameter;
        if (categoryParameter2 instanceof NumericParameter) {
            decimal = com.avito.android.lib.design.input.FormatterType.Companion.getFLOATING_POINT();
        } else if ((categoryParameter2 instanceof IntParameter) || (categoryParameter2 instanceof PriceParameter)) {
            decimal = com.avito.android.lib.design.input.FormatterType.Companion.getDECIMAL();
        } else if (categoryParameter2 instanceof PhoneParameter) {
            decimal = com.avito.android.lib.design.input.FormatterType.Companion.getMOBILE_PHONE();
        } else if (categoryParameter2 instanceof RangeParameter) {
            decimal = ((RangeParameter) categoryParameter2).getDisplaying().getDataType() == RangeParameter.DataType.FLOAT ? com.avito.android.lib.design.input.FormatterType.Companion.getFLOATING_POINT() : com.avito.android.lib.design.input.FormatterType.Companion.getDECIMAL();
        } else {
            decimal = new com.avito.android.lib.design.input.FormatterType(Integer.MAX_VALUE, null, Integer.valueOf(i2), null, 10, null);
        }
        Boolean bool = null;
        if (!(categoryParameter2 instanceof TextParameter)) {
            categoryParameter2 = null;
        }
        TextParameter textParameter = (TextParameter) categoryParameter2;
        if (!(textParameter == null || (displayingOptions = textParameter.getDisplayingOptions()) == null)) {
            bool = displayingOptions.getDisableMask();
        }
        return (!this.o.getDisableInputMasks().invoke().booleanValue() || !Intrinsics.areEqual(bool, Boolean.TRUE)) ? decimal : com.avito.android.lib.design.input.FormatterType.copy$default(decimal, 0, null, null, null, 7, null);
    }

    public final int g(CategoryParameter categoryParameter) {
        int i2;
        if (categoryParameter instanceof TextParameter) {
            DisplayingOptions displayingOptions = ((TextParameter) categoryParameter).getDisplayingOptions();
            if (Intrinsics.areEqual(displayingOptions != null ? displayingOptions.getMultiline() : null, Boolean.TRUE)) {
                i2 = 3;
                return Math.max(1, i2);
            }
        }
        i2 = 1;
        return Math.max(1, i2);
    }

    @Nullable
    public String getError(@NotNull CategoryParameter categoryParameter) {
        Intrinsics.checkNotNullParameter(categoryParameter, "$this$getError");
        if ((categoryParameter instanceof EditCategoryParameter) && ((EditCategoryParameter) categoryParameter).hasError()) {
            return categoryParameter.getTitle();
        }
        if (!(categoryParameter instanceof EditableParameter)) {
            return null;
        }
        EditableParameter editableParameter = (EditableParameter) categoryParameter;
        if (!editableParameter.hasError()) {
            return null;
        }
        if (editableParameter.hasValue()) {
            return this.c.getValue(categoryParameter);
        }
        return categoryParameter.getTitle();
    }

    public final String h(CategoryParameter categoryParameter) {
        String str = null;
        if (!(categoryParameter instanceof HasPlaceholder)) {
            return null;
        }
        String placeholder = ((HasPlaceholder) categoryParameter).getPlaceholder();
        if (placeholder != null) {
            return placeholder;
        }
        if ((categoryParameter instanceof SelectParameter) || (categoryParameter instanceof MultiselectParameter)) {
            return "Выбрать";
        }
        if (categoryParameter instanceof AddressParameter) {
            return "Укажите место";
        }
        if (categoryParameter instanceof PhoneParameter) {
            return "Введите номер телефона";
        }
        if (categoryParameter instanceof PriceParameter) {
            StringBuilder L = a.L("Цена, ");
            DisplayingOptions displayingOptions = ((PriceParameter) categoryParameter).getDisplayingOptions();
            if (displayingOptions != null) {
                str = displayingOptions.getPostfix();
            }
            L.append(str);
            return L.toString();
        } else if (categoryParameter instanceof TextParameter) {
            return "Введите значение";
        } else {
            return null;
        }
    }

    public final int i(CategoryParameter categoryParameter) {
        if (!(categoryParameter instanceof NumericParameter)) {
            if (!(categoryParameter instanceof IntParameter) && !(categoryParameter instanceof PriceParameter)) {
                if (categoryParameter instanceof EmailParameter) {
                    return 32;
                }
                if (!(categoryParameter instanceof RangeParameter)) {
                    return (!(categoryParameter instanceof CharParameter) || ((CharParameter) categoryParameter).getInputType() != CharParameter.InputType.VIN) ? 16385 : 528385;
                }
                if (((RangeParameter) categoryParameter).getDisplaying().getDataType() == RangeParameter.DataType.FLOAT) {
                }
            }
            return 2;
        }
        return 8194;
    }

    public final AttributedText j(CategoryParameter categoryParameter) {
        if (categoryParameter instanceof TextParameter) {
            return categoryParameter.getMotivation();
        }
        if (categoryParameter instanceof PhoneParameter) {
            return ((PhoneParameter) categoryParameter).getMotivation();
        }
        return null;
    }

    public final boolean k(CategoryParameter categoryParameter) {
        SelectParameter.Displaying displaying;
        if (this.j) {
            DisplayingOptions d2 = d(categoryParameter);
            if (d2 != null && d2.getHideTitle()) {
                return true;
            }
            if (!(categoryParameter instanceof SelectParameter)) {
                categoryParameter = null;
            }
            SelectParameter selectParameter = (SelectParameter) categoryParameter;
            if (selectParameter != null && (displaying = selectParameter.getDisplaying()) != null && displaying.getHideTitle()) {
                return true;
            }
        }
        return false;
    }

    public final ParameterElement.DateTime l(DateTimeParameter dateTimeParameter) {
        long j2;
        long j3;
        Restrictions.Limit limit;
        Long max;
        Restrictions.Limit limit2;
        Long min;
        Restrictions restrictions = dateTimeParameter.getRestrictions();
        if (restrictions == null || (limit2 = restrictions.getLimit()) == null || (min = limit2.getMin()) == null) {
            j2 = this.d;
        } else {
            j2 = TimeUnit.SECONDS.toMillis(min.longValue());
        }
        Restrictions restrictions2 = dateTimeParameter.getRestrictions();
        if (restrictions2 == null || (limit = restrictions2.getLimit()) == null || (max = limit.getMax()) == null) {
            j3 = this.f.now();
        } else {
            j3 = TimeUnit.SECONDS.toMillis(max.longValue());
        }
        String title = (dateTimeParameter.hasValue() || !dateTimeParameter.hasError()) ? null : dateTimeParameter.getTitle();
        Long timestamp = dateTimeParameter.isPresentTime() ? null : dateTimeParameter.getTimestamp();
        String id = dateTimeParameter.getId();
        String title2 = dateTimeParameter.getTitle();
        boolean z = !dateTimeParameter.getRequired();
        DateTimeParameter.PresentTimeOptions presentTime = dateTimeParameter.getPresentTime();
        return new ParameterElement.DateTime(id, title2, timestamp, j2, j3, z, presentTime != null ? presentTime.getTitle() : null, dateTimeParameter.isPresentTime(), null, c(dateTimeParameter), title, title != null ? new ItemWithState.State.Error(title, null, 2, null) : new ItemWithState.State.Normal(null, 1, null), 256, null);
    }

    public final InputItem m(RangeParameter rangeParameter) {
        String toTitle = rangeParameter.getDisplaying().getToTitle();
        if (toTitle == null) {
            toTitle = "";
        }
        RangeParameter.RangeValue rangeValue = (RangeParameter.RangeValue) rangeParameter.getValue();
        return a(rangeParameter, toTitle, rangeValue != null ? rangeValue.getTo() : null, rangeParameter.getToError());
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.items.InputItem n(com.avito.android.remote.model.category_parameters.base.CategoryParameter r28) {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.category_parameters.CategoryParametersElementConverter.n(com.avito.android.remote.model.category_parameters.base.CategoryParameter):com.avito.android.items.InputItem");
    }

    public final ItemWithAdditionalButton.AdditionalButton o(ParamButton paramButton) {
        ItemWithAdditionalButton.AdditionalButtonType additionalButtonType;
        String type = paramButton.getType();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.String");
        String upperCase = type.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        ItemWithAdditionalButton.AdditionalButtonType[] values = ItemWithAdditionalButton.AdditionalButtonType.values();
        int i2 = 0;
        while (true) {
            if (i2 >= 1) {
                additionalButtonType = null;
                break;
            }
            additionalButtonType = values[i2];
            if (Intrinsics.areEqual(additionalButtonType.name(), upperCase)) {
                break;
            }
            i2++;
        }
        if (additionalButtonType != null) {
            return new ItemWithAdditionalButton.AdditionalButton(additionalButtonType, paramButton.getLink());
        }
        return null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.category_parameters.ParameterElement.Select.Flat p(com.avito.android.remote.model.category_parameters.base.CategoryParameter r28) {
        /*
        // Method dump skipped, instructions count: 424
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.category_parameters.CategoryParametersElementConverter.p(com.avito.android.remote.model.category_parameters.base.CategoryParameter):com.avito.android.category_parameters.ParameterElement$Select$Flat");
    }

    public final SelectableItem q(Quarter quarter, boolean z) {
        return new SelectableItem(quarter.getId(), quarter.getTitle(), z, null, 8, null);
    }

    public final SelectableItem r(SelectParameter.Value value, boolean z) {
        Color color;
        String id = value.getId();
        String title = value.getTitle();
        SelectParameter.Value.Display display = value.getDisplay();
        return new SelectableItem(id, title, z, (display == null || (color = display.getColor()) == null) ? null : Integer.valueOf(color.getValue()));
    }

    public final List<SelectableItem> s(List<SelectParameter.Value> list, SelectParameter.Value value) {
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(r(t, Intrinsics.areEqual(value, t)));
        }
        return arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryParametersElementConverter(Formatter formatter, Resources resources, TimeSource timeSource, boolean z, boolean z2, Locale locale, boolean z3, boolean z4, boolean z5, boolean z7, HtmlNodeFactory htmlNodeFactory, HtmlCleaner htmlCleaner, Features features, int i2, j jVar) {
        this(formatter, resources, timeSource, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, locale, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? false : z4, (i2 & 256) != 0 ? false : z5, (i2 & 512) != 0 ? false : z7, htmlNodeFactory, htmlCleaner, features);
    }
}
