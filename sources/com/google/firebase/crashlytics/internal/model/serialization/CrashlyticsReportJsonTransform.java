package com.google.firebase.crashlytics.internal.model.serialization;

import a2.j.e.d.d.c.u.b;
import a2.j.e.d.d.c.u.f;
import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.util.preferences.SessionContract;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import ru.ok.android.sdk.Shared;
public class CrashlyticsReportJsonTransform {
    public static final DataEncoder a = new JsonDataEncoderBuilder().configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();

    public interface a<T> {
        T a(@NonNull JsonReader jsonReader) throws IOException;
    }

    @NonNull
    public static <T> ImmutableList<T> a(@NonNull JsonReader jsonReader, @NonNull a<T> aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(aVar.a(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.from(arrayList);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x01d5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x01bd A[SYNTHETIC] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event b(@androidx.annotation.NonNull android.util.JsonReader r12) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 826
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.b(android.util.JsonReader):com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event");
    }

    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.Exception c(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setFrames(a(jsonReader, f.a));
                    break;
                case 1:
                    builder.setReason(jsonReader.nextString());
                    break;
                case 2:
                    builder.setType(jsonReader.nextString());
                    break;
                case 3:
                    builder.setCausedBy(c(jsonReader));
                    break;
                case 4:
                    builder.setOverflowCount(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame d(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setOffset(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setSymbol(jsonReader.nextString());
                    break;
                case 2:
                    builder.setPc(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setFile(jsonReader.nextString());
                    break;
                case 4:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @NonNull
    public static CrashlyticsReport e(@NonNull JsonReader jsonReader) throws IOException {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1874684019:
                    if (nextName.equals(Shared.PARAM_PLATFORM)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1984987798:
                    if (nextName.equals(SessionContract.SESSION)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    CrashlyticsReport.FilesPayload.Builder builder2 = CrashlyticsReport.FilesPayload.builder();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.hashCode();
                        if (nextName2.equals("files")) {
                            builder2.setFiles(a(jsonReader, b.a));
                        } else if (!nextName2.equals("orgId")) {
                            jsonReader.skipValue();
                        } else {
                            builder2.setOrgId(jsonReader.nextString());
                        }
                    }
                    jsonReader.endObject();
                    builder.setNdkPayload(builder2.build());
                    break;
                case 1:
                    builder.setSdkVersion(jsonReader.nextString());
                    break;
                case 2:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 3:
                    builder.setGmpAppId(jsonReader.nextString());
                    break;
                case 4:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case 5:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                case 6:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                case 7:
                    CrashlyticsReport.Session.Builder builder3 = CrashlyticsReport.Session.builder();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.hashCode();
                        switch (nextName3.hashCode()) {
                            case -2128794476:
                                if (nextName3.equals("startedAt")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1618432855:
                                if (nextName3.equals("identifier")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1606742899:
                                if (nextName3.equals("endedAt")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1335157162:
                                if (nextName3.equals("device")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -1291329255:
                                if (nextName3.equals("events")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3556:
                                if (nextName3.equals("os")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 96801:
                                if (nextName3.equals("app")) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3599307:
                                if (nextName3.equals("user")) {
                                    c2 = 7;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 286956243:
                                if (nextName3.equals("generator")) {
                                    c2 = '\b';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1025385094:
                                if (nextName3.equals("crashed")) {
                                    c2 = '\t';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 2047016109:
                                if (nextName3.equals("generatorType")) {
                                    c2 = '\n';
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                                builder3.setStartedAt(jsonReader.nextLong());
                                break;
                            case 1:
                                builder3.setIdentifierFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                                break;
                            case 2:
                                builder3.setEndedAt(Long.valueOf(jsonReader.nextLong()));
                                break;
                            case 3:
                                CrashlyticsReport.Session.Device.Builder builder4 = CrashlyticsReport.Session.Device.builder();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName4 = jsonReader.nextName();
                                    nextName4.hashCode();
                                    switch (nextName4.hashCode()) {
                                        case -1981332476:
                                            if (nextName4.equals("simulator")) {
                                                c3 = 0;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case -1969347631:
                                            if (nextName4.equals("manufacturer")) {
                                                c3 = 1;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 112670:
                                            if (nextName4.equals("ram")) {
                                                c3 = 2;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 3002454:
                                            if (nextName4.equals("arch")) {
                                                c3 = 3;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 81784169:
                                            if (nextName4.equals("diskSpace")) {
                                                c3 = 4;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 94848180:
                                            if (nextName4.equals("cores")) {
                                                c3 = 5;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 104069929:
                                            if (nextName4.equals(VerticalFilterCloseDialogEventKt.MODEL_DIALOG)) {
                                                c3 = 6;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 109757585:
                                            if (nextName4.equals("state")) {
                                                c3 = 7;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 2078953423:
                                            if (nextName4.equals("modelClass")) {
                                                c3 = '\b';
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        default:
                                            c3 = 65535;
                                            break;
                                    }
                                    switch (c3) {
                                        case 0:
                                            builder4.setSimulator(jsonReader.nextBoolean());
                                            break;
                                        case 1:
                                            builder4.setManufacturer(jsonReader.nextString());
                                            break;
                                        case 2:
                                            builder4.setRam(jsonReader.nextLong());
                                            break;
                                        case 3:
                                            builder4.setArch(jsonReader.nextInt());
                                            break;
                                        case 4:
                                            builder4.setDiskSpace(jsonReader.nextLong());
                                            break;
                                        case 5:
                                            builder4.setCores(jsonReader.nextInt());
                                            break;
                                        case 6:
                                            builder4.setModel(jsonReader.nextString());
                                            break;
                                        case 7:
                                            builder4.setState(jsonReader.nextInt());
                                            break;
                                        case '\b':
                                            builder4.setModelClass(jsonReader.nextString());
                                            break;
                                        default:
                                            jsonReader.skipValue();
                                            break;
                                    }
                                }
                                jsonReader.endObject();
                                builder3.setDevice(builder4.build());
                                break;
                            case 4:
                                builder3.setEvents(a(jsonReader, a2.j.e.d.d.c.u.a.a));
                                break;
                            case 5:
                                CrashlyticsReport.Session.OperatingSystem.Builder builder5 = CrashlyticsReport.Session.OperatingSystem.builder();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName5 = jsonReader.nextName();
                                    nextName5.hashCode();
                                    switch (nextName5.hashCode()) {
                                        case -911706486:
                                            if (nextName5.equals("buildVersion")) {
                                                c4 = 0;
                                                break;
                                            }
                                            c4 = 65535;
                                            break;
                                        case -293026577:
                                            if (nextName5.equals("jailbroken")) {
                                                c4 = 1;
                                                break;
                                            }
                                            c4 = 65535;
                                            break;
                                        case 351608024:
                                            if (nextName5.equals("version")) {
                                                c4 = 2;
                                                break;
                                            }
                                            c4 = 65535;
                                            break;
                                        case 1874684019:
                                            if (nextName5.equals(Shared.PARAM_PLATFORM)) {
                                                c4 = 3;
                                                break;
                                            }
                                            c4 = 65535;
                                            break;
                                        default:
                                            c4 = 65535;
                                            break;
                                    }
                                    if (c4 == 0) {
                                        builder5.setBuildVersion(jsonReader.nextString());
                                    } else if (c4 == 1) {
                                        builder5.setJailbroken(jsonReader.nextBoolean());
                                    } else if (c4 == 2) {
                                        builder5.setVersion(jsonReader.nextString());
                                    } else if (c4 != 3) {
                                        jsonReader.skipValue();
                                    } else {
                                        builder5.setPlatform(jsonReader.nextInt());
                                    }
                                }
                                jsonReader.endObject();
                                builder3.setOs(builder5.build());
                                break;
                            case 6:
                                CrashlyticsReport.Session.Application.Builder builder6 = CrashlyticsReport.Session.Application.builder();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName6 = jsonReader.nextName();
                                    nextName6.hashCode();
                                    switch (nextName6.hashCode()) {
                                        case -1618432855:
                                            if (nextName6.equals("identifier")) {
                                                c5 = 0;
                                                break;
                                            }
                                            c5 = 65535;
                                            break;
                                        case 351608024:
                                            if (nextName6.equals("version")) {
                                                c5 = 1;
                                                break;
                                            }
                                            c5 = 65535;
                                            break;
                                        case 719853845:
                                            if (nextName6.equals("installationUuid")) {
                                                c5 = 2;
                                                break;
                                            }
                                            c5 = 65535;
                                            break;
                                        case 1975623094:
                                            if (nextName6.equals("displayVersion")) {
                                                c5 = 3;
                                                break;
                                            }
                                            c5 = 65535;
                                            break;
                                        default:
                                            c5 = 65535;
                                            break;
                                    }
                                    if (c5 == 0) {
                                        builder6.setIdentifier(jsonReader.nextString());
                                    } else if (c5 == 1) {
                                        builder6.setVersion(jsonReader.nextString());
                                    } else if (c5 == 2) {
                                        builder6.setInstallationUuid(jsonReader.nextString());
                                    } else if (c5 != 3) {
                                        jsonReader.skipValue();
                                    } else {
                                        builder6.setDisplayVersion(jsonReader.nextString());
                                    }
                                }
                                jsonReader.endObject();
                                builder3.setApp(builder6.build());
                                break;
                            case 7:
                                CrashlyticsReport.Session.User.Builder builder7 = CrashlyticsReport.Session.User.builder();
                                jsonReader.beginObject();
                                while (jsonReader.hasNext()) {
                                    String nextName7 = jsonReader.nextName();
                                    nextName7.hashCode();
                                    if (!nextName7.equals("identifier")) {
                                        jsonReader.skipValue();
                                    } else {
                                        builder7.setIdentifier(jsonReader.nextString());
                                    }
                                }
                                jsonReader.endObject();
                                builder3.setUser(builder7.build());
                                break;
                            case '\b':
                                builder3.setGenerator(jsonReader.nextString());
                                break;
                            case '\t':
                                builder3.setCrashed(jsonReader.nextBoolean());
                                break;
                            case '\n':
                                builder3.setGeneratorType(jsonReader.nextInt());
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    builder.setSession(builder3.build());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    @NonNull
    public CrashlyticsReport.Session.Event eventFromJson(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport.Session.Event b = b(jsonReader);
                jsonReader.close();
                return b;
            } catch (Throwable unused) {
            }
            throw th;
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @NonNull
    public String eventToJson(@NonNull CrashlyticsReport.Session.Event event) {
        return a.encode(event);
    }

    @NonNull
    public CrashlyticsReport reportFromJson(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport e = e(jsonReader);
                jsonReader.close();
                return e;
            } catch (Throwable unused) {
            }
            throw th;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        }
    }

    @NonNull
    public String reportToJson(@NonNull CrashlyticsReport crashlyticsReport) {
        return a.encode(crashlyticsReport);
    }
}
