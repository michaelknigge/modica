package org.afpparser.afp.modca.triplets.fullyqualifiedname;

/**
 * Specified the GID format.
 */
public enum FQNFmt {
    character_string(0x00),
    oid(0x10),
    url(0x20);

    private final byte id;

    private FQNFmt(int id) {
        this.id = (byte) id;
    }

    /**
     * Return the identity byte of this FQN format.
     *
     * @return the byte identifying the FQN format
     */
    byte getId() {
        return id;
    }
}