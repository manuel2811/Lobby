package main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class teleporter1 implements Listener {

    private lobby instance = lobby.getInstance();

    private ItemStack survivalGames = rename(new ItemStack(Material.WOOD_SWORD), "Survival Games");

    public teleporter1() {
        instance.getServer().getPluginManager().registerEvents(this, instance);
    }



    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getMaterial().equals(Material.NETHER_STAR)) {
                Inventory inv = instance.getServer().createInventory(null, 27, "Teleportation");
                inv.addItem(survivalGames);
                p.openInventory(inv);

            }
        }
    }
    @EventHandler
    public void onPlayerInventoryKlick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getName().equalsIgnoreCase("Teleportation")) {
            if (item != null) {
                if (item.equals(survivalGames)) {
                    Location loc = new Location(instance.getServer().getWorld(player.getWorld().getName()), 1, 1, 1);
                    player.teleport(loc);
                }
            }
        }
    }

    private ItemStack rename(ItemStack im, String name) {
        ItemMeta meta = im.getItemMeta();
        meta.setDisplayName(name);
        im.setItemMeta(meta);
        return im;
    }


}
