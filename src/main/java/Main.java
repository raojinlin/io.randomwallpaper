import io.randomwallpaper.model.WallpaperModel;
import io.randomwallpaper.provider.GnomeBuildInWallpaperProviderFactory;
import io.randomwallpaper.provider.UnSplashWallpaperProviderFactory;
import io.randomwallpaper.provider.WallpaperProviderFactory;


public class Main {
    public static void main(String[] args) {
        WallpaperProviderFactory factory = new GnomeBuildInWallpaperProviderFactory();

        if (args.length >= 1) {
            if (args[0].equals("unsplash")) {
                factory = new UnSplashWallpaperProviderFactory();
            } else if (!args[0].equals("gnome")) {
                System.err.println("Unknown provider: '"+ args[0] +"', using default provider 'gnome'.");
            }
        } else {
            System.err.println("Supported Providers: 'gnome', 'unslpash'");
            System.exit(1);
        }

        WallpaperModel model = factory.instance().getWrapper();
        System.out.println(model.getUrl());
    }
}
