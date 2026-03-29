package icu.suc.kkw557.perspectivenametag.fabric;

import icu.suc.kkw557.perspectivenametag.common.Common;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public final class Client implements ClientModInitializer {
    public static final String BLACKLIST_FILE_NAME = "perspectivenametag.server-blacklist.txt";

    @Override
    public void onInitializeClient() {
        Common.loadBlacklist(FabricLoader.getInstance().getConfigDir().resolve(BLACKLIST_FILE_NAME));
    }
}
