package icu.suc.kkw557.perspectivenametag.forge;

import icu.suc.kkw557.perspectivenametag.common.Common;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Common.ID)
public final class Client {
    public static final String BLACKLIST_FILE_NAME = "perspectivenametag.server-blacklist.txt";

    public Client() {
        Common.loadBlacklist(FMLPaths.CONFIGDIR.get().resolve(BLACKLIST_FILE_NAME));
    }
}
