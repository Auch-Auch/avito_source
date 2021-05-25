package org.junit.rules;

import a2.b.a.a.a;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
public class TemporaryFolder extends ExternalResource {
    public final File a;
    public final boolean b;
    public File c;

    public static class Builder {
        public File a;
        public boolean b;

        public Builder assureDeletion() {
            this.b = true;
            return this;
        }

        public TemporaryFolder build() {
            return new TemporaryFolder(this);
        }

        public Builder parentFolder(File file) {
            this.a = file;
            return this;
        }
    }

    public TemporaryFolder() {
        this((File) null);
    }

    public static Builder builder() {
        return new Builder();
    }

    public final File a(File file) throws IOException {
        File file2 = null;
        int i = 0;
        while (i < 10000) {
            File createTempFile = File.createTempFile("junit", DefaultDiskStorage.FileType.TEMP, file);
            File file3 = new File(a.O2(createTempFile.toString(), -4, 0));
            if (file3.mkdir()) {
                createTempFile.delete();
                return file3;
            }
            createTempFile.delete();
            i++;
            file2 = file3;
        }
        StringBuilder L = a.L("Unable to create temporary directory in: ");
        L.append(file.toString());
        L.append(". Tried ");
        L.append(10000);
        L.append(" times. ");
        L.append("Last attempted to create: ");
        L.append(file2.toString());
        throw new IOException(L.toString());
    }

    @Override // org.junit.rules.ExternalResource
    public void after() {
        delete();
    }

    public final boolean b(File file) {
        if (file.delete()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!b(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    @Override // org.junit.rules.ExternalResource
    public void before() throws Throwable {
        create();
    }

    public void create() throws IOException {
        this.c = a(this.a);
    }

    public void delete() {
        boolean z;
        File file = this.c;
        if (file == null) {
            z = true;
        } else {
            z = b(file);
        }
        if (!z && this.b) {
            StringBuilder L = a.L("Unable to clean up temporary folder ");
            L.append(this.c);
            Assert.fail(L.toString());
        }
    }

    public File getRoot() {
        File file = this.c;
        if (file != null) {
            return file;
        }
        throw new IllegalStateException("the temporary folder has not yet been created");
    }

    public File newFile(String str) throws IOException {
        File file = new File(getRoot(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new IOException(a.e3("a file with the name '", str, "' already exists in the test folder"));
    }

    public File newFolder(String str) throws IOException {
        return newFolder(str);
    }

    public TemporaryFolder(File file) {
        this.a = file;
        this.b = false;
    }

    public File newFolder(String... strArr) throws IOException {
        if (strArr.length != 0) {
            File root = getRoot();
            int i = 0;
            for (String str : strArr) {
                if (new File(str).isAbsolute()) {
                    throw new IOException(a.e3("folder path '", str, "' is not a relative path"));
                }
            }
            File file = null;
            int length = strArr.length;
            boolean z = true;
            File file2 = root;
            while (i < length) {
                File file3 = new File(file, strArr[i]);
                File file4 = new File(root, file3.getPath());
                z = file4.mkdirs();
                if (z || file4.isDirectory()) {
                    i++;
                    file2 = file4;
                    file = file3;
                } else if (file4.exists()) {
                    StringBuilder L = a.L("a file with the path '");
                    L.append(file3.getPath());
                    L.append("' exists");
                    throw new IOException(L.toString());
                } else {
                    StringBuilder L2 = a.L("could not create a folder with the path '");
                    L2.append(file3.getPath());
                    L2.append("'");
                    throw new IOException(L2.toString());
                }
            }
            if (z) {
                return file2;
            }
            StringBuilder L3 = a.L("a folder with the path '");
            L3.append(file.getPath());
            L3.append("' already exists");
            throw new IOException(L3.toString());
        }
        throw new IllegalArgumentException("must pass at least one path");
    }

    public File newFile() throws IOException {
        return File.createTempFile("junit", null, getRoot());
    }

    public TemporaryFolder(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
    }

    public File newFolder() throws IOException {
        return a(getRoot());
    }
}
