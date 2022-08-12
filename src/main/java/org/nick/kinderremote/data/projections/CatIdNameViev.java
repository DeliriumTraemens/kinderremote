package org.nick.kinderremote.data.projections;

import java.util.Set;

public interface CatIdNameViev {
    Long getId();
    String getName();

    Set<CatIdNameViev>getChildren();
}
