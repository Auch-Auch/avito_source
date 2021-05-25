package com.google.firebase.crashlytics.internal.persistence;

import a2.b.a.a.a;
import a2.j.e.d.d.e.c;
import a2.j.e.d.d.e.d;
import a2.j.e.d.d.e.e;
import a2.j.e.d.d.e.f;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
public class CrashlyticsReportPersistence {
    public static final Charset g = Charset.forName("UTF-8");
    public static final int h = 15;
    public static final CrashlyticsReportJsonTransform i = new CrashlyticsReportJsonTransform();
    public static final Comparator<? super File> j = e.a;
    public static final FilenameFilter k = f.a;
    @NonNull
    public final AtomicInteger a = new AtomicInteger(0);
    @NonNull
    public final File b;
    @NonNull
    public final File c;
    @NonNull
    public final File d;
    @NonNull
    public final File e;
    @NonNull
    public final SettingsDataProvider f;

    public CrashlyticsReportPersistence(@NonNull File file, @NonNull SettingsDataProvider settingsDataProvider) {
        File file2 = new File(file, "report-persistence");
        this.b = new File(file2, "sessions");
        this.c = new File(file2, "priority-reports");
        this.d = new File(file2, "reports");
        this.e = new File(file2, "native-reports");
        this.f = settingsDataProvider;
    }

