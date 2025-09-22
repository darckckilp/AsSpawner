package astralcraft.astralcraftspawner;

import astralcraft.astralcraftspawner.command.reloadcommand;
import astralcraft.astralcraftspawner.event.spawner;
import astralcraft.astralcraftspawner.configs.mainConfig;
import astralcraft.astralcraftspawner.configs.messageConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

    public class Astralcraftspawner extends JavaPlugin {
        private static astralcraft.astralcraftspawner.Astralcraftspawner instans;

        public File mainConfigFile = new File(getDataFolder() + "/config.yml");
        public File messageConfigFile = new File(getDataFolder() + "/message.yml");
        public mainConfig MainConfig = new mainConfig();
        public messageConfig MessageConfig = new messageConfig();

        @Override
        public void onEnable() {
            instans = this;

            new reloadcommand();
            MainConfig.reloadConfig();
            MessageConfig.reloadConfig();
            Bukkit.getPluginManager().registerEvents(new spawner(), this);
        }

        public static astralcraft.astralcraftspawner.Astralcraftspawner getInstance() {
            return instans;
        }
}