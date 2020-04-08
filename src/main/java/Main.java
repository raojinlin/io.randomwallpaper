import io.randomwallpaper.model.WrapperModel;
import io.randomwallpaper.provider.GnomeBuildInWrapperProviderFactory;
import io.randomwallpaper.provider.UnSplashWrapperProviderFactory;
import io.randomwallpaper.provider.WrapperProviderFactory;


public class Main {
    public static void main(String[] args) {
        WrapperProviderFactory factory = new GnomeBuildInWrapperProviderFactory();

        if (args.length >= 1) {
            if (args[0].equals("unsplash")) {
                factory = new UnSplashWrapperProviderFactory();
            } else if (!args[0].equals("gnome")) {
                System.err.println("Unknown provider: '"+ args[0] +"', using default provider 'gnome'.");
            }
        } else {
            System.err.println("Supported Providers: 'gnome', 'unslpash'");
            System.exit(1);
        }

        WrapperModel model = factory.instance().getWrapper();
        System.out.println(model.getUrl());
    }
}
