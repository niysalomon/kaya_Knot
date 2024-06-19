package kaya_knot.kayaKnot.policy.entity.enums;

import java.util.HashMap;
import java.util.Map;

public enum RestrictionLevelEnums {
    TOLERANT("TOLERANT"),
    NO_TOLERANT("NO_TOLERANT"),
    Low_TOLERANT("Low_TOLERANT"),
    MODERATE_TOLERANT("MODERATE_TOLERANT"),
    HIGH_TOLERANT("HIGH_TOLERANT");

    public final String label;

    private static final Map<String, RestrictionLevelEnums> BY_LABEL = new HashMap<>();

    static {
        for (RestrictionLevelEnums e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    private RestrictionLevelEnums(String label) {
        this.label = label;
    }

    public static RestrictionLevelEnums valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
