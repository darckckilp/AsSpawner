package astralcraft.astralcraftspawner.command;

import astralcraft.astralcraftspawner.Astralcraftspawner;
import astralcraft.astralcraftspawner.configs.mainConfig;
import astralcraft.astralcraftspawner.configs.messageConfig;
import com.google.common.collect.Lists;
import org.bukkit.command.CommandSender;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class reloadcommand extends AbstractCommand {

    private mainConfig MainConfig = Astralcraftspawner.getInstance().MainConfig;
    private messageConfig MessageConfig = Astralcraftspawner.getInstance().MessageConfig;

    public reloadcommand() {
        super("astralcraft");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(MessageConfig.reload + " /" + label + "reload");
            return;
        }
        if(args[0].equalsIgnoreCase("reload")) {
            if(!sender.hasPermission( "astralspawner.reload")){
                sender.sendMessage(MessageConfig.permission);
                return;
            }

            MainConfig.reloadConfig();
            MessageConfig.reloadConfig();
            sender.sendMessage(MessageConfig.reload_complite);
            getServer().getConsoleSender().sendMessage(MessageConfig.reload_complite);
            return;
        }

        sender.sendMessage(MessageConfig.idkwhatthis + args[0]);


    }
    @Override
    public List<String> complete(CommandSender sender, String[] args){
        if(args.length == 1) return Lists.newArrayList("reload");
        return Lists.newArrayList();
    }
}