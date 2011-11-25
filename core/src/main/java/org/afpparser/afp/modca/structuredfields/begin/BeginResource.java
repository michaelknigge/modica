package org.afpparser.afp.modca.structuredfields.begin;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.afpparser.afp.modca.structuredfields.SfIntroducer;
import org.afpparser.afp.modca.structuredfields.StructuredFieldWithTriplets;
import org.afpparser.afp.modca.triplets.Triplet;
import org.afpparser.common.StringUtils;

/**
 * The Begin Resource structured field begins an envelope that is used to carry resource objects in
 * print-file-level (external) resource groups. Resource references in the data stream are matched
 * against the resource identifier specified by the Begin Resource structured field.
 * <p>
 * Note: To optimize print performance, it is strongly recommended that the same encoding scheme be
 * used for a resource reference wherever in a print file that resource reference is specified. That
 * is, the encoding scheme used for the resource include, the resource map, and the resource wrapper
 * should be the same. For TrueType/OpenType fonts, optimal performance can be achieved by using
 * UTF-16BE as the encoding scheme.
 * </p>
 */
public class BeginResource extends StructuredFieldWithTriplets {
    
    private final String rsName;

    public BeginResource(SfIntroducer introducer, List<Triplet> triplets, byte[] sfData)
            throws UnsupportedEncodingException {
        super(introducer, triplets);
        rsName = StringUtils.bytesToCp500(sfData, 0, 8);
    }

    /**
     * Is the identifier used to select the resource. This identifier is matched against the
     * resource reference in the data stream.
     *
     * @return the resource name
     */
    public String getRSName() {
        return rsName;
    }

    @Override
    public String toString() {
        return getType().getName() + " rsName=" + rsName + "\n" + tripletsToString();
    }
}