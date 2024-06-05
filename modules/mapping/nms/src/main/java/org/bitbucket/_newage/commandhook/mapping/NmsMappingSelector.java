package org.bitbucket._newage.commandhook.mapping;

import org.bitbucket._newage.commandhook.legacy.mapping.LegacyMapping;
import org.bitbucket._newage.commandhook.mapping.api.IMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mapping provider static class
 */
public class NmsMappingSelector {

    private static final Logger logger = LoggerFactory.getLogger(NmsMappingSelector.class);

    private NmsMappingSelector() {

    }

    /**
     * Obtain mapping from given NMS version
     *
     * @param nmsVersion e.g. v1_16_R3
     * @return implementation of {@link IMapping}
     * @deprecated Paper will provide only jars without relocation -> no more relocation shenanigans.
     *             Use Minecraft version instead
     */
    @Deprecated
    public static IMapping fromNmsVersion(String nmsVersion) {
        IMapping mapping;
        switch (nmsVersion) {
            case "v1_20_R4":
                mapping = new NmsV1_20_R4();
                break;

            default:
                logger.warn("Mapping for {} not found! Either the plugin is outdated or has not been updated yet!", nmsVersion);
                logger.info("Falling back to legacy mode");
                mapping = new LegacyMapping(nmsVersion);
        }

        return mapping;
    }

    public static IMapping fromMinecraftVersion(String minecraftVersion) {
        IMapping mapping;
        switch (minecraftVersion) {
        case "1.20.6":
            mapping = new NmsV1_20_R4();
            break;

        default:
            logger.warn("Mapping for {} not found! Either the plugin is outdated or has not been updated yet!", minecraftVersion);
            logger.info("Falling back to legacy mode");
            mapping = new LegacyMapping(minecraftVersion);
        }

        return mapping;
    }
}
