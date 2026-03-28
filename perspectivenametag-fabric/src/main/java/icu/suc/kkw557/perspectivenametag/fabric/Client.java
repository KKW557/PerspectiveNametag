package icu.suc.kkw557.perspectivenametag.fabric;

import icu.suc.kkw557.perspectivenametag.PerspectiveNametag;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public final class Client implements ClientModInitializer {
    public static final String ID = "perspectivenametag";
    public static final String BLACKLIST_FILE_NAME = "perspectivenametag.server-blacklist.txt";
    public static final Logger LOGGER = LogManager.getLogger(ID);

    public static void loadBlacklist() throws IOException {
        Path path = FabricLoader.getInstance().getConfigDir().resolve(BLACKLIST_FILE_NAME);
        PerspectiveNametag.BLACKLIST.clear();
        if (Files.exists(path)) {
            try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
                lines.map(String::trim).filter(line -> !line.isEmpty()).forEach(PerspectiveNametag.BLACKLIST::add);
            }
        } else {
            Files.createFile(path);
        }
        LOGGER.info("Loaded {} server blacklist entries", PerspectiveNametag.BLACKLIST.size());
    }

    @Override
    public void onInitializeClient() {
        try {
            loadBlacklist();
        } catch (IOException e) {
            LOGGER.warn("Failed to load server blacklist", e);
        }
    }
}
