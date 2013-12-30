package com.Min3CraftDud3.PhoenixPowder;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PhoenixPowder extends JavaPlugin implements Listener{
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onGPUse(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
		if(p.getHealth() <= 6.0){
		if(p.getItemInHand().getType() == Material.SULPHUR){
		p.setHealth(p.getMaxHealth());
		p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
		p.sendMessage("You used PhoenixPowder.");
		}
		}
	}
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player p = (Player)e.getEntity();
		if(p.getKiller() instanceof Player){
		Player killer = e.getEntity().getKiller();
			if(e.getDeathMessage().contains("burned")){
				killer.getInventory().addItem(new ItemStack(Material.SULPHUR,1));
			}
		}
	}	
}
