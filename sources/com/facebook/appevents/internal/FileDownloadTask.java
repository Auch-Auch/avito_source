package com.facebook.appevents.internal;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
public class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
    public Callback a;
    public File b;
    public String c;

    public interface Callback {
        void onComplete(File file);
    }

    public FileDownloadTask(String str, File file, Callback callback) {
        this.c = str;
        this.b = file;
        this.a = callback;
    }

    public Boolean doInBackground(String... strArr) {
        try {
            URL url = new URL(this.c);
            int contentLength = url.openConnection().getContentLength();
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            byte[] bArr = new byte[contentLength];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.b));
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            this.a.onComplete(this.b);
        }
    }
}
