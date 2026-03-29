package icu.suc.kkw557.perspectivenametag.common;

import icu.suc.kkw557.perspectivenametag.PerspectiveNametag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Common {
    public static final String ID = "perspectivenametag";
    public static final Logger LOGGER = LogManager.getLogger(ID);

    public static void loadBlacklist(Path path) {
        try {
            PerspectiveNametag.BLACKLIST.clear();
            if (Files.exists(path)) {
                try (var lines = Files.lines(path, StandardCharsets.UTF_8)) {
                    lines.map(String::trim).filter(line -> !line.isEmpty()).forEach(PerspectiveNametag.BLACKLIST::add);
                }
            } else {
                Files.createFile(path);
            }
            LOGGER.info("Loaded {} server blacklist entries", PerspectiveNametag.BLACKLIST.size());
        } catch (IOException e) {
            LOGGER.warn("Failed to load server blacklist", e);
        }
    }
}