    @NonNull
    public static List<File> a(@NonNull List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (List<File> list : listArr) {
            i2 += list.size();
        }
        arrayList.ensureCapacity(i2);
        for (List<File> list2 : listArr) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    @NonNull
    public static List<File> b(@NonNull File file) {
        return d(file, null);
    }

    @NonNull
    public static List<File> d(@NonNull File file, @Nullable FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    @NonNull
    public static List<File> e(@NonNull File file, @Nullable FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    @NonNull
    public static File g(@NonNull File file) throws IOException {
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new IOException(a.Y2("Could not create directory ", file));
    }

    @NonNull
    public static String h(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), g);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        throw th;
    }

    public static void i(@Nullable File file) {
        if (file != null) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    i(file2);
                }
            }
            file.delete();
        }
    }

    public static void j(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), g);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable unused) {
        }
        throw th;
    }

    @NonNull
    public final List<File> c() {
        List[] listArr = {a(b(this.c), b(this.e)), b(this.d)};
        for (int i2 = 0; i2 < 2; i2++) {
            Collections.sort(listArr[i2], j);
        }
        return a(listArr);
    }

    public void deleteAllReports() {
        Iterator it = ((ArrayList) c()).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public void deleteFinalizedReport(String str) {
        a2.j.e.d.d.e.a aVar = new FilenameFilter(str) { // from class: a2.j.e.d.d.e.a
            public final String a;

            {
                this.a = r1;
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str2) {
                String str3 = this.a;
                Charset charset = CrashlyticsReportPersistence.g;
                return str2.startsWith(str3);
            }
        };
        Iterator it = ((ArrayList) a(e(this.c, aVar), e(this.e, aVar), e(this.d, aVar))).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    @NonNull
    public final File f(@NonNull String str) {
        return new File(this.b, str);
    }

    public void finalizeReports(@Nullable String str, long j2) {
        boolean z;
        List<File> d2 = d(this.b, new FileFilter(str) { // from class: a2.j.e.d.d.e.b
            public final String a;

            {
                this.a = r1;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                String str2 = this.a;
                Charset charset = CrashlyticsReportPersistence.g;
                return file.isDirectory() && !file.getName().equals(str2);
            }
        });
        Collections.sort(d2, j);
        if (d2.size() > 8) {
            for (File file : d2.subList(8, d2.size())) {
                i(file);
            }
            d2 = d2.subList(0, 8);
        }
        for (File file2 : d2) {
            List<File> e2 = e(file2, k);
            if (!e2.isEmpty()) {
                Collections.sort(e2);
                ArrayList arrayList = new ArrayList();
                Iterator<File> it = e2.iterator();
                while (true) {
                    z = false;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        File next = it.next();
                        try {
                            arrayList.add(i.eventFromJson(h(next)));
                            if (!z) {
                                String name = next.getName();
                                if (!(name.startsWith("event") && name.endsWith("_"))) {
                                }
                            }
                            z = true;
                        } catch (IOException e3) {
                            Logger logger = Logger.getLogger();
                            logger.d("Could not add event to report for " + next, e3);
                        }
                    }
                }
                String str2 = null;
                File file3 = new File(file2, "user");
                if (file3.isFile()) {
                    try {
                        str2 = h(file3);
                    } catch (IOException e4) {
                        Logger logger2 = Logger.getLogger();
                        StringBuilder L = a.L("Could not read user ID file in ");
                        L.append(file2.getName());
                        logger2.d(L.toString(), e4);
                    }
                }
                File file4 = new File(file2, "report");
                File file5 = z ? this.c : this.d;
                try {
                    CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = i;
                    CrashlyticsReport withEvents = crashlyticsReportJsonTransform.reportFromJson(h(file4)).withSessionEndFields(j2, z, str2).withEvents(ImmutableList.from(arrayList));
                    CrashlyticsReport.Session session = withEvents.getSession();
                    if (session != null) {
                        g(file5);
                        j(new File(file5, session.getIdentifier()), crashlyticsReportJsonTransform.reportToJson(withEvents));
                    }
                } catch (IOException e5) {
                    Logger logger3 = Logger.getLogger();
                    logger3.d("Could not synthesize final report file for " + file4, e5);
                }
            }
            i(file2);
        }
        int i2 = this.f.getSettings().getSessionData().maxCompleteSessionsCount;
        ArrayList arrayList2 = (ArrayList) c();
        int size = arrayList2.size();
        if (size > i2) {
            for (File file6 : arrayList2.subList(i2, size)) {
                file6.delete();
            }
        }
    }

    public void finalizeSessionWithNativeEvent(@NonNull String str, @NonNull CrashlyticsReport.FilesPayload filesPayload) {
        File file = new File(f(str), "report");
        File file2 = this.e;
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = i;
            CrashlyticsReport withNdkPayload = crashlyticsReportJsonTransform.reportFromJson(h(file)).withNdkPayload(filesPayload);
            g(file2);
            j(new File(file2, str), crashlyticsReportJsonTransform.reportToJson(withNdkPayload));
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            logger.d("Could not synthesize final native report file for " + file, e2);
        }
    }

    @NonNull
    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        List<File> c2 = c();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(((ArrayList) c2).size());
        Iterator it = ((ArrayList) c()).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            try {
                arrayList.add(CrashlyticsReportWithSessionId.create(i.reportFromJson(h(file)), file.getName()));
            } catch (IOException e2) {
                Logger logger = Logger.getLogger();
                logger.d("Could not load report file " + file + "; deleting", e2);
                file.delete();
            }
        }
        return arrayList;
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str) {
        persistEvent(event, str, false);
    }

    public void persistReport(@NonNull CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session session = crashlyticsReport.getSession();
        if (session == null) {
            Logger.getLogger().d("Could not get session for report");
            return;
        }
        String identifier = session.getIdentifier();
        try {
            File f2 = f(identifier);
            g(f2);
            j(new File(f2, "report"), i.reportToJson(crashlyticsReport));
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            logger.d("Could not persist report for session " + identifier, e2);
        }
    }

    public void persistUserIdForSession(@NonNull String str, @NonNull String str2) {
        try {
            j(new File(f(str2), "user"), str);
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            logger.d("Could not persist user ID for session " + str2, e2);
        }
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str, boolean z) {
        int i2 = this.f.getSettings().getSessionData().maxCustomExceptionEvents;
        File f2 = f(str);
        try {
            j(new File(f2, a.e3("event", String.format(Locale.US, "%010d", Integer.valueOf(this.a.getAndIncrement())), z ? "_" : "")), i.eventToJson(event));
        } catch (IOException e2) {
            Logger.getLogger().d("Could not persist event for session " + str, e2);
        }
        List<File> e3 = e(f2, c.a);
        Collections.sort(e3, d.a);
        int size = e3.size();
        for (File file : e3) {
            if (size > i2) {
                i(file);
                size--;
            } else {
                return;
            }
        }
    }
}
