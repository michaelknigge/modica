package org.modica.afp.modca.structuredfields.begin;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.modica.afp.modca.ParameterAsString;
import org.modica.afp.modca.Parameters;
import org.modica.afp.modca.structuredfields.StructuredFieldIntroducer;
import org.modica.afp.modca.structuredfields.StructuredFieldWithTriplets;
import org.modica.afp.modca.triplets.Triplet;

/**
 * The Begin Object Environment Group structured field begins an Object Environment Group, which
 * establishes the environment parameters for the object. The scope of an object environment group
 * is its containing object.
 */
public class BeginObjectEnvironmentGroup extends StructuredFieldWithTriplets {

    private final String oegName;

    public BeginObjectEnvironmentGroup(StructuredFieldIntroducer introducer, List<Triplet> triplets,
            Parameters params) throws UnsupportedEncodingException {
        super(introducer, triplets);
        oegName = params.getString(0, 8);
    }

    /**
     * Returns the name of the object environment group.
     *
     * @return the OEG name
     */
    public String getOegName() {
        return oegName;
    }

    @Override
    public List<ParameterAsString> getParameters() {
        List<ParameterAsString> params = new ArrayList<ParameterAsString>();
        params.add(new ParameterAsString("ObjectEnvironmentGroupName", oegName));
        return params;
    }
}