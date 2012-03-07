package org.modica.afp.modca.structuredfields;

import java.util.ArrayList;
import java.util.List;

import org.modica.afp.modca.ParameterAsString;
import org.modica.afp.modca.triplets.RepeatingTripletGroup;
import org.modica.afp.modca.triplets.Triplet;

/**
 * An abstract class for structured fields with triplet group attachments.
 */
public abstract class StructuredFieldWithTripletGroup extends AbstractStructuredField {

    private final RepeatingTripletGroup tripletGroup;

    public StructuredFieldWithTripletGroup(StructuredFieldIntroducer introducer,
            RepeatingTripletGroup tripletGroup) {
        super(introducer);
        this.tripletGroup = tripletGroup;
    }

    /**
     * Returns true if the triplet group contains any triplets.
     *
     * @return true if the triplet group contains triplets
     */
    public final boolean hasTripletGroup() {
        return tripletGroup != null && tripletGroup.size() > 0;
    }

    /**
     * Returns the triplet group.
     *
     * @return the triplet group
     */
    public final RepeatingTripletGroup getTripletGroup() {
        return tripletGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Triplet> tripletList : getTripletGroup()) {
            for (Triplet t : tripletList) {
                sb.append("\t");
                sb.append(t.toString());
                sb.append("\n");
            }
        }
        return getType().getName() + " triplet group=" + sb.toString();
    }

    /**
     * Returns a list of maps containing all the triplets and their corresponding parameters as
     * values in the form of Strings.
     *
     * @return all the contained triplet information in String form
     */
    public List<List<ParameterAsString>> getRepeatingGroupParameters() {
        List<List<ParameterAsString>> tripletStrings = new ArrayList<List<ParameterAsString>>();
        for (List<Triplet> tripletList : getTripletGroup()) {
            for (Triplet t : tripletList) {
                tripletStrings.add(t.getParameters());
            }
        }
        return tripletStrings;
    }
}