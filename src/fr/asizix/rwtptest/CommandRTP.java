package fr.asizix.rwtptest;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class CommandRTP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("randomtp.use")) {
                int max = 2500;
                int min = 1000;

                int x = new Random().nextInt(max - min) + min;
                int z = new Random().nextInt(max - min) + min;

                Location loc = new Location(p.getWorld(), x, 0, z);

                int y = loc.getWorld().getHighestBlockYAt(loc);

                loc.setY(y);

                p.teleport(loc);

                p.sendMessage("§ Téléportation Réussis");
            } else {
                p.sendMessage("vous n'avez la les perms pour cette commands");
            }
        } else {
            if (args.length == 1) {
                Player p = Bukkit.getPlayer(args[0]);
                if (p != null && p.isOnline()) {
                    int max = 2500;
                    int min = 1000;

                    int x = new Random().nextInt(max - min) + min;
                    int z = new Random().nextInt(max - min) + min;

                    Location loc = new Location(p.getWorld(), x, 0, z);

                    int y = loc.getWorld().getHighestBlockYAt(loc);

                    loc.setY(y);

                    p.teleport(loc);

                    p.sendMessage("§ Téléportation Réussis");
                } else {
                    assert p != null;
                    p.sendMessage("vous n'avez la les perms pour cette commands");

                }

            }
            return false;
        }
        return false;
    }
}