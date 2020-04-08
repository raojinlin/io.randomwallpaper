package io.randomwallpaper.provider;

import io.randomwallpaper.model.WrapperModel;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GnomeBuildInWrapperProvider implements Provider {
    private String[] buildInWrapperDirs = new String[]{
            "/usr/share/backgrounds",
            System.getenv("HOME") + "/.local/share/backgrounds"
    };
    private Random random = new Random();

    public WrapperModel getWrapper() {
        WrapperModel wrapperModel = new WrapperModel();
        int count = 0;
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        List<File> fileList = new ArrayList<File>();
        for (String dir: buildInWrapperDirs) {
            File file = new File(dir);
            if (file.isDirectory()) {

                File[] files = file.listFiles(fileFilter);

                if (files != null) {
                    count += files.length;
                    fileList.addAll(Arrays.asList(files));
                }
            }
        }

        if (count == 0) {
            return wrapperModel;
        }

        int next = random.nextInt(10);
        if (count > 0) {
            next = random.nextInt(count);
        }


        wrapperModel.setUrl("file://" + fileList.get(next).getAbsolutePath());
        return wrapperModel;
    }
}
