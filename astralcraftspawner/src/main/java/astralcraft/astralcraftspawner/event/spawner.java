package astralcraft.astralcraftspawner.event;

import astralcraft.astralcraftspawner.Astralcraftspawner;
import astralcraft.astralcraftspawner.configs.mainConfig;
import astralcraft.astralcraftspawner.configs.messageConfig;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class spawner implements Listener {


    private final mainConfig MainConfig = Astralcraftspawner.getInstance().MainConfig;
    private final messageConfig MessageConfig = Astralcraftspawner.getInstance().MessageConfig;


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();


        if(!player.hasPermission( "astralspawner.eventuse")){
            player.sendMessage(MessageConfig.permission);
            return;
        }

            if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

            if (block != null && block.getType() == Material.SPAWNER) {
                if (isRequiredTool(itemInHand)) {
                    block.setType(Material.AIR);
                    ItemStack spawner = new ItemStack(Material.SPAWNER, 1);
                    player.getInventory().addItem(spawner);
                    decreaseItemInHand(player);
                    playSuccessSound(player);
                }
            }
    }

    private boolean isRequiredTool(ItemStack item) {
        return MainConfig.item != null && item.getType().name().toLowerCase().equals(MainConfig.item);
    }

    private void decreaseItemInHand(Player player) {
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (itemInHand.getAmount() > 1) {
            itemInHand.setAmount(itemInHand.getAmount() - 1);
        } else {
            player.getInventory().setItemInMainHand(null);
        }
    }
    private void playSuccessSound(Player player) {
        if (MainConfig.sound != null) {
            player.playSound(player.getLocation(), MainConfig.sound, 1.0F, 1.0F);
        }
    }
}


