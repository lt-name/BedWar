package org.sobadfish.bedwar.item.nbt;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockSlime;
import cn.nukkit.item.Item;
import cn.nukkit.level.Position;
import org.sobadfish.bedwar.BedWarMain;
import org.sobadfish.bedwar.player.PlayerInfo;
import org.sobadfish.bedwar.tools.Utils;

import java.util.LinkedHashMap;


/**
 * 生成一个平台
 * @author SoBadFish
 * 2022/1/5
 */
public class Platform implements INbtItem {


    @Override
    public String getName() {
        return "简易平台";
    }

    @Override
    public boolean onClick(Item item, Player player) {
        PlayerInfo info = BedWarMain.getRoomManager().getPlayerInfo(player);

        Position pos = info.getPlayer().add(0,-10);
        LinkedHashMap<Position,Block> spawn = BedWarMain.spawnBlockByPosAndSize(pos,3,new BlockSlime());
        Utils.spawnBlock( player, spawn,true);
        info.sendMessage("&a已生成平台");
        player.getInventory().removeItem(item);
        return true;
    }




}
