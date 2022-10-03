package org.nick.kinderremote.util.repoServiceUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.nick.kinderremote.data.dto.HtRequest;

public interface RepoService {
    String getAll(HtRequest request) ;
    String getById(HtRequest request) throws JsonProcessingException;
    String editHierarchy(HtRequest request);
    String editById(HtRequest request);
    String delete(HtRequest request);
    String createNew(HtRequest request);

}
