package io.randomwallpaper.provider;

import io.randomwallpaper.model.WallpaperModel;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LocalWallpaperProvider implements Provider {
    private String[] localWrapperDirs = new String[]{
            "/usr/share/backgrounds",
            System.getenv("HOME") + "/.local/share/backgrounds"
    };

    private Random random = new Random();

    public LocalWallpaperProvider() {}

    public LocalWallpaperProvider(String[] dirs) {
        setLocalWrapperDirs(dirs);
    }

    public void setLocalWrapperDirs(String[] dirs) {
        localWrapperDirs = dirs;
    }

    public WallpaperModel getWallpaper() {
        WallpaperModel wallpaperModel = new WallpaperModel();
        int count = 0;
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        List<File> fileList = new ArrayList<File>();
        for (String dir: localWrapperDirs) {
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
            return wallpaperModel;
        }

        int next = random.nextInt(10);
        if (count > 0) {
            next = random.nextInt(count);
        }


        wallpaperModel.setUrl("file://" + fileList.get(next).getAbsolutePath());
        return wallpaperModel;
    }
}
