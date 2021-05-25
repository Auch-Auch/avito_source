package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
public final class NativeAppCallAttachmentStore {
    public static File a;

    public static final class Attachment {
        public final UUID a;
        public final String b;
        public final String c;
        public Bitmap d;
        public Uri e;
        public boolean f;
        public boolean g;

        public Attachment(UUID uuid, Bitmap bitmap, Uri uri, a aVar) {
            String str;
            this.a = uuid;
            this.d = bitmap;
            this.e = uri;
            boolean z = true;
            if (uri != null) {
                String scheme = uri.getScheme();
                if ("content".equalsIgnoreCase(scheme)) {
                    this.f = true;
                    this.g = (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) ? false : z;
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    this.g = true;
                } else if (!Utility.isWebUri(uri)) {
                    throw new FacebookException(a2.b.a.a.a.c3("Unsupported scheme for media Uri : ", scheme));
                }
            } else if (bitmap != null) {
                this.g = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            String uuid2 = !this.g ? null : UUID.randomUUID().toString();
            this.c = uuid2;
            if (!this.g) {
                str = this.e.toString();
            } else {
                str = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), uuid, uuid2);
            }
            this.b = str;
        }

        public String getAttachmentUrl() {
            return this.b;
        }

        public Uri getOriginalUri() {
            return this.e;
        }
    }

    public static File a(UUID uuid, String str, boolean z) throws IOException {
        File c = c(uuid, z);
        if (c == null) {
            return null;
        }
        try {
            return new File(c, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static void addAttachments(Collection<Attachment> collection) {
        InputStream inputStream;
        if (collection != null && collection.size() != 0) {
            if (a == null) {
                cleanupAllAttachments();
            }
            b().mkdirs();
            ArrayList arrayList = new ArrayList();
            try {
                for (Attachment attachment : collection) {
                    if (attachment.g) {
                        File a3 = a(attachment.a, attachment.c, true);
                        arrayList.add(a3);
                        Bitmap bitmap = attachment.d;
                        if (bitmap != null) {
                            FileOutputStream fileOutputStream = new FileOutputStream(a3);
                            try {
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                            } finally {
                                Utility.closeQuietly(fileOutputStream);
                            }
                        } else {
                            Uri uri = attachment.e;
                            if (uri != null) {
                                boolean z = attachment.f;
                                FileOutputStream fileOutputStream2 = new FileOutputStream(a3);
                                if (!z) {
                                    try {
                                        inputStream = new FileInputStream(uri.getPath());
                                    } catch (Throwable th) {
                                        Utility.closeQuietly(fileOutputStream2);
                                        throw th;
                                    }
                                } else {
                                    inputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
                                }
                                Utility.copyAndCloseInputStream(inputStream, fileOutputStream2);
                                Utility.closeQuietly(fileOutputStream2);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                String str = "Got unexpected exception:" + e;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((File) it.next()).delete();
                    } catch (Exception unused) {
                    }
                }
                throw new FacebookException(e);
            }
        }
    }

    public static synchronized File b() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            if (a == null) {
                a = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            file = a;
        }
        return file;
    }

    public static File c(UUID uuid, boolean z) {
        if (a == null) {
            return null;
        }
        File file = new File(a, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void cleanupAllAttachments() {
        Utility.deleteDirectory(b());
    }

    public static void cleanupAttachmentsForCall(UUID uuid) {
        File c = c(uuid, false);
        if (c != null) {
            Utility.deleteDirectory(c);
        }
    }

    public static Attachment createAttachment(UUID uuid, Bitmap bitmap) {
        Validate.notNull(uuid, "callId");
        Validate.notNull(bitmap, "attachmentBitmap");
        return new Attachment(uuid, bitmap, null, null);
    }

    public static File openAttachment(UUID uuid, String str) throws FileNotFoundException {
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return a(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    public static Attachment createAttachment(UUID uuid, Uri uri) {
        Validate.notNull(uuid, "callId");
        Validate.notNull(uri, "attachmentUri");
        return new Attachment(uuid, null, uri, null);
    }
}
