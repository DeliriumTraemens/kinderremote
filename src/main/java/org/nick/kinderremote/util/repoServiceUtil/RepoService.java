package org.nick.kinderremote.util.repoServiceUtil;

import org.nick.kinderremote.data.dto.HtRequest;

public interface RepoService {
    String getAll(HtRequest request) ;
    String getById(HtRequest request);
    String editHierarchy(HtRequest request);
    String editById(HtRequest request);
    String delete(HtRequest request);
    String createNew(HtRequest request);

}
