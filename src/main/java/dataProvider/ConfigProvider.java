package dataProvider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigProvider {
    Config config = readConfig();

    public static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.load("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    public static String URL = readConfig().getString("main.url");
    public static String URL_SAUCE = readConfig().getString("main.url_sauce");
    public static String USERNAME = readConfig().getString("auth.username");
    public static String PASSWORD = readConfig().getString("auth.password");
}
