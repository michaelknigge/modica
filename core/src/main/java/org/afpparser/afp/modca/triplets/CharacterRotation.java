package org.afpparser.afp.modca.triplets;

import org.afpparser.afp.modca.common.Rotation;


/**
 * The Character Rotation triplet is used to specify character rotation relative to the character
 * coordinate system. See the Font Object Content Architecture Reference for further information.
 */
public class CharacterRotation extends Triplet {

    private final static int LENGTH = 4;

    private final Rotation rotation;

    public CharacterRotation(byte[] data, int position) {
        this.rotation = Rotation.getValue(data[position]);
    }

    @Override
    public int getLength() {
        return LENGTH;
    }

    @Override
    public TripletIdentifiers getTid() {
        return TripletIdentifiers.character_rotation;
    }

    /**
     * Returns an enumerated type for the character rotation.
     *
     * @return the character rotation
     */
    public Rotation getRotation() {
        return rotation;
    }

    @Override
    public String toString() {
        return "character rotation=" + rotation + " degrees";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CharacterRotation)) {
            return false;
        }
        CharacterRotation charRot = (CharacterRotation) o;
        return this.rotation == charRot.rotation;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + rotation.hashCode();
        hashCode = 31 * hashCode + getTid().hashCode();
        return hashCode;
    }

}
