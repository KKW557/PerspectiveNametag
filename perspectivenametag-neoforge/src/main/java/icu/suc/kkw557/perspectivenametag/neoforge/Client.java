package icu.suc.kkw557.perspectivenametag.neoforge;

import icu.suc.kkw557.perspectivenametag.common.Common;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;

@Mod(Common.ID)
public final class Client {
    public static final String BLACKLIST_FILE_NAME = "perspectivenametag.server-blacklist.txt";

    public Client() {
        Common.loadBlacklist(FMLPaths.CONFIGDIR.get().resolve(BLACKLIST_FILE_NAME));
    }
}
