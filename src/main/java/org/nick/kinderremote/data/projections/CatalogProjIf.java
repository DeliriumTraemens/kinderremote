package org.nick.kinderremote.data.projections;

import java.util.Set;

public interface CatalogProjIf {
    Long getId();
    String getName();

    Set<CatalogProjIf> getChildren();
}
